package Usuario;

import java.util.ArrayList;
import java.util.List;

import Path.Actividad;
import Path.LearningPath;

public class Usuario {
	protected String usuario;
    protected String contrasena;
    public static List<LearningPath> learningPaths = new ArrayList<>();
    
	public Usuario(String usuario, String contrasena) {
		super();
		this.usuario = usuario;
		this.contrasena = contrasena;
	}

	public static List<LearningPath> getLearningPaths() {
		return learningPaths;
	}

	public static void setLearningPaths(List<LearningPath> learningPaths) {
		Usuario.learningPaths = learningPaths;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public void dejarRating(double rating, Actividad actividad) {
		//implementar
	}
	
	public void dejarResena(String resena, Actividad actividad) {
		//implementar
	}
	  
	
	protected boolean cambiarClave(String actual, String nueva) {
        if (this.contrasena.equals(actual)) {
            this.contrasena = nueva;
            return true;
        } else {
            return false; 
        }
    }
	  
    
    
}
