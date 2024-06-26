package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoCarreras;
import ar.edu.unju.fi.model.Carrera;

@Controller
@RequestMapping("/carrera")
public class CarreraController {
	
	
	@Autowired
	Carrera nuevaCarrera = new Carrera();
	
	@GetMapping("/lista")
	public ModelAndView getListaCarreras() {
		ModelAndView modelView = new ModelAndView("listaDeCarreras");
		modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());
		
		return modelView;
		
	}
	
	
	@GetMapping("/formularioCarrera")
	public ModelAndView getFormCarrera() {
		ModelAndView modelView = new ModelAndView("formCarrera");
		modelView.addObject("nuevaCarrera",nuevaCarrera); 
		
		return modelView;
		
	}
	
	@PostMapping("/guardarCarrera")
	public ModelAndView saveCarrera(@ModelAttribute("nuevaCarrera") Carrera carrera) {
		ListadoCarreras.agregarCarrera(carrera);
		
		ModelAndView modelView = new ModelAndView("listaDeCarreras");	
		modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras()); 
				
		return modelView;
	}
	
	@GetMapping("/modificarCarrera/{codigo}")
	public ModelAndView modificarCarrera(@PathVariable(name="codigo") String codigo) {
		Carrera carrera = ListadoCarreras.buscarCarreraPorCodigo(codigo);
		
		ModelAndView modelView = new ModelAndView("formCarrera");
		modelView.addObject("nuevaCarrera", carrera);
		modelView.addObject("flag", true);
		
		return modelView;
	}
	
	@PostMapping("/modificarCarrera")
	public ModelAndView modificarCarrera(@ModelAttribute("nuevaCarrera") Carrera carreraAModificar) {
		ListadoCarreras.modificarCarrera(carreraAModificar);
		
		ModelAndView modelView = new ModelAndView("listaDeCarreras");
		modelView.addObject("listadoCarrera", ListadoCarreras.listarCarreras());
		
		return modelView;
	}
	
	@GetMapping("/eliminarCarrera/{codigo}")
	public ModelAndView eliminarCarrera(@PathVariable(name="codigo") String codigo) {
		ListadoCarreras.eliminarCarrera(codigo);
		
		ModelAndView modelView = new ModelAndView("listaDeCarreras");
		modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());
		
		return modelView;
	}
}
