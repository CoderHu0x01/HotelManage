package com.scme.familyhotel.result;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * ===================== 此类用于拼接组件 =====================
 * 
 * @author 胡贵东
 * @version 1.0
 * @date 2017-5-8
 */

public class JointModule {
	/**
	 * 
	 * @param labelTite
	 *            JLabel标签标题
	 * 
	 * @param comboTite
	 *            下拉框默认文字
	 * 
	 * @param top
	 *            上边框厚度
	 * 
	 * @param left
	 *            左边框厚度
	 * 
	 * @param bottom
	 *            下边框厚度
	 * 
	 * @param right
	 *            右边框厚度
	 * 
	 * @return 返回整个JPanel容器
	 */

	JLabel label2;
	JLabel label3;

	JComboBox<String> Combo;

	JTextField field;

	// 拼接标签和下拉框
	public JPanel labelCom(String labelTite, String[] comboTite, Dimension comboSize, int top, int left, int bottom,
			int right) {
		JPanel panel = new JPanel();
		JLabel label = new JLabel(labelTite);
		// 创建下拉框
		Combo = new JComboBox<String>(comboTite);
		// 设置下拉框默认显示文字
		// Combo.addItem(comboTite);
		// 设置下拉框大小
		Combo.setPreferredSize(comboSize);

		// 将标签和下拉框添加到JPanel容器中
		panel.add(label);
		panel.add(Combo);
		// 设置JPanel容器边框厚度以调整组件位置
		panel.setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));

		return panel;
	}

	// 拼接标签和文本框
	public JPanel labelField(String labelTite, String textField, Dimension dimSize, int top, int left, int bottom,
			int right) {

		JPanel Panel = new JPanel();
		JLabel label = new JLabel(labelTite);
		field = new JTextField(textField);
		// 设置文本框大小
		field.setPreferredSize(dimSize);
		// 将标签和文本框添加到JPanel容器中
		Panel.add(label);
		Panel.add(field);
		// 设置JPanel容器边框厚度以调整组件位置
		Panel.setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));

		return Panel;
	}

	// 拼接标签和标签
	public JPanel jointlabel(String labelTite1, String labelTite2, Dimension dimSize, int top, int left, int bottom,
			int right) {

		JPanel Panel = new JPanel();
		JLabel label1 = new JLabel(labelTite1);
		label2 = new JLabel(labelTite2);
		// 设置边框颜色
		label2.setBorder(BorderFactory.createLineBorder(Color.blue));
		// 设置标签大小
		label2.setPreferredSize(dimSize);

		// 将标签和标签添加到JPanel容器中组合
		Panel.add(label1);
		Panel.add(label2);
		// 设置JPanel容器边框厚度以调整组件位置
		Panel.setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));

		return Panel;
	}

	// 拼接标签和标签(无边框颜色)
	public JPanel jointlabel2(String labelTite1, String labelTite2, Dimension dimSize, int top, int left, int bottom,
			int right) {

		JPanel Panel = new JPanel();
		JLabel label1 = new JLabel(labelTite1);
		label3 = new JLabel(labelTite2);
		label3.setForeground(Color.blue);

		// 设置标签大小
		label3.setPreferredSize(dimSize);

		// 将标签和标签添加到JPanel容器中组合
		Panel.add(label1);
		Panel.add(label3);
		// 设置JPanel容器边框厚度以调整组件位置
		Panel.setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));

		return Panel;
	}

	// 标签容器内文字
	public void setLabel(String roomNo, String roomType) {

		label2.setText(roomNo);
		label2.setForeground(Color.blue);

	}

	// 获取下拉框中的值
	public String getComboVal() {
		String comboValue = (String) Combo.getSelectedItem();

		return comboValue;
	}

	// 获取文本框中的值
	public String getFliText() {
		String fieldValue = field.getText();

		return fieldValue;
	}

	// 获取标签中的值
	public String getLabelText() {
		String labelValue = label2.getText();

		return labelValue;
	}

	// 设置标签中的值
	public void setLabelText(String tit) {

		label3.setText(tit);

	}

}
