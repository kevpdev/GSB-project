package fr.gsb.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gsb.model.Medicament;

public interface MedicamentRepository extends JpaRepository<Medicament, Integer> {

}
