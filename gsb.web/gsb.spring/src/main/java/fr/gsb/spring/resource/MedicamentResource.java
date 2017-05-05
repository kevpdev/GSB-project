package fr.gsb.spring.resource;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.gsb.model.Medicament;

import fr.gsb.spring.repository.MedicamentRepository;

@CrossOrigin("*")
@RequestMapping("/medicaments")
@RestController
public class MedicamentResource {
	
	@Autowired
	private MedicamentRepository medicamentDao;
	
	@PostConstruct
    public void init(){
		Medicament m = new Medicament("Jalouxine", "pour les haineux et les envieux");
		Medicament m2 = new Medicament("Mythoprane", "douleur et mensonge");
        medicamentDao.save(m);
        medicamentDao.save(m2);
    }
	
	@RequestMapping(method = RequestMethod.POST)
	public void saveMedic(@RequestBody Medicament Medic){
		medicamentDao.save(Medic);
	}
	
	 @RequestMapping(method = RequestMethod.GET)
	    public List<Medicament> findAllMedic(){
	        return medicamentDao.findAll();
	    }

	    @RequestMapping(method = RequestMethod.PUT)
	    public void updateMedic (Medicament medic, int id){
	    Medicament med = medicamentDao.findOne(id);
	      if(med!= null){
	    	  medic.setId(id);
	          med = medic;
	          medicamentDao.saveAndFlush(med);
	      }
	    }

	    @RequestMapping(value="medicaments/{id}", method = RequestMethod.DELETE)
	    public void deleteMedicament(@PathVariable int id){
	    	Medicament med = medicamentDao.findOne(id);
	        if(med != null){
	            medicamentDao.delete(med);
	        }
	    }

	    @RequestMapping(value = "medicaments/{id}", method = RequestMethod.GET)
	    public Medicament getMedic(@PathVariable int id){
	        return medicamentDao.findOne(id);
	    }

}
