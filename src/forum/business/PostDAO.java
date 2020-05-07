package forum.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import forum.business.Post;

@Stateless
public class PostDAO {
	@PersistenceContext(unitName = "JeeditPU")
	private EntityManager em;
	
//	public Book findById(int id) {
//		/*
//		return em.createQuery( "SELECT t FROM Task t WHERE t.id LIKE:new_id", Task.class)
//		.setParameter("new_id", id)
//		.getSingleResult();
//		*/
//		return em.find(Book.class,id);
//		
//	}
	
	public Post findByPostId(String post_id) {
		
		return em.find(Post.class,post_id);
		
	}
	
	public List<Post> findAll() {
		return em.createQuery( "SELECT t FROM Post t", Post.class).getResultList();
	}
	
	public void remove(String post_id) {
		Post post = em.find(Post.class, post_id);    
		if (post != null) {
			em.remove(post);      
		}
	}
	
//	public void add(Book book) {
//			//em.createQuery( "INSERT INTO Task (Task.id,Task.taskName)VALUES (task.id,task.taskName)");
//		em.persist(book);
//	}
	
	public void create(String post_id,String author, String title, String content) {
		Post post1 = new Post(post_id,author,title,content);
		//em.createQuery( "INSERT INTO Task (Task.id,Task.taskName)VALUES (task.id,task.taskName)");
		em.persist(post1);
	}

}
