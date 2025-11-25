package org.cifpaviles.bidireccional.many_to_one;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name="bi_escuela_many_to_one")
@Table(name="bi_escuela_many_to_one")
public class Escuela {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nombre;
	
	@OneToMany(mappedBy = "escuela")
	@JoinTable
	private List<Estudiante> estudiante;
	
	
}
