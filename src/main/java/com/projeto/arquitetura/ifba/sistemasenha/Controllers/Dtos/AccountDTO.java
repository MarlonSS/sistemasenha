package com.projeto.arquitetura.ifba.sistemasenha.Controllers.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDTO {
    private String login;
    private String pass;
    private int institution;

}
