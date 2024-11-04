package Persistencia;

public class CentralPersistencia {

    public static final String JSON = "JSON";
    public static final String PLAIN = "PlainText";

    // Método para obtener la persistencia de usuarios
    public static IPersistenciaUsuario getPersistenciaUsuario(String tipoArchivo) {
        if (JSON.equals(tipoArchivo)) {
            return new PersistenciaUsuarioJson();
        } else if (PLAIN.equals(tipoArchivo)) {
            return new PersistenciaUsuarioPlaintext();
        } else {
            throw new IllegalArgumentException("Tipo de archivo no soportado: " + tipoArchivo);
        }
    }

    // Método para obtener la persistencia de LearningPaths
    public static IPersistenciaLearningPath getPersistenciaLearningPath(String tipoArchivo) {
        if (JSON.equals(tipoArchivo)) {
            return new PersistenciaLearningPathJson();
        } else if (PLAIN.equals(tipoArchivo)) {
            return new PersistenciaLearningPathPlainText();
        } else {
            throw new IllegalArgumentException("Tipo de archivo no soportado: " + tipoArchivo);
        }
    }
}

