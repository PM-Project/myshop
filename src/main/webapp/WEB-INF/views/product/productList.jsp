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

	<meta charset="utf-8">
	<!--[if IE]>
		<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
	<![endif]-->
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>My Shop - Product</title>
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
                    <td><a href="product/edit/${product.id}"><img src="resources/images/EditIcon.png"/> </a></td>
                    <td><a href="product/delete/${product.id}" onclick="return confirm('Are you sure you want to delete?')"><img src="resources/images/DeleteIcon.png"/></a></td>
                </tr>
        </c:forEach>
        </table>
        </br>
        <a class="btn btn-default" href="product/form" role="button">Add New Product</a>    
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