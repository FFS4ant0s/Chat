package me.dio.sdw.ports;

public interface GenerativeAiApi {

    String generatedContent(String objective, String context);
}