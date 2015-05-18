package co.com.udem.maquinaria.DAO.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.udem.maquinaria.DAO.MaquinariaDAO;
import co.com.udem.maquinaria.DTO.StatusDTO;
import co.com.udem.maquinaria.domain.maquinas;

@Repository
public class MaquinariaDAOImpl implements MaquinariaDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<maquinas> getMaquinas() {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM maquinas");
		
		@SuppressWarnings("unchecked")
		List<maquinas> listMaquinas = (List<maquinas>) query.list();
		
		return listMaquinas;
	}
	
	public List<maquinas> getMaquinasId(long idmaquina) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT m FROM maquinas m WHERE m.idmaquina ="+idmaquina);
//		query.setParameter(0, idmaquina);
		
		@SuppressWarnings("unchecked")
		List<maquinas> listMaquinas = (List<maquinas>) query.list();
		
		return listMaquinas;
	}

	public StatusDTO deleleteMaquina(long idmaquina) {
		StatusDTO statusDTO = new StatusDTO();
		Session session = sessionFactory.getCurrentSession();
		maquinas m = (maquinas) session.load(maquinas.class, new Long(idmaquina));
		try {
			session.delete(m);
			statusDTO.setStatus("success");
		} catch (Exception e) {
			statusDTO.setStatus("error");
		}
		return statusDTO;
	}

}
