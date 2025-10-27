package dao;

import java.util.List;

import entidad.ProfesorEntidad;

public interface ProfesorDao {

	
	public void crearProfesor(ProfesorEntidad profesor);	
	public ProfesorEntidad obtenerProfesorPorId(String id);
	public List<ProfesorEntidad> obtenerTodosLosProfesores();
	public List<String> obtenerModulosPorProfesor();
	public void actualizarProfesor(ProfesorEntidad profesor);
	public void eliminarProfesor(String id);
}
