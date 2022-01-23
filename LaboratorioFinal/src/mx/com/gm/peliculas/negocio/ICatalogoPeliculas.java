package mx.com.gm.peliculas.negocio;

/**
 *
 * @author vafla
 * Contiene las operaciones necesarias de la aplicacion CatalogoPeliculas
 * Tratar unicamente temas que teienen que ver con la aplicacion
 */
public interface ICatalogoPeliculas {
    
    String NOMBRE_RECURSO = "peliculas.txt";//nombre del archivo
    
    void agregarPelicula(String nombrePelicula);
    
    void listarPeliculas();
    
    void buscarPelicula(String buscar);
    
    void iniciarCatalogoPeliculas();//inicarArchivo en si
}
