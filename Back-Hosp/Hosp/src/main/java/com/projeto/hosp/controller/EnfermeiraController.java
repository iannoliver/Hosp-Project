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

import com.projeto.hosp.domain.Enfermeira;
import com.projeto.hosp.repository.EnfermeiraRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/enfermeira")
public class EnfermeiraController {
	
	@Autowired
	private EnfermeiraRepository enfRepo;
	
	@GetMapping("/listar")
	public List<Enfermeira> Lista(){
		return enfRepo.findAll();
	}
	@GetMapping("/buscar/{id}")
	public Optional<Enfermeira> buscar(@PathVariable Integer id){
		return enfRepo.findById(id);
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(@RequestBody Enfermeira enf) {
		enfRepo.save(enf);
		return "enfvênio cadastrado";
		
	}
	
	@PutMapping("/atualizar/{id}")
	public String atualizar(@PathVariable Integer id,@RequestBody Enfermeira enf) {
		Optional<Enfermeira> ct = enfRepo.findById(id);
		String msg = "";
		
		if(ct.isPresent()) {
			Enfermeira e = new Enfermeira();
			e.setIdenfermeira(id);
			e.setNomeenfermeira(enf.getNomeenfermeira());
			e.setCpfenfermeira(enf.getCpfenfermeira());
			e.setCoren(enf.getCoren());
			enfRepo.save(e);
			
			msg = "Enfermeira atualizada";
		} else {
			msg = "Enfermeira não localizada";
		}
		return msg;
	}
	
	@DeleteMapping("/apagar/{id}")
	public String apagar(@PathVariable Integer id) {
		enfRepo.deleteById(id);
			
		return "Enfermeira Apagada";
		}

}
