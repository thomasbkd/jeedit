package forum.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forum.business.PostDAO;

/**
 * Servlet implementation class Process_del_post
 */
@WebServlet("/process_del_post")
public class Process_del_post extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private PostDAO postDAO;


	public Process_del_post() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/jeedit/welcome";
		int del = Integer.parseInt(request.getParameter("del"));
		postDAO.remove(del);
		
		response.sendRedirect(url);
	}


}
