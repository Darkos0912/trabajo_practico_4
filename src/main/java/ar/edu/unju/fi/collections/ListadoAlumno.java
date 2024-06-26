package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unju.fi.model.Alumno;

public class ListadoAlumno {
	
	public static List<Alumno> alumnos = new ArrayList<Alumno>();
	
	public static List<Alumno> listarAlumnos(){
		return alumnos.stream().filter(a->a.getEstado()==true).collect(Collectors.toList());
	}
	
	public static Alumno buscarAlumnoPorLu(String lu) {
		for (Alumno a : alumnos) {
			if(a.getLu().equals(lu)) {
				return a;
			}
		}
		return null;
	}
	
	public static void agregarAlumno(Alumno a) {
		alumnos.add(a);
		a.setEstado(true);
	}
	
	public static void modificarAlumno(Alumno modificarAlumno) {
		modificarAlumno.setEstado(true);
		for(int i=0;i<alumnos.size();i++) {
			Alumno alumno = alumnos.get(i);
			if(alumno.getLu() == modificarAlumno.getLu()) {
				alumnos.set(i, modificarAlumno);
				break;
			}
		}
	}
	
	public static void eliminarAlumno(String lu) {
		for (int i = 0; i < alumnos.size(); i++) {
			Alumno alumno = alumnos.get(i);
			if (alumno.getLu().equals(lu)) {
				alumno.setEstado(false);
				break;
			}
		}
	}
	
}
