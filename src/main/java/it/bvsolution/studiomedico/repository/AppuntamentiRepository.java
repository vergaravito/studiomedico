package it.bvsolution.studiomedico.repository;

import it.bvsolution.studiomedico.model.AppuntamentiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppuntamentiRepository extends CrudRepository<AppuntamentiEntity, Long> {

    List<AppuntamentiEntity> findByDataAppuntamento(LocalDateTime data);
    List<AppuntamentiEntity> findAllByDataAppuntamentoBetween(LocalDateTime data1, LocalDateTime data2);
    List<AppuntamentiEntity> findAll();
}
