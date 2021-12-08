package com.projeto.arquitetura.ifba.sistemasenha.Controllers;

import java.io.Serializable;
import java.util.List;

import com.projeto.arquitetura.ifba.sistemasenha.Controllers.Dtos.AccountDTO;
import com.projeto.arquitetura.ifba.sistemasenha.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import com.projeto.arquitetura.ifba.sistemasenha.Services.AccountService;
import com.projeto.arquitetura.ifba.sistemasenha.models.Account;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

@NoArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping("/conta")
public class AccountController implements Serializable {

	@Autowired
	private AccountService accService;


	
	@GetMapping("/listar")
	public List<Account> listAll(){
		return accService.list();
	}

	@GetMapping("/listarUnico")
	public ResponseEntity<Account> findOne(@RequestParam("id") Long id){
	return new ResponseEntity<>(accService.findOne(id), HttpStatus.OK);
	}

	@PostMapping(path = "/adicionar", produces = "application/json")
	public ResponseEntity<String> post(@RequestBody @Valid AccountDTO account) throws Exception {
		if(account != null) {
			accService.post(account);
			return new ResponseEntity<>("Conta Salva", HttpStatus.ACCEPTED);
		}else{
			return new ResponseEntity<>("Dados incorretos ou vazios.", HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> put(@PathVariable("") Long id, @RequestBody Account account) throws Exception {
		try{
		accService.update(id, account);
		return new ResponseEntity<>("Conta Salva", HttpStatus.ACCEPTED);
	} catch (Exception e){
		return new ResponseEntity<>("Dados incorretos", HttpStatus.ACCEPTED);
		}
		}
	@DeleteMapping("/")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> delete(@RequestParam("id") Long id) throws Exception {
		try{
			accService.delete(id);
			return new ResponseEntity<>("Conta Deletada", HttpStatus.ACCEPTED);
		} catch (Exception e){
			return new ResponseEntity<>("Dados incorretos", HttpStatus.ACCEPTED);
		}
	}
}
