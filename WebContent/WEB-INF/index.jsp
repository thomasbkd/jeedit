<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@include file="header.jsp"%>
<body>

<div class="add_post_form">
	<%@include file="add_post_form.jsp"%>
</div>

<div class="posts_list">
<section>
<h1 class="best_posts">Best posts</h1>
<c:forEach items="${original_posts}" var="orig_post">
<div class="post_and_del"  onmouseover="document.getElementById('del${orig_post.post_id}').style.display='block'" onmouseout="document.getElementById('del${orig_post.post_id}').style.display='none'">
		<div class="post_cadre" id="${orig_post.post_id}">
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
				<div class="up_vote"><a href="process_vote?id=${orig_post.post_id}&vote=1">▲</a></div>
				<div class="nb_votes">${orig_post.votes}</div>
				<div class="down_vote"><a href="process_vote?id=${orig_post.post_id}&vote=-1">▼</a></div>
				<div class="reply_icon"><a href="welcome?rep=${orig_post.post_id}#reply"><img src="img/reply.png" height="15"/></a></div>
			</div>
		</div>
		<div class="del_post">
		<a class="del_icon" id="del${orig_post.post_id}" style="margin-top: 30px; display: none;" onclick="confirmDelPost(${orig_post.post_id})"><img src="img/trash.png" height="18"/></a>
		<script>
		function confirmDelPost(post_id){
			if (confirm("Are you sure you want to delete this post? 😐"))
			{
				window.open("process_del_post?del="+post_id,"_self")
			}
		}
		</script>
		
		</div>
		</div>
		<c:set var="has_reply" value="false"/>
		<c:forEach items="${all_posts}" var="all_post">
			<c:if test="${all_post.parent_id==orig_post.post_id}">
					<c:set var="has_reply" value="true"/>
			</c:if>
		</c:forEach>
		<c:if test="${has_reply or rep==orig_post.post_id}">
		<div class="all_replies">
		<div class="replies_line">
		</div>
		<div class="replies_cadre">
		<c:forEach items="${all_posts}" var="all_post">
			<c:if test="${all_post.parent_id==orig_post.post_id}">
					<div class="reply_and_del"  onmouseover="document.getElementById('del${all_post.post_id}').style.display='block'" onmouseout="document.getElementById('del${all_post.post_id}').style.display='none'">
				<div class="reply_cadre" id="${all_post.post_id}">
			<div class="reply_attributes">
				<div class="reply_content">
					${all_post.content}
				</div>
				<div class="reply_author">
					— ${all_post.author}
				</div>
				</div>
			
			<div class="reply_vote_system">
				<div class="reply_up_vote"><a href="process_vote?id=${all_post.post_id}&vote=1">▲</a></div>
				<div class="reply_nb_votes">${all_post.votes}</div>
				<div class="reply_down_vote"><a href="process_vote?id=${all_post.post_id}&vote=-1">▼</a></div>
			</div>
		</div>
		<div class="del_reply">
		<a class="del_icon" id="del${all_post.post_id}" style="display: none;" onclick="confirmDelReply()"><img src="img/trash.png" height="15"/></a>
		<script>
		function confirmDelReply(){
			if (confirm("Are you sure you want to delete this comment? 😐"))
			{
				window.open("process_del_post?del=${all_post.post_id}","_self")
			}
		}
		</script>
		</div>
		</div>
			</c:if>
		</c:forEach>
		<c:if test="${rep==orig_post.post_id}">
		<div class="reply_form" id="reply">
			<form action="process_add_post" method="post">
   				<div class="form-row">
       				<div class="form-group col-md-2 mb-3">
           				<input name="author" type="text" class="form-control" placeholder="Pseudo" style="border-color: #007bff;" value='${author}'>
           			</div>
       				<div class="form-group col-md-9 mb-3">
               			<input name="content" type="text" class="form-control" placeholder="Insert here your content..."  value='${content}' style="border-color: #007bff;" required="required">
      				</div>
       				<div class="form-group col-md-1 mb-3">
  						<button type="submit" class="btn btn-primary" style="width: 100%;">Post</button>
       				</div>
  			 </div>
       <input type="hidden" name="reply_id" value="${rep}">
</form>
</div>
		</c:if>
		</div>
		</div>
	</c:if>  
	</c:forEach>      
</section>
</div>
</body>
</html>