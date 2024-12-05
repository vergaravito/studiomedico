package it.bvsolution.studiomedico.dto.soggetti;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SoggettoResponseDTO {

    private Long id;
    private String nome;
    private String cognome;
    private String luogonascita;
    private LocalDate datanascita;
    private String indirizzo;
    private int cap;
    private String telefono;
    private String sesso;
    private String note;
    private String email;
    private String codicefiscale;
    private Byte[] allegato;

}
