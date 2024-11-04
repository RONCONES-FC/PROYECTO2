package Path;

public class Tarea {
	
	private boolean envio;
    private final String tipo = "Tarea";
    private String medioEnvio;
    
	public Tarea(boolean envio, String medioEnvio) {
		super();
		this.envio = envio;
		this.medioEnvio = medioEnvio;
	}

	public boolean isEnvio() {
		return envio;
	}

	public void setEnvio(boolean envio) {
		this.envio = envio;
	}

	public String getMedioEnvio() {
		return medioEnvio;
	}

	public void setMedioEnvio(String medioEnvio) {
		this.medioEnvio = medioEnvio;
	
		if(medioEnvio != null && !medioEnvio.isEmpty());
			this.envio = true;
	}

	public String getTipo() {
		return tipo;
	}
	
	

    
}
