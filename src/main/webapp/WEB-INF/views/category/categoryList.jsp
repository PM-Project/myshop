<%-- 
    Document   : category
    Created on : Dec 30, 2014, 10:55:21 PM
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
        <%@include file="../admin/header.jsp" %>
	<!-- Main Menu Ends -->
        
        <a class="btn btn-default pull-right" href="category/form" role="button">Add New Category</a>
        <h1>Category Management</h1>
        
           
        <table class="table table-striped"  >
            <thead>
            <tr>
                <th>ID</th>
                <th>Category Name</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            
            <tbody>
        <c:forEach items="${categories}" var="category">
                <tr>
                    <td>${category.id}</td>
                    <td>${category.categoryName}</td>
                    <td><a href="category/edit/${category.id}"><img src="resources/images/EditIcon.png"/> </a></td>
                    <td><a href="category/delete/${category.id}" onclick="return confirm('Are you sure you want to delete?')"><img src="resources/images/DeleteIcon.png"/></a></td>
                </tr>
        </c:forEach>
            </tbody>
        </table>
        
        
	<!-- Footer Section Starts -->
	<!-- Footer Section Ends -->		
	</div>
<!-- Wrapper Ends -->
<!-- Copyright Area Starts -->
<%@include file="../foot.jsp" %>
</body>

</html>