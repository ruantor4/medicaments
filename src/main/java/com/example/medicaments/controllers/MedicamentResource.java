package com.example.medicaments.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.medicaments.models.Medicament;
import com.example.medicaments.services.MedicamentService;

@RestController
@RequestMapping(value = "/medicaments")
public class MedicamentResource {

	@Autowired
	private MedicamentService service;

	@GetMapping
	public ResponseEntity<List<Medicament>> findAll() {
		List<Medicament> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Medicament> findById(@PathVariable Long id) {
		Medicament obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Medicament> insert(@RequestBody Medicament obj) {
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Medicament> update(@PathVariable Long id, @RequestBody Medicament obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);

	}
}