package datos;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import domain.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vafla
 * DAO Data Acces Object: contiene las operacionesa realizar sobre la clase de entidad
 * SELECT, INSERT, UPDATE, DELETE sobre la tabla de entidad, la clase Usuario y se refleja en la DB
 * 
Patrón de diseño DAO sobre la clase de entidad Usuario
* Una clase DAO se asocia a una clase de entidad
 */
public class UsuarioDAO {
    
    //Las sentencias se definen al inicio de la clase, es una buena practica
    //Este SELECT es para recuperar todas las columnas de la tabla
    private static final String SQL_SELECT = "SELECT id_usuario, usuario, password FROM usuario";
    
    //Cada ? sera un valor que se ingresara para cada columna (usuario, password)
    private static final String SQL_INSERT = "INSERT INTO usuario(usuario, password) VALUES(?, ?)";
    
    private static final String SQL_UPDATE = "UPDATE usuario SET usuario = ?, password = ? WHERE id_usuario = ?";
    
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario = ?";
    
    //Metodo que va a regresar una lista de objetos (generica) de tipo Usuario
    public List<Usuario> seleccionar(){
        //Se inicializan en null para luego poder utilizar un finally
        Connection conexxion = null;
        PreparedStatement sentencia = null;
        ResultSet resultadoSet = null;
        Usuario username = null; //cada renglón se va a convertir en un objeto de tipo Usuario
        List<Usuario> usuarios = new ArrayList<>(); //se inicializar utilizando el tipo ArrayList indicando que es un tipo generico <> de tipo Usuario
        
        try {
            //Conexion a la DB
            conexxion = getConnection();
            //ejecutar sentencias sobre la tabla de DB.
            sentencia = conexxion.prepareStatement(SQL_SELECT);
            //Se ejecuta la instruccion
            resultadoSet = sentencia.executeQuery();
            
            while(resultadoSet.next()){
                int idUsuario = resultadoSet.getInt("id_usuario");
                String usuario = resultadoSet.getString("usuario");
                String password = resultadoSet.getString("password");
                
                username = new Usuario();//se usa el constructor que se requiera, en este caso sera el constructor con todos lo atributos
                username.setIdUsuario(idUsuario);
                username.setUsuario(usuario);
                username.setPassword(password);
                
                usuarios.add(username);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(resultadoSet);
                close(sentencia);
                close(conexxion);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return usuarios;
    }
    
    //nos va a indicar cuantos registros se han modificado, por eso regresa un entero
    public int insertar(Usuario username){
        
        Connection conexxion = null;
        PreparedStatement sentencia = null;
        int registros = 0;
        
        try {
            conexxion = Conexion.getConnection();
            sentencia = conexxion.prepareStatement(SQL_INSERT);
            //sustituir cada uno de los parametros
            sentencia.setString(1, username.getUsuario()); //esta linea sustituye el parametro 1 ? (primer ?  de SQL_INSERT), que es el campo usuario
            sentencia.setString(2, username.getPassword());
            
            //ejecutar la sentencia y regresara el numero de registros que fueron afectados
            registros = sentencia.executeUpdate();
            
            System.out.println("Registros insertados: " + registros);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(sentencia);//se puede hacer un import static para no tener que colocar la clase sino llamar directamente el metodo y quedaria close(sentencia)
                close(conexxion);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
            
        return registros;
    }
    
    public int actualizar(Usuario username){
        
        Connection conexxion = null;
        PreparedStatement sentencia = null;
        int registros = 0;
        
        try {
            conexxion = Conexion.getConnection();
            sentencia = conexxion.prepareStatement(SQL_UPDATE);
            sentencia.setString(1, username.getUsuario());
            sentencia.setString(2, username.getPassword());
            sentencia.setInt(3, username.getIdUsuario());
            
            registros = sentencia.executeUpdate();
            
            System.out.println("Registros actualizados: " + registros);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                Conexion.close(sentencia);
                Conexion.close(conexxion);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
            
        return registros;
    }
    
    public int eliminar(Usuario username){
        
        Connection conexxion = null;
        PreparedStatement sentencia = null;
        int registros = 0;
        
        try {
            conexxion = Conexion.getConnection();
            sentencia = conexxion.prepareStatement(SQL_DELETE);
            sentencia.setInt(1, username.getIdUsuario());
            
            registros = sentencia.executeUpdate();
            
            System.out.println("Registros eliminados: " + registros);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(sentencia);
                close(conexxion);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
            
        return registros;
    }
}
