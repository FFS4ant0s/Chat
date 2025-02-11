package me.dio.sdw.application;

import java.util.List;

import me.dio.sdw.models.Champions;
import me.dio.sdw.ports.ChampionsRepository;

public record ListChampionsUseCase (ChampionsRepository repository) {

    public List<Champions> findAll(){
        return  repository.findAll();
    }

}
