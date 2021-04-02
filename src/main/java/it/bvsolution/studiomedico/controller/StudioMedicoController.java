package it.bvsolution.studiomedico.controller;

import it.bvsolution.studiomedico.model.*;
import it.bvsolution.studiomedico.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

    @Autowired
    AppuntamentiRepository appuntamentiRepository;

    @Autowired
    StudioMedicoServices studioMedicoServices;

    @Autowired
    DottoriStudiRepository dottoriStudiRepository;

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

    @GetMapping(value = "/get/soggetti")
    public List<SoggettiEntity> fetchSoggettiByName(@RequestParam(name = "nome") String nome,
                                                    @RequestParam(name = "cognome") String cognome,
                                                    @RequestParam(name = "telefono") String telefono,
                                                    @RequestParam(name = "email") String email){
        return soggettiRepository.findByNomeContainsIgnoreCaseAndCognomeContainsIgnoreCaseAndTelefonoContainsAndEmailContainsIgnoreCase(
                nome, cognome, telefono, email);
    }

    @PostMapping(value="/insert/soggetto", consumes = "application/json")
    public SoggettiEntity insertSoggetto(@RequestBody SoggettiEntity soggetto) {
        return soggettiRepository.save(soggetto);
    }

    @PostMapping(value="/delete/soggetto")
    public void deleteSoggetto(@RequestBody SoggettiEntity soggetto) {
        soggettiRepository.delete(soggetto);
    }

    @GetMapping(value = "/fetch/soggetto")
    public SoggettiEntity fetchSoggetto(@RequestBody Long id){
        return soggettiRepository.findById(id).get();
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

    @GetMapping(value = "/fetch/assicurazione")
    public AssicurazioniEntity fetchAssicurazione(@RequestBody Long id){
        return assicurazioniRepository.findById(id).get();
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

    @GetMapping(value = "/fetch/avvocato")
    public AvvocatiEntity fetchAvvocato(@RequestBody Long id){
        return avvocatiRepository.findById(id).get();
    }

    //LIQUIDATORI CRUD

    @GetMapping(value = "/fetch/liquidatori")
    public List<LiquidatoriEntity> fetchLiquidatori(){
        return liquidatoriRepository.findAll();
    }

    @GetMapping(value = "/get/liquidatori/byassicurazione")
    public List<LiquidatoriEntity> fetchLiquidatori(@RequestParam(name = "idAssicurazione") String idAssicurazione){
        return liquidatoriRepository.findByIdAssicurazione(Long.parseLong(idAssicurazione));
    }

    @PostMapping(value="/insert/liquidatore", consumes = "application/json")
    public LiquidatoriEntity insertLiquidatore(@RequestBody LiquidatoriEntity liquidatore) {
        return liquidatoriRepository.save(liquidatore);
    }

    @PostMapping(value="/delete/liquidatore")
    public void deleteLiquidatore(@RequestBody LiquidatoriEntity liquidatore) {
        liquidatoriRepository.delete(liquidatore);
    }

    @GetMapping(value = "/fetch/liquidatore")
    public LiquidatoriEntity fetchLiquidatore(@RequestBody Long id){
        return liquidatoriRepository.findById(id).get();
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

    @GetMapping(value = "/get/incarichi/bysoggetto")
    public List<IncarichiEntity> getIncarichiBySoggetto(@RequestParam(name = "idSoggetto") String idSoggetto){
        return incarichiReposirory.findByIdSoggetto(Long.parseLong(idSoggetto));
    }

    @PostMapping(value="/insert/incarico", consumes = "application/json")
    public IncarichiEntity insertIncarico(@RequestBody IncarichiEntity incarico) {
        return studioMedicoServices.SaveIncarico(incarico);
    }

    @PostMapping(value="/delete/incarico")
    public void deleteIncarico(@RequestBody IncarichiEntity incarico) {
        incarichiReposirory.delete(incarico);
    }

    @GetMapping(value = "/fetch/incarico")
    public IncarichiEntity fetchIncarico(@RequestBody Long id){
        return incarichiReposirory.findById(id).get();
    }

    //APPUNTAMENTI CRUD

    @GetMapping(value = "/fetch/appuntamenti")
    public List<AppuntamentiEntity> fetchAppuntamenti(){
        return appuntamentiRepository.findAll();
    }

    @GetMapping(value = "/get/appuntamenti")
    public List<AppuntamentiEntity> getAppuntamenti(@RequestParam(name = "date") String dataAppuntamento) throws ParseException {
        Date data1 = new SimpleDateFormat("dd/MM/yy hh:mm:ss").parse(dataAppuntamento + " 00:00:00");
        Date data2 = new SimpleDateFormat("dd/MM/yy hh:mm:ss").parse(dataAppuntamento + " 23:59:59");

        List<AppuntamentiEntity> appuntamenti = appuntamentiRepository.findAllByDataAppuntamentoBetween(data1, data2);
        return appuntamenti;
    }

    @PostMapping(value="/insert/appuntamento", consumes = "application/json")
    public AppuntamentiEntity insertAppuntamento(@RequestBody AppuntamentiEntity appuntamento) {
        return appuntamentiRepository.save(appuntamento);
    }

    @PostMapping(value="/delete/appuntamento")
    public void deleteAppuntamento(@RequestBody AppuntamentiEntity appuntamento) {
        appuntamentiRepository.delete(appuntamento);
    }

    @GetMapping(value = "/fetch/appuntamento")
    public List<AppuntamentiEntity> fetchAppuntamento(@RequestBody Date date){
        return appuntamentiRepository.findByDataAppuntamento(date);
    }

    //DOTTORI E STUDI
    @PostMapping(value = "/join/dottore/studio")
    public List<DottoriStudiEntity> joinDottoriStudi(@RequestBody DottoriStudiEntity dottoriStudi){
        if(dottoriStudi.getIdDottore() != null){
            
        }
    }
}
