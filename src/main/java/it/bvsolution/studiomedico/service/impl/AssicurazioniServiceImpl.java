package it.bvsolution.studiomedico.service.impl;


import it.bvsolution.studiomedico.dto.assicurazioni.AssicurazioneRequestDTO;
import it.bvsolution.studiomedico.dto.assicurazioni.AssicurazioneResponseDTO;
import it.bvsolution.studiomedico.mapper.AssicurazioneMapper;
import it.bvsolution.studiomedico.model.AssicurazioniEntity;
import it.bvsolution.studiomedico.repository.AssicurazioniRepository;
import it.bvsolution.studiomedico.service.AssicurazioniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AssicurazioniServiceImpl implements AssicurazioniService {
    @Autowired
    AssicurazioniRepository assicurazioniRepository;

    @Autowired
    AssicurazioneMapper mapper;
    @Override
    public List<AssicurazioneResponseDTO> fetchAssicurazioni(){
        return mapper.toResponseDTOList(assicurazioniRepository.findAll());
    }

    @Override
    public AssicurazioneResponseDTO fetchAssicurazione(Long id){
        return mapper.toResponseDTO(assicurazioniRepository.findById(id).get());
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public AssicurazioneResponseDTO insertAssicurazione(AssicurazioneRequestDTO requestDTO) {
        AssicurazioniEntity entity = mapper.toEntity(requestDTO);
        return mapper.toResponseDTO(assicurazioniRepository.save(entity));
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void deleteAssicurazione(AssicurazioneRequestDTO requestDTO) {
        AssicurazioniEntity entity = mapper.toEntity(requestDTO);
        assicurazioniRepository.delete(entity);
    }
}
