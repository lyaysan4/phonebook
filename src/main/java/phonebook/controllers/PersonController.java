package phonebook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import phonebook.model.Person;
import phonebook.repository.PersonRepository;

import java.util.List;

@Controller
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/search")
    public String searchPerson(@RequestParam(value = "searchLine", required = false, defaultValue = "") String line,
                               Model model) {
        List<Person> persons = personRepository.findByLine("%" + line + "%");
        if (persons == null || persons.isEmpty()) {
            String notification = "Не удалось ничего найти :(";
            model.addAttribute("notification", notification);
            return "mainPage";
        }
        model.addAttribute("persons", persons);
        return "mainPage";
    }


    @PostMapping("/delete")
    public String deletePerson(@RequestParam(value = "id") Long id, Model model) {
        personRepository.delete(id);
        return "redirect:/";
    }

    @GetMapping("/add")
    public String add() {
        return "addPerson";
    }

    @GetMapping("/")
    public String showAll(Model model) {
        List<Person> persons = (List<Person>) personRepository.findAll();
        if (persons != null)
        model.addAttribute("persons", persons);
        return "mainPage";
    }

    @PostMapping("/add")
    public String addPerson(@RequestParam(value = "name") String name, @RequestParam(value = "phoneNumber") String phoneNumber,
                            @RequestParam(value = "address") String address, Model model) {
        Person addingPerson = new Person(name, phoneNumber, address);

        try {
            personRepository.save(addingPerson);
            String notification = "Данные успешно сохранены!";
            model.addAttribute("notification", notification);
            return "addPerson";
        } catch (DataIntegrityViolationException exception) {
            String notification = "Человек с такими данными уже существует. Попробуйте еще раз.";
            model.addAttribute("notification", notification);
            return "addPerson";
        } catch (Exception exception){
            String notification = "Упс, что-то пошло не так :( Попробуйте еще раз";
            model.addAttribute("notification", notification);
            return "addPerson";
        }


    }
}
