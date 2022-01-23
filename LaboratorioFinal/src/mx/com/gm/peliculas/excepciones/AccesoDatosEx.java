package mx.com.gm.peliculas.excepciones;

/**
 *
 * @author vafla
 * Excepciones
 * Cada excepcion se usa de acuerdo a lo que se necesite. Sea acceso a datos, lectura de datos o escritura de datos
 */
public class AccesoDatosEx extends Exception{
    
    public AccesoDatosEx(String mensaje){
        super(mensaje);//se llama el constructor de la clase padre Exception que contiene un argumento
    }
}
