package fr.gsb.spring.resource;

import fr.gsb.model.Visiteur;
import fr.gsb.spring.repository.VisiteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Nivhell on 27/02/2017.
 */
@RequestMapping("/login")
@RestController
public class LoginResource {
    @Autowired
    private VisiteurRepository visiteurDao;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Visiteur signIn(String email, String mdp){
        return visiteurDao.findByEmailAndMotDePasse(email, mdp).get(0);
    }
}
