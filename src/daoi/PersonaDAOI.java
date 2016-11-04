package daoi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import daol.PersonaDAOL;
import model.Persona;
import util.Conexion;

public class PersonaDAOI implements PersonaDAOL {
 Conexion cn = new Conexion();
	@Override
	public Persona insertar(Persona p) throws Exception {
		
		cn.abrir();
		try {
			cn.em.getTransaction().begin();
			cn.em.persist(p);
			cn.em.flush();
			cn.em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			cn.em.getTransaction().rollback();
		}
		return p;
	}

	@Override
	public List<Persona> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public List<Persona> buscar(Persona obj) throws Exception {
				cn.abrir();
				
				String busqueda=obj.getPers_nomb();
				busqueda='%'+busqueda.toLowerCase() +'%';
				
				String sentencia= "select p, "
						+"p.pais.pais_id "
						+"from Persona p "
						+"where "
						+ "(lower(p.pers_nomb) like :busqueda "
						+"or lower(p.pers_apel) like :busqueda ) "
						+ "and p.pers_esta='A'";
				
			
				Query q= cn.em.createQuery(sentencia);
				
				q.setParameter("busqueda", busqueda);
				
				List<Object[]> lista_objetos =q.getResultList();

				
				List<Persona> lista = new ArrayList<Persona>();
				
				for(Object objs[]: lista_objetos){
					Persona Persona=(Persona) objs[0];
					lista.add(Persona);
				}

				return lista;
	}

	@Override
	public void eliminar(Persona obj) throws Exception {
		cn.abrir();
		try {
			
			cn.em.getTransaction().begin();
			Persona oPersona=cn.em.find(Persona.class, obj.getPers_id());
			oPersona.setPers_esta('D');
			cn.em.merge(oPersona);
			cn.em.getTransaction().commit();
			
		} catch (Exception e) {
			cn.em.getTransaction().rollback();
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		
	}

	@Override
	public void actualizar(Persona obj) throws Exception {
		cn.abrir();
		try {
			cn.em.getTransaction().begin();
			cn.em.merge(obj);
			cn.em.getTransaction().commit();
			
		} catch (Exception e) {
			cn.em.getTransaction().rollback();
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		
	}

	@Override
	public Persona obtener(Persona obj) throws Exception {
		// TODO Auto-generated method stub
		Persona p1=null;
		cn.abrir();
		try {
			
			cn.em.getTransaction().begin();
			p1=cn.em.find(Persona.class, obj.getPers_id());
			
			cn.em.getTransaction().commit();
			
		} catch (Exception e) {
			cn.em.getTransaction().rollback();
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		return p1;
	}

}
