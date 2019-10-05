package com.scme.familyhotel.result;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * ============================= 这是设置JFrame窗体位置的模块 =============================
 * 
 * @author 胡贵东
 * @version 1.0
 * @date 2017-4-29
 * 
 */
public class FrameLocation {
	/**
	 * @param frame
	 *            JFrame窗体
	 */

	// 设置当前窗体显示位置及窗体图标
	public static void frameLocation(JFrame frame, String titleIco) {
		// 获取窗体的大小
		Dimension frameSize = frame.getSize();

		// 获取默认工具包
		Toolkit tool = Toolkit.getDefaultToolkit();

		// 设置标题图标
		Image image = tool.getImage(titleIco);
		frame.setIconImage(image);

		// 通过工具包获取当前显示屏的大小
		Dimension screenSize = tool.getScreenSize();

		// 让Frame窗体居中显示
		frame.setLocation(screenSize.width / 2 - frameSize.width / 2, screenSize.height / 2 - frameSize.height / 2);

		// //添加监听窗口关闭事件
		// frame.addWindowListener(new WindowAdapter() {
		// @Override
		// public void windowClosing(WindowEvent e) {
		// System.exit(0);
		// }
		// });

		//frame.setVisible(true);
	}

}
