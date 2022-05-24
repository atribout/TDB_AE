package pack;

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
	private Eleve president;
	
	@OneToOne
	private Eleve tresorier;
	
	@ManyToMany
	private List<Eleve> bureau;
	
	@ManyToMany
	private List<Eleve> membres;
	
	@ManyToMany(mappedBy = "asso_organisatrice")
	private Collection<Evenement> events;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Eleve getPresident() {
		return president;
	}

	public void setPresident(Eleve president) {
		this.president = president;
	}

	public Eleve getTresorier() {
		return tresorier;
	}

	public void setTresorier(Eleve tresorier) {
		this.tresorier = tresorier;
	}

	public List<Eleve> getBureau() {
		return bureau;
	}

	public void setBureau(List<Eleve> bureau) {
		this.bureau = bureau;
	}

	public List<Eleve> getMembres() {
		return membres;
	}

	public void setMembres(List<Eleve> membres) {
		this.membres = membres;
	}

	public Collection<Evenement> getEvents() {
		return events;
	}

	public void setEvents(Collection<Evenement> events) {
		this.events = events;
	}
	
}
