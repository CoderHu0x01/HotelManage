package com.scme.familyhotel.login;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import com.scme.familyhotel.dao.UserDao;
import com.scme.familyhotel.daoimpl.UserDaoImpl;
import com.scme.familyhotel.mainframe.SystemGraphicsMain;
import com.scme.familyhotel.pojo.User;
import com.scme.familyhotel.result.FrameLocation;



/**
 * ============== ����ϵͳ��¼��ͼ�ν���==============
 * 
 * @author ����
 * @version 1.0
 * @date 2017-4-29
 * 
 */

public class LoginGraphics extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserDao userDaoImpl = new UserDaoImpl();

	// ����Label��ǩ
	JLabel labelIco;
	JLabel labelUser;
	JLabel labelPass;
	JLabel labelPrompt;

	// ������
	JComboBox<String> combo;
	// �������������
	JPasswordField passFields;

	// ������ť
	JButton buttonLogin;
	JButton buttonExit;

	public LoginGraphics() {
		setTitle("ϵͳ��¼");
		// ���ò���
		setLayout(null);
		// ���ô�����
		setSize(400, 330);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//��ʼ���������
		loginFrameInit();
		
		//�ô��������ʾ
		FrameLocation.frameLocation(this,"pic//u01.gif");
	}
	
	public void loginFrameInit(){
		// ��װͼƬ
				ImageIcon ico = new ImageIcon("pic//Login_top.gif");
				ImageIcon LoginIco = new ImageIcon("pic//key.gif");
				ImageIcon exitIco = new ImageIcon("pic//exit.gif");

				labelIco = new JLabel();
				labelUser = new JLabel("�˺�");
				labelPass = new JLabel("����");
				labelPrompt = new JLabel("��ʾ���������¼�����룡");
				combo = new JComboBox<String>();
				passFields = new JPasswordField(null);
				buttonLogin = new JButton("��¼", LoginIco);
				buttonExit = new JButton("�˳�", exitIco);
				
				labelIco.setBounds(15, 0, 450, 50);
				labelIco.setIcon(ico);

				labelUser.setBounds(50, 80, 50, 50);
				labelPass.setBounds(50, 130, 50, 50);
				labelPrompt.setBounds(50, 240, 200, 50);
				// ���ñ�ǩ��������ɫ
				labelPrompt.setForeground(Color.red);

				combo.setBounds(120, 90, 200, 30);

				// ��ȡ���ݿ��е��û�
				ArrayList<User> findUser = userDaoImpl.findUser();
				for (User fu : findUser) {
					combo.addItem(fu.getUserName());
				}

				passFields.setBounds(120, 140, 200, 30);
				// ���������¼�
				passFields.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						passFields.setText(null);
						labelPrompt.setText("��ʾ���������¼�����룡");
					}
				});

				buttonLogin.setBounds(120, 190, 85, 30);

				// ��ť�����¼�,��������¼�
				buttonLogin.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// ������¼���ܶ���
						Login login = new Login();
						// ��¼
						boolean flag = login.checkLogin(combo, passFields, labelPrompt);
						if (flag) {
							setVisible(false);
							dispose();
							SystemGraphicsMain main = new SystemGraphicsMain();
							main.graphicsMain();
						}

					}
				});

				buttonExit.setBounds(260, 190, 85, 30);
				
				// ��������
				add(labelIco);
				add(labelUser);
				add(labelPass);
				add(labelPrompt);
				add(combo);
				add(passFields);

				add(buttonLogin);
				add(buttonExit);
	}

}
