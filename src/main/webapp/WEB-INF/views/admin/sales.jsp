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
        
           
        <table class="table table-striped" style="width:100%" >
            <tr>
                <th>ID</th>
                <th>Category</th>
                <th>Product Name</th>
                <th>Unit</th>
                <th>Cost Price</th>
                <th>Selling Price</th>
                <th>Old Price</th>
                <th>Stock</th>
                <th>Status</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        <c:forEach items="${orders}" var="items">
                <tr>
                    hello
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