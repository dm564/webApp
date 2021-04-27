import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/exp_2"})
public class exp_2 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String choice=req.getParameter("click");
        String s=req.getParameter("data");
        PrintWriter pw=resp.getWriter();
        pw.println(s+"hilll");
        if(choice.equals("click1"))
        {
            pw.println("click 1");
        }
        else if(choice.equals("click2"))
        {
            pw.println("click 2");
        }
        else
        {
            pw.println("null "+choice);
        }            
    }
}
