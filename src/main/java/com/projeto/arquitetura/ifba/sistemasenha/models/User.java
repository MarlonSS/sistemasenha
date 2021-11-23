package com.projeto.arquitetura.ifba.sistemasenha.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@Table(name ="user")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
private long id;
@NotBlank(message = "O nome não pode ser vazio.")
@Column(name="name")
private String name;
@NotBlank(message = "O e-mail não pode ser vazio.")
@Email
@Column(name="login")
private String login;
@NotBlank(message = "A senha não pode ser vazia.")
@Column(name="pass")
private String pass;
//private List<Institution> listInstitution;


    public void setName(String name){
        this.name = name;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public void setPass(String pass){
        this.pass = pass;
    }
}
