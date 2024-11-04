package Path;

import java.util.Date;
import java.util.List;

import Retroalimentacion.Rating;
import Retroalimentacion.Resena;

public class Examen extends Actividad{
	
	private final String tipo = "Examen";
    private List<PreguntaAbierta> preguntas;
    private List<String> respuestas;
    
    
    
	public Examen(String descripcion, String objetivo, String nivel, int tiempoEstimado, boolean obligatorio,
			int fechaLimite, String tipo, Date fechaLimiteDate, boolean resultado, double tiempoDedicado,
			List<Rating> ratings, List<Resena> resenas, String estado, List<Actividad> actividadesPrevias,
			List<PreguntaAbierta> preguntas) {
		super(descripcion, objetivo, nivel, tiempoEstimado, obligatorio, fechaLimite, tipo, fechaLimiteDate, resultado,
				tiempoDedicado, ratings, resenas, estado, actividadesPrevias);
		this.preguntas = preguntas;
		this.respuestas = null;
	
	}


	public List<PreguntaAbierta> getPreguntas() {
		return preguntas;
	}


	public void setPreguntas(List<PreguntaAbierta> preguntas) {
		this.preguntas = preguntas;
	}

	public String getTipo() {
		return tipo;
	}
	
	public List<String> getRespuestas(){
		return respuestas;
	}
    
	public void enviarRespuestas(List<String> respuestas) {
		this.respuestas = respuestas;
		this.setEstado("completo");
	}

}