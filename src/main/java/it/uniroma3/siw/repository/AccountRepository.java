package it.uniroma3.siw.repository;

import it.uniroma3.siw.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AccountRepository extends CrudRepository<Account,Long> {
    Optional<Account> findById(Long id);
}
