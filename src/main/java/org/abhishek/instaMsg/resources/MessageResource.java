package org.abhishek.instaMsg.resources;



import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.abhishek.instaMsg.model.Message;
import org.abhishek.instaMsg.resources.bean.FilterBean;
import org.abhishek.instaMsg.service.MessageServices;

import com.sun.research.ws.wadl.Param;
@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {
	MessageServices messageService = new MessageServices();
	
	
	@GET
	public List<Message> getMessages(@BeanParam FilterBean filterbean )
			
	{    if (filterbean.getStart() >0 && filterbean.getSize() >0)
	    {
		return  messageService.getAllMessagesPaginated(filterbean.getStart(), filterbean.getSize());
	     }
	else return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessagebyID(@PathParam("messageId") long messageID)
	{
		Message message = messageService.getMessage(messageID);
		message.getComments();
		return message;
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessageID(@PathParam(value = "messageId") long id, Message message)
	{   message.setId(id);
		return messageService.updateMessage(message);
		
	}
	
	@POST
	public Message addMessage(Message message)
	{
		return messageService.addMessage(message);
		
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam(value = "messageId") long id, Message message)
	{    message.setId(id);
		 messageService.removeMessage(id);
		
	}
	

	@Path("/{messageId}/comments")
	public CommentResource getCommentResource()
	{
		return new CommentResource();
	}
	
	
}
