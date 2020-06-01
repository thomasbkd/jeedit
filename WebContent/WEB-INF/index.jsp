<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@include file="header.jsp"%>
<body>

<!-- THOMAS -->

<div class="add_post_form">
	<%@include file="add_post_form.jsp"%>
</div>

<section>
	<c:forEach items="${original_posts}" var="orig_post">
		<div class="post_cadre">
			<div class="post_attributes">
				<div class="title_author">
					<div class="title">
						${orig_post.title}
					</div> 
					<div class="author">
						— ${orig_post.author}
					</div>
				</div>
				<div class="post_content">
					${orig_post.content}
				</div>
			</div>
			
			<div class="vote_system">
				<div class="up_vote"><a href="#">▲</a></div>
				<div class="nb_votes">${orig_post.votes}</div>
				<div class="down_vote"><a href="#">▼</a></div>
				<div class="reply_icon"><a href="#"><img src="img/reply.png" height="15"/></a></div>
			</div>
		</div>
		<c:forEach items="${all_posts}" var="all_post">
			<c:if test="${all_post.parent_id==orig_post.post_id}">
				<div class="reply_cadre">
			<div class="reply_attributes">
				<div class="reply_content">
					${all_post.content}
				</div>
				<div class="reply_author">
					— ${all_post.author}
				</div>
				</div>
			
			<div class="reply_vote_system">
				<div class="reply_up_vote"><a href="#">▲</a></div>
				<div class="reply_nb_votes">${all_post.votes}</div>
				<div class="reply_down_vote"><a href="#">▼</a></div>
			</div>
		</div>
			</c:if>
		
		</c:forEach>
	</c:forEach>          
</section>


<!-- MARION -->

	<div class="grid-container">
        <div class="grid-x grid-padding-x">
            <div class="large-12 cell">
                <h2>Jeedit v0.1</h2>
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
                    	<c:forEach items="${all_posts}" var="post_bis">
                    		<c:if  test = "${post_bis.parent_id == post.post_id}" >
	                    		<td>${post_bis.post_id}</td>
	                    		<td>${post_bis.author}</td>
	                    		<td>${post_bis.title}</td>
	                    		<td>${post_bis.content}</td>
	                    		<td>${post_bis.parent_id}</td>
	                    		<td><form accept-charset="UTF-8" action="redirect_add_post" method="GET" >
	                        		<input type="hidden" name="reply_parent_id" value='${post_bis.post_id}'>
	                        		
	                            	<input type="submit" value="Reply" class="success button"> </form>
	                        	</td>
                    		
                    		</c:if>
                    	
                    	 </c:forEach>
<!--                     	todo:print replies here -->
                    </c:forEach>
                </table>
                <a class="button" href="redirect_add_post">Add post</a>
            </div>
        </div>
    </div>
</body>
</html>