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


@WebServlet("/redirect_add_post")
public class Redirect_add_post extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String urlJSP = "/WEB-INF/add_post.jsp";
    
	@EJB
	private PostDAO postDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Redirect_add_post() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().
		getRequestDispatcher(urlJSP).
		forward(request, response);
	}

}



