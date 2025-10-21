package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import entidad.AlumnoEntidad;

public class AlumnoDaoImplementacion  implements AlumnoDao{
	
	

	
	private static AlumnoDaoImplementacion instancia;
	private DataSource dataSource;
	
	
	
	
	public AlumnoDaoImplementacion(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}


	public static AlumnoDaoImplementacion getInstancia(DataSource dataSource) {
		if (instancia == null) {
			instancia = new AlumnoDaoImplementacion(dataSource);
		}return instancia;
		
	}
	
	
	public void crearAlumno(AlumnoEntidad alumno) {
		
		String sql = "insert into alumno (codAlumno, nombreAlumno, apellidosAlumno, fechaNacimiento, grupo) values (?,?,?,?,?)";
		
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, alumno.getCodAlumno());
			statement.setString(2, alumno.getNombreAlumno());
			statement.setString(3, alumno.getApellidosAlumno());
			statement.setDate(4,new java.sql.Date(alumno.getFechaNacimiento().getTime()));
			statement.setString(5, String.valueOf(alumno.getGrupo()));			
			statement.executeUpdate();					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}


	public AlumnoEntidad obtenerAlumnoPorId(String id) {
		
		String sql = "Select * from Alumno where cod_alumno = ? ";
		Connection connection;	
		try {		
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql	);
			
			statement.setString(1, id);				
			ResultSet rs = statement.executeQuery();
				
			if (rs.next()) {
				return mapearResultSetAlumno(rs);         
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	
	public List<AlumnoEntidad> obtenerTodosLosAlumnos() {
		
		String sql = " select cod_alumno, nombre_alumno, apellidos_alumno, fecha_nacimiento, grupo from alumno";
		
		List<AlumnoEntidad> alumnos = new ArrayList<AlumnoEntidad>();
		
		try {
			Connection connection = dataSource.getConnection();
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				alumnos.add(mapearResultSetAlumno(result));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return alumnos;
	}


	public void actualizarAlumno(AlumnoEntidad alumno) {
		String sql = "update alumno set nombre_alumno = ?, apellidos_alumno = ?, fecha_nacimiento = ?, grupo = ?,  cod_alumno = ? ";
		Connection connection;
		
		
		
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql	);
			
			statement.setString(1, alumno.getNombreAlumno());
			statement.setString(2, alumno.getApellidosAlumno());
			statement.setDate(3, alumno.getFechaNacimiento());
			statement.setString(4, String.valueOf(alumno.getGrupo()));
			statement.setString(5, alumno.getCodAlumno());
			
			statement.executeQuery();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void eliminarAlumno(String id) {
		String sql = "delete from alumno where cod_alumno = ?";
		Connection connection;
		
		
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, id);			
			
			statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	private AlumnoEntidad mapearResultSetAlumno (ResultSet alumnos) {
		
		AlumnoEntidad aux = new AlumnoEntidad();
		
		 try {
			aux.setCodAlumno(alumnos.getString("cod_alumno"));
			aux.setNombreAlumno(alumnos.getString("nombre_alumno"));
	        aux.setApellidosAlumno(alumnos.getString("apellidos_alumno"));
	        aux.setFechaNacimiento(alumnos.getDate("fecha_nacimiento"));
	        aux.setGrupo(alumnos.getString("grupo").charAt(0));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
		
		return aux;
	}

}
