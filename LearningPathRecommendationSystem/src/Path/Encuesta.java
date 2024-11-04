package Path;

import java.util.Date;
import java.util.List;

import Retroalimentacion.Rating;
import Retroalimentacion.Resena;

public class Encuesta extends Actividad{
	
	private final String tipo = "Encuesta";
    private List<PreguntaAbierta> preguntas;
    private List<String> respuestaEncuesta;
    
    
	public Encuesta(String descripcion, String objetivo, String nivel, int tiempoEstimado, boolean obligatorio,
			int fechaLimite, String tipo, Date fechaLimiteDate, boolean resultado, double tiempoDedicado,
			List<Rating> ratings, List<Resena> resenas, String estado, List<Actividad> actividadesPrevias,
			List<PreguntaAbierta> preguntas, List<String> respuestaEncuesta) {
		super(descripcion, objetivo, nivel, tiempoEstimado, obligatorio, fechaLimite, tipo, fechaLimiteDate, resultado,
				tiempoDedicado, ratings, resenas, estado, actividadesPrevias);
		this.preguntas = preguntas;
		this.respuestaEncuesta = null;
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

	public List<String> getRespuestaEncuesta() {
		return respuestaEncuesta;
	}

	
	public void enviarRespuestas(List<String> respuestas) {
		this.respuestaEncuesta = respuestas;
		this.setEstado("completo");
	}
	
}
