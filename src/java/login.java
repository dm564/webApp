import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(urlPatterns = {"/login"})
public class login extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try
        {
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        Class.forName("com.mysql.jdbc.Driver");
        Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/netbeans","root","11111");
        PreparedStatement st=c.prepareStatement("select * from user_data where email=? and pass=? and verified='Y'");
        st.setString(1, email);
        st.setString(2, password);
        ResultSet rs=st.executeQuery();
        
        if(rs.next())
        {
             Blob pic=rs.getBlob("profile_pic");
             if(pic==null)
             {
                 String gender=rs.getString("gender");
                 rs.close();
                 c.close();
                 st.close();
                 resp.sendRedirect("profile_pic?email="+email+"&gender="+gender+"&picture=N");
             }
             else
             {
                 String fname=rs.getString("fname");
                 String lname=rs.getString("lname");
                 HttpSession seson=req.getSession();
                 seson.setAttribute("email",email);
                 Cookie ck=new Cookie("name", fname+" "+lname);
                 resp.addCookie(ck);
                 rs.close();
                 c.close();
                 st.close();
                 resp.sendRedirect("Welcome_servlet");
             }
        }
        else
        {
            rs.close();
            c.close();
            st.close();
            resp.sendRedirect("login_error.html");
        }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
