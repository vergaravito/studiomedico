package it.bvsolution.studiomedico.dto.liquidatori;

public class LiquidatoreResponseDTO {

    private Long id;
    private String nome;
    private String cognome;
    private Long idAssicurazione;

    public LiquidatoreResponseDTO() {
    }

    public LiquidatoreResponseDTO(Long id, String nome, String cognome, Long idAssicurazione) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.idAssicurazione = idAssicurazione;
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

    public Long getIdAssicurazione() {
        return idAssicurazione;
    }

    public void setIdAssicurazione(Long idAssicurazione) {
        this.idAssicurazione = idAssicurazione;
    }
}
