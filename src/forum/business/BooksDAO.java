package forum.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import forum.business.Book;

@Stateless
public class BooksDAO {
	@PersistenceContext(unitName = "BookstorePU")
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
	public Book findByIsbn(String isbn) {
		
		return em.find(Book.class,isbn);
		
	}
	
	public List<Book> findAll() {
		return em.createQuery( "SELECT t FROM Book t", Book.class).getResultList();
	}
	
	public void remove(String isbn) {
		Book book = em.find(Book.class, isbn);    
		if (book != null) {
			em.remove(book);      
		}
	}
	
//	public void add(Book book) {
//			//em.createQuery( "INSERT INTO Task (Task.id,Task.taskName)VALUES (task.id,task.taskName)");
//		em.persist(book);
//	}
	
	public void create(String isbn, String title, double price) {
		Book book1 = new Book(isbn,title,price);
		//em.createQuery( "INSERT INTO Task (Task.id,Task.taskName)VALUES (task.id,task.taskName)");
		em.persist(book1);
	}

}
