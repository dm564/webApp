package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.File;

public final class data_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');

    String path=application.getRealPath("/images");
    //out.println(path);
    File f=new File(path);
    String filename[]=f.list();
    int total_no_of_files=filename.length;
    int page_number=Integer.parseInt(request.getParameter("page_number"));
    String search=request.getParameter("search");
    if(search.length()!=0)
    {
        String f_temp[]=new String[total_no_of_files];
        int i=0,k=0;
        for(i=0;i<total_no_of_files;++i)
        {
            if(filename[i].indexOf(search)!=-1)
            {
                f_temp[k]=filename[i];
                ++k;
            }
        }
        filename=f_temp;
        total_no_of_files=k;
    }
    int start=(page_number-1)*6;
    int end=page_number*6-1;
    int image_counter=start;

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Wallpapers</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <br>\n");
      out.write("        <div style='width:73%;height:470px;background-color: antiquewhite;float:right;'>\n");
      out.write("            <form action=\"Welcome_servlet\">\n");
      out.write("                <tr>\n");
      out.write("                   <td><input type='text' name=\"search\" placeholder='What are you looking for?'style='width:250px;height:30px;margin-top: 20px;margin-left: 90px;' </td>\n");
      out.write("                   <td><input type='submit' value='Search' style='width:80px;height:30px'</td>\n");
      out.write("                   <td><input type=hidden name='page_number' value='1' ></td>\n");
      out.write("                </tr> \n");
      out.write("            </form>        \n");
      out.write("            <br>\n");
      out.write("    <center>\n");
      out.write("        <form>\n");
      out.write("            <table>\n");
      out.write("                ");

                    for(int i=0;i<2;++i)
                    {
                        
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                ");

                    for(int j=0;j<3;++j)
                    {
                         if(image_counter<total_no_of_files)
                            {
                        
                
      out.write("     \n");
      out.write("                <td>\n");
      out.write("                    <a href=\"download.jsp/filename=");
      out.print(filename[image_counter]);
      out.write("\">\n");
      out.write("                    <img style=\"border:1px solid gray;margin-left: 40px;margin-bottom: 20px;\" src=\"images/");
      out.print(filename[image_counter]);
      out.write("\" height=\"150\" width=\"250\"/>\n");
      out.write("                    </a>\n");
      out.write("                </td>\n");
      out.write("                    ");

                        ++image_counter;
                        }
                           else
                            break;
                        }
                    
      out.write("\n");
      out.write("                    </tr>\n");
      out.write("                ");

                    
                    }
                    ++page_number;
                
      out.write("\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("            &emsp;&emsp;\n");
      out.write("            ");

                if(page_number>=3)
                {
            
      out.write("\n");
      out.write("            <a href=\"Welcome_servlet?page_number=1&search=");
      out.print(search);
      out.write("\" style=\"text-decoration: none\">first</a>\n");
      out.write("            \n");
      out.write("            &emsp;\n");
      out.write("            ...\n");
      out.write("            &emsp;\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("            ");

                if(page_number>=3)
                {
            
      out.write("\n");
      out.write("            <a href=\"Welcome_servlet?page_number=");
      out.print(page_number-2);
      out.write("&search=");
      out.print(search);
      out.write("\" style=\"text-decoration: none\">prev</a>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("            &emsp;\n");
      out.write("            ");
      out.print(page_number-1);
      out.write("\n");
      out.write("            &emsp;\n");
      out.write("           ");

              
               double d=(double)total_no_of_files;
               if(Math.ceil(d/6)>=page_number)
               {
           
      out.write("\n");
      out.write("            <a href=\"Welcome_servlet?page_number=");
      out.print(page_number);
      out.write("&search=");
      out.print(search);
      out.write("\" style=\"text-decoration: none\">next</a>\n");
      out.write("            ");

                }
                if(Math.ceil(d/6)>page_number)
                {
            
      out.write("\n");
      out.write("            &emsp;\n");
      out.write("            ...\n");
      out.write("            &emsp;\n");
      out.write("            <a href=\"Welcome_servlet?page_number=");
      out.print((int)Math.ceil(d/6));
      out.write("&search=");
      out.print(search);
      out.write("\" style=\"text-decoration: none\">last</a>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("    </center>\n");
      out.write("            </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
