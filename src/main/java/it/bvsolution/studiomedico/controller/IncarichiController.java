package it.bvsolution.studiomedico.controller;

import it.bvsolution.studiomedico.dto.incarichi.IncaricoRequestDTO;
import it.bvsolution.studiomedico.dto.incarichi.IncaricoResponseDTO;
import it.bvsolution.studiomedico.service.IncarichiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class IncarichiController {

    @Autowired
    IncarichiService incarichiService;

    @GetMapping(value = "/fetch/incarichi")
    public List<IncaricoResponseDTO> fetchIncarichi(){
        return incarichiService.fetchIncarichi();
    }

    @GetMapping(value = "/get/incarichi/bysoggetto")
    public List<IncaricoResponseDTO> getIncarichiBySoggetto(@RequestParam(name = "idSoggetto") String idSoggetto){
        return incarichiService.getIncarichiBySoggetto(idSoggetto);
    }

    @PostMapping(value="/insert/incarico", consumes = "application/json")
    public IncaricoResponseDTO insertIncarico(@RequestBody IncaricoRequestDTO requestDTO) {
        return incarichiService.insertIncarico(requestDTO);
    }

    @PostMapping(value="/delete/incarico")
    public void deleteIncarico(@RequestBody IncaricoRequestDTO requestDTO) {
        incarichiService.deleteIncarico(requestDTO);
    }

    @GetMapping(value = "/fetch/incarico")
    public IncaricoResponseDTO fetchIncarico(@RequestBody Long id){
        return incarichiService.fetchIncarico(id);
    }

}
