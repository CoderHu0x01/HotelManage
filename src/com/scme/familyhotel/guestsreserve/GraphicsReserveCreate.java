package com.scme.familyhotel.guestsreserve;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.scme.familyhotel.dao.GraphicsReserveDao;
import com.scme.familyhotel.daoimpl.GraphicsReserveDaoImpl;
import com.scme.familyhotel.pojo.Guest;
import com.scme.familyhotel.pojo.Resever;
import com.scme.familyhotel.result.FrameLocation;

public class GraphicsReserveCreate extends JFrame implements ActionListener {
	GraphicsReserveDao graphicsReserveDaoImpl = new GraphicsReserveDaoImpl();

	private JPanel cp_main;
	private JTextField textFieldName;
	private JTextField textFieldRemark;
	private JTable table;
	private DefaultTableModel defaultTableModel;
	private String[] coumData = { "预订规格", "房间" };
	private JTextField textFieldPhone;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton buttonAddResRoom;
	private JComboBox comboBox;
	private JComboBox comboRoomNo;
	private JButton btnNewButton_1;
	private JButton button;
	private DefaultTableModel tableModel;

	String roomType;

	// /**
	// * Launch the application.
	// */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// GraphicsReserveCreate frame = new GraphicsReserveCreate();
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
	public GraphicsReserveCreate(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		cp_main = new JPanel();
		cp_main.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(cp_main);
		cp_main.setLayout(null);
		FrameLocation.frameLocation(this, "预订开单");

		JLabel lblNewLabel = new JLabel("\u57FA\u672C\u9884\u5B9A\u4FE1\u606F");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblNewLabel.setBounds(0, 0, 784, 25);
		cp_main.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u5BBE\u5BA2\u59D3\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(32, 57, 80, 15);
		cp_main.add(lblNewLabel_1);

		textFieldName = new JTextField();
		textFieldName.setBounds(109, 55, 169, 21);
		cp_main.add(textFieldName);
		textFieldName.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBounds(325, 35, 459, 354);
		cp_main.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 22, 459, 332);
		panel.add(scrollPane);

		defaultTableModel = new DefaultTableModel(coumData, 0);
		table = new JTable(defaultTableModel);
		scrollPane.setViewportView(table);

		JLabel label_5 = new JLabel("\u672C\u6B21\u9884\u8BA2\u7684\u623F\u95F4");
		label_5.setBounds(0, 0, 92, 15);
		panel.add(label_5);

		JLabel lblNewLabel_2 = new JLabel("\u70B9\u51FB\u53F3\u8FB9\u6309\u94AE\u6DFB\u52A0\u9884\u5B9A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(32, 369, 169, 15);
		cp_main.add(lblNewLabel_2);

		// 增加预订房间信息
		buttonAddResRoom = new JButton("");
		buttonAddResRoom.setIcon(new ImageIcon("pic\\add1.gif"));
		buttonAddResRoom.setBounds(211, 369, 25, 23);
		cp_main.add(buttonAddResRoom);
		buttonAddResRoom.addActionListener(this);

		JLabel lblNewLabel_3 = new JLabel("\u5907\u6CE8\uFF1A");
		lblNewLabel_3.setBounds(32, 435, 54, 15);
		cp_main.add(lblNewLabel_3);

		textFieldRemark = new JTextField();
		textFieldRemark.setBounds(117, 399, 657, 77);
		cp_main.add(textFieldRemark);
		textFieldRemark.setColumns(10);

		JCheckBox chckbxNewCheckBox = new JCheckBox("到达保留时间是否自动取消预定");
		chckbxNewCheckBox.setBounds(25, 484, 211, 23);
		cp_main.add(chckbxNewCheckBox);

		btnNewButton_1 = new JButton("保存");
		btnNewButton_1.setIcon(new ImageIcon("pic\\save.gif"));
		btnNewButton_1.setBounds(125, 519, 93, 33);
		cp_main.add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);

		button = new JButton("取消");
		button.setIcon(new ImageIcon("pic\\cancel.gif"));
		button.setBounds(478, 519, 93, 33);
		cp_main.add(button);

