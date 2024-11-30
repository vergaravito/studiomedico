package it.bvsolution.studiomedico.controller;

import it.bvsolution.studiomedico.dto.avvocati.AvvocatoRequestDTO;
import it.bvsolution.studiomedico.dto.avvocati.AvvocatoResponseDTO;
import it.bvsolution.studiomedico.model.AvvocatiEntity;
import it.bvsolution.studiomedico.service.AvvocatiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class AvvocatiController {

    @Autowired
    AvvocatiService avvocatiService;

    @GetMapping(value = "/fetch/avvocati")
    public List<AvvocatoResponseDTO> fetchAvvocati(){
        return avvocatiService.fetchAvvocati();
    }

    @GetMapping(value = "/fetch/avvocato")
    public AvvocatoResponseDTO fetchAvvocato(@RequestBody Long id){
        return avvocatiService.fetchAvvocato(id);
    }

    @PostMapping(value="/insert/avvocato", consumes = "application/json")
    public AvvocatoResponseDTO insertAvvocato(@RequestBody AvvocatoRequestDTO avvocato) {
        return avvocatiService.insertAvvocato(avvocato);
    }

    @PostMapping(value="/delete/avvocato")
    public void deleteAvvocato(@RequestBody AvvocatoRequestDTO avvocato) {
        avvocatiService.deleteAvvocato(avvocato);
    }

}
