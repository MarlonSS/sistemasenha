package com.projeto.arquitetura.ifba.sistemasenha.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="institution")
public class Institution implements Serializable{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
private long id;
@NotBlank
@Column(name="name")
private String name;
@ManyToOne(cascade=CascadeType.ALL)
@JoinColumn(name = "iduser")
private User user;
}
