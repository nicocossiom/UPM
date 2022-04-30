
//package series.mysqlbbddd.src;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SeriesDatabase {

	public SeriesDatabase() {

	}

	private static Connection con = null;
	private Statement st2 = null;

	public boolean openConnection() {
		String DBNAME = "series";
		String url = "jdbc:mysql://localhost:3306/" + DBNAME;
		String driver = "com.mysql.jdbc.Driver";
		String username = "root";
		String passwd = "ottoterco1";
		try {
			con = DriverManager.getConnection(url, username, passwd);
		} catch (SQLException e) {
			displaySQLError(e);
			return false;
		}
		return true;
	}

	public boolean closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Cannot close connection to database!");
			displaySQLError(e);
		} catch (NullPointerException e) {
			System.out.println("Error: Can't disconnect if not connected first");
			return false;
		}
		System.out.println("Disconnected from database!");
		return true;
	}

	public boolean createTableCapitulo() {
		openConnection();
		String sql = "create table capitulo(id_serie int, n_temporada int, n_orden int, fecha_estreno date, titulo varchar(100), duracion int,"
				+ "PRIMARY KEY(id_serie, n_temporada,n_orden),"
				+ "FOREIGN KEY (id_serie, n_temporada) REFERENCES temporada(id_serie,n_temporada) ON DELETE CASCADE ON UPDATE CASCADE);";
		try {
			st2 = con.createStatement();
			st2.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Couldn't create table capitulo!");
			System.out.println("Error message: " + e.getMessage());
			System.out.println("Error code: " + e.getErrorCode());
			System.out.println("SQL state: " + e.getSQLState());
			e.printStackTrace();
			return false;
		}
		System.out.println("Table capitulo created correctly");
		return true;
	}

	public boolean createTableValora() {
		openConnection();
		String sql = "create table valora(id_serie int, n_temporada int, n_orden int, id_usuario int, fecha date, valor int,"
				+ "FOREIGN KEY (id_serie,n_temporada,n_orden) REFERENCES capitulo(id_serie,n_temporada,n_orden) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "PRIMARY KEY(id_serie,n_temporada, n_orden, id_usuario, fecha));";
		try {
			st2 = con.createStatement();
			st2.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Couldn't create table valora!");
			displaySQLError(e);
			return false;
		}
		System.out.println("Table valora created correctly");
		return true;
	}

	public int loadCapitulos(String fileName) {
		openConnection();
		ArrayList<Capitulo> csv = readData(fileName, "capitulo");
		String sql = "Insert into capitulo (id_serie,n_temporada,n_orden,fecha_estreno,titulo,duracion) Values(?,?,?,?,?,?);";
		try {
			con.setAutoCommit(false);
			PreparedStatement st = con.prepareStatement(sql);
			for (Capitulo cap : csv) {
				st.setInt(1, cap.id_serie);
				st.setInt(2, cap.n_temporada);
				st.setInt(3, cap.n_orden);
				st.setDate(4, cap.fecha_estreno);
				st.setString(5, cap.titulo);
				st.setInt(6, cap.duracion);
				st.executeUpdate();
			}
			con.commit();
			con.setAutoCommit(true);
			closeConnection();
		} catch (SQLException e) {
			try {
				con.rollback();
				con.setAutoCommit(true);
				if (st2 != null) {
					closeConnection();
				}
			} catch (SQLException e1) {
			}
			displaySQLError(e);
			return -1;
		}
		return csv.size();
	}

	public int loadValoraciones(String fileName) {
		openConnection();
		ArrayList<Valoracion> csv = readData(fileName, "Valoracion");
		String sql = "Insert into valora (id_serie,n_temporada,n_orden,id_usuario,fecha,valor) Values(?,?,?,?,?,?);";
		try {
			con.setAutoCommit(false);
			PreparedStatement st = con.prepareStatement(sql);
			for (Valoracion cap : csv) {
				System.out.println(
						cap.id_serie + cap.id_serie + cap.n_temporada + cap.n_orden + cap.id_usuario + cap.valor);
				st.setInt(1, cap.id_serie);
				st.setInt(2, cap.n_temporada);
				st.setInt(3, cap.n_orden);
				st.setInt(4, cap.id_usuario);
				st.setDate(5, cap.fecha);
				st.setInt(6, cap.valor);
				st.executeUpdate();
			}
			con.commit();
			con.setAutoCommit(true);
			closeConnection();
		} catch (SQLException e) {
			displaySQLError(e);

			return -1;
		}
		return csv.size();
	}

	public String catalogo() {
		openConnection();
		String result = "{";
		String sql = "Select serie.titulo, temporada.n_capitulos, serie.id_serie from "
				+ "(temporada join serie on serie.id_serie = temporada.id_serie) order by serie.id_serie, temporada.n_temporada ASC;";
		ArrayList<String> lista = new ArrayList<String>();
		try {
			st2 = con.createStatement();
			ResultSet rs = st2.executeQuery(sql);
			int index = 0;
			int id_serieUlt = 0;
			if (rs.next()) {
				lista.add(new String(rs.getString("titulo") + ": ["));
				lista.set(index, lista.get(index) + rs.getInt("n_capitulos") + ",");
				id_serieUlt = rs.getInt("id_serie");
			} else {
				return "{}";
			}
			while (rs.next()) {
				String titulo = rs.getString("titulo");
				int id_serie = rs.getInt("id_serie");
				int n_capitulos = rs.getInt("n_capitulos");
				System.out.println("idAcual: " + id_serie + "   " + id_serieUlt + "   " + index);
				if (id_serie != id_serieUlt && id_serieUlt != 0) {
					lista.add(new String(rs.getString("titulo") + ": ["));
					String resPosIndex = lista.get(index);
					lista.set(index, resPosIndex.substring(0, resPosIndex.length() - 1) + "] ,");
					index++;
					lista.set(index, lista.get(index) + n_capitulos + ",");
					id_serieUlt = id_serie;
				} else {
					lista.set(index, lista.get(index) + n_capitulos + ",");
				}
			}
		} catch (SQLException e) {
			displaySQLError(e);
			return null;
		} finally {
			for (String res : lista) {
				result += res;
			}
		}
		return result.substring(0, result.length() - 1) + "]}";
	}


	public String noHanComentado() {
		String result = "[";
		try {
			openConnection();
			st2 = con.createStatement();
			ResultSet rs = st2.executeQuery("SELECT nombre, apellido1, apellido2 FROM usuario "
					+ "LEFT JOIN comenta ON usuario.id_usuario = comenta.id_usuario"
					+ " WHERE comenta.id_usuario IS NULL ORDER BY apellido1 ASC;");
			while (rs.next()) {
				if (rs.isFirst()) {
					result += rs.getString("nombre") + " " + rs.getString("apellido1") + " "
							+ rs.getString("apellido2");
				} else {
					result += ", " + rs.getString("nombre") + " " + rs.getString("apellido1") + " "
							+ rs.getString("apellido2");
				}
			}
		} catch (SQLException e) {
			displaySQLError(e);
			return null;
		}
		return result + "]";
	}

	public double mediaGenero(String genero) {
		openConnection();
		String sql = "SELECT avg(valora.valor) average FROM pertenece join genero on genero.id_genero = pertenece.id_genero"
				+ " join valora on pertenece.id_serie = valora.id_serie WHERE genero.descripcion = \"" + genero + "\";";
		double result = -3;
		boolean hayGen = false;
		try {
			Statement st1 = con.createStatement();
			hayGen = st1.execute("select * from genero where descripcion = \"" + genero + "\"");
			if (hayGen) {
				st2 = con.createStatement();
				ResultSet rs2 = st2.executeQuery(sql);
				if (!rs2.next())
					result = 0.0;
				else
					result = rs2.getDouble("average");
			} else {
				result = -1.0;
			}
		} catch (SQLException e) {
			displaySQLError(e);
			result = -2.0;
		}
		return result;
	}

	public double duracionMedia(String idioma) {
		openConnection();
		String sql =  "SELECT AVG(capitulo.duracion) average FROM capitulo JOIN serie ON serie.id_serie = capitulo.id_serie "+
		"JOIN capitulo cap ON serie.id_serie = capitulo.id_serie " + 
		"left JOIN valora t on t.id_serie IS NULL AND t.n_temporada IS NULL AND t.n_orden IS NULL WHERE serie.idioma = \"" + idioma + "\";";
		double result = -3.0;
		ResultSet hayCap = null;
		try{
			Statement st1 = con.createStatement();
			hayCap = st1.executeQuery(sql);
			hayCap.next();
			result = hayCap.getDouble("average");
			//al ser el query con select avg siempre devuelve un valor aunque sea null, cuando se obtiene la columna y es 0 el valor entonces
			//sabemos que no hay capitulos que cumplen los requisitos y retornamos -1
			if(result==0) result=-1;		
		} catch (SQLException e) {
			displaySQLError(e);
			result = -2.0;
		}
		return result;
	}

	public boolean setFoto(String filename) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		File f = null;
		FileInputStream fis = null;
		try {
			openConnection();
			pst = con.prepareStatement(
					"UPDATE usuario SET fotografia = ? WHERE apellido1 = 'Cabeza' AND fotografia IS NULL;");
			f = new File(filename);
			fis = new FileInputStream(f);
			pst.setBinaryStream(1, fis, (int) f.length());
			int n = pst.executeUpdate();
			if (n > 0)
				System.out.println("Fotografia añadida");
			else
				System.out.println("Fotografia no añadida");
		} catch (SQLException | FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private <E> ArrayList<E> readData(String file, String tipo) {
		File f = new File(file);
		ArrayList<E> result = null;
		Scanner fileScanner = null;
		try {
			fileScanner = new Scanner(f);
			fileScanner.nextLine();
			if (tipo.equals("Valoracion")) {
				result = (ArrayList<E>) new ArrayList<Valoracion>();
				while (fileScanner.hasNextLine()) {
					String[] att = fileScanner.nextLine().split(";");
					Date tiempo = Date.valueOf(att[4]);
					System.out.println(att[3]);
					Valoracion v = new Valoracion(Integer.valueOf(att[0]), Integer.valueOf(att[1]),
							Integer.valueOf(att[2]), Integer.valueOf(att[3]), tiempo, Integer.valueOf(att[5]));
					((ArrayList<SeriesDatabase.Valoracion>) result).add(v);
				}
			} else {
				result = (ArrayList<E>) new ArrayList<Capitulo>();
				while (fileScanner.hasNextLine()) {
					String[] att = fileScanner.nextLine().split(";");
					System.out.println(att[3]);
					Date tiempo = Date.valueOf(att[3]);
					Capitulo c = new Capitulo(Integer.valueOf(att[0]), Integer.valueOf(att[1]), Integer.valueOf(att[2]),
							tiempo, att[4], Integer.valueOf(att[5]));
					((ArrayList<SeriesDatabase.Capitulo>) result).add(c);
				}
			}
			fileScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se puede leer el archivo");
		}
		return result;
	}

	static private class Capitulo {
		int id_serie;
		int n_temporada;
		int n_orden;
		Date fecha_estreno;
		String titulo;
		int duracion;

		public Capitulo(int id_serie, int n_temporada, int n_orden, Date fecha_estreno, String titulo, int duracion) {
			this.id_serie = id_serie;
			this.n_temporada = n_temporada;
			this.n_orden = n_orden;
			this.fecha_estreno = fecha_estreno;
			this.titulo = titulo;
			this.duracion = duracion;
		}
	}

	static private class Valoracion {
		Integer id_serie;
		Integer n_temporada;
		Integer n_orden;
		Integer id_usuario;
		Date fecha;
		Integer valor;

		public Valoracion(int id_serie, int n_temporada, int n_orden, int id_usuario, Date fecha, int valor) {
			this.id_serie = id_serie;
			this.n_temporada = n_temporada;
			this.n_orden = n_orden;
			this.id_usuario = id_usuario;
			this.fecha = fecha;
			this.valor = valor;
		}
	}
	private void displaySQLError(SQLException e) {
		System.out.println("Error message: " + e.getMessage());
		System.out.println("Error code: " + e.getErrorCode());
		System.out.println("SQL state: " + e.getSQLState());
		e.printStackTrace();
	}


}
