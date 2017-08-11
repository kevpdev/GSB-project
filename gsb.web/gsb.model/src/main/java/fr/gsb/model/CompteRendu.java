package fr.gsb.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class CompteRendu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public Date date;
	public String bilan;
	@Enumerated
	public Motif motif;
	@OneToMany(orphanRemoval = true, cascade = CascadeType.PERSIST)
	@JoinColumn(name="medicaments")
	public List<Medicament> medicaments;
	
	public CompteRendu(){
		
	}
	

	public CompteRendu(Date date, String bilan, Motif motif, List<Medicament> medicaments) {
		super();
		this.date = date;
		this.bilan = bilan;
		this.motif = motif;
		this.medicaments = medicaments;
	}
	

	public CompteRendu(int id, Date date, String bilan, Motif motif, List<Medicament> medicaments) {
		this(date, bilan, motif, medicaments);
		this.id = id;

	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public String getBilan() {
		return bilan;
	}
	public void setBilan(String bilan) {
		this.bilan = bilan;
	}
	public Motif getMotif() {
		return motif;
	}
	public void setMotif(Motif motif) {
		this.motif = motif;
	}
	public List<Medicament> getMedicaments() {
		return medicaments;
	}
	public void setMedicaments(List<Medicament> medicaments) {
		this.medicaments = medicaments;
	}


	@Override
	public String toString() {
		return "CompteRendu [id=" + id + ", date=" + date + ", bilan=" + bilan
				+ ", motif=" + motif + ", medicaments=" + medicaments + "]";
	}
	
	
	
	
	
	

}
