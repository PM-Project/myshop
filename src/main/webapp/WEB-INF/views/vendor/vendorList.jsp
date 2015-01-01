<%-- 
    Document   : list
    Created on : Dec 30, 2014, 12:03:02 AM
    Author     : Jagendra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Vendor</title>
        <base href="<c:url value="/"/>"/>
    </head>
    <body>
        <h1>Vendors!</h1>
        
        <table id="tablelist">
            <tr><th>ID</th><th>Name</th><th>Email</th><th>Edit</th><th>Delete</th></tr>
        <c:forEach items="${vendors}" var="vendor">
                <tr><td>${vendor.id}</td><td>${vendor.vendorName}</td><td>${vendor.email}</td><td><a href="vendor/edit/${vendor.id}">Edit</a></td><td><a href="vendor/delete/${vendor.id}">Delete</a></td></tr>
        </c:forEach>
        </table>
        
        <a href="vendor/form">Add New Vendor</a>
    </body>
</html>


