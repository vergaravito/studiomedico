package it.bvsolution.studiomedico.dto.sedi;

public class SedeRequestDTO {

    private String nome;
    private String indirizzo;
    private int cap;

    public SedeRequestDTO() {
    }

    public SedeRequestDTO(String nome, String indirizzo, int cap) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.cap = cap;
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
