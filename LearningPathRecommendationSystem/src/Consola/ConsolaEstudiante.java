package Consola;

import java.util.List;
import Usuario.Usuario;

public class ConsolaEstudiante extends ConsolaBasica {

    // Constructor que llama al constructor de la clase base ConsolaBasica
    public ConsolaEstudiante(List<Usuario> usuarios) {
        super(usuarios); // Llama al constructor de ConsolaBasica con la lista de usuarios
    }

    @Override
    public void ejecutar() {
        Usuario usuario = autenticar(); // Llama al método de autenticación
        if (usuario != null) {
            // Lógica específica para verificar la información del estudiante
            System.out.println("Mostrando información del estudiante: " + usuario.getUsuario());
            // Aquí puedes agregar el código para mostrar detalles específicos del estudiante
        }
    }
}
