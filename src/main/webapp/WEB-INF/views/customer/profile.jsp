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

            <%@include file="../header.jsp" %>

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
                                <p>
                                        ${message}
                                    </p>
                                <div class="panel-heading">
                                    <a class="btn btn-default pull-right" href="customer/profile">Edit Profile</a>
                                    <h3 class="panel-title">Customer Profile</h3>
                                </div>
                                <div class="panel-body">
                                    
                                    <p><strong>Customer Name :</strong> ${user.customer.name}</p>
                                    <p><strong>Email :</strong> ${user.customer.email}</p>
                                    <p><strong>Phone :</strong> ${user.customer.phone}</p>
                                    <h3>Address Info:</h3>
                                    <p><strong>Door No :</strong> ${user.customer.address.doorNo}</p>
                                    <p><strong>Street :</strong> ${user.customer.address.street}</p>
                                    <p><strong>City :</strong> ${user.customer.address.city}</p>
                                    <p><strong>Zip Code :</strong> ${user.customer.address.zipCode}</p>
                                    <p><strong>State :</strong> ${user.customer.address.stateName}</p>
                                    
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
            <%@include file="../footer.jsp" %>
            <!-- Footer Section Ends -->		
        </div>
        <!-- Wrapper Ends -->
        <!-- Copyright Area Starts -->
        <%@include file="../foot.jsp" %>

    </body>

</html>