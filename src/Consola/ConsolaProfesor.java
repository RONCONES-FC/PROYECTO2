package Consola;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import Usuario.Usuario;
import Usuario.Profesor;
public class ConsolaProfesor extends ConsolaBasica {
   // Constructor con parámetros
   public ConsolaProfesor(List<Usuario> usuarios, String nombreUsuario, String contrasena) {
       super();
       this.usuarios = usuarios;
       this.nombreUsuario = nombreUsuario;
       this.contrasena = contrasena;
   }
   // Constructor vacío
   public ConsolaProfesor() {
       super(); // Inicializa los atributos base
   }
   @Override
   public void correrAplicacion() {
       // Intentar autenticar al usuario
       Usuario usuario = autenticar(nombreUsuario, contrasena);
       if (usuario != null) {
           // Verificar si el usuario es de tipo Profesor
           if (usuario instanceof Profesor) {
               System.out.println("Bienvenido, Profesor " + usuario.getUsuario() + ". Mostrando el progreso de los estudiantes en los Learning Paths.");
               // Aquí puedes agregar lógica para mostrar detalles específicos del progreso de los estudiantes
           } else {
               System.out.println("Acceso denegado: solo los profesores pueden acceder a esta consola.");
           }
       } else {
           System.out.println("Error: Usuario no encontrado.");
           // Preguntar al usuario si desea añadirse como profesor
           BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
           try {
               System.out.print("¿Desea registrarse como un nuevo profesor? (sí/no): ");
               String respuesta = reader.readLine().trim().toLowerCase();
               if (respuesta.equals("sí") || respuesta.equals("si")) {
                   // Crear un nuevo profesor con las credenciales ingresadas
                   Profesor nuevoProfesor = new Profesor(nombreUsuario, contrasena);
                   agregarUsuario(nuevoProfesor, "Datos/usuarios.json"); // Guardar el nuevo profesor en el archivo JSON
                   System.out.println("Registro exitoso. Bienvenido al sistema, Profesor " + nombreUsuario + ".");
               } else {
                   System.out.println("El usuario no fue registrado. Cerrando sesión...");
               }
           } catch (IOException e) {
               System.out.println("Error al leer la entrada: " + e.getMessage());
           }
       }
   }
   public static void main(String[] args) {
       // Instancia genérica de ConsolaProfesor
       ConsolaProfesor consola = new ConsolaProfesor();
       consola.mostrarMenu(); // Llama al método de la clase base
   }
}
