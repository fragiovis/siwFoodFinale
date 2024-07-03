package it.uniroma3.siw.service;

import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.repository.CredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CredentialsService {
    @Autowired
    private CredentialsRepository credentialsRepository;

    public Optional<Credentials> getCredentials(Long id){
        return this.credentialsRepository.findById(id);
    }
    public Credentials getCredentials(String username){
        return this.credentialsRepository.findByUsername(username);
    }
    public void saveCredentials(Credentials credentials){
        this.credentialsRepository.save(credentials);
    }

    public Credentials findByUsername(String username) {
        return this.credentialsRepository.findByUsername(username);
    }
}
