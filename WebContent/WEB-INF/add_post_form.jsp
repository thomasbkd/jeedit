<h3 style="text-align: center;"><a href="redirect_add_post" class="form_link">Add a new post</a></h3>

<form action="process_add_post" method="post">
   <div class="form-row">
       <div class="form-group col-md-3 mb-3">
           <input name="author" type="text" class="form-control" placeholder="Pseudo"  value='${author}'>
           
       </div>
       <div class="form-group col-md-7 mb-3">
               <input name="title" type="text" class="form-control" placeholder="Write here a short title for your post"  value='${title}' required="required">
       </div>
       <div class="form-group col-md-2 mb-3">
  			<button type="submit" class="btn btn-danger" style="width: 100%;">Post</button>
       </div>
   </div>
   <div class="form-group">
       <div class="form-group col-md-12 mb-6">
           <div class="input-group">
           	   <textarea name="content" type="text" class="form-control" style="height: 100px;" placeholder="Please tell us a funny story..." value='${content}' required="required"></textarea>
           </div>
       </div>
   </div>
       
       <input type="hidden" name="reply_id" value="0">
</form>