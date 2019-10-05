package com.scme.familyhotel.login;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import com.scme.familyhotel.dao.UserDao;
import com.scme.familyhotel.daoimpl.UserDaoImpl;
import com.scme.familyhotel.pojo.User;


/**
 * ============================== 这是登录功能模块 ==============================
 * 
 * @author 胡贵东
 * @version 1.0
 * @date 2017-4-29
 * 
 */

public class Login {
	private UserDao userDaoImpl = new UserDaoImpl();
	private static User user;

	public boolean checkLogin(JComboBox<String> combo, JPasswordField passField, JLabel labelPrompt) {

		/**
		 * @param combo
		 *            下拉框
		 * 
		 * @param passField
		 *            密码框
		 * 
		 * @param labelPrompt
		 *            提示标签
		 * 
		 *            Object getSelectedItem() {} 返回下拉框当前所选项。
		 */
		user = new User();

		// 获取密码框中的密码
		user.setPassword(String.valueOf(passField.getPassword()));
		//获取下拉框中用户名
		user.setUserName((String) combo.getSelectedItem());

		// 验证用户
		User checkUser = userDaoImpl.login(user);
		if (checkUser != null) {
			System.out.println("登录成功");
			labelPrompt.setText("提示：登录成功");
			// SystemGraphicsMain.gramphicsMain();
			return true;
		} else {
			System.out.println("用户名或者密码错误！");
			labelPrompt.setText("提示：用户名或者密码错误！");
			return false;
		}

	}
	
	//返回当前登录者
	public static String getLoginUser(){
		return user.getUserName();
	}
}
