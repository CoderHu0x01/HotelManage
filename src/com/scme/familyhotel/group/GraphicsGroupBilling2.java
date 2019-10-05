package com.scme.familyhotel.group;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.fabric.xmlrpc.base.Array;
import com.scme.familyhotel.dao.GroupDao;
import com.scme.familyhotel.daoimpl.GroupDaoImpl;
import com.scme.familyhotel.pojo.Room;
import com.scme.familyhotel.result.FrameLocation;

public class GraphicsGroupBilling2 extends JFrame {
	GroupDao groupDaoImpl = new GroupDaoImpl();

	private JPanel cp_groupBill;
	private JTextField text_coding;
	private JTextField text_name;
	private JTextField text_number;
	private JTextField text_deposit;
	private JTextField text_host;
	private JTextField text_date;
	private JTextField tex_address;
	private JTextField text_remarks;
	private JTable table;
	private DefaultTableModel tableModel;
	// private String[] coumData = { "�ͷ����", "��׼����" };
	private JTable table2;
	private DefaultTableModel tableModel2;
	private JPanel panel;
	private JButton button_increase;
	private JScrollPane scrollPane_1;
	private JComboBox box_roomType;
	private JButton button_delete;
	private JComboBox box_certificates;
	private JComboBox box_guerts;
	private JComboBox box_gender;
	private JCheckBox checkBox;
	private JButton button_determine;
	private JButton button_cancel;

