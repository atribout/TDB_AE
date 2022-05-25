package main.java.entities;

import java.util.Collection;

import javax.persistence.*;

@Entity
public class Personne {

	@Id
	private String login;
	
	private String mdp;
	
    private String nom;
    
    private String prenom;
    
    private int annee;
    
    private String mail;
    
    @ManyToMany
    private Collection<Association> associations;

    @ManyToMany(mappedBy = "participants")
    private Collection<Evenement> evenements;
    
    @ManyToMany(mappedBy= "acces")
    private Collection<Salle> salles_accessibles;
    
    @OneToMany(mappedBy="owner", fetch = FetchType.EAGER)
	private Adresse adresse;
    
    public Personne(){};

    public Personne(String nom, String prenom, int annee, String mail){
        this.nom = nom;
        this.prenom = prenom;
        this.annee = annee;
        this.mail = mail;
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

    public String Prenom(){
        return this.prenom;
    }

    public void setAnnee(int annee){
        this.annee = annee;
    }

    public int getAnnee(){
        return this.annee;
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

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}


}