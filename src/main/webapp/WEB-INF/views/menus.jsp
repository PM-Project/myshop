
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${menus}" var="category">
    <li><a href="${category.link}">${category.categoryName}</a></li>
</c:forEach>
