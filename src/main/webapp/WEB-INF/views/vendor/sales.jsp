<%-- 
    Document   : productList
    Created on : Jan 2, 2015, 1:57:47 AM
    Author     : Santosh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <%@include file="../head.jsp" %>
        <link href="resources/css/datepicker.css" rel="stylesheet">
        <script src="resources/js/bootstrap-datepicker.js"></script>
        
        <script>
        $(document).ready(function() {
                $('.datepicker').datepicker({
                    format: 'yyyy-mm-dd'
                }).on('changeDate',function(){
                    $(this).datepicker('hide');
                });
                
                $(".pdfreport").click(function(){
                    var fromDate = $("#fromDate").val();
                    var toDate = $("#toDate").val();
                    
                    if(fromDate === '' || toDate === '')
                    {
                        alert('Please choose Date');
                    }else{
                        window.location("vendor/download/pdf/"+fromDate+"/"+toDate);
                    }
                    return false;
                });
                
        });
        </script>
    </head>
    <body>
        <!-- Wrapper Starts -->
        <div id="wrapper" class="container">
            <!-- Header Section Starts -->
            <%@include file="header.jsp" %>
            <!-- Main Menu Ends -->
            <div class="message">${message}</div>
            <div class="pull-right">
               <form style="display: inline">
                   <input type="date" id="fromDate" class="datepicker" data-date-format="yyyy-mm-dd" placeholder="Report Date From" name="fromDate"/> 
                   <input type="date" id="toDate" class="datepicker" data-date-format="yyyy-mm-dd" placeholder="Report Date To" name="toDate" />
            </form>
                <a href="vendor/download/pdf" class="btn pdfreport"><img src="resources/images/pdf.png" alt="pdf" width="45px" height="45px"/></a>
            <a href="vendor/download/xls" class="btn"><img src="resources/images/xls.png" alt="xls" width="45px" height="45px" /></a>
            <a href="vendor/download/ht"  class="btn" ><img src="resources/images/html.png" alt="xls" width="45px" height="45px" /></a>
            
            </div>
            <h1>Sales Report</h1>

            
            
            <table class="table table-striped" style="width:100%" >
                <tr>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Quantity</th>
                    <th>Sold Rate</th>
                    <th>Amount</th>

                </tr>

                <c:forEach items="${orderItems}" var="item">
                    <tr>
                        <td>${item.product.id}</td>
                        <td>${item.product.productName}</td>
                        <td>${item.quantity}</td>
                        <td>${item.rate}</td>
                        <td>${item.amount}</td>

                    </tr>
                </c:forEach>
            </table>
            </br>

            </br>
            <!-- Footer Section Starts -->
            <!-- Footer Section Ends -->		
        </div>
        <!-- Wrapper Ends -->
        <!-- Copyright Area Starts -->
        <%@include file="../foot.jsp" %>
    </body>

</html>