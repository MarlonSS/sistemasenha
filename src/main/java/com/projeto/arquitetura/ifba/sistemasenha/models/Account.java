package com.projeto.arquitetura.ifba.sistemasenha.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name ="account")
public class Account implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
private long id;
@Column(name="login")
private String login;
@Column(name="pass")
private String pass;
}
