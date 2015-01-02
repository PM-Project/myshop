<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                            <li><a href="#">My Account</a></li>
                            <li><a href="cart.html">Shopping Cart</a></li>
                            <li><a href="#">Checkout</a></li>
                            <li><a href="register">Register</a></li>
                            <li><a href="login">Login</a></li>
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
                            <input type="text" class="form-control input-lg" placeholder="Search">
                            <span class="input-group-btn">
                                <button class="btn btn-lg" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                        </div>
                    </div>	
                </div>
                <!-- Search Ends -->						
                <!-- Shopping Cart Starts -->					
                <div class="col-md-5 col-xs-12">
                    <div id="cart" class="btn-group btn-block">
                        <button type="button" data-toggle="dropdown" class="btn btn-block btn-lg dropdown-toggle">
                            <i class="fa fa-shopping-cart"></i>
                            <span class="hidden-xs">Cart:</span> 
                            <span id="cart-total">2 item(s) - $340.00</span>
                            <i class="fa fa-caret-down"></i>
                        </button>
                        <ul class="dropdown-menu pull-right">
                            <li>
                                <table class="table hcart">
                                    <tr>
                                        <td class="text-center">
                                            <a href="product.html">
                                                <img src="resources/images/product-images/hcart-thumb1.jpg" alt="image" title="image" class="img-thumbnail img-responsive" />
                                            </a>
                                        </td>
                                        <td class="text-left">
                                            <a href="product-full.html">
                                                Seeds
                                            </a>
                                        </td>
                                        <td class="text-right">x 1</td>
                                        <td class="text-right">$120.68</td>
                                        <td class="text-center">
                                            <a href="#">
                                                <i class="fa fa-times"></i>
                                            </a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="text-center">
                                            <a href="product.html">
                                                <img src="resources/images/product-images/hcart-thumb2.jpg" alt="image" title="image" class="img-thumbnail img-responsive" />
                                            </a>
                                        </td>
                                        <td class="text-left">
                                            <a href="product-full.html">
                                                Organic
                                            </a>
                                        </td>
                                        <td class="text-right">x 2</td>
                                        <td class="text-right">$240.00</td>
                                        <td class="text-center">
                                            <a href="#">
                                                <i class="fa fa-times"></i>
                                            </a>
                                        </td>
                                    </tr>
                                </table>
                            </li>
                            <li>
                                <table class="table table-bordered total">
                                    <tbody>
                                        <tr>
                                            <td class="text-right"><strong>Sub-Total</strong></td>
                                            <td class="text-left">$1,101.00</td>
                                        </tr>
                                        <tr>
                                            <td class="text-right"><strong>Eco Tax (-2.00)</strong></td>
                                            <td class="text-left">$4.00</td>
                                        </tr>
                                        <tr>
                                            <td class="text-right"><strong>VAT (17.5%)</strong></td>
                                            <td class="text-left">$192.68</td>
                                        </tr>
                                        <tr>
                                            <td class="text-right"><strong>Total</strong></td>
                                            <td class="text-left">$1,297.68</td>
                                        </tr>
                                    </tbody>
                                </table>
                                <p class="text-right btn-block1">
                                    <a href="cart.html">
                                        View Cart
                                    </a>
                                    <a href="#">
                                        Checkout
                                    </a>
                                </p>
                            </li>									
                        </ul>
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
            <li><a href="category-list.html">Asian Food</a></li>
            <li class="dropdown">
                <a href="category-list.html" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="10">
                    Bread &amp; Bakery
                </a>
                <ul class="dropdown-menu" role="menu">
                    <li><a tabindex="-1" href="#">Brown Bread</a></li>
                    <li><a tabindex="-1" href="#">Milk Break</a></li>
                    <li><a tabindex="-1" href="#">Spl Bread</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="category-list.html" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="10">Drinks</a>
                <div class="dropdown-menu">
                    <div class="dropdown-inner">
                        <ul class="list-unstyled">
                            <li class="dropdown-header">Sub Category</li>
                            <li><a tabindex="-1" href="#">item 1</a></li>
                            <li><a tabindex="-1" href="#">item 2</a></li>
                            <li><a tabindex="-1" href="#">item 3</a></li>
                        </ul>										
                        <ul class="list-unstyled">
                            <li class="dropdown-header">Sub Category</li>
                            <li><a tabindex="-1" href="#">item 1</a></li>
                            <li><a tabindex="-1" href="#">item 2</a></li>
                            <li><a tabindex="-1" href="#">item 3</a></li>
                        </ul>
                        <ul class="list-unstyled">
                            <li class="dropdown-header">Sub Category</li>
                            <li><a tabindex="-1" href="#">item 1</a></li>
                            <li><a tabindex="-1" href="#">item 2</a></li>
                            <li><a tabindex="-1" href="#">item 3</a></li>
                        </ul>
                    </div>
                </div>
            </li>
            <li><a href="category-list.html">Fresh Meats</a></li>
            <li><a href="category-list.html">Fresh Fish</a></li>
            <li><a href="/myshop/category/list">Category</a></li>
            <li><a href="category-list.html">Vegetables</a></li>
            <li class="dropdown">
                <a href="category-list.html" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="10">
                    Pages
                </a>
                <ul class="dropdown-menu" role="menu">
                    <li><a tabindex="-1" href="index-2.html">Home</a></li>
                    <li><a tabindex="-1" href="about.html">About</a></li>
                    <li><a tabindex="-1" href="/myshop/category/list">Category List</a></li>
                    <li><a tabindex="-1" href="category-grid.html">Category Grid</a></li>
                    <li><a tabindex="-1" href="/myshop/product/list">Product</a></li>
                    <li><a tabindex="-1" href="product-full.html">Product Full Width</a></li>
                    <li><a tabindex="-1" href="cart.html">Cart</a></li>
                    <li><a tabindex="-1" href="login.html">Login</a></li>
                    <li><a tabindex="-1" href="compare.html">Compare Products</a></li>
                    <li><a tabindex="-1" href="typography.html">Typography</a></li>
                    <li><a tabindex="-1" href="register.html">Register</a></li>
                    <li><a tabindex="-1" href="contact.html">Contact</a></li>
                    <li><a tabindex="-1" href="404.html">404</a></li>
                </ul>
            </li>

        </ul>
    </div>
    <!-- Navbar Cat collapse Ends -->
</nav>
