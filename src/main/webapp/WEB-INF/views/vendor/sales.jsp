<%-- 
    Document   : productList
    Created on : Jan 2, 2015, 1:57:47 AM
    Author     : Santosh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <%@include file="../head.jsp" %>
    </head>
    <body>
        <!-- Wrapper Starts -->
        <div id="wrapper" class="container">
            <!-- Header Section Starts -->
            <%@include file="header.jsp" %>
            <!-- Main Menu Ends -->
            <div class="message">${message}</div>
            <h1>Sales Report</h1>

            <a href="vendor/download/pdf" >Pdf</a>
            <a href="vendor/download/xls" >Xls</a>
            <a href="vendor/download/ht" >Html</a>
            <table class="table table-striped" style="width:100%" >
                <tr>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Quantity</th>
                    <th>Sold Rate</th>
                    <th>Amount</th>

                </tr>

                <c:forEach items="${orderItems}" var="item">
                    <tr>
                        <td>${item.product.id}</td>
                        <td>${item.product.productName}</td>
                        <td>${item.quantity}</td>
                        <td>${item.rate}</td>
                        <td>${item.amount}</td>

                    </tr>
                </c:forEach>
            </table>
            </br>

            </br>
            <!-- Footer Section Starts -->
            <!-- Footer Section Ends -->		
        </div>
        <!-- Wrapper Ends -->
        <!-- Copyright Area Starts -->
        <%@include file="../foot.jsp" %>
    </body>

</html>