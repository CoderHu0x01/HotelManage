package com.scme.familyhotel.dao;

import java.util.ArrayList;

import com.scme.familyhotel.pojo.User;

public interface UserDao {
	//µÇÂ¼
	public abstract User login(User user);
	
	//²éÕÒÓÃ»§
	public abstract ArrayList<User> findUser();
	
	
}
