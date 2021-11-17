package com.projeto.arquitetura.ifba.sistemasenha.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.arquitetura.ifba.sistemasenha.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}
