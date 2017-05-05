package fr.gsb.model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Praticien {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String adresse;
	private String codePostal;
	private String ville;
	@Enumerated
	private CategPraticien categ;
	
	public Praticien(){
		
	}
	
	public Praticien(String nom, String prenom, String adresse, String codePostal, String ville, CategPraticien categ) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.categ = categ;
	}	
	
	
	public Praticien(int id, String nom, String prenom, String adresse, String codePostal, String ville,
			CategPraticien categ) {
		this(nom, prenom, adresse, codePostal, ville, categ);
		this.id = id;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public CategPraticien getCateg() {
		return categ;
	}
	public void setCateg(CategPraticien categ) {
		this.categ = categ;
	}

	@Override
	public String toString() {
		return "Praticien [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", codePostal="
				+ codePostal + ", ville=" + ville + ", categ=" + categ + "]";
	}
	
	
	

}
