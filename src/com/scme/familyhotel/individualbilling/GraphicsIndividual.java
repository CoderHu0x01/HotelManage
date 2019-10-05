package com.scme.familyhotel.individualbilling;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.scme.familyhotel.dao.IndividdualDao;
import com.scme.familyhotel.daoimpl.IndividdualDaoImpl;
import com.scme.familyhotel.login.Login;
import com.scme.familyhotel.pojo.Bill;
import com.scme.familyhotel.pojo.Guest;
import com.scme.familyhotel.pojo.Room;
import com.scme.familyhotel.result.FrameLocation;
import com.scme.familyhotel.result.JointModule;

/**
 * ======================== 这是散客开单的图形界面 ========================
 * 
 * @author 胡贵东
 * @version 1.0
 * @date 2017-5-8
 * 
 *
 */
public class GraphicsIndividual extends JFrame {
	private static final long serialVersionUID = 1L;

	// 可供房间表格模型
	private DefaultTableModel modelHaveRoom;
	// 开单房间表格模型
	private DefaultTableModel modelAddRoom;

	private JTable cvailableTable;
	private JTable billiTable;

	// JInternalFrame indInterFrame = new JInternalFrame("散客开单", false, false,
	// false);
	static JLabel juestLabel;
	static JLabel juestLabel2;
	static JLabel bilLabel;
	static JLabel bilLabel2;
	static JLabel presetLabel;
	static JLabel presetLabel2;

	private JointModule jintCre;
	private JointModule jintNum;
	private JointModule jintGender;
	private JointModule jintGenTy;
	private JointModule jintName;
	private JointModule jintSum;
	private JointModule jintAdder;
	private JointModule jintInfo;
	private JointModule jintDisco;
	private JointModule jintReal;
	private JointModule jintLived;
	private JointModule jintCash;

	private JCheckBox hourCheckBox;

	Guest guest;
	
	IndividdualDao individdualDaoImpl = new IndividdualDaoImpl();
	// ReseverImpl res = new ReseverImpl();

	static String roomNo2;
	static String roomType2;
	static String roomPice2;
	// 房间编号
	//static String no;

	// 查询出可供房间
	ArrayList<Room> haveRoom;

	// 宾客编号
	int gesNo;

