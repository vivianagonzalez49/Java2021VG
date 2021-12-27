package com.gm.mundopc;

/**
 *
 * @author vafla
 */
public class DispositivoEntrada {
    protected String tipoEntrada;
    protected String marca;
    
    //constructor
    public DispositivoEntrada(String tipoEntrada, String marca){
        this.tipoEntrada = tipoEntrada;
        this.marca = marca;
    }
    
    //metodos set y get par acada atributo
    public String getTipoEntrada() {
        return tipoEntrada;
    }

    public String getMarca() {
        return marca;
    }

    public void setTipoEntrada(String tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    //metodo toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DispositivoEntrada{tipoEntrada=").append(tipoEntrada);
        sb.append(", marca=").append(marca);
        sb.append('}');
        return sb.toString();
    }    
}
