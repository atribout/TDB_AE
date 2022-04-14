package pack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Club {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String name;
	String description;
	
	@ManyToMany
	@JsonIgnore
	Person member;
	
	@ManyToOne
	@JsonIgnore
	Person president;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Person getPresident() {
		return president;
	}

	public void setOwner(Person president) {
		this.president = president;
	}

	
	
	
}
