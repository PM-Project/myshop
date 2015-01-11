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
                <div class="row">
                    <!-- Primary Content Starts -->
                    <div class="col-md-12">
                        

                        <!-- Product Grid Display Starts -->
                        <div class="row product-info">
                            <!-- Left Starts -->
                            <div class="col-sm-5 images-block">
                                <c:if test="${product.fileName != null}">
                                    <p><img class="img-responsive thumbnail" alt="Image" src="pictures/large/${product.fileName}"></p>
                                </c:if>
                  
                            </div>
                            <!-- Left Ends -->
                            <!-- Right Starts -->
                            <div class="col-sm-7 product-details">
                                <!-- Product Name Starts -->
                                <h2>${product.productName}</h2>
                                <!-- Product Name Ends -->
                                <hr>
                                <!-- Manufacturer Starts -->
                                <p>
                                    ${product.productDescription}
                                </p>
                                <!-- Manufacturer Ends -->
                                <hr>
                                <!-- Price Starts -->
                                <div class="price">
                                    <span class="price-head">Price :</span>
                                    <span class="price-new">$${product.sellingPrice}</span> 
                                </div>
                                <!-- Price Ends -->
                                <hr>
                                <!-- Available Options Starts -->
                                <div class="options">
                                    <div class="form-group">
                                        <label for="input-quantity" class="control-label text-uppercase">Qty:</label>
                                        <input type="text" class="form-control productQuantity" id="input-quantity" size="2" value="1" name="quantity">
                                    </div>
                                    <div class="cart-button button-group">
                                        
                                        <button onclick="return addToCartTwo(${product.id})" class="btn btn-cart" type="button">
                                            Add to cart
                                            <i class="fa fa-shopping-cart"></i> 
                                        </button>									
                                    </div>
                                </div>
                                <!-- Available Options Ends -->
                                <hr>
                            </div>
                            <!-- Right Ends -->
                        </div>
                        <!-- Product Grid Display Ends -->
                    </div>
                </div>
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