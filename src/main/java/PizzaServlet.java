import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.datatransfer.DataFlavor;
import java.io.IOException;

@WebServlet(name = "PizzaServlet", value = "/Pizza-Order")
public class PizzaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Pizza-Form.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String crustType = request.getParameter("crustType");
        System.out.println(crustType);

        String sauceType = request.getParameter("sauceType");
        System.out.println(sauceType);

        String pizzaSize = request.getParameter("pizzaSize");
        System.out.println(pizzaSize);

    }
}
