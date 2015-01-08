<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>


<%@include file="head.jsp" %>



<body>
    <!-- Wrapper Starts -->
    <div id="wrapper" class="container">
        <!-- Header Section Starts -->
        <%@include file="header.jsp" %>
        <!-- Main Menu Ends -->

        <!-- Slider Section Starts -->
        <div class="slider">
            <div id="main-carousel" class="carousel slide" data-ride="carousel">
                <!-- Wrapper For Slides Starts -->
                <div class="carousel-inner">
                    <c:forEach items="${products}" var="product" varStatus="loop">
                        <c:if test="${product.fileName != null}">
                            <div class="item${loop.index == 0 ? ' active' : ''}">
                                <img src="pictures/large/${product.fileName}" alt="Slider" class="img-responsive" />
                            </div>
                        </c:if>
                    </c:forEach>


                </div>
                <!-- Wrapper For Slides Ends -->
                <!-- Controls Starts -->
                <a class="left carousel-control" href="#main-carousel" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                </a>
                <a class="right carousel-control" href="#main-carousel" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                </a>
                <!-- Controls Ends -->
            </div>	
        </div>
        <!-- Slider Section Ends -->
        <!-- 2 Column Banners Starts -->
        <div class="col2-banners">
            <ul class="row list-unstyled">
                <li class="col-sm-8">
                    <img src="resources/images/banners/2col-banner1.jpg" alt="banners" class="img-responsive" />
                </li>
                <li class="col-sm-4">
                    <img src="resources/images/banners/2col-banner2.jpg" alt="banners" class="img-responsive" />
                </li>
            </ul>
        </div>
        <!-- 2 Column Banners Ends -->
        <!-- Latest Products Starts -->
        <section class="product-carousel">			
            <!-- Heading Starts -->
            <h3 class="product-head">Latest Products</h3>
            <!-- Heading Ends -->
            <!-- Products Row Starts -->
            <div class="row">
                <div class="col-xs-12">
                    <!-- Product Carousel Starts -->
                    <div id="owl-product" class="owl-carousel">
                        <c:forEach items="${products}" var="product">
                            <!-- Product #1 Starts -->
                            <div class="item">
                                <div class="product-col">
                                    <div class="image">
                                        <img src="pictures/thumb/${product.fileName}" alt="product" class="img-responsive" />
                                    </div>
                                    <div class="caption">
                                        <h4><a href="product.html"> ${product.productName}</a></h4>
                                        <div class="description">
                                            ${product.productDescription}
                                        </div>
                                        <div class="price">
                                            <span class="price-new">$${product.sellingPrice}</span>
                                            <c:if test="${product.oldPrice > 0}">
                                                <span class="price-old">$${product.oldPrice}</span>
                                            </c:if>
                                        </div>
                                        <div class="cart-button button-group">
                                            <button onClick="return addToCart(${product.id})" type="button" class="btn btn-cart">
                                                <i class="fa fa-shopping-cart"></i>
                                                Add to cart									 
                                            </button>

                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Product #1 Ends -->
                        </c:forEach>
                    </div>
                    <!-- Product Carousel Ends -->
                </div>
            </div>
            <!-- Products Row Ends -->
        </section>
        <!-- Latest Products Ends -->
        <!-- 3 Column Banners Starts -->
        <div class="col3-banners">
            <ul class="row list-unstyled">
                <li class="col-sm-4">
                    <img src="resources/images/banners/3col-banner1.jpg" alt="banners" class="img-responsive" />
                </li>
                <li class="col-sm-4">
                    <img src="resources/images/banners/3col-banner2.jpg" alt="banners" class="img-responsive" />
                </li>
                <li class="col-sm-4">
                    <img src="resources/images/banners/3col-banner3.jpg" alt="banners" class="img-responsive" />
                </li>
            </ul>
        </div>
        <!-- 3 Column Banners Ends -->
        <!-- Featured Products Starts -->
        <section class="products-list">			
            <!-- Heading Starts -->
            <h2 class="product-head">Featured Products</h2>
            <!-- Heading Ends -->
            <!-- Products Row Starts -->
            <div class="row">
                <!-- Product #1 Starts -->

                <c:forEach items="${products}" var="product">

                    <div class="col-md-3 col-sm-6">
                        <div class="product-col">
                            <div class="image">
                                <img src="pictures/thumb/${product.fileName}" alt="product" class="img-responsive" />
                            </div>
                            <div class="caption">
                                <h4><a href="product.html">${product.productName}</a></h4>
                                <div class="description">
                                    ${product.productDescription}
                                </div>
                                <div class="price">
                                    <span class="price-new">$${product.sellingPrice}</span>
                                    <c:if test="${product.oldPrice > 0}">
                                        <span class="price-old">$${product.oldPrice}</span>
                                    </c:if>
                                </div>
                                <div class="cart-button button-group">
                                    <button onClick="return addToCart(${product.id})" type="button" class="btn btn-cart">
                                        <i class="fa fa-shopping-cart"></i>
                                        Add to cart									 
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>

                </c:forEach>
                
            </div>
            <!-- Products Row Ends -->
        </section>
        <!-- Latest Products Ends -->
        <!-- Footer Section Starts -->
        <%@include file="footer.jsp" %>
        <!-- Footer Section Ends -->		
    </div>
    <!-- Wrapper Ends -->
    <!-- Copyright Area Starts -->
    <%@include file="foot.jsp" %>
</body>


