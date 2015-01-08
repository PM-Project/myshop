<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                                    <h3 class="panel-title">Login Required</h3>
                                </div>
                                <div class="panel-body">
                                    <h4>
                                        Account Information required to check out your cart.
                                    </h4>
                                    <p>
                                        <a class="btn btn-danger" href="checkout/confirm">Login with you Customer Account</a> 
                                        <a class="btn btn-danger" href="checkout/guest">Checkout as Guest</a>
                                    </p>

                                    
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