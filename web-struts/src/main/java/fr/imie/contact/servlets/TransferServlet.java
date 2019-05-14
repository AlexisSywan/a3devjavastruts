package fr.imie.contact.servlets;

import com.sun.deploy.perf.PerfRollup;
import fr.imie.contact.*;
import fr.imie.contact.entities.*;
import fr.imie.contact.repositories.*;
import sun.invoke.empty.Empty;

import javax.inject.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import java.math.BigDecimal;
import java.time.*;
import java.util.*;

@WebServlet("/transfer/*")
public class TransferServlet extends HttpServlet {

    @Inject
    private BankAccountRepository bankaccountrepository;

    @Inject
    private PersonRepository personrepository;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getMethod().equalsIgnoreCase("post")){

            BigDecimal ammount = new BigDecimal(request.getParameter("ammount"));

            Integer idDebit = Integer.parseInt(request.getParameter("debitAccount"));
            Integer idCredit = Integer.parseInt(request.getParameter("creditAccount"));

            BankAccount debitAccount = bankaccountrepository.findById(idDebit);
            BankAccount creditAccount = bankaccountrepository.findById(idCredit);

            debitAccount.setBalance(debitAccount.getBalance().subtract(ammount));
            creditAccount.setBalance(creditAccount.getBalance().add(ammount));

            bankaccountrepository.save(debitAccount);
            bankaccountrepository.save(creditAccount);
        }

        List<BankAccount> accounts = bankaccountrepository.findAll();
        List<Person> persons = personrepository.findAll();

        request.setAttribute("accounts", accounts);
        request.setAttribute("persons", persons);

        request.getRequestDispatcher("/WEB-INF/views/transfer.jsp").forward(request, response);
    }

}