package it.bvsolution.studiomedico.service.impl;

import it.bvsolution.studiomedico.dto.dottori.DottoreRequestDTO;
import it.bvsolution.studiomedico.dto.dottori.DottoreResponseDTO;
import it.bvsolution.studiomedico.mapper.DottoreMapper;
import it.bvsolution.studiomedico.model.DottoriEntity;
import it.bvsolution.studiomedico.repository.DottoriRepository;
import it.bvsolution.studiomedico.service.DottoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DottoriServiceImpl implements DottoriService {

    @Autowired
    DottoriRepository dottoriRepository;

    @Autowired
    DottoreMapper mapper;

    @Override
    public List<DottoreResponseDTO> fetchDottori() {
        return mapper.toResponseDTOList(dottoriRepository.findAll());
    }

    @Override
    public DottoreResponseDTO fetchDottore(Long id) {
        return mapper.toResponseDTO(dottoriRepository.findById(id).get());
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public DottoreResponseDTO insertDottore(DottoreRequestDTO requestDTO) {
        DottoriEntity entity = mapper.toEntity(requestDTO);
        return mapper.toResponseDTO(dottoriRepository.save(entity));
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void deleteDottore(DottoreRequestDTO requestDTO) {
        DottoriEntity entity = mapper.toEntity(requestDTO);
        dottoriRepository.delete(entity);
    }

}
