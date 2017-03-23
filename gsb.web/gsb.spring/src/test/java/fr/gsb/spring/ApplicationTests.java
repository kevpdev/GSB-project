package fr.gsb.spring;



import fr.gsb.model.Visiteur;
import fr.gsb.spring.repository.VisiteurRepository;
import fr.gsb.spring.resource.LoginResource;
import fr.gsb.spring.resource.VisiteurResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@EnableJpaRepositories("fr.gsb.spring.repository")
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private VisiteurResource visResource;
	@Autowired
	private LoginResource loginResource;
	final Logger LOG = Logger.getLogger(getClass().getName());
	@Test
	public void saveVisisteurTest() {

		Visiteur vis = new Visiteur();
		//vis.setId(1);
		vis.setNom("Dub");
		vis.setPrenom("Tom");
        vis.setEmail("toto@gmail.com");
        vis.setMotDePasse("123");
        visResource.saveVisiteur(vis);
	}
   @Test
	public void findAllVisiteurTest(){
		List<Visiteur> visiteurs  = visResource.findAllVisiteur();
        LOG.info("liste de visiteurs : "+visiteurs.size());
	}

	@Test
	public void updateVisiteurTest(){
		Visiteur v = new Visiteur();
		v.setNom("Dupont");
		v.setPrenom("rich");
        v.setEmail("toto@gmail.com");
        v.setMotDePasse("123");
        visResource.updateVisiteur(v, 1);
	}

	@Test
	public void deleteVisiteurTest(){
		Visiteur v = visResource.getVisiteur(1);
		if(v != null )
            visResource.deleteVisiteur(v.getId());

	}
    @Test
	public void signInTest(){
		Visiteur v = new Visiteur();
		v.setNom("Dupont");
		v.setPrenom("rich");
		v.setEmail("toto@gmail.com");
		v.setMotDePasse("123");

       Visiteur vis = loginResource.signIn(v);
       if(vis == null)
           fail("email ou mot de passe incorrecte");
    }


}
