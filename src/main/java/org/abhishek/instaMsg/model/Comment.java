package org.abhishek.instaMsg.model;


public class Comment {

	private long id;
	private String comments;
	private String author;
	
	
	public Comment()
	{}
	
	public Comment(long id, String comment, String author) {
		super();
		this.id = id;
		this.comments = comment;
		this.author = author;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getComment() {
		return comments;
	}
	public void setComment(String comment) {
		this.comments = comment;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	
	
	
	
}
