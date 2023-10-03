package com.projeto.hosp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.hosp.domain.Plantao;
import com.projeto.hosp.repository.PlantaoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/plantao")
public class PlantaoController {

	@Autowired
	private PlantaoRepository plantRepo;
	
	@GetMapping("/listar")
	public List<Plantao> Lista(){
		return plantRepo.findAll();
	}
	@GetMapping("/buscar/{id}")
	public Optional<Plantao> buscar(@PathVariable Integer id){
		return plantRepo.findById(id);
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(@RequestBody Plantao plant) {
		plantRepo.save(plant);
		return "Plantão cadastrado";
		
	}
	
	@PutMapping("/atualizar/{id}")
	public String atualizar(@PathVariable Integer id,@RequestBody Plantao plant) {
		Optional<Plantao> ct = plantRepo.findById(id);
		String msg = "";
		
		if(ct.isPresent()) {
			Plantao p = new Plantao();
			p.setIdplantao(id);
			p.setDtplantao(plant.getDtplantao());
			p.setHoraplantao(plant.getHoraplantao());			
			p.setIdinternacao(plant.getIdinternacao());
			p.setIdenfermeira(plant.getIdenfermeira());
			plantRepo.save(p);
			
			msg = "Plantão atualizado";
		} else {
			msg = "Plantão não localizado";
		}
		return msg;
	}
	
	@DeleteMapping("/apagar/{id}")
	public String apagar(@PathVariable Integer id) {
		plantRepo.deleteById(id);
			
		return "Plantão Apagado";
		}
	
}
