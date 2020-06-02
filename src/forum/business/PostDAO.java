package forum.business;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class PostDAO {
	@PersistenceContext(unitName = "JeeditPU")

	private EntityManager em;
	public Post findByPostId(int post_id) {
		return em.find(Post.class,post_id);
	}
	
	public List<Post> findAll() {
		return em.createQuery( "SELECT p FROM Post p ORDER BY p.votes DESC", Post.class).getResultList();
	}
	
	public List<Post> findReplies(int post_id) {
		return em.createQuery( "SELECT p FROM Post p WHERE p.parent_id LIKE:param_id ORDER BY p.votes DESC", Post.class)
				.setParameter("param_id", post_id)
				.getResultList();
	}
	
	public Post findPost(int post_id) {
		return em.createQuery( "SELECT p FROM Post p WHERE p.post_id LIKE:param_id", Post.class)
				.setParameter("param_id", post_id)
				.getResultList().get(0);
	}
	
	public void updateVote(int post_id, int new_vote) {
		Post post = findPost(post_id);
		post.setVotes(new_vote);
		em.persist(post);
	}
	
	
	
	public void remove(int post_id) {
		Post post = em.find(Post.class, post_id);    
		if (post != null) {
			em.remove(post);
		List<Post> replies = findReplies(post_id);
		for(int i = 0; i<replies.size(); i++) {
			em.remove(replies.get(i));
		}
			
		}
	}
	

	public void create(String author, String title, String content, int parent_id) {
		Post post = new Post(author,title,content,parent_id);
		em.persist(post);
	}

}
