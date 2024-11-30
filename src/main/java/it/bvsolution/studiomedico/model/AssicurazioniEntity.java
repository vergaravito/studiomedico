package it.bvsolution.studiomedico.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "assicurazioni")
@Table(name = "assicurazioni")
public class AssicurazioniEntity implements Serializable {

    @Id
    @SequenceGenerator(name="assicurazioni_pk_sequence",sequenceName="assicurazioni_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="assicurazioni_pk_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono1")
    private String telefono1;

    @Column(name = "telefono2")
    private String telefono2;

    @Column(name = "indirizzo")
    private String indirizzo;

    @Column(name = "cap")
    private int cap;

    @Column(name = "partitaiva")
    private String partitaiva;

    @Column(name = "codicefiscale")
    private String codicefiscale;

    @Column(name = "note")
    private String note;

    public AssicurazioniEntity() {
        super();
    }

    public AssicurazioniEntity(Long id, String nome, String email, String telefono1, String telefono2, String indirizzo, int cap, String partitaiva, String codicefiscale, String note) {
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

    @Override
    public String toString() {
        return "AssicurazioniEntity{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefono1='" + telefono1 + '\'' +
                ", telefono2='" + telefono2 + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", cap=" + cap +
                ", partitaiva='" + partitaiva + '\'' +
                ", codicefiscale='" + codicefiscale + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

}
