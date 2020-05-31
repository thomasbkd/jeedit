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
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Process_add_post() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "welcome";
//		String error = new String();
		
		//String post_id = request.getParameter("post_id");
		String post_author = request.getParameter("author");
		String post_title = request.getParameter("title");
		String post_content = request.getParameter("content");
		int parent_id;
		try {
			parent_id = Integer.parseInt(request.getParameter("reply_parent_id_bis"));
		} catch (NumberFormatException ex) {
			parent_id = 0;
		}
		
		postDAO.create(post_author, post_title,post_content, parent_id);
		response.sendRedirect(url);
	}

}



