package it.bvsolution.studiomedico.service.impl;

import it.bvsolution.studiomedico.dto.sedi.SedeRequestDTO;
import it.bvsolution.studiomedico.dto.sedi.SedeResponseDTO;
import it.bvsolution.studiomedico.mapper.SedeMapper;
import it.bvsolution.studiomedico.model.SediEntity;
import it.bvsolution.studiomedico.repository.SediRepository;
import it.bvsolution.studiomedico.service.SediService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SediServiceImpl implements SediService {

    @Autowired
    SediRepository sediRepository;

    @Autowired
    SedeMapper mapper;
    @Override
    public List<SedeResponseDTO> fetchStudi() {
        return mapper.toResponseDTOList(sediRepository.findAll());
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public SedeResponseDTO insertStudio(SedeRequestDTO requestDTO) {
        SediEntity entity = mapper.toEntity(requestDTO);
        return mapper.toResponseDTO(sediRepository.save(entity));
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void deleteStudio(SedeRequestDTO requestDTO) {
        SediEntity entity = mapper.toEntity(requestDTO);
        sediRepository.delete(entity);
    }

}
