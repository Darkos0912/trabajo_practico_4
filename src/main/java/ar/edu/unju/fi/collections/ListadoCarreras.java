package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unju.fi.model.Carrera;

public class ListadoCarreras {
	
	public static List<Carrera> carreras = new ArrayList<Carrera>();
	
		//Metodo para listar carreras
		public static List<Carrera> listarCarreras(){
			return carreras.stream().filter(a->a.getEstado()==true).collect(Collectors.toList());
		}
		
		//Metodo para buscar carrera por codigo
		public static Carrera buscarCarreraPorCodigo (String codigo) {
			for (Carrera c : carreras) {
				if (c.getCodigo().equals(codigo)) {
					return c;
				}
			}
			return null;
		}
		
		//Metodo para agregar una carrera
		public static void agregarCarrera(Carrera c) {
			carreras.add(c);
			c.setEstado(true);
		}
		
		//Metodo para modificar una carrera
		public static void modificarCarrera(Carrera carreraModificada) {
			carreraModificada.setEstado(true);
			for (int i=0; i<carreras.size(); i++) {
				Carrera carrera = carreras.get(i);
				if(carrera.getCodigo().equals(carreraModificada.getCodigo())){
					carreras.set(i, carreraModificada);
					break;
				}
			}
		}
		
		//Metodo para eliminar una carrera.
		public static void eliminarCarrera(String codigo) {
			
			for (int i=0; i<carreras.size(); i++) {
				Carrera carrera = carreras.get(i);
				if(carrera.getCodigo().equals(codigo)){
					carrera.setEstado(false);
					break;
				}
			}
		}
}
