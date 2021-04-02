package it.bvsolution.studiomedico.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
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
