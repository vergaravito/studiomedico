package it.bvsolution.studiomedico.repository;

import it.bvsolution.studiomedico.model.AvvocatiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AvvocatiRepository extends CrudRepository<AvvocatiEntity, Long> {

    Optional<AvvocatiEntity> findByNomeAndCognome(String nome,String cognome);
    List<AvvocatiEntity> findAll();
}
