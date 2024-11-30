package it.bvsolution.studiomedico.service;

import it.bvsolution.studiomedico.dto.avvocati.AvvocatoRequestDTO;
import it.bvsolution.studiomedico.dto.avvocati.AvvocatoResponseDTO;

import java.util.List;

public interface AvvocatiService {

    List<AvvocatoResponseDTO> fetchAvvocati();

    AvvocatoResponseDTO fetchAvvocato(Long id);

    AvvocatoResponseDTO insertAvvocato(AvvocatoRequestDTO requestDTO);

    void deleteAvvocato(AvvocatoRequestDTO requestDTO);
}
