package it.bvsolution.studiomedico.service.impl;

import it.bvsolution.studiomedico.dto.appuntamenti.AppuntamentoRequestDTO;
import it.bvsolution.studiomedico.dto.appuntamenti.AppuntamentoResponseDTO;
import it.bvsolution.studiomedico.mapper.AppuntamentoMapper;
import it.bvsolution.studiomedico.model.AppuntamentiEntity;
import it.bvsolution.studiomedico.repository.AppuntamentiRepository;
import it.bvsolution.studiomedico.service.AppuntamentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class AppuntamentiServiceImpl implements AppuntamentiService {

    @Autowired
    private AppuntamentiRepository appuntamentiRepository;

    @Autowired
    private AppuntamentoMapper mapper;

    @Override
    public List<AppuntamentoResponseDTO> fetchAppuntamenti() {
        List<AppuntamentiEntity> appuntamenti =  appuntamentiRepository.findAll();
        return mapper.toResponseDTOList(appuntamenti);
    }

    @Override
    public List<AppuntamentoResponseDTO> fetchAppuntamento(LocalDateTime date) {
        List<AppuntamentiEntity> appuntamenti = appuntamentiRepository.findByDataAppuntamento(date);
        return mapper.toResponseDTOList(appuntamenti);
    }

    @Override
    public List<AppuntamentoResponseDTO> getAppuntamenti(String dataAppuntamento) {
        LocalDate data = LocalDate.parse(dataAppuntamento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        LocalDateTime inizioGiorno = data.atStartOfDay();
        LocalDateTime fineGiorno = data.atTime(LocalTime.MAX);

        List<AppuntamentiEntity> appuntamenti = appuntamentiRepository.findAllByDataAppuntamentoBetween(inizioGiorno, fineGiorno);
        return mapper.toResponseDTOList(appuntamenti);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public AppuntamentoResponseDTO insertAppuntamento(AppuntamentoRequestDTO requestDTO) {

        AppuntamentiEntity entity = mapper.toEntity(requestDTO);
        AppuntamentiEntity savedEntity = appuntamentiRepository.save(entity);
        return mapper.toResponseDTO(savedEntity);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void deleteAppuntamento(AppuntamentoRequestDTO requestDTO) {
        AppuntamentiEntity entity = mapper.toEntity(requestDTO);
        appuntamentiRepository.delete(entity);
    }
}
