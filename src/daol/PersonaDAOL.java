package daol;

import java.util.List;

import model.Persona;

public interface PersonaDAOL {

	public abstract Persona insertar(Persona obj) throws Exception;
	public abstract List<Persona> listar() throws Exception;
	public abstract List<Persona> buscar(Persona obj) throws Exception;
	public abstract void eliminar(Persona obj) throws Exception;
	public abstract void actualizar(Persona obj) throws Exception;
	public abstract Persona obtener(Persona obj) throws Exception;
}
