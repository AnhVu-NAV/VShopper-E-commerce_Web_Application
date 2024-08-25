<%-- 
    Document   : Register
    Created on : Aug 19, 2024, 10:05:14 AM
    Author     : AnhVuNAV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Register</title>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/styleLogin.css"/>
    </head>
    <body>
        <div class="container">
            <div class="login-box">
                <div class="login-left">
                    <div class="featured-image">
                        <img src="img/1.png" alt="Be Verified">
                        <!--<a href="Register.jsp"></a>-->
                    </div>
                    <p class="title">Be Verified</p>
                    <p class="subtitle">Join experienced Designers on this platform.</p>
                </div>
                <div class="login-right">

                    <c:if test="${registerSuccess ne null}">
                        <p style="color: green; font-size: 1.5rem; text-align: center">${registerSuccess}</p>
                    </c:if>

                    <h2>Register</h2>
                    <form action="register" method="POST">
                        <div class="input-group">
                            <input type="text" name="username" placeholder="Enter Username" class="input-field" required>
                        </div>

                        <c:if test="${duplicateUsername ne null}">
                            <p style="color: red; font-size: 1.25rem; text-align: center">${duplicateUsername}</p>
                        </c:if>

                        <div class="input-group">
                            <input type="password" name="password" placeholder="Enter Password" class="input-field" required>
                        </div>
                        <div class="input-group">
                            <input type="text" name="fullname" placeholder="Enter Fullname" class="input-field" required>
                        </div>

                        <!-- Nhóm email và phone cùng hàng -->
                        <div class="input-group-horizontal">
                            <input type="email" name="email" placeholder="Enter Email" class="input-field half-width" required>
                            <input type="tel" name="phone" placeholder="Enter Phone" class="input-field half-width" required>
                        </div>

                        <div class="input-group">
                            <input type="text" name="address" placeholder="Enter Address" class="input-field" required>
                        </div>

                        <button type="submit" class="btn-login">Register</button>
                        
                        <!-- Nút Back to Home -->
                        <a href="./customer" class="btn-back-home">Back to Home</a>
                    </form>

                    <p class="signup">You have an account? <a href="login">Login Now</a></p>
                </div>
            </div>
        </div>
    </body>
</html>
