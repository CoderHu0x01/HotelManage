package com.scme.familyhotel.guestsreserve;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.scme.familyhotel.dao.GraphicsReserveDao;
import com.scme.familyhotel.daoimpl.GraphicsReserveDaoImpl;
import com.scme.familyhotel.individualbilling.GraphicsIndividual;
import com.scme.familyhotel.result.FrameLocation;

public class GraphicsReserveMain extends JFrame implements ActionListener {
	GraphicsReserveDao graphicsReserveDaoImpl = new GraphicsReserveDaoImpl();
	private JButton createButton;
	private JButton buttonQuery;
	private JButton buttonOpenRoom;
	private JPanel cp_main;
	private JTextField textField;
	private JTable table;
	private DefaultTableModel defaultTableModel;
	private String[] coumData = { "宾客姓名", "联系电话", "预定客房类型", "预定房间编号", "预抵时间", "保留时间", "预定时间", "备注" };
	
	static String resRoomNo;
	// /**
	// * Launch the application.
	// */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// GraphicsReserveMain frame = new GraphicsReserveMain();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public GraphicsReserveMain() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 730);
		cp_main = new JPanel();
		cp_main.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(cp_main);
		cp_main.setLayout(null);
		setTitle("客户预订");
		FrameLocation.frameLocation(this, null);

		createButton = new JButton("增加");
		createButton.setFont(new Font("宋体", Font.PLAIN, 16));
		createButton.setIcon(new ImageIcon("pic\\new.gif"));
		createButton.setBounds(23, 16, 101, 41);
		cp_main.add(createButton);
		createButton.addActionListener(this);

		JScrollPane sp_main = new JScrollPane();
		sp_main.setBounds(0, 87, 1184, 605);
		cp_main.add(sp_main);

		defaultTableModel = new DefaultTableModel(coumData, 0);
		
		
		table = new JTable(defaultTableModel);
		sp_main.setViewportView(table);

		JLabel lblNewLabel = new JLabel("\u623F\u95F4\u53F7/\u59D3\u540D/\u7535\u8BDD\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setBounds(393, 22, 144, 27);
		cp_main.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(541, 21, 165, 31);
		cp_main.add(textField);
		textField.setColumns(20);

		JButton button = new JButton("\u4FEE\u6539");
		button.setIcon(new ImageIcon("pic\\modi0.gif"));
		button.setFont(new Font("宋体", Font.PLAIN, 16));
		button.setBounds(131, 16, 101, 41);
		cp_main.add(button);

		JButton button_1 = new JButton("删除");
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				defaultTableModel.removeRow(0);
			}
		});
		button_1.setIcon(new ImageIcon("pic\\del.gif"));
		button_1.setFont(new Font("宋体", Font.PLAIN, 16));
		button_1.setBounds(242, 16, 101, 41);
		cp_main.add(button_1);

		buttonOpenRoom = new JButton("开设房间");
		buttonOpenRoom.setIcon(new ImageIcon("pic\\modi3.gif"));
		buttonOpenRoom.setFont(new Font("宋体", Font.PLAIN, 16));
		buttonOpenRoom.setBounds(1047, 16, 127, 41);
		cp_main.add(buttonOpenRoom);
		buttonOpenRoom.addActionListener(this);

		JButton button_3 = new JButton("刷新");
		button_3.setIcon(new ImageIcon("pic\\b1.gif"));
		button_3.setFont(new Font("宋体", Font.PLAIN, 16));
		button_3.setBounds(936, 16, 101, 41);
		cp_main.add(button_3);

		JButton button_4 = new JButton("过滤");
		button_4.setIcon(new ImageIcon("pic\\recall.gif"));
		button_4.setFont(new Font("宋体", Font.PLAIN, 16));
		button_4.setBounds(827, 16, 101, 41);
		cp_main.add(button_4);

		buttonQuery = new JButton("查询");
		buttonQuery.setFont(new Font("宋体", Font.PLAIN, 16));
		buttonQuery.setIcon(new ImageIcon("pic\\find.gif"));
		buttonQuery.setBounds(716, 16, 101, 41);
		cp_main.add(buttonQuery);
		buttonQuery.addActionListener(this);

		JLabel lblNewLabel_1 = new JLabel("\u5BBE\u5BA2\u9884\u5B9A\u4FE1\u606F");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		lblNewLabel_1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblNewLabel_1.setBounds(0, 62, 1184, 27);
		cp_main.add(lblNewLabel_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 增加用户添加监听
		if (e.getSource() == createButton) {
			new GraphicsReserveCreate(defaultTableModel).setVisible(true);
		}

		// 开设房间添加监听
		if (e.getSource() == buttonOpenRoom) {
			// new GraphicsReserveInto().setVisible(true);
			new GraphicsIndividual().setTitle("预订开单");
			
		}

	}
	
	public static void setRoomNo(String roomNo){
		resRoomNo=roomNo;
	}
}
