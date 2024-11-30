package it.bvsolution.studiomedico.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "incarichi")
@Table(name = "incarichi")
public class IncarichiEntity {

    @Id
    @SequenceGenerator(name="incarichi_pk_sequence",sequenceName="incarichi_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="incarichi_pk_sequence")
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

    @Column(name = "id_soggetto")
    private Long idSoggetto;

    @Column(name = "id_avvocato")
    private Long id_avvocato;

    @Column(name = "n_sinistro")
    private int n_sinistro;

    @Column(name = "id_dottore")
    private Long id_dottore;

    @Column(name = "data_sinistro")
    private LocalDateTime data_sinistro;

    @Column(name = "data_incarico")
    private LocalDateTime data_incarico;

    @Column(name = "note")
    private String note;

    public IncarichiEntity() {
        super();
    }

    public IncarichiEntity(Long id, String numero_incarico, String tipo, Long id_assicurazione, Long id_liquidatore, Long idSoggetto, Long id_avvocato, int n_sinistro, Long id_dottore, LocalDateTime data_sinistro, LocalDateTime data_incarico, String note) {
        this.id = id;
        this.numero_incarico = numero_incarico;
        this.tipo = tipo;
        this.id_assicurazione = id_assicurazione;
        this.id_liquidatore = id_liquidatore;
        this.idSoggetto = idSoggetto;
        this.id_avvocato = id_avvocato;
        this.n_sinistro = n_sinistro;
        this.id_dottore = id_dottore;
        this.data_sinistro = data_sinistro;
        this.data_incarico = data_incarico;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero_incarico() {
        return numero_incarico;
    }

    public void setNumero_incarico(String numero_incarico) {
        this.numero_incarico = numero_incarico;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getId_assicurazione() {
        return id_assicurazione;
    }

    public void setId_assicurazione(Long id_assicurazione) {
        this.id_assicurazione = id_assicurazione;
    }

    public Long getId_liquidatore() {
        return id_liquidatore;
    }

    public void setId_liquidatore(Long id_liquidatore) {
        this.id_liquidatore = id_liquidatore;
    }

    public Long getIdSoggetto() {
        return idSoggetto;
    }

    public void setIdSoggetto(Long idSoggetto) {
        this.idSoggetto = idSoggetto;
    }

    public Long getId_avvocato() {
        return id_avvocato;
    }

    public void setId_avvocato(Long id_avvocato) {
        this.id_avvocato = id_avvocato;
    }

    public int getN_sinistro() {
        return n_sinistro;
    }

    public void setN_sinistro(int n_sinistro) {
        this.n_sinistro = n_sinistro;
    }

    public Long getId_dottore() {
        return id_dottore;
    }

    public void setId_dottore(Long id_dottore) {
        this.id_dottore = id_dottore;
    }

    public LocalDateTime getData_sinistro() {
        return data_sinistro;
    }

    public void setData_sinistro(LocalDateTime data_sinistro) {
        this.data_sinistro = data_sinistro;
    }

    public LocalDateTime getData_incarico() {
        return data_incarico;
    }

    public void setData_incarico(LocalDateTime data_incarico) {
        this.data_incarico = data_incarico;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "IncarichiEntity{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", id_assicurazione=" + id_assicurazione +
                ", id_liquidatore=" + id_liquidatore +
                ", idSoggetto=" + idSoggetto +
                ", id_avvocato=" + id_avvocato +
                ", n_sinistro=" + n_sinistro +
                ", id_dottore=" + id_dottore +
                ", data_sinistro=" + data_sinistro +
                ", data_incarico=" + data_incarico +
                ", note='" + note + '\'' +
                '}';
    }
}
