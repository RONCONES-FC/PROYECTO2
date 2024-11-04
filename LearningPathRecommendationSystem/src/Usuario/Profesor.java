package Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Path.Actividad;
import Path.LearningPath;
import Path.Progreso;
import Path.RecursoEducativo;
import Retroalimentacion.Rating;
import Retroalimentacion.Resena;

public class Profesor extends Usuario {
    private List<Actividad> actividadesCreadas;
    private List<LearningPath> learningPathsCreados;

    public Profesor(String usuario, String contrasena, List<Actividad> actividadesCreadas, List<LearningPath> learningPathsCreados) {
        super(usuario, contrasena);
        this.actividadesCreadas = actividadesCreadas;
        this.learningPathsCreados = learningPathsCreados;
    }

    public List<Actividad> getActividadesCreadas() {
        return actividadesCreadas;
    }

    public void setActividadesCreadas(List<Actividad> actividadesCreadas) {
        this.actividadesCreadas = actividadesCreadas;
    }

    public List<LearningPath> getLearningPathsCreados() {
        return learningPathsCreados;
    }

    public void setLearningPathsCreados(List<LearningPath> learningPathsCreados) {
        this.learningPathsCreados = learningPathsCreados;
    }

    public LearningPath crearLearningPath(String titulo, int duracionEnMinutos, String descripcion, String nivelDeDificultad,
                                          String version, Date ultimaFechaDeModificacion, Progreso progreso,
                                          List<Actividad> actividades, Date fechaDeCreacion, List<Rating> ratings,
                                          double ratingPromedio) {

        LearningPath path = new LearningPath(titulo, duracionEnMinutos, descripcion, nivelDeDificultad, version,
                ultimaFechaDeModificacion, progreso, actividades, fechaDeCreacion,
                ratings, ratingPromedio);
        learningPathsCreados.add(path);
        return path;
    }



    // Crear actividad utilizando el constructor de RecursoEducativo
    public RecursoEducativo crearActividad(String descripcion, String objetivo, String nivel, int tiempo, boolean obligatorio, Date fechaLimite, String tipoMaterial) {
        RecursoEducativo recurso = new RecursoEducativo(descripcion, objetivo, nivel, tiempo, obligatorio, tiempo, tipoMaterial, fechaLimite, obligatorio, tiempo, null, null, "incompleto", actividadesCreadas, tipoMaterial);
        actividadesCreadas.add(recurso);
        return recurso;
    }

    public Progreso verProgresoEstudiante(Estudiante estudiante, LearningPath path) {
        return estudiante.verProgreso(path);
    }

    // Clonar actividad utilizando RecursoEducativo
    public RecursoEducativo clonarActividad(RecursoEducativo recurso) {
        RecursoEducativo copia = new RecursoEducativo(
                recurso.getDescripcion(),
                recurso.getObjetivo(),
                recurso.getNivel(),
                recurso.getTiempoEstimado(),
                recurso.isObligatorio(),
                recurso.getFechaLimite(),
                recurso.getTipoMaterial(),
                recurso.getFechaLimiteDate(),
                recurso.isResultado(),
                recurso.getTiempoDedicado(),
                new ArrayList<>(recurso.getRatings()),
                new ArrayList<>(recurso.getResenas()),
                recurso.getEstado(),
                new ArrayList<>(recurso.getActividadesPrevias()),
                recurso.getTipoMaterial()
        );
        return copia;
    }

    public void agregarActividad(Actividad actividad, LearningPath path) {
        List<Actividad> actividades = path.getActividades();
        actividades.add(actividad);
        path.setActividades(actividades);
    }

    public void reordenarPath(LearningPath path, Actividad actividadPorCambiar, int pos) {
        List<Actividad> actividades = path.getActividades();
        actividades.remove(actividadPorCambiar);
        if (pos < 0) {
            pos = 0;
        } else if (pos > actividades.size()) {
            pos = actividades.size() - 1;
        }

        actividades.add(pos, actividadPorCambiar);
        path.setActividades(actividades);
    }

    public void revisarActividad(Actividad actividad, String resultado) {
        actividad.setEstado(resultado);
    }

    public List<Resena> verResenas(Actividad actividad) {
        return actividad.getResenas();
    }
}
