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

import com.projeto.hosp.domain.Convenio;
import com.projeto.hosp.domain.Medico;
import com.projeto.hosp.repository.ConvenioRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/convenio")
public class ConvenioController {

	@Autowired
	private ConvenioRepository conRepo;
	
	@GetMapping("/listar")
	public List<Convenio> Lista(){
		return conRepo.findAll();
	}
	@GetMapping("/buscar/{id}")
	public Optional<Convenio> buscar(@PathVariable Integer id){
		return conRepo.findById(id);
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(@RequestBody Convenio con) {
		conRepo.save(con);
		return "Convênio cadastrado";
		
	}
	
	@PutMapping("/atualizar/{id}")
	public String atualizar(@PathVariable Integer id,@RequestBody Convenio con) {
		Optional<Convenio> ct = conRepo.findById(id);
		String msg = "";
		
		if(ct.isPresent()) {
			Convenio c = new Convenio();
			c.setIdconvenio(id);
			c.setNomeconvenio(con.getNomeconvenio());
			c.setCnpj(con.getCnpj());
			c.setTempocarencia(con.getTempocarencia());
			conRepo.save(c);
			
			msg = "Convenio atualizado";
		} else {
			msg = "Convenio não localizado";
		}
		return msg;
	}
	
	@DeleteMapping("/apagar/{id}")
	public String apagar(@PathVariable Integer id) {
		conRepo.deleteById(id);
			
		return "Convenio Apagado";
		}
	

}
