/**
 * 
 */
package co.com.udem.maquinaria.DAO;

import java.util.List;

import co.com.udem.maquinaria.DTO.MaquinariaDTO;
import co.com.udem.maquinaria.DTO.StatusDTO;
import co.com.udem.maquinaria.domain.maquinas;

/**
 * @author Jonathan
 *
 */
public interface MaquinariaDAO {
	
	public List<maquinas> getMaquinas();
	public List<maquinas> getMaquinasId(long idmaquina);
	public StatusDTO deleleteMaquina (long idmaquina);
}
