package com.gm.mundopc;

/**
 *
 * @author vafla
 */
public class Orden {
    
    private final int idOrden;
    private Computadora computadoras[];
    private static int contadorOrdenes;
    private int contadorComputadoras;//saber cuantos objetos de tipo computadora se han agregado al arreglo. no basta con saber el maximo de objetos de tipo computadora que soporta el arreglo sino que se necesita saber cuantos objetos realmente se han agregado al arreglo
    private static final int maxComputadoras = 10;
    
    public Orden(){
        this.idOrden = ++Orden.contadorOrdenes;//inicializa idOrden con contador
        this.computadoras = new Computadora[Orden.maxComputadoras];//inicializa el arreglo de productos
    }
    
    public void agregarComputadora(Computadora computadora){
        if(this.contadorComputadoras < Orden.maxComputadoras){//contadorComputadoras no supere el maximo de computadoras permitidas en el arreglo
            this.computadoras[this.contadorComputadoras++] = computadora;//por cada objeto de tipo producto que se agregue, se va a incrementar la variable contadorProductos. primero se agina el valor y posteriormente se va a incrementar la siguiente vez que se utilice la variable
        }else{
            System.out.println("Se ha superado el limite" + Orden.maxComputadoras);
        }
    }
    
    public void mostrarOrden(){
        //imprimir detalle de la orden, detalle de todos los productos que se tienen en la orden, asi como el total de la orden
        System.out.println("Id Orden: "+ this.idOrden);
        System.out.println("Computadoras de la orden: " + this.idOrden);
        for (int i = 0; i < this.contadorComputadoras; i++) {//se hace con contadorComputadoras ya que esa variable es la que realmente tiene cuantas computadoras se han agregado al arreglo actualmente
            System.out.println(this.computadoras[i]);//se proporciona el indice que se esta iterando en el momento
        }
    }
}
