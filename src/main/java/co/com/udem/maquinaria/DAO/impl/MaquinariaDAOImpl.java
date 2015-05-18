package co.com.udem.maquinaria.DAO.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.udem.maquinaria.DAO.MaquinariaDAO;
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
	
	public List<maquinas> updateMaquina(long idmaquina,String imagen,String nombre,Double precio,Double descuento,String descripcion,String disponibilidad){

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("UPDATE maquinas m SET m.imagen="+imagen+",m.nombre="+nombre+",m.precio="+precio+
		",m.descuento="+descuento+",m.descripcion="+descripcion+",m.disponibilidad="+disponibilidad+" WHERE m.idmaquina="+idmaquina);
		List<maquinas> response = (List<maquinas>)query.list();
		return response;
	}

}
