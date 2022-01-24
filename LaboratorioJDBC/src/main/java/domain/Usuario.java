package domain;

/**
 *
 * @author vafla
 * Esta clase va a representar un registro en la tabla de la db. Clase de entidad
 * Mapeo entre clases java y registros de dbs
 */
public class Usuario {
    
    //Columnas en la DB: id_usuario, usuario, password
    
    private int idUsuario; //se mapea este atributo de Java con la columna de la DB
    private String usuario;
    private String password;
    
    public Usuario(){
    }
    
    //Crear objetos solamente con el idUsuario. Por ejemplo, si se desea eliminar un registro, bastaria solamente con informar el id_usuario/idUsuario
    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    //Crear objetos con todos los atributos excepto idUsuario(ya que es autoincrementable). Cuando por ejemplo se desea hacer un INSERT, se necesitan estas columnas ya que id_usuario en la db es la primary key y ademas es autoincrementable
    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    //Constructor para cuando por ejemplo se desea modificar UPDATE la informacion de un registro en especifico
    public Usuario(int idUsuario, String usuario, String password) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
    }
    
    //Métodos get y set por si se desea modificar UPDATE un atributo de manera individual
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Metodo toString para poder mandar a imprimir el estado del objeto  en cualquier momento
    @Override
    public String toString() {
        return "Persona{" + "idUsuario=" + idUsuario + ", usuario=" + usuario + ", password=" + password + '}';
    }
}
