import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.metamodel.SetAttribute;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/Welcome_servlet"})
public class Welcome_servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        
        PrintWriter pw=resp.getWriter();
        pw.println("<html>");
        pw.println("<link href=\"style.css\" rel=\"stylesheet\">");
        pw.println("<body>");
        String p="1";
        String s="";
        if(req.getQueryString()!=null)
        {
            p=req.getParameter("page_number");
            s=req.getParameter("search");
        }
        RequestDispatcher rd1=getServletContext().getRequestDispatcher("/header_servlet");
        RequestDispatcher rd2=getServletContext().getRequestDispatcher("/navigation_servlet");
        RequestDispatcher rd3=getServletContext().getRequestDispatcher("/data.jsp?page_number="+p+"&search="+s);
        rd1.include(req, resp);
        rd2.include(req, resp);
        rd3.include(req, resp);
        pw.println("</body>");
        pw.println("</html>");
    }
}
