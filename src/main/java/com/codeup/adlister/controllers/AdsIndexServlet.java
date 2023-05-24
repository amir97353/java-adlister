package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //We set an attribute in order to access it inside our jsp file
        request.setAttribute("ads", DaoFactory.getAdsDao().all());
        //Daofactory comes from the Daofactory class. Inside Daofactory is the method getAdsDao that creates a new instance of the connection that is defiened inside the MySqlAdsDao(constructor). The .all method is defined in the MysqlAdsDao
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
    }
}
