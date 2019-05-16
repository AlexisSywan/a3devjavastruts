package fr.imie.contact.repositories;

import fr.imie.contact.entities.Person;

import java.util.List;

public interface PersonRepository {

    public abstract void save(Person person);

    public abstract void deleteById(int id);

    public abstract Person findById(int id);

    public abstract List<Person> findAll();
}