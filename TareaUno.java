import java.util.Scanner;

/*
 * Tarea 2: Detalles Libro
 * @author vivianagonzalez
 */
public class Libro {
    public static void main(String args[]){
        System.out.println("Proporciona el título: ");
        Scanner consola = new Scanner(System.in);
        var titulo = consola.nextLine();
        System.out.println("Proporciona el autor: ");
        var autor = consola.nextLine();
        System.out.println(titulo + " fue escrito por " +  autor);
    }
}
