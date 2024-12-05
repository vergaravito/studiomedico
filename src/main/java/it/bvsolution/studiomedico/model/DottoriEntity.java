package it.bvsolution.studiomedico.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "dottori")
@Table(name = "dottori")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
