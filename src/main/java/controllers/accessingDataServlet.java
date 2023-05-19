package controllers;

import daopackage.DaoFactory;
import models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="accessingDataServlet",urlPatterns = "/ads")
public class accessingDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Ad> allAds = DaoFactory.getAdsDao().all();
        req.setAttribute("allads",allAds);
        req.getRequestDispatcher("/ads/index.jsp").forward(req, resp);
    }
}
