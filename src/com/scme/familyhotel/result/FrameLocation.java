package com.scme.familyhotel.result;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * ============================= ��������JFrame����λ�õ�ģ�� =============================
 * 
 * @author ����
 * @version 1.0
 * @date 2017-4-29
 * 
 */
public class FrameLocation {
	/**
	 * @param frame
	 *            JFrame����
	 */

	// ���õ�ǰ������ʾλ�ü�����ͼ��
	public static void frameLocation(JFrame frame, String titleIco) {
		// ��ȡ����Ĵ�С
		Dimension frameSize = frame.getSize();

		// ��ȡĬ�Ϲ��߰�
		Toolkit tool = Toolkit.getDefaultToolkit();

		// ���ñ���ͼ��
		Image image = tool.getImage(titleIco);
		frame.setIconImage(image);

		// ͨ�����߰���ȡ��ǰ��ʾ���Ĵ�С
		Dimension screenSize = tool.getScreenSize();

		// ��Frame���������ʾ
		frame.setLocation(screenSize.width / 2 - frameSize.width / 2, screenSize.height / 2 - frameSize.height / 2);

		// //��Ӽ������ڹر��¼�
		// frame.addWindowListener(new WindowAdapter() {
		// @Override
		// public void windowClosing(WindowEvent e) {
		// System.exit(0);
		// }
		// });

		//frame.setVisible(true);
	}

}
