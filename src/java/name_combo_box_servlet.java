
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/name_combo_box_servlet"})
public class name_combo_box_servlet extends HttpServlet {

     String names[]=new String[10];
     int index=0;
     String temp;
     
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
        pw.println("<tr colspan=3>");
        pw.println("<td>");
        pw.println("<select>");
        temp=req.getParameter("name");
        pw.println("<option>NAMES</option>");
        if(temp!=null)
        {  
          names[index++]=temp;
        }
        if(index!=0)
        {
           for(int i=0;i<index;i++)
           {
                pw.println("<option>"+names[i]+"</option>");
           }
        } 
        pw.println("</select>");
        pw.println("</td>");
        pw.println("</tr>");
        pw.println("</table>");
        pw.println("</form>");
        pw.println("</body>");
        pw.println("</html>");
    }
}
