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
}
