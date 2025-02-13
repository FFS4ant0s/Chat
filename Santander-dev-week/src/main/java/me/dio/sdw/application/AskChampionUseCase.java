package me.dio.sdw.application;

import org.springframework.stereotype.Service;

import me.dio.sdw.exception.ChampionNotFoundException;
import me.dio.sdw.models.Champions;
import me.dio.sdw.ports.ChampionsRepository;

@Service
public class AskChampionUseCase {

    private final ChampionsRepository repository;

    public AskChampionUseCase(ChampionsRepository repository) {
        this.repository = repository;
    }

    public String askChampion(Long championId, String question) {
        Champions champions = repository.findById(championId)
            .orElseThrow(() -> new ChampionNotFoundException(championId));

        return champions.generateContextByQuestion(question);
    }
}
