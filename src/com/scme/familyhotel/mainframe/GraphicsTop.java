package com.scme.familyhotel.mainframe;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.scme.familyhotel.group.GraphicsGroupBilling;
import com.scme.familyhotel.group.GraphicsGroupBilling2;
import com.scme.familyhotel.guestscheckout.GraphicsCheckOut;
import com.scme.familyhotel.guestsreserve.GraphicsReserveCreate;
import com.scme.familyhotel.guestsreserve.GraphicsReserveMain;
import com.scme.familyhotel.individualbilling.GraphicsIndividual;
import com.scme.familyhotel.salesinquiries.SalesInquiries;
import com.scme.familyhotel.salesinquiries.SalesInquiries2;

/**
 * ============== 这是主界面顶部 =============
 * 
 * @author 胡贵东
 * @version 1.3
 * @date 2017-5-16
 * 
 */

public class GraphicsTop extends SystemGraphicsMain implements ActionListener {
	JButton individualButton;
	private JButton groupButton;
	private JButton checkoutButton;
	private JButton reseverButton;
	private JButton queryButton;
	private JButton manageButton;
	private JButton netSetButton;
	private JButton systemSetButton;
	private JButton aboutButton;
	private JButton exitButton;

	private static final long serialVersionUID = 1L;

	public GraphicsTop() {
		// 创建界面顶部容器
		topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		/**
		 * BorderFactory 提供标准 Border 对象的工厂类。在任何可能的地方， 此工厂类都将提供对已共享 Border 实例的引用
		 * 
		 * static Border createLineBorder(Color color) 创建一个具有指定颜色的线边框。
		 * 
		 */

		topPanel.setBorder(BorderFactory.createLineBorder(Color.red));

		// 封装图片
		ImageIcon individualIco = new ImageIcon("pic//ToolBar//m01.gif");
		ImageIcon groupIco = new ImageIcon("pic//ToolBar//m02.gif");
		ImageIcon checkoutIco = new ImageIcon("pic//ToolBar//m04.gif");
		ImageIcon reseverIco = new ImageIcon("pic//ToolBar//m05.gif");
		ImageIcon queryIco = new ImageIcon("pic//ToolBar//m06.gif");
		ImageIcon manageIco = new ImageIcon("pic//ToolBar//m07.gif");
		ImageIcon netSetIco = new ImageIcon("pic//ToolBar//m08.gif");
		ImageIcon systemSetIco = new ImageIcon("pic//ToolBar//m09.gif");
		ImageIcon aboutIco = new ImageIcon("pic//ToolBar//m03.gif");
		ImageIcon exitIco = new ImageIcon("pic//ToolBar//m10.gif");

		// 为功能按钮添加按钮及图片
		individualButton = new JButton("散客开单", individualIco);
		individualButton.addActionListener(this);

		groupButton = new JButton("团体开单", groupIco);
		groupButton.addActionListener(this);

		checkoutButton = new JButton("宾客结账", checkoutIco);
		checkoutButton.addActionListener(this);

		reseverButton = new JButton("客房预订", reseverIco);
		reseverButton.addActionListener(this);

		queryButton = new JButton("营业查询", queryIco);
		queryButton.addActionListener(this);
		
		manageButton = new JButton("客户管理", manageIco);
		manageButton.addActionListener(this);
		
		netSetButton = new JButton("网络设置", netSetIco);
		systemSetButton = new JButton("系统设置", systemSetIco);
		aboutButton = new JButton("关于我们", aboutIco);
		exitButton = new JButton("退出系统", exitIco);

		// 设置按钮中图片和文本位置
		textLocation(individualButton);

		textLocation(groupButton);

		textLocation(checkoutButton);

		textLocation(reseverButton);

		textLocation(queryButton);

		textLocation(manageButton);

		textLocation(netSetButton);

		textLocation(systemSetButton);

		textLocation(aboutButton);

		textLocation(exitButton);

		topPanel.add(individualButton);
		topPanel.add(groupButton);
		topPanel.add(checkoutButton);
		topPanel.add(reseverButton);
		topPanel.add(queryButton);
		topPanel.add(manageButton);
		topPanel.add(netSetButton);
		topPanel.add(systemSetButton);
		topPanel.add(aboutButton);
		topPanel.add(exitButton);

		// frame.add(topPanel, BorderLayout.NORTH);

	}

	// 设置按钮中图片和文本位置
	public static void textLocation(JButton button) {
		/**
		 * @param button
		 *            按钮
		 * 
		 *            void setVerticalTextPosition(int textPosition)
		 *            设置文本相对于图标的垂直位置。 void setHorizontalTextPosition(int
		 *            textPosition) 设置文本相对于图标的水平位置。
		 * 
		 *
		 */

		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setHorizontalTextPosition(JButton.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 为散客开单按钮添加事件
		if (e.getSource() == individualButton) {
			new GraphicsIndividual();
		}

		// 为团体开单按钮添加事件
		if (e.getSource() == groupButton) {
			new GraphicsGroupBilling().setVisible(true);
		}

		// 为宾客结账按钮添加事件
		if (e.getSource() == checkoutButton) {
			new GraphicsCheckOut().setVisible(true);
		}

		// 为客房预订按钮添加事件
		if (e.getSource() == reseverButton) {
			new GraphicsReserveMain().setVisible(true);
		}

		// 为营业查询按钮添加事件
		if (e.getSource() == queryButton) {
			new SalesInquiries().setVisible(true);
		}

		// 为客户管理按钮添加事件
		if (e.getSource() == manageButton) {

		}

	}

}
