package it.bvsolution.studiomedico.controller;

import it.bvsolution.studiomedico.dto.sedi.SedeRequestDTO;
import it.bvsolution.studiomedico.dto.sedi.SedeResponseDTO;
import it.bvsolution.studiomedico.model.SediEntity;
import it.bvsolution.studiomedico.service.SediService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class SediController {

    @Autowired
    SediService sediService;

    @GetMapping(value = "/fetch/studi")
    public List<SedeResponseDTO> fetchStudi(){
        return sediService.fetchStudi();
    }

    @PostMapping(value="/insert/studio", consumes = "application/json")
    public SedeResponseDTO insertStudio(@RequestBody SedeRequestDTO requestDTO) {
        return sediService.insertStudio(requestDTO);
    }

    @PostMapping(value="/delete/studio")
    public void deleteStudio(@RequestBody SedeRequestDTO requestDTO) {
        sediService.deleteStudio(requestDTO);
    }

}
