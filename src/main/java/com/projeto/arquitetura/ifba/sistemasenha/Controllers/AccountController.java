package com.projeto.arquitetura.ifba.sistemasenha.Controllers;

import java.io.Serializable;
import java.util.List;

import com.projeto.arquitetura.ifba.sistemasenha.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import com.projeto.arquitetura.ifba.sistemasenha.Services.AccountService;
import com.projeto.arquitetura.ifba.sistemasenha.models.Account;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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

	@PostMapping("/adicionar")
	public ResponseEntity<String> post(Account account) throws Exception {
	accService.post(account);
	return new ResponseEntity<>("Conta Salva", HttpStatus.ACCEPTED);
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
	public ResponseEntity<String> delete(@RequestParam("id") Long id) throws Exception {
		try{
			accService.delete(id);
			return new ResponseEntity<>("Conta Deletada", HttpStatus.ACCEPTED);
		} catch (Exception e){
			return new ResponseEntity<>("Dados incorretos", HttpStatus.ACCEPTED);
		}
	}
}
