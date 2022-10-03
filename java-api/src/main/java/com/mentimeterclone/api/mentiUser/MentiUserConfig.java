package com.mentimeterclone.api.mentiUser;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            MentiUser rasmus = new MentiUser(
                    "Rasmus",
                    "rasmusrudling@gmail.com"
            );

            MentiUser anna = new MentiUser(
                    "Anna",
                    "annalovisaellen@gmail.com"
            );

            userRepository.saveAll(List.of(rasmus, anna));
        };
    }
}
