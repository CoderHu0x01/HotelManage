package com.scme.familyhotel.mainframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.scme.familyhotel.dao.GraphicsLeftDao;
import com.scme.familyhotel.daoimpl.GraphicsLeftImpl;
import com.scme.familyhotel.pojo.Guest;
import com.scme.familyhotel.pojo.Room;
import com.scme.familyhotel.result.JointModule;

/**
 * ============ 这是主界面左部 ============
 * 
 * @author 胡贵东
 * @version 1.3
 * @date 2017-5-16
 * 
 */

public class GraphicsLeft extends SystemGraphicsMain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JointModule jmName;
	private static JointModule jmDefu;
	private static JointModule jmPhone;
	private static JointModule jmAddress;
	private static JointModule jmEnter;
	private static JointModule jmMake;
	private static JointModule jmCash;
	private static JointModule jmMoney;

	private static JointModule jmSum;
	private static JointModule jmSeize;
	private static JointModule jmResidue;
	private static JointModule jmOrder;
	private static JointModule jmStop;

	private static JLabel labelSingle;

	static GraphicsLeftDao graphLeft = new GraphicsLeftImpl();

	public GraphicsLeft() {
		// 创建界面左部容器
		leftPanel = new JPanel(new BorderLayout());

		JLabel timeLabel = new JLabel();

		// 设置标签大小
		timeLabel.setPreferredSize(new Dimension(250, 30));

		leftPanel.setBorder(BorderFactory.createLineBorder(Color.green));

		timeLabel.setBorder(BorderFactory.createLineBorder(Color.yellow));

		// 在标签中显示时间
		// showDate(timeLabel);
		ShowDate.showDate(timeLabel);

		/**
		 * void setHorizontalAlignment(int alignment) 设置标签内容沿 X 轴的对齐方式
		 */
		// 让内容居中显示
		timeLabel.setHorizontalAlignment(JButton.CENTER);

		// 设置标签中文字颜色
		timeLabel.setForeground(Color.blue);

		leftPanel.add(timeLabel, BorderLayout.NORTH);

		// 左边部分界面-中间部分
		graphicsLeftC();

		// 左边部分界面-下部分
		graphicsLeftB();

	}

	// 左部界面-中部
	public void graphicsLeftC() {
		JPanel paneC = new JPanel(new BorderLayout());

		ImageIcon icoQuery = new ImageIcon("pic//b1.gif");
		ImageIcon icoNote = new ImageIcon("pic//b2.gif");

		// 创建标签化窗体
		JTabbedPane tabbedPaneC = new JTabbedPane(JTabbedPane.BOTTOM);

		JPanel tPaneQuery = new JPanel(new BorderLayout());
		JPanel tPaneNote = new JPanel();

		tPaneQuery.add(leftCQueryTop(), BorderLayout.NORTH);
		tPaneQuery.add(leftCQueryDown(), BorderLayout.SOUTH);

		tabbedPaneC.addTab("查询", icoQuery, tPaneQuery);
		tabbedPaneC.addTab("便签", icoNote, tPaneNote);

		paneC.setPreferredSize(new Dimension(100, 300));
		paneC.setBorder(BorderFactory.createLineBorder(Color.red));

		tabbedPaneC.setPreferredSize(new Dimension(250, 600));

		paneC.add(tabbedPaneC);
		leftPanel.add(paneC, BorderLayout.CENTER);

	}

	// 左部界面-下部
	public void graphicsLeftB() {
		JPanel paneB = new JPanel();

		paneB.setPreferredSize(new Dimension(200, 200));
		paneB.setBorder(BorderFactory.createLineBorder(Color.black));

		leftPanel.add(paneB, BorderLayout.SOUTH);

	}

	// 左部界面-"状态"中的上部分内容(标准单人间信息)
	public JPanel leftCQueryTop() {
		/**
		 * static Border createEmptyBorder(int top, int left, int bottom, int
		 * right) 创建一个占用空间但没有绘制的空边框，指定了顶线、底线、左边框线和右边框线的宽度。
		 */
		// "状态"中的上部分容器
		JPanel tPaneQueryTop = new JPanel(new GridLayout(9, 1));

		// 创建空白框
		// tPaneQueryTop.setBorder(BorderFactory.createEmptyBorder(10,20,10,10));

		labelSingle = new JLabel();
		labelSingle.setForeground(Color.red);
		labelSingle.setFont(new Font("宋体", 1, 18));

		// 按照房间编号查询
		// gji.findGuestNR(roomNo);

		// JLabel labelName=new JLabel("客户姓名:");
		jmName = new JointModule();
		JPanel labelName = jmName.jointlabel2("客户姓名:", null, new Dimension(100, 20), 0, 0, 0, 50);

		jmDefu = new JointModule();
		JPanel labelDefault = jmDefu.jointlabel2("预设单价:", null, new Dimension(100, 20), 0, 0, 0, 50);

		jmPhone = new JointModule();
		JPanel labelPhone = jmPhone.jointlabel2("客房电话:", null, new Dimension(100, 20), 0, 0, 0, 50);

		jmAddress = new JointModule();
		JPanel labelAddress = jmAddress.jointlabel2("所在区域:", null, new Dimension(100, 20), 0, 0, 0, 50);

		jmEnter = new JointModule();
		JPanel labelEnter = jmEnter.jointlabel2("进店时间:", null, new Dimension(100, 20), 0, 0, 0, 50);

		jmMake = new JointModule();
		JPanel labelMake = jmMake.jointlabel2("已用时间:", null, new Dimension(100, 20), 0, 0, 0, 50);

		jmCash = new JointModule();
		JPanel labelCash = jmCash.jointlabel2("已交押金:", null, new Dimension(100, 20), 0, 0, 0, 50);

		jmMoney = new JointModule();
		JPanel labelMoney = jmMoney.jointlabel2("应收金额:", null, new Dimension(100, 20), 0, 0, 0, 50);

		tPaneQueryTop.setPreferredSize(new Dimension(250, 300));

		tPaneQueryTop.add(labelSingle);
		tPaneQueryTop.add(labelName);
		tPaneQueryTop.add(labelDefault);
		tPaneQueryTop.add(labelPhone);
		tPaneQueryTop.add(labelAddress);
		tPaneQueryTop.add(labelEnter);
		tPaneQueryTop.add(labelMake);
		tPaneQueryTop.add(labelCash);
		tPaneQueryTop.add(labelMoney);

		return tPaneQueryTop;
	}

	// 左部界面-"状态"中的下部分内容(房间总状态信息)
	public JPanel leftCQueryDown() {
		// "状态"中的上部分容器
		JPanel tPaneQueryDown = new JPanel(new GridLayout(9, 1));

		JLabel labelRoomSta = new JLabel("房间总状态");
		labelRoomSta.setForeground(Color.red);
		labelRoomSta.setFont(new Font("宋体", 1, 18));

		jmSum = new JointModule();
		JPanel labelSum = jmSum.jointlabel2("房间总数:", null, new Dimension(100, 20), 0, 0, 0, 50);
		jmSum.setLabelText(graphLeft.queryLeftRoomAll() + "");

		jmSeize = new JointModule();
		JPanel labelSeize = jmSeize.jointlabel2("当前占用:", null, new Dimension(100, 20), 0, 0, 0, 50);
		jmSeize.setLabelText(graphLeft.roomCount("当前占用") + "");

		jmResidue = new JointModule();
		JPanel labelResidue = jmResidue.jointlabel2("当前可供:", null, new Dimension(100, 20), 0, 0, 0, 50);
		jmResidue.setLabelText(graphLeft.roomCount("当前可用") + "");

		jmOrder = new JointModule();
		JPanel labelOrder = jmOrder.jointlabel2("当前预订:", null, new Dimension(100, 20), 0, 0, 0, 50);
		jmOrder.setLabelText(graphLeft.roomCount("当前预订") + "");

		jmStop = new JointModule();
		JPanel labelStop = jmStop.jointlabel2("当前停用:", null, new Dimension(100, 20), 0, 0, 0, 50);
		jmStop.setLabelText(graphLeft.roomCount("当前停用") + "");

		tPaneQueryDown.setPreferredSize(new Dimension(250, 300));

		tPaneQueryDown.add(labelRoomSta);
		tPaneQueryDown.add(labelSum);
		tPaneQueryDown.add(labelSeize);
		tPaneQueryDown.add(labelResidue);
		tPaneQueryDown.add(labelOrder);
		tPaneQueryDown.add(labelStop);

		return tPaneQueryDown;
	}

	// 查询出上部信息
	public static void getORoo(String roomNo, String roomType) {
		ArrayList<Object> listR = graphLeft.findGuestNR(roomNo);
		System.out.println(roomNo + "----");

		labelSingle.setText(roomType + ":" + roomNo);

		if (listR.size() > 0) {
			Guest guestInfo = (Guest) listR.get(0);
			Room roomInfo = (Room) listR.get(1);

			jmName.setLabelText(guestInfo.getGuestName());
			jmDefu.setLabelText(roomInfo.getRoomPrice());
			jmAddress.setLabelText(roomInfo.getFloor() + "楼");
			jmPhone.setLabelText(roomInfo.getRoomPhone());
			jmCash.setLabelText(guestInfo.getRealCash() + "");
			jmMoney.setLabelText(roomInfo.getRoomPrice());

		} else {
			Room room = graphLeft.queryLeftRoomInfo(roomNo);
			jmDefu.setLabelText(room.getRoomPrice());
			jmAddress.setLabelText(room.getFloor() + "楼");
			jmPhone.setLabelText(room.getRoomPhone());
			jmName.setLabelText(null);
			jmCash.setLabelText(null);
			jmEnter.setLabelText(null);
		}

	}

	// 给进店时间组件赋值
	public static void addEnter(String expendTime) {

		if (!expendTime.equals(" ")) {
			jmEnter.setLabelText(expendTime);
		} else {
			jmEnter.setLabelText(null);
		}

		System.out.println(expendTime);
	}
}
