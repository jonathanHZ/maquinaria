package co.com.udem.maquinaria.bussines;

import java.util.List;

import co.com.udem.maquinaria.DTO.MaquinariaDTO;
import co.com.udem.maquinaria.domain.maquinas;

public interface MaquinariaService {
	
	public List<maquinas> getMaquinas();
	public List<maquinas> getMaquinasId(long idmaquina);
	public List<maquinas> updateMaquina(long idmaquina,String imagen,String nombre,Double precio,Double descuento,String descripcion,String disponibilidad);

}
