package it.bvsolution.studiomedico.controller;

import it.bvsolution.studiomedico.dto.liquidatori.LiquidatoreRequestDTO;
import it.bvsolution.studiomedico.dto.liquidatori.LiquidatoreResponseDTO;
import it.bvsolution.studiomedico.model.LiquidatoriEntity;
import it.bvsolution.studiomedico.service.LiquidatoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class LiquidatoriController {

    @Autowired
    LiquidatoriService liquidatoriService;

    @GetMapping(value = "/fetch/liquidatori")
    public List<LiquidatoreResponseDTO> fetchLiquidatori(){
        return liquidatoriService.fetchLiquidatori();
    }

    @GetMapping(value = "/fetch/liquidatore")
    public LiquidatoreResponseDTO fetchLiquidatore(@RequestBody Long id){
        return liquidatoriService.fetchLiquidatore(id);
    }

    @GetMapping(value = "/get/liquidatori/byassicurazione")
    public List<LiquidatoreResponseDTO> fetchLiquidatori(@RequestParam(name = "idAssicurazione") String idAssicurazione){
        return liquidatoriService.fetchLiquidatori(idAssicurazione);
    }

    @PostMapping(value="/insert/liquidatore", consumes = "application/json")
    public LiquidatoreResponseDTO insertLiquidatore(@RequestBody LiquidatoreRequestDTO requestDTO) {
        return liquidatoriService.insertLiquidatore(requestDTO);
    }

    @PostMapping(value="/delete/liquidatore")
    public void deleteLiquidatore(@RequestBody LiquidatoreRequestDTO requestDTO) {
        liquidatoriService.deleteLiquidatore(requestDTO);
    }

}
