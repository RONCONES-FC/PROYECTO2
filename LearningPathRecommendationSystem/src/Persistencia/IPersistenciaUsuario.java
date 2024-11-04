package Persistencia;

import Usuario.Usuario;

public interface IPersistenciaUsuario {
	void cargarUsuario(String archivo, Usuario usuario);
    void salvarUsuario(String archivo, Usuario usuario);

}
