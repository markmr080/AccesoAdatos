package org.cifpaviles.bidireccional.many_to_many;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity(name="bi_libro_many_to_many")
@Table(name="bi_libro_many_to_many")
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String titulo;
	private String editorial;
	
	@ManyToMany
	@JoinTable(name="AutorLibroBidireccional",
	joinColumns = @JoinColumn(name="idLibro"),
	inverseJoinColumns = @JoinColumn(name="idAutor")
	)
	
	private List<Autor> listaAutores;

}
