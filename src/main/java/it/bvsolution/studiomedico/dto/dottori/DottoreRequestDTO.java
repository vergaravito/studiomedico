package it.bvsolution.studiomedico.dto.dottori;

public class DottoreRequestDTO {

    private String nome;
    private String cognome;

    public DottoreRequestDTO() {
    }

    public DottoreRequestDTO(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
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
}
