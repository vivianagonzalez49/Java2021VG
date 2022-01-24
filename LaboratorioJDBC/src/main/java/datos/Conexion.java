package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author vafla
 */
public class Conexion {
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/testlabjdbc?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    
    //establecer user y pass para la conexion
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "admin";
    
    //Metodo para establecer la conexion
    public static Connection getConnection() throws SQLException{
        //2. Establecer conexión. Con la clase DriverManager se trae el metodo getConnection y se pasan los parametros, url (la url), el user y pass
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }
    
    //Metodos para cerrar la conexion
    
    //Con este metodo se ejecuta una query
    public static void close(ResultSet resultadoSet) throws SQLException{
        resultadoSet.close();
    }
    
    //Statement y PreparedStatement (Van a permitir ejecutar sentencias sobre la tabla de DB) funcionan igual pero PreparedStatement tiene un mejor performance  que el objeto statement
    public static void close(Statement sentencia) throws SQLException{
        sentencia.close();
    }
    
    public static void close(PreparedStatement sentencia) throws SQLException{
        sentencia.close();
    }
    
    //cierre de conexion
    public static void close(Connection conexxion) throws SQLException{
        conexxion.close();
    }
}
