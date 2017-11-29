package phonebook.repository;

import org.springframework.data.repository.CrudRepository;
import phonebook.model.Person;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findByNameLikeIgnoreCase(String line);
    List<Person> findByAddressLikeIgnoreCase(String line);
    List<Person> findByPhoneNumberLikeIgnoreCase(String line);

    default List<Person> findByLine(String line) {
        return Stream.of(findByNameLikeIgnoreCase(line), findByAddressLikeIgnoreCase(line), findByPhoneNumberLikeIgnoreCase(line))
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
    }
}
