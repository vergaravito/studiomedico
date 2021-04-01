package it.bvsolution.studiomedico.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity(name = "appuntamenti")
@Table(name = "appuntamenti")
public class AppuntamentiEntity {

    @Id
    @SequenceGenerator(name="pk_sequence",sequenceName="appuntamenti_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="pk_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "id_studio")
    private Long idStudio;

    @Column(name = "data_appuntamento")
    private Date dataAppuntamento;

    @Column(name = "ora_appuntamento")
    private String oraAppuntamento;

    @Column(name = "durata")
    private int durata;

    @Column(name = "id_incarico")
    private Long idIncarico;

    @Column(name = "note")
    private String note;

    public AppuntamentiEntity() {
        super();
    }

    @Override
    public String toString() {
        return "AppuntamentiEntity{" +
                "id=" + id +
                ", id_studio=" + idStudio +
                ", dataAppuntamento=" + dataAppuntamento +
                ", durata=" + durata +
                ", id_incarico=" + idIncarico +
                ", note='" + note + '\'' +
                '}';
    }
}
