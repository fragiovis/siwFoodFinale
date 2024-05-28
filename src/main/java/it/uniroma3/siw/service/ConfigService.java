/*package it.uniroma3.siw.service;

import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.model.User;
import it.uniroma3.siw.repository.CredentialsRepository;
import it.uniroma3.siw.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class ConfigService implements UserDetailsService {

    @Autowired
    private CredentialsRepository credentialsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Credentials> credentials = this.credentialsRepository.findByUsername(username);

        if (credentials.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        if (!credentials.get().getPassword().equals(password)){
            throw new UsernameNotFoundException("Wrong password");
        }
        if (credentials.get().getPassword().equals(password)) {
            User user = credentials.get().getAccount();
        }
        return new org.springframework.security.core.userdetails.User(user);
    }
}*/

