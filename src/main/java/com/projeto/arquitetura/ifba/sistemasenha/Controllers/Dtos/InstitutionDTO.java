package com.projeto.arquitetura.ifba.sistemasenha.Controllers.Dtos;

import com.projeto.arquitetura.ifba.sistemasenha.models.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InstitutionDTO {
    private String name;
    private User user;
}
