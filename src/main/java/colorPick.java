import javax.print.DocFlavor;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "colorPick", value = "/colorPick")
public class colorPick extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/pickcolor.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userColor = request.getParameter("userColor");
        request.setAttribute("userColor", userColor);
        response.sendRedirect("/viewcolor.jsp");
    }
}
