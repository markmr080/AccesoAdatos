package entidad;

public class ProfesorEntidad {
	
	private String codProfesor;
	private String nombreProfesor;
	private String ciudad;
	public String getCodProfesor() {
		return codProfesor;
	}
	public void setCodProfesor(String codProfesor) {
		this.codProfesor = codProfesor;
	}
	public String getNombreProfesor() {
		return nombreProfesor;
	}
	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	
	@Override
	public String toString() {
		return "ProfesorEntidad [codProfesor=" + codProfesor + ", nombreProfesor=" + nombreProfesor + ", ciudad="
				+ ciudad + "]";
	}
	
	
}
