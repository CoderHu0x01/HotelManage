package com.scme.familyhotel.mainframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.scme.familyhotel.daoimpl.RoomInfoImpl;
import com.scme.familyhotel.group.GraphicsGroupBilling;
import com.scme.familyhotel.guestscheckout.GraphicsCheckOut;
import com.scme.familyhotel.individualbilling.GraphicsIndividual;
import com.scme.familyhotel.pojo.Bill;
import com.scme.familyhotel.pojo.Room;

/**
 * ===================== 这是主界面中部 =====================
 * 
 * @author 胡贵东
 * @version 1.3
 * @date 2017-5-16
 * 
 */

public class GraphicsCenter extends SystemGraphicsMain {
	// 标准单人间按钮容器
	JPanel panelBD;
	// 标准双人间按钮容器
	JPanel panelBS;
	// 豪华单人间按钮容器
	JPanel panelHD;
	// 豪华双人间按钮容器
	JPanel panelHS;
	// 商务套房按钮容器
	JPanel panelSW;
	// 总统套房按钮容器
	JPanel panelZT;

	ArrayList<Room> listBDRoom;
	ArrayList<Room> listBSRoom;
	ArrayList<Room> listHDRoom;
	ArrayList<Room> listHSRoom;
	ArrayList<Room> listSWRoom;
	ArrayList<Room> listZTRoom;

	// 标准单人间
	JScrollPane scrollPaneSingle;
	// 标准双人间
	JScrollPane scrollPaneDouble;
	// 豪华单人间
	JScrollPane scrollPaneLuxOne;
	// 豪华双人间
	JScrollPane scrollPaneLuxTwo;
	// 商务套房
	JScrollPane scrollPaneCommerce;
	// 总统套房
	JScrollPane scrollPanePres;

	JTabbedPane tabbedPane;

	private static final long serialVersionUID = 1L;

	private DefaultTableModel tabelModel;
	// 房间信息的JDBC对象
	RoomInfoImpl roomJdbc = new RoomInfoImpl();

	public GraphicsCenter() {
		/**
		 * void setPreferredSize(Dimension preferredSize) 设置此组件的首选大小。
		 * (在有布局管理器中调整组件大小)
		 *
		 * 
		 * JScrollPane(Component view) 创建一个显示指定组件内容的
		 * JScrollPane，只要组件的内容超过视图大小就会显示水平和垂直滚动条
		 */

		// 创建中间界面总容器
		centerPanel = new JPanel(new BorderLayout());

		// 创建一个标签化窗口
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		// 标准单人间
		panelBD = new JPanel(new FlowLayout(FlowLayout.LEFT, 60, 60));
		// 标准双人间
		panelBS = new JPanel(new FlowLayout(FlowLayout.LEFT, 60, 60));
		// 豪华单人间
		panelHD = new JPanel(new FlowLayout(FlowLayout.LEFT, 60, 60));
		// 豪华双人间
		panelHS = new JPanel(new FlowLayout(FlowLayout.LEFT, 60, 60));
		// 商务套房
		panelSW = new JPanel(new FlowLayout(FlowLayout.LEFT, 60, 60));
		// 总统套房
		panelZT = new JPanel(new FlowLayout(FlowLayout.LEFT, 60, 60));

		// 获取房间信息并将它存入集合
		ArrayList<Room> listBDRoom = roomJdbc.find("标准单人间");
		ArrayList<Room> listBSRoom = roomJdbc.find("标准双人间");
		ArrayList<Room> listHDRoom = roomJdbc.find("豪华单人间");
		ArrayList<Room> listHSRoom = roomJdbc.find("豪华双人间");
		ArrayList<Room> listSWRoom = roomJdbc.find("商务套房");
		ArrayList<Room> listZTRoom = roomJdbc.find("总统套房");

		// 创建滚动窗体
		// 标准单人间
		scrollPaneSingle = icoState(panelBD, listBDRoom);
		// 标准双人间
		scrollPaneDouble = icoState(panelBS, listBSRoom);
		// 豪华单人间
		scrollPaneLuxOne = icoState(panelHD, listHDRoom);
		// 豪华双人间
		scrollPaneLuxTwo = icoState(panelHS, listHSRoom);
		// 商务套房
		scrollPaneCommerce = icoState(panelSW, listSWRoom);
		// 总统套房
		scrollPanePres = icoState(panelZT, listZTRoom);

		centerPanel.setPreferredSize(new Dimension(1650, 830));
		centerPanel.setBorder(BorderFactory.createLineBorder(Color.CYAN));
		tabbedPane.setPreferredSize(new Dimension(1630, 600));

		// 添加带有滚动窗体的选项卡
		tabbedPane.addTab("标准单人间", scrollPaneSingle);
		tabbedPane.addTab("标准双人间", scrollPaneDouble);
		tabbedPane.addTab("豪华单人间", scrollPaneLuxOne);
		tabbedPane.addTab("豪华双人间", scrollPaneLuxTwo);
		tabbedPane.addTab("商务套房", scrollPaneCommerce);
		tabbedPane.addTab("总统套房", scrollPanePres);

		// 设置JScrollPane滚动条显示状态
		scrollPaneState(scrollPaneSingle);
		scrollPaneState(scrollPaneDouble);
		scrollPaneState(scrollPaneLuxOne);
		scrollPaneState(scrollPaneLuxTwo);
		scrollPaneState(scrollPaneCommerce);
		scrollPaneState(scrollPanePres);

		centerPanel.add(tabbedPane, BorderLayout.NORTH);

		// 中间界面-中间部分
		graphicsCenterC();

		// 中间界面-下部分
		graphicsCenterB();

	}

