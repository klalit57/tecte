<%@page import="com.tech.blog.entities.User" %>

<%@page errorPage="error_page.jsp" %>
<%
    User user = (User) session.getAttribute("currentUser");
    if (user == null) {
        response.sendRedirect("Register_page.jsp");
    }
%>


<%
  int postId=Integer.parseInt(request.getParameter("post_id"));  
    
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- css bootstrap-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <!-- css sheet-->
        <link href="css/mystyle.css" rel="stylesheet" type="text/css"/>
        <!-- font awesome 4 css-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <style>
            .banner-background{
                clip-path:polygon(30% 0%, 70% 0%, 100% 0, 99% 79%, 70% 100%, 28% 79%, 0 100%, 0 0);
            }
        </style>
    </head>
    <body>
        <h1>post id : <%= postId%></h1>
    </body>
</html>
