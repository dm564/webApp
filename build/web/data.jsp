<%@page import="java.io.File"%>
<%
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
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Wallpapers</title>
    </head>
    <body>
        <br>
        <div style='width:73%;height:470px;background-color: antiquewhite;float:right;'>
            <form action="Welcome_servlet">
                <tr>
                   <td><input type='text' name="search" placeholder='What are you looking for?'style='width:250px;height:30px;margin-top: 20px;margin-left: 90px;' </td>
                   <td><input type='submit' value='Search' style='width:80px;height:30px'</td>
                   <td><input type=hidden name='page_number' value='1' ></td>
                </tr> 
            </form>        
            <br>
    <center>
        <form>
            <table>
                <%
                    for(int i=0;i<2;++i)
                    {
                        
                %>
                <tr>
                <%
                    for(int j=0;j<3;++j)
                    {
                         if(image_counter<total_no_of_files)
                            {
                        
                %>     
                <td>
                    <a href="http://localhost:8080/WebApplication1/download.jsp?filename=<%=filename[image_counter]%>">
                    <img style="border:1px solid gray;margin-left: 40px;margin-bottom: 20px;" src="images/<%=filename[image_counter]%>" height="150" width="250"/>
                    </a>
                </td>
                    <%
                        ++image_counter;
                        }
                           else
                            break;
                        }
                    %>
                    </tr>
                <%
                    
                    }
                    ++page_number;
                %>
            </table>
        </form>
            &emsp;&emsp;
            <%
                if(page_number>=3)
                {
            %>
            <a href="Welcome_servlet?page_number=1&search=<%=search%>" style="text-decoration: none">first</a>
            
            &emsp;
            ...
            &emsp;
            <%
                }
            %>
            <%
                if(page_number>=3)
                {
            %>
            <a href="Welcome_servlet?page_number=<%=page_number-2%>&search=<%=search%>" style="text-decoration: none">prev</a>
            <%
                }
            %>
            &emsp;
            <%=page_number-1%>
            &emsp;
           <%
              
               double d=(double)total_no_of_files;
               if(Math.ceil(d/6)>=page_number)
               {
           %>
            <a href="Welcome_servlet?page_number=<%=page_number%>&search=<%=search%>" style="text-decoration: none">next</a>
            <%
                }
                if(Math.ceil(d/6)>page_number)
                {
            %>
            &emsp;
            ...
            &emsp;
            <a href="Welcome_servlet?page_number=<%=(int)Math.ceil(d/6)%>&search=<%=search%>" style="text-decoration: none">last</a>
            <%
                }
            %>
    </center>
            </div>
    </body>
</html>
