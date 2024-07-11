package com.example.medicaments.services;

import java.util.List;
import java.util.Optional;

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

	public Medicament findById(Long id) {
		Optional<Medicament> obj = repository.findById(id);
		return obj.get();
	}

	public Medicament insert(Medicament obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Medicament update(Long id, Medicament obj) {
		Medicament entity = repository.getReferenceById(id);
		updateDate(entity, obj);
		return repository.save(entity);
	}

	private void updateDate(Medicament entity, Medicament obj) {
		entity.setName(obj.getName());
		entity.setApresentation(obj.getApresentation());
		entity.setLaboratory(obj.getLaboratory());

	}

}
