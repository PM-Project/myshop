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

            <h1>Vendors</h1>

            <table class="table table-striped">
                <tr><th>ID</th><th>Name</th><th>Brand</th><th>View</th></tr>
                        <c:forEach items="${vendors}" var="vendor">
                    <tr><td>${vendor.id}</td><td>${vendor.company}</td><td>${vendor.brand}</td><td><a href="admin/vendor/${vendor.id}">Details</a></td></tr>
                </c:forEach>
            </table>

            <!-- Footer Section Starts -->
            <!-- Footer Section Ends -->		
        </div>
        <!-- Wrapper Ends -->
        <!-- Copyright Area Starts -->
        <%@include file="../foot.jsp" %>
    </body>

</html>