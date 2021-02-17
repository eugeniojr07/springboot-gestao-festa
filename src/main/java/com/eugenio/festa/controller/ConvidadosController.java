package com.eugenio.festa.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eugenio.festa.model.Convidado;
import com.eugenio.festa.repository.Convidados;

	@CrossOrigin(origins = "http://localhost:4200")
	@RestController 
	@RequestMapping("/convidados")
	public class ConvidadosController {
	
	@Autowired
	private Convidados convidados;

	@GetMapping
	public ArrayList<Convidado> listar() {
	  return (ArrayList<Convidado>) convidados.findAll();
	}
	
	// criando convidado rest api
		@PostMapping
		public Convidado criarConvidado(@RequestBody Convidado convidado) {
			return convidados.save(convidado);
		}	
	
		// get convidado by id rest api
		@GetMapping("/{id}")
		public ResponseEntity<Convidado> getConvidadoById(@PathVariable(value = "id") Long id) {
			Optional<Convidado> convidado = convidados.findById(id);
			
			if(convidado.isPresent())
	            return new ResponseEntity<Convidado>(convidado.get(), HttpStatus.OK);
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		// atualizando convidado rest api
		@PutMapping("/{id}")
		public ResponseEntity<Convidado> atualizaConvidado(@PathVariable Long id, @RequestBody Convidado convidadoDetalhes){
			Optional<Convidado> convidado = convidados.findById(id);
			
			if(convidado.isPresent()){
				Convidado convidadoNovo = convidado.get();
				convidadoNovo.setNome(convidadoDetalhes.getNome());
				convidadoNovo.setQuantidadeAcompanhantes(convidadoDetalhes.getQuantidade_acompanhantes());
	            convidados.save(convidadoNovo);
	            return new ResponseEntity<Convidado>(convidadoNovo, HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		// deletando convidado rest api
		@DeleteMapping("/{id}")
		public ResponseEntity<Map<String, Boolean>> deletaConvidado(@PathVariable Long id){
			Optional<Convidado> convidado = convidados.findById(id);
			
			if(convidado.isPresent()){
			Convidado convidadoNovo = convidado.get();
			convidados.delete(convidadoNovo);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return new ResponseEntity<Map<String,Boolean>>(response,HttpStatus.OK);
			} else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
}

