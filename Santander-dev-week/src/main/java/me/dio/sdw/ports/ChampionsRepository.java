package me.dio.sdw.ports;

import java.util.List;
import java.util.Optional;

import me.dio.sdw.models.Champions;

public interface ChampionsRepository {
    List<Champions> findAll();

    Optional<Champions> findById(Long id);
}
