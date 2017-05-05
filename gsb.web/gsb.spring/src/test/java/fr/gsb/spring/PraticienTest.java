package fr.gsb.spring;

import static org.junit.Assert.*;

import java.util.List;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import fr.gsb.model.CategPraticien;
import fr.gsb.model.Praticien;
import fr.gsb.spring.resource.PraticienResource;

@RunWith(SpringRunner.class)
@EnableJpaRepositories("fr.gsb.spring.repository")
@SpringBootTest
public class PraticienTest {

	@Autowired
	private PraticienResource pratResource;
	private Logger LOG = Logger.getLogger(getClass().getName());
	
	@Test
	public void testFindAllPraticien() {
		//fail("Not yet implemented");
		List<Praticien> prats =  pratResource.finAllPraticien();
		LOG.info("LISTE DES PRATICIENS : "+ prats);
		
	}
	
	@Test
	public void testSavePraticien(){
		Praticien p = new Praticien("BUVAIT", "Fiora", "9 rue du moulin", "75000", "Monarville", CategPraticien.dermatologue);
		Praticien p2 = new Praticien("Gauchard", "Dani", "12 rue des olivette", "44000", "Nantes", CategPraticien.generaliste);
		pratResource.savePraticien(p);
		pratResource.savePraticien(p2);
	}
	
	@Test
	public void testUpdatePraticien(){
		Praticien pr = new Praticien("JOYARD", "Katrine", "3 rue motet", "75000", "Monarville", CategPraticien.generaliste);
		pratResource.updatePraticien(pr, 1);
	}
	
	@Test
	public void testDeletePraticien(){
		pratResource.deletePraticien(1);
	}
	
	@Test
	public void testGetPraticien(){
		Praticien prat  = pratResource.getPraticien(2);
		LOG.info("PRATICIEN TROUVE "+ prat);
	}

}
