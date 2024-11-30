package it.bvsolution.studiomedico.controller;

import it.bvsolution.studiomedico.dto.soggetti.SoggettoRequestDTO;
import it.bvsolution.studiomedico.dto.soggetti.SoggettoResponseDTO;
import it.bvsolution.studiomedico.service.SoggettiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin("*")
public class SoggettiController {

    @Autowired
    private SoggettiService soggettiService;

    @GetMapping(value = "/fetch/soggetti")
    public List<SoggettoResponseDTO> fetchSoggetti(){
        return soggettiService.fetchSoggetti();
    }

    @GetMapping(value = "/get/soggetti")
    public List<SoggettoResponseDTO> fetchSoggettiByName(@RequestParam(name = "nome") String nome,
                                                         @RequestParam(name = "cognome") String cognome,
                                                         @RequestParam(name = "telefono") String telefono,
                                                         @RequestParam(name = "email") String email){
        return soggettiService.fetchSoggettiByName(nome, cognome, telefono, email);
    }

    @Transactional
    @PostMapping(value="/insert/soggetto", consumes = "application/json")
    public SoggettoResponseDTO insertSoggetto(@RequestBody SoggettoRequestDTO requestDTO) {
        return soggettiService.insertSoggetto(requestDTO);
    }

    @PostMapping(value="/delete/soggetto")
    public void deleteSoggetto(@RequestBody SoggettoRequestDTO requestDTO) {
        soggettiService.deleteSoggetto(requestDTO);
    }

    @GetMapping(value = "/fetch/soggetto")
    public SoggettoResponseDTO fetchSoggetto(@RequestBody Long id){
        return soggettiService.fetchSoggetto(id);
    }

}
