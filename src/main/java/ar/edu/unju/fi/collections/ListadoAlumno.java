package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Alumno;

public class ListadoAlumno {
	
	public static List<Alumno> alumnos = new ArrayList<Alumno>();
	
	public static List<Alumno> listarAlumnos(){
		return alumnos;
	}
	
	public static Alumno buscarAlumnoPorDni(int dni) {
		for (Alumno a : alumnos) {
			if(a.getDni() == dni) {
				return a;
			}
		}
		return null;
	}
	
	public static void agregarAlumno(Alumno a) {
		alumnos.add(a);
	}
	
	public static void modificarAlumno(Alumno modificarAlumno) {
		for(int i=0;i<alumnos.size();i++) {
			Alumno alumno = alumnos.get(i);
			if(alumno.getDni() == modificarAlumno.getDni()) {
				alumnos.set(i, modificarAlumno);
				break;
			}
		}
	}
	
	public static void eliminarAlumno(int dni) {
		alumnos.removeIf(alumno -> alumno.getDni() == dni);
	}
	
}
