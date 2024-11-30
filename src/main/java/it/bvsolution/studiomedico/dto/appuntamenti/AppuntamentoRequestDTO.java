package it.bvsolution.studiomedico.dto.appuntamenti;

import java.time.LocalDate;

public class AppuntamentoRequestDTO {

    private Long idStudio;
    private LocalDate dataAppuntamento;
    private String oraAppuntamento;
    private int durata;
    private Long idIncarico;
    private String note;

    public AppuntamentoRequestDTO() {
    }

    public AppuntamentoRequestDTO(Long idStudio, LocalDate dataAppuntamento, String oraAppuntamento, int durata, Long idIncarico, String note) {
        this.idStudio = idStudio;
        this.dataAppuntamento = dataAppuntamento;
        this.oraAppuntamento = oraAppuntamento;
        this.durata = durata;
        this.idIncarico = idIncarico;
        this.note = note;
    }

    public Long getIdStudio() {
        return idStudio;
    }

    public void setIdStudio(Long idStudio) {
        this.idStudio = idStudio;
    }

    public LocalDate getDataAppuntamento() {
        return dataAppuntamento;
    }

    public void setDataAppuntamento(LocalDate dataAppuntamento) {
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
}
