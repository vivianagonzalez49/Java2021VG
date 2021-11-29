package laboratorio;

/**
 *
 * @author vafla laboratorio: Proyecto Caja video 59, sección 10 Se solicita
 * crear una clase llamada Cajacon las siguientes características: •Debe tener 3
 * atributos de tipo entero (ancho, alto y profundo) •Debe tener 2
 * constructores, uno vacío y uno con 3 argumentos, uno por cada atributo de la
 * clase. •Debe tener el método que calcule el volumen de la caja según la
 * formula de la lámina anterior. •Crear una clase de prueba para crear un
 * objeto de tipo caja que tenga como valores: ancho=3, alto= 2, profundo = 6 y
 * que mande a imprimir el volumen de la caja según los valores proporcionados
 * anteriormente
 *
 */
public class Caja {

    /* Atributos */
    int ancho;
    int alto;
    int profundo;

    /* Constructor vacío */
    public Caja() {
        System.out.println("Ejecucion constructor vacío");
    }

    /* Constructor con argumentos */
    public Caja(int ancho, int alto, int profundo) {
        this.ancho = ancho;
        this.alto = alto;
        this.profundo = profundo;
        System.out.println("Ejecucion constructor con argumentos");
    }
    
    /* Metodo para calcular volumen con retorno */
    public int volumen() {
        return alto * ancho * profundo;
    }
    
    /* Metodo para calcular volumen vacio */
    public void volumenVacio() {
        int resultado = alto * ancho * profundo;
        System.out.println("El volumen (con void) es = " + resultado);
    }
}
