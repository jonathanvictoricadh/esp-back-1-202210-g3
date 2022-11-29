package com.spotify.music;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableRabbit
@AutoConfiguration
public class ApiMusicApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiMusicApplication.class, args);
    }

}
