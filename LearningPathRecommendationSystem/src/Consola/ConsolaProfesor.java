package Consola;

import java.util.List;
import Usuario.Usuario;
import Usuario.Profesor;

public class ConsolaProfesor extends ConsolaBasica {

    // Constructor que llama al constructor de la clase base ConsolaBasica
    public ConsolaProfesor(List<Usuario> usuarios) {
        super(usuarios); // Llama al constructor de ConsolaBasica con la lista de usuarios
    }

    @Override
    public void ejecutar() {
        Usuario usuario = autenticar(); // Llama al método de autenticación
        if (usuario != null) {
            // Verificamos que el usuario sea una instancia de Profesor antes de continuar
            if (usuario instanceof Profesor) {
                System.out.println("Bienvenido, Profesor " + usuario.getUsuario() + ". Mostrando el progreso de los estudiantes en los Learning Paths.");
                // Aquí puedes agregar la lógica para mostrar el progreso de los estudiantes en los Learning Paths
            } else {
                System.out.println("Acceso denegado: solo los profesores pueden acceder a esta consola.");
            }
        }
    }
}
