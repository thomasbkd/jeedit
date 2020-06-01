<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <%@include file="header.jsp"%>
    <title>Add post</title>
</head>
<body>

<%--                 <c:if test="${not empty error}"> --%>
<!--                 	<div class="alert callout" aria-live="assertive" role="alert" style="display: block;"> -->
<%--     				<p><c:out value='${error}'></c:out></p> --%>
<!--   					</div> -->
<%--   				</c:if> --%>
  				
                    <%@include file="add_post_form.jsp"%>
                
            </div>
        </div>
    </div>
    
</body>
</html>