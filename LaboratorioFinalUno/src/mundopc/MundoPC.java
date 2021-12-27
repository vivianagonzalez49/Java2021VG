package mundopc;

import com.gm.mundopc.*;

/**
 *
 * @author vafla
 */
public class MundoPC {
    public static void main(String[] args) {
        
        Monitor monitorHP = new Monitor("HP", 14.00);
        Raton ratonHP = new Raton("Bluetooth", "HP");
        Teclado tecladoHP = new Teclado("Bluetooth", "HP");
        Computadora computadoraHP = new Computadora("Computadora HP", monitorHP, tecladoHP, ratonHP);//relacion de agregacion: se agregan los objetos (tipo monitor, raton y teclado) a la clase computadora
        
        Monitor monitorASUS = new Monitor("ASUS", 14.00);
        Raton ratonASUS = new Raton("Entrada USB", "ASUS");
        Teclado tecladoASUS = new Teclado("Entrada USB", "ASUS");
        Computadora computadoraASUS = new Computadora("Computadora ASUS", monitorASUS, tecladoHP, ratonASUS);
        
        
        Orden orden1 = new Orden();
        orden1.agregarComputadora(computadoraHP);
        orden1.agregarComputadora(computadoraASUS);
        
        orden1.mostrarOrden();
    }
}
