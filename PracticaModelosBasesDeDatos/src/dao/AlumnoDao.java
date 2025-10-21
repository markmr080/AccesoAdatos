package dao;

import java.util.List;

import entidad.AlumnoEntidad;


public interface AlumnoDao {

	public void crearAlumno(AlumnoEntidad alumno);	
	public AlumnoEntidad obtenerAlumnoPorId(String id);
	public List<AlumnoEntidad> obtenerTodosLosAlumnos();
	public void actualizarAlumno(AlumnoEntidad alumno);
	public void eliminarAlumno(String id);
	
	
}
