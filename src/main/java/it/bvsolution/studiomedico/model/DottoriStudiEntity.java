package it.bvsolution.studiomedico.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
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

    @Override
    public String toString() {
        return "DottoriStudiEntity{" +
                "id=" + id +
                ", idDottore=" + idDottore +
                ", idStudio=" + idStudio +
                '}';
    }
}
