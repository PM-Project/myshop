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

            <h1>Customers</h1>

            <table class="table table-striped">
                <tr><th>ID</th><th>Name</th><th>Email</th><th>Phone</th><th>View</th></tr>
                        <c:forEach items="${customers}" var="customer">
                    <tr><td>${customer.id}</td><td>${customer.name}</td><td>${customer.email}</td><td>${customer.phone}</td><td><a href="admin/customer/${vendor.id}">Details</a></td></tr>
                </c:forEach>
            </table>

            <!-- Footer Section Starts -->
            <%@include file="../footer.jsp" %>
            <!-- Footer Section Ends -->		
        </div>
        <!-- Wrapper Ends -->
        <!-- Copyright Area Starts -->
        <%@include file="../foot.jsp" %>
    </body>

</html>