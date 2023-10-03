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

import com.projeto.hosp.domain.Telefone;
import com.projeto.hosp.repository.TelefoneRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/Telefone")
public class TelefoneController {

	@Autowired
	private TelefoneRepository telRepo;
	
	@GetMapping("/listar")
	public List<Telefone> Lista(){
		return telRepo.findAll();
	}
	@GetMapping("/buscar/{id}")
	public Optional<Telefone> buscar(@PathVariable Integer id){
		return telRepo.findById(id);
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(@RequestBody Telefone tel) {
		telRepo.save(tel);
		return "Telefone cadastrado";
		
	}
	
	@PutMapping("/atualizar/{id}")
	public String atualizar(@PathVariable Integer id,@RequestBody Telefone tel) {
		Optional<Telefone> ct = telRepo.findById(id);
		String msg = "";
		
		if(ct.isPresent()) {
			Telefone t = new Telefone();
			t.setIdtelefone(id);
			t.setDdd(tel.getDdd());
			t.setNumero(tel.getNumero());
			t.setIdmedico(tel.getIdmedico());
			t.setIdpaciente(tel.getIdpaciente());
			telRepo.save(t);
			
			msg = "Telefone atualizado";
		} else {
			msg = "Telefone não localizado";
		}
		return msg;
	}
	
	@DeleteMapping("/apagar/{id}")
	public String apagar(@PathVariable Integer id) {
		telRepo.deleteById(id);
			
		return "Telefone Apagado";
		}
}
