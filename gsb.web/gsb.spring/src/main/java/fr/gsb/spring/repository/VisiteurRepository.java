package fr.gsb.spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import fr.gsb.model.Visiteur;
import java.util.List;

public interface VisiteurRepository extends  JpaRepository<Visiteur, Integer> {

//    @Modifying
//    @Query(Select * from Visiteur v where v.email = ? and v.motDePasse)
//    Visiteur signIn(String email, String mdp);

    List<Visiteur> findByEmailAndMotDePasse(String email, String motDePasse);

}
