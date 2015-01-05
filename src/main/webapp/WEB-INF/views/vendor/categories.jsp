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
            <div class="row">
                <div class="col-md-12">
                    
                    <a class="btn btn-default pull-right" href="category/form" role="button">Add New Category</a>
                    
                    <h1>Categories Management</h1>
                    <h4>Add/Update </h4>

                    </br>


                    <form:form class="form-horizontal" modelAttribute="vendor" method="post">

                        <form:errors element="div" class="alert alert-error" path="*"/>

                        <div class="selected-category">
                            <label>Select Categories</label>
                            <form:checkboxes path="categories" element="div" cssClass="category" items="${categories}" itemLabel="categoryName" itemValue="id"/>
                        </div>
                        <button type="submit" class="btn btn-default">Save Categories</button>

                    </form:form>
                </div>

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
            var Example = (function () {
                "use strict";

                var elem, hideHandler, that = {};

                that.init = function (options) {
                    elem = $(options.selector);
                };

                that.show = function (text) {
                    clearTimeout(hideHandler);

                    elem.find("span").html(text);
                    elem.delay(200).fadeIn().delay(4000).fadeOut();
                };

                return that;
            }());


            $(function () {
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