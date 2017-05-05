package fr.gsb.spring;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import fr.gsb.model.CompteRendu;
import fr.gsb.model.Medicament;
import fr.gsb.model.Motif;
import fr.gsb.spring.resource.CompteRenduResource;

@RunWith(SpringRunner.class)
@EnableJpaRepositories("fr.gsb.spring.repository")
@SpringBootTest
public class CompteRenduTest {
	
	@Autowired
	private CompteRenduResource cRenduResource;
	final Logger LOG = Logger.getLogger(getClass().getName());
	
	@Test
	public void testFindAllCrendu() {
		//fail("Not yet implemented");
		List<CompteRendu> crendus = cRenduResource.findAllCRendu();
		LOG.info("LISTE DES compte rendus : "+crendus.size());		
	}
	
	@Test
	public void testSaveCrendu(){
		
		cRenduResource.saveCRendu(getCr());
	}
	
	@Test
	public void testUpdateCrendu(){
		cRenduResource.updateCRendu(getCr(), 1);
	}
	
	@Test
	public void testDeleteCrendu(){
		cRenduResource.deleteCompteRendu(1);
	}
	
	@Test
	public void testGetCrendu(){
		CompteRendu crndu = cRenduResource.getCRendu(1);
		LOG.info("COMPTE RENDU TROUVE : "+crndu);
	}
	
	public CompteRendu getCr(){
		List<Medicament> meds = new ArrayList<Medicament>();
		meds.add(new Medicament("Mythalgan", "douleur et mensonge"));
		CompteRendu cr = new CompteRendu(new Date(), "ras", Motif.periodicite, meds);
		return cr;
	}

}
