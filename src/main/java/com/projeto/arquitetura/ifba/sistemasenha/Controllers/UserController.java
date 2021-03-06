package com.projeto.arquitetura.ifba.sistemasenha.Controllers;

import com.projeto.arquitetura.ifba.sistemasenha.Controllers.Dtos.UserDto;
import com.projeto.arquitetura.ifba.sistemasenha.Services.AccountService;
import com.projeto.arquitetura.ifba.sistemasenha.Services.UserService;
import com.projeto.arquitetura.ifba.sistemasenha.models.Account;
import com.projeto.arquitetura.ifba.sistemasenha.models.Institution;
import com.projeto.arquitetura.ifba.sistemasenha.models.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;


@RestController
@RequestMapping("/usuario")
public class UserController implements Serializable {

    @Autowired
    private UserService userService;

    @GetMapping("/listar")
    public List<User> listAll(){
        return userService.list();
    }

    @GetMapping("/listarUnico")
    public ResponseEntity<User> findOne(@RequestParam ("id") Long id){
        return new ResponseEntity<>(userService.findOne(id), HttpStatus.OK);
    }

    @PostMapping("/adicionar")
    public ResponseEntity<String> post(@RequestBody @Valid UserDto user) throws Exception {
        userService.post(user);
        return new ResponseEntity<>("Conta Salva", HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> put(@PathVariable("") Long id, @RequestBody User user) throws Exception {
        try{
            userService.update(id, user);
            return new ResponseEntity<>("Conta Salva", HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>("Dados Vazios", HttpStatus.NOT_ACCEPTABLE);
        }
    }
    @DeleteMapping("/")
    public ResponseEntity<String> delete(@RequestParam("id") Long id) throws Exception {
        try{
            userService.delete(id);
            return new ResponseEntity<>("Conta Deletada", HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>("Dados incorretos", HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
