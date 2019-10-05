package com.scme.familyhotel.mainframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * ============================= 这是显示时间的模块 =============================
 * 
 * @author 胡贵东
 * @version 1.0
 * @date 2017-5-1
 * 
 */
public class ShowDate {
	// 让日期在标签容器中动态显示
	public static void showDate(JLabel timeLabel) {
		/**
		 * @param timeLabel
		 *            JLabel标签
		 * 
		 *            javax.swing.Timer 在指定时间间隔触发一个或多个
		 *            ActionEvent。一个示例用法是动画对象，它将 Timer 用作绘制其帧的触发器。
		 *            设置计时器的过程包括创建一个 Timer 对象，在该对象上注册一个或多个动作侦听器，以及使用 start
		 *            方法启动该计时器。
		 * 
		 * 
		 *            Timer(int delay, ActionListener listener) 创建一个 Timer
		 *            并将初始延迟和事件间延迟初始化为 delay 毫秒。 Timer
		 *            构造方法的第二个参数指定接收计时器动作事件的侦听器。
		 *
		 */
		// 添加显示时间事件(设置Timer 1000ms实现一次动作 实际是一个线程 )
		Timer time = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 获取当前时间毫秒值
				long timemillis = System.currentTimeMillis();
				// 将指定毫秒值转化为日期
				Date date = new Date(timemillis);
				// 转换日期显示格式
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// 将日期显示到标签中
				timeLabel.setText(df.format(date));

			}
		});
		
		//启动线程
		time.start();

	}
}
