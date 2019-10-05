package com.scme.familyhotel.group;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.scme.familyhotel.dao.IndividdualDao;
import com.scme.familyhotel.daoimpl.GroupBillingDaoImpl;
import com.scme.familyhotel.daoimpl.IndividdualDaoImpl;
import com.scme.familyhotel.login.Login;
import com.scme.familyhotel.pojo.Bill;
import com.scme.familyhotel.pojo.Guest;
import com.scme.familyhotel.pojo.Resever;
import com.scme.familyhotel.pojo.Room;
import com.scme.familyhotel.result.FrameLocation;

public class GraphicsGroupBilling extends JFrame {
	private GroupBillingDaoImpl groupBillingDaoImpl = new GroupBillingDaoImpl();

	IndividdualDao individdualDaoImpl = new IndividdualDaoImpl();
	private JPanel contentPane;
	private JTextField text_idcode;
	private JTextField text_paid;
	private JTextField text_Addressinformation;
	private JTextField text_Noteinformation;
	private JTextField text_name;
	private JTextField text_numder;
	private GroupBillingDaoImpl daoImpl;
	private DefaultTableModel tableModel;
	private DefaultTableModel tableModel_order;
	private String[] columData = { "客房编号", "标准单价" };
	private JTable table_xinxi;
	private JTable table_order;
	private JComboBox comboBox;
	private JTextField text_roomNo;
	private JTextField text_booking;

	static String groupRoomNo;
	static String grouproomType;
	static String grouproomPice;

