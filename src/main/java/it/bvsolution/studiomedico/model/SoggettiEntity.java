package it.bvsolution.studiomedico.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;

@Entity(name = "soggetti")
@Table(name = "soggetti")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
