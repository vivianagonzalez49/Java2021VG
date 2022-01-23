package mx.com.gm.peliculas.presentacion;

import java.util.Scanner;
import mx.com.gm.peliculas.negocio.CatalagoPeliculasImpl;
import mx.com.gm.peliculas.negocio.ICatalogoPeliculas;

/**
 *
 * @author vafla
 * Contiene el metodo Main. Incluye un menu de opciones para escoger la opcion a procesar en el programa
 * bajo acoplamiento: utilizar la menor cantidad de relaciones entre las clases, es decir, la capa de presentacion no se comunica directamente con la capa de datos sino solamente con la capa de negocio
 * alta cohesion: cada clase se encarga de realizar su tarea y nada mas y por ello la separacion de capas, cada capa se encarga de su funcion en particular, por ej, la capa de datos en caso de comunicarse con el archivo, la capa de negocio se encarga de realizar las operaciones de nuestra app y finalmente la capa de presentacion se encarga de mostrar la informacion al usuario y tambien de capturar la informacion del usuario. Cada capa tiene su propia responsabilidad
 */
public class CatalogoPeliculasPresentacion {
    public static void main(String[] args) {
        int opcion = -1;
        Scanner scanner = new Scanner(System.in);//variable scanner tipo Scanner, se crea el objeto tipo scanner y se pasa la consola de entrada. Se usa para solicitar informacion al usuario
        ICatalogoPeliculas catalogo = new CatalagoPeliculasImpl();//variable del tipo de la interface ICatalogoPeliculas y se crea el objeto de la clase CatalogoPeliculasImpl
        
        //El ususario puede presionar varias opciones, si presiona 0 el programa termina
        while(opcion != 0){//mientras opcion sea diferente de cero entonces el programa continua en este ciclo while
            System.out.println("Elige uan opción: \n"
                + "1. Iniciar catalogo de peliculas \n"
                + "2. Agregar pelicula \n"
                + "3. Listar peliculas \n"
                + "4. Buscar pelicula \n"
                + "0. Salir"); //Esto es lo primero que se le muestra al usuario, el menu principal
            opcion = Integer.parseInt(scanner.nextLine()); //se captura la opcion que proporcione el user. Se debe convertir al tipo con el que se esta trbajando, en este caso entero
            
            //procesar cada una de las opciones que el user proporcione
            switch(opcion){
                case 1:
                    catalogo.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la pelicula");//primero se debe saber cual pelicula se quiere procesar. Por ello antes se va a solicitar al usuario que proporcione el nombre de la pelicula
                    var nombrePelicula = scanner.nextLine();//se procesa el nombre de la pelicula utilizando el scanner.nextline
                    catalogo.agregarPelicula(nombrePelicula);//esto crea internamente un objeto de tipo pelicula
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    System.out.println("Introduce el nombre de una pelicula a buscar");
                    var buscarPelicula = scanner.nextLine();
                    catalogo.buscarPelicula(buscarPelicula);
                    break;
                case 0:
                    System.out.println("Hasta pronto!");
                    break;
                default:
                    System.out.println("Opcion no reconocida");
                    break;
            }
        }
    }
}
