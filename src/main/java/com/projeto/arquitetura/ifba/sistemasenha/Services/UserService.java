package com.projeto.arquitetura.ifba.sistemasenha.Services;

import com.projeto.arquitetura.ifba.sistemasenha.Repository.UserRepository;
import com.projeto.arquitetura.ifba.sistemasenha.models.Account;
import com.projeto.arquitetura.ifba.sistemasenha.models.Institution;
import com.projeto.arquitetura.ifba.sistemasenha.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

@Service
public class UserService implements Serializable {

    @Autowired
    private UserRepository userRepository;

    public List<User> list() {
        return userRepository.findAll();
    }

    public User findOne(@RequestParam("id") Long id){
        if(userRepository.existsById(id)) {
            User var= userRepository.findById(id).get();
            return var;
        }else{
            return null;
        }
    }

    public void post(@Valid User user) throws Exception {
         var us = new User();
        if (user == null) {
            throw new Exception("Não há nada.");
        } else {
            us.setName(user.getName());
            us.setLogin(user.getLogin());
            us.setPass(user.getPass());
            userRepository.save(us);
        }
    }

    public void update(@PathVariable("")  Long id, @RequestBody @Valid User user) throws Exception {
        var c = userRepository.findById(id);

        if (c.isPresent()) {
            var aux = c.get();
            aux.setName(user.getName());
            aux.setLogin(user.getLogin());
            aux.setPass(user.getPass());
            userRepository.save(aux);
        } else {
            throw new Exception("Usuário Não encontrado.");
        }
    }

    @DeleteMapping("/")
    public void delete(@RequestParam("id") Long id) throws Exception {
        var c = userRepository.findById(id);

        if (c.isPresent()) {
            var aux = c.get();
            userRepository.delete(aux);
        } else {
            throw new Exception("Usuário não encontrado.");
        }
    }
}

