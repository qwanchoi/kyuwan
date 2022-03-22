package com.edu.api;

public class Member {
    public String id;
    public String name;
    
    public Member(String id, String name) {
	this.id = id;
	this.name = name;
    }
    
    @Override
    public int hashCode() {
	return 1111;
    }
    
    @Override
    public boolean equals(Object obj) {
	if(obj instanceof Member) {
	    Member member = (Member) obj;
	    if(this.id.equals(member.id) 
		    && this.name.equals(member.name)) {
		return true;
	    }
	}
	
	return false;
    }
}
