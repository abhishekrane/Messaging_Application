package org.abhishek.instaMsg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.abhishek.instaMsg.database.DatabaseClass;

import org.abhishek.instaMsg.model.Profile;

public class ProfileServices {
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileServices() {
    profiles.put("Abhi123", new Profile (1l,"Abhi123","Abhi","Rane"));
    profiles.put("Rane456", new Profile (2l,"Rane456","Abhishek","Pandurang"));
 	}

	public  List<Profile> getAllProfiles() {
		return new ArrayList<Profile> (profiles.values());
	}
	
	
	public Profile getProfileByName(String name)
	{
		return profiles.get(name);
	}
	
	public Profile addProfileByName(Profile profile)
	{
		return profiles.put(profile.getProfileName(), profile);
	}
	
	public Profile updateProfileByName(Profile profile)
	{
		if(profile.getProfileName().isEmpty())
			return null;
		return profiles.put(profile.getProfileName(), profile);
	}
	
	public Profile deleteProfileByName(String name)
	{
		return profiles.remove(name);
	}
	
	
}
