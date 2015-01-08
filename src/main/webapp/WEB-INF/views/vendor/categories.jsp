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


    </head>
    <body>
        <!-- Wrapper Starts -->
        <div id="wrapper" class="container">
            <!-- Header Section Starts -->
            <%@include file="header.jsp" %>
            <!-- Main Menu Ends -->
            <div class="row">
                <div class="col-md-12">
                    
                    <a class="btn btn-default pull-right" href="vendor/category/form" role="button">Add New Category</a>
                    <div class="message">${message}</div>
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
            <!-- Footer Section Ends -->		
        </div>
        <!-- Wrapper Ends -->
        <!-- Copyright Area Starts -->
        <%@include file="../foot.jsp" %>



    </body>

</html>