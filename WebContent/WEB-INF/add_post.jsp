<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <%@include file="header.jsp"%>
    <title>Add post</title>
</head>
<body>
    <div class="grid-container">
        <div class="grid-x grid-padding-x">
            <div class="large-12 cell">
                <h2>Jeedit v0.1</h2>
                <h3>Add a new post</h3>
<%--                 <c:if test="${not empty error}"> --%>
<!--                 	<div class="alert callout" aria-live="assertive" role="alert" style="display: block;"> -->
<%--     				<p><c:out value='${error}'></c:out></p> --%>
<!--   					</div> -->
<%--   				</c:if> --%>
  				
                <form action="process_add_post" method="post">
                    <div class="row">
<!--                         <div class="medium-6 cell"> -->
<!--                             <label>ID -->
<%--                                 <input name="post_id" type="text" placeholder="222XXXX" value='${post_id}'> --%>
<!--                             </label> -->
<!--                         </div> -->
                        <div class="medium-6  cell">
                            <label>Title
                                <input name="title" type="text" placeholder="What did you learn today ?" value='${title}'>
                            </label>
                            
                        </div>
                        <div class="medium-6  cell">
                            <label>Author
                                <input name="author" type="text" placeholder="Amandine_du_38"  value='${author}'>
                            </label>
                        </div>
                        <div class="medium-6  cell">
                            <div class="input-group">
                            	<label>Content
                            		<input name="content" type="text" value='${content}'>
                            	</label>
                            </div>
                        </div>
                        <input type="submit" class="button" value="Submit">
                    </div>
                </form>
            </div>
        </div>
    </div>
    
</body>
</html>