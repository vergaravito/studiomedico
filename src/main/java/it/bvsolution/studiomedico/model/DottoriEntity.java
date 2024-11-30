package it.bvsolution.studiomedico.model;

import javax.persistence.*;

@Entity(name = "dottori")
@Table(name = "dottori")
public class DottoriEntity {

    @Id
    @SequenceGenerator(name="dottori_pk_sequence",sequenceName="dottori_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="dottori_pk_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    public DottoriEntity() {
        super();
    }

    public DottoriEntity(Long id, String nome, String cognome) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
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

    @Override
    public String toString() {
        return "DottoriEntity{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}
