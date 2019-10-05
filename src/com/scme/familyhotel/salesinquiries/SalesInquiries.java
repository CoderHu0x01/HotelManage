package com.scme.familyhotel.salesinquiries;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
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

import com.scme.familyhotel.dao.SalesInquiriesDao;
import com.scme.familyhotel.daoimpl.SalesInquiriesDaoImpl;
import com.scme.familyhotel.result.FrameLocation;

public class SalesInquiries extends JFrame {
	SalesInquiriesDao salesInquiriesDaoImpl = new SalesInquiriesDaoImpl();

	// private JDBCTemplate jdbcTemplate = new JDBCTemplate();

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private DefaultTableModel tableModel1;
	private DefaultTableModel tableModel2;
	private DefaultTableModel tableModel3;
	private DefaultTableModel tableModel4;
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

	private String[] coumData = { "�˵���", "�����", "��������", "����Ѻ��", "ʵ��Ѻ��", "����ʱ��", "��ע" };
	private String[] coumtaba = { "��Ա���", "�����", "��������", "�Ա�", "֤������", "֤�����", "����", "Ѻ��", "Ԥס����", "��ǰ״̬", "��סʱ��",
			"����ʱ��", "���㵥��" };
	private String[] coumfour = { "�����", "��������", "����", "�ۿ۱���", "�ۺ󵥼�", "�Żݽ��", "��סʱ��" };

	int value;
	int value2;

	// /**
	// * Launch the application.
	// */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// SalesInquiries frame = new SalesInquiries();
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
	public SalesInquiries() {
		{
			// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 800, 550);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			this.setTitle("Ӫҵ��ѯ");
			FrameLocation.frameLocation(this, null);
		}
		{
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(0, 0, 784, 512);
			contentPane.add(tabbedPane);

			{
				JPanel panel = new JPanel();
				tabbedPane.addTab("���˵���ѯ", new ImageIcon("pic/u04.gif"), panel, null);
				panel.setLayout(null);

				chckbxNewCheckBox = new JCheckBox("����ʱ��");
				chckbxNewCheckBox.setBounds(101, 17, 86, 23);
				panel.add(chckbxNewCheckBox);

				{
					JLabel label = new JLabel("��ʼʱ��");
					label.setBounds(193, 21, 54, 15);
					panel.add(label);

					textField = new JTextField();
					textField.setBounds(246, 18, 121, 21);
					panel.add(textField);
					textField.setColumns(10);
				}
				{
					JLabel label_1 = new JLabel("��ֹ��ѯ");
					label_1.setBounds(428, 21, 54, 15);
					panel.add(label_1);

					textField_1 = new JTextField();
					textField_1.setBounds(492, 18, 132, 21);
					panel.add(textField_1);
					textField_1.setColumns(10);
				}
				{
					checkBox_2 = new JCheckBox("����/����/�˵���");
					checkBox_2.setBounds(101, 70, 132, 23);
					panel.add(checkBox_2);

					chckbxNewCheckBox.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {

							value = 1;
						}
					});

					checkBox_2.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {

							value = 2;

						}
					});

					textField_2 = new JTextField();
					textField_2.setBounds(246, 71, 121, 21);
					panel.add(textField_2);
					textField_2.setColumns(10);

