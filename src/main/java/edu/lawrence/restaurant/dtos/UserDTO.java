package edu.lawrence.restaurant.dtos;

import edu.lawrence.restaurant.entities.User;

public class UserDTO {
	private String userid;
	private String name;
	private String password;
	
	public UserDTO() {}
	public UserDTO(User core) {
    	userid = core.getUserid().toString();
		name = core.getName();
		password = core.getPassword();
    }


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserid() {
	        return userid;
	    }

	public void setUserid(String userid) {
	        this.userid = userid;
	    }
}
