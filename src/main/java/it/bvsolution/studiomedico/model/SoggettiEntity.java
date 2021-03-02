package it.bvsolution.studiomedico.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity(name = "soggetti")
@Table(name = "soggetti")
public class SoggettiEntity {

    @Id
    @SequenceGenerator(name="pk_sequence",sequenceName="soggetti_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="pk_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "luogonascita")
    private String luogonascita;

    @Column(name = "datanascita")
    private Date datanascita;

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
