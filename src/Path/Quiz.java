package Path;

import java.util.Date;
import java.util.List;

import Retroalimentacion.Rating;
import Retroalimentacion.Resena;

public abstract class Quiz extends Actividad {
	
	 	protected int calificacionMinima;
	    protected boolean esSatisfactorio = false;
	    protected int puntos = 0;
	    protected List<Pregunta> preguntas;
	 

	    public Quiz(String descripcion, String objetivo, String nivel, int tiempoEstimado, boolean obligatorio,
				int fechaLimite, String tipo, Date fechaLimiteDate, boolean resultado, double tiempoDedicado,
				List<Rating> ratings, List<Resena> resenas, String estado, List<Actividad> actividadesPrevias,
				int calificacionMinima, boolean esSatisfactorio, int puntos, List<Pregunta> preguntas) {
			super(descripcion, objetivo, nivel, obligatorio, tipo, fechaLimiteDate, resultado,
					tiempoDedicado, ratings, resenas, estado, actividadesPrevias);
			this.calificacionMinima = calificacionMinima;
			this.esSatisfactorio = esSatisfactorio;
			this.puntos = 0;
			this.preguntas = preguntas;
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
		
		//ActualizarPuntos

   
}
