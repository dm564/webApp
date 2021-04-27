<%-- 
    Document   : download
    Created on : Nov 10, 2017, 9:11:35 PM
    Author     : DEEPAK
--%>

<%@page import="java.io.FileInputStream"%>
<%@page import="javax.imageio.stream.FileImageInputStream"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>download</title>
    </head>
    <body>
        <%
            String filename=request.getParameter("filename");
            FileInputStream fin=new FileInputStream(application.getRealPath("/") + "images/" + filename);
            int total_length=fin.available();
            byte b[]=new byte[total_length];
            fin.read(b);
            response.setContentType("multipart/form-data");
            response.getHeader("contenet-disposition: attachment; filename="+filename);
            ServletOutputStream ou=response.getOutputStream();
            ou.write(b);
            ou.close();
        %>
    </body>
</html>
