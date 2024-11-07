package Consola;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Usuario.Usuario;

public abstract class ConsolaBasica {
	protected List<Usuario> usuarios;
	
	public ConsolaBasica(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
	
	protected Usuario autenticar() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese su usuario: ");
        String username = scanner.nextLine();
        
        System.out.print("Ingrese su contraseña: ");
        String password = scanner.nextLine();
        
        Usuario usuarioAutenticado = Usuario.autenticarUsuario(username, password, usuarios);
        
        if (usuarioAutenticado != null) {
            System.out.println("Autenticación exitosa. Bienvenido, " + usuarioAutenticado.getUsuario());
            return usuarioAutenticado;
        } else {
            System.out.println("Error: Usuario o contraseña incorrectos.");
            return null;
        }
    }

    // Método abstracto que cada consola específica debe implementar
    public abstract void ejecutar();{

}

public static void main(String[] args) {
    // Crear una lista de usuarios con usuario y contraseña
    List<Usuario> usuarios = new ArrayList<>();
    usuarios.add(new Usuario("estudiante1", "pass123"));
    usuarios.add(new Usuario("profesor1", "profpass"));

    // Pedir al usuario que elija una consola
    Scanner scanner = new Scanner(System.in);
    System.out.println("Seleccione la consola:");
    System.out.println("1. Verificar Estudiante");
    System.out.println("2. Seguir Progreso del Profesor");
    System.out.println("3. Crear Learning Path (Profesor)");

    int opcion = scanner.nextInt();

    // Según la opción, ejecutamos la consola correspondiente
    switch (opcion) {
        case 1:
            ConsolaEstudiante consolaEstudiante = new ConsolaEstudiante(usuarios);
            consolaEstudiante.ejecutar();
            break;
        case 2:
            // Aquí instanciarías ConsolaSeguirProgresoProfesor
            // Ejemplo: ConsolaSeguirProgresoProfesor consolaProgreso = new ConsolaSeguirProgresoProfesor(usuarios);
            // consolaProgreso.ejecutar();
            break;
        case 3:
            // Aquí instanciarías ConsolaCrearLearningPath
            // Ejemplo: ConsolaCrearLearningPath consolaCrear = new ConsolaCrearLearningPath(usuarios);
            // consolaCrear.ejecutar();
            break;
        default:
            System.out.println("Opción no válida.");
            break;
    }

    scanner.close();
}
}



