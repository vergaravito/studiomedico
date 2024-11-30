package it.bvsolution.studiomedico.dto.liquidatori;

public class LiquidatoreRequestDTO {

    private String nome;
    private String cognome;
    private Long idAssicurazione;

    public LiquidatoreRequestDTO() {
    }

    public LiquidatoreRequestDTO(String nome, String cognome, Long idAssicurazione) {
        this.nome = nome;
        this.cognome = cognome;
        this.idAssicurazione = idAssicurazione;
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

    public Long getIdAssicurazione() {
        return idAssicurazione;
    }

    public void setIdAssicurazione(Long idAssicurazione) {
        this.idAssicurazione = idAssicurazione;
    }
}
