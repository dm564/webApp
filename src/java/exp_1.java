import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/exp_1"})
public class exp_1 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        String s=req.getParameter("data");
        PrintWriter pw=resp.getWriter();
       if(s.equals("deepak"))
        {
            String target="exp_2?data="+s;
            pw.println("<html>");
            pw.println("<body>");
            pw.println("<form action='"+target+"'  method='post'>");
            pw.println(target + "<input type='submit' value='click1' name='click'>");
            pw.println(target + "<input type='submit' value='click2' name='click'>");
            pw.println("</form>");
            pw.println("</body>");
            pw.println("</html>");
        }
    }
    
    
}
