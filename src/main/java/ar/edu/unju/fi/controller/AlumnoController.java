package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoAlumno;
import ar.edu.unju.fi.model.Alumno;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {
	
	@Autowired
	Alumno nuevoAlumno = new Alumno();
	
	@GetMapping("/lista")
	public ModelAndView getListaAlumnos() {
		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		modelView.addObject("listadoAlumnos", ListadoAlumno.listarAlumnos());
		
		return modelView;
	}
	
	@GetMapping("/formularioAlumno")
	public ModelAndView getFormAlumno() {
		ModelAndView modelView = new ModelAndView("formAlumno");
		modelView.addObject("nuevoAlumno", nuevoAlumno);
		
		return modelView;
	}
	
	@PostMapping("/guardarAlumno")
	public ModelAndView saveAlumno(@ModelAttribute("nuevoAlumno") Alumno alumnos) {
		ListadoAlumno.agregarAlumno(alumnos);
		
		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		modelView.addObject("listadoAlumnos", ListadoAlumno.listarAlumnos());
		
		return modelView;
	}
	
	@GetMapping("modificarAlumno/{lu}")
	public ModelAndView modificarAlumno(@PathVariable(name="lu") String lu) {
		Alumno alumno = ListadoAlumno.buscarAlumnoPorLu(lu);
		
		ModelAndView modelView = new ModelAndView("formAlumno");
		
		modelView.addObject("nuevoAlumno", alumno);
		modelView.addObject("flag", true);
		return modelView;
	}
	
	@PostMapping("/modificarAlumno")
	public ModelAndView modificarAlumno(@ModelAttribute("nuevoAlumno") Alumno alumnoAModificar) {
		ListadoAlumno.modificarAlumno(alumnoAModificar);
		
		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		modelView.addObject("listadoAlumnos", ListadoAlumno.listarAlumnos());
		
		return modelView;
	}
	
	@GetMapping("/eliminarAlumno/{lu}")
	public ModelAndView eliminarAlumno(@PathVariable(name="lu") String lu) {
		ListadoAlumno.eliminarAlumno(lu);
		
		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		modelView.addObject("listadoAlumnos", ListadoAlumno.listarAlumnos());
		
		return modelView;
	}
}
