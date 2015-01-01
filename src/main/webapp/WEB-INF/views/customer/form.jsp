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
	
	<!-- Header Section Starts -->
        <%@include file="../header.jsp" %>
	<!-- Main Menu Ends -->
        
            <h1>Customer Registration Form</h1>
        <form:form method="POST" action="customer/save" commandName="customer">
            <form:errors element="div" cssClass="errors" path="*"/>
            <p>
                 <form:input type="hidden" path="id"/>
            <table> 
            <tr>
            <td><label>Customer Name:</label></td>
            <td><form:input path="customerName" /></td>
            <td><form:errors path="customerName" element="div" cssClass="error" /></td>
            </tr>
            <tr>
                <td> <label> email:</label></td>
                <td><form:input path="customerEmail" /></td>
                <td><form:errors path="customerEmail" element="div" cssClass="error"/></td>   
            </tr>
            <tr>
                <td> <label> contact Number:</label></td>
                <td><form:input path="customerContact" /></td>
                <td><form:errors path="customerContact" element="div" cssClass="error"/></td>   
            </tr>
            <tr>
                <td> <label> Date:</label></td>
                <td><form:input path="creationDate" /></td>
                <td><form:errors path="creationDate" element="div" cssClass="error"/></td>   
            </tr>
            
            
            
            <tr>
                <td> <label> Credit Card Number:</label></td>
                <td><form:input path="customerCreditCardNumber" /></td>
                <td><form:errors path="customerCreditCardNumber" element="div" cssClass="error"/></td>   
            </tr>
            
            <tr>
                <td> <label> Expiration Date:</label></td>
                <td><form:input path="expirationDate" /></td>
                <td><form:errors path="expirationDate" element="div" cssClass="error"/></td> 
                
            </tr>
            <tr>
                <td> <label> CVV2:</label></td>
                <td><form:input path="cvv2" /></td>
                <td><form:errors path="cvv2" element="div" cssClass="error"/></td>   
            </tr>
            <tr>
                <td> <label> Card Holder's Name:</label></td>
                <td><form:input path="cardHolderName" /></td>
                <td><form:errors path="cardHolderName" element="div" cssClass="error"/></td>   
            </tr>
            
            <tr>
                <td> <label> Address:</label></td>
                <td><form:input path="address1" /></td>
                <td><form:errors path="address1" element="div" cssClass="error"/></td>   
            </tr>
            <tr>
                <td> <label> Address2:</label></td>
                <td><form:input path="address2" /></td>
                <td><form:errors path="address2" element="div" cssClass="error"/></td>   
            </tr>
            <tr>
                <td> <label> City:</label></td>
                <td><form:input path="city" /></td>
                <td><form:errors path="city" element="div" cssClass="error"/></td>   
            </tr>
            <tr>
                <td> <label> State:</label></td>
                <td><form:input path="state" /></td>
                <td><form:errors path="state" element="div" cssClass="error"/></td>   
            </tr>
            <tr>
                <td> <label> Zip Code:</label></td>
                <td><form:input path="zipcode" /></td>
                <td><form:errors path="zipcode" element="div" cssClass="error"/></td>   
            </tr>
            </table>
            <input type="submit" value="Submit"/>
            
        </form:form>
    
    <%@include file="../footer.jsp" %>
	<!-- Footer Section Ends -->		
	
<!-- Wrapper Ends -->
<!-- Copyright Area Starts -->
<%@include file="../foot.jsp" %>
</body>
</html>
