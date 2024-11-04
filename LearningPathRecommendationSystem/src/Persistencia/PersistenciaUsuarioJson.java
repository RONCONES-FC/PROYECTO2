package Persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import Usuario.Usuario;

public class PersistenciaUsuarioJson implements IPersistenciaUsuario {

    @Override
    public void cargarUsuario(String archivo, Usuario usuario) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            Usuario data = (Usuario) ois.readObject();
            usuario.setUsuario(data.getUsuario());
            usuario.setContrasena(data.getContrasena());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void salvarUsuario(String archivo, Usuario usuario) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

