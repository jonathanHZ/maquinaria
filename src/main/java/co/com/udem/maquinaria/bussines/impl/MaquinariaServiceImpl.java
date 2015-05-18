package co.com.udem.maquinaria.bussines.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.udem.maquinaria.DAO.MaquinariaDAO;
import co.com.udem.maquinaria.bussines.MaquinariaService;
import co.com.udem.maquinaria.domain.maquinas;

@Service
public class MaquinariaServiceImpl implements MaquinariaService {
	
	@Autowired
	private MaquinariaDAO maquinariaDAO;

	
	@Transactional
	public List<maquinas> getMaquinas() {
		
		List<maquinas> list = maquinariaDAO.getMaquinas();
		return list;
	}
	
	@Transactional
	public List<maquinas> getMaquinasId(long idmaquina) {
		
		List<maquinas> list = maquinariaDAO.getMaquinasId(idmaquina);
		return list;
	}
	
	@Transactional
	public List<maquinas> updateMaquina(long idmaquina,String imagen,String nombre,Double precio,Double descuento,String descripcion,String disponibilidad){
		List<maquinas> response = maquinariaDAO.updateMaquina(idmaquina,imagen,nombre,precio,descuento,descripcion,disponibilidad);
		return response;
	}

}
