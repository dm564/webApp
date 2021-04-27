
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/header_servlet"})
public class header_servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        String name="";
        Cookie c[] = req.getCookies();
        for(int i=0;i<c.length;++i)
        {
            if((c[i].getName()).equals("name"))
                name=c[i].getValue();
        }
        PrintWriter pw =resp.getWriter();
        pw.println("<div class=\"top\">\n" +
"            <img src=\"logo.png\" height=160 width=160 >\n");
        pw.println("<div style=\"float:right;background-color:lightblue;height:75%;width:20%;margin-right:10px;margin-top:20px;\">\n" +
"		<center>\n" +
"		<h3 style=\"margin-top:25px;font-weight:normal;\">hi "+name+"</h3>\n" +
"		</center>\n" +
"	<div style=\"float:right;background-color:royalblue;height:25%;width:90%;margin-right:10px;margin-top:10px;\">\n" +
"		<center>\n" +
"		<h3 style=\"margin-top:1px;font-weight:normal;\"><a href='logout.html' style='text-decoration:none;color:black;'>logout</a></h3>\n" +
"		</center>\n" +
"		\n" +
"	</div>\n" +
"		\n" +
"	</div>\n" +
"	");
        pw.println("</div>");
    }   
}
