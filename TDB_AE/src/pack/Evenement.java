package pack;

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
    Collection<Eleve> participants ;

    @ManyToMany
    Collection<Association> asso_organisateur;
    
    @OneToMany
    Collection<Salle> salles;
    
    
 
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
	
}
