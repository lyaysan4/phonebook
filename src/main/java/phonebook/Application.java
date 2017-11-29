package phonebook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import phonebook.controllers.PersonController;
import phonebook.model.Person;
import phonebook.repository.PersonRepository;

import java.util.Optional;

@SpringBootApplication
public class Application {

    private static  final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
