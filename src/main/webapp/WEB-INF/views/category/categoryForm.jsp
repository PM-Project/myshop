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

	<meta charset="utf-8">
	<!--[if IE]>
		<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
	<![endif]-->
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>My Shop - Category Form</title>
	<base href='<c:url value="/"/>' />
        
	<!-- Bootstrap Core CSS -->
	<link href="resources/css/bootstrap.min.css" rel="stylesheet">
	<!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
        
        
	<!-- Google Web Fonts -->
	<link href="http://fonts.googleapis.com/css?family=Roboto+Condensed:300italic,400italic,700italic,400,300,700" rel="stylesheet" type="text/css">
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
	
	<!-- CSS Files -->
	<link href="resources/font-awesome/css/font-awesome.min.css" rel="stylesheet">
	<link href="resources/css/owl.carousel.css" rel="stylesheet">
	<link href="resources/css/style.css" rel="stylesheet">
	<link href="resources/css/responsive.css" rel="stylesheet">
	
	<!--[if lt IE 9]>
		<script src="resources/js/ie8-responsive-file-warning.js"></script>
	<![endif]-->
	
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	
	
</head>
<body>
<!-- Wrapper Starts -->
	<div id="wrapper" class="container">
	<!-- Header Section Starts -->
        <%@include file="../header.jsp" %>
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
        <%@include file="../footer.jsp" %>
	<!-- Footer Section Ends -->		
	</div>
<!-- Wrapper Ends -->
<!-- Copyright Area Starts -->
<%@include file="../foot.jsp" %>
</body>

</html>