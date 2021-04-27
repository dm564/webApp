import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/color_servlet"})
public class color_servlet extends HttpServlet {

    String color;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       color=req.getParameter("color");
       PrintWriter pw=resp.getWriter();
       pw.println("<html>");
       pw.println("<body bgcolor="+color+">");
       pw.println("</body>");
       pw.println("</html>");
       
    }

}
