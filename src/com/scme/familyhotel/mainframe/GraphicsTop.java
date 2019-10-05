package com.scme.familyhotel.mainframe;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.scme.familyhotel.group.GraphicsGroupBilling;
import com.scme.familyhotel.group.GraphicsGroupBilling2;
import com.scme.familyhotel.guestscheckout.GraphicsCheckOut;
import com.scme.familyhotel.guestsreserve.GraphicsReserveCreate;
import com.scme.familyhotel.guestsreserve.GraphicsReserveMain;
import com.scme.familyhotel.individualbilling.GraphicsIndividual;
import com.scme.familyhotel.salesinquiries.SalesInquiries;
import com.scme.familyhotel.salesinquiries.SalesInquiries2;

/**
 * ============== ���������涥�� =============
 * 
 * @author ����
 * @version 1.3
 * @date 2017-5-16
 * 
 */

public class GraphicsTop extends SystemGraphicsMain implements ActionListener {
	JButton individualButton;
	private JButton groupButton;
	private JButton checkoutButton;
	private JButton reseverButton;
	private JButton queryButton;
	private JButton manageButton;
	private JButton netSetButton;
	private JButton systemSetButton;
	private JButton aboutButton;
	private JButton exitButton;

	private static final long serialVersionUID = 1L;

	public GraphicsTop() {
		// �������涥������
		topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		/**
		 * BorderFactory �ṩ��׼ Border ����Ĺ����ࡣ���κο��ܵĵط��� �˹����඼���ṩ���ѹ��� Border ʵ��������
		 * 
		 * static Border createLineBorder(Color color) ����һ������ָ����ɫ���߱߿�
		 * 
		 */

		topPanel.setBorder(BorderFactory.createLineBorder(Color.red));

		// ��װͼƬ
		ImageIcon individualIco = new ImageIcon("pic//ToolBar//m01.gif");
		ImageIcon groupIco = new ImageIcon("pic//ToolBar//m02.gif");
		ImageIcon checkoutIco = new ImageIcon("pic//ToolBar//m04.gif");
		ImageIcon reseverIco = new ImageIcon("pic//ToolBar//m05.gif");
		ImageIcon queryIco = new ImageIcon("pic//ToolBar//m06.gif");
		ImageIcon manageIco = new ImageIcon("pic//ToolBar//m07.gif");
		ImageIcon netSetIco = new ImageIcon("pic//ToolBar//m08.gif");
		ImageIcon systemSetIco = new ImageIcon("pic//ToolBar//m09.gif");
		ImageIcon aboutIco = new ImageIcon("pic//ToolBar//m03.gif");
		ImageIcon exitIco = new ImageIcon("pic//ToolBar//m10.gif");

		// Ϊ���ܰ�ť��Ӱ�ť��ͼƬ
		individualButton = new JButton("ɢ�Ϳ���", individualIco);
		individualButton.addActionListener(this);

		groupButton = new JButton("���忪��", groupIco);
		groupButton.addActionListener(this);

		checkoutButton = new JButton("���ͽ���", checkoutIco);
		checkoutButton.addActionListener(this);

		reseverButton = new JButton("�ͷ�Ԥ��", reseverIco);
		reseverButton.addActionListener(this);

		queryButton = new JButton("Ӫҵ��ѯ", queryIco);
		queryButton.addActionListener(this);
		
		manageButton = new JButton("�ͻ�����", manageIco);
		manageButton.addActionListener(this);
		
		netSetButton = new JButton("��������", netSetIco);
		systemSetButton = new JButton("ϵͳ����", systemSetIco);
		aboutButton = new JButton("��������", aboutIco);
		exitButton = new JButton("�˳�ϵͳ", exitIco);

		// ���ð�ť��ͼƬ���ı�λ��
		textLocation(individualButton);

		textLocation(groupButton);

		textLocation(checkoutButton);

		textLocation(reseverButton);

		textLocation(queryButton);

		textLocation(manageButton);

		textLocation(netSetButton);

		textLocation(systemSetButton);

		textLocation(aboutButton);

		textLocation(exitButton);

		topPanel.add(individualButton);
		topPanel.add(groupButton);
		topPanel.add(checkoutButton);
		topPanel.add(reseverButton);
		topPanel.add(queryButton);
		topPanel.add(manageButton);
		topPanel.add(netSetButton);
		topPanel.add(systemSetButton);
		topPanel.add(aboutButton);
		topPanel.add(exitButton);

		// frame.add(topPanel, BorderLayout.NORTH);

	}

	// ���ð�ť��ͼƬ���ı�λ��
	public static void textLocation(JButton button) {
		/**
		 * @param button
		 *            ��ť
		 * 
		 *            void setVerticalTextPosition(int textPosition)
		 *            �����ı������ͼ��Ĵ�ֱλ�á� void setHorizontalTextPosition(int
		 *            textPosition) �����ı������ͼ���ˮƽλ�á�
		 * 
		 *
		 */

		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setHorizontalTextPosition(JButton.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Ϊɢ�Ϳ�����ť����¼�
		if (e.getSource() == individualButton) {
			new GraphicsIndividual();
		}

		// Ϊ���忪����ť����¼�
		if (e.getSource() == groupButton) {
			new GraphicsGroupBilling().setVisible(true);
		}

		// Ϊ���ͽ��˰�ť����¼�
		if (e.getSource() == checkoutButton) {
			new GraphicsCheckOut().setVisible(true);
		}

		// Ϊ�ͷ�Ԥ����ť����¼�
		if (e.getSource() == reseverButton) {
			new GraphicsReserveMain().setVisible(true);
		}

		// ΪӪҵ��ѯ��ť����¼�
		if (e.getSource() == queryButton) {
			new SalesInquiries().setVisible(true);
		}

		// Ϊ�ͻ�����ť����¼�
		if (e.getSource() == manageButton) {

		}

	}

}
