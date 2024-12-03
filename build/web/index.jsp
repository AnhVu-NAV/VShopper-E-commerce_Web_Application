<%-- 
    Document   : index
    Created on : Aug 19, 2024, 10:05:14 AM
    Author     : AnhVuNAV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VShopper</title>
    </head>
    <body>
        <!-- Header -->
        <%@include file="Panner.jsp" %>

        <!-- Body -->
        <div class="container-fluid pt-5" id="product">
            <div class="row px-xl-5"> 
                <%@include file="Menu.jsp" %>
                <%@include file="Content.jsp" %>
            </div>
        </div>

        <!-- Footer -->
        <%@include file="Footer.jsp" %>
    </body>
</html>
