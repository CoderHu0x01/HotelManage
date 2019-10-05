package com.scme.familyhotel.mainframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.scme.familyhotel.daoimpl.RoomInfoImpl;
import com.scme.familyhotel.group.GraphicsGroupBilling;
import com.scme.familyhotel.guestscheckout.GraphicsCheckOut;
import com.scme.familyhotel.individualbilling.GraphicsIndividual;
import com.scme.familyhotel.pojo.Bill;
import com.scme.familyhotel.pojo.Room;

/**
 * ===================== �����������в� =====================
 * 
 * @author ����
 * @version 1.3
 * @date 2017-5-16
 * 
 */

public class GraphicsCenter extends SystemGraphicsMain {
	// ��׼���˼䰴ť����
	JPanel panelBD;
	// ��׼˫�˼䰴ť����
	JPanel panelBS;
	// �������˼䰴ť����
	JPanel panelHD;
	// ����˫�˼䰴ť����
	JPanel panelHS;
	// �����׷���ť����
	JPanel panelSW;
	// ��ͳ�׷���ť����
	JPanel panelZT;

	ArrayList<Room> listBDRoom;
	ArrayList<Room> listBSRoom;
	ArrayList<Room> listHDRoom;
	ArrayList<Room> listHSRoom;
	ArrayList<Room> listSWRoom;
	ArrayList<Room> listZTRoom;

	// ��׼���˼�
	JScrollPane scrollPaneSingle;
	// ��׼˫�˼�
	JScrollPane scrollPaneDouble;
	// �������˼�
	JScrollPane scrollPaneLuxOne;
	// ����˫�˼�
	JScrollPane scrollPaneLuxTwo;
	// �����׷�
	JScrollPane scrollPaneCommerce;
	// ��ͳ�׷�
	JScrollPane scrollPanePres;

	JTabbedPane tabbedPane;

	private static final long serialVersionUID = 1L;

	private DefaultTableModel tabelModel;
	// ������Ϣ��JDBC����
	RoomInfoImpl roomJdbc = new RoomInfoImpl();

	public GraphicsCenter() {
		/**
		 * void setPreferredSize(Dimension preferredSize) ���ô��������ѡ��С��
		 * (���в��ֹ������е��������С)
		 *
		 * 
		 * JScrollPane(Component view) ����һ����ʾָ��������ݵ�
		 * JScrollPane��ֻҪ��������ݳ�����ͼ��С�ͻ���ʾˮƽ�ʹ�ֱ������
		 */

		// �����м����������
		centerPanel = new JPanel(new BorderLayout());

		// ����һ����ǩ������
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		// ��׼���˼�
		panelBD = new JPanel(new FlowLayout(FlowLayout.LEFT, 60, 60));
		// ��׼˫�˼�
		panelBS = new JPanel(new FlowLayout(FlowLayout.LEFT, 60, 60));
		// �������˼�
		panelHD = new JPanel(new FlowLayout(FlowLayout.LEFT, 60, 60));
		// ����˫�˼�
		panelHS = new JPanel(new FlowLayout(FlowLayout.LEFT, 60, 60));
		// �����׷�
		panelSW = new JPanel(new FlowLayout(FlowLayout.LEFT, 60, 60));
		// ��ͳ�׷�
		panelZT = new JPanel(new FlowLayout(FlowLayout.LEFT, 60, 60));

		// ��ȡ������Ϣ���������뼯��
		ArrayList<Room> listBDRoom = roomJdbc.find("��׼���˼�");
		ArrayList<Room> listBSRoom = roomJdbc.find("��׼˫�˼�");
		ArrayList<Room> listHDRoom = roomJdbc.find("�������˼�");
		ArrayList<Room> listHSRoom = roomJdbc.find("����˫�˼�");
		ArrayList<Room> listSWRoom = roomJdbc.find("�����׷�");
		ArrayList<Room> listZTRoom = roomJdbc.find("��ͳ�׷�");

		// ������������
		// ��׼���˼�
		scrollPaneSingle = icoState(panelBD, listBDRoom);
		// ��׼˫�˼�
		scrollPaneDouble = icoState(panelBS, listBSRoom);
		// �������˼�
		scrollPaneLuxOne = icoState(panelHD, listHDRoom);
		// ����˫�˼�
		scrollPaneLuxTwo = icoState(panelHS, listHSRoom);
		// �����׷�
		scrollPaneCommerce = icoState(panelSW, listSWRoom);
		// ��ͳ�׷�
		scrollPanePres = icoState(panelZT, listZTRoom);

		centerPanel.setPreferredSize(new Dimension(1650, 830));
		centerPanel.setBorder(BorderFactory.createLineBorder(Color.CYAN));
		tabbedPane.setPreferredSize(new Dimension(1630, 600));

		// ��Ӵ��й��������ѡ�
		tabbedPane.addTab("��׼���˼�", scrollPaneSingle);
		tabbedPane.addTab("��׼˫�˼�", scrollPaneDouble);
		tabbedPane.addTab("�������˼�", scrollPaneLuxOne);
		tabbedPane.addTab("����˫�˼�", scrollPaneLuxTwo);
		tabbedPane.addTab("�����׷�", scrollPaneCommerce);
		tabbedPane.addTab("��ͳ�׷�", scrollPanePres);

		// ����JScrollPane��������ʾ״̬
		scrollPaneState(scrollPaneSingle);
		scrollPaneState(scrollPaneDouble);
		scrollPaneState(scrollPaneLuxOne);
		scrollPaneState(scrollPaneLuxTwo);
		scrollPaneState(scrollPaneCommerce);
		scrollPaneState(scrollPanePres);

		centerPanel.add(tabbedPane, BorderLayout.NORTH);

		// �м����-�м䲿��
		graphicsCenterC();

		// �м����-�²���
		graphicsCenterB();

	}

