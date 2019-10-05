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
 * ============== 这是系统登录的图形界面==============
 * 
 * @author 胡贵东
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

	// 创建Label标签
	JLabel labelIco;
	JLabel labelUser;
	JLabel labelPass;
	JLabel labelPrompt;

	// 下拉框
	JComboBox<String> combo;
	// 创建密码输入框
	JPasswordField passFields;

	// 创建按钮
	JButton buttonLogin;
	JButton buttonExit;

	public LoginGraphics() {
		setTitle("系统登录");
		// 设置布局
		setLayout(null);
		// 设置窗体宽高
		setSize(400, 330);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//初始化界面组件
		loginFrameInit();
		
		//让窗体居中显示
		FrameLocation.frameLocation(this,"pic//u01.gif");
	}
	
	public void loginFrameInit(){
		// 封装图片
				ImageIcon ico = new ImageIcon("pic//Login_top.gif");
				ImageIcon LoginIco = new ImageIcon("pic//key.gif");
				ImageIcon exitIco = new ImageIcon("pic//exit.gif");

				labelIco = new JLabel();
				labelUser = new JLabel("账号");
				labelPass = new JLabel("密码");
				labelPrompt = new JLabel("提示：请输入登录名密码！");
				combo = new JComboBox<String>();
				passFields = new JPasswordField(null);
				buttonLogin = new JButton("登录", LoginIco);
				buttonExit = new JButton("退出", exitIco);
				
				labelIco.setBounds(15, 0, 450, 50);
				labelIco.setIcon(ico);

				labelUser.setBounds(50, 80, 50, 50);
				labelPass.setBounds(50, 130, 50, 50);
				labelPrompt.setBounds(50, 240, 200, 50);
				// 设置标签内字体颜色
				labelPrompt.setForeground(Color.red);

				combo.setBounds(120, 90, 200, 30);

				// 获取数据库中的用户
				ArrayList<User> findUser = userDaoImpl.findUser();
				for (User fu : findUser) {
					combo.addItem(fu.getUserName());
				}

				passFields.setBounds(120, 140, 200, 30);
				// 添加鼠标点击事件
				passFields.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						passFields.setText(null);
						labelPrompt.setText("提示：请输入登录名密码！");
					}
				});

				buttonLogin.setBounds(120, 190, 85, 30);

				// 按钮监听事件,处理等你事件
				buttonLogin.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// 创建登录功能对象
						Login login = new Login();
						// 登录
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
				
				// 添加输入框
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
