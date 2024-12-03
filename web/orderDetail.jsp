<%-- 
    Document   : orderDetail
    Created on : Aug 19, 2024, 10:33:11 AM
    Author     : AnhVuNAV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Order Details</title>
        <link href="css/style.css" rel="stylesheet"/>
    </head>
    <body>
        <%@include file="Panner.jsp" %>

        <div class="container mt-5">
            <h1 class="text-center mb-4">Order Details</h1>

            <c:choose>
                <c:when test="${not empty orderDetails}">
                    <!-- Order Summary -->
                    <div class="mb-4">
                        <h4>Order ID: ${order.id}</h4>
                        <p>Order Date: ${order.created_date}</p>
                        <p>User: ${order.user.fullname} (${order.user.email})</p>
                    </div>

                    <!-- Order Details Table -->
                    <div class="col-lg-12 table-responsive mb-5">
                        <table class="table table-bordered text-center mb-0">
                            <thead class="bg-secondary text-dark">
                                <tr>
                                    <th>Product</th>
                                    <th>Image</th>
                                    <th>Quantity</th>
                                    <th>Price</th>
                                    <th>Subtotal</th>
                                </tr>
                            </thead>
                            <tbody class="align-middle">
                                <c:forEach items="${orderDetails}" var="detail">
                                    <tr>
                                        <td class="align-middle">${detail.product.name}</td>
                                        <td class="align-middle">
                                            <img src="${detail.product.image_url}" alt="${detail.product.name}" style="width: 100px;">
                                        </td>
                                        <td class="align-middle">${detail.product_quantity}</td>
                                        <td class="align-middle">${detail.price}</td>
                                        <td class="align-middle">${detail.price * detail.product_quantity}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </c:when>
                <c:otherwise>
                    <p class="alert alert-info">No order details found.</p>
                </c:otherwise>
            </c:choose>

            <!-- Back Button -->
            <div class="text-center mt-4">
                <a href="customerOrders"><button class="btn btn-success">Back to My Orders</button></a>
            </div>
        </div>

        <%@include file="Footer.jsp" %>
    </body>
</html>
