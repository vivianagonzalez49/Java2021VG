package test;

import domain.Cliente;
import domain.Empleado;
import java.util.Date;

/**
 *
 * @author vafla
 * //aunque no se tenga nada en la clase Empleado, al momento de imprimir se imprime la informacion de toString (se manda a llamar) por ser publica (al hacer esta parte, se hizo sin agregar nada a la clase Empleado para probar que esta clase heredo el metodo toString que hizo que imprimiera informacion, todos con valores por default)
 */
public class TestHerencia {
    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("Viviana", 3500000.0);
        System.out.println("empleado1 = " + empleado1);//cuando se crea un objeto de la clase Empleado no solamente se tiene informacion de la clase hija empleado sino tambien informacion de la clase padre ya que en memoria en un solo objeto
        
        var fecha = new Date();   
        Cliente cliente1 = new Cliente("Viviana Gonzalez", 'F', 27, "Calle 8 # 13-24", fecha, true);//para crear un nuevo objeto de tipo Date se utiliza new, luego Date() y esto regresara una nueva fecha generada en este momento
        System.out.println("cliente1 = " + cliente1);
    }
}
