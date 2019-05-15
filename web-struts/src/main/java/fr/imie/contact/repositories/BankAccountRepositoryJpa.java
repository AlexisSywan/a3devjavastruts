package fr.imie.contact.repositories;

import fr.imie.contact.entities.BankAccount;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BankAccountRepositoryJpa implements BankAccountRepository{

    @PersistenceContext
    EntityManager em;

    public List<BankAccount> findAll() {
        return em.createQuery("select ba from BankAccount ba").getResultList();
    }

    public void save(BankAccount entity) {
        if (entity.getId() == null) {
            em.persist(entity);
        }else {
            em.merge(entity);
        }
    }

    public BankAccount findById(int id) {
        return em.find(BankAccount.class, id);
    }
}
