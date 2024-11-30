package it.bvsolution.studiomedico.model;

import javax.persistence.*;

@Entity(name = "dottori_studi")
@Table(name = "dottori_studi")
public class DottoriStudiEntity {

    @Id
    @SequenceGenerator(name="dottori_studi_pk_sequence",sequenceName="dottori_studi_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="dottori_studi_pk_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "id_dottore")
    private Long idDottore;

    @Column(name = "id_studio")
    private Long idStudio;

    public DottoriStudiEntity() {
        super();
    }

    public DottoriStudiEntity(Long id, Long idDottore, Long idStudio) {
        this.id = id;
        this.idDottore = idDottore;
        this.idStudio = idStudio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdDottore() {
        return idDottore;
    }

    public void setIdDottore(Long idDottore) {
        this.idDottore = idDottore;
    }

    public Long getIdStudio() {
        return idStudio;
    }

    public void setIdStudio(Long idStudio) {
        this.idStudio = idStudio;
    }

    @Override
    public String toString() {
        return "DottoriStudiEntity{" +
                "id=" + id +
                ", idDottore=" + idDottore +
                ", idStudio=" + idStudio +
                '}';
    }
}