					ButtonGroup group = new ButtonGroup();
					group.add(chckbxNewCheckBox);
					group.add(checkBox_2);
				}
				{
					button_3 = new JButton("��ѯ");

					button_3.setIcon(new ImageIcon("pic\\find.gif"));
					button_3.setBounds(425, 70, 86, 23);
					panel.add(button_3);

					button_3.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if (value == 1) {
								tableModel1.getDataVector().clear();

								ArrayList<ArrayList<Object>> listInfo = salesInquiriesDaoImpl
										.queryNRZInfo(textField_2.getText());

								for (ArrayList<Object> info : listInfo) {
									Object[] rowData = info.toArray();
									tableModel1.addRow(rowData);
								}

								tableModel1.getDataVector().clear();
								ArrayList<ArrayList<Object>> listTimeInfo = salesInquiriesDaoImpl
										.queryTimenfo(textField.getText(), textField_1.getText());
								for (ArrayList<Object> timeinfo : listTimeInfo) {
									Object[] rowData = timeinfo.toArray();
									tableModel1.addRow(rowData);
								}
							} else if (value == 2) {
								tableModel1.getDataVector().clear();

								ArrayList<ArrayList<Object>> listInfo = salesInquiriesDaoImpl
										.queryNRZInfo(textField_2.getText());

								for (ArrayList<Object> info : listInfo) {
									Object[] rowData = info.toArray();
									tableModel1.addRow(rowData);
								}
							}

						}
					});

					button_4 = new JButton("ˢ��");
					button_4.setIcon(new ImageIcon("pic\\b1.gif"));
					button_4.setBounds(538, 70, 86, 23);
					panel.add(button_4);
					button_4.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							queryListInfo();
						}

					});

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

					tableModel1 = new DefaultTableModel(coumData, 0);

					queryListInfo();

					table = new JTable(tableModel1);
					scrollPane.setViewportView(table);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				tabbedPane.addTab("ȫ��������Ϣ��ѯ", new ImageIcon("pic/u02.gif"), panel_1, null);
				panel_1.setLayout(null);
				{
					JLabel label = new JLabel("��������/֤�����/�����");
					label.setBounds(90, 27, 112, 15);
					panel_1.add(label);

					textField_4 = new JTextField();
					textField_4.setBounds(197, 24, 124, 21);
					panel_1.add(textField_4);
					textField_4.setColumns(10);
				}
				{
					button_5 = new JButton("ȷ��");
					button_5.setIcon(new ImageIcon("pic\\find.gif"));
					button_5.setBounds(375, 23, 93, 23);
					panel_1.add(button_5);
					button_5.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							tableModel2.getDataVector().clear();

							ArrayList<ArrayList<Object>> listInfo = salesInquiriesDaoImpl
									.queryNCRO(textField_4.getText());

							for (ArrayList<Object> info : listInfo) {
								Object[] rowData = info.toArray();
								tableModel2.addRow(rowData);
							}

						}
					});

					button_6 = new JButton("ˢ��");
					button_6.setIcon(new ImageIcon("pic\\b1.gif"));
					button_6.setBounds(499, 23, 93, 23);
					panel_1.add(button_6);
					button_6.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							tableModel2.getDataVector().clear();

							ArrayList<ArrayList<Object>> listAllGuestInfo = salesInquiriesDaoImpl.queryAllGuestInfo();
							for (ArrayList<Object> allInfo : listAllGuestInfo) {
								Object[] rowData = allInfo.toArray();
								tableModel2.addRow(rowData);
							}

						}
					});

					button_2 = new JButton("��������");
					button_2.setIcon(new ImageIcon("pic\\recall.gif"));
					button_2.setBounds(630, 23, 106, 23);
					panel_1.add(button_2);
				}
				{
					textField_5 = new JTextField();
					textField_5.setBackground(Color.GRAY);
					textField_5.setText("����������Ϣ");
					textField_5.setHorizontalAlignment(SwingConstants.CENTER);
					textField_5.setBounds(0, 59, 779, 21);
					panel_1.add(textField_5);
					textField_5.setColumns(10);
				}
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(0, 79, 779, 403);
					panel_1.add(scrollPane);
					tableModel2 = new DefaultTableModel(coumtaba, 0);

					ArrayList<ArrayList<Object>> listAllGuestInfo = salesInquiriesDaoImpl.queryAllGuestInfo();
					for (ArrayList<Object> allInfo : listAllGuestInfo) {
						Object[] rowData = allInfo.toArray();
						tableModel2.addRow(rowData);
					}

					table_1 = new JTable(tableModel2);
					scrollPane.setViewportView(table_1);
				}
			}
			{
				JPanel panel_2 = new JPanel();
				tabbedPane.addTab("�ڵ�������Ѳ�ѯ", new ImageIcon("pic/u03.gif"), panel_2, null);
				panel_2.setLayout(null);
				{
					checkBox_3 = new JCheckBox("��סʱ��");
					checkBox_3.setBounds(59, 20, 89, 27);
					panel_2.add(checkBox_3);
				}
				{
					JLabel label = new JLabel("��ʼʱ��");
					label.setBounds(169, 24, 72, 18);
					panel_2.add(label);

					textField_6 = new JTextField();
					textField_6.setBounds(237, 21, 153, 24);
					panel_2.add(textField_6);
					textField_6.setColumns(10);
				}
				{
					JLabel label_1 = new JLabel("��ֹʱ��");
					label_1.setBounds(435, 24, 72, 18);
					panel_2.add(label_1);

					textField_7 = new JTextField();
					textField_7.setColumns(10);
					textField_7.setBounds(510, 21, 153, 24);
					panel_2.add(textField_7);
				}
				{
					checkBox_1 = new JCheckBox("�����");
					checkBox_1.setBounds(59, 70, 89, 27);
					panel_2.add(checkBox_1);

					textField_8 = new JTextField();
					textField_8.setBounds(155, 71, 179, 24);
					panel_2.add(textField_8);
					textField_8.setColumns(10);
					
					ButtonGroup group2=new ButtonGroup();
					group2.add(checkBox_3);
					group2.add(checkBox_1);
					
					checkBox_3.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {

							value2 = 1;
						}
					});

					checkBox_1.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {

							value2 = 2;

						}
					});
					
				}
				{
					button_7 = new JButton("��ѯ");
					button_7.setIcon(new ImageIcon("pic\\find.gif"));
					button_7.setBounds(381, 70, 100, 27);
					panel_2.add(button_7);
					button_7.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if (value2 == 1) {

								tableModel3.getDataVector().clear();
								ArrayList<ArrayList<Object>> listTimeInfo = salesInquiriesDaoImpl
										.queryConsumetTime(textField_6.getText(), textField_7.getText());
								for (ArrayList<Object> timeinfo : listTimeInfo) {
									Object[] rowData = timeinfo.toArray();
									tableModel3.addRow(rowData);
								}
							} else if (value2 == 2) {
								tableModel3.getDataVector().clear();

								ArrayList<ArrayList<Object>> listInfo = salesInquiriesDaoImpl
										.queryConsumetRoomNo(textField_8.getText());

								for (ArrayList<Object> info : listInfo) {
									Object[] rowData = info.toArray();
									tableModel3.addRow(rowData);
								}
							}

						}
					});

				}
				{
					button_8 = new JButton("ˢ��");
					button_8.setIcon(new ImageIcon("pic\\b1.gif"));
					button_8.setBounds(532, 70, 100, 27);
					panel_2.add(button_8);
				}
				{
					textField_9 = new JTextField();
					textField_9.setBackground(Color.GRAY);
					textField_9.setHorizontalAlignment(SwingConstants.CENTER);
					textField_9.setText("�ڵ��������");
					textField_9.setBounds(0, 106, 779, 24);
					panel_2.add(textField_9);
					textField_9.setColumns(10);
				}
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(0, 129, 765, 338);
					panel_2.add(scrollPane);

					tableModel3 = new DefaultTableModel(coumfour, 0);
					ArrayList<ArrayList<Object>> listConsumeInfo = salesInquiriesDaoImpl.consumeInfo();
					for (ArrayList<Object> allInfo : listConsumeInfo) {
						Object[] rowData = allInfo.toArray();
						tableModel3.addRow(rowData);
					}

					table_2 = new JTable(tableModel3);
					scrollPane.setViewportView(table_2);
				}
			}
			{

				JPanel panel_3 = new JPanel();
				tabbedPane.addTab("���������Ѳ�ѯ", null, panel_3, null);
				panel_3.setLayout(null);
				{
					checkBox = new JCheckBox("����ʱ��");
					checkBox.setBounds(61, 24, 89, 27);
					panel_3.add(checkBox);
				}
				{
					JLabel label = new JLabel("��ʼʱ��");
					label.setBounds(179, 28, 67, 18);
					panel_3.add(label);

					textField_10 = new JTextField();
					textField_10.setBounds(247, 25, 126, 24);
					panel_3.add(textField_10);
					textField_10.setColumns(10);
				}
				{
					JLabel label_1 = new JLabel("��ֹʱ��");
					label_1.setBounds(418, 28, 72, 18);
					panel_3.add(label_1);

					textField_11 = new JTextField();
					textField_11.setBounds(493, 25, 183, 24);
					panel_3.add(textField_11);
					textField_11.setColumns(10);
				}
				{
					chckbxNewCheckBox_1 = new JCheckBox("��ѯʱ��");
					chckbxNewCheckBox_1.setBounds(61, 56, 89, 27);
					panel_3.add(chckbxNewCheckBox_1);

					
				}
				{
					comboBox = new JComboBox();
					comboBox.setModel(new DefaultComboBoxModel(new String[] { "�����˵���", "��������" }));
					comboBox.setBounds(179, 57, 107, 24);
					panel_3.add(comboBox);
				}
				{
					JLabel label_2 = new JLabel("�ؼ��֣�");
					label_2.setBounds(301, 62, 60, 18);
					panel_3.add(label_2);

					textField_12 = new JTextField();
					textField_12.setBounds(360, 59, 86, 24);
					panel_3.add(textField_12);
					textField_12.setColumns(10);
				}
				{
					button = new JButton("��ѯ");
					button.setIcon(new ImageIcon("pic\\find.gif"));
					button.setBounds(460, 59, 86, 27);
					panel_3.add(button);
					
					
					
					
					
				}
				{
					button_1 = new JButton("ˢ��");
					button_1.setIcon(new ImageIcon("pic\\b1.gif"));
					button_1.setBounds(572, 59, 95, 27);
					panel_3.add(button_1);
				}
				{
					textField_13 = new JTextField();
					textField_13.setBackground(Color.GRAY);
					textField_13.setText("����������");
					textField_13.setHorizontalAlignment(SwingConstants.CENTER);
					textField_13.setBounds(0, 102, 779, 24);
					panel_3.add(textField_13);
					textField_13.setColumns(10);
				}
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(0, 127, 765, 340);
					panel_3.add(scrollPane);

					tableModel4 = new DefaultTableModel(coumfour, 0);

					table_3 = new JTable(tableModel4);
					scrollPane.setViewportView(table_3);
				}
			}
		}

	}

	public void queryListInfo() {
		tableModel1.getDataVector().clear();
		// �ӽ��˷����в�ѯ������
		ArrayList<ArrayList<Object>> listBill = salesInquiriesDaoImpl.queryBillInfo();

		for (ArrayList<Object> listTemp : listBill) {
			// ������ת����
			Object[] arrayBill = listTemp.toArray();

			tableModel1.addRow(arrayBill);
		}
	}

}
