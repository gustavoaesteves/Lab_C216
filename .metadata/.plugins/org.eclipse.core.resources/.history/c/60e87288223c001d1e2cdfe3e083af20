package model;

import java.util.Objects;

public class Curso {
	private Long id;
	private  String description;
	private Integer numHoraria;
	public Curso(long id, String description, Integer numHoraria) {
		super();
		this.id = id;
		this.description = description;
		this.numHoraria = numHoraria;
	}

	public Curso() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getnumHoraria() {
		return numHoraria;
	}

	public void setnumHoraria(Integer numHoraria) {
		this.numHoraria = numHoraria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
