package it.bvsolution.studiomedico.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "sedi")
@Table(name = "sedi")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SediEntity {

    @Id
    @SequenceGenerator(name="sedi_pk_sequence",sequenceName="sedi_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="sedi_pk_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "indirizzo")
    private String indirizzo;

    @Column(name = "cap")
    private int cap;

}
