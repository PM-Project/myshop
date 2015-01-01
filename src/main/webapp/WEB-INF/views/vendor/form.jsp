<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags/form" %>
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
	
	<title>Grocery Shoppe Stores - Bootstrap 3 Template</title>
	<base href='<c:url value="/"/>' />
        
	<!-- Bootstrap Core CSS -->
	<link href="resources/css/bootstrap.min.css" rel="stylesheet">
	
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

        <h1>Vendor Page</h1>
        
        <spring:form method="post" action="vendor/save" commandName="vendor">
            <spring:errors element="div" cssClass="errors" path="*"/>
            <p>
            <spring:input type="hidden" path="id"/>
            <table> 
            <tr>
            <td><label>Vendor Name:</label></td>
            <td><spring:input path="vendorName" /></td>
            <td><spring:errors path="vendorName" element="div" cssClass="error" /></td>
            </tr>
            <tr>
               
            <td><label>Street:</label></td>
            <td><spring:input path="street" /></td>
            <td><spring:errors path="street" element="div" cssClass="error" /></td>
            </tr>
             <td><label>City:</label></td>
            <td><spring:input path="city" /></td>
            <td><spring:errors path="city" element="div" cssClass="error" /></td>
            </tr>
             <td><label>State:</label></td>
            <td><spring:input path="state" /></td>
            <td><spring:errors path="state" element="div" cssClass="error" /></td>
            </tr>
            <td><label>zip-code:</label></td>
            <td><spring:input path="zipcode" /></td>
            <td><spring:errors path="zipcode" element="div" cssClass="error" /></td>
            </tr>
            
            <tr>
            <td><label>Join Date:</label></td>
            <td><spring:input path="joinDate" /></td>
            <td><spring:errors path="joinDate" element="div" cssClass="error" /></td>
            </tr>           
             <tr>
            <td><label>Email:</label></td>
            <td><spring:input path="email" /></td>
            <td><spring:errors path="email" element="div" cssClass="error" /></td>
            </tr>
            <tr>
            <td><label>Phone:</label></td>
            <td><spring:input path="phone" /></td>
            <td><spring:errors path="phone" element="div" cssClass="error" /></td>
            </tr>
            </table>
            </p>
            <p>
                <input type="submit" value="Submit"/>
            </p>
            
        </spring:form>
        
         <%@include file="../footer.jsp" %>
	<!-- Footer Section Ends -->		
	</div>
<!-- Wrapper Ends -->
<!-- Copyright Area Starts -->
<%@include file="../foot.jsp" %>
    </body>
</html>