	JComboBox Box_Documenttype;
	JComboBox Box_GuestsType;
	JComboBox Box_gender;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// GraphicsGroupBilling frame = new GraphicsGroupBilling();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public GraphicsGroupBilling() {
		setTitle("团体开单");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 703);
		FrameLocation.frameLocation(this, null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_xinxi = new JPanel();
		panel_xinxi.setForeground(Color.LIGHT_GRAY);
		panel_xinxi.setBorder(new LineBorder(Color.RED));
		panel_xinxi.setBounds(10, 22, 272, 265);
		contentPane.add(panel_xinxi);
		panel_xinxi.setLayout(null);

		JLabel lblNewLabel = new JLabel("房间信息");
		lblNewLabel.setBounds(0, 0, 272, 25);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.GRAY);
		panel_xinxi.add(lblNewLabel);
		lblNewLabel.setBorder(new LineBorder(Color.LIGHT_GRAY));

		JPanel panel_information = new JPanel();
		panel_information.setBounds(0, 28, 272, 32);
		panel_information.setForeground(Color.LIGHT_GRAY);
		panel_information.setToolTipText("");
		panel_information.setBorder(BorderFactory.createLineBorder(Color.blue));
		panel_xinxi.add(panel_information);
		panel_information.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("房间类型：");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(52, 0, 76, 32);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_information.add(lblNewLabel_1);

		comboBox = new JComboBox();

		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "标准单人间", "标准双人间", "豪华单人间", "豪华双人间", "商务套房", "总统套房" }));
		comboBox.setToolTipText("");
		comboBox.setBounds(131, 6, 119, 21);
		panel_information.add(comboBox);

		JScrollPane Pane_information = new JScrollPane();
		Pane_information.setBounds(0, 229, 272, -140);
		panel_xinxi.add(Pane_information);

		JButton Button_add = new JButton("添加到开单区");
		Button_add.setBounds(0, 229, 272, 36);
		Button_add.setIcon(new ImageIcon("E:\\workspace\\workspace_eclipse\\Java\u9879\u76EE\\img\\pic\\new.gif"));
		panel_xinxi.add(Button_add);
		Button_add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (table_xinxi.getSelectedRow() != -1) {
					int row = table_xinxi.getSelectedRow();
					// 获取电机的内容
					Object value = table_xinxi.getValueAt(row, 0);
					Object value2 = table_xinxi.getValueAt(row, 1);
					tableModel_order.addRow(new Object[] { value, value2 });
					// 从表格移除
					tableModel.removeRow(row);
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 59, 272, 173);
		panel_xinxi.add(scrollPane);

		tableModel = new DefaultTableModel(columData, 0);
		table_xinxi = new JTable(tableModel);
		scrollPane.setViewportView(table_xinxi);

		ArrayList<Room> roomInfoList = groupBillingDaoImpl.queryTypeRoom("标准单人间");
		for (Room info : roomInfoList) {
			tableModel.addRow(new Object[] { info.getRoomNo(), info.getRoomPrice() });
		}

		comboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// 清空当前表格模型数据
				tableModel.getDataVector().clear();

				String roomType = (String) comboBox.getSelectedItem();

				ArrayList<Room> roomInfoList = groupBillingDaoImpl.queryTypeRoom(roomType);
				for (Room info : roomInfoList) {
					tableModel.addRow(new Object[] { info.getRoomNo(), info.getRoomPrice() });
				}
			}
		});

		JPanel panel_order = new JPanel();
		panel_order.setBounds(303, 22, 272, 265);
		contentPane.add(panel_order);
		panel_order.setLayout(null);

		JLabel label_order = new JLabel("开单房间");
		label_order.setHorizontalAlignment(SwingConstants.CENTER);
		label_order.setBorder(new LineBorder(Color.LIGHT_GRAY));
		label_order.setBackground(Color.GRAY);
		label_order.setBounds(0, 0, 272, 25);
		panel_order.add(label_order);

		JButton button_delete = new JButton("从开单区删除");
		button_delete.setIcon(new ImageIcon("E:\\workspace\\workspace_eclipse\\Java\u9879\u76EE\\img\\pic\\del.gif"));
		button_delete.setBounds(0, 229, 272, 36);
		panel_order.add(button_delete);
		button_delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table_order.getSelectedRow();

				tableModel_order.removeRow(row);
			}
		});

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 24, 272, 206);
		panel_order.add(scrollPane_1);

		tableModel_order = new DefaultTableModel(columData, 0);

		table_order = new JTable(tableModel_order);
		scrollPane_1.setViewportView(table_order);

		JPanel panel_framework = new JPanel();
		panel_framework.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_framework.setForeground(Color.LIGHT_GRAY);
		panel_framework.setBounds(10, 297, 565, 306);
		contentPane.add(panel_framework);
		panel_framework.setLayout(null);

		JLabel lbl_Documenttype = new JLabel("证件类型");
		lbl_Documenttype.setFont(new Font("宋体", Font.PLAIN, 14));
		lbl_Documenttype.setBounds(23, 20, 80, 21);
		panel_framework.add(lbl_Documenttype);

		Box_Documenttype = new JComboBox();
		Box_Documenttype.setModel(new DefaultComboBoxModel(new String[] { "身份证", "户口本" }));
		Box_Documenttype.setBounds(95, 20, 95, 21);
		panel_framework.add(Box_Documenttype);

		JLabel lbl_idcode = new JLabel("证件编号");
		lbl_idcode.setFont(new Font("宋体", Font.PLAIN, 14));
		lbl_idcode.setBounds(23, 69, 80, 29);
		panel_framework.add(lbl_idcode);

		text_idcode = new JTextField();
		text_idcode.setBounds(95, 71, 95, 25);
		panel_framework.add(text_idcode);
		text_idcode.setColumns(10);

		JLabel lbl_paid = new JLabel("实收押金");
		lbl_paid.setFont(new Font("宋体", Font.PLAIN, 14));
		lbl_paid.setBounds(23, 124, 80, 29);
		panel_framework.add(lbl_paid);

		text_paid = new JTextField();
		text_paid.setColumns(10);
		text_paid.setBounds(95, 126, 95, 25);
		panel_framework.add(text_paid);

		JLabel lbl_Addressinformation = new JLabel("地址信息");
		lbl_Addressinformation.setFont(new Font("宋体", Font.PLAIN, 14));
		lbl_Addressinformation.setBounds(23, 177, 80, 29);
		panel_framework.add(lbl_Addressinformation);

		text_Addressinformation = new JTextField();
		text_Addressinformation.setColumns(10);
		text_Addressinformation.setBounds(95, 179, 439, 25);
		panel_framework.add(text_Addressinformation);

		JLabel lbl_Noteinformation = new JLabel("备注信息");
		lbl_Noteinformation.setFont(new Font("宋体", Font.PLAIN, 14));
		lbl_Noteinformation.setBounds(23, 216, 80, 29);
		panel_framework.add(lbl_Noteinformation);

		text_Noteinformation = new JTextField();
		text_Noteinformation.setColumns(10);
		text_Noteinformation.setBounds(95, 218, 439, 25);
		panel_framework.add(text_Noteinformation);

		JLabel lbl_GuestsType = new JLabel("宾客类型");
		lbl_GuestsType.setFont(new Font("宋体", Font.PLAIN, 14));
		lbl_GuestsType.setBounds(212, 20, 80, 21);
		panel_framework.add(lbl_GuestsType);

		Box_GuestsType = new JComboBox();
		Box_GuestsType.setModel(new DefaultComboBoxModel(
				new String[] { "\u666E\u901A\u5BBE\u5BA2", "\u4F1A\u5458", "\u8C6A\u534E\u5BBE\u5BA2" }));
		Box_GuestsType.setBounds(286, 20, 95, 21);
		panel_framework.add(Box_GuestsType);

		JLabel lbl_name = new JLabel("主客姓名");
		lbl_name.setFont(new Font("宋体", Font.PLAIN, 14));
		lbl_name.setBounds(212, 73, 80, 21);
		panel_framework.add(lbl_name);

		text_name = new JTextField();
		text_name.setColumns(10);
		text_name.setBounds(286, 71, 95, 25);
		panel_framework.add(text_name);

		JLabel lbl_HostRoom = new JLabel("主客房间");
		lbl_HostRoom.setFont(new Font("宋体", Font.PLAIN, 14));
		lbl_HostRoom.setBounds(212, 128, 80, 21);
		panel_framework.add(lbl_HostRoom);

		JLabel lbl_TheoryOfGender = new JLabel("主客性别");
		lbl_TheoryOfGender.setFont(new Font("宋体", Font.PLAIN, 14));
		lbl_TheoryOfGender.setBounds(391, 23, 80, 21);
		panel_framework.add(lbl_TheoryOfGender);

		JComboBox Box_gender = new JComboBox();
		Box_gender.setModel(new DefaultComboBoxModel(new String[] { "男", "女", "不详" }));
		Box_gender.setBounds(460, 20, 95, 21);
		panel_framework.add(Box_gender);

		JLabel lbl_numder = new JLabel("宾客人数");
		lbl_numder.setFont(new Font("宋体", Font.PLAIN, 14));
		lbl_numder.setBounds(391, 76, 80, 21);
		panel_framework.add(lbl_numder);

		text_numder = new JTextField();
		text_numder.setColumns(10);
		text_numder.setBounds(460, 73, 95, 25);
		panel_framework.add(text_numder);

		JLabel lbl_bookingnumber = new JLabel("预定天数");
		lbl_bookingnumber.setFont(new Font("宋体", Font.PLAIN, 14));
		lbl_bookingnumber.setBounds(391, 131, 80, 21);
		panel_framework.add(lbl_bookingnumber);

		JCheckBox CheckBox_one = new JCheckBox("到预定天数时自动提醒");
		CheckBox_one.setFont(new Font("宋体", Font.PLAIN, 14));
		CheckBox_one.setBounds(65, 262, 174, 23);
		panel_framework.add(CheckBox_one);

		text_roomNo = new JTextField();
		text_roomNo.setColumns(10);
		text_roomNo.setBounds(286, 128, 95, 25);
		panel_framework.add(text_roomNo);

		text_booking = new JTextField();
		text_booking.setColumns(10);
		text_booking.setBounds(460, 128, 95, 25);
		panel_framework.add(text_booking);

		JButton Button_determine = new JButton("确认");
		Button_determine.setIcon(new ImageIcon("pic\\modi3.gif"));
		Button_determine.setBounds(125, 618, 101, 37);
		contentPane.add(Button_determine);
		Button_determine.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				 Guest guest = new Guest();
