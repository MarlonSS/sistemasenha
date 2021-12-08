package com.projeto.arquitetura.ifba.sistemasenha.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name ="user")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
private long id;
@Column(name="name")
private String name;
@Column(name="username")
private String username;
@Column(name="pass")
private String pass;


}
