package it.bvsolution.studiomedico.controller;

import it.bvsolution.studiomedico.dto.assicurazioni.AssicurazioneRequestDTO;
import it.bvsolution.studiomedico.dto.assicurazioni.AssicurazioneResponseDTO;
import it.bvsolution.studiomedico.model.AssicurazioniEntity;
import it.bvsolution.studiomedico.service.AssicurazioniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class AssicurazioniController {
    @Autowired
    AssicurazioniService assicurazioniService;

    @GetMapping(value = "/fetch/assicurazioni")
    public List<AssicurazioneResponseDTO> fetchAssicurazioni(){
        return assicurazioniService.fetchAssicurazioni();
    }

    @GetMapping(value = "/fetch/assicurazione")
    public AssicurazioneResponseDTO fetchAssicurazione(@RequestBody Long id){
        return assicurazioniService.fetchAssicurazione(id);
    }

    @PostMapping(value="/insert/assicurazione", consumes = "application/json")
    public AssicurazioneResponseDTO insertAssicurazione(@RequestBody AssicurazioneRequestDTO requestDTO) {
        return assicurazioniService.insertAssicurazione(requestDTO);
    }

    @PostMapping(value="/delete/assicurazione")
    public void deleteAssicurazione(@RequestBody AssicurazioneRequestDTO requestDTO) {
        assicurazioniService.deleteAssicurazione(requestDTO);
    }
}
