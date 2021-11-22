package com.projeto.arquitetura.ifba.sistemasenha.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name ="account")
public class Account  {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
private long id;
@NotBlank(message = "O e-mail não pode ser vazio.")
@Email
@Column(name="login")
private String login;
@Column(name="pass")
private String pass;
@ManyToOne(cascade=CascadeType.ALL)
@JoinColumn(name = "id_institution")
private Institution institution;
}
