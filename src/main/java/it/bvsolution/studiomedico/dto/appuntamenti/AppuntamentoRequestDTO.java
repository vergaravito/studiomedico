package it.bvsolution.studiomedico.dto.appuntamenti;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppuntamentoRequestDTO {

    private Long idStudio;
    private LocalDate dataAppuntamento;
    private String oraAppuntamento;
    private int durata;
    private Long idIncarico;
    private String note;

}
