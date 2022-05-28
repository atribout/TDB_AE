package entities;

import java.util.Collection;

import javax.persistence.*;

@Entity
public class Evenement {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String description;
    private String date;
    private String time;

    @ManyToMany
    private Collection<Personne> participants ;

    @ManyToOne
    private Association asso_organisateur;
    
    @ManyToMany
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Collection<Personne> getParticipants() {
		return participants;
	}

	public void setParticipants(Collection<Personne> participants) {
		this.participants = participants;
	}

	public Association getAsso_organisateur() {
		return asso_organisateur;
	}

	public void setAsso_organisateur(Association asso_organisateur) {
		this.asso_organisateur = asso_organisateur;
	}

	public Collection<Salle> getSalle() {
		return salles;
	}

	public void setSalle(Collection<Salle> salles) {
		this.salles = salles;
	}
	
}