	public GraphicsIndividual() {
		/**
		 * Container getContentPane() 返回此窗体的 contentPane 对象 (返回当前整个容器空间)
		 */

		setSize(600, 650);
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		setTitle("散客开单");
		setResizable(false);
		FrameLocation.frameLocation(this, "pic//u01.gif");

		// setUndecorated(true);

		guest = new Guest();
		// gjl = new GuestJdbcImpl();
		// 定义集合存储从界面获得的数据
		ArrayList<String> list = new ArrayList<String>();

		// 创建一个内部窗体框架
		// indInterFrame.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		// indInterFrame.setSize(600, 650);

		JLabel topLabel = new JLabel("开单信息", JLabel.CENTER);
		topLabel.setPreferredSize(new Dimension(590, 20));
		topLabel.setBorder(BorderFactory.createLineBorder(Color.red));

		juestLabel = new JLabel("主客房间:");
		juestLabel2 = new JLabel();
		juestLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		juestLabel2.setPreferredSize(new Dimension(120, 30));

		bilLabel = new JLabel("房间类型:");
		bilLabel2 = new JLabel();
		bilLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		bilLabel2.setPreferredSize(new Dimension(120, 30));

		presetLabel = new JLabel("预设价格:");
		presetLabel2 = new JLabel();
		presetLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		presetLabel2.setPreferredSize(new Dimension(120, 30));

		// 设置信息
		setLabel();

		jintCre = new JointModule();
		String[] credeType = { "身份证", "学生证" };
		JPanel idPanel = jintCre.labelCom("证件类型:", credeType, new Dimension(80, 30), 10, 10, 0, 50);

		jintNum = new JointModule();
		JPanel typePanel = jintNum.labelField("证件编号:", null, new Dimension(100, 30), 10, 10, 0, 50);

		jintGender = new JointModule();
		String[] gender = { "男", "女" };
		JPanel sexPanel = jintGender.labelCom("主客性别:", gender, new Dimension(60, 30), 10, 5, 0, 0);

		jintGenTy = new JointModule();
		String[] guestType = { "普通宾客", "会员宾客" };
		JPanel guestPanel = jintGenTy.labelCom("宾客类型:", guestType, new Dimension(80, 30), 0, 10, 0, 40);

		jintName = new JointModule();
		JPanel namePanel = jintName.labelField("主客性名:", null, new Dimension(100, 30), 0, 20, 0, 10);

		jintSum = new JointModule();
		JPanel sumPanel = jintSum.labelField("宾客人数:", null, new Dimension(100, 30), 0, 5, 0, 0);

		jintAdder = new JointModule();
		JPanel addressPanel = jintAdder.labelField("地址信息:", null, new Dimension(500, 30), 0, 10, 0, 0);

		jintInfo = new JointModule();
		JPanel infoPanel = jintInfo.labelField("备注信息:", null, new Dimension(500, 30), 0, 10, 0, 0);

		jintDisco = new JointModule();
		JPanel discountPanel = jintDisco.jointlabel("折扣比例:", "10", new Dimension(50, 30), 0, 10, 0, 10);

		jintReal = new JointModule();
		JPanel realityPanel = jintReal.jointlabel("实际单价:", roomPice2, new Dimension(50, 30), 0, 10, 0, 10);

		jintLived = new JointModule();
		JPanel livedPanel = jintLived.labelField("预住天数:", null, new Dimension(50, 30), 0, 10, 0, 10);

		jintCash = new JointModule();
		JPanel cashPanel = jintCash.labelField("实收押金:", null, new Dimension(60, 30), 0, 10, 0, 10);

		// 创建复选框
		hourCheckBox = new JCheckBox("钟点房");
		hourCheckBox.setBorder(BorderFactory.createEmptyBorder(10, 15, 20, 100));

		JCheckBox warnCheckBox = new JCheckBox("到期预住天数自动提醒");
		warnCheckBox.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 200));

		// "追加房间"界面
		JTabbedPane addRoomTabblePane = graphicsAddRoom();

		// 提示
		JLabel label = new JLabel("提示:只能追加同类，房间只能4间，若要追加不同房间请选择”团体开单“");
		// 设置字体颜色
		label.setForeground(Color.red);
		label.setPreferredSize(new Dimension(600, 40));
		// label.setBorder(BorderFactory.createEmptyBorder(60, 80, 50, 50));
		label.setBorder(BorderFactory.createLineBorder(Color.red));

		// 确定和取消按钮
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 150, 25));
		buttonPanel.setPreferredSize(new Dimension(500, 100));

		ImageIcon confirmIco = new ImageIcon("pic//modi3.gif");
		ImageIcon abolishIco = new ImageIcon("pic//cancel.gif");

		JButton confirmButton = new JButton("确认", confirmIco);

		confirmButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!(jintNum.getFliText().equals("") || jintName.getFliText().equals("")
						|| jintAdder.getFliText().equals("") || jintInfo.getFliText().equals("")
						|| jintCash.getFliText().equals("") || jintSum.getFliText().equals("")
						|| jintLived.getFliText().equals(""))) {

					// 显示提示界面确认操作
					PromptFrame();

				} else {
					new JOptionPane().showMessageDialog(null, "请将数据填写完整！");
				}
			}

		});

		JButton abolishButtonnew = new JButton("取消", abolishIco);
		buttonPanel.add(confirmButton);
		buttonPanel.add(abolishButtonnew);

		add(topLabel);
		add(juestLabel);
		add(juestLabel2);
		add(bilLabel);
		add(bilLabel2);
		add(presetLabel);
		add(presetLabel2);

		add(idPanel);
		add(typePanel);
		add(sexPanel);
		add(guestPanel);
		add(namePanel);
		add(sumPanel);
		add(addressPanel);
		add(infoPanel);
		add(discountPanel);
		add(realityPanel);
		add(livedPanel);
		add(cashPanel);
		add(hourCheckBox);
		add(warnCheckBox);
		add(addRoomTabblePane);
		add(label);
		add(buttonPanel);
		// setVisible(true);

		// add();
		setVisible(true);

	}

	// 底部"追加房间"界面
	public JTabbedPane graphicsAddRoom() {
		modelHaveRoom = new DefaultTableModel(new String[] { "可供房间" }, 0);
		modelAddRoom = new DefaultTableModel(new String[] { "开单房间" }, 0);

		// 标签容器
		JTabbedPane tabblePane = new JTabbedPane();
		tabblePane.setPreferredSize(new Dimension(590, 200));
		// JPanel容器
		JPanel roomInfoPanel = new JPanel();

		// 查询出可供房间
		ArrayList<Room> haveRoom = individdualDaoImpl.queryHaveRoom();
		for (Room hRoom : haveRoom) {
			modelHaveRoom.addRow(new Object[] { hRoom.getRoomNo() });
		}

		// 向开单房间中添加数据
		modelAddRoom.addRow(new Object[] { roomNo2 });

		// 表格容器
		cvailableTable = new JTable(modelHaveRoom);
		billiTable = new JTable(modelAddRoom);

		// 设置表格单元格高度
		cvailableTable.setRowHeight(20);
		billiTable.setRowHeight(20);

		// 滚动窗格,并将表格加入
		// 可供房间
		JScrollPane cvailableScroll = new JScrollPane(cvailableTable);
		cvailableScroll.setPreferredSize(new Dimension(230, 250));
		// 追加房间
		JScrollPane billiScroll = new JScrollPane(billiTable);
		billiScroll.setPreferredSize(new Dimension(230, 250));

		// 中间的选择按钮
		ImageIcon confirmIco = new ImageIcon("pic//right.gif");
		ImageIcon abolishIco = new ImageIcon("pic//left.gif");

		JPanel pane = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 30));
		pane.setPreferredSize(new Dimension(100, 250));
		pane.setBorder(BorderFactory.createLineBorder(Color.red));

		JButton button1 = new JButton(confirmIco);
		// 给按钮设置提示文本
		button1.setToolTipText("添加到开单区");
		button1.setPreferredSize(new Dimension(20, 20));
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cvailableTable.getSelectedRow() != -1) {
					// 获取当前点击的行
					int row = cvailableTable.getSelectedRow();

					// 获得当前行与指定列的值
					Object value = cvailableTable.getValueAt(row, 0);
					// 将值插入到另外一个表格中
					modelAddRoom.addRow(new Object[] { value });

					// 移除当前行
					modelHaveRoom.removeRow(row);
				}
			}
		});

		JButton button2 = new JButton(abolishIco);
		button2.setToolTipText("从开单区移除");
		button2.setPreferredSize(new Dimension(20, 20));
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (billiTable.getSelectedRow() != -1) {
					// 获取当前行
					int row = billiTable.getSelectedRow();
					// 移除指定行数据
					modelAddRoom.removeRow(row);
				}
			}
		});

		pane.add(button1);
		pane.add(button2);

		roomInfoPanel.add(cvailableScroll);
		roomInfoPanel.add(pane);
		roomInfoPanel.add(billiScroll);

		tabblePane.add("追加房间", roomInfoPanel);

		return tabblePane;
	}

	// 获取房间信息
	public static void setInfo(String roomNo, String roomType, String roomPice) {
		// System.out.println(roomNo + "**+++++");
		roomNo2 = roomNo;
		roomType2 = roomType;
		roomPice2 = roomPice;

		//no = roomNo;
	}

	// 将房间信息插入标签容器中
	public static void setLabel() {
		juestLabel2.setText(roomNo2);
		bilLabel2.setText(roomType2);
		presetLabel2.setText(roomPice2);

		juestLabel2.setForeground(Color.blue);
		bilLabel2.setForeground(Color.blue);
		presetLabel2.setForeground(Color.red);

	}

	// 生成结账单号(入住单号)
	public void generateCheckNumber() {
		// 计算总金额
		double countPrice = countCheckPrice();

		Bill bill = new Bill();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
		// 获取当前时间
		Date date = new Date();
		String dateBillNo = dateFormat.format(date);
		System.out.println(dateBillNo);

		bill.setBillNo(dateBillNo);
		bill.setGuestNo(gesNo);
		bill.setExpendPrice(countPrice);
		bill.setRebate(10);
		bill.setTallyPeople(Login.getLoginUser());
		bill.setExpendTime(new Timestamp(new Date().getTime()));

		// 向数据库中插入结账单号和总金额
		individdualDaoImpl.insertBillInfo(bill);
	}

	// 计算总金额
	public double countCheckPrice() {
		// 存储总金额
		double countPrice = 0;
		// 获取所有行
		int rowCount = modelAddRoom.getRowCount();

		// 获取当前表格中所有列的数据
		for (int i = 0; i < rowCount; i++) {
			String valueData = (String) billiTable.getValueAt(i, 0);
			// System.out.println(valueData + " 66666");
			countPrice += individdualDaoImpl.queryRoomPrice(valueData);
		}
		System.out.println("房间总价" + countPrice);

		return countPrice;
	}

	// 提示界面
	public void PromptFrame() {
		JFrame frame = new JFrame();
		frame.setLayout(null);
		frame.setSize(450, 200);
		frame.setTitle("提示");

		// 初始化界面
		JLabel lable = new JLabel("您确定已当前宾客信息，以[" + roomNo2 + "]为主房间开设房间吗？");
		lable.setBounds(50, 30, 400, 50);
		frame.add(lable);

		JButton yesButton = new JButton("是");
		yesButton.setBounds(50, 80, 47, 40);
		yesButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// 确认时间处理
				actionConfirmIndividual();
				frame.dispose();

				// 释放散客开单窗体
				dispose();

			}
		});

		JButton noButton = new JButton("否");
		noButton.setBounds(330, 80, 47, 40);
		frame.add(yesButton);
		frame.add(noButton);

		FrameLocation.frameLocation(frame, null);

		frame.setVisible(true);
	}

	// 确认按钮时处理事件
	public void actionConfirmIndividual() {
		if (!(jintNum.getFliText().equals("") || jintName.getFliText().equals("") || jintAdder.getFliText().equals("")
				|| jintInfo.getFliText().equals("") || jintCash.getFliText().equals("")
				|| jintSum.getFliText().equals("") || jintLived.getFliText().equals(""))) {

			guest.setCredeType(jintCre.getComboVal());
			System.out.println(jintCre.getComboVal());

			guest.setCredeNum(jintNum.getFliText());
			System.out.println(jintNum.getFliText());
			// gjl.findGuestNo(jintNum.getFliText());

			guest.setGender(jintGender.getComboVal());
			System.out.println(jintGender.getComboVal());

			guest.setGuestType(jintGenTy.getComboVal());
			System.out.println(jintGenTy.getComboVal());

			guest.setGuestName(jintName.getFliText());
			System.out.println(jintName.getFliText());

			guest.setAddress(jintAdder.getFliText());
			System.out.println(jintAdder.getFliText());

			guest.setGuestRemark(jintInfo.getFliText());
			System.out.println(jintInfo.getFliText());

			String s = jintCash.getFliText();
			double d = Double.parseDouble(s);
			guest.setRealCash(d);
			System.out.println(d);
			// 添加房间信息数据
			individdualDaoImpl.createGueInfo(guest);

			// 新增房间人数
			// String sum = jintSum.getFliText();
			int sumjin = Integer.parseInt(jintSum.getFliText());
			individdualDaoImpl.createRoomInfo(sumjin, roomNo2);

			// 增加预住天数
			// String live = jintLived.getFliText();
			int liveDay = Integer.parseInt(jintLived.getFliText());
			individdualDaoImpl.createRes(roomNo2, liveDay);

			// setVisible(false);

			// 查询对应的宾客编号通过证件编号
			gesNo = individdualDaoImpl.findGuestNo(jintNum.getFliText());
			// 将宾客编号插入房间信息中
			individdualDaoImpl.createRoomInfo2(gesNo, roomNo2);

			// 如果钟点房按钮是被选中的，则执行更新
			if (hourCheckBox.isSelected()) {
				individdualDaoImpl.updateRoomState(hourCheckBox.getText(), roomNo2);
			}

			// 生成结账单号和计算总金额
			generateCheckNumber();

		} else {
			new JOptionPane().showMessageDialog(null, "请将数据填写完整！");
		}
	}
}
