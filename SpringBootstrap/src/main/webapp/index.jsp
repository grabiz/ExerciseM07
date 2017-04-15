<%-- 
    Document   : index
    Created on : Apr 13, 2017, 4:28:20 PM
    Author     : NGUYEN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<!DOCTYPE html>
<html>
    <jsp:include page="/WEB-INF/include/header.jsp"/>
    <img src="<c:url value='https://s-media-cache-ak0.pinimg.com/originals/b1/26/1a/b1261aa7d17af7ba4b64feaa90f001c1.jpg'></c:url>" class="img-thumbnail" alt="manga" width="600" weith="300"/>
    <br><br>
    <a href="showList" class="btn btn-info" role="button">Show List</a>
</div>    
</body>
</html>
