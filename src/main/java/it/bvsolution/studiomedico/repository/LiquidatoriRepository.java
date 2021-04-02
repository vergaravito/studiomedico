package it.bvsolution.studiomedico.repository;

import it.bvsolution.studiomedico.model.LiquidatoriEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LiquidatoriRepository extends CrudRepository<LiquidatoriEntity, Long> {

    public Optional<LiquidatoriEntity> findByNomeAndCognome(String nome,String cognome);
    public List<LiquidatoriEntity> findAll();
    public List<LiquidatoriEntity> findByIdAssicurazione(Long idAssicurazione);
}
