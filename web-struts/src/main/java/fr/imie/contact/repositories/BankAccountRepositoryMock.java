package fr.imie.contact.repositories;

import fr.imie.contact.entities.*;

import java.util.*;

public class BankAccountRepositoryMock implements BankAccountRepository {

    private static Map<Integer,BankAccount> bankAccounts = new TreeMap();

    private static int autoIncrement = 1;

    public BankAccountRepositoryMock() {

    }

    public List<BankAccount> findAll() {
        return new ArrayList(bankAccounts.values());
    }

    public void save(BankAccount bankAccount) {
        if(bankAccount.getId() == null) {
            bankAccounts.put(autoIncrement, bankAccount);
            bankAccount.setId(autoIncrement);
            autoIncrement++;
        } else {
            bankAccounts.put(bankAccount.getId(), bankAccount);
        }
    }

}