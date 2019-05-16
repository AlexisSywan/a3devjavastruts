package fr.imie.contact.actions;

import com.opensymphony.xwork2.ActionSupport;
import fr.imie.contact.entities.Person;
import fr.imie.contact.repositories.PersonRepository;
import fr.imie.contact.repositories.PersonRepositoryMock;

import java.util.List;

public class PersonAction extends ActionSupport {

    private PersonRepository repository = new PersonRepositoryMock();

    private Person person;

    private List<Person> persons;

    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String save() {
        repository.save(person);
        return SUCCESS;
    }
    public String deleteById() {
        repository.deleteById(id);
        return SUCCESS;
    }
    public String findAll() {
        persons = repository.findAll();
        return SUCCESS;
    }

    public String findById() {
        person = repository.findById(id);
        persons = repository.findAll();
        return SUCCESS;
    }

}