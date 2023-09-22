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

import com.projeto.hosp.domain.Endereco;
import com.projeto.hosp.domain.Medico;
import com.projeto.hosp.repository.MedicoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/medico")
public class MedicoController {
	
	@Autowired
	private MedicoRepository medRepo;
	
	@GetMapping("/listar")
	public List<Medico> Lista(){
		return medRepo.findAll();
	}
	@GetMapping("/buscar/{id}")
	public Optional<Medico> buscar(@PathVariable Integer id){
		return medRepo.findById(id);
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(@RequestBody Medico med) {
		medRepo.save(med);
		return "Médico cadastrado";
		
	}
	
	@PutMapping("/atualizar/{id}")
	public String atualizar(@PathVariable Integer id,@RequestBody Medico med) {
		Optional<Medico> ct = medRepo.findById(id);
		String msg = "";
		
		if(ct.isPresent()) {
			Medico m = new Medico();
			m.setIdmedico(id);
			m.setNomemed(med.getNomemed());
			m.setCpf(med.getCpf());
			m.setCrm(med.getCrm());
			m.setEmailmed(med.getEmailmed());
			m.setCargo(med.getCargo());
			medRepo.save(m);
			
			msg = "Médico atualizado";
		} else {
			msg = "Médico não localizado";
		}
		return msg;
	}
	
	@DeleteMapping("/apagar/{id}")
	public String apagar(@PathVariable Integer id) {
		medRepo.deleteById(id);
			
		return "Médico Apagado";
		}
	

}
