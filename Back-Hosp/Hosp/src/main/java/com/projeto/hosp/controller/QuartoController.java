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

import com.projeto.hosp.domain.Quarto;
import com.projeto.hosp.repository.QuartoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/quarto")
public class QuartoController {

	@Autowired
	private QuartoRepository quarRepo;
	
	@GetMapping("/listar")
	public List<Quarto> Lista(){
		return quarRepo.findAll();
	}
	@GetMapping("/buscar/{id}")
	public Optional<Quarto> buscar(@PathVariable Integer id){
		return quarRepo.findById(id);
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(@RequestBody Quarto quar) {
		quarRepo.save(quar);
		return "Quarto selecionado";
		
	}
	
	@PutMapping("/atualizar/{id}")
	public String atualizar(@PathVariable Integer id,@RequestBody Quarto quar) {
		Optional<Quarto> ct = quarRepo.findById(id);
		String msg = "";
		
		if(ct.isPresent()) {
			Quarto q = new Quarto();
			q.setIdquarto(id);
			q.setNumero(quar.getNumero());
			q.setIdtipo(quar.getIdtipo());
			quarRepo.save(q);
			
			msg = "Quarto atualizado";
		} else {
			msg = "Quarto não localizado";
		}
		return msg;
	}
	
	@DeleteMapping("/apagar/{id}")
	public String apagar(@PathVariable Integer id) {
		quarRepo.deleteById(id);
			
		return "Quarto Desocupado";
		}
	
}