		// 房间类型
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "标准单人间", "\u6807\u51C6\u53CC\u4EBA\u95F4", "\u8C6A\u534E\u5355\u4EBA\u95F4",
						"\u8C6A\u534E\u53CC\u4EBA\u95F4", "\u5546\u52A1\u5957\u623F", "\u603B\u7EDF\u5957\u623F" }));
		comboBox.setBounds(109, 159, 169, 21);

		cp_main.add(comboBox);

		comboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				comboRoomNo.removeAllItems();
				roomType = (String) comboBox.getSelectedItem();

				ArrayList<String> resRoomNo = graphicsReserveDaoImpl.queryRoomNo(roomType);
				for (String no : resRoomNo) {
					comboRoomNo.addItem(no);
				}
			}
		});

		comboRoomNo = new JComboBox();
		roomType = (String) comboBox.getSelectedItem();

		ArrayList<String> resRoomNo = graphicsReserveDaoImpl.queryRoomNo(roomType);
		for (String no : resRoomNo) {
			comboRoomNo.addItem(no);
		}

		comboRoomNo.setBounds(109, 207, 169, 21);
		cp_main.add(comboRoomNo);

		JLabel label = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(32, 106, 80, 15);
		cp_main.add(label);

		JLabel label_1 = new JLabel("\u9884\u5B9A\u89C4\u683C\uFF1A");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		label_1.setBounds(32, 161, 80, 15);
		cp_main.add(label_1);

		JLabel label_2 = new JLabel("\u623F\u95F4\u7F16\u53F7\uFF1A");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("宋体", Font.PLAIN, 16));
		label_2.setBounds(32, 209, 80, 15);
		cp_main.add(label_2);

		JLabel label_3 = new JLabel("\u9884\u62B5\u65F6\u95F4\uFF1A");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		label_3.setBounds(32, 257, 80, 15);
		cp_main.add(label_3);

		JLabel label_4 = new JLabel("\u4FDD\u7559\u65F6\u95F4\uFF1A");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("宋体", Font.PLAIN, 16));
		label_4.setBounds(32, 306, 80, 15);
		cp_main.add(label_4);

		textFieldPhone = new JTextField();
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(109, 104, 169, 21);
		cp_main.add(textFieldPhone);

		// 预抵时间
		textField_2 = new JTextField();

		textField_2.setColumns(10);
		textField_2.setBounds(109, 255, 169, 21);
		cp_main.add(textField_2);

		// 保留时间
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(109, 304, 169, 21);
		cp_main.add(textField_3);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 增加预定房间按钮事件
		if (e.getSource() == buttonAddResRoom) {

			String roomPype = (String) comboBox.getSelectedItem();
			String rooNo = (String) comboRoomNo.getSelectedItem();

			defaultTableModel.addRow(new Object[] { roomPype, rooNo });

		}

		if (e.getSource() == btnNewButton_1) {
			Guest guest = new Guest();
			Resever res = new Resever();
			String rooNo = (String) comboRoomNo.getSelectedItem();

			guest.setGuestName(textFieldName.getText());
			guest.setPhone(textFieldPhone.getText());
			try {
				res.setEstime(new SimpleDateFormat("yyyy-MM-dd").parse(textField_2.getText()));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				res.setRestaintime(new SimpleDateFormat("yyyy-MM-dd").parse(textField_3.getText()));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			res.setResRemark(textFieldRemark.getText());
			res.setReseverTime(new Date(System.currentTimeMillis()));

			graphicsReserveDaoImpl.insertResGuest(guest);
			graphicsReserveDaoImpl.inserResever(res, rooNo);

			tableModel.addRow(new Object[] { textFieldName.getText(), textFieldPhone.getText(),
					(String) comboBox.getSelectedItem(), (String) comboRoomNo.getSelectedItem(), textField_2.getText(),
					textField_3.getText(), new Date(System.currentTimeMillis()), textFieldRemark.getText() });
		
			
			graphicsReserveDaoImpl.createRoomInfo(rooNo);
			
			
			dispose();
		}

	}
}
