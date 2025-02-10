package me.dio.sdw.ports;

import java.util.List;

import me.dio.sdw.models.Champions;

public interface ChampionsRepository {
    List<Champions> findall();
}
