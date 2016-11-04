package daoi;

import java.util.List;

import javax.persistence.Query;

import daol.PaisDAOL;
import model.Pais;
import util.Conexion;

public class PaisDAOI implements PaisDAOL {

	Conexion cn = new Conexion();
	@Override
	public List<Pais> listar() throws Exception {
		cn.abrir();
		List<Pais> lista=null;
		try {
			Query q =cn.em.createQuery("select p from Pais p");
			lista=q.getResultList();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return lista;
	}

}
