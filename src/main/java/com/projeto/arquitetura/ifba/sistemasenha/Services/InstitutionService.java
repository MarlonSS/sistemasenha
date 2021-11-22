package com.projeto.arquitetura.ifba.sistemasenha.Services;

import com.projeto.arquitetura.ifba.sistemasenha.Controllers.Dtos.InstitutionDTO;
import com.projeto.arquitetura.ifba.sistemasenha.Repository.AccountRepository;
import com.projeto.arquitetura.ifba.sistemasenha.Repository.InstitutionRepository;
import com.projeto.arquitetura.ifba.sistemasenha.models.Account;
import com.projeto.arquitetura.ifba.sistemasenha.models.Institution;
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
public class InstitutionService implements Serializable {

    @Autowired
    private InstitutionRepository institutionRepository;

    public List<Institution> list() {
        return institutionRepository.findAll();
    }

    public void post(@RequestBody @Valid InstitutionDTO institution) throws Exception {
        var inst = new Institution();
        if (institution == null) {
            throw new Exception("Não há nada.");
        } else {
            inst.setName(institution.getName());
            inst.setUser(institution.getUser());
            institutionRepository.save(inst);
        }
    }

    public void update(@PathVariable("")  Long id, @RequestBody Institution institution) throws Exception {
        var c = institutionRepository.findById(id);

        if (c.isPresent()) {
            var aux = c.get();
            aux.setName(institution.getName());
            institutionRepository.save(aux);
        } else {
            throw new Exception("Instituição Não encontrada.");
        }
    }

    @DeleteMapping("/")
    public void delete(@RequestParam("id") Long id) throws Exception {
        var c = institutionRepository.findById(id);

        if (c.isPresent()) {
            var aux = c.get();
            institutionRepository.delete(aux);
        } else {
            throw new Exception("Conta não encontrada.");
        }
    }
}
