package main.java.entities;

import java.util.*;

import javax.persistence.*;

@Entity
public class Association {
	
	@Id
	private String nom;
	
	private String description;
	
	//Bureau bureau;
	//Un seul role de president par éleve
	@OneToOne
	private Personne president;
	
	@OneToOne
	private Personne tresorier;
	
	@ManyToMany
	private List<Personne> bureau;
	
	@ManyToMany
	private List<Personne> membres;
	
	@ManyToMany(mappedBy = "asso_organisatrice")
	private Collection<Evenement> events;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Personne getPresident() {
		return president;
	}

	public void setPresident(Personne president) {
		this.president = president;
	}

	public Personne getTresorier() {
		return tresorier;
	}

	public void setTresorier(Personne tresorier) {
		this.tresorier = tresorier;
	}

	public List<Personne> getBureau() {
		return bureau;
	}

	public void setBureau(List<Personne> bureau) {
		this.bureau = bureau;
	}

	public List<Personne> getMembres() {
		return membres;
	}

	public void setMembres(List<Personne> membres) {
		this.membres = membres;
	}

	public Collection<Evenement> getEvents() {
		return events;
	}

	public void setEvents(Collection<Evenement> events) {
		this.events = events;
	}
	
}
