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
	@Path("/addevent")
    @Consumes({ "application/json" })
	public void addEvent(Evenement e) {
		em.persist(e);
	}
	
	@POST
	@Path("/addutilisateur")
    @Consumes({ "application/json" })
	public void addUtilisateur(Personne u) {
		System.out.println("coucou");
		em.persist(u);
	}
	
	@GET
	@Path("/loginutilisateur")
    @Produces({ "application/json" })
	public Personne loginUtilisateur() {
		return (Personne) em.createQuery("from Utilisateur", Personne.class);	
	}

}
