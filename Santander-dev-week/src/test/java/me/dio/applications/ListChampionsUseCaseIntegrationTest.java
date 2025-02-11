package me.dio.applications;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import me.dio.sdw.application.ListChampionsUseCase;
import me.dio.sdw.models.Champions;

@SpringBootTest
public class ListChampionsUseCaseIntegrationTest {

    @Autowired
    private ListChampionsUseCase listChampionsUseCase;

    public void testListChampions() {
        List<Champions> champions = listChampionsUseCase.findAll();
        assertEquals(12, champions.size());  
    }
}
