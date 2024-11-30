package it.bvsolution.studiomedico.controller;

import it.bvsolution.studiomedico.dto.dottori.DottoreRequestDTO;
import it.bvsolution.studiomedico.dto.dottori.DottoreResponseDTO;
import it.bvsolution.studiomedico.model.DottoriEntity;
import it.bvsolution.studiomedico.service.DottoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class DottoriController {

    @Autowired
    DottoriService dottoriService;

    @GetMapping(value = "/fetch/dottori")
    public List<DottoreResponseDTO> fetchDottori() {
        return dottoriService.fetchDottori();
    }

    @GetMapping(value = "/fetch/dottore")
    public DottoreResponseDTO fetchDottore(@RequestBody Long id){
        return dottoriService.fetchDottore(id);
    }

    @PostMapping(value="/insert/dottore", consumes = "application/json")
    public DottoreResponseDTO insertDottore(@RequestBody DottoreRequestDTO requestDTO) {
        return dottoriService.insertDottore(requestDTO);
    }

    @PostMapping(value="/delete/dottore")
    public void deleteDottore(@RequestBody DottoreRequestDTO requestDTO) {
        dottoriService.deleteDottore(requestDTO);
    }

}
