<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@include file="header.jsp"%>
<body>
<section>
	<c:forEach items="${posts}" var="post">
	<c:if test="${post.parent ==0}">         
		<div class="post_cadre">
			<div class="post_attributes">
				<div class="title_author">
					<div class="title">
						${post.title}
					</div> 
					<div class="author">
						${post.author}
					</div>
				</div>
				<div class="post_content">
					${post.content}
				</div>
				
			</div>
			
			<div class="vote_system">
				<div class="up_vote"><a href="#">▲</a></div>
				<div class="nb_votes">${post.votes}</div>
				<div class="down_vote"><a href="#">▼</a></div>
				
			</div>
		</div>
	</c:if>
	</c:forEach>          

</section>
</body>
</html>