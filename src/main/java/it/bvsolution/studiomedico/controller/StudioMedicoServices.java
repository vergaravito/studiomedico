package it.bvsolution.studiomedico.controller;

import it.bvsolution.studiomedico.model.IncarichiEntity;
import it.bvsolution.studiomedico.repository.IncarichiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class StudioMedicoServices {
    @Autowired
    IncarichiRepository incarichiRepository;

    public IncarichiEntity SaveIncarico(IncarichiEntity incarico){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int year = calendar.get(Calendar.YEAR);
        try {
            Long numeroIncarico = incarichiRepository.getCurrentValFromSequence() + 1;
            incarico.setNumero_incarico(numeroIncarico + "/" + year);
        } catch (Exception e){
            incarico = incarichiRepository.save(incarico);
            Long id = incarico.getId();
            incarico.setNumero_incarico(id + "/" + year);
        }

        return incarichiRepository.save(incarico);
    }
}
