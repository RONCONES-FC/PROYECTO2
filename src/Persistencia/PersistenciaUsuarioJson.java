package Persistencia;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Usuario.Usuario;
public abstract class PersistenciaUsuarioJson implements IPersistenciaUsuario {
   @Override
   public final List<Usuario> cargarUsuarios(String archivo) {
       List<Usuario> usuarios = new ArrayList<>();
       try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
           StringBuilder jsonBuilder = new StringBuilder();
           String line;
           while ((line = reader.readLine()) != null) {
               jsonBuilder.append(line.trim());
           }
           String json = jsonBuilder.toString().trim();
           if (json.startsWith("[") && json.endsWith("]")) {
               json = json.substring(1, json.length() - 1).trim();
               String[] usuariosJson = json.split("},\\s*\\{");
               for (String usuarioJson : usuariosJson) {
                   Usuario usuario = procesarUsuarioJson(usuarioJson);
                   if (usuario != null) {
                       usuarios.add(usuario);
                   }
               }
           }
       } catch (IOException e) {
           System.out.println("Error al leer el archivo JSON: " + e.getMessage());
           e.printStackTrace();
       }
       return usuarios;
   }
   @Override
   public final void salvarUsuarios(String archivo, List<Usuario> usuarios) {
       try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
           writer.write("[\n");
           for (int i = 0; i < usuarios.size(); i++) {
               Usuario usuario = usuarios.get(i);
               writer.write(formatearUsuarioJson(usuario));
               if (i < usuarios.size() - 1) {
                   writer.write(","); // Separador
               }
               writer.write("\n");
           }
           writer.write("]");
       } catch (IOException e) {
           System.out.println("Error al guardar los usuarios en JSON: " + e.getMessage());
           e.printStackTrace();
       }
   }
   // Método abstracto para que las subclases personalicen cómo procesar un usuario desde JSON
   protected abstract Usuario procesarUsuarioJson(String usuarioJson);
   // Método abstracto para que las subclases personalicen cómo formatear un usuario en JSON
   protected abstract String formatearUsuarioJson(Usuario usuario);
}

