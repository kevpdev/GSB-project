package fr.gsb.spring.resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import fr.gsb.model.CompteRendu;
import fr.gsb.model.Medicament;
import fr.gsb.model.Motif;
import fr.gsb.spring.repository.CompteRenduRepository;

@CrossOrigin("*")
@RequestMapping("/crendus")
@RestController
public class CompteRenduResource {
	
	@Autowired
	private CompteRenduRepository cRenduDao;
	private static Logger LOG = Logger.getLogger(CompteRenduResource.class);
	
	@PostConstruct
    public void init(){
		
		
//		Medicament m1 = new Medicament("Suicidine", "pour les suicidaire");
//		Medicament m2 = new Medicament("Doliprane", "douleur et fievre");
//		Medicament m4 = new Medicament("Mythoprane", "douleur et mensonge");
//		Medicament m3 = new Medicament("Jalouxine", "raleur et anvieux");	
//		Set<Medicament> medocs = new HashSet<Medicament>();
//		Set<Medicament> medocsb = new HashSet<Medicament>();
//		medocs.add(m1);
//		medocs.add(m2);
//		medocsb.add(m3);
//		medocsb.add(m4);		
//		CompteRendu crend = new CompteRendu(new Date(), "RAS", Motif.periodicite, medocs);
//		CompteRendu crendb = new CompteRendu(new Date(), "blablabla", Motif.relance, medocsb);
//		LOG.info("crendu init : "+crend);
//		cRenduDao.save(crend);
//		cRenduDao.save(crendb);
    }
	
	@RequestMapping(method = RequestMethod.POST)
	public void saveCRendu(@RequestBody CompteRendu cRendu){
		LOG.info("objet crendu : "+cRendu);
		cRenduDao.saveAndFlush(cRendu);
	}
	
	 @RequestMapping(method = RequestMethod.GET)
	    public Set<CompteRendu> findAllCRendu(){
		 Set setCr = new HashSet<CompteRendu>(cRenduDao.findAll());
	        return setCr;
	    }

	    @RequestMapping(method = RequestMethod.PUT)
	    public void updateCRendu (CompteRendu CompteRendu, int id){
	    CompteRendu cr = cRenduDao.findOne(id);
	      if(cr!= null){
	          CompteRendu.setId(id);
	          cr = CompteRendu;
	          cRenduDao.saveAndFlush(cr);
	      }
	    }

	    @RequestMapping(value="crendus/{id}", method = RequestMethod.DELETE)
	    public void deleteCompteRendu(@PathVariable int id){
	    	CompteRendu cr = cRenduDao.findOne(id);
	        if(cr != null){
	            cRenduDao.delete(cr);
	        }
	    }

	    @RequestMapping(value = "crendus/{id}", method = RequestMethod.GET)
	    public CompteRendu getCRendu(@PathVariable int id){
	        return cRenduDao.findOne(id);
	    }

}
