package it.uniroma3.siw.repository;

import org.springframework.data.repository.CrudRepository;
import it.uniroma3.siw.model.Credentials;

import java.util.Optional;

public interface CredentialsRepository extends CrudRepository<Credentials, Long> {

    Credentials findByUsername(String username);

    Optional<Credentials> findById(Long id);
}
