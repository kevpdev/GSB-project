package fr.gsb.spring.resource;

import fr.gsb.model.Visiteur;
import fr.gsb.spring.repository.VisiteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Nivhell on 27/02/2017.
 */
@CrossOrigin("http://localhost:8080")
@RequestMapping("/login")
@RestController
public class LoginResource {
    @Autowired
    private VisiteurRepository visiteurDao;

    @RequestMapping(method = RequestMethod.POST)

    public Visiteur signIn(@RequestBody Visiteur visiteur){
        List<Visiteur> visiteurs = visiteurDao.findByEmailAndMotDePasse(visiteur.getEmail(), visiteur.getMotDePasse());
        if(visiteurs.size()>1){
            Visiteur v = visiteurs.get(0);
            return v != null ? v : null;
        }

        return null;


    }
}
