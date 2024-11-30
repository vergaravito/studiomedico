package it.bvsolution.studiomedico.service;

import it.bvsolution.studiomedico.dto.sedi.SedeRequestDTO;
import it.bvsolution.studiomedico.dto.sedi.SedeResponseDTO;
import it.bvsolution.studiomedico.model.SediEntity;

import java.util.List;

public interface SediService {
    List<SedeResponseDTO> fetchStudi();

    SedeResponseDTO insertStudio(SedeRequestDTO requestDTO);

    void deleteStudio(SedeRequestDTO requestDTO);
}
