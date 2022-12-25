package ru.gyurii.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.gyurii.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private List<Person> people;
    private static int PEOPLE_COUNT;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Ivan"));
        people.add(new Person(++PEOPLE_COUNT, "Dmitry"));
        people.add(new Person(++PEOPLE_COUNT, "Yegor"));
        people.add(new Person(++PEOPLE_COUNT, "Katy"));

    }

    public List<Person> index() {
        return people;
    }

    public Person show(final int id) {
        return people.stream()
                .filter(person -> person.getId() == id)
                .findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person personUpdate) {
        Person personToBeUpdate = show(id);
        personToBeUpdate.setName(personUpdate.getName());
    }

    public void delete(int deleteId) {
        people.removeIf(p -> p.getId() == deleteId);
    }
}
