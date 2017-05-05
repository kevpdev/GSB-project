package fr.gsb.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gsb.model.Praticien;

public interface PraticienRepository extends JpaRepository<Praticien, Integer> {

}
