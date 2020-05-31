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
                        <th>Content</th>
                        <th>Parent ID</th> 
<!--                          replace later by indentation or something in the display -->
                    </tr>
                    <c:forEach items="${original_posts}" var="post">
                    	<tr>
                    		<td>${post.post_id}</td>
                    		<td>${post.author}</td>
                    		<td>${post.title}</td>
                    		<td>${post.content}</td>
                    		<td>${post.parent_id}</td>
                    		<td><form accept-charset="UTF-8" action="redirect_add_post" method="GET" >
                        		<input type="hidden" name="reply_parent_id" value='${post.post_id}'>
                        		
                            	<input type="submit" value="Reply" class="success button"> </form>
                        	</td>
                        	
                    	</tr>
<!--                     	todo:print replies here -->
                    </c:forEach>
                </table>
                <a class="button" href="redirect_add_post">Add post</a>
            </div>
        </div>
    </div>
</body>
</html>