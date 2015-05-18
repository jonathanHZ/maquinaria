/**
 * 
 */
package co.com.udem.maquinaria.DAO;

import java.util.List;

import co.com.udem.maquinaria.DTO.MaquinariaDTO;
import co.com.udem.maquinaria.domain.maquinas;

/**
 * @author Jonathan
 *
 */
public interface MaquinariaDAO {
	
	public List<maquinas> getMaquinas();
	public List<maquinas> getMaquinasId(long idmaquina);
	public List<maquinas> updateMaquina(long idmaquina,String imagen,String nombre,Double precio,Double descuento,String descripcion,String disponibilidad);
}
