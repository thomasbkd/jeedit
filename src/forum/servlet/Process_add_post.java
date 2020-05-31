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
		
//		if (post_id.isEmpty() || post_author.isEmpty() || post_title.isEmpty() || post_content.isEmpty()) {
//			error = "Fill in all the fields of this form";
//		}
		
		
//		Book book1 = new Book(book_isbn, book_title, price);
//		booksDAO.add(book1);
		Post p1 = new Post(post_author, post_title,post_content,0);
		postDAO.create(p1);
		response.sendRedirect(url);
		/*
			It's up to you
		*/
	}

}



