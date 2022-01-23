package mx.com.gm.peliculas.domain;

/**
 *
 * @author vafla
 * Clase del dominio del problema. Representa los objetos pelicula utilizados en la aplicacion catalogo de peliculas
 * 
 * La clases de dominio son conocidas tambien como clases de entidad. En la conexion a DB con JDBC, normalmente corresponder a una tabla de BD y los atributos que tiene esta clase serian columnas de la tabla Pelicula en la BD
 * 
 * Se va a usar en varias partes del programa
 * En datos para guardar, recuperar informacion, leer informacion de un pelicula
 * En negocio para realizar las operaciones que se tengan en el sistema
 * En el paquete principal se usara para crear objetos de tipo peicula
 * 
 * Esta es una clase javabean
 */
public class Pelicula {
    
    private String nombre;
    
    public Pelicula(){
        
    }
    
    public Pelicula(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
