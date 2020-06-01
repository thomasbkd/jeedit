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

/**
 * Servlet implementation class Process_vote
 */
@WebServlet("/process_vote")
public class Process_vote extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private PostDAO postDAO;



    public Process_vote() {
        super();
    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/jeedit/welcome";
		int id = Integer.parseInt(request.getParameter("id"));
		int vote = Integer.parseInt(request.getParameter("vote"));
		Post post = postDAO.findPost(id);
		int new_vote = post.getVotes()+vote;
		if(new_vote < 0) new_vote = 0;
		postDAO.updateVote(id, new_vote);	
		
		response.sendRedirect(url+"#"+id);


	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
