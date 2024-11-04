package Path;

import java.util.Date;
import java.util.List;

import Retroalimentacion.Rating;
import Retroalimentacion.Resena;

public class Quiz extends Actividad {
	
	private final String tipo = "Quiz";
    private int calificacionMinima;
    private boolean esSatisfactorio;
    private int puntos;
    private List<PreguntaCerrada> preguntas;
    private List<Integer> respuestasCorrectas;

    public Quiz(String descripcion, String objetivo, String nivel, int tiempoEstimado, boolean obligatorio,
			int fechaLimite, String tipo, Date fechaLimiteDate, boolean resultado, double tiempoDedicado,
			List<Rating> ratings, List<Resena> resenas, String estado, List<Actividad> actividadesPrevias,
			int calificacionMinima, boolean esSatisfactorio, int puntos, List<PreguntaCerrada> preguntas,
			List<Integer> respuestasCorrectas) {
		super(descripcion, objetivo, nivel, tiempoEstimado, obligatorio, fechaLimite, tipo, fechaLimiteDate, resultado,
				tiempoDedicado, ratings, resenas, estado, actividadesPrevias);
		this.calificacionMinima = calificacionMinima;
		this.esSatisfactorio = esSatisfactorio;
		this.puntos = puntos;
		this.preguntas = preguntas;
		this.respuestasCorrectas = respuestasCorrectas; 
	}

    public int getCalificacionMinima() {
		return calificacionMinima;
	}

	public void setCalificacionMinima(int calificacionMinima) {
		this.calificacionMinima = calificacionMinima;
	}

	public boolean isEsSatisfactorio() {
		return esSatisfactorio;
	}

	public void setEsSatisfactorio(boolean esSatisfactorio) {
		this.esSatisfactorio = esSatisfactorio;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public List<PreguntaCerrada> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<PreguntaCerrada> preguntas) {
		this.preguntas = preguntas;
	}

	public List<Integer> getRespuestasCorrectas() {
		return respuestasCorrectas;
	}

	public void setRespuestasCorrectas(List<Integer> respuestasCorrectas) {
		this.respuestasCorrectas = respuestasCorrectas;
	}

	public String getTipo() {
		return tipo;
	}

    public void enviarRespuestas(List<Integer> respuestasSeleccionadas) {
        actualizarPuntos(respuestasSeleccionadas);
        if (this.puntos >= this.calificacionMinima) {
            this.esSatisfactorio = true;
        } else {
            this.esSatisfactorio = false;
        }
    }

    private void actualizarPuntos(List<Integer> respuestasSeleccionadas) {
        this.puntos = 0;
        for (int i = 0; i < preguntas.size(); i++) {
            if (respuestasSeleccionadas.get(i).equals(respuestasCorrectas.get(i))) {
                this.puntos += preguntas.get(i).getPuntos(); 
            }
        }
    }
}
