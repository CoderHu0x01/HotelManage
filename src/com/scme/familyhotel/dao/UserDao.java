package com.scme.familyhotel.dao;

import java.util.ArrayList;

import com.scme.familyhotel.pojo.User;

public interface UserDao {
	//��¼
	public abstract User login(User user);
	
	//�����û�
	public abstract ArrayList<User> findUser();
	
	
}
