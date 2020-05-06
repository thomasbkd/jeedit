package forum.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forum.business.BooksDAO;
import forum.business.Book;
import forum.business.Post;
import forum.business.PostDAO;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/welcome2")
public class Welcome2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private PostDAO postDAO;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcome2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/index.jsp";
		List<Post> posts = postDAO.findAll();
		request.setAttribute("posts", posts);

		getServletContext()
		.getRequestDispatcher(url).
		forward(request, response);
	}


}