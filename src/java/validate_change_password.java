import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
@WebServlet(urlPatterns = {"/validate_change_password"})
public class validate_change_password extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        try{
        
        HttpSession seson=req.getSession();
        String email=seson.getAttribute("email").toString();
        String opass=req.getParameter("data2");
        String npass=req.getParameter("data3");
        String capha=req.getParameter("data5");
        
        PrintWriter pw=resp.getWriter();
        
        String captcha="";
        Cookie ck[]=req.getCookies();
        for(int i=0;i<ck.length;++i)
        {
            if((ck[i].getName()).equals("captcha"))
            {
                captcha=ck[i].getValue();
            }
        }
        if(captcha.equals(capha))
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/netbeans","root","12345");
            
            PreparedStatement st1=c.prepareStatement("select * from user_data where email=? and pass=?");
            st1.setString(1, email);
            st1.setString(2, opass);
            ResultSet rs=st1.executeQuery();
            if(rs.next())
            {
                PreparedStatement st2=c.prepareStatement("Update user_data set pass=? where email=?");
                st2.setString(1, npass);
                st2.setString(2, email);
                st2.executeUpdate();
            
                st1.close();
                st2.close();
                c.close();
                resp.sendRedirect("change_password?data=U");
            }
            else
            {
                //pw.println("inside database");
                c.close();
                st1.close();
                resp.sendRedirect("change_password?data=NU");
            }
        }
        else
        {
            //pw.println("inside capha");
            pw.println(capha);
            pw.println(captcha);
            resp.sendRedirect("change_password?data=C");
        }
                
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
    }
}
