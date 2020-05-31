package forum.business;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class PostDAO {
	@PersistenceContext(unitName = "JeeditPU")

	private EntityManager em;
	public Post findByPostId(long post_id) {
		return em.find(Post.class,post_id);
	}
	
	public List<Post> findAll() {
		return em.createQuery( "SELECT p FROM Post p", Post.class).getResultList();
	}
	
	public List<Post> findReply(long post_id) {
		return em.createQuery( "SELECT t FROM Post t WHERE t.parent_id LIKE:new_id ", Post.class)
				.setParameter("new_id", post_id)
				.getResultList();
	}
	
	public void remove(long post_id) {
		Post post = em.find(Post.class, post_id);    
		if (post != null) {
			em.remove(post);      
		}
	}
	

	public void create(String author, String title, String content, int parent_id) {
		Post post = new Post(author,title,content,parent_id);
		em.persist(post);
	}

}
