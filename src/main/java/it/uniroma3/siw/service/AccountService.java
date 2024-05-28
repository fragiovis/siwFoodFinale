package it.uniroma3.siw.service;
import it.uniroma3.siw.model.Account;
import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.repository.AccountRepository;
import it.uniroma3.siw.repository.CredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CredentialsRepository credentialsRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Account getUser(Long id){
        return this.accountRepository.findById(id).orElse(null);
    }

    public void saveUser(Account account){
        this.accountRepository.save(account);
    }

    public void registerUser(String username, String password, String firstName, String lastName, Date dateOfBirth) {
        // Codifica la password prima di salvarla
        String encodedPassword = passwordEncoder.encode(password);

        // Salva le credenziali
        Credentials credentials = new Credentials();
        credentials.setUsername(username);
        credentials.setPassword(encodedPassword);
        credentials.setRole("ROLE_CHEF");
        credentialsRepository.save(credentials);

        // Salva l'account
        Account account = new Account();
        account.setName(firstName);
        account.setSurname(lastName);
        account.setCredentials(credentials);
        account.setDate(dateOfBirth);
        credentials.setAccount(account);
        accountRepository.save(account);
    }
}


