package fr.imie.contact.servlets;

import fr.imie.contact.DateUtils;
import fr.imie.contact.entities.Person;
import fr.imie.contact.repositories.PersonRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/person/*")
public class PersonServlet extends HttpServlet {

    @Inject
    private PersonRepository repository;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Person person = new Person();

        if (request.getMethod().equalsIgnoreCase("post")){

            if(request.getParameter("id") != null) {
                person =repository.findById(Integer.parseInt(request.getParameter("id")));
            }

            person.setFirstName(request.getParameter("firstName"));
            person.setLastName(request.getParameter("lastName"));
            person.setEmail(request.getParameter("email"));

            String text = request.getParameter("birthDate");
            LocalDate date = DateUtils.toLocalDate(text);
            person.setBirthDate(date);


            repository.save(person);
        }

        if(request.getPathInfo() != null && request.getPathInfo().matches("/delete/[0-9]+")) {

            Integer id = Integer.parseInt(request.getPathInfo().split("/")[2]);
            repository.deleteById(id);

        }

        if(request.getPathInfo() != null && request.getPathInfo().matches("/edit/[0-9]+")) {

            Integer id = Integer.parseInt(request.getPathInfo().split("/")[2]);
            request.setAttribute("id", id);
        }

        List<Person> persons = repository.findAll();
        request.setAttribute("persons", persons);
        request.getRequestDispatcher("/WEB-INF/views/person.jsp").forward(request, response);
    }

}