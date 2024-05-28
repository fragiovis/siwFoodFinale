package it.uniroma3.siw.repository;

import it.uniroma3.siw.model.Ricetta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RicettaRepository extends CrudRepository<Ricetta,Long> {
    @Query(value="select * "
            + "from ricetta r "
            + "where r.id not in "
            + "(select ricette_id "
            + "from cuoco_ricette "
            + "where cuoco_ricette.cuoco_id = :cuocoId)", nativeQuery=true)
    Iterable<Ricetta> findRicetteNotInCuoco(@Param("cuocoId") Long id);

    Iterable<Ricetta> findByName(String name);
}
