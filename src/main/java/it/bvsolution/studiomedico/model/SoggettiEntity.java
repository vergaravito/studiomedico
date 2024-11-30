package it.bvsolution.studiomedico.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;

@Entity(name = "soggetti")
@Table(name = "soggetti")
public class SoggettiEntity {

    @Id
    @SequenceGenerator(name="soggetti_pk_sequence",sequenceName="soggetti_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="soggetti_pk_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "luogonascita")
    private String luogonascita;

    @Column(name = "datanascita")
    private LocalDate datanascita;

    @Column(name = "indirizzo")
    private String indirizzo;

    @Column(name = "cap")
    private int cap;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "sesso")
    private String sesso;

    @Column(name = "note")
    private String note;

    @Column(name = "email")
    private String email;

    @Column(name = "codicefiscale")
    private String codicefiscale;

    @Column(name = "allegato")
    private Byte[] allegato;

    public SoggettiEntity() {
        super();
    }

    public SoggettiEntity(Long id, String nome, String cognome, String luogonascita, LocalDate datanascita, String indirizzo, int cap, String telefono, String sesso, String note, String email, String codicefiscale, Byte[] allegato) {
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

    @Override
    public String toString() {
        return "SoggettiEntity{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", luogonascita='" + luogonascita + '\'' +
                ", datanascita=" + datanascita +
                ", indirizzo='" + indirizzo + '\'' +
                ", cap=" + cap +
                ", telefono='" + telefono + '\'' +
                ", sesso='" + sesso + '\'' +
                ", note='" + note + '\'' +
                ", email='" + email + '\'' +
                ", codicefiscale='" + codicefiscale + '\'' +
                ", allegato=" + Arrays.toString(allegato) +
                '}';
    }
}
