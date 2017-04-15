<%-- 
    Document   : ListProduct
    Created on : Apr 14, 2017, 10:03:41 PM
    Author     : NGUYEN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html>
<html>
    <jsp:include page="../include/header.jsp"/>
    <div class="table-responsive">
        <table class="table table-hover">
            <tr>
                <th>ID</th>
                <th>Branch</th>
                <th>Price</th>
                <th>Description</th>
                <th>Add to cart</th>
            </tr>
            <c:forEach var="product" items="${listProduct}">
                <tr>
                <td>${product.id}</td>
                <td>${product.branch}</td>
                <td>${product.price}</td>
                <td>${product.description}</td>
                <td> <spring:form action="addEdit">
                     <input  type="hidden" name="prodId" value="${product.id}"/>
                     <button type="submit" name="action" value="add" class="btn btn-danger">Add to cart</button>
                     <button type="submit" name="action" value="edit" class="btn btn-success">Edit</button>
                     </spring:form>
                </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