	// �м����-�в�
	public void graphicsCenterC() {
		JPanel cenPane = new JPanel(new FlowLayout(FlowLayout.RIGHT, 80, 10));

		// ͼƬ
		ImageIcon ico1 = new ImageIcon("pic//browse.gif");
		ImageIcon ico2 = new ImageIcon("pic//b1.gif");
		ImageIcon ico3 = new ImageIcon("pic//refurbish.gif");

		// ��ť
		JButton button1 = new JButton("��ʾȫ��", ico1);
		JButton button2 = new JButton("����״̬", ico2);
		JButton button3 = new JButton("ˢ��", ico3);
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new SystemGraphicsMain().graphicsMain();
				
			}
		});

		cenPane.setPreferredSize(new Dimension(1600, 50));
		cenPane.setBorder(BorderFactory.createLineBorder(Color.red));

		cenPane.add(button1);
		cenPane.add(button2);
		cenPane.add(button3);
		centerPanel.add(cenPane, BorderLayout.CENTER);

	}

	// �м����-�²�
	public void graphicsCenterB() {
		JPanel bottPane = new JPanel(new BorderLayout());

		String[] columData = { "��ס����", "�������", "��׼����", "��������", "�����ۿ�", "���ѽ��", "����ʱ��", "������" };
		tabelModel = new DefaultTableModel(columData, 0);

		JTable table = new JTable(tabelModel);
		table.setRowHeight(30);

		// �����������岢��������
		JScrollPane scrollPaneB1 = new JScrollPane(table);

		bottPane.setPreferredSize(new Dimension(1600, 200));
		bottPane.setBorder(BorderFactory.createLineBorder(Color.green));

		// ��ʾ������
		scrollPaneState(scrollPaneB1);

		bottPane.add(scrollPaneB1, BorderLayout.CENTER);

		centerPanel.add(bottPane, BorderLayout.SOUTH);

	}

	// ����JScrollPane��������ʾ״̬
	public void scrollPaneState(JScrollPane scrollPane) {
		// ˮƽ����������ʾ
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		// ��ֱ������������ʾ
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	}

	// ����ÿ�ַ�����ʾ״̬ͼ�갴ť
	public JScrollPane icoState(JPanel panelState, ArrayList<Room> list) {
		/**
		 * @praram list �洢������Ϣ�ļ���
		 * 
		 * @praram panelState �����״̬����
		 */

		panelState.setPreferredSize(new Dimension(500, 1000));

		// ״̬ͼ��
		String icoUrl = null;

		for (int i = 0; i < list.size(); i++) {
			// ��ȡ����״̬��Ϣ
			String state = list.get(i).getRoomState();

			if (state != null) {
				if (state.equals("��ǰ����")) {
					icoUrl = "pic//room//prov.gif";
				} else if (state.equals("��ǰռ��")) {
					icoUrl = "pic//room//pree.gif";
				} else if (state.equals("��ǰͣ��")) {
					icoUrl = "pic//room//stop.gif";
				} else if (state.equals("��ǰԤ��")) {
					icoUrl = "pic//room//rese.gif";
				} else if (state.equals("��ǰ��ɨ")) {
					icoUrl = "pic//room//clean.gif";
				} else if (state.equals("�ӵ㷿")) {
					icoUrl = "pic//room//clock.gif";
				}

			}

			// ��ȡ������
			String roomNo = list.get(i).getRoomNo();
			// ��ȡ��������
			String roomType = list.get(i).getRoomType();
			// ��ȡ���䵥��
			String roomPice = list.get(i).getRoomPrice();

			// ����Ӧ����״̬ͼ�����Ӧ�����������ʾ
			JButton buttonState = buttonJointState(icoUrl, roomNo);

			// getNo(roomNo);

			// Ϊ״̬��ť��ӵ���¼�
			buttonState.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					GraphicsLeft.getORoo(roomNo, roomType);
					GraphicsIndividual.setInfo(roomNo, roomType, roomPice);
					GraphicsCheckOut.initInfo(roomNo);
					GraphicsGroupBilling.initInfo(roomNo, roomType, roomPice);

					// ��ײ�����м�������
					indertData(roomNo, roomPice, roomType);

				}
			});

			// ��ͼ����ӵ�panel������
			panelState.add(buttonState);

		}

		// �������������������
		JScrollPane scrollPaneSingle = new JScrollPane(panelState);

		return scrollPaneSingle;

	}

	// ����״̬��ͼ�갴ť�ͷ��������
	public JButton buttonJointState(String icoUrl, String buttonTit) {

		ImageIcon ico = new ImageIcon(icoUrl);

		JButton button = new JButton(buttonTit, ico);

		button.setPreferredSize(new Dimension(90, 80));

		// ���ð�ť��ͼƬ���ı�λ��
		GraphicsTop.textLocation(button);

		return button;
	}

	// ���м����ײ���������
	public void indertData(String roomNo, String roomPice, String roomType) {
		tabelModel.getDataVector().clear();

		Bill billInfo = roomJdbc.queryBillInfo(roomNo);
		if (billInfo != null) {
			tabelModel.addRow(new Object[] { "RZ" + billInfo.getBillNo(), roomNo, roomPice, roomType,
					billInfo.getRebate(), billInfo.getExpendPrice(),
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(billInfo.getExpendTime()),
					billInfo.getTallyPeople() });

			// ���󲿽��洫������
			GraphicsLeft.addEnter(new SimpleDateFormat("yyyy-MM-dd").format(billInfo.getExpendTime()) + " ");
		} else {
			tabelModel.addRow(new Object[] { null, null, null, null, null, null, null, null });
			GraphicsLeft.addEnter(" ");
		}

	}

	public void initCenterState() {

	}
}
