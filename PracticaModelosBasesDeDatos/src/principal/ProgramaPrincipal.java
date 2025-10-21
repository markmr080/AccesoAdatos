package principal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

import dto.AlumnoDto;
import servicios.AlumnoService;

public class ProgramaPrincipal {

	
	
	public static void main (String [] args) {
		
		DataSource ds = configurarDataSource();
		
		AlumnoService alumnoService = AlumnoService.getInstancia(ds);
		
		List <AlumnoDto> alumnosDto = alumnoService.obtenerTodosLosAlumnos();
		for (AlumnoDto alumnoDto : alumnosDto) {
			System.out.println(alumnoDto.toString());
		}
		
		
		
		
	}
	
	
	private static DataSource configurarDataSource() {
		
		MysqlDataSource ds = null;
		
		Properties prop = new Properties();
		
		FileInputStream file;
		
		try {
			file = new FileInputStream("resources\\conexion.properties");
			
			prop.load(file);
			
			ds = new MysqlDataSource();
			ds.setUrl(prop.getProperty("url"));
			ds.setUser(prop.getProperty("user"));
			ds.setPassword(prop.getProperty("password"));
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ds;
		
	}
}
