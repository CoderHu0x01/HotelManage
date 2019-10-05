package com.scme.familyhotel.mainframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * ============================= ������ʾʱ���ģ�� =============================
 * 
 * @author ����
 * @version 1.0
 * @date 2017-5-1
 * 
 */
public class ShowDate {
	// �������ڱ�ǩ�����ж�̬��ʾ
	public static void showDate(JLabel timeLabel) {
		/**
		 * @param timeLabel
		 *            JLabel��ǩ
		 * 
		 *            javax.swing.Timer ��ָ��ʱ��������һ������
		 *            ActionEvent��һ��ʾ���÷��Ƕ����������� Timer ����������֡�Ĵ�������
		 *            ���ü�ʱ���Ĺ��̰�������һ�� Timer �����ڸö�����ע��һ�������������������Լ�ʹ�� start
		 *            ���������ü�ʱ����
		 * 
		 * 
		 *            Timer(int delay, ActionListener listener) ����һ�� Timer
		 *            ������ʼ�ӳٺ��¼����ӳٳ�ʼ��Ϊ delay ���롣 Timer
		 *            ���췽���ĵڶ�������ָ�����ռ�ʱ�������¼�����������
		 *
		 */
		// �����ʾʱ���¼�(����Timer 1000msʵ��һ�ζ��� ʵ����һ���߳� )
		Timer time = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ��ȡ��ǰʱ�����ֵ
				long timemillis = System.currentTimeMillis();
				// ��ָ������ֵת��Ϊ����
				Date date = new Date(timemillis);
				// ת��������ʾ��ʽ
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// ��������ʾ����ǩ��
				timeLabel.setText(df.format(date));

			}
		});
		
		//�����߳�
		time.start();

	}
}
