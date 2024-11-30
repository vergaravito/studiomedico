package it.bvsolution.studiomedico.service;

import it.bvsolution.studiomedico.dto.appuntamenti.AppuntamentoRequestDTO;
import it.bvsolution.studiomedico.dto.appuntamenti.AppuntamentoResponseDTO;
import java.time.LocalDateTime;
import java.util.List;

public interface AppuntamentiService {

    List<AppuntamentoResponseDTO> fetchAppuntamenti();
    List<AppuntamentoResponseDTO> fetchAppuntamento(LocalDateTime date);

    List<AppuntamentoResponseDTO> getAppuntamenti(String dataAppuntamento);

    AppuntamentoResponseDTO insertAppuntamento(AppuntamentoRequestDTO appuntamento);

    void deleteAppuntamento(AppuntamentoRequestDTO requestDTO);

}
