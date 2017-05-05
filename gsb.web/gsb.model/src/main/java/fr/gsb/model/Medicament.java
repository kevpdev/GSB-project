package fr.gsb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medicament {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public String name;
	public String description;
	
	public Medicament(){
		
	}
	
	public Medicament(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public Medicament(int id, String name, String description) {
		this(name, description);
		this.id = id;

	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Medicament [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
	
	
	
	
	
}
