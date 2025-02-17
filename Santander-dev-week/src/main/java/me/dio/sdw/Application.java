package me.dio.sdw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "me.dio.sdw.adapters.out")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
