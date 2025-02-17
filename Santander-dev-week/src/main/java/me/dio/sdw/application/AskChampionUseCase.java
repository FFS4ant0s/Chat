package me.dio.sdw.application;

import org.springframework.stereotype.Service;

import me.dio.sdw.exception.ChampionNotFoundException;
import me.dio.sdw.models.Champions;
import me.dio.sdw.ports.ChampionsRepository;
import me.dio.sdw.ports.GenerativeAiApi;

@Service
public class AskChampionUseCase {

    private final ChampionsRepository repository;
    private final GenerativeAiApi genAiService;

    public AskChampionUseCase(ChampionsRepository repository, GenerativeAiApi genAiService) {
        this.repository = repository;
        this.genAiService = genAiService;
    }

    public String askChampion(Long championId, String question) {
        Champions champion = repository.findById(championId)
                .orElseThrow(() -> new ChampionNotFoundException(championId));

        String context = champion.generateContextByQuestion(question);
        String objective = """
                Atue como um assistente com a habilidade de se comportar como os Campeões do League of Legends (LOL).
                Responda perguntas incorporando a personalidade e estilo de um determinado Campeão.
                Segue a pergunta, o nome do Campeão e sua respectiva lore (história):
                """;

        return genAiService.generatedContent(objective, context);
    }
}
