package it.bvsolution.studiomedico;

import it.bvsolution.studiomedico.model.AssicurazioniEntity;
import it.bvsolution.studiomedico.repository.AssicurazioniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
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
		List<AssicurazioniEntity> assicurazioni = assicurazioniRepository.findAll();

		for (AssicurazioniEntity assicurazione : assicurazioni) {
			System.out.println("Nome Assicurazione: " + assicurazione);
		}
	}
}
