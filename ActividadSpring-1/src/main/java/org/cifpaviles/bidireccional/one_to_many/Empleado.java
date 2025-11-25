package org.cifpaviles.bidireccional.one_to_many;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name="bi_empleado_one_to_many")
@Table(name="bi_empleado_one_to_many")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinTable(name="idDepartamento")
	private Departamento departamento;
	
	private String nombreEmpleado;
	private String turnoEmpleado;
}