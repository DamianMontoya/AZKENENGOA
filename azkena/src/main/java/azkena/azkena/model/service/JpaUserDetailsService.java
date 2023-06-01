package azkena.azkena.model.service;

import azkena.azkena.model.dao.IClienteDAO;
import azkena.azkena.model.identity.Cliente;
import azkena.azkena.model.identity.Rol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("gpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService {
    @Autowired
    private IClienteDAO clienteDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Cliente usuario = clienteDAO.findByUsername(username);

        if(usuario == null) {
            throw new UsernameNotFoundException("Username: " + username + " no existe en el sistema!");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(usuario.getRol().getRol()));

        return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, authorities);
    }
}

