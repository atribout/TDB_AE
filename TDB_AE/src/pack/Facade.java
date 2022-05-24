package pack;

import java.util.Collection;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Singleton
@Path("/")
public class Facade {

	@PersistenceContext
	EntityManager em;
	
	
	@POST
	@Path("/addperson")
    @Consumes({ "application/json" })
	public void addPerson(Personne p) {
		String mail = p.getMail();
		String login = p.getLogin();
		Collection<Personne> ps = em.createQuery("select * from Personne where mail = ? or login = ?",Personne.class)
									.setParameter(1,mail).setParameter(2,login).getResultList();
		if (ps == null) {
			em.persist(p);
		} else {
			//throw Exception
		}
	}
	
	//Ajouter une adresse à une personne
	@POST
	@Path("/putaddress")
    @Consumes({ "application/json" })
	public void putAddress(String login, String rue,String ville,int adrPost, int num) {
		Adresse a = new Adresse(num,rue,ville,adrPost);
		Personne p = em.find(Personne.class, login);
		em.persist(a);
		p.setAdresse(a);
		em.merge(p);	
	}
	
	
	
	@GET
	@Path("/listpersons")
    @Produces({ "application/json" })
	public Collection<Personne> listePersonnes() {
		return em.createQuery("FROM Personne", Personne.class).getResultList();
	}
	
	@GET
	@Path("/listaddresses")
    @Produces({ "application/json" })
	public Collection<Adresse> listeAdresses() {
		return em.createQuery("FROM Adresse", Adresse.class).getResultList();	
	}
	
	@POST
	@Path("/associate")
    @Consumes({ "application/json" })
	public void associate(Association as) {
		System.out.println(as.getPersonId() +" "+ as.getAdressId());
		Personne p = em.find(Personne.class, as.getPersonId());
		Adresse a = em.find(Adresse.class, as.getAdressId());
		a.setOwner(p);
	}
	
}
