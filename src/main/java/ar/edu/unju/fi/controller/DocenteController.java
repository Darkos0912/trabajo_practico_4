package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoDocentes;
import ar.edu.unju.fi.model.Docente;

@Controller
@RequestMapping("/docente")
public class DocenteController {
	
	@Autowired
	Docente nuevoDocente = new Docente();
	
	@GetMapping("/lista")
	public ModelAndView getListaDocentes() {
		
		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		modelView.addObject("listadoDocentes", ListadoDocentes.listarDocentes());
		
		return modelView;
	}
	
	@GetMapping("/formularioDocente")
	public ModelAndView formularioDocente() {
		
		ModelAndView modelView = new ModelAndView("formDocente");
		modelView.addObject("nuevoDocente", nuevoDocente);
		
		return modelView;
	}
	
	@PostMapping("/guardarDocente")
	public ModelAndView guardarDocente(@ModelAttribute("nuevoDocente") Docente docente) {
		ListadoDocentes.agregarDocente(docente);
		
		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		modelView.addObject("listadoDocentes", ListadoDocentes.listarDocentes());
		
		return modelView;
	}
	
	@GetMapping("/modificarDocente/{legajo}")
	public ModelAndView modificarDocente(@PathVariable(name="legajo") String legajo) {
		Docente docente = ListadoDocentes.buscarDocentePorLegajo(legajo);
		
		ModelAndView modelView = new ModelAndView("formDocente");
		
		modelView.addObject("nuevoDocente", docente);
		modelView.addObject("flag", true);
		
		return modelView; 
	}
	
	@PostMapping("/modificarDocente")
	public ModelAndView modificarDocente(@ModelAttribute("nuevoDocente") Docente docenteModificado) {
		ListadoDocentes.modificarDocente(docenteModificado);
		
		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		modelView.addObject("listadoDocentes", ListadoDocentes.listarDocentes());
		
		return modelView;
	}
	
	@GetMapping("/eliminarDocente/{legajo}")
	public ModelAndView eliminarDocente(@PathVariable(name="legajo") String legajo) {
		ListadoDocentes.eliminarDocente(legajo);
		
		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		modelView.addObject("listadoDocentes", ListadoDocentes.listarDocentes());
		
		return modelView;
	}
}
