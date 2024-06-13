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
	private Carrera nuevaCarrera;
	
	//Mostrar la vista listaDeCarreras, con el listado de las carreras.
	@GetMapping("/lista")
	public ModelAndView getListaCarreras() {
		ModelAndView modelView = new ModelAndView("listaDeCarreras");
		modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());
		
		return modelView;
		
	}
	
	//Mostrar la vista formCarrera, con el formulario para llenar la información de la nueva Carrera.
	@GetMapping("/formulario")
	public ModelAndView getFormCarrera() {
		nuevaCarrera = new Carrera();
		ModelAndView modelView = new ModelAndView("formCarrera"); //pasa por parametro el nombre del formulario
		modelView.addObject("nuevaCarrera",nuevaCarrera); //Agregamos/Instanciamos una nueva carrera.
		
		return modelView;
		
	}
	
	//Guardar la nueva Carrera, y mostrar la lista de carreras.
	@PostMapping("/guardar")
	public ModelAndView saveCarrera(@ModelAttribute("nuevaCarrera") Carrera carrera) {
		//guardar la información que se envia a través del formulario.
		ListadoCarreras.agregarCarrera(carrera);
		
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("listaDeCarreras"); //pasa por parametro el nombre del formulario		
		modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras()); //Traemos el listado de las carreras.
				
		return modelView;
	}
	
	@GetMapping("/modificar")
	public ModelAndView modificarCarrera() {
		
	}
	
	// Después desarrollar esta función
	@GetMapping("/eliminar/{codigo}")
	public ModelAndView eliminarCarrera(@PathVariable(name="codigo") String codigo) {
		//borrar
		ListadoCarreras.eliminarCarrera(codigo);
		
		//mostrar el nuevo listado
		ModelAndView modelView = new ModelAndView("listaDeCarreras");
		modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());
		
		return modelView;
	}
}
