package it.bvsolution.studiomedico.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "assicurazioni")
@Table(name = "assicurazioni")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
