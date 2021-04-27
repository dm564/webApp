import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/first_click"})
public class first_click extends HttpServlet {

    int click;
    @Override
    public void init() throws ServletException {
        click=0;
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        click++;
        PrintWriter pw = resp.getWriter();
        pw.println("number of clicks "+click);
    }

    @Override
    public void destroy() {
        click=0;
    }
}
