package it.bvsolution.studiomedico.service;

import it.bvsolution.studiomedico.dto.liquidatori.LiquidatoreRequestDTO;
import it.bvsolution.studiomedico.dto.liquidatori.LiquidatoreResponseDTO;
import it.bvsolution.studiomedico.model.LiquidatoriEntity;
import java.util.List;

public interface LiquidatoriService {

    List<LiquidatoreResponseDTO> fetchLiquidatori();

    LiquidatoreResponseDTO fetchLiquidatore(Long id);

    List<LiquidatoreResponseDTO> fetchLiquidatori(String idAssicurazione);

    LiquidatoreResponseDTO insertLiquidatore(LiquidatoreRequestDTO requestDTO);

    void deleteLiquidatore(LiquidatoreRequestDTO requestDTO);

}
