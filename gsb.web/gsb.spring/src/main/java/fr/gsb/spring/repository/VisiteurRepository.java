package fr.gsb.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gsb.model.Visiteur;

public interface VisiteurRepository extends  JpaRepository<Visiteur, Integer> {

}
