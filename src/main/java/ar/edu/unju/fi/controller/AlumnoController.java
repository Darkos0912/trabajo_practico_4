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
	private Alumno nuevoAlumno;
	
	@GetMapping("/lista")
	public ModelAndView getListaAlumnos() {
		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		modelView.addObject("listadoAlumnos", ListadoAlumno.listarAlumnos());
		
		return modelView;
	}
	
	@GetMapping("/formulario")
	public ModelAndView getFormAlumno() {
		nuevoAlumno = new Alumno();
		ModelAndView modelView = new ModelAndView("formAlumno");
		modelView.addObject("nuevoAlumno", nuevoAlumno);
		
		return modelView;
	}
	
	@PostMapping("/guardar")
	public ModelAndView saveAlumno(@ModelAttribute("nuevoAlumno") Alumno alumnos) {
		ListadoAlumno.agregarAlumno(alumnos);
		
		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		modelView.addObject("listadoAlumnos", ListadoAlumno.listarAlumnos());
		
		return modelView;
	}
	
	@GetMapping("/modificar")
	public ModelAndView modificarAlumno() {
		
	}
	
	@GetMapping("/eliminar/{dni}")
	public ModelAndView eliminarAlumno(@PathVariable(name="dni") int dni) {
		ListadoAlumno.eliminarAlumno(dni);
		
		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		modelView.addObject("listadoAlumnos", ListadoAlumno.listarAlumnos());
		
		return modelView;
	}
}
