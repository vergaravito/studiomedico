package it.bvsolution.studiomedico.dto.soggetti;

import java.time.LocalDate;

public class SoggettoResponseDTO {

    private Long id;
    private String nome;
    private String cognome;
    private String luogonascita;
    private LocalDate datanascita;
    private String indirizzo;
    private int cap;
    private String telefono;
    private String sesso;
    private String note;
    private String email;
    private String codicefiscale;
    private Byte[] allegato;

    public SoggettoResponseDTO(Long id, String nome, String cognome, String luogonascita, LocalDate datanascita, String indirizzo, int cap, String telefono, String sesso, String note, String email, String codicefiscale, Byte[] allegato) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.luogonascita = luogonascita;
        this.datanascita = datanascita;
        this.indirizzo = indirizzo;
        this.cap = cap;
        this.telefono = telefono;
        this.sesso = sesso;
        this.note = note;
        this.email = email;
        this.codicefiscale = codicefiscale;
        this.allegato = allegato;
    }

    public SoggettoResponseDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getLuogonascita() {
        return luogonascita;
    }

    public void setLuogonascita(String luogonascita) {
        this.luogonascita = luogonascita;
    }

    public LocalDate getDatanascita() {
        return datanascita;
    }

    public void setDatanascita(LocalDate datanascita) {
        this.datanascita = datanascita;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodicefiscale() {
        return codicefiscale;
    }

    public void setCodicefiscale(String codicefiscale) {
        this.codicefiscale = codicefiscale;
    }

    public Byte[] getAllegato() {
        return allegato;
    }

    public void setAllegato(Byte[] allegato) {
        this.allegato = allegato;
    }
}
