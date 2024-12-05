package it.bvsolution.studiomedico.dto.dottori;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DottoreRequestDTO {

    private String nome;
    private String cognome;

}
