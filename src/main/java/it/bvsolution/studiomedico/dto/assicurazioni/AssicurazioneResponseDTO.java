package it.bvsolution.studiomedico.dto.assicurazioni;


public class AssicurazioneResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private String telefono1;
    private String telefono2;
    private String indirizzo;
    private int cap;
    private String partitaiva;
    private String codicefiscale;
    private String note;

    public AssicurazioneResponseDTO() {
    }

    public AssicurazioneResponseDTO(Long id, String nome, String email, String telefono1, String telefono2, String indirizzo, int cap, String partitaiva, String codicefiscale, String note) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.indirizzo = indirizzo;
        this.cap = cap;
        this.partitaiva = partitaiva;
        this.codicefiscale = codicefiscale;
        this.note = note;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
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

    public String getPartitaiva() {
        return partitaiva;
    }

    public void setPartitaiva(String partitaiva) {
        this.partitaiva = partitaiva;
    }

    public String getCodicefiscale() {
        return codicefiscale;
    }

    public void setCodicefiscale(String codicefiscale) {
        this.codicefiscale = codicefiscale;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
