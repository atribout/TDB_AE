package pack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Adresse {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int num;
	private String rue;
	private String ville;
	private int adressePostale;
	
	@ManyToOne
	private Personne owner;

	public Adresse() {};
	
	public Adresse(int num, String rue, String ville, int adrPost) {
		this.num = num;
		this.rue = rue;
		this.ville = ville;
		this.adressePostale = adrPost;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Personne getOwner() {
		return owner;
	}

	public void setOwner(Personne owner) {
		this.owner = owner;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getAdressePostale() {
		return adressePostale;
	}

	public void setAdressePostale(int adressePostale) {
		this.adressePostale = adressePostale;
	}
	
	
}
