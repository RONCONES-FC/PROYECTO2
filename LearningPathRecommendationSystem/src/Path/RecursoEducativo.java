package Path;

import java.util.Date;
import java.util.List;

import Retroalimentacion.Rating;
import Retroalimentacion.Resena;

public class RecursoEducativo extends Actividad {

	
	private final String tipo = "Recurso educativo";
    private String tipoMaterial;
    private List<String> recues;
    
	public RecursoEducativo(String descripcion, String objetivo, String nivel, int tiempoEstimado, boolean obligatorio, 
            int fechaLimite, String tipo, Date fechaLimiteDate, boolean resultado, double tiempoDedicado, 
            List<Rating> ratings, List<Resena> resenas, String estado, List<Actividad> actividadesPrevias, 
            String tipoMaterial){
		super(tipoMaterial, tipoMaterial, tipoMaterial, fechaLimite, obligatorio, fechaLimite, tipoMaterial, fechaLimiteDate, obligatorio, tiempoDedicado, ratings, resenas, tipoMaterial, actividadesPrevias);
		this.tipoMaterial = tipoMaterial;
		this.recues = null;
	}

	public String getTipoMaterial() {
		return tipoMaterial;
	}

	public void setTipoMaterial(String tipoMaterial) {
		this.tipoMaterial = tipoMaterial;
	}

	public String getTipo() { 
		return tipo;
	}
	
    
	public void marcarCompleto() {
		this.setEstado("completo");
    }
    
	public List<String> getRespuestas(){
		return recues;
	}
    
	public void enviarRespuestas(List<String> respuestas) {
		this.recues = respuestas;
		this.setEstado("completo");
	}
	
}
