package com.scme.familyhotel.welcome;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

import com.scme.familyhotel.login.LoginGraphics;



/**
 * =========================================
 * 这是 程序启动画面 （软件启动时显示的欢迎画面）
 * ========================================= 
 * 
 * @author 胡贵东
 * @version	1.1
 * @date 2017-4-29
 */


public class Welcome extends JWindow {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 *	JWindow 是一个容器，可以显示在用户桌面上的任何位置。
	 *	它没有标题栏、窗口管理按钮或者其他与 JFrame 关联的修饰，
	 *	但它仍然是用户桌面的“一类居民”，可以存在于桌面上的任何位置。
	 *
	 *
	 *	@param frameIco
	 *			启动画面的图片路径
	 *
	 *	@param waitTime
	 *			启动画面的显示时间
	 */

	public void startInterface(String frameIco,int waitTime){

		//封装图片
		ImageIcon ico = new ImageIcon(frameIco);


		/**
		 * JLabel(Icon image){} 
		 * 创建具有指定图像的 JLabel 实例
		 */
		//创建JLabel标签
		JLabel label = new JLabel(ico);


		/**
		 *  void getContentPane(){}
		 *  初始化一个容器并在其中添加标签组件
		 *  
		 *  BorderLayout
		 *  这是一个布置容器的边框布局，它可以对容器组件进行安排，
		 *  并调整其大小，使其符合下列五个区域：北、南、东、西、中。
		 */
		// 初始化容器并将标签放在此容器（欢迎屏幕）中间
		getContentPane().add(label, BorderLayout.CENTER);  


		//自动调整此窗口的大小，以适合其子组件的首选大小和布局
		pack();


		/**
		 * Toolkit 定义的方法是一种“胶水”，将 java.awt 包中与
		 * 平台无关的类与 java.awt.peer 中的对应物连接起来。
		 * Toolkit 定义的一些方法能直接查询本机操作系统
		 * 
		 *  static Toolkit getDefaultToolkit() 获取默认工具包。 
		 */
		Toolkit tk=Toolkit.getDefaultToolkit();


		/**
		 * Dimension 类封装单个对象中组件的宽度和高度（精确到整数）。
		 * 
		 */
		//通过获取本机操作系统默认工具包获取当前屏幕的分辨率大小 
		Dimension screenSize=tk.getScreenSize();


		/**
		 *  Dimension getPreferredSize() {}
		 *  获取自动调整后的组件大小 
		 */
		//获取调整后标签大小
		Dimension labelSize=label.getPreferredSize();


		/**
		 *  public void setLocation(int x,int y)    将组件移到新位置
		 */
		// 将JWindow容器以及其中的组件内容放在当前屏幕中间
		setLocation(screenSize.width/2-labelSize.width/2, screenSize.height/2-labelSize.height/2);


		//设置JWindow容器以及其中的组件内容可见
		setVisible(true);


		// 增加一个鼠标事件处理器，如果用户用鼠标点击了欢迎屏幕，则关闭。
		addMouseListener(new MouseAdapter() {
			//重写mousePressed方法
			@Override
			public void mousePressed(MouseEvent e) {
				//设置窗体为隐藏
				setVisible(false);

				//释放由此 Window、其子组件及其拥有的所有子组件所使用的所有本机屏幕资源
				dispose();  
			}
		});


		/**
		 * Swing线程在同一时刻仅能被一个线程所访问。一般来说，这个线程是事件派发线程（event-dispatching thread）。
		 * 如果需要从事件处理（event-handling）或绘制代码以外的地方访问UI，
		 * 那么可以使用SwingUtilities类的invokeLater()或invokeAndWait()方法。
		 */
		// 关闭窗体(欢迎屏幕)的线程
		Runnable closeInter=new Runnable() {

			@Override
			public void run() {
				//设置窗体为隐藏
				setVisible(false);

				//释放由此 Window、其子组件及其拥有的所有子组件所使用的所有本机屏幕资源
				dispose(); 

			}
		};


		// 等待关闭窗体(欢迎屏幕)的线程
		Runnable waitClose=new Runnable() {

			@Override
			public void run() {
				try {
					// 当显示了waitTime时间后，尝试关闭欢迎屏幕(线程休眠)
					Thread.sleep(waitTime);

					/** ===================================================================================
					 *  SwingUtilities类提供了两个方法：invokeLate和invoteAndWait，
					 *  它们都使事件派发线程上的可运行对象排队。当可运行对象排在事件派发队列的队首时，
					 *  就调用其run方法。其效果是允许事件派发线程调用另一个线程中的任意一个代码块。 
					 *  只有从事件派发线程才能更新组件。 
					 *  与invoikeLater一样，invokeAndWait也把可运行对象排入事件派发线程的队列中，
					 *  invokeLater在把可运行的对象放入队列后就返回，而invokeAndWait一直等待知道
					 *  已启动了可运行的run方法才返回。
					 *  如果一个操作在另外一个操作执行之前必须从一个组件获得信息，则invokeAndWait方法是很有用的。
					 * 
					 * 
					 * invokeAndWait锁定调用它的线程，直到可运行对象从事件派发线程中派发出去
					 * 并且该可运行的对象的run方法激活,，如果从事件派发线程调用invoikeAndWait，则会发生死锁的状况,
					 * 因为 invokeAndWait正在等待事件派发，但是，由于是从事件派发线程中调用invokeAndWait，
					 * 所以直到invokeAndWait返回后事件才能派发。 
					 * ====================================================================================
					 * SwingUtilities(Swing 实用方法的集合)
					 * 
					 * invokeAndWait是直到事件分发线程已经执行了指定代码才返回
					 */
					//上一部分(睡眠线程)执行完毕waitClose执行closeInter线程
					SwingUtilities.invokeAndWait(closeInter);	

				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					//启动登录界面
					new LoginGraphics().setVisible(true);
					
				}

			}
		};
		// 启动等待关闭窗体(欢迎屏幕)的线程，并设置其线程名
		Thread t=new Thread(waitClose, "waitThread");
		t.start();
	}
	
	
	/**
	 * 程序入口
	 */
	public static void main(String[] args) {
		Welcome welcome=new Welcome();
		//欢迎画面
		welcome.startInterface("pic//Login.gif",2000);

	}

}




