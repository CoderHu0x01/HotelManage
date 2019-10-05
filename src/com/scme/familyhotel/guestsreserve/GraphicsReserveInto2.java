package com.scme.familyhotel.guestsreserve;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.scme.familyhotel.result.FrameLocation;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class GraphicsReserveInto2 extends JFrame {

	private JPanel contentPane;
	private JTextField text_certificates;
	private JTextField text_name;
	private JTextField text_number;
	private JTextField text_address;
	private JTextField text_remarks;
	private DefaultTableModel tableModel;
	private String[] coumData = { "可供房间" };
	private String[] coumdatatwo = { "开单房间" };
	private JTable table;
	private JTable table_1;
	private JTextField text_date;
	private JTextField text_deposit;
	private JComboBox box_certificates;
	private JComboBox box_gender;
	private JComboBox box_type;
	private JCheckBox CheckBox_remind;
	private JButton button_left;
	private JButton button_right;
	private JButton button_cancel;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GraphicsReserveInto frame = new GraphicsReserveInto();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public GraphicsReserveInto2() {
		{
			//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 550, 655);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			this.setTitle("预定开单");
			FrameLocation.frameLocation(this, null);
		}
		{
			JLabel lblNewLabel = new JLabel("开单信息");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setVerticalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(0, 0, 534, 23);
			contentPane.add(lblNewLabel);
			lblNewLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		}
		{
			JLabel label = new JLabel("主客房间：");
			label.setBounds(30, 33, 60, 15);
			contentPane.add(label);
		}
		{
			JLabel label_1 = new JLabel("房间类型:");
			label_1.setBounds(214, 33, 70, 15);
			contentPane.add(label_1);
		}
		{
			JLabel label_2 = new JLabel("预设单价：");
			label_2.setBounds(364, 33, 70, 15);
			contentPane.add(label_2);
		}
		{
			JLabel label_3 = new JLabel("证件类型");
			label_3.setBounds(30, 83, 60, 15);
			contentPane.add(label_3);

			box_certificates = new JComboBox();
			box_certificates.setModel(new DefaultComboBoxModel(new String[] { "身份证", "社保证" }));
			box_certificates.setBounds(91, 80, 70, 21);
			contentPane.add(box_certificates);
		}
		{
			JLabel label_4 = new JLabel("证件编码：");
			label_4.setBounds(189, 83, 72, 15);
			contentPane.add(label_4);

			text_certificates = new JTextField();
			text_certificates.setBounds(271, 80, 66, 21);
			contentPane.add(text_certificates);
			text_certificates.setColumns(10);
		}
		{
			JLabel label_5 = new JLabel("主客性别：");
			label_5.setBounds(347, 83, 70, 15);
			contentPane.add(label_5);

			box_gender = new JComboBox();
			box_gender.setModel(new DefaultComboBoxModel(new String[] { "男", "女", "保密" }));
			box_gender.setBounds(434, 80, 70, 21);
			contentPane.add(box_gender);
		}
		{
			JLabel label_6 = new JLabel("宾客类型：");
			label_6.setBounds(30, 124, 60, 15);
			contentPane.add(label_6);

			box_type = new JComboBox();
			box_type.setModel(new DefaultComboBoxModel(new String[] { "普通用户", "vip用户" }));
			box_type.setBounds(91, 121, 82, 21);
			contentPane.add(box_type);
		}
		{
			JLabel label_7 = new JLabel("主客姓名：");
			label_7.setBounds(189, 124, 72, 15);
			contentPane.add(label_7);

			text_name = new JTextField();
			text_name.setColumns(10);
			text_name.setBounds(271, 121, 66, 21);
			contentPane.add(text_name);
		}
		{
			JLabel label_8 = new JLabel("\u5BBE\u5BA2\u4EBA\u6570\uFF1A");
			label_8.setBounds(354, 124, 70, 15);
			contentPane.add(label_8);

			text_number = new JTextField();
			text_number.setColumns(10);
			text_number.setBounds(434, 121, 66, 21);
			contentPane.add(text_number);
		}
		{
			JLabel label_9 = new JLabel("地址信息：");
			label_9.setBounds(30, 168, 60, 15);
			contentPane.add(label_9);

			text_address = new JTextField();
			text_address.setBounds(95, 165, 409, 21);
			contentPane.add(text_address);
			text_address.setColumns(10);
		}
		{
			JLabel label_10 = new JLabel("备注信息：");
			label_10.setBounds(30, 205, 60, 15);
			contentPane.add(label_10);

			text_remarks = new JTextField();
			text_remarks.setColumns(10);
			text_remarks.setBounds(95, 202, 409, 21);
			contentPane.add(text_remarks);
		}
		{
			JLabel label_11 = new JLabel("折扣比例");
			label_11.setBounds(30, 246, 60, 15);
			contentPane.add(label_11);
		}
		{
			JLabel label_12 = new JLabel("实际单价");
			label_12.setBounds(143, 246, 54, 15);
			contentPane.add(label_12);
		}
		{
			JLabel label_13 = new JLabel("预住天数");
			label_13.setBounds(258, 246, 60, 15);
			contentPane.add(label_13);

			text_date = new JTextField();
			text_date.setBounds(314, 243, 66, 21);
			contentPane.add(text_date);
			text_date.setColumns(10);
		}
		{
			JLabel label_14 = new JLabel("实收押金");
			label_14.setBounds(390, 246, 60, 15);
			contentPane.add(label_14);

			text_deposit = new JTextField();
			text_deposit.setColumns(10);
			text_deposit.setBounds(447, 243, 66, 21);
			contentPane.add(text_deposit);
		}
		{
			JCheckBox checkBox = new JCheckBox("钟点房");
			checkBox.setForeground(Color.GRAY);
			checkBox.setBounds(30, 283, 103, 23);
			contentPane.add(checkBox);
		}
		{
			CheckBox_remind = new JCheckBox("到预住天数时自动提醒");
			CheckBox_remind.setBounds(135, 283, 170, 23);
			contentPane.add(CheckBox_remind);
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 329, 514, 201);
			contentPane.add(panel);
			panel.setLayout(null);

			JPanel panel_1 = new JPanel();
			panel_1.setBounds(10, 10, 201, 181);
			panel.add(panel_1);
			panel_1.setLayout(null);

			JScrollPane sp_available = new JScrollPane();
			sp_available.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			sp_available.setBounds(0, 0, 201, 181);
			panel_1.add(sp_available);

			tableModel = new DefaultTableModel(coumData, 0);
			table = new JTable(tableModel);
			sp_available.setViewportView(table);

			JPanel panel_2 = new JPanel();
			panel_2.setBounds(303, 10, 201, 181);
			panel.add(panel_2);
			panel_2.setLayout(null);

			JScrollPane sp_billing = new JScrollPane();
			sp_billing.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			sp_billing.setBounds(0, 0, 201, 181);
			panel_2.add(sp_billing);

			tableModel = new DefaultTableModel(coumdatatwo, 0);
			table_1 = new JTable(tableModel);
			sp_billing.setViewportView(table_1);

			button_left = new JButton("");
			button_left.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\left.gif"));
			button_left.setBounds(241, 46, 25, 23);
			panel.add(button_left);

			button_right = new JButton("");
			button_right.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\right.gif"));
			button_right.setBounds(241, 105, 25, 23);
			panel.add(button_right);
		}
		{
			JLabel label_15 = new JLabel("追加房间");
			label_15.setBounds(10, 312, 54, 15);
			contentPane.add(label_15);
			label_15.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		}
		{
			JLabel label = new JLabel("注：只能追加同类房间，最多4间！若要追加不同类型的房间请选择“团体开单”。");
			label.setForeground(Color.RED);
			label.setBounds(10, 541, 514, 15);
			contentPane.add(label);
		}
		{
			JButton button_determine = new JButton("确定");
			button_determine.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\modi3.gif"));
			button_determine.setBounds(104, 566, 93, 23);
			contentPane.add(button_determine);
		}
		{
			button_cancel = new JButton("取消");
			button_cancel.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\cancel.gif"));
			button_cancel.setBounds(275, 566, 93, 23);
			contentPane.add(button_cancel);
		}

	}
}
