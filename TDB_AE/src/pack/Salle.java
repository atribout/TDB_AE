package pack;

import java.util.*;

import javax.persistence.*;

@Entity
public class Salle {
	
	@Id
	private String Nom;
	
	private String batiment;
	private int etage;
	private int capacite;
	private boolean projecteur;
	private boolean accees_demandé;
	private TypeSalle type;
	
	
	@ManyToMany(mappedBy = "salles")
	private Collection<Evenement> activite;
	
	
	@ManyToMany
	private Collection<Personne> accees;
	
	public String getBatiment() {
		return batiment;
	}
	public void setBatiment(String batiment) {
		this.batiment = batiment;
	}
	public int getEtage() {
		return etage;
	}
	public void setEtage(int etage) {
		this.etage = etage;
	}
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	public TypeSalle getType() {
		return type;
	}
	public void setType(TypeSalle type) {
		this.type = type;
	}
	public boolean isProjecteur() {
		return projecteur;
	}
	public void setProjecteur(boolean projecteur) {
		this.projecteur = projecteur;
	}
	public Collection<Evenement> getActivite() {
		return activite;
	}
	public void setActivite(Collection<Evenement> activite) {
		this.activite = activite;
	}
	public Collection<Personne> getAccees() {
		return accees;
	}
	public void setAccees(Collection<Personne> accees) {
		this.accees = accees;
	}
	public boolean isAccees_demandé() {
		return accees_demandé;
	}
	public void setAccees_demandé(boolean accees_demandé) {
		this.accees_demandé = accees_demandé;
	}
	
}
