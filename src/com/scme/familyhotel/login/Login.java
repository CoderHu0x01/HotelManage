package com.scme.familyhotel.login;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import com.scme.familyhotel.dao.UserDao;
import com.scme.familyhotel.daoimpl.UserDaoImpl;
import com.scme.familyhotel.pojo.User;


/**
 * ============================== ���ǵ�¼����ģ�� ==============================
 * 
 * @author ����
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
		 *            ������
		 * 
		 * @param passField
		 *            �����
		 * 
		 * @param labelPrompt
		 *            ��ʾ��ǩ
		 * 
		 *            Object getSelectedItem() {} ����������ǰ��ѡ�
		 */
		user = new User();

		// ��ȡ������е�����
		user.setPassword(String.valueOf(passField.getPassword()));
		//��ȡ���������û���
		user.setUserName((String) combo.getSelectedItem());

		// ��֤�û�
		User checkUser = userDaoImpl.login(user);
		if (checkUser != null) {
			System.out.println("��¼�ɹ�");
			labelPrompt.setText("��ʾ����¼�ɹ�");
			// SystemGraphicsMain.gramphicsMain();
			return true;
		} else {
			System.out.println("�û��������������");
			labelPrompt.setText("��ʾ���û��������������");
			return false;
		}

	}
	
	//���ص�ǰ��¼��
	public static String getLoginUser(){
		return user.getUserName();
	}
}
