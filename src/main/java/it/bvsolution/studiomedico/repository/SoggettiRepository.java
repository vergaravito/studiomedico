package it.bvsolution.studiomedico.repository;

import it.bvsolution.studiomedico.model.SediEntity;
import it.bvsolution.studiomedico.model.SoggettiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SoggettiRepository extends CrudRepository<SoggettiEntity, Long> {

    public Optional<SoggettiEntity> findByNomeAndCognome(String nome,String cognome);
    public List<SoggettiEntity> findAll();
    public List<SoggettiEntity> findByNomeContainsIgnoreCaseAndCognomeContainsIgnoreCaseAndTelefonoContainsAndEmailContainsIgnoreCase(String nome, String cognome, String telefono, String email);
}
