package laboratorio;

/**
 *
 * @author vafla
 */
public class PruebaCaja {
    public static void main(String[] args) {
        
        Caja argumentos1 = new Caja();
        System.out.println("argumentos1 alto: " + argumentos1.alto);
        System.out.println("argumentos1 ancho: " + argumentos1.ancho);
        System.out.println("argumentos1 profundo: " + argumentos1.profundo);
        
        Caja argumentos2 = new Caja(3, 2, 6);
        System.out.println("argumentos2 ancho: " + argumentos2.ancho);
        System.out.println("argumentos2 alto: " + argumentos2.alto);
        System.out.println("argumentos2 profundo: " + argumentos2.profundo);
        
        int resultado = argumentos2.volumen(); //se regresa el resultado
        System.out.println("El volumen es = " + resultado); //se imprime el resultado
        
        argumentos2.volumenVacio();
    }
}
