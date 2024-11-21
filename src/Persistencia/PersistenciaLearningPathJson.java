package Persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Path.Actividad;
import Path.LearningPath;
import Retroalimentacion.Rating;

public class PersistenciaLearningPathJson implements IPersistenciaLearningPath {

    @SuppressWarnings("unchecked")
	@Override
    public void cargarLearningPath(String archivo, LearningPath learningPath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
      
            Object obj = ois.readObject();
            if (obj instanceof Map) {
                Map<String, Object> data = (Map<String, Object>) obj;

                // Cargar atributos de LearningPath
                learningPath.setTitulo((String) data.get("titulo"));
                learningPath.setDuracionEnMinutos((Integer) data.get("duracionEnMinutos"));
                learningPath.setDescripcion((String) data.get("descripcion"));
                learningPath.setNivelDeDificultad((String) data.get("nivelDeDificultad"));
                learningPath.setVersion((String) data.get("version"));
                learningPath.setUltimaFechaDeModificacion(new Date((Long) data.get("ultimaFechaDeModificacion")));
                learningPath.setFechaDeCreacion(new Date((Long) data.get("fechaDeCreacion")));

              
                Object actividadesObj = data.get("actividades");
                List<Map<String, Object>> actividades = new ArrayList<>();
                if (actividadesObj instanceof List) {
                    List<?> actividadesList = (List<?>) actividadesObj;
                    for (Object actividadObj : actividadesList) {
                        if (actividadObj instanceof Map) {
                            actividades.add((Map<String, Object>) actividadObj);
                        }
                    }
                }
                learningPath.setActividades(null); 

               
                Object ratingsObj = data.get("ratings");
                List<Map<String, Object>> ratings = new ArrayList<>();
                if (ratingsObj instanceof List) {
                    List<?> ratingsList = (List<?>) ratingsObj;
                    for (Object ratingObj : ratingsList) {
                        if (ratingObj instanceof Map) {
                            ratings.add((Map<String, Object>) ratingObj);
                        }
                    }
                }
                learningPath.setRatings(null);  

                learningPath.setRatingPromedio((Double) data.get("ratingPromedio"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void salvarLearningPath(String archivo, LearningPath learningPath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            Map<String, Object> data = new HashMap<>();

            // Guardar atributos de LearningPath
            data.put("titulo", learningPath.getTitulo());
            data.put("duracionEnMinutos", learningPath.getDuracionEnMinutos());
            data.put("descripcion", learningPath.getDescripcion());
            data.put("nivelDeDificultad", learningPath.getNivelDeDificultad());
            data.put("version", learningPath.getVersion());
            data.put("ultimaFechaDeModificacion", learningPath.getUltimaFechaDeModificacion().getTime());
            data.put("fechaDeCreacion", learningPath.getFechaDeCreacion().getTime());

            // Guardar actividades como un mapa de atributos
            List<Map<String, Object>> actividadesData = new ArrayList<>();
            for (Actividad actividad : learningPath.getActividades()) {
                Map<String, Object> actividadData = new HashMap<>();
                actividadData.put("descripcion", actividad.getDescripcion());
                actividadData.put("objetivo", actividad.getObjetivo());
                actividadData.put("nivel", actividad.getNivel());
                actividadData.put("tiempoEstimado", actividad.getTiempoEstimado());
                actividadData.put("obligatorio", actividad.isObligatorio());
                actividadData.put("fechaLimite", actividad.getFechaLimite());
                actividadData.put("tipo", actividad.getTipo());
                actividadData.put("fechaLimiteDate", actividad.getFechaLimiteDate().getTime());
                actividadData.put("resultado", actividad.isResultado());
                actividadData.put("tiempoDedicado", actividad.getTiempoDedicado());
                actividadData.put("estado", actividad.getEstado());
                
                actividadesData.add(actividadData);
            }
            data.put("actividades", actividadesData);

            // Guardar ratings como un mapa de atributos
            List<Map<String, Object>> ratingsData = new ArrayList<>();
            for (Rating rating : learningPath.getRatings()) {
                Map<String, Object> ratingData = new HashMap<>();
                ratingData.put("numero", rating.getNumero());
           
                ratingsData.add(ratingData);
            }
            data.put("ratings", ratingsData);

            data.put("ratingPromedio", learningPath.getRatingPromedio());

            oos.writeObject(data);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
