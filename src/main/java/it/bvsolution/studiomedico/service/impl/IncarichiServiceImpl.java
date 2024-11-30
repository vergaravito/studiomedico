package it.bvsolution.studiomedico.service.impl;

import it.bvsolution.studiomedico.dto.incarichi.IncaricoRequestDTO;
import it.bvsolution.studiomedico.dto.incarichi.IncaricoResponseDTO;
import it.bvsolution.studiomedico.mapper.IncaricoMapper;
import it.bvsolution.studiomedico.model.IncarichiEntity;
import it.bvsolution.studiomedico.repository.IncarichiRepository;
import it.bvsolution.studiomedico.service.IncarichiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Service
public class IncarichiServiceImpl implements IncarichiService {
    @Autowired
    IncarichiRepository incarichiRepository;

    @Autowired
    IncaricoMapper mapper;

    @Override
    public List<IncaricoResponseDTO> fetchIncarichi(){
        return mapper.toResponseDTOList(incarichiRepository.findAll());
    }

    @Override
    public List<IncaricoResponseDTO> getIncarichiBySoggetto(@RequestParam(name = "idSoggetto") String idSoggetto){
        return mapper.toResponseDTOList(incarichiRepository.findByIdSoggetto(Long.parseLong(idSoggetto)));
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public IncaricoResponseDTO insertIncarico(@RequestBody IncaricoRequestDTO requestDTO) {
        return mapper.toResponseDTO(saveIncarico(requestDTO));
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void deleteIncarico(@RequestBody IncaricoRequestDTO requestDTO) {
        IncarichiEntity entity = mapper.toEntity(requestDTO);
        incarichiRepository.delete(entity);
    }

    @Override
    public IncaricoResponseDTO fetchIncarico(@RequestBody Long id){
        return mapper.toResponseDTO(incarichiRepository.findById(id).get());
    }

    private IncarichiEntity saveIncarico(IncaricoRequestDTO requestDTO){

        int year = LocalDate.now().getYear();

        Long numeroIncarico = incarichiRepository.getCurrentValFromSequence() + 1;
        requestDTO.setNumeroIncarico(numeroIncarico + "/" + year);

        IncarichiEntity entity = mapper.toEntity(requestDTO);

        return incarichiRepository.save(entity);
    }
}
