package it.bvsolution.studiomedico.model;

import javax.persistence.*;

@Entity(name = "avvocati")
@Table(name = "avvocati")
public class AvvocatiEntity {
    @Id
    @SequenceGenerator(name="avvocati_pk_sequence",sequenceName="avvocati_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="avvocati_pk_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "indirizzo")
    private String indirizzo;

    @Column(name = "cap")
    private int cap;

    @Column(name = "email")
    private String email;

    @Column(name = "pec")
    private String pec;

    @Column(name = "telefono1")
    private String telefono1;

    @Column(name = "telefono2")
    private String telefono2;

    @Column(name = "fax")
    private String fax;

    @Column(name = "note")
    private String note;

    public AvvocatiEntity() {
        super();
    }

    public AvvocatiEntity(Long id, String nome, String cognome, String titolo, String indirizzo, int cap, String email, String pec, String telefono1, String telefono2, String fax, String note) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.titolo = titolo;
        this.indirizzo = indirizzo;
        this.cap = cap;
        this.email = email;
        this.pec = pec;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.fax = fax;
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

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPec() {
        return pec;
    }

    public void setPec(String pec) {
        this.pec = pec;
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

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "AvvocatiEntity{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", titolo='" + titolo + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", cap=" + cap +
                ", email='" + email + '\'' +
                ", pec='" + pec + '\'' +
                ", telefono1='" + telefono1 + '\'' +
                ", telefono2='" + telefono2 + '\'' +
                ", fax='" + fax + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
