<%-- 
    Document   : foot
    Created on : Dec 30, 2014, 4:41:32 PM
    Author     : kunda_000
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="copyright container">
    <div class="clearfix">
        <!-- Starts -->
        <p class="pull-left">
            &copy; 2014 MyShop Inc. Thanks to Bootstrap and <a href="http://sainathchillapuram.com/">Sainath Chillapuram</a> for the theme.
        </p>
        <!-- Ends -->
        <!-- Payment Gateway Links Starts -->
        <ul class="pull-right list-inline">
            <li>
                <img src="resources/images/payment-icon/cirrus.png" alt="PaymentGateway" />
            </li>
            <li>
                <img src="resources/images/payment-icon/paypal.png" alt="PaymentGateway" />
            </li>
            <li>
                <img src="resources/images/payment-icon/visa.png" alt="PaymentGateway" />
            </li>
            <li>
                <img src="resources/images/payment-icon/mastercard.png" alt="PaymentGateway" />
            </li>
            <li>
                <img src="resources/images/payment-icon/americanexpress.png" alt="PaymentGateway" />
            </li>
        </ul>
        <!-- Payment Gateway Links Ends -->
    </div>
</div>
<!-- Copyright Area Ends -->
<!-- JavaScript Files -->

<script src="resources/js/owl.carousel.min.js"></script>
<script src="resources/js/custom.js"></script>
<script src="resources/js/isotope.pkgd.min.js"></script>
<sec:authorize access="hasRole({'ROLE_ADMIN'})" var="admin"></sec:authorize>
<sec:authorize access="hasRole({'ROLE_VENDOR'})" var="vendor"></sec:authorize>
<script>
    $(document).ready(function () {
        $('#isoContainer').isotope();
        
    });
    
    function addToCartTwo(id)
    {
        var qty = $(".productQuantity").val();
        addToCart(id,qty);
    }

    function addToCart(id,qty=1)
    {
        <c:if test="${admin || vendor}">
            alert('Not Allow. Only customer can add cart');
        </c:if>
        <c:if test="${! admin && ! vendor}">
        $.get('cart/add/' + id + '/'+ qty , function (data) {
                if (data === 'success')
                {
                    alert('This item has been added to cart successfully.');
                    $("#cart").load("cart");
                }
            });
        </c:if>
    }
</script>

<c:remove var="title" scope="session"/>
<c:remove var="message" scope="session"/>