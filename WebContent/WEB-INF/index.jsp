<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@include file="header.jsp"%>
<body>
    <div class="grid-container">
        <div class="grid-x grid-padding-x">
            <div class="large-12 cell">
                <h2>jeedit v0.1</h2>
                <table>
                    <tr><th>ID</th>
                        <th>Author</th>
                        <th>Title</th>
                        <th>Content</th>
                    </tr>
	                    <c:forEach items="${posts}" var="post">
                    	<tr>
                    		<td>${post.post_id}</td>
                    		<td>${post.author}</td>
                    		<td>${post.title}</td>
                    		<td>${post.content}</td>
                    	</tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</body>
</html>