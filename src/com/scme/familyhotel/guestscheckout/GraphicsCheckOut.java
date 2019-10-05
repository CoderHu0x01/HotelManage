package com.scme.familyhotel.guestscheckout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.scme.familyhotel.dao.CheckOutDao;
import com.scme.familyhotel.dao.RoomInfoDao;
import com.scme.familyhotel.daoimpl.CheckOutDaoImpl;
import com.scme.familyhotel.daoimpl.RoomInfoImpl;
import com.scme.familyhotel.pojo.Bill;
import com.scme.familyhotel.result.FrameLocation;

public class GraphicsCheckOut extends JFrame {
	CheckOutDao checkOutDaoImpl = new CheckOutDaoImpl();

	RoomInfoDao roomInfoDaoImpl = new RoomInfoImpl();
	private JPanel contentPane;
	private JTextField textReality;
	private JTextField textPay;
	private JTextField textRemark;
	private JTable table;
	private DefaultTableModel tableMoble;
	private JLabel lbConsume;
	private JLabel labelNumber;
	private JLabel labelRoom;
	private JLabel labelGuestName;
	private JLabel labelReceMoney;
	private JLabel lbCanceldMoney;
	private JLabel labelFravorMoney;
	private JLabel labelRetail;
	private JButton buttonSelttle;
	private JButton buttonCanch;
	private JLabel labelBillRoom;

	static String billRoomNo;
	
