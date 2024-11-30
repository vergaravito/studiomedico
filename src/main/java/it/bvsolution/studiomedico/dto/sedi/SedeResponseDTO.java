package it.bvsolution.studiomedico.dto.sedi;

public class SedeResponseDTO {

    private Long id;
    private String nome;
    private String indirizzo;
    private int cap;

    public SedeResponseDTO() {
    }

    public SedeResponseDTO(Long id, String nome, String indirizzo, int cap) {
        this.id = id;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.cap = cap;
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
}
