package it.bvsolution.studiomedico.dto.assicurazioni;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssicurazioneRequestDTO {

    private String nome;
    private String email;
    private String telefono1;
    private String telefono2;
    private String indirizzo;
    private int cap;
    private String partitaiva;
    private String codicefiscale;
    private String note;

}
