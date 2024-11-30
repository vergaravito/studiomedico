package it.bvsolution.studiomedico.service;

import it.bvsolution.studiomedico.dto.soggetti.SoggettoRequestDTO;
import it.bvsolution.studiomedico.dto.soggetti.SoggettoResponseDTO;

import java.util.List;

public interface SoggettiService {

    List<SoggettoResponseDTO> fetchSoggetti();

    List<SoggettoResponseDTO> fetchSoggettiByName(String nome, String cognome,
                                                  String telefono, String email);

    SoggettoResponseDTO insertSoggetto(SoggettoRequestDTO requestDTO);

    void deleteSoggetto(SoggettoRequestDTO requestDTO);

    SoggettoResponseDTO fetchSoggetto(Long id);

}
