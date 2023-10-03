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

import com.projeto.hosp.domain.Paciente;
import com.projeto.hosp.repository.PacienteRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/paciente")
public class PacienteController {

	@Autowired
	private PacienteRepository paciRepo;
	
	@GetMapping("/listar")
	public List<Paciente> Lista(){
		return paciRepo.findAll();
	}
	@GetMapping("/buscar/{id}")
	public Optional<Paciente> buscar(@PathVariable Integer id){
		return paciRepo.findById(id);
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(@RequestBody Paciente paci) {
		paciRepo.save(paci);
		return "Paciente cadastrado";
		
	}
	
	@PutMapping("/atualizar/{id}")
	public String atualizar(@PathVariable Integer id,@RequestBody Paciente paci) {
		Optional<Paciente> ct = paciRepo.findById(id);
		String msg = "";
		
		if(ct.isPresent()) {
			Paciente p = new Paciente();
			p.setIdpaciente(id);
			p.setNomepaciente(paci.getNomepaciente());
			p.setDtnascimento(paci.getDtnascimento());
			p.setCpfpaciente(paci.getCpfpaciente());
			p.setRgpaciente(paci.getRgpaciente());
			p.setEmailpaciente(paci.getEmailpaciente());
			p.setIdconvenio(paci.getIdconvenio());
			paciRepo.save(p);
			
			msg = "Paciente atualizado";
		} else {
			msg = "Paciente não localizado";
		}
		return msg;
	}
	
	@DeleteMapping("/apagar/{id}")
	public String apagar(@PathVariable Integer id) {
		paciRepo.deleteById(id);
			
		return "Paciente Apagado";
		}
	
}
