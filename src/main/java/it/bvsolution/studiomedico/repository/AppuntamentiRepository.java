package it.bvsolution.studiomedico.repository;

import it.bvsolution.studiomedico.model.AppuntamentiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppuntamentiRepository extends CrudRepository<AppuntamentiEntity, Long> {

    public List<AppuntamentiEntity> findByDataAppuntamento(Date data);
    public List<AppuntamentiEntity> findAllByDataAppuntamentoBetween(Date data1, Date data2);
    public List<AppuntamentiEntity> findAll();
}
