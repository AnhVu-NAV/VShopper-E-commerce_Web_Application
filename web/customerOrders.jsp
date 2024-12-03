<%-- 
    Document   : customerOrders
    Created on : Aug 19, 2024, 10:05:14 AM
    Author     : AnhVuNAV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>My Orders</title>
         <link href="css/style.css" rel="stylesheet"/>
    </head>
    <body>
        <%@include file="Panner.jsp" %>

        <div class="container mt-5">
            <h2 class="text-center">My Orders</h2>
            <c:choose>
        <c:when test="${not empty orders}">
            <div class="col-lg-12 table-responsive mb-5">
                <table class="table table-bordered text-center mb-0">
                    <thead class="bg-secondary text-dark">
                        <tr>
                            <th>Order ID</th>
                            <th>Created Date</th>
                            <th>Status</th>
                            <th colspan="2" >Action</th>
                        </tr>   
                    </thead>
                    <tbody>
                        <c:forEach var="order" items="${orders}">
                            <tr>
                                <td>${order.id}</td>
                                <td>${order.created_date}</td>
                                <td>${order.status}</td>
                                <td>
                                    <a href="orderDetail?orderId=${order.id}">View Details</a>
                                </td>
                                <td><a href="cancelOrder?orderId=${order.id}" class="btn btn-sm btn-danger" onclick="return confirm('Are you sure you want to cancel this order?');">Cancel Order</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:when>
        <c:otherwise>
            <p class="alert alert-info">You have no orders yet.</p>
        </c:otherwise>
    </c:choose>
    <div class="text-center">
        <a href="customer"><button class="btn btn-success">Back to Home</button></a>
    </div>
        </div>

        <%@include file="Footer.jsp" %>
    </body>
</html>
