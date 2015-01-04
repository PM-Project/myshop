<%-- 
    Document   : categoryForm
    Created on : Dec 31, 2014, 5:50:21 PM
    Author     : Santosh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        
        <h1>Category Management</h1>
        <h4>Add/Update</h4>
        
        <form:form  method="post" action="category/save" commandName="category">
            <form:errors element="div" cssClass="errors" path="*"/>
            <p>
                <form:input type="hidden" path="id"/>
                <table> 
                    <tr>
                        <td><label>Category ID:</label></td>
                        <td><form:input readonly="true" path="id" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><label>Category Name:</label></td>
                        <td><form:input path="categoryName" name="categoryName" /></td>
                        <td><form:errors path="categoryName" element="div" cssClass="error" /></td>
                    </tr>
                </table>
            </p>
            <p>
                <input type="submit" value="Submit"/>
            </p>
            
        </form:form>
        
         
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