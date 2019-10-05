package com.scme.familyhotel.mainframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.scme.familyhotel.dao.GraphicsLeftDao;
import com.scme.familyhotel.daoimpl.GraphicsLeftImpl;
import com.scme.familyhotel.pojo.Guest;
import com.scme.familyhotel.pojo.Room;
import com.scme.familyhotel.result.JointModule;

/**
 * ============ ������������ ============
 * 
 * @author ����
 * @version 1.3
 * @date 2017-5-16
 * 
 */

public class GraphicsLeft extends SystemGraphicsMain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JointModule jmName;
	private static JointModule jmDefu;
	private static JointModule jmPhone;
	private static JointModule jmAddress;
	private static JointModule jmEnter;
	private static JointModule jmMake;
	private static JointModule jmCash;
	private static JointModule jmMoney;

	private static JointModule jmSum;
	private static JointModule jmSeize;
	private static JointModule jmResidue;
	private static JointModule jmOrder;
	private static JointModule jmStop;

	private static JLabel labelSingle;

	static GraphicsLeftDao graphLeft = new GraphicsLeftImpl();

	public GraphicsLeft() {
		// ��������������
		leftPanel = new JPanel(new BorderLayout());

		JLabel timeLabel = new JLabel();

		// ���ñ�ǩ��С
		timeLabel.setPreferredSize(new Dimension(250, 30));

		leftPanel.setBorder(BorderFactory.createLineBorder(Color.green));

		timeLabel.setBorder(BorderFactory.createLineBorder(Color.yellow));

		// �ڱ�ǩ����ʾʱ��
		// showDate(timeLabel);
		ShowDate.showDate(timeLabel);

		/**
		 * void setHorizontalAlignment(int alignment) ���ñ�ǩ������ X ��Ķ��뷽ʽ
		 */
		// �����ݾ�����ʾ
		timeLabel.setHorizontalAlignment(JButton.CENTER);

		// ���ñ�ǩ��������ɫ
		timeLabel.setForeground(Color.blue);

		leftPanel.add(timeLabel, BorderLayout.NORTH);

		// ��߲��ֽ���-�м䲿��
		graphicsLeftC();

		// ��߲��ֽ���-�²���
		graphicsLeftB();

	}

	// �󲿽���-�в�
	public void graphicsLeftC() {
		JPanel paneC = new JPanel(new BorderLayout());

		ImageIcon icoQuery = new ImageIcon("pic//b1.gif");
		ImageIcon icoNote = new ImageIcon("pic//b2.gif");

		// ������ǩ������
		JTabbedPane tabbedPaneC = new JTabbedPane(JTabbedPane.BOTTOM);

		JPanel tPaneQuery = new JPanel(new BorderLayout());
		JPanel tPaneNote = new JPanel();

		tPaneQuery.add(leftCQueryTop(), BorderLayout.NORTH);
		tPaneQuery.add(leftCQueryDown(), BorderLayout.SOUTH);

		tabbedPaneC.addTab("��ѯ", icoQuery, tPaneQuery);
		tabbedPaneC.addTab("��ǩ", icoNote, tPaneNote);

		paneC.setPreferredSize(new Dimension(100, 300));
		paneC.setBorder(BorderFactory.createLineBorder(Color.red));

		tabbedPaneC.setPreferredSize(new Dimension(250, 600));

		paneC.add(tabbedPaneC);
		leftPanel.add(paneC, BorderLayout.CENTER);

	}

	// �󲿽���-�²�
	public void graphicsLeftB() {
		JPanel paneB = new JPanel();

		paneB.setPreferredSize(new Dimension(200, 200));
		paneB.setBorder(BorderFactory.createLineBorder(Color.black));

		leftPanel.add(paneB, BorderLayout.SOUTH);

	}

	// �󲿽���-"״̬"�е��ϲ�������(��׼���˼���Ϣ)
	public JPanel leftCQueryTop() {
		/**
		 * static Border createEmptyBorder(int top, int left, int bottom, int
		 * right) ����һ��ռ�ÿռ䵫û�л��ƵĿձ߿�ָ���˶��ߡ����ߡ���߿��ߺ��ұ߿��ߵĿ�ȡ�
		 */
		// "״̬"�е��ϲ�������
		JPanel tPaneQueryTop = new JPanel(new GridLayout(9, 1));

		// �����հ׿�
		// tPaneQueryTop.setBorder(BorderFactory.createEmptyBorder(10,20,10,10));

		labelSingle = new JLabel();
		labelSingle.setForeground(Color.red);
		labelSingle.setFont(new Font("����", 1, 18));

		// ���շ����Ų�ѯ
		// gji.findGuestNR(roomNo);

		// JLabel labelName=new JLabel("�ͻ�����:");
		jmName = new JointModule();
		JPanel labelName = jmName.jointlabel2("�ͻ�����:", null, new Dimension(100, 20), 0, 0, 0, 50);

		jmDefu = new JointModule();
		JPanel labelDefault = jmDefu.jointlabel2("Ԥ�赥��:", null, new Dimension(100, 20), 0, 0, 0, 50);

		jmPhone = new JointModule();
		JPanel labelPhone = jmPhone.jointlabel2("�ͷ��绰:", null, new Dimension(100, 20), 0, 0, 0, 50);

		jmAddress = new JointModule();
		JPanel labelAddress = jmAddress.jointlabel2("��������:", null, new Dimension(100, 20), 0, 0, 0, 50);

		jmEnter = new JointModule();
		JPanel labelEnter = jmEnter.jointlabel2("����ʱ��:", null, new Dimension(100, 20), 0, 0, 0, 50);

		jmMake = new JointModule();
		JPanel labelMake = jmMake.jointlabel2("����ʱ��:", null, new Dimension(100, 20), 0, 0, 0, 50);

		jmCash = new JointModule();
		JPanel labelCash = jmCash.jointlabel2("�ѽ�Ѻ��:", null, new Dimension(100, 20), 0, 0, 0, 50);

		jmMoney = new JointModule();
		JPanel labelMoney = jmMoney.jointlabel2("Ӧ�ս��:", null, new Dimension(100, 20), 0, 0, 0, 50);

		tPaneQueryTop.setPreferredSize(new Dimension(250, 300));

		tPaneQueryTop.add(labelSingle);
		tPaneQueryTop.add(labelName);
		tPaneQueryTop.add(labelDefault);
		tPaneQueryTop.add(labelPhone);
		tPaneQueryTop.add(labelAddress);
		tPaneQueryTop.add(labelEnter);
		tPaneQueryTop.add(labelMake);
		tPaneQueryTop.add(labelCash);
		tPaneQueryTop.add(labelMoney);

		return tPaneQueryTop;
	}

	// �󲿽���-"״̬"�е��²�������(������״̬��Ϣ)
	public JPanel leftCQueryDown() {
		// "״̬"�е��ϲ�������
		JPanel tPaneQueryDown = new JPanel(new GridLayout(9, 1));

		JLabel labelRoomSta = new JLabel("������״̬");
		labelRoomSta.setForeground(Color.red);
		labelRoomSta.setFont(new Font("����", 1, 18));

		jmSum = new JointModule();
		JPanel labelSum = jmSum.jointlabel2("��������:", null, new Dimension(100, 20), 0, 0, 0, 50);
		jmSum.setLabelText(graphLeft.queryLeftRoomAll() + "");

		jmSeize = new JointModule();
		JPanel labelSeize = jmSeize.jointlabel2("��ǰռ��:", null, new Dimension(100, 20), 0, 0, 0, 50);
		jmSeize.setLabelText(graphLeft.roomCount("��ǰռ��") + "");

		jmResidue = new JointModule();
		JPanel labelResidue = jmResidue.jointlabel2("��ǰ�ɹ�:", null, new Dimension(100, 20), 0, 0, 0, 50);
		jmResidue.setLabelText(graphLeft.roomCount("��ǰ����") + "");

		jmOrder = new JointModule();
		JPanel labelOrder = jmOrder.jointlabel2("��ǰԤ��:", null, new Dimension(100, 20), 0, 0, 0, 50);
		jmOrder.setLabelText(graphLeft.roomCount("��ǰԤ��") + "");

		jmStop = new JointModule();
		JPanel labelStop = jmStop.jointlabel2("��ǰͣ��:", null, new Dimension(100, 20), 0, 0, 0, 50);
		jmStop.setLabelText(graphLeft.roomCount("��ǰͣ��") + "");

		tPaneQueryDown.setPreferredSize(new Dimension(250, 300));

		tPaneQueryDown.add(labelRoomSta);
		tPaneQueryDown.add(labelSum);
		tPaneQueryDown.add(labelSeize);
		tPaneQueryDown.add(labelResidue);
		tPaneQueryDown.add(labelOrder);
		tPaneQueryDown.add(labelStop);

		return tPaneQueryDown;
	}

	// ��ѯ���ϲ���Ϣ
	public static void getORoo(String roomNo, String roomType) {
		ArrayList<Object> listR = graphLeft.findGuestNR(roomNo);
		System.out.println(roomNo + "----");

		labelSingle.setText(roomType + ":" + roomNo);

		if (listR.size() > 0) {
			Guest guestInfo = (Guest) listR.get(0);
			Room roomInfo = (Room) listR.get(1);

			jmName.setLabelText(guestInfo.getGuestName());
			jmDefu.setLabelText(roomInfo.getRoomPrice());
			jmAddress.setLabelText(roomInfo.getFloor() + "¥");
			jmPhone.setLabelText(roomInfo.getRoomPhone());
			jmCash.setLabelText(guestInfo.getRealCash() + "");
			jmMoney.setLabelText(roomInfo.getRoomPrice());

		} else {
			Room room = graphLeft.queryLeftRoomInfo(roomNo);
			jmDefu.setLabelText(room.getRoomPrice());
			jmAddress.setLabelText(room.getFloor() + "¥");
			jmPhone.setLabelText(room.getRoomPhone());
			jmName.setLabelText(null);
			jmCash.setLabelText(null);
			jmEnter.setLabelText(null);
		}

	}

	// ������ʱ�������ֵ
	public static void addEnter(String expendTime) {

		if (!expendTime.equals(" ")) {
			jmEnter.setLabelText(expendTime);
		} else {
			jmEnter.setLabelText(null);
		}

		System.out.println(expendTime);
	}
}
