package fr.gsb.spring;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import fr.gsb.model.Medicament;
import fr.gsb.spring.resource.MedicamentResource;

@RunWith(SpringRunner.class)
@EnableJpaRepositories("fr.gsb.spring.repository")
@SpringBootTest
public class MedicamentTest {
	
	@Autowired
	private MedicamentResource medResource;
	final Logger LOG = Logger.getLogger(getClass().getName());

	@Test
	public void testFindAllMedoc() {
		//fail("Not yet implemented");
		List<Medicament> medocs = medResource.findAllMedic();
		LOG.info("LISTE DES médicaments : "+medocs.size());
		
	}
	
	@Test
	public void testSaveMedoc(){
		Medicament med = new Medicament("Mythoferalgan", "douleur et mensonge");
		Medicament med2 = new Medicament("Hexaspray", "maux de gorge");
		medResource.saveMedic(med);
		medResource.saveMedic(med2);
	}
	
	@Test
	public void testUpdateMedoc(){
		Medicament med = new Medicament("Mythoferalgan", "douleur et mensonge");
		medResource.updateMedic(med, 1);;
	}
	
	@Test
	public void testDeleteMedoc(){
		medResource.deleteMedicament(2);
	}
	
	@Test
	public void testGetMedoc(){
		Medicament medic = medResource.getMedic(1);
		LOG.info("MEDOC trouvé : "+ medic);
	}

}
