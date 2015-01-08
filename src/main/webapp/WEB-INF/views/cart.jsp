<%-- 
    Document   : cart
    Created on : Jan 6, 2015, 4:55:13 PM
    Author     : kunda_000
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<button type="button" data-toggle="dropdown" class="btn btn-block btn-lg dropdown-toggle">
    <i class="fa fa-shopping-cart"></i>
    <span class="hidden-xs">Cart:</span> 
    <c:set value="${cart.lineItems.size()}" var="cartSize" />
    <span id="cart-total">${cart.totalItems} item(s) - $${cart.grandTotal}</span>
    <i class="fa fa-caret-down"></i>
</button>
<ul class="dropdown-menu pull-right">
    <li>
        <table class="table hcart">
            <tbody>

                <c:forEach items="${cart.lineItems}" var="lineItem">

                    <tr>
                        <td class="text-center">
                            <a href="product.html">
                                <img src="pictures/thumb/${lineItem.value.product.fileName}" width="50" alt="image" title="image" class="img-thumbnail img-responsive">
                            </a>
                        </td>
                        <td class="text-left">
                            <a href="product-full.html">
                                ${lineItem.value.product.productName}
                            </a>
                        </td>
                        <td class="text-right">x${lineItem.value.quantity}</td>
                        <td class="text-right">$${lineItem.value.amount}</td>
                        <td class="text-center">
                            <a href="#">
                                <i class="fa fa-times"></i>
                            </a>
                        </td>
                    </tr>

                </c:forEach>


            </tbody></table>
    </li>
    <li>
        <c:if test="${cartSize > 0}">
            <table class="table table-bordered total">
                <tbody>
                    <tr>
                        <td class="text-right"><strong>Sub-Total</strong></td>
                        <td class="text-left">$${cart.subTotal}</td>
                    </tr>

                    <tr>
                        <td class="text-right"><strong>VAT (${cart.taxRate}%)</strong></td>
                        <td class="text-left">$${cart.taxAmount}</td>
                    </tr>
                    <tr>
                        <td class="text-right"><strong>Total</strong></td>
                        <td class="text-left">$${cart.grandTotal}</td>
                    </tr>
                </tbody>
            </table>
        </c:if>
        <c:choose>
            <c:when test="${cartSize > 0}">
                <p class="text-right btn-block1">
                    <a href="cart/details">
                        View Cart
                    </a>
                    <a href="checkout">
                        Checkout
                    </a>
                </p>
            </c:when>
            <c:otherwise>
                <p style="text-align: center"><strong>You Cart Is Empty</strong></p>
            </c:otherwise>
        </c:choose>

    </li>									
</ul>
