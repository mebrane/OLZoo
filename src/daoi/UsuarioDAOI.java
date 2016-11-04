package daoi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import daol.UsuarioDAOL;
import model.Usuario;
import util.Conexion;

public class UsuarioDAOI implements UsuarioDAOL {

	Conexion cn = new Conexion();
	@Override
	public Usuario validar(Usuario usu) throws Exception {
		cn.abrir();
		Usuario u = null;
		try {
			Query q = cn.em.createQuery("select u from Usuario u where u.user_user= :u and u.user_pass= :p");
			q.setParameter("u", usu.getUser_user());
			q.setParameter("p", usu.getUser_pass());
			List<Usuario> lista = q.getResultList();
			for (Usuario o : lista) {
				u = lista.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.cerrar();
		}
		return u;
	}

	@Override
	public Usuario insertar(Usuario usu) throws Exception {
		cn.abrir();
		try {
			cn.em.getTransaction().begin();
			cn.em.persist(usu);
			cn.em.flush();
			cn.em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			cn.em.getTransaction().rollback();
			// TODO: handle exception
		}
		return usu;

	}

	@Override
	public List<Usuario> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> buscar(Usuario usu) throws Exception {
		cn.abrir();
		List<Usuario> lista=new ArrayList<Usuario>();
		try {
			String sql="select u,u.Persona.pers_id,u.Persona.Pais.pais_id from Usuario u where "
					+ "(lower(u.Persona.pers_nomb) like :busqueda "
					+ "or lower(u.Persona.pers_apel) like :busqueda ) "
					+ "and u.user_esta='A'";
			Query q =cn.em.createQuery(sql);
			q.setParameter("busqueda",'%'+ usu.getPersona().getPers_nomb().toLowerCase()+'%');
			
			List<Object[]> lista_objetos =q.getResultList();

			for(Object objs[]: lista_objetos){
				Usuario u=(Usuario) objs[0];
				lista.add(u);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public void eliminar(Usuario u) throws Exception {
		cn.abrir();
		try {
			cn.em.getTransaction().begin();
			Query q = cn.em
					.createQuery("select u from Usuario u where u.Persona.pers_id= :pers_id and u.user_carg= :carg");
			q.setParameter("pers_id", u.getPersona().getPers_id());
			q.setParameter("carg", u.getUser_carg());
			List<Usuario> lista = q.getResultList();
			Usuario u2= new Usuario();
			u2=null;
			for (Usuario o : lista) {
				u2 = lista.get(0);
			}
			if(u2!=null){
				u2.setUser_esta('D');
				cn.em.merge(u2);
				cn.em.getTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			cn.em.getTransaction().rollback();
			// TODO: handle exception
		}

		
	}

	@Override
	public Usuario obtener(Usuario u) throws Exception {
		cn.abrir();
		Usuario usu=new Usuario();
		try {
			cn.em.getTransaction().begin();
			Query q = cn.em
					.createQuery("select u from Usuario u where u.Persona.pers_id= :id and u.user_carg= :cargo");
			q.setParameter("id", u.getPersona().getPers_id());
			q.setParameter("cargo", u.getUser_carg());
			List<Usuario> lista = q.getResultList();
			Usuario u2= new Usuario();
			u2=null;
			for (Usuario o : lista) {
				u2 = lista.get(0);
			}
			usu= u2;
//			if(u2!=null){
//				u2.setUser_esta('D');
//				cn.em.merge(u2);
//				cn.em.getTransaction().commit();
//			}
		} catch (Exception e) {
			e.printStackTrace();
			cn.em.getTransaction().rollback();
			// TODO: handle exception
		}
		
		return usu;
	}

	@Override
	public void actualizar(Usuario usu) throws Exception {
		cn.abrir();
		try {
			cn.em.getTransaction().begin();
			cn.em.merge(usu);
			cn.em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			cn.em.getTransaction().rollback();
			// TODO: handle exception
		}
		
	}

}
