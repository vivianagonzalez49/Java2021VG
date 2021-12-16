package domain;

import java.util.Date;

/**
 *
 * @author vafla
 */
public class Cliente extends Persona {
    private int idCliente;
    private Date fechaRegistro;
    private boolean vip;
    public static int contadorCliente;//contabilizar el numero de objetos de tipo Cliente creados y poder asignar un vlaor unico tambien al atributo idCliente de esta clase
    
    public Cliente(String nombre, char genero, int edad, String direccion, Date fechaRegistro, boolean vip) {
        super(nombre, genero, edad, direccion);//siempre debe ser la primera linea cuando se llama un constructor de la clase padre usando super
        this.idCliente = ++Cliente.contadorCliente;
        this.fechaRegistro = fechaRegistro;
        this.vip = vip;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{idCliente=").append(idCliente);
        sb.append(", fechaRegistro=").append(fechaRegistro);
        sb.append(", vip=").append(vip);
        sb.append(", ").append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
