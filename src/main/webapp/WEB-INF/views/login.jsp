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
                <h2 class="main-heading text-center">
                    Login to Your Account
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
                                    <h3 class="panel-title">Login</h3>
                                </div>
                                <div class="panel-body">
                                    <p>
                                        Please login using your existing account
                                    </p>
                                    <c:if test="${param.error != null}">
                                        <p></p><p class="error">Authentication Failure. Please Try again</p>
                                    </c:if>
                                    <c:if test="${param.logout != null}">
                                        <p></p><p class="error">Good Bye ! user logged out successfully.</p>
                                    </c:if>

                                    <!-- Login Form Starts -->
                                    <form class="form-inline" role="form" method="post" action='<c:url value="/j_spring_security_check" />'>
                                        <div class="form-group">
                                            <label class="sr-only" for="exampleInputEmail2">Username</label>
                                            <input type="text" name="username" class="form-control" id="exampleInputEmail2" placeholder="Username">
                                        </div>
                                        <div class="form-group">
                                            <label class="sr-only" for="exampleInputPassword2">Password</label>
                                            <input type="password" name="password" class="form-control" id="exampleInputPassword2" placeholder="Password">
                                        </div>
                                        <button type="submit" class="btn btn-danger">
                                            Login
                                        </button>
                                    </form>
                                    <!-- Login Form Ends -->
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