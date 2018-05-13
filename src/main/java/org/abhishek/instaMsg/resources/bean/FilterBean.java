package org.abhishek.instaMsg.resources.bean;

import javax.ws.rs.QueryParam;

public class FilterBean {

	private @QueryParam("start") int start;
	private @QueryParam ("size") int size ;
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
	
	
	
}
