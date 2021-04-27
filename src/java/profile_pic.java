import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/profile_pic"})
public class profile_pic extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        String is_pic=req.getParameter("picture");
        String email=req.getParameter("email");
        String gender=req.getParameter("gender");
        PrintWriter pw=resp.getWriter();
        pw.println("<html>");
        pw.println("<body>");
        pw.println("<div style='height:160px;width:100%;background-color:royalblue'>");
        pw.println("<img src='logo.png' height=160 width=160 >");
        pw.println("</div>");
        pw.println("<div style='margin-top:50px;'>");
        pw.println("<center>");
        pw.println("<form action='upload?email="+email+"' enctype='multipart/form-data' method='post'>");
        pw.println("<table>");
        pw.println("<tr>");
        if(is_pic.equals("N"))
        {
           pw.println("<td rowspan=2><img src='"+gender+".png' heigth=300 width=200></td>");
        }
        else
        {
            //pw.println("hello");
            pw.println("<td rowspan=2><img src='http://localhost:8080/WebApplication1/fetch_image?email="+email+"' heigth=300 width=200></td>");
        }
        pw.println("<td style='font-size:20px;align:center;'>&nbsp;&nbsp;&nbsp;Change Profile Picture<br><br>&nbsp;&nbsp;&nbsp;<input type='file' name='file' style='font-size:15px;'></td>");
        pw.println("<td rowspan=3><input type='submit' value='Next' name='sbt' style='font-size:25px;'></td>");
        pw.println("</tr>");
        pw.println("<tr>");
        pw.println("<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='submit' value='Upload' name='sbt' style='font-size:15px;align:center;'></td>");
        pw.println("</tr>");
        pw.println("</table>");
        pw.println("</form>");
        pw.println("</center>");
        pw.println("</div>");
        pw.println("</body>");
        pw.println("</html>");
    }

    
}
