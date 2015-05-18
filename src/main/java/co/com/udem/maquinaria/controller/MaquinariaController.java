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
	public @ResponseBody List<maquinas> maquinasListApi(HttpServletRequest request,
			HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods",
				"GET,PUT,POST,DELETE");
		response.addHeader("Access-Control-Allow-Headers", "Content-Type");
		List<maquinas> maquinas = maquinariaService.getMaquinas();
		return maquinas;
	}

	// Este metodo devuelve la mquina por el id pasado por el parametro
	@RequestMapping("/listAPIid")
	public @ResponseBody List<maquinas> maquinaById(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "id", required = true, defaultValue = "1") Long identificador) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods",
				"GET,PUT,POST,DELETE");
		response.addHeader("Access-Control-Allow-Headers", "Content-Type");
		System.out.println("Este es en /listAPIid  " + identificador);
		List<maquinas> maquinas = maquinariaService
				.getMaquinasId(identificador);
		return maquinas;
	}

	// Este metodo devuelve la mquina por el id pasado por el parametro
	// http://localhost:8080/maquinaria/maquinas/listUPDATE?id=1&imagen=../lib/images/1.jpg&nombre=cortadora&precio=350000
	@RequestMapping("/listUPDATE")
	public @ResponseBody List<maquinas> maquinaUpdate(
			@RequestParam(value = "id", required = true, defaultValue = "1") Long idmaquina,
			@RequestParam(value = "imagen", required = false, defaultValue = "../lib/images/1.jpg") String imagen,
			@RequestParam(value = "nombre", required = false, defaultValue = "maquina") String nombre,
			@RequestParam(value = "precio", required = false, defaultValue = "0.0") Double precio,
			@RequestParam(value = "descuento", required = false, defaultValue = "0.0") Double descuento,
			@RequestParam(value = "descripcion", required = false, defaultValue = "") String descripcion,
			@RequestParam(value = "disponibilidad", required = false, defaultValue = "") String disponibilidad) {

		List<maquinas> maquinas = maquinariaService.updateMaquina(idmaquina,
				imagen, nombre, precio, descuento, descripcion, disponibilidad);
		return maquinas;
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
