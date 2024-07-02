package com.example.medicaments.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.medicaments.models.Medicament;
import com.example.medicaments.repositories.MedicamentRepository;

@Service
public class MedicamentService {

	@Autowired
	private MedicamentRepository repository;

	public List<Medicament> findAll() {
		return repository.findAll();
	}

	public Medicament insert(Medicament obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

}
