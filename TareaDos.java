import java.util.Scanner;

/*
Tarea: Tienda de libros
Se solicita capturar la siguiente información de una tienda de libros:

nombre (String)

id (int)

precio (double)

envioGratuito (boolean)

Tu tarea es imprimir un mensaje en el siguiente formato:

Proporciona el nombre:
Proporciona el id:
Proporciona el precio:
Proporciona el envio gratuito:
<nombre> #<id>
Precio: <simbolo><precio>
Envio Gratuito: <envioGratuito>
Por ejemplo:

Proporciona el nombre:
Programacion con Java
Proporciona el id:
1520
Proporciona el precio:
899
Proporciona el envio gratuito:
true
Programacion con Java #1520
Precio: $899.00
Envio Gratuito: true
 * @author vivianagonzalez
 */
public class TiendaLibros {
    public static void main (String args[]){
        /* Para cada uno se puede usar su propio tipo String, int, double, boolean, 
        pero decidí usar con todos var y luego hacer la conversión de tipos */
        Scanner consola = new Scanner(System.in);
        System.out.println("Proporciona el nombre: ");
        var nombre = consola.nextLine(); // por defecto lo toma como string
        System.out.println("Proporciona el id: ");
        var id = Integer.parseInt(consola.nextLine());
        System.out.println("Proporciona el precio: ");
        var precio = Double.parseDouble(consola.nextLine());
        System.out.println("Proporciona el envío gratuito: ");
        var envioGratuito = Boolean.parseBoolean(consola.nextLine());
        
        System.out.println(nombre + " #" + id);
        System.out.println("Precio: " + "$" + precio);
        System.out.println("Envío gratuito: " + envioGratuito);
    }
}
