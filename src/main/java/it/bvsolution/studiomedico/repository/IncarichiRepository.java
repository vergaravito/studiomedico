package it.bvsolution.studiomedico.repository;

import it.bvsolution.studiomedico.model.IncarichiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncarichiRepository extends CrudRepository<IncarichiEntity, Long> {

    public List<IncarichiEntity> findByTipo(String tipo);
    public List<IncarichiEntity> findAll();
}