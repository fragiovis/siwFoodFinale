/*package it.uniroma3.siw.security;

import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.model.Account;
import it.uniroma3.siw.repository.CredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final CredentialsRepository credentialsRepository;

    @Autowired
    public CustomUserDetailsService(CredentialsRepository credentialsRepository) {
        this.credentialsRepository = credentialsRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Credentials credentials = credentialsRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return org.springframework.security.core.userdetails.User.withUsername(credentials.getUsername())
                .password(credentials.getPassword())
                .authorities(credentials.getRole())
                .build();
    }

    public Account loadUserDetails(String username) {
        Credentials credentials = credentialsRepository.findByUsername(username).orElse(null);
        return credentials != null ? credentials.getAccount() : null;
    }
}
*/
