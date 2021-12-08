package com.projeto.arquitetura.ifba.sistemasenha.Services;

import com.projeto.arquitetura.ifba.sistemasenha.Repository.UserRepository;
import com.projeto.arquitetura.ifba.sistemasenha.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class CustomUserDetailService implements UserDetailsService {


    private UserRepository userRepository;

    @Autowired
    public UserRepository getUserRepository() {
        return userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user = Optional.ofNullable(userRepository.findByUserName(username)).orElseThrow(() -> new UsernameNotFoundException("Not Found"));
       List<GrantedAuthority> listAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
       List<GrantedAuthority> listUser = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
   return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPass(), listAdmin);

    }
}
