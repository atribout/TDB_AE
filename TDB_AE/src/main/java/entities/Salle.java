package entities;

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
	private boolean accees_demande;
	
	
	@ManyToMany(mappedBy = "salles")
	private Collection<Evenement> activite;
	
	
	@ManyToMany
	private Collection<Personne> acces;
	
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
		return acces;
	}
	public void setAccees(Collection<Personne> accees) {
		this.acces = accees;
	}
	public boolean isAccees_demande() {
		return accees_demande;
	}
	public void setAccees_demande(boolean accees_demande) {
		this.accees_demande = accees_demande;
	}
	
}
