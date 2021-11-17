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
@Table(name ="instiution")
public class Institution {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
private long id;
@Column(name="name")
private String name;
//private List<Account> listaccount;
}
