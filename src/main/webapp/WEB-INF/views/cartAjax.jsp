<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${cart.lineItems.size() > 0}">
        
    

<table class="table table-bordered">
    <thead>
        <tr>
            <td class="text-center">
                Product Image
            </td>
            <td class="text-center">
                Product Details
            </td>							
            <td class="text-center">
                Quantity
            </td>
            <td class="text-center">
                Price
            </td>
            <td class="text-center">
                Total
            </td>
            <td class="text-center">
                Action
            </td>
        </tr>
    </thead>
    <tbody>

    <c:forEach items="${cart.lineItems}" var="item">

        <tr>
            <td class="text-center">
                <a href="product.html">
                    <img class="img-thumbnail" title="Product Name" alt="Product Name" src="pictures/thumb/${item.value.product.fileName}">
                </a>
            </td>
            <td class="text-center">
                <a href="product-full.html">${item.value.product.productName}</a>
            </td>							
            <td class="text-center">
                <div class="input-group btn-block">
                    <input class="quantity" title="${item.value.product.id}" type="text" class="form-control" size="1" value="${item.value.quantity}" name="quantity">
                </div>								
            </td>
            <td class="text-center">
                $${item.value.product.sellingPrice}
            </td>
            <td class="text-center">
                $${item.value.amount}
            </td>
            <td class="text-center">
                <button class="btn btn-default tool-tip updateQty" value="${item.value.product.id}" type="button" data-original-title="Update">
                    <i class="fa fa-refresh"></i>
                </button>
                <button class="btn btn-default tool-tip removeItem" value="${item.value.product.id}" type="button" data-original-title="Remove">
                    <i class="fa fa-times-circle"></i>
                </button>
            </td>
        </tr>

    </c:forEach> 


</tbody>
<tfoot>
    <tr>
        <td class="text-right" colspan="4">
            <strong>Sub Total :</strong>
        </td>
        <td class="text-left" colspan="2">
            $${cart.subTotal}
        </td>
    </tr>
    <tr>
        <td class="text-right" colspan="4">
            <strong>Tax ${cart.taxRate} %:</strong>
        </td>
        <td class="text-left" colspan="2">
            $${cart.taxAmount}
        </td>
    </tr>
    <tr>
        <td class="text-right" colspan="4">
            <strong>Sub Total :</strong>
        </td>
        <td class="text-left" colspan="2">
            $${cart.grandTotal}
        </td>
    </tr>
</tfoot>
</table>
        
        <div class="cartButtons" style="text-align: center">
            <a class="btn btn-default" href="checkout">Clear Cart</a>
            <a class="btn btn-default" href="./">Continue Shopping</a>
            <a class="btn btn-default btn-danger" href="checkout">Checkout</a>
        </div>
        
        
        </c:when>
        <c:otherwise>
            <h4 style="text-align: center">Cart is Empty.</h4>
        </c:otherwise>
</c:choose>
        
        