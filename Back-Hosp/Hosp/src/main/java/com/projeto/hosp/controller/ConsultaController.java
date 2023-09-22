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

import com.projeto.hosp.domain.Consulta;
import com.projeto.hosp.domain.Consulta;
import com.projeto.hosp.repository.ConsultaRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/consulta")
public class ConsultaController {
	
	@Autowired
	private ConsultaRepository conRepo;
	
	@GetMapping("/listar")
	public List<Consulta> Lista(){
		return conRepo.findAll();
	}
	@GetMapping("/buscar/{id}")
	public Optional<Consulta> buscar(@PathVariable Integer id){
		return conRepo.findById(id);
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(@RequestBody Consulta con) {
		conRepo.save(con);
		return "Consulta cadastrada";
		
	}
	
	@PutMapping("/atualizar/{id}")
	public String atualizar(@PathVariable Integer id,@RequestBody Consulta con) {
		Optional<Consulta> ct = conRepo.findById(id);
		String msg = "";
		
		if(ct.isPresent()) {
			Consulta c = new Consulta();
			c.setIdconsulta(id);
			c.setDataconsulta(con.getDataconsulta());
			c.setHoraconsulta(con.getHoraconsulta());
			c.setValorconsulta(con.getValorconsulta());
			conRepo.save(c);
			
			msg = "Consulta atualizada";
		} else {
			msg = "Consulta não localizada";
		}
		return msg;
	}
	
	@DeleteMapping("/apagar/{id}")
	public String apagar(@PathVariable Integer id) {
		conRepo.deleteById(id);
			
		return "Consulta Apagada";
		}

}
