package fr.istic.taa.servlet;

import fr.istic.taa.ObjetsMetier.User;
import fr.istic.taa.jaxrs.dao.UserDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="getUsers",urlPatterns={"/GetUsers"})
public class GetUsers extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        response.setContentType("text/html");

        PrintWriter p = new PrintWriter(response.getOutputStream());

        UserDao userDao = new UserDao();
        List<User> users = userDao.findAll();

        p.print("<table>\n" + 
        		"    <thead>\n" + 
        		"        <tr>\n" + 
        		"            <th colspan=\"2\">users</th>\n" + 
        		"        </tr>\n" + 
        		"    </thead>\n" + 
        		"    <tbody>\n" + 
        		"        <tr>\n");
        
                users.forEach(user -> {p.println(user.getName() + " " + user.getSurname());});
                p.print("        </tr>\n" + 
        		"    </tbody>\n" + 
        		"</table>\n" + 
        		"\n" + 
        		"");

        p.flush();

    }


}
