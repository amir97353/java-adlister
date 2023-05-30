package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.Users;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: show the registration form
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request,response);
        //Runs the register.jsp file
        //Inside the jsp file is our form

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // TODO: ensure the submitted information is valid
        // These parameters come from the from in register.jsp the register.jsp has a method of post
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        // TODO: create a new user based off of the submitted information
        //The below if statement is saying that if there is a username email and password then create a new user and set the parameters of the username email and password to the paramters above that come from the form
        if(username != null && email !=null && password!=null){
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setEmail(email);
            newUser.setPassword(password);

            Users usersDao = DaoFactory.getUsersDao();
            //Users reference the Users interface and you make that equal to DaoFactory.getUsersDao it gives you access to  the .insert method tha comes from MySqlUsersDao

            usersDao.insert(newUser);
            //above we are running the .insert method to enter the new user that we created in to the database.
            response.sendRedirect("/login");
            //After the new user is added you send them to the login page to login with their added credentials.

        }else{
            // If they are not a user then you send them to the register page where they would have to send out the register form
            response.sendRedirect("/register");
        }


        // TODO: if a user was successfully created, send them to their profile
    }
}
