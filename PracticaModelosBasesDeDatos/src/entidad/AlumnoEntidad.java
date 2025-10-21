package entidad;

import java.sql.Date;

public class AlumnoEntidad {
	private String codAlumno;
	private String nombreAlumno;
	private String apellidosAlumno;
	private Date fechaNacimiento;
	private char grupo;
	
	
	public String getCodAlumno() {
		return codAlumno;
	}
	public void setCodAlumno(String codAlumno) {
		this.codAlumno = codAlumno;
	}
	public String getNombreAlumno() {
		return nombreAlumno;
	}
	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}
	public String getApellidosAlumno() {
		return apellidosAlumno;
	}
	public void setApellidosAlumno(String apellidosAlumno) {
		this.apellidosAlumno = apellidosAlumno;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public char getGrupo() {
		return grupo;
	}
	public void setGrupo(char grupo) {
		this.grupo = grupo;
	}
	
	

	
	
	
	
	@Override
	public String toString() {
		return "AlumnoEntidad [codAlumno=" + codAlumno + ", nombreAlumno=" + nombreAlumno + ", apellidosAlumno="
				+ apellidosAlumno + ", fechaNacimiento=" + fechaNacimiento + ", grupo=" + grupo + "]";
	}
	
	
	
	
}
