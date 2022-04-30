
package academia;
/**
* Implementación del TAD Asignatura<br>
* {@code Asignatura = Tupla(nombre,Col(Alumno))}
* INV(Asignatura) = Hay orden lexicografico creciente.
* @since 2/4/2018 > 31/3/2020
* @version 1.1
* @author JMB
*/
public class AsignaturaCol implements Asignatura
{
private String nombre;
private ICol<Alumno> asig;
private int MAX_TAMAÑO = 20;
public AsignaturaCol (String name)
{
nombre = name;
asig = new ColTupla<Alumno>(MAX_TAMAÑO);
}
public String getNombre()
{
return nombre;
}
public String toString ()
{
return "(" + nombre + "," + asig.size() + ",\n" + asig + ")";
}
public boolean esIgual (Asignatura a)
{
AsignaturaCol otra = (AsignaturaCol) a;
return nombre.equals(otra.nombre);
}
public int size()
{
return asig.size();
}
// TIPO BUSQUEDA ----------------------------------------------------
/**
* Bus = TUPLA(boolean,int)=(esta,pos)
*/
private class Bus
{
boolean esta;
int pos;
Bus (boolean si, int aqui)
{
esta = si;
pos = aqui;
}
}
/**
* PRE: Existe un orden lexicográfico creciente* POST: resultado es el "Bus" (true,i) donde i es la posicion de la
* primera aparicion del alumno "al" en el objeto. Si "al" no
* está, el resultado es el "Bus" (false,i) donde i es la posicion
* donde deberia estar el alumno.
*/
private Bus buscarPos(Alumno al)
{
String claveAl = al.clave();
String claveActual;
int valorComparacion;
boolean encontrado = false;
boolean colocado = false;
int i = 0;
while((i < asig.size()) && !encontrado && !colocado)
{
claveActual = asig.get(i).clave();
valorComparacion = claveAl.compareTo(claveActual);
if (valorComparacion == 0)
encontrado = true;
else if (valorComparacion < 0)
colocado = true;
else
i++;
}
return new Bus(encontrado,i);
}
// -----------------------------------------------------------------
public Alumno get (int pos)
{
return asig.get(pos);
}
public Alumno getNotas (Alumno al)
{
Bus lugar = buscarPos(al);
return (lugar.esta)? asig.get(lugar.pos) : al;
}
public void matricularAlumno (Alumno al)
{
Bus lugar = buscarPos(al);
asig.add(lugar.pos,al);
}
public void desmatricularAlumno (Alumno al)
{
Bus lugar = buscarPos(al);
asig.remove(lugar.pos);
}
public void calificarAlumno (Alumno al)
{
Bus lugar = buscarPos(al);
if (lugar.esta)
{
Alumno actual = asig.get(lugar.pos);
actual.setPrimerParcial(al.getPrimerParcial());
actual.setSegundoParcial(al.getSegundoParcial());
}
}
}