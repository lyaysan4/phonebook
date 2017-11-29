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
//
//    @Bean
//	public CommandLineRunner demo(PersonRepository repository){
//		return (args) -> {
////			repository.save(new Person("person1", "123456", "qwerty"));
////			repository.save(new Person("person2", "456896", "fhtkiy"));
////			repository.save(new Person("person3", "125896", "dgfhry"));
////			repository.save(new Person("person4", "358947", "ouyitk"));
////			repository.save(new Person("person5", "125824", "poiujy"));
//
//			log.info("Books found with findAll():");
//			log.info("---------------------------");
//			for (Person person : repository.findAll()) {
//				log.info(person.toString());
//			}
//			log.info("");
//
//			Optional<Person> person = repository.findById(1L);
//            log.info("Book found with findOne(1L):");
//			log.info("----------------------------");
//		person.ifPresent(p -> log.info(p.toString()));
//			log.info("");
//
//			log.info("Books found by (er):");
//			log.info("-------------------------------------");
//            System.out.println(repository.existsByAddress("qwerty"));
//            log.info("");
//		};
//	}
}
