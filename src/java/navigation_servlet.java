import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/navigation_servlet"})
public class navigation_servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        PrintWriter pw =resp.getWriter();
        pw.println(" <div class=\"navigation\">\n" +
"            <center>\n" +
"            <table class='tabl'>\n" +
"                <tr>\n" +
"                   <td class=\"nvtd\"><a href='Welcome_servlet' style='text-decoration:none;color:black;'>Home</a></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td class=\"nvtd\">Contact</td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td class=\"nvtd\">What's New</td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td class=\"nvtd\"><a href='change_password' style='text-decoration:none;color:black;'>Change Password</a></td>\n" +
"                </tr>\n" +
"            </table>\n" +
"            </center>\n" +
"        </div>");
    }
   
    
}
