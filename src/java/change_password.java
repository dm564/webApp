import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/change_password"})
public class change_password extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        PrintWriter pw=resp.getWriter();
        pw.println("<html>");
        pw.println("<link href=\"style.css\" rel=\"stylesheet\">");
        pw.println("<script src=\"validate_change_password.js\"></script>");
        pw.println("<body>");
        RequestDispatcher rd1=getServletContext().getRequestDispatcher("/header_servlet");
        RequestDispatcher rd2=getServletContext().getRequestDispatcher("/navigation_servlet");
        rd1.include(req, resp);
        rd2.include(req, resp);
        pw.println("<div class=\"content\">\n" +
"            <form action=\"validate_change_password\" onsubmit=\"return validate_change_password(this)\">\n" +
"                <table>\n" +
"                    <tr>\n" +
"                        <td class=\"td\">Old Password:</td>\n" +
"                        <td ><input type=\"password\" name=\"data2\" placeholder=\"old\" class=\"tdu\"></td>\n" +
"                    </tr>\n" +
"                     <tr>\n" +
"                        <td class=\"td\">New Password:</td>\n" +
"                        <td ><input type=\"password\" name=\"data3\" placeholder=\"old\" class=\"tdu\"></td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td class=\"td\">Re-Type Password:</td>\n" +
"                        <td ><input type=\"password\" name=\"data4\" placeholder=\"Re-Type\" class=\"tdu\"></td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td class=\"td\">Captcha:</td>\n" +
"                        <td ><input type=\"text\" name=\"data5\" placeholder=\"\" class=\"tdu\"></td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td></td>\n" +
"                        <td><img src='captcha' height='40' width='190'></td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td></td>\n" +
"                        <td style='align-items: left;'><input type='submit' value='SUBMIT' class='tdu'></td>\n" +
"                    </tr>\n" );
        pw.println("<tr>\n" +
"                        <td colspan=\"2\">\n" +
"                            <span id=\"err\" style=\"color:red;\"></span>\n" +
"                        </td>\n" +
"                    </tr>\n");
        if(req.getQueryString()!=null)
        {
            String s=req.getParameter("data");
            if(s.equals("C"))
            {
                pw.println("<tr><h3 style='color:red;font-weight:normal;'>INVALID CAPTCHA !!!</h3></tr>");
            }
            if(s.equals("U"))
            {
                pw.println("<tr><h3 style='color:green;font-weight:normal;'>Password changed SUCCESSFULLY</h3></tr>");
                try
                {
                    resp.setHeader("Refresh", "5; URL=http://localhost:8080/WebApplication1/login.html");
                }
                catch(Exception e){}
                
            }
            if(s.equals("NU"))
            {
                pw.println("<tr><h3 style='color:red;font-weight:normal;'>OLD password WRONG</h3></tr>");
            }
            
        }
        
        pw.println("</table>\n" +
"            </form>\n" +
"        </div>");
        pw.println("</body>");
        pw.println("</html>");
        //String url=req.getRequestURI();
    }
    
}
