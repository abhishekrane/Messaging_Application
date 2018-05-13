package org.abhishek.instaMsg.resources;

import java.util.List;
import java.util.Map;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.abhishek.instaMsg.model.Comment;
import org.abhishek.instaMsg.service.CommentServices;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {
    CommentServices commentServices = new CommentServices();

	
	@POST
	public Comment addnewComment(@PathParam ("messageId") long messageId,Comment comment) {
		return commentServices.addComment(messageId, comment);
	}
	@GET
	public List<Comment> getAllComment(@PathParam ("messageId") long messageId)
	{
		return commentServices.getAllComments(messageId);
		
	}
	@GET
	@Path("/{commentId}")
	public Comment getComment(@PathParam ("messageId") long messageId,@PathParam ("commentId") long commentId)
	{
		return commentServices.getComments(messageId, commentId);
	}
	
	@PUT
	@Path("/{commentId}")
	public Comment update(@PathParam ("messageId") long messageId, Comment comment)
	{
		return commentServices.updateComment(messageId, comment);
	}
	
	@DELETE
	@Path("/{commentId}")
	public void delete(@PathParam ("messageId") long messageId,@PathParam ("commentId") long commentId)
	{
		 commentServices.removeMessage(messageId, commentId);
	}
	
	
	
	
	
	
}
