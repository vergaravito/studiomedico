package it.bvsolution.studiomedico.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
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
