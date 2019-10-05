package com.scme.familyhotel.salesinquiries;



import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.scme.familyhotel.result.FrameLocation;
/**
 * ===============这是营业查询界面============
 * @author 
 *
 */

public class SalesInquiries2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private DefaultTableModel tableModel;
	private String[] coumData = { "账单号", "房间号", "宾客姓名", "已收押金", "实收押金", "结算时间",
			"备注" };
	private String[] coumtaba = { "会员编号", "房间号", "宾客姓名", "性别", "证件类型", "证件编号",
			"人数", "押金", "预住天数", "当前状态", "入住时间", "结账时间", "结算单号" };
	private String[] coumfour = { "房间号", "房间类型", "单价", "折扣比例", "折后单价", "优惠金额",
			"入住时间" };
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table_1;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTable table_2;
	private JTable table_3;
	private JCheckBox chckbxNewCheckBox;
	private JCheckBox checkBox_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_2;
	private JCheckBox checkBox_3;
	private JCheckBox checkBox_1;
	private JButton button_7;
	private JButton button_8;
	private JCheckBox checkBox;
	private JCheckBox chckbxNewCheckBox_1;
	private JComboBox comboBox;
	private JButton button;
	private JButton button_1;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SalesInquiries frame = new SalesInquiries();
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
	public SalesInquiries2() {
		{
			//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 800, 550);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			this.setTitle("营业查询");
			FrameLocation.frameLocation(this, null);
		}
		{
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(0, 0, 784, 512);
			contentPane.add(tabbedPane);

			{
				JPanel panel = new JPanel();
				tabbedPane.addTab("结账单查询", new ImageIcon("E:/小可爱啊/u04.gif"),
						panel, null);
				panel.setLayout(null);

				chckbxNewCheckBox = new JCheckBox("结账时间");
				chckbxNewCheckBox.setBounds(101, 17, 86, 23);
				panel.add(chckbxNewCheckBox);
				{
					JLabel label = new JLabel("起始时间");
					label.setBounds(193, 21, 54, 15);
					panel.add(label);

					textField = new JTextField();
					textField.setBounds(246, 18, 121, 21);
					panel.add(textField);
					textField.setColumns(10);
				}
				{
					JLabel label_1 = new JLabel("终止查询");
					label_1.setBounds(428, 21, 54, 15);
					panel.add(label_1);

					textField_1 = new JTextField();
					textField_1.setBounds(492, 18, 132, 21);
					panel.add(textField_1);
					textField_1.setColumns(10);
				}
				{
					checkBox_2 = new JCheckBox("姓名/房间/账单号");
					checkBox_2.setBounds(101, 70, 132, 23);
					panel.add(checkBox_2);

					textField_2 = new JTextField();
					textField_2.setBounds(246, 71, 121, 21);
					panel.add(textField_2);
					textField_2.setColumns(10);
				}
				{
					button_3 = new JButton("查询");
					button_3.setIcon(new ImageIcon(
							"E:\\\u5C0F\u53EF\u7231\u554A\\find.gif"));
					button_3.setBounds(425, 70, 86, 23);
					panel.add(button_3);

					button_4 = new JButton("刷新");
					button_4.setIcon(new ImageIcon(
							"E:\\\u5C0F\u53EF\u7231\u554A\\b1.gif"));
					button_4.setBounds(538, 70, 86, 23);
					panel.add(button_4);
				}
				{
					textField_3 = new JTextField();
					textField_3.setBackground(Color.GRAY);
					textField_3.setHorizontalAlignment(SwingConstants.CENTER);
					textField_3.setText("\u7ED3\u8D26\u72B6\u6001\u4FE1\u606F");
					textField_3.setBounds(0, 113, 779, 21);
					panel.add(textField_3);
					textField_3.setColumns(10);
				}
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(0, 134, 779, 348);
					panel.add(scrollPane);

					tableModel = new DefaultTableModel(coumData, 0);
					table = new JTable(tableModel);
					scrollPane.setViewportView(table);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				tabbedPane.addTab("全部宾客信息查询", new ImageIcon("E:/小可爱啊/u02.gif"),
						panel_1, null);
				panel_1.setLayout(null);
				{
					JLabel label = new JLabel("姓名/房间/账单号");
					label.setBounds(90, 27, 112, 15);
					panel_1.add(label);

					textField_4 = new JTextField();
					textField_4.setBounds(197, 24, 124, 21);
					panel_1.add(textField_4);
					textField_4.setColumns(10);
				}
				{
					button_5 = new JButton("确定");
					button_5.setIcon(new ImageIcon(
							"E:\\\u5C0F\u53EF\u7231\u554A\\find.gif"));
					button_5.setBounds(375, 23, 93, 23);
					panel_1.add(button_5);

					button_6 = new JButton("刷新");
					button_6.setIcon(new ImageIcon(
							"E:\\\u5C0F\u53EF\u7231\u554A\\b1.gif"));
					button_6.setBounds(499, 23, 93, 23);
					panel_1.add(button_6);

					button_2 = new JButton("今日来宾");
					button_2.setIcon(new ImageIcon(
							"E:\\\u5C0F\u53EF\u7231\u554A\\recall.gif"));
					button_2.setBounds(630, 23, 106, 23);
					panel_1.add(button_2);
				}
				{
					textField_5 = new JTextField();
					textField_5.setBackground(Color.GRAY);
					textField_5.setText("所有来宾信息");
					textField_5.setHorizontalAlignment(SwingConstants.CENTER);
					textField_5.setBounds(0, 59, 779, 21);
					panel_1.add(textField_5);
					textField_5.setColumns(10);
				}
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(0, 79, 779, 403);
					panel_1.add(scrollPane);

					tableModel = new DefaultTableModel(coumtaba, 0);
					table_1 = new JTable(tableModel);
					scrollPane.setViewportView(table_1);
				}
			}
			{
				JPanel panel_2 = new JPanel();
				tabbedPane.addTab("在店宾客消费查询", new ImageIcon("E:/小可爱啊/u03.gif"),
						panel_2, null);
				panel_2.setLayout(null);
				{
					checkBox_3 = new JCheckBox("入住时间");
					checkBox_3.setBounds(59, 20, 89, 27);
					panel_2.add(checkBox_3);
				}
				{
					JLabel label = new JLabel("起始时间");
					label.setBounds(169, 24, 72, 18);
					panel_2.add(label);

					textField_6 = new JTextField();
					textField_6.setBounds(237, 21, 153, 24);
					panel_2.add(textField_6);
					textField_6.setColumns(10);
				}
				{
					JLabel label_1 = new JLabel("终止时间");
					label_1.setBounds(435, 24, 72, 18);
					panel_2.add(label_1);

					textField_7 = new JTextField();
					textField_7.setColumns(10);
					textField_7.setBounds(510, 21, 153, 24);
					panel_2.add(textField_7);
				}
				{
					checkBox_1 = new JCheckBox("房间号");
					checkBox_1.setBounds(59, 70, 89, 27);
					panel_2.add(checkBox_1);

					textField_8 = new JTextField();
					textField_8.setBounds(155, 71, 179, 24);
					panel_2.add(textField_8);
					textField_8.setColumns(10);
				}
				{
					button_7 = new JButton("查询");
					button_7.setIcon(new ImageIcon(
							"G:\\A+family\u9152\u5E97\u7BA1\u7406\u7CFB\u7EDF\\Family\\gif\\find.gif"));
					button_7.setBounds(381, 70, 100, 27);
					panel_2.add(button_7);
				}
				{
					button_8 = new JButton("刷新");
					button_8.setIcon(new ImageIcon(
							"G:\\A+family\u9152\u5E97\u7BA1\u7406\u7CFB\u7EDF\\Family\\gif\\b1.gif"));
					button_8.setBounds(532, 70, 100, 27);
					panel_2.add(button_8);
				}
				{
					textField_9 = new JTextField();
					textField_9.setBackground(Color.GRAY);
					textField_9.setHorizontalAlignment(SwingConstants.CENTER);
					textField_9.setText("在店宾客消费");
					textField_9.setBounds(0, 106, 779, 24);
					panel_2.add(textField_9);
					textField_9.setColumns(10);
				}
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(0, 129, 765, 338);
					panel_2.add(scrollPane);

					tableModel = new DefaultTableModel(coumfour, 0);
					table_2 = new JTable(tableModel);
					scrollPane.setViewportView(table_2);
				}
			}
			{

				JPanel panel_3 = new JPanel();
				tabbedPane.addTab("离店宾客消费查询", null, panel_3, null);
				panel_3.setLayout(null);
				{
					checkBox = new JCheckBox("结账时间");
					checkBox.setBounds(61, 24, 89, 27);
					panel_3.add(checkBox);
				}
				{
					JLabel label = new JLabel("起始时间");
					label.setBounds(179, 28, 67, 18);
					panel_3.add(label);

					textField_10 = new JTextField();
					textField_10.setBounds(247, 25, 126, 24);
					panel_3.add(textField_10);
					textField_10.setColumns(10);
				}
				{
					JLabel label_1 = new JLabel("终止时间");
					label_1.setBounds(418, 28, 72, 18);
					panel_3.add(label_1);

					textField_11 = new JTextField();
					textField_11.setBounds(493, 25, 183, 24);
					panel_3.add(textField_11);
					textField_11.setColumns(10);
				}
				{
					chckbxNewCheckBox_1 = new JCheckBox("查询时间");
					chckbxNewCheckBox_1.setBounds(61, 56, 89, 27);
					panel_3.add(chckbxNewCheckBox_1);
				}
				{
					comboBox = new JComboBox();
					comboBox.setModel(new DefaultComboBoxModel(new String[] {
							"按结账单号", "按房间编号" }));
					comboBox.setBounds(179, 57, 107, 24);
					panel_3.add(comboBox);
				}
				{
					JLabel label_2 = new JLabel("关键字：");
					label_2.setBounds(301, 62, 60, 18);
					panel_3.add(label_2);

					textField_12 = new JTextField();
					textField_12.setBounds(360, 59, 86, 24);
					panel_3.add(textField_12);
					textField_12.setColumns(10);
				}
				{
					button = new JButton("查询");
					button.setIcon(new ImageIcon(
							"G:\\A+family\u9152\u5E97\u7BA1\u7406\u7CFB\u7EDF\\Family\\gif\\find.gif"));
					button.setBounds(460, 59, 86, 27);
					panel_3.add(button);
				}
				{
					button_1 = new JButton("刷新");
					button_1.setIcon(new ImageIcon(
							"G:\\A+family\u9152\u5E97\u7BA1\u7406\u7CFB\u7EDF\\Family\\gif\\b1.gif"));
					button_1.setBounds(572, 59, 95, 27);
					panel_3.add(button_1);
				}
				{
					textField_13 = new JTextField();
					textField_13.setBackground(Color.GRAY);
					textField_13.setText("离店宾客消费");
					textField_13.setHorizontalAlignment(SwingConstants.CENTER);
					textField_13.setBounds(0, 102, 779, 24);
					panel_3.add(textField_13);
					textField_13.setColumns(10);
				}
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(0, 127, 765, 340);
					panel_3.add(scrollPane);

					tableModel = new DefaultTableModel(coumfour, 0);
					table_3 = new JTable(tableModel);
					scrollPane.setViewportView(table_3);
				}
			}
		}
	}
}
