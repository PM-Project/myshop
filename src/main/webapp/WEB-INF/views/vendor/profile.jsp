<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">

    <head>

        <%@include file="../head.jsp" %>

    </head>
    <body>
        <!-- Wrapper Starts -->
        <div id="wrapper" class="container">

            <%@include file="header.jsp" %>

            <!-- Main Container Starts -->
            <div id="main-container">

                <!-- Main Heading Starts -->
                
                <!-- Main Heading Ends -->
                <!-- Login Form Section Starts -->
                <section class="login-area">
                    <div class="row">
                        
                        <div class="col-sm-12">
                            <!-- Login Panel Starts -->
                            <div class="panel panel-smart">
                                <div class="panel-heading">
                                    <h3 class="panel-title">${user.vendor.company}</h3>
                                </div>
                                <div class="panel-body">
                                    <p><strong>Company Name :</strong> ${user.vendor.company}</p>
                                    <p><strong>Brand Name :</strong> ${user.vendor.brand}</p>
                                    <h3>Contact:</h3>
                                    <p><strong>Email :</strong> ${user.vendor.email}</p>
                                    <p><strong>Phone :</strong> ${user.vendor.phone}</p>
                                    <h3>Address Info:</h3>
                                    <p><strong>Door No :</strong> ${user.vendor.address.doorNo}</p>
                                    <p><strong>Street :</strong> ${user.vendor.address.street}</p>
                                    <p><strong>City :</strong> ${user.vendor.address.city}</p>
                                    <p><strong>Zip Code :</strong> ${user.vendor.address.zipCode}</p>
                                    <p><strong>State :</strong> ${user.vendor.address.stateName}</p>

                                    
                                </div>
                            </div>
                            <!-- Login Panel Ends -->
                        </div>
                        
                        
                        
                    </div>
                </section>
                <!-- Login Form Section Ends -->
            </div>
            <!-- Main Container Ends -->
            <!-- Footer Section Starts -->
            <!-- Footer Section Ends -->		
        </div>
        <!-- Wrapper Ends -->
        <!-- Copyright Area Starts -->
        <%@include file="../foot.jsp" %>

    </body>

</html>