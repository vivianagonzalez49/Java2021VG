package test;

import datos.UsuarioDAO;
import domain.Usuario;
import java.util.List;

/**
 *
 * @author vafla
 */
public class TestManejoUsuarios {
    public static void main(String[] args) {
        
        UsuarioDAO usuarioDao = new UsuarioDAO();
        //Aqui se mostraria la informacion del metodo seleccionar. Fue un ejemplo, luego se usara en la otra parte del codigo
//        List<Usuario> usuarios = usuarioDao.seleccionar();
//        for(Usuario username: usuarios){
//            System.out.println("usuario = " + username);
//        }
//        usuarios.forEach(username -> {
//            System.out.println("username = " + username);
//        });


        //Insertar un nuevo objeto de tipo Usuario
//        Usuario usuarioNuevo = new Usuario("usertest", "userpass");
//        usuarioDao.insertar(usuarioNuevo);

        
        //Modificar un objeto de Usuario existente (registro)
//        Usuario usuarioModificar = new Usuario(1, "vgonzalez", "vgonZalez");
//        usuarioDao.actualizar(usuarioModificar);
        

        //Eliminar un objeto de Usuario existente
//        Usuario usuarioEliminar = new Usuario(3);
//        usuarioDao.eliminar(usuarioEliminar);
        
        
        List<Usuario> usuarios = usuarioDao.seleccionar();
        for(Usuario username: usuarios){
            System.out.println("usuario = " + username);
        }
        
    }
}
