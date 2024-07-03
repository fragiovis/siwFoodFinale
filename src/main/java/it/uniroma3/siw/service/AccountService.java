package it.uniroma3.siw.service;
import it.uniroma3.siw.model.Account;
import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.model.Cuoco;
import it.uniroma3.siw.repository.AccountRepository;
import it.uniroma3.siw.repository.CredentialsRepository;
import it.uniroma3.siw.repository.CuocoRepository;
import it.uniroma3.siw.validator.CredentialsValidator;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Date;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CredentialsRepository credentialsRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CuocoRepository cuocoRepository;
    @Autowired
    private CredentialsValidator credentialsValidator;


    public Account getUser(Long id){
        return this.accountRepository.findById(id).orElse(null);
    }

    public void saveUser(Account account){
        this.accountRepository.save(account);
    }


    @Transactional
    public Account registerUser(String username, String password, String firstName, String lastName, Date dateOfBirth, String immagineFileName) {
        String encodedPassword = passwordEncoder.encode(password);

        Credentials credentials = new Credentials();
        credentials.setUsername(username);
        credentials.setPassword(encodedPassword);
        credentials.setRole("ROLE_CHEF");

        Account account = new Account();
        account.setName(firstName);
        account.setSurname(lastName);
        account.setCredentials(credentials);
        account.setDate(dateOfBirth);
        account.setImmagine("/images/uploads/account-photos/" + immagineFileName); // Percorso completo
        credentials.setAccount(account);

        Cuoco cuoco = new Cuoco();
        account.setCuoco(cuoco);
        cuoco.setName(firstName);
        cuoco.setSurname(lastName);
        cuoco.setDateOfBirth(dateOfBirth);
        cuoco.setAccount(account);

        credentialsValidator.validate(account);
        accountRepository.save(account);
        return account;
    }




}


