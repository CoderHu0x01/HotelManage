package com.scme.familyhotel.mainframe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 这是主界面底部
 * 
 * @author 胡贵东
 * @version 1.3
 * @date 2017-5-16
 * 
 */

public class GraphicsBottom extends SystemGraphicsMain {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GraphicsBottom(){
		// 创建界面底部容器
				bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

				JLabel nameLabel = new JLabel("Family酒店管理系统");
				JLabel primptLabel = new JLabel("提示：请选择功能项");
				JLabel sysInfoLabel = new JLabel("当前操作界面:Family酒店管理系统——beta版");
				JLabel adminInfoLabel = new JLabel("当前操作员:Admin");

				/**
				 * void setPreferredSize(Dimension preferredSize) 设置此组件的首选大小。
				 * (在有布局管理器中调整组件大小)
				 */

				bottomPanel.setBorder(BorderFactory.createLineBorder(Color.blue));

				nameLabel.setBorder(BorderFactory.createLineBorder(Color.red));
				nameLabel.setPreferredSize(new Dimension(250, 30));

				// nameLabel.setHorizontalAlignment(JButton.CENTER);

				primptLabel.setBorder(BorderFactory.createLineBorder(Color.red));
				primptLabel.setPreferredSize(new Dimension(400, 30));
				// primptLabel.setHorizontalAlignment(JButton.CENTER);

				sysInfoLabel.setBorder(BorderFactory.createLineBorder(Color.red));
				sysInfoLabel.setPreferredSize(new Dimension(350, 30));
				// sysInfoLabel.setHorizontalAlignment(JButton.CENTER);

				adminInfoLabel.setBorder(BorderFactory.createLineBorder(Color.red));
				adminInfoLabel.setPreferredSize(new Dimension(300, 30));
				// adminInfoLabel.setHorizontalAlignment(JButton.CENTER);

				bottomPanel.add(nameLabel);
				bottomPanel.add(primptLabel);
				bottomPanel.add(sysInfoLabel);
				bottomPanel.add(adminInfoLabel);

	}
}
