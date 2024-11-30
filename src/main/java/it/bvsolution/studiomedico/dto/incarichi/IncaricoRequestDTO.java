package it.bvsolution.studiomedico.dto.incarichi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class IncaricoRequestDTO {
    @JsonProperty("numero_incarico")
    private String numero_incarico;
    private String tipo;
    private Long id_assicurazione;
    private Long id_liquidatore;
    private Long idSoggetto;
    private Long id_avvocato;
    private int n_sinistro;
    private Long id_dottore;
    private LocalDateTime data_sinistro;
    private LocalDateTime data_incarico;
    private String note;

    public IncaricoRequestDTO() {
    }

    public IncaricoRequestDTO(String numero_incarico, String tipo, Long id_assicurazione, Long id_liquidatore, Long idSoggetto, Long id_avvocato, int n_sinistro, Long id_dottore, LocalDateTime data_sinistro, LocalDateTime data_incarico, String note) {
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

    public String getNumeroIncarico() {
        return numero_incarico;
    }

    public void setNumeroIncarico(String numeroIncarico) {
        this.numero_incarico = numeroIncarico;
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
}
