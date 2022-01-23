package mx.com.gm.peliculas.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

/**
 *
 * @author 
 * Agrega la funcionalidad para interactuar con el archivo donde se va a guardar la informacion del catalogo de peliculas. Contiene las operaciones a ejectuar en el archivo de peliculas.txt
 * 
 * Se debe cumplir con el contrato definido en la interface. Se deben implementar los abstract methods. Al comienzo da un error pero el ide ayuda con eso
 */
public class AccesoDatosImpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombreRecurso) {//tipo Exception se definen en la firma del metodo
        File archivo = new File(nombreRecurso);//variable tipo File y se crea el objeto de esa clase. Se le indica el nombre del recurso que se va a buscar. Solo se esta creando la variable archivo mas no el archivo en si en el disco duro
        return archivo.exists();//se pregunta si existe el archivo. exists regresa true si existe o false si no existe. Como regresa un boolean, se puede regresar directamente la pregunta del metodo .exists(). Con esto se verifica si existe el archivo ya en el disco duro
    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx {
        File archivo = new File(nombreRecurso); //variable archivo de tipo File y se crea el objeto tipo File con la variable nombreRecurso que se esta recibiendo
        List<Pelicula> peliculas = new ArrayList<>();//se crea el tipo, la variable que va a almacenar los objetos de tipo pelicula, lista de peliculas y se inicializa la lista usando la implementacion de List (arraylist). En ArrayList<> se indica que se va a utilizar un tipo generico y se va a utilizar el tipo generico definido en el lado izquierdo <Pelicula>. Si es una coleccion es en plural
        try {
            //Se lee cada una de las lineas del archivo. Cada linea que se lea va a ser un String y posteriormente ese String va a ser el nombre de la pelicula asi que en la clase Pelicula, en su atributo nombre se va a almacenar el nombre de la pelicula. Es decir, cada linea del archivo va a corresponder a un nombre de una pelicula. Por eso se crea un objeto de tipo Pelicula con cada linea que se lea del archivo
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));//Se lee el archivo con BufferedReader, se crea el objeto BufferedReader y a su vez se necesita crear el objeto FileReader ya que se debe recordar que FileReader no lee lineas completas, por lo tanto se debe apoyar tambien en el BufferedReader para poder leer lineas completas. Se pasa el objeto de archivo de File. Puede traer una exception FileNotFoundException entonces el codigo queda envuelto en un try-catch
            String linea = null;//variable para leer cada una de las lineas
            linea = entrada.readLine();//se utiliza la variable de entrada y el metodo readLine. Este metodo readLine peude arrojar una excepcion IOException. Se lee una linea
            while(linea != null){//se revisa si la linea es diferente de null entonces se empieza a revisar cada una de las lineas pero ya no se manda a imprimir la informacion que se lee del archivo sino que se va a regresar una lista de objetos de tipo Pelicula segun lo que se ha definido en el metodo
                Pelicula pelicula = new Pelicula(linea);//se crea un objeto de tipo Pelicula y utilizando el constructor definido en la clase lo que se le pasa es la linea que se esta leyendo ya que se debe recordar que cada linea que tenga el archivo es un string que contiene el nombre de cada pelicula (una pelicula cad vez). Cada una de las lineas contiene un string  y ese string se va a utilizar en el constructor de la clase Pelicula
                peliculas.add(pelicula);//una vez se tenga el objeto de pelicula se agrega a la lista. Se agrega .add el objeto tipo pelicula (pelicula) a la lista peliculas. //Por cada linea que se lea en el archivo, se esta agregando un objeto de tipo Pelicula a la lista de peliculas
                linea = entrada.readLine();//se vuelve a leer la linea ya que se esta dentro de un ciclo while para sabeer si se tiene una nueva linea y si es asi, entonces se vuelve a preguntar si la linea es diferente de nulo se vuelve a hacer el proceso, se crea un nuevo objeto de tipo pelicula y se agrega a la lista de peliculas
            }
            entrada.close();//si se termina de leer cada una de las lineas del archivo entonces ya se puede cerrar el flujo
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas: " + ex.getMessage());//se propaga la excepcion y se obtiene el mensaje
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas: " + ex.getMessage());
        }
        return peliculas;//se devuelve el listado de peliculas
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx {
        File archivo = new File(nombreRecurso);//se define la variable de archivo de tipo File, se crea un objeto tipo File y se pasa el nombre del recurso
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));//se crea la variable de salida para mandar informacion, para poder empezar a escribir. La clase PrintWriter va a recibir un objeto FileWriter, se indica la variable archivo (el file) y el boolean anexar para indicar si se va a anexar info o se va a sobreescribir info existente en el archivo. Esto puede generar una exception IOException y se crea un bloque try-catch
            salida.println(pelicula.toString());//se anexa la informacion. Se utiliza la variable de salida, el metodo println para que imprima una nueva linea y basicamente se manda a imprimir el objeto de tipo pelicula. Si se esta en la consola estandar, de forma automatica se manda a llamar el metodo to String, sin embargo ya que esto no es la salida estandar directamente, se debe mandar a llamar el metodo toString para que se imprima el objeto de tipo pelicula, po reso solamente en la implementacion del metodo toString debe tener el nombre de la pelicula return this.nombre; solo regresara el atributo de nombre
            salida.close();//una vez que se ha mandado esta informacion al archivo,  entonces se cierra el flujo
            System.out.println("Se ha escrito informacion al archivo: " + pelicula);//y finalmente se envia este mensaje
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new EscrituraDatosEx("Excepcion al escribir peliculas: " + ex.getMessage());
        } 
    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx {
        //regresa una cadena donde nos indica si existe el objeto de tipo pelicula que se va a buscar y ademas el indice, es decir la linea donde lo encontro buscar
        File archivo = new File(nombreRecurso);//se define la variable de archivo de tipo File, se crea un objeto tipo File y se pasa el nombre del recurso
        String resultado = null;//se define una variable donde se va a almacenar el resultado. En caso de que la pelicula exista se va a indicar el indice y nombre de la pelicula encontrada
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));//se crea la variable entrada, internamente se crea el objeto FileReader y se le pasa el nombre del archivo. Puede arrojar una excepcion FileNotFoundException
            String linea = null;//se define la variable linea que va a almacenar cada una de las lineas
            linea = entrada.readLine();//usando la variable entrada se lee la linea. Puede arrojar una excepcion IOException
            int indice = 1; //saber el indice que se esta leyendo, la pelicula. Posteriormente se puede incrementar conforme se vaya leyendo las lineas del archivo. La primer linea tendra el valor de 1
            while(linea != null){
                if(buscar != null && buscar.equalsIgnoreCase(linea)){//si la pelicula que se esta buscando es diferente de nulo. La cadena de la pelicula que se esta buscando sea diferente de nulo y ademas si es igual a la linea que se ha leido. equalsIgnoreCase para que no afecte la diferencia de mayusculas y minusculas
                    resultado = "Pelicula " + linea + " encontrada en el indice " + indice;
                    break;//si ya se ha encontrado la pelicula entonces se rompe el ciclo while
                }
                linea = entrada.readLine();//si la busqueda no coincide, entonces se vuelve a leer la siguiente linea, asi que se utiliza la variable entrada. 
                indice++;//y se incrementa el indice. Si no se encuentra en la primer linea, se lee la siguiente linea y se incrementa el indice
            }
            entrada.close();//al terminar el ciclo while se debe cerrar
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al buscar pelicula: " + ex.getMessage());//se propaga la excepcion y se obtiene el mensaje
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al buscar pelicula: " + ex.getMessage());
        }
        return resultado;//si no se llega a encontrar entonces se retorna la variable resultado con el valor de null
    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosEx {
        File archivo = new File(nombreRecurso);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo)); //se abre un flujo para poder crear el archivo. FileWriter puede dar exception IOException
            salida.close();//Una vez que se tiene el archivo de salida, para que se cree este archivo, simplemente se hace un close y con eso se crea el archivo
            System.out.println("Se ha creado el archivo");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx("Excepcion al crear archivo: " + ex.getMessage());
        }
    }

    @Override
    public void borrar(String nombreRecurso) {
        File archivo = new File(nombreRecurso);
        if(archivo.exists()){//Si existe el archivo entonces se elimina
            archivo.delete();//con la variable archivo se manada a llamar el metodo delete
            System.out.println("Se ha borrado el archivo");
        }
        
    }
}