	// /**
	// * Launch the application.
	// */
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
	public GraphicsGroupBilling2() {
		{
			this.setTitle("���忪��");
			// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 550, 600);
			cp_groupBill = new JPanel();
			cp_groupBill.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(cp_groupBill);
			cp_groupBill.setLayout(null);
			FrameLocation.frameLocation(this, null);
		}

		{
			panel = new JPanel();
			panel.setBounds(10, 36, 252, 233);
			cp_groupBill.add(panel);
			panel.setLayout(null);
			panel.setBorder(BorderFactory.createLineBorder(Color.BLUE));

			button_increase = new JButton("���ӵ�������");
			button_increase.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\new.gif"));
			button_increase.setBounds(0, 210, 252, 23);
			panel.add(button_increase);
			button_increase.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					if (table.getSelectedRow() != -1) {
						// ��ȡ��ǰ�е������
						int row = table.getSelectedRow();
						// ��ȡָ���е�һ�е�����
						Object valueData = table.getValueAt(row, 0);
						// ��ȡָ���еڶ��е�����
						Object valueData2 = table.getValueAt(row, 1);

						// ��������ݼ��뵽�Ҳ�������
						tableModel2.addRow(new Object[] { valueData, valueData2 });
					}
				}
			});

			scrollPane_1 = new JScrollPane();
			scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane_1.setBounds(0, 27, 252, 183);
			panel.add(scrollPane_1);

			tableModel = new DefaultTableModel(new String[] { "�ͷ����", "��׼����" }, 0);

			table = new JTable(tableModel);
			scrollPane_1.setViewportView(table);

			JLabel label = new JLabel("�������ͣ�");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(10, 10, 71, 15);
			panel.add(label);

			box_roomType = new JComboBox();
			box_roomType.setModel(
					new DefaultComboBoxModel(new String[] { "��׼���˼�", "��׼˫�˼�", "�������˼�", "����˫�˼�", "�����׷�", "��ͳ�׷�" }));
			box_roomType.setBounds(91, 7, 114, 21);

			actionQueryNoPrice();

			box_roomType.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					tableModel.getDataVector().clear();
					actionQueryNoPrice();
				}
			});

			panel.add(box_roomType);
		}
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(266, 36, 252, 233);
			cp_groupBill.add(panel_1);
			panel_1.setLayout(null);

			button_delete = new JButton("�ӿ�����ɾ��");
			button_delete.setBounds(0, 210, 252, 23);
			button_delete.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\del.gif"));
			panel_1.add(button_delete);
			button_delete.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (table2.getSelectedRow() != -1) {
						// ��ȡ��ǰ�е������
						int row = table2.getSelectedRow();
						// �Ƴ�ָ����
						tableModel2.removeRow(row);

					}
				}
			});

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setBounds(0, 0, 252, 211);
			panel_1.add(scrollPane);

			tableModel2 = new DefaultTableModel(new String[] { "�ͷ����", "��׼����" }, 0);
			table2 = new JTable(tableModel2);
			scrollPane.setViewportView(table2);
		}
		{
			JLabel lblNewLabel = new JLabel("������Ϣ");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(10, 10, 252, 25);
			cp_groupBill.add(lblNewLabel);
			lblNewLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		}
		{
			JLabel label = new JLabel("��������");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBorder(BorderFactory.createLineBorder(Color.BLUE));
			label.setBounds(266, 10, 252, 25);
			cp_groupBill.add(label);
		}
		{
			JLabel label = new JLabel("֤�����ͣ�");
			label.setBounds(2, 300, 64, 15);
			cp_groupBill.add(label);

			box_certificates = new JComboBox();
			box_certificates.setModel(new DefaultComboBoxModel(new String[] { "���֤", "�籣֤" }));
			box_certificates.setBounds(72, 297, 75, 21);
			cp_groupBill.add(box_certificates);
		}
		{
			JLabel label_1 = new JLabel("�������ͣ�");
			label_1.setBounds(157, 300, 72, 15);
			cp_groupBill.add(label_1);

			box_guerts = new JComboBox();
			box_guerts.setModel(new DefaultComboBoxModel(new String[] { "��ͨ����", "��Ա����" }));
			box_guerts.setBounds(239, 297, 88, 21);
			cp_groupBill.add(box_guerts);
		}
		{
			JLabel label_2 = new JLabel("�����Ա�");
			label_2.setBounds(337, 300, 68, 15);
			cp_groupBill.add(label_2);

			box_gender = new JComboBox();
			box_gender.setModel(new DefaultComboBoxModel(new String[] { "��", "Ů", "����" }));
			box_gender.setBounds(411, 297, 75, 21);
			cp_groupBill.add(box_gender);
		}
		{
			JLabel label = new JLabel("֤�����룺");
			label.setBounds(2, 341, 68, 15);
			cp_groupBill.add(label);

			text_coding = new JTextField();
			text_coding.setBounds(72, 338, 75, 21);
			cp_groupBill.add(text_coding);
			text_coding.setColumns(10);
		}
		{
			JLabel label_1 = new JLabel("����������");
			label_1.setBounds(164, 341, 65, 15);
			cp_groupBill.add(label_1);

			text_name = new JTextField();
			text_name.setColumns(10);
			text_name.setBounds(239, 338, 75, 21);
			cp_groupBill.add(text_name);
		}
		{
			JLabel label_2 = new JLabel("����������");
			label_2.setBounds(337, 341, 68, 15);
			cp_groupBill.add(label_2);

			text_number = new JTextField();
			text_number.setColumns(10);
			text_number.setBounds(411, 338, 75, 21);
			cp_groupBill.add(text_number);
		}
		{
			JLabel label = new JLabel("ʵ��Ѻ��");
			label.setBounds(2, 381, 68, 15);
			cp_groupBill.add(label);

			text_deposit = new JTextField();
			text_deposit.setColumns(10);
			text_deposit.setBounds(72, 378, 75, 21);
			cp_groupBill.add(text_deposit);
		}
		{
			JLabel label_1 = new JLabel("���ͷ��䣺");
			label_1.setBounds(164, 381, 65, 15);
			cp_groupBill.add(label_1);

			text_host = new JTextField();
			text_host.setColumns(10);
			text_host.setBounds(239, 378, 75, 21);
			cp_groupBill.add(text_host);
		}
		{
			JLabel label_2 = new JLabel("Ԥס������");
			label_2.setBounds(337, 381, 68, 15);
			cp_groupBill.add(label_2);

			text_date = new JTextField();
			text_date.setColumns(10);
			text_date.setBounds(411, 378, 75, 21);
			cp_groupBill.add(text_date);
		}
		{
			JLabel label = new JLabel("��ַ��Ϣ");
			label.setBounds(10, 417, 60, 15);
			cp_groupBill.add(label);

			tex_address = new JTextField();
			tex_address.setBounds(72, 414, 414, 21);
			cp_groupBill.add(tex_address);
			tex_address.setColumns(10);
		}
		{
			JLabel label_1 = new JLabel("��ע��Ϣ");
			label_1.setBounds(10, 442, 60, 15);
			cp_groupBill.add(label_1);

			text_remarks = new JTextField();
			text_remarks.setColumns(10);
			text_remarks.setBounds(72, 442, 414, 21);
			cp_groupBill.add(text_remarks);
		}
		{
			checkBox = new JCheckBox("��Ԥס����ʱ�Զ�����");
			checkBox.setBounds(26, 481, 236, 23);
			cp_groupBill.add(checkBox);
		}
		{
			button_determine = new JButton("ȷ��");
			button_determine.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\modi3.gif"));
			button_determine.setBounds(98, 518, 93, 23);
			cp_groupBill.add(button_determine);
		}
		{
			button_cancel = new JButton("ȡ��");
			button_cancel.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\cancel.gif"));
			button_cancel.setBounds(254, 518, 93, 23);
			cp_groupBill.add(button_cancel);
		}

	}

	// ��������Ϣ��ѯ����Ϣ
	public void actionQueryNoPrice() {
		String roomType = (String) box_roomType.getSelectedItem();
		ArrayList<Room> roomNoPriceList = groupDaoImpl.queryRoomNoPrice(roomType);
		for (Room roomNoPrice : roomNoPriceList) {
			tableModel.addRow(new Object[] { roomNoPrice.getRoomNo(), roomNoPrice.getRoomPrice() });
		}
	}

}
