package org.cifpaviles.bidireccional.many_to_one;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name="bi_estudiante_many_to_one")
@Table(name="bi_estudiante_many_to_one")
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nombreEstudiante;
	private int curso;
	
	@ManyToOne
	@JoinColumn(name="idEscuela")
	private Escuela escuela;
	
	
	
}
