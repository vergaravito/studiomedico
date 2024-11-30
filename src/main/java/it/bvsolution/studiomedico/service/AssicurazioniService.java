package it.bvsolution.studiomedico.service;

import it.bvsolution.studiomedico.dto.assicurazioni.AssicurazioneRequestDTO;
import it.bvsolution.studiomedico.dto.assicurazioni.AssicurazioneResponseDTO;

import java.util.List;

public interface AssicurazioniService {

    List<AssicurazioneResponseDTO> fetchAssicurazioni();

    AssicurazioneResponseDTO fetchAssicurazione(Long id);

    AssicurazioneResponseDTO insertAssicurazione(AssicurazioneRequestDTO requestDTO);

    void deleteAssicurazione(AssicurazioneRequestDTO requestDTO);
}
