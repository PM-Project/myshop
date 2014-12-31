<%-- 
    Document   : category
    Created on : Dec 30, 2014, 10:55:21 PM
    Author     : Santosh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>

	<meta charset="utf-8">
	<!--[if IE]>
		<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
	<![endif]-->
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>My Shop - Category</title>
	<base href='<c:url value="/"/>' />
        
	<!-- Bootstrap Core CSS -->
	<link href="resources/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- Google Web Fonts -->
	<link href="http://fonts.googleapis.com/css?family=Roboto+Condensed:300italic,400italic,700italic,400,300,700" rel="stylesheet" type="text/css">
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
	
	<!-- CSS Files -->
	<link href="resources/font-awesome/css/font-awesome.min.css" rel="stylesheet">
	<link href="resources/css/owl.carousel.css" rel="stylesheet">
	<link href="resources/css/style.css" rel="stylesheet">
	<link href="resources/css/responsive.css" rel="stylesheet">
	
	<!--[if lt IE 9]>
		<script src="resources/js/ie8-responsive-file-warning.js"></script>
	<![endif]-->
	
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	
	
</head>
<body>
<!-- Wrapper Starts -->
	<div id="wrapper" class="container">
	<!-- Header Section Starts -->
        <%@include file="../header.jsp" %>
	<!-- Main Menu Ends -->
        
        <h1>Category Management</h1>
        
            
            
            <center>
                <form id="categoryForm" method="post" >
                    <table style="border-collapse: collapse; width: 500px;" border="0" bordercolor="#006699">
                        <tbody>
                            <tr>     
                                <td>Enter Contact Name</td>      
                                <td><input name="name" type="text"><input value="Search" type="submit"><input onclick="javascript:go('saveContact.do');" value="New Contact" type="button"></td>
                            </tr>
                        </tbody>
                    </table>
                </form>
                <c:if test="${empty SEARCH_CONTACTS_RESULTS_KEY}"> 
                </c:if>
                <c:if test="${! empty SEARCH_CONTACTS_RESULTS_KEY}">
                    <c:forEach items="${SEARCH_CONTACTS_RESULTS_KEY}" var="contact"> 
                       
                    </c:forEach>
                </c:if>
                <table style="border-collapse: collapse; width: 500px;" border="1" bordercolor="#006699">
                    <tbody>
                        <tr bgcolor="lightblue">    
                            <th>Id</th>    
                            <th>Name</th>       
                            <th>Address</th>     
                            <th>Mobile</th>    
                            <th></th>   
                        </tr>
	 
                        <tr>    
                            <td colspan="4">No Results found</td>   
                        </tr>
	 
                        <tr>     
                            <td><c:out value="${contact.id}"></c:out></td>     
                            <td><c:out value="${contact.name}"></c:out></td>     
                            <td><c:out value="${contact.address}"></c:out> </td>     
                            <td><c:out value="${contact.mobile}"></c:out></td>     
                            <td> <a href="http://www.blogger.com/updateContact.do?id=$%7Bcontact.id%7D">Edit</a> <a href="javascript:deleteContact('deleteContact.do?id=${contact.id}');">Delete</a></td>    
                        </tr>
                    </tbody>
                </table>
            </center>

            
            
        
        
        
        
        
        
	<!-- Latest Products Starts -->
		<section class="product-carousel">			
		<!-- Heading Starts -->
			<h2 class="product-head">Latest Products</h2>
		<!-- Heading Ends -->
		<!-- Products Row Starts -->
			<div class="row">
				<div class="col-xs-12">
				<!-- Product Carousel Starts -->
					<div id="owl-product" class="owl-carousel">
					<!-- Product #1 Starts -->
						<div class="item">
							<div class="product-col">
								<div class="image">
									<img src="resources/images/product-images/1.jpg" alt="product" class="img-responsive" />
								</div>
								<div class="caption">
									<h4><a href="product.html">Simply Organic Seeds</a></h4>
									<div class="description">
										We are so lucky living in such a wonderful time. Our almost unlimited ...
									</div>
									<div class="price">
										<span class="price-new">$199.50</span> 
										<span class="price-old">$249.50</span>
									</div>
									<div class="cart-button button-group">
										<button type="button" class="btn btn-cart">
											<i class="fa fa-shopping-cart"></i>
											Add to cart									 
										</button>
										<button type="button" title="Wishlist" class="btn btn-wishlist">
											<i class="fa fa-heart"></i>
										</button>
										<button type="button" title="Compare" class="btn btn-compare">
											<i class="fa fa-bar-chart-o"></i>
										</button>
									</div>
								</div>
							</div>
						</div>
					<!-- Product #1 Ends -->
					<!-- Product #2 Starts -->
						<div class="item">
							<div class="product-col">
								<div class="image">
									<img src="resources/images/product-images/2.jpg" alt="product" class="img-responsive" />
								</div>
								<div class="caption">
									<h4><a href="product.html">Simply Organic Seeds</a></h4>
									<div class="description">
										We are so lucky living in such a wonderful time. Our almost unlimited ...
									</div>
									<div class="price">
										<span class="price-new">$199.50</span> 
										<span class="price-old">$249.50</span>
									</div>
									<div class="cart-button button-group">
										<button type="button" class="btn btn-cart">
											<i class="fa fa-shopping-cart"></i>
											Add to cart									 
										</button>
										<button type="button" title="Wishlist" class="btn btn-wishlist">
											<i class="fa fa-heart"></i>
										</button>
										<button type="button" title="Compare" class="btn btn-compare">
											<i class="fa fa-bar-chart-o"></i>
										</button>
									</div>
								</div>
							</div>
						</div>
					<!-- Product #2 Ends -->
					<!-- Product #3 Starts -->
						<div class="item">
							<div class="product-col">
								<div class="image">
									<img src="resources/images/product-images/3.jpg" alt="product" class="img-responsive" />
								</div>
								<div class="caption">
									<h4><a href="product.html">Simply Organic Seeds</a></h4>
									<div class="description">
										We are so lucky living in such a wonderful time. Our almost unlimited ...
									</div>
									<div class="price">
										<span class="price-new">$199.50</span> 
										<span class="price-old">$249.50</span>
									</div>
									<div class="cart-button button-group">
										<button type="button" class="btn btn-cart">
											<i class="fa fa-shopping-cart"></i>
											Add to cart									 
										</button>
										<button type="button" title="Wishlist" class="btn btn-wishlist">
											<i class="fa fa-heart"></i>
										</button>
										<button type="button" title="Compare" class="btn btn-compare">
											<i class="fa fa-bar-chart-o"></i>
										</button>
									</div>
								</div>
							</div>
						</div>
					<!-- Product #3 Ends -->
					<!-- Product #4 Starts -->
						<div class="item">
							<div class="product-col">
								<div class="image">
									<img src="resources/images/product-images/4.jpg" alt="product" class="img-responsive" />
								</div>
								<div class="caption">
									<h4><a href="product.html">Simply Organic Seeds</a></h4>
									<div class="description">
										We are so lucky living in such a wonderful time. Our almost unlimited ...
									</div>
									<div class="price">
										<span class="price-new">$199.50</span> 
										<span class="price-old">$249.50</span>
									</div>
									<div class="cart-button button-group">
										<button type="button" class="btn btn-cart">
											<i class="fa fa-shopping-cart"></i>
											Add to cart									 
										</button>
										<button type="button" title="Wishlist" class="btn btn-wishlist">
											<i class="fa fa-heart"></i>
										</button>
										<button type="button" title="Compare" class="btn btn-compare">
											<i class="fa fa-bar-chart-o"></i>
										</button>
									</div>
								</div>
							</div>
						</div>
					<!-- Product #4 Ends -->
					<!-- Product #5 Starts -->
						<div class="item">
							<div class="product-col">
								<div class="image">
									<img src="resources/images/product-images/5.jpg" alt="product" class="img-responsive" />
								</div>
								<div class="caption">
									<h4><a href="product.html">Simply Organic Seeds</a></h4>
									<div class="description">
										We are so lucky living in such a wonderful time. Our almost unlimited ...
									</div>
									<div class="price">
										<span class="price-new">$199.50</span> 
										<span class="price-old">$249.50</span>
									</div>
									<div class="cart-button button-group">
										<button type="button" class="btn btn-cart">
											<i class="fa fa-shopping-cart"></i>
											Add to cart									 
										</button>
										<button type="button" title="Wishlist" class="btn btn-wishlist">
											<i class="fa fa-heart"></i>
										</button>
										<button type="button" title="Compare" class="btn btn-compare">
											<i class="fa fa-bar-chart-o"></i>
										</button>
									</div>
								</div>
							</div>
						</div>
					<!-- Product #5 Ends -->
					<!-- Product #6 Starts -->
						<div class="item">
							<div class="product-col">
								<div class="image">
									<img src="resources/images/product-images/6.jpg" alt="product" class="img-responsive" />
								</div>
								<div class="caption">
									<h4><a href="product.html">Simply Organic Seeds</a></h4>
									<div class="description">
										We are so lucky living in such a wonderful time. Our almost unlimited ...
									</div>
									<div class="price">
										<span class="price-new">$199.50</span> 
										<span class="price-old">$249.50</span>
									</div>
									<div class="cart-button button-group">
										<button type="button" class="btn btn-cart">
											<i class="fa fa-shopping-cart"></i>
											Add to cart									 
										</button>
										<button type="button" title="Wishlist" class="btn btn-wishlist">
											<i class="fa fa-heart"></i>
										</button>
										<button type="button" title="Compare" class="btn btn-compare">
											<i class="fa fa-bar-chart-o"></i>
										</button>
									</div>
								</div>
							</div>
						</div>
					<!-- Product #6 Ends -->
					<!-- Product #7 Starts -->
						<div class="item">
							<div class="product-col">
								<div class="image">
									<img src="resources/images/product-images/7.jpg" alt="product" class="img-responsive" />
								</div>
								<div class="caption">
									<h4><a href="product.html">Simply Organic Seeds</a></h4>
									<div class="description">
										We are so lucky living in such a wonderful time. Our almost unlimited ...
									</div>
									<div class="price">
										<span class="price-new">$199.50</span> 
										<span class="price-old">$249.50</span>
									</div>
									<div class="cart-button button-group">
										<button type="button" class="btn btn-cart">
											<i class="fa fa-shopping-cart"></i>
											Add to cart									 
										</button>
										<button type="button" title="Wishlist" class="btn btn-wishlist">
											<i class="fa fa-heart"></i>
										</button>
										<button type="button" title="Compare" class="btn btn-compare">
											<i class="fa fa-bar-chart-o"></i>
										</button>
									</div>
								</div>
							</div>
						</div>
					<!-- Product #7 Ends -->
					<!-- Product #8 Starts -->
						<div class="item">
							<div class="product-col">
								<div class="image">
									<img src="resources/images/product-images/8.jpg" alt="product" class="img-responsive" />
								</div>
								<div class="caption">
									<h4><a href="product.html">Simply Organic Seeds</a></h4>
									<div class="description">
										We are so lucky living in such a wonderful time. Our almost unlimited ...
									</div>
									<div class="price">
										<span class="price-new">$199.50</span> 
										<span class="price-old">$249.50</span>
									</div>
									<div class="cart-button button-group">
										<button type="button" class="btn btn-cart">
											<i class="fa fa-shopping-cart"></i>
											Add to cart									 
										</button>
										<button type="button" title="Wishlist" class="btn btn-wishlist">
											<i class="fa fa-heart"></i>
										</button>
										<button type="button" title="Compare" class="btn btn-compare">
											<i class="fa fa-bar-chart-o"></i>
										</button>
									</div>
								</div>
							</div>
						</div>
					<!-- Product #8 Ends -->
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
				<div class="col-md-3 col-sm-6">
					<div class="product-col">
						<div class="image">
							<img src="resources/images/product-images/17.jpg" alt="product" class="img-responsive" />
						</div>
						<div class="caption">
							<h4><a href="product.html">Simply Organic Seeds</a></h4>
							<div class="description">
								We are so lucky living in such a wonderful time. Our almost unlimited ...
							</div>
							<div class="price">
								<span class="price-new">$199.50</span> 
								<span class="price-old">$249.50</span>
							</div>
							<div class="cart-button button-group">
								<button type="button" class="btn btn-cart">
									<i class="fa fa-shopping-cart"></i>
									Add to cart									 
								</button>
								<button type="button" title="Wishlist" class="btn btn-wishlist">
									<i class="fa fa-heart"></i>
								</button>
								<button type="button" title="Compare" class="btn btn-compare">
									<i class="fa fa-bar-chart-o"></i>
								</button>
							</div>
						</div>
					</div>
				</div>
			<!-- Product #1 Ends -->
			<!-- Product #2 Starts -->
				<div class="col-md-3 col-sm-6">
					<div class="product-col">
						<div class="image">
							<img src="resources/images/product-images/18.jpg" alt="product" class="img-responsive" />
						</div>
						<div class="caption">
							<h4><a href="product.html">Simply Organic Seeds</a></h4>
							<div class="description">
								We are so lucky living in such a wonderful time. Our almost unlimited ...
							</div>
							<div class="price">
								<span class="price-new">$199.50</span> 
								<span class="price-old">$249.50</span>
							</div>
							<div class="cart-button button-group">
								<button type="button" class="btn btn-cart">
									<i class="fa fa-shopping-cart"></i>
									Add to cart									 
								</button>
								<button type="button" title="Wishlist" class="btn btn-wishlist">
									<i class="fa fa-heart"></i>
								</button>
								<button type="button" title="Compare" class="btn btn-compare">
									<i class="fa fa-bar-chart-o"></i>
								</button>
							</div>
						</div>
					</div>
				</div>
			<!-- Product #2 Ends -->
			<!-- Product #3 Starts -->
				<div class="col-md-3 col-sm-6">
					<div class="product-col">
						<div class="image">
							<img src="resources/images/product-images/19.jpg" alt="product" class="img-responsive" />
						</div>
						<div class="caption">
							<h4><a href="product.html">Simply Organic Seeds</a></h4>
							<div class="description">
								We are so lucky living in such a wonderful time. Our almost unlimited ...
							</div>
							<div class="price">
								<span class="price-new">$199.50</span> 
								<span class="price-old">$249.50</span>
							</div>
							<div class="cart-button button-group">
								<button type="button" class="btn btn-cart">
									<i class="fa fa-shopping-cart"></i>
									Add to cart									 
								</button>
								<button type="button" title="Wishlist" class="btn btn-wishlist">
									<i class="fa fa-heart"></i>
								</button>
								<button type="button" title="Compare" class="btn btn-compare">
									<i class="fa fa-bar-chart-o"></i>
								</button>
							</div>
						</div>
					</div>
				</div>
			<!-- Product #3 Ends -->
			<!-- Product #4 Starts -->
				<div class="col-md-3 col-sm-6">
					<div class="product-col">
						<div class="image">
							<img src="resources/images/product-images/20.jpg" alt="product" class="img-responsive" />
						</div>
						<div class="caption">
							<h4><a href="product.html">Simply Organic Seeds</a></h4>
							<div class="description">
								We are so lucky living in such a wonderful time. Our almost unlimited ...
							</div>
							<div class="price">
								<span class="price-new">$199.50</span> 
								<span class="price-old">$249.50</span>
							</div>
							<div class="cart-button button-group">
								<button type="button" class="btn btn-cart">
									<i class="fa fa-shopping-cart"></i>
									Add to cart									 
								</button>
								<button type="button" title="Wishlist" class="btn btn-wishlist">
									<i class="fa fa-heart"></i>
								</button>
								<button type="button" title="Compare" class="btn btn-compare">
									<i class="fa fa-bar-chart-o"></i>
								</button>
							</div>
						</div>
					</div>
				</div>
			<!-- Product #4 Ends -->
			</div>
		<!-- Products Row Ends -->
		</section>
	<!-- Latest Products Ends -->
	<!-- Footer Section Starts -->
        <%@include file="../footer.jsp" %>
	<!-- Footer Section Ends -->		
	</div>
<!-- Wrapper Ends -->
<!-- Copyright Area Starts -->
<%@include file="../foot.jsp" %>
</body>

</html>