package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unju.fi.model.Docente;

public class ListadoDocentes {
	//crear un arrayList statico.
	public static List<Docente> docentes = new ArrayList<Docente>();
	//crear a continuación los métodos:
	
	//método para listar los docentes.
	public static List<Docente> listarDocentes() {
		return docentes.stream().filter(a->a.getEstado()==true).collect(Collectors.toList());
	}
	
	//método para buscar un docente a través de su legajo.
	public static Docente buscarDocentePorLegajo(String legajo){
		for(Docente d : docentes) {
			if(d.getLegajo().equals(legajo)) {
				return d;
			}
		}
		return null;
	}
	
	public static void agregarDocente(Docente docente) {
		docentes.add(docente);
		docente.setEstado(true);
	}
	
	//método para modificar los datos de un docente.
	public static void modificarDocente(Docente docenteModificado) {
		docenteModificado.setEstado(true);
		for(int i=0; i<docentes.size(); i++) {
			Docente docente = docentes.get(i);
			
			if(docente.getLegajo().equals(docenteModificado.getLegajo())) {
				docentes.set(i, docenteModificado);
				break;
			}
		}
	}
	
	//método para eliminar los datos de un docente.
	public static void eliminarDocente(String legajo) {
		for(int i=0; i<docentes.size();i++) {
			Docente docente = docentes.get(i);
			if(docente.getLegajo().equals(legajo)) {
				docente.setEstado(false);
				break;
			}
		}
	}
	
}