	int gesNo;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// GraphicsCheckOut frame = new GraphicsCheckOut();
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
	public GraphicsCheckOut() {
		setResizable(false);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(300,300, 726, 533);
		setSize(710, 500);
		setTitle("收银结账");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		FrameLocation.frameLocation(this, "pic//u01.gif");

		// JInternalFrame internalFrame = new JInternalFrame("收银结账");
		JPanel internalFrame = new JPanel();
		contentPane.add(internalFrame);
		internalFrame.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLUE));
		panel.setBounds(0, 13, 694, 36);
		internalFrame.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("结账单号:");
		lblNewLabel.setBounds(14, 13, 72, 18);
		panel.add(lblNewLabel);

		labelNumber = new JLabel("");
		labelNumber.setBounds(98, 13, 157, 18);
		panel.add(labelNumber);
		labelNumber.setForeground(Color.BLUE);

		Bill bill = roomInfoDaoImpl.queryBillInfo(billRoomNo);
		if (bill != null) {
			labelNumber.setText("YD" + bill.getBillNo());
		}

		labelBillRoom = new JLabel("结账房间:");
		labelBillRoom.setBounds(269, 13, 72, 18);
		panel.add(labelBillRoom);

		labelRoom = new JLabel("");
		labelRoom.setBounds(341, 13, 100, 18);
		labelRoom.setForeground(Color.BLUE);
		labelRoom.setText(billRoomNo);
		panel.add(labelRoom);

		JLabel label_3 = new JLabel("宾客姓名:");
		label_3.setBounds(460, 13, 72, 18);
		panel.add(label_3);

		labelGuestName = new JLabel("");
		labelGuestName.setBounds(534, 13, 82, 18);
		panel.add(labelGuestName);

		String guestName = checkOutDaoImpl.queryBillNameInfo(billRoomNo);
		labelGuestName.setText(guestName);
		labelGuestName.setForeground(Color.BLUE);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.BLUE));
		panel_1.setBounds(0, 59, 694, 160);
		internalFrame.add(panel_1);
		panel_1.setLayout(null);

		JLabel label_5 = new JLabel("消费金额：");
		label_5.setForeground(Color.BLUE);
		label_5.setBounds(14, 13, 84, 18);
		panel_1.add(label_5);

		lbConsume = new JLabel("");
		lbConsume.setBounds(99, 13, 72, 18);
		if (bill != null) {
			lbConsume.setText(String.valueOf(bill.getExpendPrice()));
		}

		panel_1.add(lbConsume);

		JLabel label_6 = new JLabel("应收金额:");
		label_6.setForeground(Color.BLUE);
		label_6.setBounds(204, 13, 72, 18);
		panel_1.add(label_6);

		labelReceMoney = new JLabel("");
		labelReceMoney.setBounds(280, 13, 72, 18);
		if (bill != null) {
			labelReceMoney.setText(String.valueOf(bill.getExpendPrice() * 0.9));
		}
		panel_1.add(labelReceMoney);

		JLabel label_8 = new JLabel("已收押金:");
		label_8.setForeground(Color.BLUE);
		label_8.setBounds(366, 13, 72, 18);
		panel_1.add(label_8);

		lbCanceldMoney = new JLabel("");
		lbCanceldMoney.setBounds(440, 13, 72, 18);
		if (bill != null) {
			lbCanceldMoney.setText(String.valueOf(bill.getExpendPrice()));
		}
		panel_1.add(lbCanceldMoney);

		JLabel label_9 = new JLabel("优惠金额:");
		label_9.setForeground(Color.BLUE);
		label_9.setBounds(526, 13, 72, 18);
		panel_1.add(label_9);

		labelFravorMoney = new JLabel("");
		labelFravorMoney.setBounds(596, 13, 72, 18);
		if (bill != null) {
			labelFravorMoney.setText(String.valueOf(bill.getExpendPrice() * 0.1));
		}
		panel_1.add(labelFravorMoney);

		JLabel label = new JLabel("实收金额:");
		label.setBounds(14, 59, 72, 18);
		panel_1.add(label);

		textReality = new JTextField();
		textReality.setEditable(false);
		textReality.setBounds(88, 56, 93, 24);
		if (bill != null) {
			textReality.setText(String.valueOf(bill.getExpendPrice()));
		}
		panel_1.add(textReality);
		textReality.setColumns(10);

		JLabel label_2 = new JLabel("宾客支付:");
		label_2.setBounds(247, 59, 72, 18);
		panel_1.add(label_2);

		textPay = new JTextField();
		textPay.setBounds(319, 56, 98, 24);
		textPay.setText("0");
		panel_1.add(textPay);
		textPay.setColumns(10);

		JLabel label_4 = new JLabel("找零:");
		label_4.setForeground(Color.BLUE);
		label_4.setBounds(468, 59, 38, 18);
		panel_1.add(label_4);

		labelRetail = new JLabel("");
		labelRetail.setBounds(513, 59, 85, 18);
		panel_1.add(labelRetail);

		JLabel label_10 = new JLabel("结账备注:");
		label_10.setBounds(14, 103, 72, 18);
		panel_1.add(label_10);

		textRemark = new JTextField();
		textRemark.setBounds(88, 100, 231, 24);
		panel_1.add(textRemark);
		textRemark.setColumns(10);

		buttonSelttle = new JButton("结账");
		buttonSelttle.setIcon(new ImageIcon("pic\\u04.gif"));
		buttonSelttle.setBounds(349, 99, 113, 27);
		panel_1.add(buttonSelttle);
		buttonSelttle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				double pay = Double.parseDouble(textPay.getText());
				// 找零
				double odd = pay - bill.getExpendPrice();
				labelRetail.setText(String.valueOf(odd));

				// 插入备注信息
				checkOutDaoImpl.insertRemark(textRemark.getText() + " ", bill.getBillNo());

			}
		});

		buttonCanch = new JButton("取消");
		buttonCanch.setIcon(new ImageIcon("pic\\cancel.gif"));
		buttonCanch.setBounds(485, 99, 113, 27);
		panel_1.add(buttonCanch);

		JLabel lblNewLabel_1 = new JLabel("结账区内房间消费清单", JLabel.CENTER);
		lblNewLabel_1.setBorder(BorderFactory.createLineBorder(Color.RED));
		lblNewLabel_1.setBounds(0, 221, 694, 18);
		internalFrame.add(lblNewLabel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 244, 694, 208);
		internalFrame.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);

		tableMoble = new DefaultTableModel(new String[] { "房间号", "单价", "折扣", "折扣价", "消费天数", "消费金额", "消费时间" }, 0);
		if (billRoomNo != null) {
			tableMoble.addRow(new Object[] { billRoomNo, bill.getExpendPrice(), 10, bill.getExpendPrice() * 0.9, 1.0,
					bill.getExpendPrice() * 0.9, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) });
		}
		table = new JTable(tableMoble);
		scrollPane.setViewportView(table);
		internalFrame.setVisible(true);
	}

	// 初始化组件参数
	public static void initInfo(String roomNo) {
		billRoomNo = roomNo;
	}
}
