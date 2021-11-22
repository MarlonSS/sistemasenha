package com.projeto.arquitetura.ifba.sistemasenha.Services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.projeto.arquitetura.ifba.sistemasenha.Controllers.Dtos.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projeto.arquitetura.ifba.sistemasenha.Repository.AccountRepository;
import com.projeto.arquitetura.ifba.sistemasenha.models.Account;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Service
public class AccountService implements Serializable {

	@Autowired
	private AccountRepository accRepo;

	public List<Account> list() {
		return accRepo.findAll();
	}

	public Account findOne(@RequestParam("id") Long id){
	if(accRepo.existsById(id)) {
			Account var= accRepo.findById(id).get();
			return var;
	}else{
         	return null;
		 }
	}

	public void post(@Valid AccountDTO account) throws Exception {
		var acc = new Account();
			acc.setLogin(account.getLogin());
			acc.setPass(acc.getPass());
			acc.setInstitution(acc.getInstitution());
			accRepo.save(acc);
	}

	public void update(@PathVariable("")  Long id, @RequestBody Account account) throws Exception {
		var c = accRepo.findById(id);

		if (c.isPresent()) {
			var aux = c.get();
			aux.setLogin(account.getLogin());
			aux.setPass(account.getPass());
			accRepo.save(aux);
		} else {
			throw new Exception("Turma Não encontrada");
		}
	}

	@DeleteMapping("/")
	public void delete(@RequestParam("id") Long id) throws Exception {
		var c = accRepo.findById(id);

		if (c.isPresent()) {
			var aux = c.get();
			accRepo.delete(aux);
		} else {
			throw new Exception("Conta não encontrada.");
		}
	}

}
