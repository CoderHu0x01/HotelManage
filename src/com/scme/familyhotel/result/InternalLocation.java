package com.scme.familyhotel.result;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * ======================================
 * 这是设置JInternalFrame内部窗体位置的模块
 * ======================================
 * 
 * @author 胡贵东
 * @version	1.0
 * @date 2017-5-8
 * 
 */

import javax.swing.JInternalFrame;

public class InternalLocation {
	/**
	 * 
	 * @param indInterFrame
	 *            内部框架容器
	 */

	// 让JInternalFrame窗体框架居中显示
	public static void internalLocation(JInternalFrame indInterFrame) {
		// 获取JInternalFrame窗体框架大小
		Dimension internalSize = indInterFrame.getSize();

		// 获取默认开发工具包
		Toolkit tool = Toolkit.getDefaultToolkit();

		// 获取当前窗体大小
		Dimension screenSize = tool.getScreenSize();

		// 让JInternalFrame窗体框架居中
		indInterFrame.setLocation(screenSize.width / 2 - internalSize.width / 2,
				screenSize.height / 2 - internalSize.height / 2);

	}
}
