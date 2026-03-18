package org.daypilot.demo.html5eventcalendarspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        // Load .env before Spring reads properties
        Dotenv dotenv = Dotenv.configure()
                               .ignoreIfMissing()  // optional, in case .env is not present
                                .load();

        // Set environment variables programmatically
        System.setProperty("DB_USER", dotenv.get("DB_USER"));
        System.setProperty("DB_PASS", dotenv.get("DB_PASS"));

        SpringApplication.run(Application.class, args);
    }
}