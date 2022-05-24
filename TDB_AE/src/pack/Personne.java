package pack;

import java.util.Collection;

import javax.persistence.*;

@Entity
public class Eleve {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String prenom;
    private int annee;

    private String role;

    @ManyToMany
    private Collection<Association> associations;

    @ManyToMany(mappedBy = "participants")
    private Collection<Evenement> evenements;
    
    @ManyToMany(mappedBy= "acces")
    private Collection<Salle> salles_accessibles;
    

    public Eleve(){};

    public Eleve(String nom, String prenom, int annee){
        this.nom = nom;
        this.prenom = prenom;
        this.annee = annee;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public String getNom(){
        return this.nom;
    }

    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    public String getPrenom(){
        return this.prenom;
    }

    public void setAnnee(int annee){
        this.annee = annee;
    }

    public int getAnnee(){
        return this.annee;
    }

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Collection<Evenement> getEvenements() {
		return evenements;
	}

	public void setEvenements(Collection<Evenement> evenements) {
		this.evenements = evenements;
	}

	public Collection<Association> getAssociations() {
		return associations;
	}

	public void setAssociations(Collection<Association> associations) {
		this.associations = associations;
	}

	public Collection<Salle> getSalles_accessibles() {
		return salles_accessibles;
	}

	public void setSalles_accessibles(Collection<Salle> salles_accessibles) {
		this.salles_accessibles = salles_accessibles;
	}


}