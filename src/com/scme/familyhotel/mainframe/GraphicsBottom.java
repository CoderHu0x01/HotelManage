package com.scme.familyhotel.mainframe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * ����������ײ�
 * 
 * @author ����
 * @version 1.3
 * @date 2017-5-16
 * 
 */

public class GraphicsBottom extends SystemGraphicsMain {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GraphicsBottom(){
		// ��������ײ�����
				bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

				JLabel nameLabel = new JLabel("Family�Ƶ����ϵͳ");
				JLabel primptLabel = new JLabel("��ʾ����ѡ������");
				JLabel sysInfoLabel = new JLabel("��ǰ��������:Family�Ƶ����ϵͳ����beta��");
				JLabel adminInfoLabel = new JLabel("��ǰ����Ա:Admin");

				/**
				 * void setPreferredSize(Dimension preferredSize) ���ô��������ѡ��С��
				 * (���в��ֹ������е��������С)
				 */

				bottomPanel.setBorder(BorderFactory.createLineBorder(Color.blue));

				nameLabel.setBorder(BorderFactory.createLineBorder(Color.red));
				nameLabel.setPreferredSize(new Dimension(250, 30));

				// nameLabel.setHorizontalAlignment(JButton.CENTER);

				primptLabel.setBorder(BorderFactory.createLineBorder(Color.red));
				primptLabel.setPreferredSize(new Dimension(400, 30));
				// primptLabel.setHorizontalAlignment(JButton.CENTER);

				sysInfoLabel.setBorder(BorderFactory.createLineBorder(Color.red));
				sysInfoLabel.setPreferredSize(new Dimension(350, 30));
				// sysInfoLabel.setHorizontalAlignment(JButton.CENTER);

				adminInfoLabel.setBorder(BorderFactory.createLineBorder(Color.red));
				adminInfoLabel.setPreferredSize(new Dimension(300, 30));
				// adminInfoLabel.setHorizontalAlignment(JButton.CENTER);

				bottomPanel.add(nameLabel);
				bottomPanel.add(primptLabel);
				bottomPanel.add(sysInfoLabel);
				bottomPanel.add(adminInfoLabel);

	}
}
