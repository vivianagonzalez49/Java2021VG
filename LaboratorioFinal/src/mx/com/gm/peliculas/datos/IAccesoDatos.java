package mx.com.gm.peliculas.datos;

import java.util.List;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

/**
 *
 * @author vafla
 * Puede ser tambien una bd
 * Una interface solo va a definir el comportamiento
 */
public interface IAccesoDatos {
    
    boolean existe(String nombreRecurso) throws AccesoDatosEx; //Si existe o no (true o false) el archivo en el disco duro, con el que se va a trabajar. Si es true, regresa una lista de objetos tipo pelicula. nombreArchivo
    
    List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx;//Regresa un List, una coleccion lista de objetos tipo Pelicula, se pasa el nombre del recurso para poder acceder al archivo
    
    void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx;//Se recibe un objeto de tipo Pelicula ya que se va a anexar al archivo, se define el nombre del recurso y ademas se indica si se anexa la info o se sobreescribe
    
    String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx;//para buscar una pelicula. Regresa un Stringsi se encuentra la pelicula. Se define el nombre del recurso (nombre del archivo) y la cadena a buscar
    
    void crear(String nombreRecurso) throws AccesoDatosEx;//crear un archivo o recurso. Se define el parametro nombreRecurso
    
    void borrar(String nombreRecurso) throws AccesoDatosEx;//See le indica en nombre del recurso que se desea borrar
}
