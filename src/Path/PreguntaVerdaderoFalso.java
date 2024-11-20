package Path;


public class PreguntaVerdaderoFalso extends Pregunta{
	
	public PreguntaVerdaderoFalso(String enunciado, int puntos, boolean respuesta) {
		super(enunciado, puntos);
		this.respuesta = respuesta; 
	}
	private boolean respuesta;
	
	public boolean isRespuesta() {
		return respuesta;
	}
	public void setRespuesta(boolean respuesta) {
		this.respuesta = respuesta;
	}
	
	public void AsignarPuntos (boolean respuestaUsuario) {
		if (respuestaUsuario == respuesta) {
			puntos=1;
		}
		
	}
	

}
