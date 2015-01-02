<%-- 
    Document   : productForm
    Created on : Jan 2, 2015, 2:23:49 AM
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
	
	<title>My Shop - Product Form</title>
	<base href='<c:url value="/"/>' />
        
        <script type="text/css">
           
           #errmsg
            {
            color: red;
            }
        </script>
            
        
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
    <script >
        $(document).ready(function () {
  //called when key is pressed in textbox
  $("#costPrice").keypress(function (e) {
     //if the letter is not digit then display error and don't type anything
     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
        //display error message
        $("#errmsg").html("Digits Only").show().fadeOut("slow");
               return false;
    }
   });
});
    </script>
	
</head>
<body>
<!-- Wrapper Starts -->
	<div id="wrapper" class="container">
	<!-- Header Section Starts -->
        <%@include file="../header.jsp" %>
	<!-- Main Menu Ends -->
        
        <h1>Product Management</h1>
        <h4>Add/Update </h4>
        
        </br>
	
    <div class="bs-example">
        <form:form class="form-horizontal" commandName="product" action="product/save" method="post">
            
            <div class="alert alert-error">
                <form:errors element="div" class="alert alert-error" path="*"/></br>
            </div>
            
            <form:input type="hidden" path="id"/>
            
            <div class="form-group">
                <label for="productName" class="control-label col-xs-2">Product Name</label>
                <div class="col-xs-10">
                    <form:input type="text" path="productName" class="form-control input-sm mrgn-bttm-md" id="productName" placeholder="Product Name" style="width:300px"/>
                    <form:errors path="productName" element="div" cssClass="error" />
                </div>
            </div>
            <div class="form-group">
                <label for="category" class="control-label col-xs-2">Category</label>
                <div class="col-xs-10">
                    <%--<form:input type="text" class="form-control input-sm mrgn-bttm-md" path="category" placeholder="Category" style="width:300px"/>--%>
                
                    <form:select path="category" class="form-control input-sm mrgn-bttm-md" placeholder="Category" style="width:300px">
                        <%--<c:forEach items="${categories}" var="category" varStatus="count">--%> 
                            
                            <form:option value="NONE" label="-----Select-----"/>
                            <form:options items="${categories}" itemLabel="categoryName" itemValue="id"/>
                        <%--</c:forEach>--%>
                    </form:select>   
                    
                    
                    
                
                </div>
            </div>
            
            
            <div class="form-group">
                <label for="unit" class="control-label col-xs-2">Unit</label>
                <div class="col-xs-10">
                    <form:input type="text" class="form-control input-sm mrgn-bttm-md" path="unit" placeholder="Unit" style="width:300px"/>
                </div>
            </div>
            
            <div class="form-group">
                <label for="costPrice" class="control-label col-xs-2">Cost Price</label>
                <div class="col-xs-10">
                    <form:input type="text" id="costPrice" class="form-control input-sm mrgn-bttm-md" path="costPrice" placeholder="Cost Price" style="width:300px"/>
                </div>
            </div>
        
            <div class="form-group">
                <label for="sellingPrice" class="control-label col-xs-2">Selling Price</label>
                <div class="col-xs-10">
                    <form:input type="text" class="form-control input-sm mrgn-bttm-md" path="sellingPrice" placeholder="Selling Price" style="width:300px"/>
                </div>
            </div>
            
            <div class="form-group">
                <label for="openingBalance" class="control-label col-xs-2">Opening Balance</label>
                <div class="col-xs-10">
                    <form:input type="text" class="form-control input-sm mrgn-bttm-md" path="openingBalance" placeholder="Opening Balance" style="width:300px"/>
                </div>
            </div>
            
            <div class="form-group">
                <label for="currentBalance" class="control-label col-xs-2">Current Balance</label>
                <div class="col-xs-10">
                    <form:input type="text" class="form-control input-sm mrgn-bttm-md" path="currentBalance" placeholder="Current Balance" style="width:300px"/>
                </div>
            </div>
        
        
            <div class="form-group">
                <div class="col-xs-offset-2 col-xs-10">
                    <div class="checkbox">
                        <label><form:checkbox path ="isAvailable"/> Product Available</label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-xs-offset-2 col-xs-10">
                    <button type="submit" class="btn btn-default">Save Product</button>
                </div>
            </div>
        </form:form>
    </div>
        
        
        
        
        </br>
        
        
        
        <!-- Footer Section Starts -->
        <%@include file="../footer.jsp" %>
	<!-- Footer Section Ends -->		
	</div>
<!-- Wrapper Ends -->
<!-- Copyright Area Starts -->
<%@include file="../foot.jsp" %>


<!-- JS dependencies -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <!--<script src="resources/js/bootstrap.min.js"></script>-->
    <script>
        var Example = (function() {
        "use strict";

        var elem,hideHandler,that = {};

        that.init = function(options) {elem = $(options.selector); };

        that.show = function(text) {
        clearTimeout(hideHandler);

        elem.find("span").html(text);
        elem.delay(200).fadeIn().delay(4000).fadeOut();
    };

    return that;
}());
        
        
        $(function() {
            Example.init({
                "selector": ".bb-alert"
            });
        });
    </script>

    <!-- bootbox code -->
    <script src="resources/js/bootbox.js"></script>

    <!-- put all demo code in one place -->
    <script src="resources/js/bootboxdemo.js"></script>

</body>

</html>