<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@include file="header.jsp"%>
<title>Jeedit</title>
<body>
    <div class="grid-container">
        <div class="grid-x grid-padding-x">
            <div class="large-12 cell">
                <h2>Jeedit v0.1</h2>
<!--                 <h3>Catalog</h3> -->
                <table>
                    <tr><th>ID</th>
                        <th>Author</th>
                        <th>Title</th>
                        <th>content</th>
                    </tr>
                    <c:forEach items="${posts}" var="post">
                    	<tr>
                    		<td>${post.post_id}</td>
                    		
                    		<td>${post.author}</td>
                    		<td>${post.title}</td>
                    		<td>${post.content}</td>
<!--                         	<td><form accept-charset="UTF-8" action="CartProcess" method="post" > -->
<%--                         		<input type="hidden" name="isbn" value='${book.isbn}'> --%>
<%--                         		<input type="hidden" name="title" value='${book.title}'> --%>
<%--                         		<input type="hidden" name="price" value='${book.price}'> --%>
                        		
<!--                         		<input type="number" name="quantity" value="1"> -->
<!--                             	<input type="submit" value="Add To Cart" class="success button"> </form> -->
<!--                         	</td> -->
                    	</tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</body>
</html>