<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

                <!-- Main Heading Starts -->
                <h2 class="main-heading text-center">
                    ORDER
                </h2>
                <!-- Main Heading Ends -->
                <!-- Login Form Section Starts -->
                <section class="login-area">
                    <div class="row">
                        <div class="col-sm-2">

                        </div>
                        <div class="col-sm-8">
                            <!-- Login Panel Starts -->
                            <div class="panel panel-smart">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Order Detail</h3>
                                </div>
                                <div class="panel-body">

                                    <form:form method="post" action="order/confirm" modelAttribute="order">
                                        
                                        <p><strong>Customer Name:</strong> ${order.customer.name}</p>
                                        <p><strong>Email:</strong> ${order.customer.email}</p>

                                        <table class="table table-bordered">
                                            <thead>
                                                <tr>
                                                   <td class="text-center">
                                                        S.N.
                                                    </td>
                                                    <td class="text-center">
                                                        Particulars
                                                    </td>							
                                                    <td class="text-center">
                                                        Quantity
                                                    </td>
                                                    <td class="text-center">
                                                        Rate
                                                    </td>
                                                    <td class="text-center">
                                                        Total
                                                    </td>
                                                    
                                                </tr>
                                            </thead>
                                            <tbody>

                                                <c:forEach items="${order.cart.lineItems}" var="item" varStatus="loop">

                                                    <tr>
                                                        <td class="text-center">
                                                            ${loop.index+1}
                                                        </td>
                                                        <td class="text-center">
                                                            ${item.value.product.productName}
                                                        </td>							
                                                        <td class="text-center">
                                                            ${item.value.quantity}
                                                        </td>
                                                        <td class="text-center">
                                                            $${item.value.product.sellingPrice}
                                                        </td>
                                                        <td class="text-center">
                                                            $${item.value.amount}
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
                                                        $${order.cart.subTotal}
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td class="text-right" colspan="4">
                                                        <strong>Tax ${order.cart.taxRate} %:</strong>
                                                    </td>
                                                    <td class="text-left" colspan="2">
                                                        $${order.cart.taxAmount}
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td class="text-right" colspan="4">
                                                        <strong>Sub Total :</strong>
                                                    </td>
                                                    <td class="text-left" colspan="2">
                                                        $${order.cart.grandTotal}
                                                    </td>
                                                </tr>
                                            </tfoot>
                                        </table>                                        

                                    
                                        
                                        <h3>Shipping Details:</h3>
                                        <p>${order.customer.address.doorNo}</p>
                                        <p>${order.customer.address.street}</p>
                                        <p>${order.customer.address.city}</p>
                                        <p>${order.customer.address.zipCode}</p>
                                        <p>${order.customer.address.stateName}</p>
                                        
                                        <div style="text-align: center">
                                            <input type="submit" class="btn btn-danger" value="Make Payment" />
                                        </div>
                                        </form:form> 
                                </div>
                            </div>
                            <!-- Login Panel Ends -->
                        </div>
                        <div class="col-sm-2">

                        </div>


                    </div>
                </section>
                <!-- Login Form Section Ends -->
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