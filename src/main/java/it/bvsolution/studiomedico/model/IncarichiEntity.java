package it.bvsolution.studiomedico.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "incarichi")
@Table(name = "incarichi")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncarichiEntity {

    @Id
    @SequenceGenerator(name="incarichi_pk_sequence",sequenceName="incarichi_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="incarichi_pk_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "numero_incarico")
    private String numeroIncarico;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "id_assicurazione")
    private Long idAssicurazione;

    @Column(name = "id_liquidatore")
    private Long idLiquidatore;

    @Column(name = "id_soggetto")
    private Long idSoggetto;

    @Column(name = "id_avvocato")
    private Long idAvvocato;

    @Column(name = "n_sinistro")
    private int nSinistro;

    @Column(name = "id_dottore")
    private Long idDottore;

    @Column(name = "data_sinistro")
    private LocalDateTime dataSinistro;

    @Column(name = "data_incarico")
    private LocalDateTime dataIncarico;

    @Column(name = "note")
    private String note;

}
