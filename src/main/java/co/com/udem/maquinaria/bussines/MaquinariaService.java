package co.com.udem.maquinaria.bussines;

import java.util.List;

import co.com.udem.maquinaria.DTO.MaquinariaDTO;
import co.com.udem.maquinaria.DTO.StatusDTO;
import co.com.udem.maquinaria.domain.maquinas;

public interface MaquinariaService {
	
	public List<MaquinariaDTO> getMaquinas();
	public List<MaquinariaDTO> getMaquinasId(long idmaquina);
	public List<MaquinariaDTO> getMaquinasData(String data);
	public StatusDTO deleleteMaquina (long idmaquina);
}
