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
 * ======================== ����ɢ�Ϳ�����ͼ�ν��� ========================
 * 
 * @author ����
 * @version 1.0
 * @date 2017-5-8
 * 
 *
 */
public class GraphicsIndividual extends JFrame {
	private static final long serialVersionUID = 1L;

	// �ɹ�������ģ��
	private DefaultTableModel modelHaveRoom;
	// ����������ģ��
	private DefaultTableModel modelAddRoom;

	private JTable cvailableTable;
	private JTable billiTable;

	// JInternalFrame indInterFrame = new JInternalFrame("ɢ�Ϳ���", false, false,
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
	// ������
	//static String no;

	// ��ѯ���ɹ�����
	ArrayList<Room> haveRoom;

	// ���ͱ��
	int gesNo;

	public GraphicsIndividual() {
		/**
		 * Container getContentPane() ���ش˴���� contentPane ���� (���ص�ǰ���������ռ�)
		 */

		setSize(600, 650);
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		setTitle("ɢ�Ϳ���");
		setResizable(false);
		FrameLocation.frameLocation(this, "pic//u01.gif");

		// setUndecorated(true);

		guest = new Guest();
		// gjl = new GuestJdbcImpl();
		// ���弯�ϴ洢�ӽ����õ�����
		ArrayList<String> list = new ArrayList<String>();

		// ����һ���ڲ�������
		// indInterFrame.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		// indInterFrame.setSize(600, 650);

		JLabel topLabel = new JLabel("������Ϣ", JLabel.CENTER);
		topLabel.setPreferredSize(new Dimension(590, 20));
		topLabel.setBorder(BorderFactory.createLineBorder(Color.red));

		juestLabel = new JLabel("���ͷ���:");
		juestLabel2 = new JLabel();
		juestLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		juestLabel2.setPreferredSize(new Dimension(120, 30));

		bilLabel = new JLabel("��������:");
		bilLabel2 = new JLabel();
		bilLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		bilLabel2.setPreferredSize(new Dimension(120, 30));

		presetLabel = new JLabel("Ԥ��۸�:");
		presetLabel2 = new JLabel();
		presetLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		presetLabel2.setPreferredSize(new Dimension(120, 30));

		// ������Ϣ
		setLabel();

		jintCre = new JointModule();
		String[] credeType = { "���֤", "ѧ��֤" };
		JPanel idPanel = jintCre.labelCom("֤������:", credeType, new Dimension(80, 30), 10, 10, 0, 50);

		jintNum = new JointModule();
		JPanel typePanel = jintNum.labelField("֤�����:", null, new Dimension(100, 30), 10, 10, 0, 50);

		jintGender = new JointModule();
		String[] gender = { "��", "Ů" };
		JPanel sexPanel = jintGender.labelCom("�����Ա�:", gender, new Dimension(60, 30), 10, 5, 0, 0);

		jintGenTy = new JointModule();
		String[] guestType = { "��ͨ����", "��Ա����" };
		JPanel guestPanel = jintGenTy.labelCom("��������:", guestType, new Dimension(80, 30), 0, 10, 0, 40);

		jintName = new JointModule();
		JPanel namePanel = jintName.labelField("��������:", null, new Dimension(100, 30), 0, 20, 0, 10);

		jintSum = new JointModule();
		JPanel sumPanel = jintSum.labelField("��������:", null, new Dimension(100, 30), 0, 5, 0, 0);

		jintAdder = new JointModule();
		JPanel addressPanel = jintAdder.labelField("��ַ��Ϣ:", null, new Dimension(500, 30), 0, 10, 0, 0);

		jintInfo = new JointModule();
		JPanel infoPanel = jintInfo.labelField("��ע��Ϣ:", null, new Dimension(500, 30), 0, 10, 0, 0);

		jintDisco = new JointModule();
		JPanel discountPanel = jintDisco.jointlabel("�ۿ۱���:", "10", new Dimension(50, 30), 0, 10, 0, 10);

		jintReal = new JointModule();
		JPanel realityPanel = jintReal.jointlabel("ʵ�ʵ���:", roomPice2, new Dimension(50, 30), 0, 10, 0, 10);

		jintLived = new JointModule();
		JPanel livedPanel = jintLived.labelField("Ԥס����:", null, new Dimension(50, 30), 0, 10, 0, 10);

		jintCash = new JointModule();
		JPanel cashPanel = jintCash.labelField("ʵ��Ѻ��:", null, new Dimension(60, 30), 0, 10, 0, 10);

		// ������ѡ��
		hourCheckBox = new JCheckBox("�ӵ㷿");
		hourCheckBox.setBorder(BorderFactory.createEmptyBorder(10, 15, 20, 100));

		JCheckBox warnCheckBox = new JCheckBox("����Ԥס�����Զ�����");
		warnCheckBox.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 200));

		// "׷�ӷ���"����
		JTabbedPane addRoomTabblePane = graphicsAddRoom();

		// ��ʾ
		JLabel label = new JLabel("��ʾ:ֻ��׷��ͬ�࣬����ֻ��4�䣬��Ҫ׷�Ӳ�ͬ������ѡ�����忪����");
		// ����������ɫ
		label.setForeground(Color.red);
		label.setPreferredSize(new Dimension(600, 40));
		// label.setBorder(BorderFactory.createEmptyBorder(60, 80, 50, 50));
		label.setBorder(BorderFactory.createLineBorder(Color.red));

		// ȷ����ȡ����ť
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 150, 25));
		buttonPanel.setPreferredSize(new Dimension(500, 100));

		ImageIcon confirmIco = new ImageIcon("pic//modi3.gif");
		ImageIcon abolishIco = new ImageIcon("pic//cancel.gif");

		JButton confirmButton = new JButton("ȷ��", confirmIco);

		confirmButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!(jintNum.getFliText().equals("") || jintName.getFliText().equals("")
						|| jintAdder.getFliText().equals("") || jintInfo.getFliText().equals("")
						|| jintCash.getFliText().equals("") || jintSum.getFliText().equals("")
						|| jintLived.getFliText().equals(""))) {

					// ��ʾ��ʾ����ȷ�ϲ���
					PromptFrame();

				} else {
					new JOptionPane().showMessageDialog(null, "�뽫������д������");
				}
			}

		});

		JButton abolishButtonnew = new JButton("ȡ��", abolishIco);
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

	// �ײ�"׷�ӷ���"����
	public JTabbedPane graphicsAddRoom() {
		modelHaveRoom = new DefaultTableModel(new String[] { "�ɹ�����" }, 0);
		modelAddRoom = new DefaultTableModel(new String[] { "��������" }, 0);

		// ��ǩ����
		JTabbedPane tabblePane = new JTabbedPane();
		tabblePane.setPreferredSize(new Dimension(590, 200));
		// JPanel����
		JPanel roomInfoPanel = new JPanel();

		// ��ѯ���ɹ�����
		ArrayList<Room> haveRoom = individdualDaoImpl.queryHaveRoom();
		for (Room hRoom : haveRoom) {
			modelHaveRoom.addRow(new Object[] { hRoom.getRoomNo() });
		}

		// �򿪵��������������
		modelAddRoom.addRow(new Object[] { roomNo2 });

		// �������
		cvailableTable = new JTable(modelHaveRoom);
		billiTable = new JTable(modelAddRoom);

		// ���ñ��Ԫ��߶�
		cvailableTable.setRowHeight(20);
		billiTable.setRowHeight(20);

		// ��������,����������
		// �ɹ�����
		JScrollPane cvailableScroll = new JScrollPane(cvailableTable);
		cvailableScroll.setPreferredSize(new Dimension(230, 250));
		// ׷�ӷ���
		JScrollPane billiScroll = new JScrollPane(billiTable);
		billiScroll.setPreferredSize(new Dimension(230, 250));

		// �м��ѡ��ť
		ImageIcon confirmIco = new ImageIcon("pic//right.gif");
		ImageIcon abolishIco = new ImageIcon("pic//left.gif");

		JPanel pane = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 30));
		pane.setPreferredSize(new Dimension(100, 250));
		pane.setBorder(BorderFactory.createLineBorder(Color.red));

		JButton button1 = new JButton(confirmIco);
		// ����ť������ʾ�ı�
		button1.setToolTipText("��ӵ�������");
		button1.setPreferredSize(new Dimension(20, 20));
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cvailableTable.getSelectedRow() != -1) {
					// ��ȡ��ǰ�������
					int row = cvailableTable.getSelectedRow();

					// ��õ�ǰ����ָ���е�ֵ
					Object value = cvailableTable.getValueAt(row, 0);
					// ��ֵ���뵽����һ�������
					modelAddRoom.addRow(new Object[] { value });

					// �Ƴ���ǰ��
					modelHaveRoom.removeRow(row);
				}
			}
		});

		JButton button2 = new JButton(abolishIco);
		button2.setToolTipText("�ӿ������Ƴ�");
		button2.setPreferredSize(new Dimension(20, 20));
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (billiTable.getSelectedRow() != -1) {
					// ��ȡ��ǰ��
					int row = billiTable.getSelectedRow();
					// �Ƴ�ָ��������
					modelAddRoom.removeRow(row);
				}
			}
		});

		pane.add(button1);
		pane.add(button2);

		roomInfoPanel.add(cvailableScroll);
		roomInfoPanel.add(pane);
		roomInfoPanel.add(billiScroll);

		tabblePane.add("׷�ӷ���", roomInfoPanel);

		return tabblePane;
	}

	// ��ȡ������Ϣ
	public static void setInfo(String roomNo, String roomType, String roomPice) {
		// System.out.println(roomNo + "**+++++");
		roomNo2 = roomNo;
		roomType2 = roomType;
		roomPice2 = roomPice;

		//no = roomNo;
	}

	// ��������Ϣ�����ǩ������
	public static void setLabel() {
		juestLabel2.setText(roomNo2);
		bilLabel2.setText(roomType2);
		presetLabel2.setText(roomPice2);

		juestLabel2.setForeground(Color.blue);
		bilLabel2.setForeground(Color.blue);
		presetLabel2.setForeground(Color.red);

	}

	// ���ɽ��˵���(��ס����)
	public void generateCheckNumber() {
		// �����ܽ��
		double countPrice = countCheckPrice();

		Bill bill = new Bill();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
		// ��ȡ��ǰʱ��
		Date date = new Date();
		String dateBillNo = dateFormat.format(date);
		System.out.println(dateBillNo);

		bill.setBillNo(dateBillNo);
		bill.setGuestNo(gesNo);
		bill.setExpendPrice(countPrice);
		bill.setRebate(10);
		bill.setTallyPeople(Login.getLoginUser());
		bill.setExpendTime(new Timestamp(new Date().getTime()));

		// �����ݿ��в�����˵��ź��ܽ��
		individdualDaoImpl.insertBillInfo(bill);
	}

	// �����ܽ��
	public double countCheckPrice() {
		// �洢�ܽ��
		double countPrice = 0;
		// ��ȡ������
		int rowCount = modelAddRoom.getRowCount();

		// ��ȡ��ǰ����������е�����
		for (int i = 0; i < rowCount; i++) {
			String valueData = (String) billiTable.getValueAt(i, 0);
			// System.out.println(valueData + " 66666");
			countPrice += individdualDaoImpl.queryRoomPrice(valueData);
		}
		System.out.println("�����ܼ�" + countPrice);

		return countPrice;
	}

	// ��ʾ����
	public void PromptFrame() {
		JFrame frame = new JFrame();
		frame.setLayout(null);
		frame.setSize(450, 200);
		frame.setTitle("��ʾ");

		// ��ʼ������
		JLabel lable = new JLabel("��ȷ���ѵ�ǰ������Ϣ����[" + roomNo2 + "]Ϊ�����俪�跿����");
		lable.setBounds(50, 30, 400, 50);
		frame.add(lable);

		JButton yesButton = new JButton("��");
		yesButton.setBounds(50, 80, 47, 40);
		yesButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// ȷ��ʱ�䴦��
				actionConfirmIndividual();
				frame.dispose();

				// �ͷ�ɢ�Ϳ�������
				dispose();

			}
		});

		JButton noButton = new JButton("��");
		noButton.setBounds(330, 80, 47, 40);
		frame.add(yesButton);
		frame.add(noButton);

		FrameLocation.frameLocation(frame, null);

		frame.setVisible(true);
	}

	// ȷ�ϰ�ťʱ�����¼�
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
			// ��ӷ�����Ϣ����
			individdualDaoImpl.createGueInfo(guest);

			// ������������
			// String sum = jintSum.getFliText();
			int sumjin = Integer.parseInt(jintSum.getFliText());
			individdualDaoImpl.createRoomInfo(sumjin, roomNo2);

			// ����Ԥס����
			// String live = jintLived.getFliText();
			int liveDay = Integer.parseInt(jintLived.getFliText());
			individdualDaoImpl.createRes(roomNo2, liveDay);

			// setVisible(false);

			// ��ѯ��Ӧ�ı��ͱ��ͨ��֤�����
			gesNo = individdualDaoImpl.findGuestNo(jintNum.getFliText());
			// �����ͱ�Ų��뷿����Ϣ��
			individdualDaoImpl.createRoomInfo2(gesNo, roomNo2);

			// ����ӵ㷿��ť�Ǳ�ѡ�еģ���ִ�и���
			if (hourCheckBox.isSelected()) {
				individdualDaoImpl.updateRoomState(hourCheckBox.getText(), roomNo2);
			}

			// ���ɽ��˵��źͼ����ܽ��
			generateCheckNumber();

		} else {
			new JOptionPane().showMessageDialog(null, "�뽫������д������");
		}
	}
}
