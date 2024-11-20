package Path;

public class PreguntaAbierta extends Pregunta {

	

	private int extensionMaxima;
	
	public PreguntaAbierta(String enunciado, int extensionMaxima) {
		super(enunciado, extensionMaxima);
		this.extensionMaxima = extensionMaxima;
	}

	public int getExtensionMaxima() {
		return extensionMaxima;
	}

	public void setExtensionMaxima(int extensionMaxima) {
		this.extensionMaxima = extensionMaxima;
	}
	
	
}
