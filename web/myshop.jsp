<%-- 
    Document   : mýhop
    Created on : Mar 11, 2024, 9:00:41 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <<h1>List of Products</h1>
        <form name="f" action="" method="post">
            Enter number of items to buy:
            <input type="number" name="num" value="1"/>
            <hr/>
            <table border="1px" width ="40%">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Quatity</th>
                    <th>Price</th>
                    <th>Action</th>
                </tr>
                <c:forEach items="${requestScope.data}" var="p">
                    <c:set var="id" value="${p.id}"
                      
                </c:forEach>

            </table>
    </form>
</body>
</html>
