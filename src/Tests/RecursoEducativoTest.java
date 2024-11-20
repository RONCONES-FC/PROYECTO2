package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Path.Actividad;
import Path.Encuesta;
import Path.PreguntaAbierta;
import Path.RecursoEducativo;
import Retroalimentacion.Rating;
import Retroalimentacion.Resena;

class RecursoEducativoTest {
	private RecursoEducativo RecursoEducativo1;
	@BeforeEach
	void setUp() throws Exception {
		
		  	SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
	        String descripcion = "Introduccion a eclipse";
	        String objetivo = "Familiarizar al estudiante con el programa";
	        String nivel = "Basico";
	        int tiempoEstimado = 5;
	        boolean obligatorio = true;
	        Date fechaLimiteDate = fecha.parse("2024-10-30");
	        boolean resultado = false;
	        double tiempoDedicado = 0.0; 
	        List<Rating> ratings = new ArrayList<>();
	        List<Resena> resenas = new ArrayList<>(); 
	        String estado = "sin empezar";
	        List<Actividad> actividadesPrevias = new ArrayList<>();
	        String material = "Inicio en Eclipse";
	        String tipoMaterial = "PDF";
	        
	 
	        RecursoEducativo1 = new RecursoEducativo(
	            descripcion,
	            objetivo,
	            nivel,
	            obligatorio,
	            "Recurso Educativo",
	            fechaLimiteDate,
	            resultado,
	            tiempoDedicado,
	            ratings,
	            resenas,
	            estado,
	            actividadesPrevias, 
	            tipoMaterial,
	            material
	        );
	}

	
	@Test
	void testGetTipoMaterial() {
		String respuesta = "PDF";
		assertEquals(RecursoEducativo1.getTipoMaterial(),respuesta, "El tipo de material no coincide");
		
	}
	
	void testSetTipoMaterial() {
		String respuesta = "Video";
		RecursoEducativo1.setTipoMaterial("Video");
		assertEquals(RecursoEducativo1.getTipoMaterial(),respuesta, "El tipo de material no se asigno correctamente");
		
	}
	
	@Test
	void testGetMaterial() {
		String respuesta = "Inicio en Eclipse";
		assertEquals(RecursoEducativo1.getTipoMaterial(),respuesta, "El material no coincide");
		
	}
	
	void testSetMaterial() {
		String respuesta = "Instalacion Eclipse";
		RecursoEducativo1.setTipoMaterial("Instalacion Eclipse");
		assertEquals(RecursoEducativo1.getTipoMaterial(),respuesta, "El material no se asigno correctamente");
		
	}
	
	@Test
	void testMarcarCompleto() {
		RecursoEducativo1.marcarCompleto();
		assertEquals(RecursoEducativo1.getTipo(),"completo", "El material no coincide");
		
	}
	

}
