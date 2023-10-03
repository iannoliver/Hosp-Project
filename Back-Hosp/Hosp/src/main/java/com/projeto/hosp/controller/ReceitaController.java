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

import com.projeto.hosp.domain.Receita;
import com.projeto.hosp.repository.ReceitaRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/receita")
public class ReceitaController {

	@Autowired
	private ReceitaRepository recRepo;
	
	@GetMapping("/listar")
	public List<Receita> Lista(){
		return recRepo.findAll();
	}
	@GetMapping("/buscar/{id}")
	public Optional<Receita> buscar(@PathVariable Integer id){
		return recRepo.findById(id);
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(@RequestBody Receita rec) {
		recRepo.save(rec);
		return "Receita cadastrada";
		
	}
	
	@PutMapping("/atualizar/{id}")
	public String atualizar(@PathVariable Integer id,@RequestBody Receita rec) {
		Optional<Receita> ct = recRepo.findById(id);
		String msg = "";
		
		if(ct.isPresent()) {
			Receita r = new Receita();
			r.setIdreceita(id);
			r.setMedicamento(rec.getMedicamento());
			r.setQtdmedicamento(rec.getQtdmedicamento());			
			r.setInstrucaouso(rec.getInstrucaouso());
			r.setIdconsulta(rec.getIdconsulta());
			recRepo.save(r);
			
			msg = "Receita atualizada";
		} else {
			msg = "Receita não localizada";
		}
		return msg;
	}
	
	@DeleteMapping("/apagar/{id}")
	public String apagar(@PathVariable Integer id) {
		recRepo.deleteById(id);
			
		return "Receita Apagada";
		}
	
}
