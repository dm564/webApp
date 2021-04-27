import java.sql.*;
import java.io.PrintWriter;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/signup_database"})
public class signup_database extends HttpServlet {

     int i,otp=0,temp;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        try{
        for(i=0;i<4;i++)
        {
            temp=(int)(Math.random()*10);
            if(temp==10 || temp==0)
            {
                temp=1;
            }
            otp=otp*10+temp;
        }
        String fname=req.getParameter("data1");
        String lname=req.getParameter("data2");
        String email=req.getParameter("data3");
        String pass=req.getParameter("data4");
        String gender=req.getParameter("data6");
        String country=req.getParameter("data7");
        Class.forName("com.mysql.jdbc.Driver");
        Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/netbeans","root","11111");
        Statement st=c.createStatement();
        st.executeUpdate("insert into user_data (fname,lname,email,pass,gender,country,otp,verified) values ('"+fname+"','"+lname+"','"+email+"','"+pass+"','"+gender+"','"+country+"',"+otp+",'N')");
        PrintWriter pw=resp.getWriter();
        c.close();
        st.close();
        send_mail_function(email);
        resp.sendRedirect("otp.html");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
     void send_mail_function(String email)
    {
        try{
        Properties property=new Properties();
        property.put("mail.smtp.host","smtp.gmail.com");
        property.put("mail.smtp.port","465");
        property.put("mail.smtp.user","netbeanswork");
        property.put("mail.smtp.password","netbeanswork");
        property.put("mail.smtps.auth","true");
        
        
        Session seson=Session.getDefaultInstance(property);
        
        MimeMessage message=new MimeMessage(seson);
        message.setSender(new InternetAddress("netbeanswork@gmail.com"));
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(email));     
        message.setSubject("Confirmation MAIL from ENIGMA");
        message.setContent("Kindly click on the link given below <br> http://localhost:8080/WebApplication1/otp.html<br> OTP : "+otp+"<br>Enigma Team","text/html");
        
        Transport trans=seson.getTransport("smtps");
        trans.connect("smtp.gmail.com","netbeanswork","netbeanswork");
        trans.sendMessage(message, message.getAllRecipients());
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}


