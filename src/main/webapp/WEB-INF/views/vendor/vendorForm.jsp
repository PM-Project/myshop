<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">

    <head>

        <%@include file="../head.jsp" %>

    </head>
    <body>
        <!-- Wrapper Starts -->
        <div id="wrapper" class="container">

            <%@include file="../header.jsp" %>

            <!-- Main Container Starts -->
            <div id="main-container">

                <!-- Main Heading Starts -->
                <h2 class="main-heading text-center">
                    Register to Start Selling your Products
                </h2>
                <!-- Main Heading Ends -->
                <!-- Login Form Section Starts -->
                <section class="login-area">
                    <div class="row">
                        <div class="col-sm-3">
                            
                        </div>
                        <div class="col-sm-6">
                            <!-- Login Panel Starts -->
                            <div class="panel panel-smart">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Vender Registration</h3>
                                </div>
                                <div class="panel-body">

                                    <form:form role="form" method="post" commandName="vendor">

                                        <form:errors element="div" cssClass="errors" path="*"/>

                                        <form:input type="hidden" path="id"/>

                                        <div class="form-group">
                                            <label>Company Name:</label>
                                            <form:input cssClass="form-control" path="company" />
                                            <form:errors path="company" element="div" cssClass="error" />
                                        </div>
                                        <div class="form-group">
                                            <label>Brand Name:</label>
                                            <form:input cssClass="form-control" path="brand" />
                                            <form:errors path="brand" element="div" cssClass="error" />
                                        </div>
                                        <h3>Address:</h3>
                                        <div class="form-group">
                                            <label>Street:</label>
                                            <form:input cssClass="form-control" path="address.street" />
                                            <form:errors path="address.street" element="div" cssClass="error" />
                                        </div>
                                        <div class="form-group">
                                            <label>City:</label>
                                            <form:input cssClass="form-control" path="address.city" />
                                            <form:errors path="address.city" element="div" cssClass="error" />
                                        </div>
                                        <div class="form-group">
                                            <label>State:</label>
                                            <form:input cssClass="form-control" path="address.stateName" />
                                            <form:errors path="address.stateName" element="div" cssClass="error" />
                                        </div>
                                        <div class="form-group">
                                            <label>Zip Code:</label>
                                            <form:input cssClass="form-control" path="address.zipCode" />
                                            <form:errors path="address.zipCode" element="div" cssClass="error" />
                                        </div>

                                        <h3>Contact:</h3>          
                                        <div class="form-group">
                                            <label>Email:</label>
                                            <form:input cssClass="form-control" path="email" />
                                            <form:errors path="email" element="div" cssClass="error" />
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Phone:</label>
                                            <form:input cssClass="form-control" path="phone" />
                                            <form:errors path="phone" element="div" cssClass="error" />
                                        </div>

                                        <div class="form-group">
                                            <input class="btn btn-primary" type="submit" value="Submit"/>
                                        </div>

                                    </form:form>
                                </div>
                            </div>
                            <!-- Login Panel Ends -->
                        </div>
                        <div class="col-sm-3">
                            
                        </div>

                    </div>
                </section>
                <!-- Login Form Section Ends -->
            </div>
            <!-- Main Container Ends -->
            <!-- Footer Section Starts -->
            <%@include file="../footer.jsp" %>
            <!-- Footer Section Ends -->		
        </div>
        <!-- Wrapper Ends -->
        <!-- Copyright Area Starts -->
        <%@include file="../foot.jsp" %>

    </body>

</html>