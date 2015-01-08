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
        
        <form:form class="form-horizontal" method="post" action="category/save" commandName="category">
            <form:errors element="div" cssClass="errors" path="*"/>
            
                <form:input type="hidden" path="id"/>
<!--                <table> 
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
                </table>-->
            <div class="form-group">
                
                <label for="categoryName" class="control-label col-xs-2">Category Name</label>
                <div class="col-xs-10">
                    <form:input type="text" path="categoryName" class="form-control input-sm mrgn-bttm-md" id="categoryName" placeholder="Category Name" style="width:300px"/>
                    <form:errors path="categoryName" element="div" cssClass="error" />
                </div>
            </div>

            <div class="form-group">
                <div class="col-xs-offset-2 col-xs-10">
                    <button type="submit" class="btn btn-default">Save Category</button>
                </div>
            </div>         
            
          
            
        </form:form>
        
         
        </br>
	<!-- Footer Section Starts -->
	<!-- Footer Section Ends -->		
	</div>
<!-- Wrapper Ends -->
<!-- Copyright Area Starts -->
<%@include file="../foot.jsp" %>
</body>

</html>