	// 中间界面-中部
	public void graphicsCenterC() {
		JPanel cenPane = new JPanel(new FlowLayout(FlowLayout.RIGHT, 80, 10));

		// 图片
		ImageIcon ico1 = new ImageIcon("pic//browse.gif");
		ImageIcon ico2 = new ImageIcon("pic//b1.gif");
		ImageIcon ico3 = new ImageIcon("pic//refurbish.gif");

		// 按钮
		JButton button1 = new JButton("显示全部", ico1);
		JButton button2 = new JButton("过滤状态", ico2);
		JButton button3 = new JButton("刷新", ico3);
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new SystemGraphicsMain().graphicsMain();
				
			}
		});

		cenPane.setPreferredSize(new Dimension(1600, 50));
		cenPane.setBorder(BorderFactory.createLineBorder(Color.red));

		cenPane.add(button1);
		cenPane.add(button2);
		cenPane.add(button3);
		centerPanel.add(cenPane, BorderLayout.CENTER);

	}

	// 中间界面-下部
	public void graphicsCenterB() {
		JPanel bottPane = new JPanel(new BorderLayout());

		String[] columData = { "入住单号", "主房间号", "标准单价", "宾客类型", "享受折扣", "消费金额", "消费时间", "记账人" };
		tabelModel = new DefaultTableModel(columData, 0);

		JTable table = new JTable(tabelModel);
		table.setRowHeight(30);

		// 创建滚动窗体并将表格加入
		JScrollPane scrollPaneB1 = new JScrollPane(table);

		bottPane.setPreferredSize(new Dimension(1600, 200));
		bottPane.setBorder(BorderFactory.createLineBorder(Color.green));

		// 显示滚动条
		scrollPaneState(scrollPaneB1);

		bottPane.add(scrollPaneB1, BorderLayout.CENTER);

		centerPanel.add(bottPane, BorderLayout.SOUTH);

	}

	// 设置JScrollPane滚动条显示状态
	public void scrollPaneState(JScrollPane scrollPane) {
		// 水平滚动条不显示
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		// 垂直滚动条总是显示
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	}

	// 设置每种房间显示状态图标按钮
	public JScrollPane icoState(JPanel panelState, ArrayList<Room> list) {
		/**
		 * @praram list 存储房间信息的集合
		 * 
		 * @praram panelState 房间的状态容器
		 */

		panelState.setPreferredSize(new Dimension(500, 1000));

		// 状态图标
		String icoUrl = null;

		for (int i = 0; i < list.size(); i++) {
			// 获取房间状态信息
			String state = list.get(i).getRoomState();

			if (state != null) {
				if (state.equals("当前可用")) {
					icoUrl = "pic//room//prov.gif";
				} else if (state.equals("当前占用")) {
					icoUrl = "pic//room//pree.gif";
				} else if (state.equals("当前停用")) {
					icoUrl = "pic//room//stop.gif";
				} else if (state.equals("当前预定")) {
					icoUrl = "pic//room//rese.gif";
				} else if (state.equals("当前打扫")) {
					icoUrl = "pic//room//clean.gif";
				} else if (state.equals("钟点房")) {
					icoUrl = "pic//room//clock.gif";
				}

			}

			// 获取房间编号
			String roomNo = list.get(i).getRoomNo();
			// 获取房间类型
			String roomType = list.get(i).getRoomType();
			// 获取房间单价
			String roomPice = list.get(i).getRoomPrice();

			// 将对应房间状态图标与对应房间编号组合显示
			JButton buttonState = buttonJointState(icoUrl, roomNo);

			// getNo(roomNo);

			// 为状态按钮添加点击事件
			buttonState.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					GraphicsLeft.getORoo(roomNo, roomType);
					GraphicsIndividual.setInfo(roomNo, roomType, roomPice);
					GraphicsCheckOut.initInfo(roomNo);
					GraphicsGroupBilling.initInfo(roomNo, roomType, roomPice);

					// 向底部表格中加入数据
					indertData(roomNo, roomPice, roomType);

				}
			});

			// 将图标添加到panel容器中
			panelState.add(buttonState);

		}

		// 将容器加入滚动窗体中
		JScrollPane scrollPaneSingle = new JScrollPane(panelState);

		return scrollPaneSingle;

	}

	// 房间状态的图标按钮和房间编号组合
	public JButton buttonJointState(String icoUrl, String buttonTit) {

		ImageIcon ico = new ImageIcon(icoUrl);

		JButton button = new JButton(buttonTit, ico);

		button.setPreferredSize(new Dimension(90, 80));

		// 设置按钮内图片和文本位置
		GraphicsTop.textLocation(button);

		return button;
	}

	// 向中间界面底部插入数据
	public void indertData(String roomNo, String roomPice, String roomType) {
		tabelModel.getDataVector().clear();

		Bill billInfo = roomJdbc.queryBillInfo(roomNo);
		if (billInfo != null) {
			tabelModel.addRow(new Object[] { "RZ" + billInfo.getBillNo(), roomNo, roomPice, roomType,
					billInfo.getRebate(), billInfo.getExpendPrice(),
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(billInfo.getExpendTime()),
					billInfo.getTallyPeople() });

			// 向左部界面传送数据
			GraphicsLeft.addEnter(new SimpleDateFormat("yyyy-MM-dd").format(billInfo.getExpendTime()) + " ");
		} else {
			tabelModel.addRow(new Object[] { null, null, null, null, null, null, null, null });
			GraphicsLeft.addEnter(" ");
		}

	}

	public void initCenterState() {

	}
}
