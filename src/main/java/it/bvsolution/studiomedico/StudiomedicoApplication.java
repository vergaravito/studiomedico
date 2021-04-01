package it.bvsolution.studiomedico;

import it.bvsolution.studiomedico.model.AssicurazioniEntity;
import it.bvsolution.studiomedico.repository.AssicurazioniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@SpringBootApplication
public class StudiomedicoApplication {

	@Autowired
	AssicurazioniRepository assicurazioniRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudiomedicoApplication.class, args);
	}

	@PostConstruct
	public void studioMedico() {

	}
}
