package it.bvsolution.studiomedico.model;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity(name = "appuntamenti")
@Table(name = "appuntamenti")
public class AppuntamentiEntity {

    @Id
    @SequenceGenerator(name="appuntamenti_pk_sequence",sequenceName="appuntamenti_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="appuntamenti_pk_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "id_studio")
    private Long idStudio;

    @Column(name = "data_appuntamento")
    private LocalDateTime dataAppuntamento;

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

    public AppuntamentiEntity(Long id, Long idStudio, LocalDateTime dataAppuntamento, String oraAppuntamento, int durata, Long idIncarico, String note) {
        this.id = id;
        this.idStudio = idStudio;
        this.dataAppuntamento = dataAppuntamento;
        this.oraAppuntamento = oraAppuntamento;
        this.durata = durata;
        this.idIncarico = idIncarico;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdStudio() {
        return idStudio;
    }

    public void setIdStudio(Long idStudio) {
        this.idStudio = idStudio;
    }

    public LocalDateTime getDataAppuntamento() {
        return dataAppuntamento;
    }

    public void setDataAppuntamento(LocalDateTime dataAppuntamento) {
        this.dataAppuntamento = dataAppuntamento;
    }

    public String getOraAppuntamento() {
        return oraAppuntamento;
    }

    public void setOraAppuntamento(String oraAppuntamento) {
        this.oraAppuntamento = oraAppuntamento;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public Long getIdIncarico() {
        return idIncarico;
    }

    public void setIdIncarico(Long idIncarico) {
        this.idIncarico = idIncarico;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
