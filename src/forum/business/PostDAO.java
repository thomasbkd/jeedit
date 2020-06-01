package forum.business;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
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
		return em.createQuery( "SELECT p FROM Post p ORDER BY p.votes DESC", Post.class).getResultList();
	}
	
	public List<Post> findPosts(long post_id) {
		return em.createQuery( "SELECT p FROM Post p WHERE p.parent_id LIKE:new_id  ORDER BY p.votes DESC", Post.class)
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
