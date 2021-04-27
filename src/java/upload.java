import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import javax.servlet.http.Part;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.sql.Blob;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Cookie;

@WebServlet(urlPatterns = {"/upload"})
@MultipartConfig(maxFileSize = 2*1024*1024)
public class upload extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        try{
        String email=req.getParameter("email");
        String choice=req.getParameter("sbt");
        PrintWriter pw=resp.getWriter();
        Class.forName("com.mysql.jdbc.Driver");
        Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/netbeans","root","11111");
        PreparedStatement st=c.prepareStatement("select * from user_data where email=?");
        st.setString(1,email);
        ResultSet rs=st.executeQuery();
        rs.next();
        if(choice.equals("Next"))
        {
            String fname=rs.getString("fname");
            String lname=rs.getString("lname");
            Cookie ck=new Cookie("name", fname+" "+lname);
            resp.addCookie(ck);
            rs.close();
            c.close();
            st.close();
            resp.sendRedirect("Welcome_servlet");
        }
        else if(choice.equals("Upload"))
        {
            Part p=req.getPart("file");
            String gender=rs.getString("gender");
            InputStream bin=p.getInputStream();
            
            PreparedStatement st1=c.prepareStatement("update user_data set profile_pic=? where email=?");
            
            st1.setBinaryStream(1,bin,(int)p.getSize());
            st1.setString(2,email);
            st1.executeUpdate();
            
            c.close();
            st1.close();
            st.close();
            resp.sendRedirect("profile_pic?email="+email+"&picture=Y&gender="+gender);
        }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
    }


}
