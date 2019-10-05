package com.scme.familyhotel.mainframe;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.scme.familyhotel.result.FrameLocation;

/**
 * ==================== 这是主界面入口 ====================
 * 
 * @author 胡贵东
 * @version 1.3
 * @date 2017-5-16
 * 
 */
public class SystemGraphicsMain extends JFrame {

	private static final long serialVersionUID = 1L;

	// 顶部容器
	static JPanel topPanel;
	// 左部容器
	static JPanel leftPanel;
	// 中间容器
	static JPanel centerPanel;
	// 底部容器
	static JPanel bottomPanel;

	public void graphicsMain() {
		setLayout(new BorderLayout());
		setSize(1920, 1080);
		setTitle("Family酒店管理系统 ——Beta1.3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 界面顶部(构造中初始化)
		GraphicsTop top = new GraphicsTop();
		// 将顶部界面容器中添加到窗体中
		add(topPanel, BorderLayout.NORTH);

		// 界面左部
		GraphicsLeft left = new GraphicsLeft();
		add(leftPanel, BorderLayout.WEST);

		// 界面中部
		GraphicsCenter center = new GraphicsCenter();
		add(centerPanel, BorderLayout.CENTER);

		// 界面底部
		GraphicsBottom bottom = new GraphicsBottom();
		add(bottomPanel, BorderLayout.SOUTH);

		setVisible(true);
		// 设置窗体显示并添加标题图标
		FrameLocation.frameLocation(this, "pic//u01.gif");
	}

	public void lostFou() {
		setFocusable(false);
	}

	/*
	 * public static void main(String[] args) { SystemGraphicsMain sg = new
	 * SystemGraphicsMain(); sg.graphicsMain(); }
	 */
}
