package it.bvsolution.studiomedico.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "appuntamenti")
@Table(name = "appuntamenti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppuntamentiEntity {

    @Id
    @SequenceGenerator(name="appuntamenti_pk_sequence",sequenceName="appuntamenti_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="appuntamenti_pk_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "id_studio")
    private Long idStudio;

    @Column(name = "data_appuntamento")
    private LocalDateTime dataAppuntamento;

    @Column(name = "ora_appuntamento")
    private String oraAppuntamento;

    @Column(name = "durata")
    private int durata;

    @Column(name = "id_incarico")
    private Long idIncarico;

    @Column(name = "note")
    private String note;

}
