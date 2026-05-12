import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/generic")
public class GenericServlett extends GenericServlet {

    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>This is GenericServlet Example</h2>");
        out.println("<p>GenericServlet is protocol independent.</p>");
    }
}