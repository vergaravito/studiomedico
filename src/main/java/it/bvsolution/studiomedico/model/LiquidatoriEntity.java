package it.bvsolution.studiomedico.model;

import javax.persistence.*;

@Entity(name = "liquidatori")
@Table(name = "liquidatori")
public class LiquidatoriEntity {

    @Id
    @SequenceGenerator(name="liquidatori_pk_sequence",sequenceName="liquidatori_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="liquidatori_pk_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "id_assicurazione")
    private Long idAssicurazione;

    public LiquidatoriEntity() {
        super();
    }

    public LiquidatoriEntity(Long id, String nome, String cognome, Long idAssicurazione) {
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

    @Override
    public String toString() {
        return "LiquidatoriEntity{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", idAssicurazione=" + idAssicurazione +
                '}';
    }
}
