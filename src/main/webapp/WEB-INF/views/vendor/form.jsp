<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <base href="<c:url value="/"/>"/>
        <link rel="stylesheet" href="resources/css/styles.css"/>
    </head>
    <body>

        <h1>Vendor Page</h1>
        
        <spring:form method="post" action="vendor/save" commandName="vendor">
            <spring:errors element="div" cssClass="errors" path="*"/>
            <p>
            <spring:input type="hidden" path="id"/>
            <table> 
            <tr>
            <td><label>Vendor Name:</label></td>
            <td><spring:input path="vendorName" /></td>
            <td><spring:errors path="vendorName" element="div" cssClass="error" /></td>
            </tr>
            <tr>
               
            <td><label>Street:</label></td>
            <td><spring:input path="street" /></td>
            <td><spring:errors path="street" element="div" cssClass="error" /></td>
            </tr>
             <td><label>City:</label></td>
            <td><spring:input path="city" /></td>
            <td><spring:errors path="city" element="div" cssClass="error" /></td>
            </tr>
             <td><label>State:</label></td>
            <td><spring:input path="state" /></td>
            <td><spring:errors path="state" element="div" cssClass="error" /></td>
            </tr>
            <td><label>zip-code:</label></td>
            <td><spring:input path="zipcode" /></td>
            <td><spring:errors path="zipcode" element="div" cssClass="error" /></td>
            </tr>
            
            <tr>
            <td><label>Join Date:</label></td>
            <td><spring:input path="joinDate" /></td>
            <td><spring:errors path="joinDate" element="div" cssClass="error" /></td>
            </tr>           
             <tr>
            <td><label>Email:</label></td>
            <td><spring:input path="email" /></td>
            <td><spring:errors path="email" element="div" cssClass="error" /></td>
            </tr>
            <tr>
            <td><label>Phone:</label></td>
            <td><spring:input path="phone" /></td>
            <td><spring:errors path="phone" element="div" cssClass="error" /></td>
            </tr>
            </table>
            </p>
            <p>
                <input type="submit" value="Submit"/>
            </p>
            
        </spring:form>
    </body>
</html>