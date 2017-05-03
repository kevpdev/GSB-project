package fr.gsb.model;

import java.util.Date;
import java.util.List;

public class CompteRendu {
	
	public int id;
	public Date date;
	public String remplaçant;
	public String bilan;
	public Motif motif;
	public List<Medicament> medicaments;

}
