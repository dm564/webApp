
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/hello_servlet"})
public class hello_servlet extends HttpServlet {

    String name;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw=resp.getWriter();
        pw.println("<html>");
        pw.println("<body>");
        pw.println("<table>");
        pw.println("<form action=>");
        pw.println("<table>");
        pw.println("<tr>");
        pw.println("<td>NAME:</td>");
        pw.println("<td><input type=text name=name></td>");
        pw.println("<td><input type=submit value=SUBMIT></td>");
        pw.println("</tr>");
        name=req.getParameter("name");
        if(name!=null)
        {
            pw.println("<tr colspan=3>");
            pw.println("<td>HELLO "+ name +" </td>");
            pw.println("</td>");
        }
        pw.println("</table>");
        pw.println("</form>");
        pw.println("</body>");
        pw.println("</html>");
    }
    
}
