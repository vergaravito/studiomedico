package it.bvsolution.studiomedico.repository;

import it.bvsolution.studiomedico.model.SediEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SediRepository extends CrudRepository<SediEntity, Long> {

    Optional<SediEntity> findByNome(String nome);
    List<SediEntity> findAll();
}
