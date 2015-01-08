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
				<div class="col-md-9">
				
				<!-- Main Heading Starts -->
					<h2 class="main-heading2">
						Search Results:
					</h2>
                                        <br/>
                                        <br/>
				<!-- Main Heading Ends -->
				
				
				<!-- Product Grid Display Starts -->
					<div id="isoContainer" class="row">
					<!-- Product #1 Starts -->
                                        <c:forEach items="${products}" var="product" varStatus="index">
						<div class="col-md-4 col-sm-6">
							<div class="product-col">
                                                            <div class="image" style="background-image: url('pictures/thumb/${product.fileName}')">
                                                                <img src="pictures/thumb/${product.fileName}" class="img-responsive"/>
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
										<button class="btn btn-wishlist" title="" type="button" data-original-title="Wishlist">
											<i class="fa fa-heart"></i>
										</button>
										<button class="btn btn-compare" title="" type="button" data-original-title="Compare">
											<i class="fa fa-bar-chart-o"></i>
										</button>
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
			<!-- Primary Content Ends -->
			<!-- Sidebar Starts -->
				<div class="col-md-3">
				<!-- Categories Links Starts -->
					<h3 class="side-heading">Categories</h3>
					<div class="list-group">
						<a class="list-group-item" href="category-grid.html">
							<i class="fa fa-chevron-right"></i>
							Spices &amp; Herbs
						</a>
						<a class="list-group-item" href="category-grid.html">
							<i class="fa fa-chevron-right"></i>
							Chili Powder
						</a>
						<a class="list-group-item" href="category-grid.html">
							<i class="fa fa-chevron-right"></i>
							Herb Blends
						</a>
						<a class="list-group-item" href="category-grid.html">
							<i class="fa fa-chevron-right"></i>
							Seasonings
						</a>
						<a class="list-group-item" href="category-grid.html">
							<i class="fa fa-chevron-right"></i>
							Salt Free Spices
						</a>
					</div>
				<!-- Categories Links Ends -->
				<!-- Shopping Options Starts -->
					<h3 class="side-heading">Shopping Options</h3>
					<div class="list-group">
						<div class="list-group-item">
							Brands
						</div>
						<div class="list-group-item">
							<div class="filter-group">
								<label class="checkbox">
									<input type="checkbox" checked="checked" value="br1" name="filter1">
									Brand Name 1
								</label>
								<label class="checkbox">
									<input type="checkbox" value="br2" name="filter2">
									Brand Name 2
								</label>
								<label class="checkbox">
									<input type="checkbox" value="br2" name="filter2">
									Brand Name 3
								</label>
							</div>
						</div>
						<div class="list-group-item">
							Manufacturer
						</div>
						<div class="list-group-item">
							<div class="filter-group">
								<label class="radio">
									<input type="radio" checked="checked" value="mr1" name="filter-manuf">
									Manufacturer Name 1
								</label>
								<label class="radio">
									<input type="radio" value="mr2" name="filter-manuf">
									Manufacturer Name 2
								</label>
								<label class="radio">
									<input type="radio" value="mr3" name="filter-manuf">
									Manufacturer Name 3
								</label>
							</div>							
						</div>	
						<div class="list-group-item">
							<button class="btn btn-danger" type="button">Filter</button>
						</div>
					</div>
				<!-- Shopping Options Ends -->
				<!-- Bestsellers Links Starts -->
					<h3 class="side-heading">Bestsellers</h3>
					<div class="product-col">
						<div class="image">
							<img class="img-responsive" alt="product" src="images/product-images/19.jpg">
						</div>
						<div class="caption">
							<h4>
								<a href="product-full.html">Simply Organic Seeds</a>
							</h4>
							<div class="description">
								We are so lucky living in such a wonderful time. Our almost unlimited ...
							</div>
							<div class="price">
								<span class="price-new">$199.50</span> 
								<span class="price-old">$249.50</span>
							</div>
							<div class="cart-button button-group">
								<button class="btn btn-wishlist" title="" type="button" data-original-title="Wishlist">
									<i class="fa fa-heart"></i>
								</button>
								<button class="btn btn-compare" title="" type="button" data-original-title="Compare">
									<i class="fa fa-bar-chart-o"></i>
								</button>
								<button class="btn btn-cart" type="button">
									Add to cart
									<i class="fa fa-shopping-cart"></i> 
								</button>									
							</div>
						</div>
					</div>
				<!-- Bestsellers Links Ends -->
				</div>
			<!-- Sidebar Ends -->
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