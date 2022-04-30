-- String sql = "create table capitulo(id_serie int, n_temporada int, n_orden int, fecha_estreno date, titulo varchar(100), duracion int,"
-- 		+ "PRIMARY KEY(id_serie, n_temporada,n_orden)," 
-- 		+ "FOREIGN KEY (id_serie, n_temporada) REFERENCES temporada(id_serie,n_temporada) ON DELETE CASCADE ON UPDATE CASCADE);";
--         String sql = "create table valora(id_serie int, n_temporada int, n_orden int, id_usuario int, fecha date, valor int,"
-- 		+ "FOREIGN KEY (id_serie,n_temporada,n_orden) REFERENCES capitulo(id_serie,n_temporada,n_orden) ON DELETE CASCADE ON UPDATE CASCADE,"
-- 		+ "FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario) ON DELETE CASCADE ON UPDATE CASCADE,"
-- 		+ "PRIMARY KEY(id_serie,n_temporada, n_orden, id_usuario, fecha));";
--         String sql = "Insert into valora (id_serie,n_temporada,n_orden,id_usuario,fecha,valor) Values(?,?,?,?,?,?);";
--         ResultSet rs = st.executeQuery("SELECT nombre, apellido1, apellido2 FROM usuario " +
--                                 "LEFT JOIN comenta ON usuario.id_usuario = comenta.id_usuario" +
--                                  " WHERE comenta.id_usuario IS NULL ORDER BY apellido1 ASC;");

Select serie.titulo, temporada.n_capitulos, temporada.n_temporada, serie.id_serie from (temporada join serie on serie.id_serie = temporada.id_serie) order by serie.id_serie, temporada.n_temporada;


 Select serie.titulo, temporada.n_capitulos, serie.id_serie from
 (temporada join serie on serie.id_serie = temporada.id_serie) order by serie.id_serie, temporada.n_temporada ASC;


 Select AVG(valora.valor), serie.id_serie, capitulo.n_temporada, capitulo.n_orden, genero.descripcion  from 
 serie JOIN valora on serie.id_serie = valora.id_serie 
 JOIN pertenece on pertenece.id_serie = serie.id_serie
 JOIN capitulo on capitulo.id_serie = serie.id_serie
 JOIN genero on genero.id_genero = pertenece.id_genero
 WHERE genero.descripcion = "Comedia"
 GROUP BY capitulo.n_orden
 ;


 AVG(valora.valor), ;


 SELECT avg(valora.valor) average FROM pertenece join genero on genero.id_genero = pertenece.id_genero
 join valora on pertenece.id_serie = valora.id_serie
 WHERE genero.descripcion = "Terror"
 ;

 select * from genero where descripcion = "Drama";

 update usuario
 set fotografia = se;ect 
 select * from usuario("HomerSimpson.jpg") where usuario.apellido1 = "Cabeza";


 SELECT AVG(capitulo.duracion) average FROM capitulo JOIN serie ON serie.id_serie = capitulo.id_serie
 JOIN capitulo cap ON serie.id_serie = capitulo.id_serie 
 left JOIN valora t on t.id_serie IS NULL AND t.n_temporada IS NULL AND t.n_orden IS NULL
 WHERE serie.idioma = 'Francés' ;


SELECT * FROM serie JOIN serie ON serie.idioma = capitulo.id_serie where serie.idioma = "POllas";

SELECT * FROM capitulo JOIN serie ON serie.id_serie = capitulo.id_serie where serie.idioma = "Francés";

