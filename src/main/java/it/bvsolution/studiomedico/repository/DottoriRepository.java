package it.bvsolution.studiomedico.repository;

import it.bvsolution.studiomedico.model.DottoriEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DottoriRepository extends CrudRepository<DottoriEntity, Long> {

    Optional<DottoriEntity> findByNomeAndCognome(String nome,String cognome);
    List<DottoriEntity> findAll();
}
