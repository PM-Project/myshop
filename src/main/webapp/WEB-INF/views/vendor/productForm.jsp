<%-- 
    Document   : productForm
    Created on : Jan 2, 2015, 2:23:49 AM
    Author     : Santosh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <%@include file="../head.jsp" %>

        

    </head>
    <body>
        <!-- Wrapper Starts -->
        <div id="wrapper" class="container">
            <!-- Header Section Starts -->
            <%@include file="header.jsp" %>
            <!-- Main Menu Ends -->


            <div class="panel-heading">
                <h2 class="main-heading">Product </h2>

            </div>

            <div class="row">
                <div class="col-md-12">
                    <form:form class="form-horizontal" commandName="product" action="vendor/product/save" method="post" enctype="multipart/form-data">

                        <form:errors element="div" class="alert alert-error" path="*"/>

                        <div class="row" >
                            <div class="col-md-6 ui-sortable">                


                                <form:input type="hidden" path="id"/>

                                <div class="form-group">
                                    <label for="productName" class="control-label col-xs-3">Product Name</label>
                                    <div class="col-xs-9">
                                        <form:input type="text" path="productName" class="form-control input-sm mrgn-bttm-md" id="productName" placeholder="Product Name" style="width:300px"/>
                                        <form:errors path="productName" element="div" cssClass="error" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="productDescription" class="control-label col-xs-3">Description</label>
                                    <div class="col-xs-9">
                                        <form:textarea type="text" path="productDescription" class="form-control input-sm mrgn-bttm-md" id="productDescription" placeholder="Product Description" style="width:300px"/>

                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="category" class="control-label col-xs-3">Category</label>
                                    <div class="col-xs-9">
                                        <form:select path="category" class="form-control input-sm mrgn-bttm-md" placeholder="Category" style="width:300px">
                                            <form:options items="${categories}" itemLabel="categoryName" itemValue="id"/>
                                        </form:select>   
                                    </div>
                                </div>



                                <div class="form-group">
                                    <label for="unit" class="control-label col-xs-3">Unit</label>
                                    <div class="col-xs-9">
                                        <form:select path="unit" class="form-control input-sm mrgn-bttm-md" style="width: auto;">
                                            <form:options items="${units}"/>
                                        </form:select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="costPrice" class="control-label col-xs-3">Cost Price</label>
                                    <div class="col-xs-9">
                                        <form:input type="text" id="costPrice" class="form-control input-sm mrgn-bttm-md" path="costPrice" placeholder="Cost Price" style="width:300px"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="sellingPrice" class="control-label col-xs-3">Selling Price</label>
                                    <div class="col-xs-9">
                                        <form:input type="text" class="form-control input-sm mrgn-bttm-md" path="sellingPrice" placeholder="Selling Price" style="width:300px"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-xs-3">Old Price</label>
                                    <div class="col-xs-9">
                                        <form:input type="text" class="form-control input-sm mrgn-bttm-md" path="oldPrice" placeholder="Old Price" style="width:300px"/>
                                    </div>
                                </div>

                                <div class="form-group" style="display:none">
                                    <label for="currentBalance" class="control-label col-xs-3">Current Balance</label>
                                    <div class="col-xs-9">
                                        <form:input type="text" class="form-control input-sm mrgn-bttm-md" path="currentBalance" placeholder="Current Balance" style="width:300px"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-xs-offset-3 col-xs-9">
                                        <button type="submit" class="btn btn-default">Save Product</button>
                                    </div>

                                </div>
                            </div>


                            <div class="col-md-6 ui-sortable">

                                <div class="form-group">
                                    <c:if test="${product.fileName != null}">
                                        <img src="pictures/thumb/${product.fileName}"/><br/>
                                    </c:if>
                                    
                                    <lable for="file">Product Picture [Must be JPEG picture]</lable>
                                        <form:input type="file" path="file" class="btn btn-default"/>
                                </div>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>




            </br>



            <!-- Footer Section Starts -->
            <!-- Footer Section Ends -->		
        </div>
        <!-- Wrapper Ends -->
        <!-- Copyright Area Starts -->
        <%@include file="../foot.jsp" %>



    </body>

</html>