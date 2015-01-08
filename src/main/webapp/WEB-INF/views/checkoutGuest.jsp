<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">

    <head>

        <%@include file="head.jsp" %>

    </head>
    <body>
        <!-- Wrapper Starts -->
        <div id="wrapper" class="container">

            <%@include file="header.jsp" %>

            <!-- Main Container Starts -->
            <div id="main-container">

                <!-- Main Heading Starts -->
                <h2 class="main-heading text-center">
                    Guest Checkout
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
                                    <h3 class="panel-title">Checkout As Guest</h3>
                                </div>
                                <div class="panel-body">

                                    <form:form role="form" method="post" modelAttribute="customer">

                                        <form:errors element="div" cssClass="errors" path="*"/>

                                        <form:input type="hidden" path="id"/>

                                        <div class="form-group">
                                            <label>Full Name:</label>
                                            <form:input required="required" cssClass="form-control" path="name" />
                                            <form:errors path="name" element="div" cssClass="error" />
                                        </div>
                                        <div class="form-group">
                                            <label>Email:</label>
                                            <form:input required="required" type="email" cssClass="form-control" path="email" />
                                            <form:errors path="email" element="div" cssClass="error" />
                                            <div class="error">${message}</div>
                                        </div>
                                        <div class="form-group">
                                            <label>Phone:</label>
                                            <form:input required="required" cssClass="form-control" path="phone" />
                                            <form:errors path="phone" element="div" cssClass="error" />
                                        </div>
                                        
                                        <h3>Shipping Address:</h3>
                                        <div class="form-group">
                                            <label>Door No. / Building No. P.O.Box No</label>
                                            <form:input required="required" cssClass="form-control" path="address.doorNo" />
                                            <form:errors path="address.doorNo" element="div" cssClass="error" />
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Street:</label>
                                            <form:input required="required" cssClass="form-control" path="address.street" />
                                            <form:errors path="address.street" element="div" cssClass="error" />
                                        </div>
                                        <div class="form-group">
                                            <label>City:</label>
                                            <form:input required="required" cssClass="form-control" path="address.city" />
                                            <form:errors path="address.city" element="div" cssClass="error" />
                                        </div>
                                        <div class="form-group">
                                            <label>State:</label>
                                            <form:input required="required" cssClass="form-control" path="address.stateName" />
                                            <form:errors path="address.stateName" element="div" cssClass="error" />
                                        </div>
                                        <div class="form-group">
                                            <label>Zip Code:</label>
                                            <form:input required="required" cssClass="form-control" path="address.zipCode" />
                                            <form:errors path="address.zipCode" element="div" cssClass="error" />
                                        </div>
                                        
                                        <h3>Payment Information:</h3>
                                        <div class="form-group">
                                            <label>Name on Card:</label>
                                            <form:input required="required" cssClass="form-control" path="account.accountName" />
                                            <form:errors path="account.accountName" element="div" cssClass="error" />
                                        </div>
                                        <div class="form-group">
                                            <label>Card Number:</label>
                                            <form:input required="required" cssClass="form-control" path="account.accountNumber" />
                                            <form:errors path="account.accountNumber" element="div" cssClass="error" />
                                        </div>
                                        <div class="form-group">
                                            <label>CVV:</label>
                                            <form:input required="required" cssClass="form-control" path="account.cardCvv" />
                                            <form:errors path="account.cardCvv" element="div" cssClass="error" />
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
            <%@include file="footer.jsp" %>
            <!-- Footer Section Ends -->		
        </div>
        <!-- Wrapper Ends -->
        <!-- Copyright Area Starts -->
        <%@include file="foot.jsp" %>

    </body>

</html>