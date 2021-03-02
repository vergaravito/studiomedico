package it.bvsolution.studiomedico.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity(name = "sedi")
@Table(name = "sedi")
public class SediEntity {

    @Id
    @SequenceGenerator(name="pk_sequence",sequenceName="sedi_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="pk_sequence")
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
