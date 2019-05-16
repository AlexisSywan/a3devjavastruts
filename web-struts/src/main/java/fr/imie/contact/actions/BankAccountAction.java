package fr.imie.contact.actions;

import com.opensymphony.xwork2.ActionSupport;
import fr.imie.contact.entities.*;
import fr.imie.contact.repositories.*;

import javax.inject.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;

//@WebServlet("/bankaccount/*")
public class BankAccountAction extends ActionSupport {

    //  @Inject
//  private BankAccountRepository bankAccountRepository;
//  @Inject
//  private PersonRepository personRepository;

    private BankAccountRepositoryMock bankAccountRepositoryMock = new BankAccountRepositoryMock();
    private PersonRepositoryMock personRepositoryMock = new PersonRepositoryMock();

    private Person person;
    private BankAccount bankAccount;

    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    private List<BankAccount> bankAccounts;

    private List<Person> persons;

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public String save () {
        bankAccountRepositoryMock.save(bankAccount);
        return SUCCESS;
    }


    public String findAll () {
        persons = personRepositoryMock.findAll();
        bankAccounts = bankAccountRepositoryMock.findAll();
        //request.setAttribute("persons", persons);
        //request.getRequestDispatcher("/WEB-INF/views/person.jsp").forward(request, response);
        return SUCCESS;
    }

}