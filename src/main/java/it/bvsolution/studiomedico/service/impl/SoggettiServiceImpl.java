package it.bvsolution.studiomedico.service.impl;

import it.bvsolution.studiomedico.dto.soggetti.SoggettoRequestDTO;
import it.bvsolution.studiomedico.dto.soggetti.SoggettoResponseDTO;
import it.bvsolution.studiomedico.mapper.SoggettoMapper;
import it.bvsolution.studiomedico.model.SoggettiEntity;
import it.bvsolution.studiomedico.repository.SoggettiRepository;
import it.bvsolution.studiomedico.service.SoggettiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SoggettiServiceImpl implements SoggettiService {

    @Autowired
    SoggettiRepository soggettiRepository;

    @Autowired
    SoggettoMapper mapper;

    @Override
    public List<SoggettoResponseDTO> fetchSoggetti() {
        return mapper.toResponseDTOList(soggettiRepository.findAll());
    }

    @Override
    public List<SoggettoResponseDTO> fetchSoggettiByName(String nome, String cognome, String telefono, String email) {
        return mapper.toResponseDTOList(soggettiRepository.findByNomeContainsIgnoreCaseAndCognomeContainsIgnoreCaseAndTelefonoContainsAndEmailContainsIgnoreCase(
                nome, cognome, telefono, email));
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public SoggettoResponseDTO insertSoggetto(SoggettoRequestDTO requestDTO) {
        SoggettiEntity entity = mapper.toEntity(requestDTO);
        return mapper.toResponseDTO(soggettiRepository.save(entity));
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void deleteSoggetto(SoggettoRequestDTO requestDTO) {
        SoggettiEntity entity = mapper.toEntity(requestDTO);
        soggettiRepository.delete(entity);
    }

    @Override
    public SoggettoResponseDTO fetchSoggetto(Long id) {
        return mapper.toResponseDTO(soggettiRepository.findById(id).get());
    }
}
