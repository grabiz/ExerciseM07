<%-- 
    Document   : EditData
    Created on : Apr 15, 2017, 9:34:44 AM
    Author     : NGUYEN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html>
<html>
    <jsp:include page="../include/header.jsp"/>
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12">
            <spring:form action="saveCancel" method="post" modelAttribute="product" >
                <div class="form-group">
                    <label for="id">ID:</label>
                     ${product.id}  <input type="hidden" name="id" value="${product.id}"/>
                </div>
                <div class="form-group">
                    <label for="branch">Branch </label>
                    <input type="text" name="branch" class="form-control" id="branch" placeholder="${product.branch}" />
                </div>
                <div class="form-group">
                    <label for="price">Price</label>
                    <input type="text" name="price" class="form-control" id="price" placeholder="${product.price}"/>
                </div>
                <div class="form-group">
                    <label for="description">Description </label>
                    <textarea rows="3" name="description" class="form-control" id="description" placeholder="${product.description}"></textarea>
                </div>
                <button type="submit" name="action" value="save" class="btn btn-warning">Save</button>
                <button type="submit" name="action" value="cancel" class="btn btn-success">Cancel</button>
            </spring:form>
        </div>
    </div>
</div>
</body>
</html>
