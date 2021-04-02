package it.bvsolution.studiomedico.repository;

import it.bvsolution.studiomedico.model.DottoriStudiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DottoriStudiRepository extends CrudRepository<DottoriStudiEntity, Long> {

    public List<DottoriStudiEntity> findAll();
}
