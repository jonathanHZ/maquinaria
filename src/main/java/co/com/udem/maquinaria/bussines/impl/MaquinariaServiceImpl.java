package co.com.udem.maquinaria.bussines.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.udem.maquinaria.DAO.MaquinariaDAO;
import co.com.udem.maquinaria.DTO.MaquinariaDTO;
import co.com.udem.maquinaria.DTO.StatusDTO;
import co.com.udem.maquinaria.bussines.MaquinariaService;
import co.com.udem.maquinaria.domain.maquinas;

@Service
public class MaquinariaServiceImpl implements MaquinariaService {

	@Autowired
	private MaquinariaDAO maquinariaDAO;

	@Transactional
	public List<MaquinariaDTO> getMaquinas() {

		List<MaquinariaDTO> list = new ArrayList<MaquinariaDTO>();
		List<maquinas> maquinas = maquinariaDAO.getMaquinas();
		for (maquinas maquinas2 : maquinas) {
			MaquinariaDTO maquinariaDTO = new MaquinariaDTO();
			maquinariaDTO.setIdmaquina(maquinas2.getIdmaquina());
			maquinariaDTO.setImagen(maquinas2.getImagen());
			maquinariaDTO.setNombre( maquinas2.getNombre());
			maquinariaDTO.setPrecio(maquinas2.getPrecio());
			maquinariaDTO.setDescuento(maquinas2.getDescuento());
			maquinariaDTO.setDescripcion(maquinas2.getDescripcion());
			maquinariaDTO.setDisponibilidad(maquinas2.getDisponibilidad());
			double precioDescuento = maquinas2.getPrecio()-((maquinas2.getPrecio()*maquinas2.getDescuento())/100);
			maquinariaDTO.setPrecioDescuento(precioDescuento);
			list.add(maquinariaDTO);
		}
		return list;
	}

	@Transactional
	public List<MaquinariaDTO> getMaquinasId(long idmaquina) {

		List<MaquinariaDTO> list = new ArrayList<MaquinariaDTO>();
		List<maquinas> maquinas = maquinariaDAO.getMaquinasId(idmaquina);
		for (maquinas maquinas2 : maquinas) {
			MaquinariaDTO maquinariaDTO = new MaquinariaDTO();
			maquinariaDTO.setIdmaquina(maquinas2.getIdmaquina());
			maquinariaDTO.setImagen(maquinas2.getImagen());
			maquinariaDTO.setNombre( maquinas2.getNombre());
			maquinariaDTO.setPrecio(maquinas2.getPrecio());
			maquinariaDTO.setDescuento(maquinas2.getDescuento());
			maquinariaDTO.setDescripcion(maquinas2.getDescripcion());
			maquinariaDTO.setDisponibilidad(maquinas2.getDisponibilidad());
			double precioDescuento = maquinas2.getPrecio()-((maquinas2.getPrecio()*maquinas2.getDescuento())/100);
			maquinariaDTO.setPrecioDescuento(precioDescuento);
			list.add(maquinariaDTO);
		}
		return list;
	}

	@Transactional
	public StatusDTO deleleteMaquina(long idmaquina) {
		return maquinariaDAO.deleleteMaquina(idmaquina);
	}

}
