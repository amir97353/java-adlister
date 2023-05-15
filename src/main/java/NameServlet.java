import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "NameServlet", urlPatterns = "/name")
//The above is just the end of the url /name
public class NameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Hello my name is Kotlin</h1>");

        System.out.println(req.getParameter("cohort"));
        //In the above we're looking for the value of cohort and what it equals is inside the url that we made. The value can be whatever
        //Paramter is in the url http://localhost:8080/name?cohort=Kotlin
    }
}
