package it.bvsolution.studiomedico.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "avvocati")
@Table(name = "avvocati")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvvocatiEntity {
    @Id
    @SequenceGenerator(name="avvocati_pk_sequence",sequenceName="avvocati_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="avvocati_pk_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "indirizzo")
    private String indirizzo;

    @Column(name = "cap")
    private int cap;

    @Column(name = "email")
    private String email;

    @Column(name = "pec")
    private String pec;

    @Column(name = "telefono1")
    private String telefono1;

    @Column(name = "telefono2")
    private String telefono2;

    @Column(name = "fax")
    private String fax;

    @Column(name = "note")
    private String note;

}
