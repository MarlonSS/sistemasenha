package com.projeto.arquitetura.ifba.sistemasenha.Controllers;

import com.projeto.arquitetura.ifba.sistemasenha.Services.AccountService;
import com.projeto.arquitetura.ifba.sistemasenha.Services.InstitutionService;
import com.projeto.arquitetura.ifba.sistemasenha.models.Account;
import com.projeto.arquitetura.ifba.sistemasenha.models.Institution;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping("/instituicao")
public class InstitutionController implements Serializable {

    @Autowired
    private InstitutionService institutionService;



    @GetMapping("/listar")
    public List<Institution> listAll(){
        return institutionService.list();
    }

    @PostMapping("/adicionar")
    public ResponseEntity<String> post(Institution institution) throws Exception {
        institutionService.post(institution);
        return new ResponseEntity<>("Conta Salva", HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> put(@PathVariable("") Long id, @RequestBody Institution institution) throws Exception {
        try{
            institutionService.update(id, institution);
            return new ResponseEntity<>("Conta Salva", HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>("Dados incorretos", HttpStatus.ACCEPTED);
        }
    }
    @DeleteMapping("/")
    public ResponseEntity<String> delete(@RequestParam("id") Long id) throws Exception {
        try{
            institutionService.delete(id);
            return new ResponseEntity<>("Conta Deletada", HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>("Dados incorretos", HttpStatus.ACCEPTED);
        }
    }
}
