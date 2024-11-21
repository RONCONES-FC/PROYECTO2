package Persistencia;
import java.util.ArrayList;
import java.util.List;
import Usuario.Usuario;
public class PersistenciaUsuarioJsonConcreta extends PersistenciaUsuarioJson {
   @Override
   protected Usuario procesarUsuarioJson(String usuarioJson) {
       // Limpia los caracteres adicionales
       usuarioJson = usuarioJson.replace("{", "").replace("}", "").replace("\"", "").trim();
       String[] campos = usuarioJson.split(",");
       String nombreUsuario = null;
       String contrasena = null;
       // Divide los campos clave-valor
       for (String campo : campos) {
           String[] keyValue = campo.split(":");
           if (keyValue.length == 2) {
               String key = keyValue[0].trim();
               String value = keyValue[1].trim();
               if (key.equals("nombreUsuario")) {
                   nombreUsuario = value;
               } else if (key.equals("contrasena")) {
                   contrasena = value;
               }
           }
       }
       // Crea un nuevo objeto Usuario si los datos son válidos
       if (nombreUsuario != null && contrasena != null) {
           return new Usuario(nombreUsuario, contrasena);
       }
       return null;
   }
   @Override
   protected String formatearUsuarioJson(Usuario usuario) {
       // Formatea un objeto Usuario como JSON
       return String.format("    {\n        \"nombreUsuario\": \"%s\",\n        \"contrasena\": \"%s\"\n    }",
               usuario.getUsuario(), usuario.getContrasena());
   }
   @Override
   public void cargarUsuario(String archivo, Usuario usuario) {
       List<Usuario> usuarios = cargarUsuarios(archivo);
       if (!usuarios.isEmpty()) {
           Usuario primero = usuarios.get(0);
           usuario.setUsuario(primero.getUsuario());
           usuario.setContrasena(primero.getContrasena());
       } else {
           System.out.println("El archivo no contiene usuarios.");
       }
   }
   @Override
   public void salvarUsuario(String archivo, Usuario usuario) {
       List<Usuario> usuarios = new ArrayList<>();
       usuarios.add(usuario);
       salvarUsuarios(archivo, usuarios);
   }
}


