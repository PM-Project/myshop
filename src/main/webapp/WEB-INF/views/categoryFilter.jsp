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
				
				<!-- Main Heading Starts -->
					<h2 class="main-heading2">
						${category.categoryName}
					</h2>
                                        <br/>
                                        <br/>
				<!-- Main Heading Ends -->
				
				
				<!-- Product Grid Display Starts -->
                                <div class="row" id="isoContainer">
					<!-- Product #1 Starts -->
                                        <c:forEach items="${category.products}" var="product" varStatus="index">
                                            <div class="col-md-3 col-sm-6">
							<div class="product-col">
								<div class="image">
									<img class="img-responsive" alt="product" src="pictures/thumb/${product.fileName}">
								</div>
								<div class="caption">
									<h4><a href="product.html">${product.productName}</a></h4>
									<div class="description">
										${product.productDescription}
									</div>
									<div class="price">
										<span class="price-new">$199.50</span> 
										<span class="price-old">$249.50</span>
									</div>
									<div class="cart-button button-group">
										
										<button onClick="return addToCart(${product.id})" class="btn btn-cart" type="button">
											Add to cart
											<i class="fa fa-shopping-cart"></i> 
										</button>									
									</div>
								</div>
							</div>
						</div>
                                                </c:forEach>
					<!-- Product #1 Ends -->
					
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