package it.bvsolution.studiomedico.repository;

import it.bvsolution.studiomedico.model.AssicurazioniEntity;
import it.bvsolution.studiomedico.model.AvvocatiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssicurazioniRepository extends CrudRepository<AssicurazioniEntity, Long> {

    public Optional<AssicurazioniEntity> findByNome(String nome);
    public List<AssicurazioniEntity> findAll();

}
