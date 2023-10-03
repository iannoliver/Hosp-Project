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

import com.projeto.hosp.domain.Tipoquarto;
import com.projeto.hosp.repository.TipoquartoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/tipoquarto")
public class TipoquartoController {

	@Autowired
	private TipoquartoRepository tipoRepo;
	
	@GetMapping("/listar")
	public List<Tipoquarto> Lista(){
		return tipoRepo.findAll();
	}
	@GetMapping("/buscar/{id}")
	public Optional<Tipoquarto> buscar(@PathVariable Integer id){
		return tipoRepo.findById(id);
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(@RequestBody Tipoquarto tipo) {
		tipoRepo.save(tipo);
		return "Tipo do quarto selecionado";
		
	}
	
	@PutMapping("/atualizar/{id}")
	public String atualizar(@PathVariable Integer id,@RequestBody Tipoquarto tipo) {
		Optional<Tipoquarto> ct = tipoRepo.findById(id);
		String msg = "";
		
		if(ct.isPresent()) {
			Tipoquarto t = new Tipoquarto();
			t.setIdtipo(id);
			t.setDescquarto(tipo.getDescquarto());
			t.setValordiario(tipo.getValordiario());
			tipoRepo.save(t);
			
			msg = "Tipo de quarto atualizado";
		} else {
			msg = "Tipo de quarto não localizado";
		}
		return msg;
	}
	
	@DeleteMapping("/apagar/{id}")
	public String apagar(@PathVariable Integer id) {
		tipoRepo.deleteById(id);
			
		return "Tipo de quarto Desocupado";
		}
}
