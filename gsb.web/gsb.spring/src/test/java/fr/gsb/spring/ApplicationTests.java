package fr.gsb.spring;



import fr.gsb.model.Visiteur;
import fr.gsb.spring.repository.VisiteurRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@EnableJpaRepositories("fr.gsb.spring.repository")
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private VisiteurRepository visiteurDao;
	final Logger LOG = Logger.getLogger(getClass().getName());
	@Test
	public void saveVisisteurTest() {

		Visiteur vis = new Visiteur();
		//vis.setId(1);
		vis.setNom("Toti");
		vis.setPrenom("toto");
		visiteurDao.saveAndFlush(vis);
	}
   @Test
	public void findAllVisiteurTest(){
		List<Visiteur> visiteurs  = visiteurDao.findAll();
        LOG.info("liste de visiteurs : "+visiteurs.size());
	}

}
