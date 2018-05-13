package org.abhishek.instaMsg.service;

import java.util.*;

import org.abhishek.instaMsg.database.DatabaseClass;
import org.abhishek.instaMsg.model.Comment;
import org.abhishek.instaMsg.model.Message;

public class CommentServices {

	

	private Map<Long,Message> messages  = DatabaseClass.getMessages();
	private Map<Long, Comment> comments = DatabaseClass.getComments();
	
	public List<Comment> getAllComments(long messageId)
	{
		
		Map<Long,Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
		
	}
	
	public Comment getComments(long messageId, long commentID)
	{
		Map<Long,Comment> comments = messages.get(messageId).getComments();
		return comments.get(commentID);
	}
	public Comment updateComment(long messageId, Comment comment ) {
		Map<Long,Comment> comments = messages.get(messageId).getComments();
		if (comment.getId() <= 0) {
			return null;
		}
		
		comments.put(comment.getId(), comment);
		return comment;
	}
	public Comment addComment(long messageId, Comment comment) {
		Map<Long,Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public void removeMessage (long messageId, long commentId) {
		Map<Long,Comment> comments = messages.get(messageId).getComments();
		comments.remove(commentId);
		
	}

	public Map<Long, Comment> getComments() {
		return comments;
	}

	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}
	
	
	
	
	
	
}
