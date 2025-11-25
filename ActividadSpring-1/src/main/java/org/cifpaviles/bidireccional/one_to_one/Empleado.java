package org.cifpaviles.bidireccional.one_to_one;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity(name="bi_empleado_one_to_one")
@Table(name="bi_empleado_one_to_one")

public class Empleado {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@OneToOne
		@JoinColumn(name="parkingId")
		private Parking parking;
		
		private String nombreEmpleado;
		private String turnoEmpleado;
	}
