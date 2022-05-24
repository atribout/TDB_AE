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

@Singleton
@Path("/")
public class Facade {
	
	@PersistenceContext
	EntityManager em;
	
	@POST
	@Path("/addutilisateur")
    @Consumes({ "application/json" })
	public void addUtilisateur(Utilisateur u) {
		System.out.println("coucou");
		em.persist(u);
	}
	
	@GET
	@Path("/loginutilisateur")
    @Produces({ "application/json" })
	public Utilisateur loginUtilisateur() {
		return (Utilisateur) em.createQuery("from Utilisateur", Utilisateur.class);	
	}

}
