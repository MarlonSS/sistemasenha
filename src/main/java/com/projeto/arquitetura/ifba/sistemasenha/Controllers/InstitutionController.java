package com.projeto.arquitetura.ifba.sistemasenha.Controllers;

import com.projeto.arquitetura.ifba.sistemasenha.Controllers.Dtos.InstitutionDTO;
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

import javax.validation.Valid;
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

    @PostMapping(path = "/adicionar", produces = "application/json")
    public ResponseEntity<String> post(@RequestBody @Valid InstitutionDTO institution) throws Exception {
        if (institution != null) {
            institutionService.post(institution);
            return new ResponseEntity<>("Conta Salva", HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("Dados vazios.", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> put(@PathVariable("") Long id, @RequestBody Institution institution) throws Exception {
        try{
            if(institution != null) {
                institutionService.update(id, institution);
                return new ResponseEntity<>("Conta Salva", HttpStatus.ACCEPTED);
            }else{
                return new ResponseEntity<>("Dados vazios.", HttpStatus.NOT_ACCEPTABLE);
            }
        } catch (Exception e){
            return new ResponseEntity<>("Dados incorretos", HttpStatus.NOT_ACCEPTABLE);
        }
    }
    @DeleteMapping("/")
    public ResponseEntity<String> delete(@RequestParam("id") Long id) throws Exception {
        try{
            institutionService.delete(id);
            return new ResponseEntity<>("Conta Deletada", HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>("Dados incorretos", HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
