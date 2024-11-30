package it.bvsolution.studiomedico.service.impl;

import it.bvsolution.studiomedico.dto.liquidatori.LiquidatoreRequestDTO;
import it.bvsolution.studiomedico.dto.liquidatori.LiquidatoreResponseDTO;
import it.bvsolution.studiomedico.mapper.LiquidatoreMapper;
import it.bvsolution.studiomedico.model.LiquidatoriEntity;
import it.bvsolution.studiomedico.repository.LiquidatoriRepository;
import it.bvsolution.studiomedico.service.LiquidatoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LiquidatoriServiceImpl implements LiquidatoriService {

    @Autowired
    LiquidatoriRepository liquidatoriRepository;

    @Autowired
    LiquidatoreMapper mapper;

    @Override
    public List<LiquidatoreResponseDTO> fetchLiquidatori() {
        return mapper.toResponseDTOList(liquidatoriRepository.findAll());
    }

    @Override
    public LiquidatoreResponseDTO fetchLiquidatore(Long id) {
        return mapper.toResponseDTO(liquidatoriRepository.findById(id).get());
    }

    @Override
    public List<LiquidatoreResponseDTO> fetchLiquidatori(String idAssicurazione) {
        return mapper.toResponseDTOList(liquidatoriRepository.findByIdAssicurazione(Long.parseLong(idAssicurazione)));
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public LiquidatoreResponseDTO insertLiquidatore(LiquidatoreRequestDTO requestDTO) {
        LiquidatoriEntity entity = mapper.toEntity(requestDTO);
        return mapper.toResponseDTO(liquidatoriRepository.save(entity));
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void deleteLiquidatore(LiquidatoreRequestDTO requestDTO) {
        LiquidatoriEntity entity = mapper.toEntity(requestDTO);
        liquidatoriRepository.delete(entity);
    }

}
