package it.bvsolution.studiomedico.service;

import it.bvsolution.studiomedico.dto.dottori.DottoreRequestDTO;
import it.bvsolution.studiomedico.dto.dottori.DottoreResponseDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface DottoriService {

    List<DottoreResponseDTO> fetchDottori();

    DottoreResponseDTO fetchDottore(@RequestBody Long id);

    DottoreResponseDTO insertDottore(@RequestBody DottoreRequestDTO dottore);

    void deleteDottore(@RequestBody DottoreRequestDTO dottore);
}
