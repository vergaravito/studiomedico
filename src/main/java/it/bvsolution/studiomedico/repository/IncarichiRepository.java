package it.bvsolution.studiomedico.repository;

import it.bvsolution.studiomedico.model.IncarichiEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncarichiRepository extends CrudRepository<IncarichiEntity, Long> {

    List<IncarichiEntity> findByTipo(String tipo);
    List<IncarichiEntity> findAll();
    List<IncarichiEntity> findByIdSoggetto(Long idSoggetto);

    @Query(value = "SELECT nextval('incarichi_id_seq')", nativeQuery = true)
    Long getCurrentValFromSequence();

}
