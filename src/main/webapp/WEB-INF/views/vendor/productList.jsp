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
        
        <a class="btn btn-default pull-right" href="vendor/product/form" role="button">Add New Product</a> 
        <h1>Product Management</h1>
        
           
        <table class="table table-striped" style="width:100%" >
            <tr>
                <th>ID</th>
                <th>Category</th>
                <th>Product Name</th>
                <th>Unit</th>
                <th>CP</th>
                <th>SP</th>
                <th>OB</th>
                <th>CB</th>
                <th>Stock Qty</th>
                <th>Status<th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        <c:forEach items="${products}" var="product">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.category.categoryName}</td>
                    <td>${product.productName}</td>
                    <td>${product.unit}</td>
                    <td>${product.costPrice}</td>
                    <td>${product.sellingPrice}</td>
                    <td>${product.openingBalance}</td>
                    <td>${product.currentBalance}</td>
                    <td>${product.openingBalance + product.currentBalance}</td>
                    <td>${product.isAvailable}</td>
                    <td><a href="vendor/product/edit/${product.id}"><img src="resources/images/EditIcon.png"/> </a></td>
                    <td><a href="vendor/product/delete/${product.id}" onclick="return confirm('Are you sure you want to delete?')"><img src="resources/images/DeleteIcon.png"/></a></td>
                </tr>
        </c:forEach>
        </table>
        </br>
           
        </br>
	<!-- Footer Section Starts -->
        <%@include file="../footer.jsp" %>
	<!-- Footer Section Ends -->		
	</div>
<!-- Wrapper Ends -->
<!-- Copyright Area Starts -->
<%@include file="../foot.jsp" %>
</body>

</html>