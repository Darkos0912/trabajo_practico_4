package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoCarreras;
import ar.edu.unju.fi.collections.ListadoDocentes;
import ar.edu.unju.fi.collections.ListadoMaterias;
import ar.edu.unju.fi.model.Materia;

@Controller
@RequestMapping("/materia")
public class MateriaController {
	
	@Autowired
	Materia nuevaMateria = new Materia();
	
	@GetMapping("/lista")
	public ModelAndView getListaMaterias() {
		
		ModelAndView modelView= new ModelAndView("listaDeMaterias");
		modelView.addObject("listadoMaterias",ListadoMaterias.listarMaterias());
		
		return modelView;
	}
	
	@GetMapping("/formularioMateria")
	public ModelAndView getformularioMateria() {
		ModelAndView modelView = new ModelAndView("formMateria");
		
		modelView.addObject("nuevaMateria",nuevaMateria);
		modelView.addObject("listadoDocentes",ListadoDocentes.listarDocentes());
		modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());
		modelView.addObject("flag", false);
		
		return modelView;
	}
	
	@PostMapping("/guardarMateria")
	public ModelAndView guardarMateria(@ModelAttribute("nuevaMateria") Materia materia) {
		materia.setDocente(ListadoDocentes.buscarDocentePorLegajo(materia.getDocente().getLegajo()));
		materia.setCarrera(ListadoCarreras.buscarCarreraPorCodigo(materia.getCarrera().getCodigo()));
		ListadoMaterias.agregarMateria(materia);
		
		ModelAndView modelView= new ModelAndView("listaDeMaterias");
		modelView.addObject("listadoMaterias",ListadoMaterias.listarMaterias());
		
		return modelView;
		
	}
	
	@GetMapping("/eliminarMateria/{codigo}")
	public ModelAndView eliminarMateria(@PathVariable(name="codigo") String codigo) {
		ListadoMaterias.eliminarMateria(codigo);
		
		ModelAndView modelView = new ModelAndView("listaDeMaterias");
		modelView.addObject("listadoMaterias",ListadoMaterias.listarMaterias());
		
		return modelView;
	}
	
	@GetMapping("/modificarMateria/{codigo}")
	public ModelAndView modificarMateria(@PathVariable(name="codigo")String codigo) {
		Materia materia = ListadoMaterias.buscarMateriaPorCodigo(codigo);
		
		ModelAndView modelView =new ModelAndView("formMateria");
		modelView.addObject("nuevaMateria", materia);
		modelView.addObject("flag", true);
		
		return modelView;
	}
	
	@PostMapping("/modificarMateria")
	public ModelAndView modifcarMateria(@ModelAttribute("nuevaMateria") Materia materiaModificada)
	{	ListadoMaterias.modificarMateria(materiaModificada);
		ModelAndView modelView = new ModelAndView("listaDeMaterias");
		modelView.addObject("listadoMaterias",ListadoMaterias.listarMaterias());
		
		return modelView;
		
	}
}
