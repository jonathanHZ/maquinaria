package co.com.udem.maquinaria.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import co.com.udem.maquinaria.DTO.MaquinariaDTO;
import co.com.udem.maquinaria.DTO.StatusDTO;
import co.com.udem.maquinaria.bussines.MaquinariaService;
import co.com.udem.maquinaria.domain.maquinas;

@Controller
@RequestMapping("/maquinas")
public class MaquinariaController {

	@Autowired
	public MaquinariaService maquinariaService;

	@RequestMapping("/list")
	public ModelAndView MoviesList() {

		ModelAndView mv = new ModelAndView();
		mv.addObject("machines", maquinariaService.getMaquinas());
		return mv;
	}

	// Este metodo devuelve en formato JSON toda la tabla de la BdeD
	@RequestMapping("/listAPI")
	public @ResponseBody List<MaquinariaDTO> maquinasListApi(
			HttpServletRequest request, HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods",
				"GET,PUT,POST,DELETE");
		response.addHeader("Access-Control-Allow-Headers", "Content-Type");

		return maquinariaService.getMaquinas();
	}

	// Este metodo devuelve la mquina por el id pasado por el parametro
	@RequestMapping("/listAPIid")
	public @ResponseBody List<MaquinariaDTO> maquinaById(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "id", required = true, defaultValue = "1") Long identificador) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods",
				"GET,PUT,POST,DELETE");
		response.addHeader("Access-Control-Allow-Headers", "Content-Type");
		System.out.println("Este es en /listAPIid  " + identificador);
		return maquinariaService.getMaquinasId(identificador);
	}

	@RequestMapping("/deleteId")
	public @ResponseBody StatusDTO deleteMaquinaById(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "id", required = true, defaultValue = "1") Long idmaquina) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods",
				"GET,PUT,POST,DELETE");
		response.addHeader("Access-Control-Allow-Headers", "Content-Type");
		return maquinariaService.deleleteMaquina(idmaquina);
	}

	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	public String redirect() {

		return "redirect:detail";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String finalPage() {

		return "detail";
	}

}
