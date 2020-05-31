package forum.business;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Post")
public class Post implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "post_id")
	private int post_id;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "post_type")
	private String post_type;
	
	@Column(name = "post_date")
	private Date post_date;
	
	@Column(name = "parent")
	private int parent;
	
	@Column(name = "votes")
	private int votes;
	

	public Post() {
//		this.post_id = "";
		this.author = "";
		this.title = "";
		this.content = "";
		this.post_type = "text";
		this.post_date = (Date) null;
		this.parent = 0;
		this.votes = 0;
		
	}

	public Post(String author, String title, String content, int parent) {
//		this.post_id = post_id;
		this.author = author;
		this.title = title;
		this.content = content;
		this.post_type = "text"; //à modifier en fonction de content
		this.post_date = (Date) null;
		this.parent = parent;
		this.votes = 0;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPost_type() {
		return post_type;
	}

	public void setPost_type(String post_type) {
		this.post_type = post_type;
	}

	public Date getPost_date() {
		return post_date;
	}

	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	
}
