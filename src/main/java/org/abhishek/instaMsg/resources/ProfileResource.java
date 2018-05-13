package org.abhishek.instaMsg.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.abhishek.instaMsg.model.Profile;
import org.abhishek.instaMsg.service.ProfileServices;
@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	ProfileServices profiles = new ProfileServices();
	
	@GET
	public List<Profile> getAllProfiles()
	{
		return  profiles.getAllProfiles();
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String name )
	{
		return  profiles.getProfileByName(name);
	}
	
	@POST
	public Profile addProfile(Profile profile)
	{
		return profiles.addProfileByName(profile);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String name, Profile profile)
	{    profile.setProfileName(name);
		return profiles.updateProfileByName(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public void removeProfile(@PathParam("profileName") String profileName, Profile profile)
	{    profile.setProfileName(profileName);
	     profiles.deleteProfileByName(profileName);
	}
	
	
	

}

