package com.projeto.arquitetura.ifba.sistemasenha.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="user")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
private long id;
@Column(name="Name")
private String name;
@Column(name="login")
private String login;
@Column(name="pass")
private String pass;
//private List<Institution> listInstitution;
}
