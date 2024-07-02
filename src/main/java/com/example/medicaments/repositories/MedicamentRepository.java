package com.example.medicaments.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.medicaments.models.Medicament;

public interface MedicamentRepository extends JpaRepository<Medicament, Long> {

}
