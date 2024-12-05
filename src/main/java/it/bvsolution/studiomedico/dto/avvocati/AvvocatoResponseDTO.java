package it.bvsolution.studiomedico.dto.avvocati;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvvocatoResponseDTO {

    private Long id;
    private String nome;
    private String cognome;
    private String titolo;
    private String indirizzo;
    private int cap;
    private String email;
    private String pec;
    private String telefono1;
    private String telefono2;
    private String fax;
    private String note;

}
