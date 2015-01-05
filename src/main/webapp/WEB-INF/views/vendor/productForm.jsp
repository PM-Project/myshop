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

    <%@include file="../head.jsp" %>
    
    <script type="text/css">
           
           #errmsg
            {
            color: red;
            }
        </script>
        
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
        <%@include file="header.jsp" %>
	<!-- Main Menu Ends -->
        
        <h1>Product Management</h1>
        <h4>Add/Update </h4>
        
        </br>
	
    <div class="bs-example">
        <form:form class="form-horizontal" commandName="product" action="product/save" method="post">
            
                <form:errors element="div" class="alert alert-error" path="*"/></br>
            
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
                            
                            <form:options items="${categories}" itemLabel="categoryName" itemValue="id"/>
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