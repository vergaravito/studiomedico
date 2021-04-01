package it.bvsolution.studiomedico.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity(name = "incarichi")
@Table(name = "incarichi")
public class IncarichiEntity {

    @Id
    @SequenceGenerator(name="pk_sequence",sequenceName="incarichi_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="pk_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "numero_incarico")
    private String numero_incarico;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "id_assicurazione")
    private Long id_assicurazione;

    @Column(name = "id_liquidatore")
    private Long id_liquidatore;

    @Column(name = "ambito")
    private String ambito;

    @Column(name = "id_soggetto")
    private Long id_soggetto;

    @Column(name = "id_avvocato")
    private Long id_avvocato;

    @Column(name = "n_sinistro")
    private int n_sinistro;

    @Column(name = "id_dottore")
    private Long id_dottore;

    @Column(name = "data_sinistro")
    private Date data_sinistro;

    @Column(name = "data_incarico")
    private Date data_incarico;

    @Column(name = "note")
    private String note;

    public IncarichiEntity() {
        super();
    }

    @Override
    public String toString() {
        return "IncarichiEntity{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", id_assicurazione=" + id_assicurazione +
                ", id_liquidatore=" + id_liquidatore +
                ", ambito='" + ambito + '\'' +
                ", id_soggetto=" + id_soggetto +
                ", id_avvocato=" + id_avvocato +
                ", n_sinistro=" + n_sinistro +
                ", id_dottore=" + id_dottore +
                ", data_sinistro=" + data_sinistro +
                ", data_incarico=" + data_incarico +
                ", note='" + note + '\'' +
                '}';
    }
}
