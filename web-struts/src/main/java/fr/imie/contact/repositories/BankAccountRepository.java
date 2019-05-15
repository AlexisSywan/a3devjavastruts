package fr.imie.contact.repositories;

import fr.imie.contact.entities.*;

import javax.ejb.*;
import javax.persistence.*;
import java.util.*;

public interface BankAccountRepository {

    public abstract void save(BankAccount entity);

    public abstract List<BankAccount> findAll();

}