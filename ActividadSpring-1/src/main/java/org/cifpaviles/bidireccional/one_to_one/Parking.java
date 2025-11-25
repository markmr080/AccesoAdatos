package org.cifpaviles.bidireccional.one_to_one;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity(name="bi_parking_one_to_one")
@Table(name="bi_parking_one_to_one")
public class Parking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nombre;
	
	@OneToOne(mappedBy="parking")
	private Empleado empleado;
}
