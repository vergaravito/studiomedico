package it.bvsolution.studiomedico.service;

import it.bvsolution.studiomedico.dto.incarichi.IncaricoRequestDTO;
import it.bvsolution.studiomedico.dto.incarichi.IncaricoResponseDTO;

import java.util.List;

public interface IncarichiService {

    List<IncaricoResponseDTO> fetchIncarichi();

    IncaricoResponseDTO fetchIncarico(Long id);

    List<IncaricoResponseDTO> getIncarichiBySoggetto(String idSoggetto);

    IncaricoResponseDTO insertIncarico(IncaricoRequestDTO requestDTO);

    void deleteIncarico(IncaricoRequestDTO requestDTO);
}
