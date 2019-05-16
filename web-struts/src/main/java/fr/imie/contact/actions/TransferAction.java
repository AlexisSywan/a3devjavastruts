package fr.imie.contact.actions;

import com.opensymphony.xwork2.ActionSupport;
import fr.imie.contact.entities.BankAccount;
import fr.imie.contact.entities.Person;
import fr.imie.contact.repositories.BankAccountRepositoryMock;
import fr.imie.contact.repositories.PersonRepositoryMock;

import java.math.BigDecimal;
import java.util.List;

//@WebServlet("/transfer/*")
public class TransferAction extends ActionSupport {

    private BankAccountRepositoryMock bankAccountRepositoryMock = new BankAccountRepositoryMock();
    private PersonRepositoryMock personRepositoryMock = new PersonRepositoryMock();

    private BankAccount bankAccountDebit;
    private BankAccount bankAccountCredit;
    private Person person;

    public Integer getDebit() {
        return debit;
    }

    public void setDebit(Integer debit) {
        this.debit = debit;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    private Integer debit;
    private Integer credit;

    private List<Person> persons;
    private List<BankAccount> bankAccounts;

    public BigDecimal getAmmount() {
        return ammount;
    }

    public void setAmmount(BigDecimal ammount) {
        this.ammount = ammount;
    }

    private BigDecimal ammount;

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public String findAll () {
        persons = personRepositoryMock.findAll();
        bankAccounts = bankAccountRepositoryMock.findAll();
        //request.setAttribute("persons", persons);
        //request.getRequestDispatcher("/WEB-INF/views/person.jsp").forward(request, response);
        return SUCCESS;
    }


    public String save() {
        System.out.println(credit);
        System.out.println(debit);
        bankAccountCredit = bankAccountRepositoryMock.findById(credit);
        bankAccountDebit = bankAccountRepositoryMock.findById(debit);
        bankAccountDebit.setBalance(bankAccountDebit.getBalance().subtract(ammount));
        bankAccountCredit.setBalance(bankAccountCredit.getBalance().add(ammount));
        bankAccountRepositoryMock.save(bankAccountCredit);
        bankAccountRepositoryMock.save(bankAccountDebit);

        return SUCCESS;
    }

}