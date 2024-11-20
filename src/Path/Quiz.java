package Path;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Retroalimentacion.Rating;
import Retroalimentacion.Resena;

public abstract class Quiz extends Actividad {
	
	 	protected int calificacionMinima;
	    protected boolean esSatisfactorio = false;
	    protected int puntos = 0;
	    protected List<PreguntaCerrada> preguntas;
	 

	    public Quiz(String descripcion, String objetivo, String nivel, int tiempoEstimado, boolean obligatorio,
				int fechaLimite, String tipo, Date fechaLimiteDate, boolean resultado, double tiempoDedicado,
				List<Rating> ratings, List<Resena> resenas, String estado, List<Actividad> actividadesPrevias,
				int calificacionMinima, boolean esSatisfactorio, int puntos, List<PreguntaCerrada> preguntas2) {
			super(descripcion, objetivo, nivel, obligatorio, tipo, fechaLimiteDate, resultado,
					tiempoDedicado, ratings, resenas, estado, actividadesPrevias);
			this.calificacionMinima = calificacionMinima;
			this.esSatisfactorio = esSatisfactorio;
			this.puntos = 0;
			this.preguntas = preguntas2;
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

		public void setEsSatisfactorio() {
			this.esSatisfactorio = true;
		}

		public int getPuntos() {
			return puntos;
		}

		public void setPuntos(int puntos) {
			this.puntos = puntos;
		}
	//Actualizar puntos
		public void ActualizarPuntos(List<Integer> respuestas) {
			if (respuestas.size() !=0 && preguntas.size()>respuestas.size()) {
				int dif = preguntas.size()-respuestas.size();
				while (dif>0) {
					respuestas.add(dif+respuestas.size()-1, 0);
					dif=dif-1;
				}
			}
			if (preguntas.size()<respuestas.size()) {
				int dif = -respuestas.size()-preguntas.size();
				while (dif>0) {
					respuestas.remove(dif-respuestas.size()-1);
					dif=dif-1;
				}
			}
				int cuenta =0;
				for (int i=0;i<preguntas.size();i++) {
					if (preguntas.get(i).getRespuesta() == respuestas.get(i)) {
						cuenta ++;
					}
					
				}
			this.setPuntos(cuenta);

				 
			if (cuenta >= calificacionMinima) {
				this.setEsSatisfactorio();	
		}
			
	}
	

   
}
