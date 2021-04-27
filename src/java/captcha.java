import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/captcha"})
public class captcha extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        String captcha="";
        String temp_captcha="";
        String take="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for(int i=0;i<6;++i)
        {
            temp_captcha+=take.charAt((int)(36*Math.random()));
        }
        captcha=temp_captcha;
        Cookie ck=new Cookie("captcha", captcha);
        resp.addCookie(ck);
        //PrintWriter pw=resp.getWriter();
        //pw.println(captcha);
        BufferedImage img=new BufferedImage(190,40,BufferedImage.TYPE_INT_RGB);
        Graphics g=img.getGraphics();
        g.setColor(Color.WHITE);
        g.drawRect(0, 0, 190, 40);
        g.fillRect(0, 0, 190, 40);
        g.setColor(Color.BLACK);
        Font f=new Font("Monotype Corsiva",0,40);
        g.setFont(f);
        g.drawString(temp_captcha, 1, 35);
        for(int i=0;i<15;++i)
        {
            g.drawLine((int)(190*Math.random()),(int)(40*Math.random()),(int)(190*Math.random()),(int)(40*Math.random()));
        }
        ImageIO.write(img, "PNG", resp.getOutputStream());
    }

    
}
