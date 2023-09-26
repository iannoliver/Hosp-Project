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
import com.projeto.hosp.repository.EnderecoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository endRepo;
	
	@GetMapping("/listar")
	public List<Endereco> Lista(){
		return endRepo.findAll();
	}
	@GetMapping("/buscar/{id}")
	public Optional<Endereco> buscar(@PathVariable Integer id){
		return endRepo.findById(id);
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(@RequestBody Endereco end) {
		endRepo.save(end);
		return "endvênio cadastrado";
		
	}
	
	@PutMapping("/atualizar/{id}")
	public String atualizar(@PathVariable Integer id,@RequestBody Endereco end) {
		Optional<Endereco> ct = endRepo.findById(id);
		String msg = "";
		
		if(ct.isPresent()) {
			Endereco e = new Endereco();
			e.setIdendereco(id);
			e.setLog(end.getLog());
			e.setCep(end.getCep());
			e.setNumero(end.getNumero());
			e.setComplemento(end.getComplemento());
			e.setReferencia(end.getReferencia());
			e.setBairro(end.getBairro());
			e.setCidade(end.getCidade());
			e.setEstado(end.getEstado());
			endRepo.save(e);
			
			msg = "Endereco atualizado";
		} else {
			msg = "Endereco não localizado";
		}
		return msg;
	}
	
	@DeleteMapping("/apagar/{id}")
	public String apagar(@PathVariable Integer id) {
		endRepo.deleteById(id);
			
		return "Endereco Apagado";
		}
	


}
