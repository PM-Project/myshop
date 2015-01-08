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

                <h2 class="main-heading text-center">
                    Shopping Cart
                </h2>

                <div id="cartAjax" class="table-responsive shopping-cart-table">
                    <c:import url="/cart/ajax"/>		
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

        
        <script type="text/javascript">
            $(document).ready(function(){
                $(".quantity").live("change",function(){
                    var id = $(this).attr("title");
                    var qty = $(this).val();
                    $.post('cart/item/'+id+'/'+qty, function(data){
                        if(data==='success'){
                            $("#cartAjax").load('cart/ajax');
                            $("#cart").load("cart");
                        }
                    });
                });
                
                $(".updateQty").live("click",function(){
                    var id = $(this).val();
                    var qty = $(this).parent().parent().find(".quantity").val();
                    $.post('cart/item/'+id+'/'+qty, function(data){
                        if(data==='success'){
                            $("#cartAjax").load('cart/ajax');
                            $("#cart").load("cart");
                        }
                    });
                });
                
                $(".removeItem").live("click",function(){
                    var id = $(this).val();
                    $.post('cart/remove/'+id, function(data){
                        if(data==='success'){
                            $("#cartAjax").load('cart/ajax');
                            $("#cart").load("cart");
                        }
                    });
                });
                
            });
        </script>
        
    </body>

</html>