package fr.imie.contact.repositories;

import fr.imie.contact.entities.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PersonRepositoryJpa implements PersonRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Person person) {
        if (person.getId() == null)
            em.persist(person);
        else
            em.merge(person);
    }

    public void deleteById(int id) {
        em.remove(em.getReference(Person.class, id));
    }

    public Person findById(int id) {
        return em.find(Person.class, id);
    }

    public List<Person> findAll() {
        return em.createQuery("select p from Person p", Person.class).getResultList();
    }

}