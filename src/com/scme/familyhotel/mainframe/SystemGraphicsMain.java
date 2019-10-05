package com.scme.familyhotel.mainframe;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.scme.familyhotel.result.FrameLocation;

/**
 * ==================== ������������� ====================
 * 
 * @author ����
 * @version 1.3
 * @date 2017-5-16
 * 
 */
public class SystemGraphicsMain extends JFrame {

	private static final long serialVersionUID = 1L;

	// ��������
	static JPanel topPanel;
	// ������
	static JPanel leftPanel;
	// �м�����
	static JPanel centerPanel;
	// �ײ�����
	static JPanel bottomPanel;

	public void graphicsMain() {
		setLayout(new BorderLayout());
		setSize(1920, 1080);
		setTitle("Family�Ƶ����ϵͳ ����Beta1.3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ���涥��(�����г�ʼ��)
		GraphicsTop top = new GraphicsTop();
		// ������������������ӵ�������
		add(topPanel, BorderLayout.NORTH);

		// ������
		GraphicsLeft left = new GraphicsLeft();
		add(leftPanel, BorderLayout.WEST);

		// �����в�
		GraphicsCenter center = new GraphicsCenter();
		add(centerPanel, BorderLayout.CENTER);

		// ����ײ�
		GraphicsBottom bottom = new GraphicsBottom();
		add(bottomPanel, BorderLayout.SOUTH);

		setVisible(true);
		// ���ô�����ʾ����ӱ���ͼ��
		FrameLocation.frameLocation(this, "pic//u01.gif");
	}

	public void lostFou() {
		setFocusable(false);
	}

	/*
	 * public static void main(String[] args) { SystemGraphicsMain sg = new
	 * SystemGraphicsMain(); sg.graphicsMain(); }
	 */
}
