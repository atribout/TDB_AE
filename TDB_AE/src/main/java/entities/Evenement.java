package main.java.entities;

import java.util.Collection;

import javax.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
public class Evenement {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String description;
    private Date date;
    private Time time;

    @ManyToMany
    private Collection<Personne> participants ;

    @ManyToMany
    private Collection<Association> asso_organisateur;
    
    @OneToMany
    private Collection<Salle> salles;
    
    
 
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Collection<Personne> getParticipants() {
		return participants;
	}

	public void setParticipants(Collection<Personne> participants) {
		this.participants = participants;
	}

	public Collection<Association> getAsso_organisateur() {
		return asso_organisateur;
	}

	public void setAsso_organisateur(Collection<Association> asso_organisateur) {
		this.asso_organisateur = asso_organisateur;
	}

	public Collection<Salle> getSalles() {
		return salles;
	}

	public void setSalles(Collection<Salle> salles) {
		this.salles = salles;
	}
	
}
