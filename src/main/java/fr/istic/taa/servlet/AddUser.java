package fr.istic.taa.servlet;
import fr.istic.taa.ObjetsMetier.User;
import fr.istic.taa.jaxrs.dao.UserDao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="addUser",urlPatterns={"/AddUser"})
public class AddUser extends HttpServlet {

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        UserDao userDao = new UserDao();

        User user = new User();
        user.setName(request.getParameter("name"));
        user.setSurname(request.getParameter("firstname"));
        userDao.save(user);

        out.println(
                "<H1>Recapitulatif des informations</H1>\n" +
                "<UL>\n" +
                " <LI>Nom: "
                + request.getParameter("name") + "\n" +
                " <LI>Prenom: "
                + request.getParameter("firstname") + "\n" +
                "</UL>\n");
    }
}

