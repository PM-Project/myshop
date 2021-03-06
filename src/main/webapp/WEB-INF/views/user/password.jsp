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
                                    <h3 class="panel-title">Create New Password</h3>
                                </div>
                                <div class="panel-body">
                                    
                                    <form:form method="post" modelAttribute="user" action="password">
                                        <form:errors path="*"/>
                                        <div class="form-group">
                                            <label>New Password</label>
                                            <form:input type="password"  path="password" class="form-control" />
                                            
                                        </div>
                                        <div class="form-group">
                                            <label>Password</label>
                                            <form:input type="password" path="verification" class="form-control"  />
                                        </div>
                                        <input type="submit" value="Submit" />
                                        
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