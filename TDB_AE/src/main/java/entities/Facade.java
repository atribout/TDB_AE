package entities;

import java.util.Collection;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import entities.Personne;

@Singleton
@Path("/")
public class Facade {
	
	@PersistenceContext
	EntityManager em;
	
	@POST
	@Path("/addutilisateur")
    @Consumes({ "application/json" })
	public void addUtilisateur(Personne u) {
		System.out.println("coucou");
		em.persist(u);
	}
	
	@POST
	@Path("/loginutilisateur")
    @Consumes({ "application/json" })
	public Personne verifierMembre(Personne u) {
		String password = u.getMdp();
		String username = u.getLogin();
		Personne q = em.createQuery("SELECT m FROM Personne m where login=:username AND mdp=:password", Personne.class).setParameter("username", username).setParameter("password", password).getSingleResult();
		return q;
	}
	
	

}