//				 Room room = new Room();
//				 Resever resever = new Resever();
//				 guest.setCredeType((String)
//				 Box_Documenttype.getSelectedItem());
//				 guest.setGuestType((String)
//				 Box_GuestsType.getSelectedItem());
//				 guest.setGender((String) Box_gender.getSelectedItem());
//				 guest.setCredeNum(text_idcode.getText());
//				 guest.setGuestName(text_name.getText());
//				 room.setGuestNum(Integer.parseInt(text_numder.getText()));
//				 guest.setRealCash(Integer.parseInt(text_name.getText()));
//				 room.setRoomNo(groupRoomNo);
//				 resever.setLiveDay(Integer.parseInt(text_booking.getText()));
//				 guest.setAddress((String) text_Addressinformation.getText());
//				 guest.setGuestRemark((String)
//				 text_Addressinformation.getText());
//				
//				 groupBillingDaoImpl.selectAllguest(guest);
//				 groupBillingDaoImpl.insertRoom(room,groupRoomNo);

				individdualDaoImpl.createRoomInfo3(groupRoomNo);
				dispose();

			}

		});

		JButton Button_cancel = new JButton("取消");
		Button_cancel
				.setIcon(new ImageIcon("E:\\workspace\\workspace_eclipse\\Java\u9879\u76EE\\img\\pic\\cancel.gif"));
		Button_cancel.setBounds(358, 613, 101, 37);
		contentPane.add(Button_cancel);
	}

	// 获取房间信息
	public static void initInfo(String roomNo, String roomType, String roomPice) {
		// System.out.println(roomNo + "**+++++");
		groupRoomNo = roomNo;
		grouproomType = roomType;
		grouproomPice = roomPice;
	}

}
