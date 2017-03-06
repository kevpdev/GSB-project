package fr.gsb.spring.resource;

import fr.gsb.model.Visiteur;
import fr.gsb.spring.repository.VisiteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Nivhell on 24/02/2017.
 */
@CrossOrigin("*")
@RequestMapping("/visiteurs")
@RestController
public class VisiteurResource {
    @Autowired
    private VisiteurRepository visiteurDao;

    @PostConstruct
    public void init(){
        Visiteur vis = new Visiteur();
        //vis.setId(1);
        vis.setNom("Toti");
        vis.setPrenom("toto");
        vis.setEmail("toto@gmail.com");
        vis.setMotDePasse("123");
        visiteurDao.save(vis);
    }
    @RequestMapping(method = RequestMethod.POST)
    public void saveVisiteur(@RequestBody  Visiteur visiteur) {
        visiteurDao.save(visiteur);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Visiteur> findAllVisiteur(){
        return visiteurDao.findAll();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateVisiteur (Visiteur visiteur, int id){
      Visiteur v = visiteurDao.findOne(id);
      if(v!= null){
          visiteur.setId(id);
          v = visiteur;
          visiteurDao.saveAndFlush(v);
      }
    }

    @RequestMapping(value="visiteurs/{id}", method = RequestMethod.DELETE)
    public void deleteVisiteur(@PathVariable int id){
        Visiteur v = visiteurDao.findOne(id);
        if(v != null){
            visiteurDao.delete(v);
        }
    }

    @RequestMapping(value = "visiteurs/{id}", method = RequestMethod.GET)
    public Visiteur getVisiteur(@PathVariable int id){
        return visiteurDao.findOne(id);
    }


}
