package com.scme.familyhotel.result;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * ===================== ��������ƴ����� =====================
 * 
 * @author ����
 * @version 1.0
 * @date 2017-5-8
 */

public class JointModule {
	/**
	 * 
	 * @param labelTite
	 *            JLabel��ǩ����
	 * 
	 * @param comboTite
	 *            ������Ĭ������
	 * 
	 * @param top
	 *            �ϱ߿���
	 * 
	 * @param left
	 *            ��߿���
	 * 
	 * @param bottom
	 *            �±߿���
	 * 
	 * @param right
	 *            �ұ߿���
	 * 
	 * @return ��������JPanel����
	 */

	JLabel label2;
	JLabel label3;

	JComboBox<String> Combo;

	JTextField field;

	// ƴ�ӱ�ǩ��������
	public JPanel labelCom(String labelTite, String[] comboTite, Dimension comboSize, int top, int left, int bottom,
			int right) {
		JPanel panel = new JPanel();
		JLabel label = new JLabel(labelTite);
		// ����������
		Combo = new JComboBox<String>(comboTite);
		// ����������Ĭ����ʾ����
		// Combo.addItem(comboTite);
		// �����������С
		Combo.setPreferredSize(comboSize);

		// ����ǩ����������ӵ�JPanel������
		panel.add(label);
		panel.add(Combo);
		// ����JPanel�����߿����Ե������λ��
		panel.setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));

		return panel;
	}

	// ƴ�ӱ�ǩ���ı���
	public JPanel labelField(String labelTite, String textField, Dimension dimSize, int top, int left, int bottom,
			int right) {

		JPanel Panel = new JPanel();
		JLabel label = new JLabel(labelTite);
		field = new JTextField(textField);
		// �����ı����С
		field.setPreferredSize(dimSize);
		// ����ǩ���ı�����ӵ�JPanel������
		Panel.add(label);
		Panel.add(field);
		// ����JPanel�����߿����Ե������λ��
		Panel.setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));

		return Panel;
	}

	// ƴ�ӱ�ǩ�ͱ�ǩ
	public JPanel jointlabel(String labelTite1, String labelTite2, Dimension dimSize, int top, int left, int bottom,
			int right) {

		JPanel Panel = new JPanel();
		JLabel label1 = new JLabel(labelTite1);
		label2 = new JLabel(labelTite2);
		// ���ñ߿���ɫ
		label2.setBorder(BorderFactory.createLineBorder(Color.blue));
		// ���ñ�ǩ��С
		label2.setPreferredSize(dimSize);

		// ����ǩ�ͱ�ǩ��ӵ�JPanel���������
		Panel.add(label1);
		Panel.add(label2);
		// ����JPanel�����߿����Ե������λ��
		Panel.setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));

		return Panel;
	}

	// ƴ�ӱ�ǩ�ͱ�ǩ(�ޱ߿���ɫ)
	public JPanel jointlabel2(String labelTite1, String labelTite2, Dimension dimSize, int top, int left, int bottom,
			int right) {

		JPanel Panel = new JPanel();
		JLabel label1 = new JLabel(labelTite1);
		label3 = new JLabel(labelTite2);
		label3.setForeground(Color.blue);

		// ���ñ�ǩ��С
		label3.setPreferredSize(dimSize);

		// ����ǩ�ͱ�ǩ��ӵ�JPanel���������
		Panel.add(label1);
		Panel.add(label3);
		// ����JPanel�����߿����Ե������λ��
		Panel.setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));

		return Panel;
	}

	// ��ǩ����������
	public void setLabel(String roomNo, String roomType) {

		label2.setText(roomNo);
		label2.setForeground(Color.blue);

	}

	// ��ȡ�������е�ֵ
	public String getComboVal() {
		String comboValue = (String) Combo.getSelectedItem();

		return comboValue;
	}

	// ��ȡ�ı����е�ֵ
	public String getFliText() {
		String fieldValue = field.getText();

		return fieldValue;
	}

	// ��ȡ��ǩ�е�ֵ
	public String getLabelText() {
		String labelValue = label2.getText();

		return labelValue;
	}

	// ���ñ�ǩ�е�ֵ
	public void setLabelText(String tit) {

		label3.setText(tit);

	}

}
