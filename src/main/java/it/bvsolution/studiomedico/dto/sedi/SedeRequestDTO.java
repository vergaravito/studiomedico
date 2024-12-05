package it.bvsolution.studiomedico.dto.sedi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SedeRequestDTO {

    private String nome;
    private String indirizzo;
    private int cap;

}
