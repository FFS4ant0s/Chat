package me.dio.sdw.application;

import java.util.List;

import org.springframework.stereotype.Service;

import me.dio.sdw.models.Champions;
import me.dio.sdw.ports.ChampionsRepository;

@Service
public class ListChampionsUseCase {

    private final ChampionsRepository repository;

    public ListChampionsUseCase(ChampionsRepository repository) {
        this.repository = repository;
    }

    public List<Champions> findAll() {
        return repository.findAll();
    }
}
