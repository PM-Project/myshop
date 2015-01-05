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
                            <li><a href="admin">Home</a></li>
                            <li><a href="logout">Logout</a></li>
                                
                            
                            
                        </ul>
                    </div>
                </div>
                <!-- Header Links Ends -->

                
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
    <!-- Navbar Cat collapse Starts -->
    <div class="collapse navbar-collapse navbar-cat-collapse">
        <ul class="nav navbar-nav">
            <li><a href="admin/vendor/list">Vendors</a></li>
            <li><a href="admin/customer/list">Customers</a></li>
            <li><a href="admin/categories">Categories</a></li>
            <li><a href="admin/sales">Sales</a></li>
            
        </ul>
    </div>
    <!-- Navbar Cat collapse Ends -->
    <!-- Navbar Cat collapse Ends -->
</nav>
