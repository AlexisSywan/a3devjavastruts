package fr.imie.contact.repositories;

import fr.imie.contact.entities.BankAccount;
import fr.imie.contact.entities.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collector;

public class BankAccountRepositoryMock implements BankAccountRepository {

    private static Map<Integer,BankAccount> bankAccounts = new TreeMap();

    private static int autoIncrement = 1;

    public BankAccountRepositoryMock() {

    }

    public List<BankAccount> findAll() {
        return new ArrayList(bankAccounts.values());
    }

    public void save(BankAccount bankAccount) {
        Integer owner_id = bankAccount.getOwner().getId();
        Person owner = new PersonRepositoryMock().findById(owner_id);
        bankAccount.setOwner(owner);

        if(bankAccount.getId() == null) {
            bankAccounts.put(autoIncrement, bankAccount);
            bankAccount.setId(autoIncrement);
            autoIncrement++;
        } else {
            bankAccounts.put(bankAccount.getId(), bankAccount);
        }
    }

    public BankAccount findById(int id) {
        return bankAccounts.get(id);
    }

}