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
import fr.gsb.model.CategPraticien;
import fr.gsb.model.Praticien;
import fr.gsb.spring.repository.PraticienRepository;

@CrossOrigin("*")
@RequestMapping("/praticiens")
@RestController
public class PraticienResource {
	
	@Autowired
	private PraticienRepository praticienDao;
	
	@PostConstruct
    public void init(){
		Praticien p = new Praticien("DUPONT", "Richard", "3 rue motet", "75000", "Monarville", CategPraticien.generaliste);
		Praticien p2 = new Praticien("HARAULT", "Jean", "5 avenue du boulon", "62000", "Jolanda", CategPraticien.dentiste);
		praticienDao.save(p);
		praticienDao.save(p2);
    }
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Praticien> finAllPraticien(){
		return praticienDao.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST) 
	public void savePraticien(@RequestBody Praticien prat){
		praticienDao.save(prat);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void updatePraticien(Praticien prat, int id){
		Praticien p = praticienDao.findOne(id);
		if(p != null){
			prat.setId(id);
			p = prat;
			praticienDao.saveAndFlush(p);
		}
	}
	
	@RequestMapping(value = "praticiens/{id}", method = RequestMethod.DELETE)
	public void deletePraticien(@PathVariable int id){
		Praticien p = praticienDao.findOne(id);
		if(p != null){
			praticienDao.delete(p);
		}
	}
	
	@RequestMapping(value = "praticiens/{id}", method = RequestMethod.GET)
	public Praticien getPraticien(@PathVariable int id){
		Praticien p = praticienDao.findOne(id);
		return p;
	}
	
}
