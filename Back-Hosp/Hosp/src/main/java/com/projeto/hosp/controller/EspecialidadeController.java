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

import com.projeto.hosp.domain.Especialidade;
import com.projeto.hosp.repository.EspecialidadeRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/especialidade")
public class EspecialidadeController {

	@Autowired
	private EspecialidadeRepository espRepo;
	
	@GetMapping("/listar")
	public List<Especialidade> Lista(){
		return espRepo.findAll();
	}
	@GetMapping("/buscar/{id}")
	public Optional<Especialidade> buscar(@PathVariable Integer id){
		return espRepo.findById(id);
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(@RequestBody Especialidade esp) {
		espRepo.save(esp);
		return "espvênio cadastrado";
		
	}
	
	@PutMapping("/atualizar/{id}")
	public String atualizar(@PathVariable Integer id,@RequestBody Especialidade esp) {
		Optional<Especialidade> ct = espRepo.findById(id);
		String msg = "";
		
		if(ct.isPresent()) {
			Especialidade e = new Especialidade();
			e.setIdespecialidade(id);
			e.setNomeespecialidade(esp.getNomeespecialidade());
			espRepo.save(e);
			
			msg = "Especialidade atualizada";
		} else {
			msg = "Especialidade não localizada";
		}
		return msg;
	}
	
	@DeleteMapping("/apagar/{id}")
	public String apagar(@PathVariable Integer id) {
		espRepo.deleteById(id);
			
		return "Especialidade Apagada";
		}
}
