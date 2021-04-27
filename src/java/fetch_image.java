import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

@WebServlet(urlPatterns = {"/fetch_image"})
public class fetch_image extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        try{
        String email=req.getParameter("email");
        Class.forName("com.mysql.jdbc.Driver");
        Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/netbeans","root","11111");
        PreparedStatement st=c.prepareStatement("select * from user_data where email=?");
        st.setString(1,email);
        ResultSet rs=st.executeQuery();
        rs.next();
        Blob pic=rs.getBlob("profile_pic");
        c.close();
        st.close();
        rs.close();
        InputStream in=pic.getBinaryStream();
        BufferedImage img=ImageIO.read(in);
        ImageIO.write(img,"PNG", resp.getOutputStream());
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
}
