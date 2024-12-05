package it.bvsolution.studiomedico.dto.incarichi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncaricoRequestDTO {
    private String numeroIncarico;
    private String tipo;
    private Long idAssicurazione;
    private Long idLiquidatore;
    private Long idSoggetto;
    private Long idAvvocato;
    private int nSinistro;
    private Long idDottore;
    private LocalDateTime dataSinistro;
    private LocalDateTime dataIncarico;
    private String note;

}
