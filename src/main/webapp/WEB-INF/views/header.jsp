<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<header id="header-area">
    <!-- Nested Row Starts -->
    <div class="row">
        <!-- Logo Starts -->
        <div class="col-md-4 col-xs-12">
            <div id="logo">
                <a href="./" class="logo"></a>
            </div>
        </div>
        <!-- Logo Ends -->
        <!-- Header Right Starts -->
        <div class="col-md-8 col-xs-12">
            <div class="row header-top">
                <!-- Header Links Starts -->
                <div class="col-md-9 col-xs-12">
                    <div class="header-links">
                        <ul class="list-unstyled list-inline pull-left">
                            <li><a href="./">Home</a></li>
                                <sec:authorize access="hasRole('ROLE_VENDOR')">
                                <li><a href="vendor">My Account</a></li>
                                </sec:authorize>
                                <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <li><a href="admin">DASHBOARD</a></li>
                                </sec:authorize>
                                <sec:authorize access="hasRole('ROLE_CUSTOMER')">
                                <li><a href="customer">My Account</a></li>
                                <li><a href="cart/details">Shopping Cart</a></li>
                                <li><a href="checkout">Checkout</a></li>
                                </sec:authorize>





                            <sec:authorize access="isAuthenticated()" var="isLoggedIn">
                                <li><a href="logout">Logout</a></li>
                                </sec:authorize>
                                <c:if test="${! isLoggedIn}">
                                <li><a href="cart/details">Shopping Cart</a></li>
                                <li><a href="checkout">Checkout</a></li>
                                <li><a href="register">Register</a></li>
                                <li><a href="login">Login</a></li>
                                </c:if>    






                        </ul>
                    </div>
                </div>
                <!-- Header Links Ends -->


            </div>
            <div class="row">
                <!-- Search Starts -->					
                <div class="col-md-7 col-xs-12">
                    <div id="search">
                        <div class="input-group">
                            <form method="post" action="search/products">
                                <input type="text" name="query" value="${param.query}" class="form-control input-lg" placeholder="Search">
                                <span class="input-group-btn">
                                    <button class="btn btn-lg" type="submit">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </span>
                            </form>
                        </div>
                    </div>	
                </div>
                <!-- Search Ends -->						
                <!-- Shopping Cart Starts -->					
                <div class="col-md-5 col-xs-12">
                    <div id="cart" class="btn-group btn-block">
                        <c:import url="/cart" />
                    </div>
                </div>
                <!-- Shopping Cart Ends -->						
            </div>
        </div>
        <!-- Header Right Ends -->				
    </div>
    <!-- Nested Row Ends -->
</header>
<!-- Header Section Ends -->
<!-- Main Menu Starts -->
<nav id="main-menu" class="navbar" role="navigation">
    <!-- Nav Header Starts -->
    <div class="navbar-header">
        <button type="button" class="btn btn-navbar navbar-toggle" data-toggle="collapse" data-target=".navbar-cat-collapse">
            <span class="sr-only">Toggle Navigation</span>
            <i class="fa fa-bars"></i>
        </button>
    </div>
    <!-- Nav Header Ends -->
    <!-- Navbar Cat collapse Starts -->
    <div class="collapse navbar-collapse navbar-cat-collapse">
        <ul class="nav navbar-nav">

            <c:import url="/menu" />

        </ul>
    </div>
    <!-- Navbar Cat collapse Ends -->
</nav>
