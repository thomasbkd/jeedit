package forum.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import forum.business.Post;
import forum.business.PostDAO;


@WebServlet("/process_add_post")
public class Process_add_post extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private PostDAO postDAO;

    public Process_add_post() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/jeedit/welcome";
//		String error = new String();
		request.setCharacterEncoding("UTF-8");
		//String post_id = request.getParameter("post_id");
		String post_author = request.getParameter("author");
		if(post_author.contentEquals("")) post_author = "Anonymous";
		String post_title = request.getParameter("title");
		String post_content = request.getParameter("content");
		int parent_id = Integer.parseInt(request.getParameter("reply_id"));
		/* try {
			parent_id = Integer.parseInt(request.getParameter("reply_id"));
		} catch (NumberFormatException ex) {
			parent_id = 0;
		} */
		
		postDAO.create(post_author, post_title,post_content, parent_id);
		response.sendRedirect(url);
	}

}



