package it.bvsolution.studiomedico.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
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

    @Override
    public String toString() {
        return "DottoriEntity{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}
