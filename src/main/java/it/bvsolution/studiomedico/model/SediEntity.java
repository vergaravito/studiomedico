package it.bvsolution.studiomedico.model;

import javax.persistence.*;

@Entity(name = "sedi")
@Table(name = "sedi")
public class SediEntity {

    @Id
    @SequenceGenerator(name="sedi_pk_sequence",sequenceName="sedi_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="sedi_pk_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "indirizzo")
    private String indirizzo;

    @Column(name = "cap")
    private int cap;

    public SediEntity() {
        super();
    }

    public SediEntity(Long id, String nome, String indirizzo, int cap) {
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

    @Override
    public String toString() {
        return "SediEntity{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", cap=" + cap +
                '}';
    }
}
