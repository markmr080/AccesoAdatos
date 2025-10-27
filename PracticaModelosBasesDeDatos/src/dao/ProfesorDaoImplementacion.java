package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import entidad.AlumnoEntidad;
import entidad.ProfesorEntidad;

public class ProfesorDaoImplementacion implements ProfesorDao {
	
	
	private DataSource dataSource;
	private static ProfesorDaoImplementacion instancia;

	private ProfesorDaoImplementacion(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	

	public static ProfesorDaoImplementacion getInstancia(DataSource dataSource) {
		if (instancia == null) {
			instancia = new ProfesorDaoImplementacion(dataSource);
		}return instancia;
	}

	private ProfesorEntidad mapearResultSetProfesor (ResultSet profesor) {
		
		ProfesorEntidad aux = new ProfesorEntidad();
		
		 try {
			aux.setCodProfesor(profesor.getString("cod_Profesor"));
			aux.setNombreProfesor(profesor.getString("nombre_profesor"));
			aux.setCiudad(profesor.getString("ciudad"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
		
		return aux;
	}

	@Override
	public void crearProfesor(ProfesorEntidad profesor) {
		// TODO Auto-generated method stub
		String sql = "insert into profesor (cod_Profesor, nombre_Profesor, ciudad) values (?,?,?)";
		
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, profesor.getCodProfesor());
			statement.setString(2, profesor.getNombreProfesor());
			statement.setString(3, profesor.getCiudad());
					
			statement.executeUpdate();					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public ProfesorEntidad obtenerProfesorPorId(String id) {
		String sql = "Select * from Profesor where cod_profesor = ? ";
		Connection connection;	
		try {		
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);		
			statement.setString(1, id);				
			ResultSet rs = statement.executeQuery();
				
			if (rs.next()) {
				return mapearResultSetProfesor(rs);         
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}

	@Override
	public List<ProfesorEntidad> obtenerTodosLosProfesores() {
		String sql = " select cod_profesor, nombre_profesor, ciudad from profesor";
		
		List<ProfesorEntidad> alumnos = new ArrayList<ProfesorEntidad>();
		
		try {
			Connection connection = dataSource.getConnection();
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				alumnos.add(mapearResultSetProfesor(result));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return alumnos;
	}
	}

	@Override
	public List<String> obtenerModulosPorProfesor() {
		String sql = "Select nombre_modulo from modulo where cod_profesor = ? ";
		Connection connection;	
		
		
		
		return null;
	}

	@Override
	public void actualizarProfesor(ProfesorEntidad profesor) {
		// TODO Auto-generated method stub
		String sql = "update profesor set nombre_profesor = ?, ciudad = ? where cod_profesor = ?";
		
		Connection con;
		
		con = this.dataSource.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		
		
		
	}

	@Override
	public void eliminarProfesor(String id) {
		// TODO Auto-generated method stub
		
	}

}
