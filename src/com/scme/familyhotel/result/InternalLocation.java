package com.scme.familyhotel.result;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * ======================================
 * ��������JInternalFrame�ڲ�����λ�õ�ģ��
 * ======================================
 * 
 * @author ����
 * @version	1.0
 * @date 2017-5-8
 * 
 */

import javax.swing.JInternalFrame;

public class InternalLocation {
	/**
	 * 
	 * @param indInterFrame
	 *            �ڲ��������
	 */

	// ��JInternalFrame�����ܾ�����ʾ
	public static void internalLocation(JInternalFrame indInterFrame) {
		// ��ȡJInternalFrame�����ܴ�С
		Dimension internalSize = indInterFrame.getSize();

		// ��ȡĬ�Ͽ������߰�
		Toolkit tool = Toolkit.getDefaultToolkit();

		// ��ȡ��ǰ�����С
		Dimension screenSize = tool.getScreenSize();

		// ��JInternalFrame�����ܾ���
		indInterFrame.setLocation(screenSize.width / 2 - internalSize.width / 2,
				screenSize.height / 2 - internalSize.height / 2);

	}
}
