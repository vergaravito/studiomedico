package it.bvsolution.studiomedico.dto.liquidatori;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LiquidatoreResponseDTO {

    private Long id;
    private String nome;
    private String cognome;
    private Long idAssicurazione;

}
