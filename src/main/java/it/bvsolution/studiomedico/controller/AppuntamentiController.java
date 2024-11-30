package it.bvsolution.studiomedico.controller;

import it.bvsolution.studiomedico.dto.appuntamenti.AppuntamentoRequestDTO;
import it.bvsolution.studiomedico.dto.appuntamenti.AppuntamentoResponseDTO;

import it.bvsolution.studiomedico.service.AppuntamentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin("*")
public class AppuntamentiController {

    @Autowired
    private AppuntamentiService appuntamentiService;

    @GetMapping(value = "/fetch/appuntamenti")
    public List<AppuntamentoResponseDTO> fetchAppuntamenti() {
        return appuntamentiService.fetchAppuntamenti();
    }

    @GetMapping(value = "/fetch/appuntamento")
    public List<AppuntamentoResponseDTO> fetchAppuntamento(@RequestBody LocalDateTime date) {
        return appuntamentiService.fetchAppuntamento(date);
    }

    @GetMapping(value = "/get/appuntamenti")
    public List<AppuntamentoResponseDTO> getAppuntamenti(@RequestParam(name = "date") String dataAppuntamento) {
        return appuntamentiService.getAppuntamenti(dataAppuntamento);
    }

    @PostMapping(value="/insert/appuntamento", consumes = "application/json")
    public AppuntamentoResponseDTO insertAppuntamento(@RequestBody AppuntamentoRequestDTO appuntamento) {
        return appuntamentiService.insertAppuntamento(appuntamento);
    }

    @PostMapping(value="/delete/appuntamento")
    public void deleteAppuntamento(@RequestBody AppuntamentoRequestDTO appuntamento) {
        appuntamentiService.deleteAppuntamento(appuntamento);
    }

}
