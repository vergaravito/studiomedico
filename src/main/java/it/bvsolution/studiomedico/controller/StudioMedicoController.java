package it.bvsolution.studiomedico.controller;

import it.bvsolution.studiomedico.service.StudioMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class StudioMedicoController {

    @Autowired
    StudioMedicoService studioMedicoService;

    @GetMapping(value = "/fill/invitoavisita",
            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public @ResponseBody byte[] fillPdfDocument(){
        return studioMedicoService.fillPdfDocument();
    }
}
