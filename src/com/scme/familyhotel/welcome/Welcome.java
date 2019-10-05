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
 * ���� ������������ ���������ʱ��ʾ�Ļ�ӭ���棩
 * ========================================= 
 * 
 * @author ����
 * @version	1.1
 * @date 2017-4-29
 */


public class Welcome extends JWindow {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 *	JWindow ��һ��������������ʾ���û������ϵ��κ�λ�á�
	 *	��û�б����������ڹ���ť���������� JFrame ���������Σ�
	 *	������Ȼ���û�����ġ�һ����񡱣����Դ����������ϵ��κ�λ�á�
	 *
	 *
	 *	@param frameIco
	 *			���������ͼƬ·��
	 *
	 *	@param waitTime
	 *			�����������ʾʱ��
	 */

	public void startInterface(String frameIco,int waitTime){

		//��װͼƬ
		ImageIcon ico = new ImageIcon(frameIco);


		/**
		 * JLabel(Icon image){} 
		 * ��������ָ��ͼ��� JLabel ʵ��
		 */
		//����JLabel��ǩ
		JLabel label = new JLabel(ico);


		/**
		 *  void getContentPane(){}
		 *  ��ʼ��һ����������������ӱ�ǩ���
		 *  
		 *  BorderLayout
		 *  ����һ�����������ı߿򲼾֣������Զ�����������а��ţ�
		 *  ���������С��ʹ���������������򣺱����ϡ����������С�
		 */
		// ��ʼ������������ǩ���ڴ���������ӭ��Ļ���м�
		getContentPane().add(label, BorderLayout.CENTER);  


		//�Զ������˴��ڵĴ�С�����ʺ������������ѡ��С�Ͳ���
		pack();


		/**
		 * Toolkit ����ķ�����һ�֡���ˮ������ java.awt ������
		 * ƽ̨�޹ص����� java.awt.peer �еĶ�Ӧ������������
		 * Toolkit �����һЩ������ֱ�Ӳ�ѯ��������ϵͳ
		 * 
		 *  static Toolkit getDefaultToolkit() ��ȡĬ�Ϲ��߰��� 
		 */
		Toolkit tk=Toolkit.getDefaultToolkit();


		/**
		 * Dimension ���װ��������������Ŀ�Ⱥ͸߶ȣ���ȷ����������
		 * 
		 */
		//ͨ����ȡ��������ϵͳĬ�Ϲ��߰���ȡ��ǰ��Ļ�ķֱ��ʴ�С 
		Dimension screenSize=tk.getScreenSize();


		/**
		 *  Dimension getPreferredSize() {}
		 *  ��ȡ�Զ�������������С 
		 */
		//��ȡ�������ǩ��С
		Dimension labelSize=label.getPreferredSize();


		/**
		 *  public void setLocation(int x,int y)    ������Ƶ���λ��
		 */
		// ��JWindow�����Լ����е�������ݷ��ڵ�ǰ��Ļ�м�
		setLocation(screenSize.width/2-labelSize.width/2, screenSize.height/2-labelSize.height/2);


		//����JWindow�����Լ����е�������ݿɼ�
		setVisible(true);


		// ����һ������¼�������������û���������˻�ӭ��Ļ����رա�
		addMouseListener(new MouseAdapter() {
			//��дmousePressed����
			@Override
			public void mousePressed(MouseEvent e) {
				//���ô���Ϊ����
				setVisible(false);

				//�ͷ��ɴ� Window�������������ӵ�е������������ʹ�õ����б�����Ļ��Դ
				dispose();  
			}
		});


		/**
		 * Swing�߳���ͬһʱ�̽��ܱ�һ���߳������ʡ�һ����˵������߳����¼��ɷ��̣߳�event-dispatching thread����
		 * �����Ҫ���¼�����event-handling������ƴ�������ĵط�����UI��
		 * ��ô����ʹ��SwingUtilities���invokeLater()��invokeAndWait()������
		 */
		// �رմ���(��ӭ��Ļ)���߳�
		Runnable closeInter=new Runnable() {

			@Override
			public void run() {
				//���ô���Ϊ����
				setVisible(false);

				//�ͷ��ɴ� Window�������������ӵ�е������������ʹ�õ����б�����Ļ��Դ
				dispose(); 

			}
		};


		// �ȴ��رմ���(��ӭ��Ļ)���߳�
		Runnable waitClose=new Runnable() {

			@Override
			public void run() {
				try {
					// ����ʾ��waitTimeʱ��󣬳��Թرջ�ӭ��Ļ(�߳�����)
					Thread.sleep(waitTime);

					/** ===================================================================================
					 *  SwingUtilities���ṩ������������invokeLate��invoteAndWait��
					 *  ���Ƕ�ʹ�¼��ɷ��߳��ϵĿ����ж����Ŷӡ��������ж��������¼��ɷ����еĶ���ʱ��
					 *  �͵�����run��������Ч���������¼��ɷ��̵߳�����һ���߳��е�����һ������顣 
					 *  ֻ�д��¼��ɷ��̲߳��ܸ�������� 
					 *  ��invoikeLaterһ����invokeAndWaitҲ�ѿ����ж��������¼��ɷ��̵߳Ķ����У�
					 *  invokeLater�ڰѿ����еĶ��������к�ͷ��أ���invokeAndWaitһֱ�ȴ�֪��
					 *  �������˿����е�run�����ŷ��ء�
					 *  ���һ������������һ������ִ��֮ǰ�����һ����������Ϣ����invokeAndWait�����Ǻ����õġ�
					 * 
					 * 
					 * invokeAndWait�������������̣߳�ֱ�������ж�����¼��ɷ��߳����ɷ���ȥ
					 * ���Ҹÿ����еĶ����run��������,��������¼��ɷ��̵߳���invoikeAndWait����ᷢ��������״��,
					 * ��Ϊ invokeAndWait���ڵȴ��¼��ɷ������ǣ������Ǵ��¼��ɷ��߳��е���invokeAndWait��
					 * ����ֱ��invokeAndWait���غ��¼������ɷ��� 
					 * ====================================================================================
					 * SwingUtilities(Swing ʵ�÷����ļ���)
					 * 
					 * invokeAndWait��ֱ���¼��ַ��߳��Ѿ�ִ����ָ������ŷ���
					 */
					//��һ����(˯���߳�)ִ�����waitCloseִ��closeInter�߳�
					SwingUtilities.invokeAndWait(closeInter);	

				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					//������¼����
					new LoginGraphics().setVisible(true);
					
				}

			}
		};
		// �����ȴ��رմ���(��ӭ��Ļ)���̣߳����������߳���
		Thread t=new Thread(waitClose, "waitThread");
		t.start();
	}
	
	
	/**
	 * �������
	 */
	public static void main(String[] args) {
		Welcome welcome=new Welcome();
		//��ӭ����
		welcome.startInterface("pic//Login.gif",2000);

	}

}




