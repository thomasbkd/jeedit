package forum.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import forum.business.Post;
import forum.business.PostDAO;


@WebServlet("/Add_post")
public class Add_post extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private PostDAO postDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_post() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "welcome";
		
		String post_id = request.getParameter("post_id");
		String post_author = request.getParameter("author");
		String post_title = request.getParameter("title");
		String post_content = request.getParameter("content");
		
		
		
		
//		Book book1 = new Book(book_isbn, book_title, price);
//		booksDAO.add(book1);
		
		postDAO.create(post_id, post_author, post_title,post_content);
		response.sendRedirect(url);
		/*
			It's up to you
		*/
	}

}



