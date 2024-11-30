package it.bvsolution.studiomedico.service.impl;

import it.bvsolution.studiomedico.dto.avvocati.AvvocatoRequestDTO;
import it.bvsolution.studiomedico.dto.avvocati.AvvocatoResponseDTO;
import it.bvsolution.studiomedico.mapper.AvvocatoMapper;
import it.bvsolution.studiomedico.model.AvvocatiEntity;
import it.bvsolution.studiomedico.repository.AvvocatiRepository;
import it.bvsolution.studiomedico.service.AvvocatiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AvvocatiServiceImpl implements AvvocatiService {
    @Autowired
    AvvocatiRepository avvocatiRepository;

    @Autowired
    AvvocatoMapper mapper;

    @Override
    public List<AvvocatoResponseDTO> fetchAvvocati() {
        return mapper.toResponseDTOList(avvocatiRepository.findAll());
    }

    @Override
    public AvvocatoResponseDTO fetchAvvocato(Long id) {
        return mapper.toResponseDTO(avvocatiRepository.findById(id).get());
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public AvvocatoResponseDTO insertAvvocato(AvvocatoRequestDTO requestDTO) {
        AvvocatiEntity entity = mapper.toEntity(requestDTO);
        return mapper.toResponseDTO(avvocatiRepository.save(entity));
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void deleteAvvocato(AvvocatoRequestDTO requestDTO) {
        AvvocatiEntity entity = mapper.toEntity(requestDTO);
        avvocatiRepository.delete(entity);
    }

}
