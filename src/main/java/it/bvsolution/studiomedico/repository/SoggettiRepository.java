package it.bvsolution.studiomedico.repository;

import it.bvsolution.studiomedico.model.SoggettiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SoggettiRepository extends CrudRepository<SoggettiEntity, Long> {

    Optional<SoggettiEntity> findByNomeAndCognome(String nome,String cognome);
    List<SoggettiEntity> findAll();
    List<SoggettiEntity> findByNomeContainsIgnoreCaseAndCognomeContainsIgnoreCaseAndTelefonoContainsAndEmailContainsIgnoreCase(String nome, String cognome, String telefono, String email);
}
