package me.dio.sdw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import me.dio.sdw.application.ListChampionsUseCase;
import me.dio.sdw.ports.ChampionsRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	public ListChampionsUseCase provideListChampionsUseCase(ChampionsRepository repository) {
		return new ListChampionsUseCase(repository);
	}

}
