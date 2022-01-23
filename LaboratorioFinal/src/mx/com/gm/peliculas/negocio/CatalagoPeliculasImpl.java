package mx.com.gm.peliculas.negocio;

import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.gm.peliculas.datos.AccesoDatosImpl;
import mx.com.gm.peliculas.datos.IAccesoDatos;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

/**
 *
 * @author vafla
 * Define la funcionalidad de la aplicacion. Reglas de negocio de la aplicacion. Contiene la implementacion de las operaciones necesarias de la aplicacion CatalogoPeliculas
 * 
 * Esta clase implementa también la interface IAccesoDatos. No extiende directamente la clase (AccesoDatosImpl) que implementa esa interface sino que lo hace directamente. No va a ver conexión directa entre clases sino los tipos interface.
 * Con esto se aplica el concepto de bajo acoplamiento y alta cohesion: porque si las clases (CatalagoPeliculasImpl, AccesoDatosImpl) si tienen alguna modificacion, si trabajamos directamente con las clases, entonces nos puede afectar nuestro codigo pero si se trbaaja con tipo interface entonces se puede modificar el codigo de las clases que implementan los metodo definidos en las interfaces y entonces no estamos afectando a las demas capas debido a que la interface contiene solamente la firma de los metodos pero no contiene cómo es que se realiza ese trabajo; para ello se tienen las clases que implementan la interface
 */
public class CatalagoPeliculasImpl implements ICatalogoPeliculas {
    
    private final IAccesoDatos datos;//se crea un atributo del tipo de la interface IAccesoDatos
    
    public CatalagoPeliculasImpl(){
        //inicializa la variable datos
        this.datos = new AccesoDatosImpl();//se utiliza la clase que implementa la interface IAccesoDatos
        //cuando se utiliza el tipo interface, entonces se van a poder acceder a los metodos definidos en la inferface. Debido a que este tipo  this.datos puede apuntar a clases que implementan esta interface, entonces se va a poder utilizar esa implementacion de manejo de archivos sin problema pero bien podria ser una implementacion de acceso a db
        //es recomendable utilizar el tipo inteface cuando se defina nuestra variable y posteriormente especificar cual es la implementacion que se va a utilizar, en este caso AccesoDatosImpl() pero esa implementacio se puede cambiar en cualquier momento
    }

    @Override
    public void agregarPelicula(String nombrePelicula) {
        try {
            Pelicula pelicula = new Pelicula(nombrePelicula);//se recibe un String pero se convierte ese string a un objeto de tipo pelicula, se utiliza ese string para inicializar el objeto de tipo pelicula
            boolean anexar = false;//se define una variable para saber si se va a anexar informacion al archivo o si se va a sobreescribir
            anexar = datos.existe(NOMBRE_RECURSO);//para la variable anexar se va a preguntar por medio de la variable de datos si existe el archivo y para ello se va a utilizar la constante NOMBRE_RECURSO. Se debe envolver en un bloque tyr-catch y trae la posible exception AccesoDatosEx
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);//si existe, por medio de la variable datos se va a manda a escribir. Se escribe el objeto pelicula, el nombre del recurso definido en la interface y se anexa o no la informacion dependiendo si existe o no el recurso en el disco duro
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPeliculas() {
        try {
            var peliculas = this.datos.listar(NOMBRE_RECURSO);//se define la variable peliculas y se utiliza el atributo datos para acceder al metodo listar especificando en nombre del archivo. Este metodo puede arrojar un excepcion
            for(var pelicula : peliculas){//con la variable peliculas se va a iterar cada una de las peliculas que se tienen y se van a mandar a imprimir
                System.out.println("pelicula = " + pelicula);//se imprime la variable pelicula para imprimir cada una de las peliculas que se tienen en el archivo
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);//no propaga excepcion sino que la muestra
        }
    }

    @Override
    public void buscarPelicula(String buscar) {
        String resultado = null;//variable resultado donde se va a almacenar el resultado de la busqueda. Si no se encuentra entonces sera null
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);//con la variable se utiliza el atributo datos, posteriormente se manda a llamar el metodo buscar, se indica el nombre del recurso y la pelicula a buscar
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos buscando la pelicula");
            ex.printStackTrace(System.out);//no propaga excepcion sino que la muestra. Se manda a imprimir la lista de errores
        }
        System.out.println("resultado = " + resultado);//se imprime el resultado. Recordar que el resultado de buscar una pelicula regresa el indice, es decir la linea del archivo donde se encuentra la pelicula
    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            //se pregunta si ya existe el archivo y se quiere volver a iniciar el catalogo de pelioculas
            if(this.datos.existe(NOMBRE_RECURSO)){
                datos.borrar(NOMBRE_RECURSO);//si ya existe se borra el archivo y
                datos.crear(NOMBRE_RECURSO);//posteriormente se crea el archivo
            }else { //si no existe entonces se crea
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al iniciar catalogo de peliculas");
            ex.printStackTrace(System.out);
        }
    }
}
