package it.bvsolution.studiomedico.controller;

import it.bvsolution.studiomedico.model.*;
import it.bvsolution.studiomedico.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class StudioMedicoController {

    @Autowired
    AssicurazioniRepository assicurazioniRepository;

    @Autowired
    AvvocatiRepository avvocatiRepository;

    @Autowired
    DottoriRepository dottoriRepository;

    @Autowired
    LiquidatoriRepository liquidatoriRepository;

    @Autowired
    SediRepository sediRepository;

    @Autowired
    SoggettiRepository soggettiRepository;

    @Autowired
    IncarichiRepository incarichiReposirory;

    //STUDI CRUD
    @GetMapping(value = "/fetch/studi")
    public List<SediEntity> fetchStudi(){
        return sediRepository.findAll();
    }

    @PostMapping(value="/insert/studio", consumes = "application/json")
    public SediEntity insertStudio(@RequestBody SediEntity sede) {
        return sediRepository.save(sede);
    }

    @PostMapping(value="/delete/studio")
    public void deleteStudio(@RequestBody SediEntity sede) {
        sediRepository.delete(sede);
    }

    //SOGGETTI CRUD
    @GetMapping(value = "/fetch/soggetti")
    public List<SoggettiEntity> fetchSoggetti(){
        return soggettiRepository.findAll();
    }

    @PostMapping(value="/insert/soggetto", consumes = "application/json")
    public SoggettiEntity insertSoggetto(@RequestBody SoggettiEntity soggetto) {
        return soggettiRepository.save(soggetto);
    }

    @PostMapping(value="/delete/soggetto")
    public void deleteSoggetto(@RequestBody SoggettiEntity soggetto) {
        soggettiRepository.delete(soggetto);
    }

    //ASSICURAZIONI CRUD

    @GetMapping(value = "/fetch/assicurazioni")
    public List<AssicurazioniEntity> fetchAssicurazioni(){
        return assicurazioniRepository.findAll();
    }

    @PostMapping(value="/insert/assicurazione", consumes = "application/json")
    public AssicurazioniEntity insertAssicurazione(@RequestBody AssicurazioniEntity assicurazione) {
        return assicurazioniRepository.save(assicurazione);
    }

    @PostMapping(value="/delete/assicurazione")
    public void deleteAssicurazione(@RequestBody AssicurazioniEntity assicurazione) {
        assicurazioniRepository.delete(assicurazione);
    }

    //AVVOCATI CRUD

    @GetMapping(value = "/fetch/avvocati")
    public List<AvvocatiEntity> fetchAvvocato(){
        return avvocatiRepository.findAll();
    }

    @PostMapping(value="/insert/avvocato", consumes = "application/json")
    public AvvocatiEntity insertAvvocato(@RequestBody AvvocatiEntity avvocato) {
        return avvocatiRepository.save(avvocato);
    }

    @PostMapping(value="/delete/avvocato")
    public void deleteAvvocato(@RequestBody AvvocatiEntity avvocato) {
        avvocatiRepository.delete(avvocato);
    }

    //LIQUIDATORI CRUD

    @GetMapping(value = "/fetch/liquidatori")
    public List<LiquidatoriEntity> fetchLiquidatori(){
        return liquidatoriRepository.findAll();
    }

    @PostMapping(value="/insert/liquidatore", consumes = "application/json")
    public LiquidatoriEntity insertLiquidatore(@RequestBody LiquidatoriEntity liquidatore) {
        return liquidatoriRepository.save(liquidatore);
    }

    @PostMapping(value="/delete/liquidatore")
    public void deleteLiquidatore(@RequestBody LiquidatoriEntity liquidatore) {
        liquidatoriRepository.delete(liquidatore);
    }

    //DOTTORI CRUD

    @GetMapping(value = "/fetch/dottori")
    public List<DottoriEntity> fetchDottori(){
        return dottoriRepository.findAll();
    }

    @PostMapping(value="/insert/dottore", consumes = "application/json")
    public DottoriEntity insertDottore(@RequestBody DottoriEntity dottore) {
        return dottoriRepository.save(dottore);
    }

    @PostMapping(value="/delete/dottore")
    public void deleteDottore(@RequestBody DottoriEntity dottore) {
        dottoriRepository.delete(dottore);
    }
    @GetMapping(value = "/fetch/dottore")
    public DottoriEntity fetchDottore(@RequestBody Long id){
        return dottoriRepository.findById(id).get();
    }

    //INCARICHI CRUD

    @GetMapping(value = "/fetch/incarichi")
    public List<IncarichiEntity> fetchIncarichi(){
        return incarichiReposirory.findAll();
    }

    @PostMapping(value="/insert/incarico", consumes = "application/json")
    public IncarichiEntity insertIncarico(@RequestBody IncarichiEntity incarico) {
        return incarichiReposirory.save(incarico);
    }

    @PostMapping(value="/delete/incarico")
    public void deleteIncarico(@RequestBody IncarichiEntity incarico) {
        incarichiReposirory.delete(incarico);
    }
}
