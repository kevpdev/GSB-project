package fr.gsb.spring.resource;

import fr.gsb.model.Visiteur;
import fr.gsb.spring.repository.VisiteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Nivhell on 24/02/2017.
 */
@RequestMapping("/visiteur")
@RestController
public class VisiteurResource {
    @Autowired
    private VisiteurRepository visiteurDao;

    public void saveVisiteur(Visiteur visiteur){
        visiteurDao.save(visiteur);
    }

}
