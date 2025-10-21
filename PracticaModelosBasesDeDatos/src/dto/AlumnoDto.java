package dto;

import java.io.Serializable;

public class AlumnoDto implements Serializable{
	
	private String idAlumno;
	private String nombreAlumno;
	private String apellidosAlumno;
	private int edad;
	private char grupo;
	

	@Override
	public String toString() {
		return "AlumnoDto [idAlumno=" + idAlumno + ", nombreAlumno=" + nombreAlumno + ", apellidosAlumno="
				+ apellidosAlumno + ", edad=" + edad + ", grupo=" + grupo + "]";
	}
	public AlumnoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AlumnoDto(String idAlumno, String nombreAlumno, String apellidosAlumno, int edad, char grupo) {
		super();
		this.idAlumno = idAlumno;
		this.nombreAlumno = nombreAlumno;
		this.apellidosAlumno = apellidosAlumno;
		this.edad = edad;
		this.grupo = grupo;
	}
	public String getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(String idAlumno) {
		this.idAlumno = idAlumno;
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public char getGrupo() {
		return grupo;
	}
	public void setGrupo(char grupo) {
		this.grupo = grupo;
	}
	
	
	

}
