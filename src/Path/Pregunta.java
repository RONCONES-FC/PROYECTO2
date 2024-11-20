package Path;

public abstract class Pregunta {

	
	protected String enunciado;
	protected int puntos; 

	public Pregunta(String enunciado, int puntos) {
		this.enunciado = enunciado;
		this.puntos = puntos; 
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	
	
	
}
