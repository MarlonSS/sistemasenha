package com.projeto.arquitetura.ifba.sistemasenha.Controllers.Dtos;

import com.projeto.arquitetura.ifba.sistemasenha.models.Institution;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDTO {
    private String login;
    private String pass;
    private Institution institution;

}
