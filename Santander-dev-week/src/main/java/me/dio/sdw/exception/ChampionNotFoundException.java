package me.dio.sdw.exception;

public class ChampionNotFoundException extends  RuntimeException{

    public ChampionNotFoundException(Long championId) {
        super("Champion %d not found");
    }

}
