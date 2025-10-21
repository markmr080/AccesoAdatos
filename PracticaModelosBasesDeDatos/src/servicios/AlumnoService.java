package servicios;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dao.AlumnoDaoImplementacion;
import dto.AlumnoDto;
import entidad.AlumnoEntidad;

public class AlumnoService {
	
	
	private static AlumnoService instancia;
	
	private AlumnoDaoImplementacion alumnoDao;
	
	
	
	private AlumnoService(DataSource datasource) {
		
		alumnoDao = alumnoDao.getInstancia(datasource);		
	}
	
	public static AlumnoService getInstancia(DataSource datasource) {
		
		if (instancia == null) {
			instancia = new AlumnoService(datasource);
		}
		
		return instancia;
	}
	
	
	
	public void crearAlumno(AlumnoDto alumnoDto) {		
		AlumnoEntidad alumno = new AlumnoEntidad();
		alumno = mapearDtoEntidad(alumnoDto);
		alumnoDao.crearAlumno(alumno);		
	}
	
	public AlumnoDto obtenerAlumnoPorId(String id) {
		
		AlumnoEntidad alumno = alumnoDao.obtenerAlumnoPorId(id);
		AlumnoDto alumnoDto = mapearEntidadDto(alumno);
		
		if (alumnoDto !=null) {
			return alumnoDto;
		}
		
		return null;
	}
	public List<AlumnoDto> obtenerTodosLosAlumnos() {
		
		List <AlumnoEntidad> alumnos = alumnoDao.obtenerTodosLosAlumnos();
		List <AlumnoDto> alumnosDto = new ArrayList<AlumnoDto>();
		
		for (AlumnoEntidad alumno: alumnos) {
			alumnosDto.add(mapearEntidadDto(alumno));
		}
		return alumnosDto;
	}
	public void actualizarAlumno(AlumnoDto alumnoDto) {
		AlumnoEntidad alumno  = alumnoDao.obtenerAlumnoPorId(alumnoDto.getIdAlumno());
		
		if (alumno!=null) {
			alumno.setNombreAlumno(alumnoDto.getNombreAlumno());
			alumno.setApellidosAlumno(alumnoDto.getApellidosAlumno());
			alumno.setCodAlumno(alumnoDto.getIdAlumno());
			alumno.setFechaNacimiento(convertirEdadAFecha(alumnoDto.getEdad()));
			alumno.setGrupo(alumnoDto.getGrupo());
			alumnoDao.actualizarAlumno(alumno);
			
		}
		
		
	}
	
	public void eliminarAlumno(String id) {
		if (alumnoDao.obtenerAlumnoPorId(id)!=null) {
			alumnoDao.eliminarAlumno(id);
		}
		
	}
	
	
	
	private AlumnoEntidad mapearDtoEntidad (AlumnoDto alumnoDto) {
		
		AlumnoEntidad alumno  = new AlumnoEntidad();
		
		alumno.setNombreAlumno(alumnoDto.getNombreAlumno());
		alumno.setApellidosAlumno(alumnoDto.getApellidosAlumno());
		alumno.setCodAlumno(alumnoDto.getIdAlumno());
		alumno.setFechaNacimiento(convertirEdadAFecha(alumnoDto.getEdad()));
		alumno.setGrupo(alumnoDto.getGrupo());
		return alumno;
		
	}
	
	
	private AlumnoDto mapearEntidadDto (AlumnoEntidad alumno) {
		
		AlumnoDto alumnoDto = new AlumnoDto();
		alumnoDto.setIdAlumno(alumno.getCodAlumno());
		alumnoDto.setNombreAlumno(alumno.getNombreAlumno());
		alumnoDto.setApellidosAlumno(alumno.getApellidosAlumno());
		alumnoDto.setGrupo(alumno.getGrupo());
		alumnoDto.setEdad(calcularEdad(alumno.getFechaNacimiento()));
		return alumnoDto;
		
		
	}
	
	
	
	private Date convertirEdadAFecha (int edad) {
		LocalDate nacimiento = LocalDate.now().minusYears(edad);
		return (Date) Date.from(nacimiento.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
	}
	
	private int calcularEdad(Date fecha) {
		LocalDate nacimiento = new java.util.Date(fecha.getTime()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		return Period.between(nacimiento, LocalDate.now()).getYears();
	}
	
}
