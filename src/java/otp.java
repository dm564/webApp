import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/otp"})
public class otp extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
       try
       {
       String email=req.getParameter("email");
       String otp=req.getParameter("otp");
       
       Class.forName("com.mysql.jdbc.Driver");
       Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/netbeans","root","11111");
       PreparedStatement st=c.prepareStatement("select * from user_data where email=? and otp=?");
       st.setString(1,email);
       st.setString(2,otp);
       ResultSet rs=st.executeQuery();
       if(rs.next())
       {
           st=c.prepareStatement("update user_data set verified='Y' where email=? ");
           st.setString(1,email);
           st.executeUpdate();
           c.close();
           st.close();
           resp.sendRedirect("http://localhost:8080/WebApplication1/login.html");
       }
       else
       {
           c.close();
           st.close();
           resp.sendRedirect("http://localhost:8080/WebApplication1/otp_error.html");
       }
       }
       catch(Exception e)
       {
         System.out.println(e);
       }
    }
}
