package it.uniroma3.siw.validator;

import it.uniroma3.siw.model.Account;
import it.uniroma3.siw.repository.CredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CredentialsValidator {

    @Autowired
    private CredentialsRepository credentialsRepository;

    public void validate(Account account) {
        if (credentialsRepository.findByUsername(account.getCredentials().getUsername())!=null) {
            throw new IllegalArgumentException("Username già esistente.");
        }
    }
}
