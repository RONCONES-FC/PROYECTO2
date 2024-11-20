package Path;

import java.util.List;

public class PreguntaCerrada extends Pregunta {

	private List<String> opciones;
    private int respuesta;
    private List<String> explicaciones;
    private int punto;
    
    
	public PreguntaCerrada(String enunciado, List<String> opciones, int respuesta, List<String> explicaciones, int punto, int puntos) {
		super(enunciado, puntos);
		this.opciones = opciones;
		this.respuesta = respuesta;
		this.explicaciones = explicaciones;
		this.punto = punto;
	}


	public List<String> getOpciones() {
		return opciones;
	}


	public void setOpciones(List<String> opciones) {
		this.opciones = opciones;
	}


	public int getRespuesta() {
		return respuesta;
	}


	public void setRespuesta(int respuesta) {
		this.respuesta = respuesta;
	}


	public List<String> getExplicaciones() {
		return explicaciones;
	}


	public void setExplicaciones(List<String> explicaciones) {
		this.explicaciones = explicaciones;
	}


	public int getPuntos() {
		return punto;
	}


	public void asignarPunto(int nuevoPunto) {
        this.punto = nuevoPunto;
    }
	
    
    
}
