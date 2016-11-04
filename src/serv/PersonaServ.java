package serv;

import java.util.List;

import daoi.PersonaDAOI;

import model.Persona;

public class PersonaServ extends PersonaDAOI  {

	@Override
	public Persona insertar(Persona obj) throws Exception {
		// TODO Auto-generated method stub
		return super.insertar(obj);
	}

	@Override
	public List<Persona> listar() throws Exception {
		// TODO Auto-generated method stub
		return super.listar();
	}

	@Override
	public List<Persona> buscar(Persona obj) throws Exception {
		// TODO Auto-generated method stub
		return super.buscar(obj);
	}

	@Override
	public void eliminar(Persona obj) throws Exception {
		super.eliminar(obj);
		
	}
	
	@Override
	public Persona obtener(Persona obj) throws Exception {
		return super.obtener(obj);
		
	}


	@Override
	public void actualizar(Persona obj) throws Exception {
		// TODO Auto-generated method stub
		super.actualizar(obj);
	}

}
