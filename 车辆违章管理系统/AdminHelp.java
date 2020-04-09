package 车辆违章管理系统;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class AdminHelp extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHelp frame = new AdminHelp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminHelp() {
		setTitle("管理员使用帮助");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminHelp.class.getResource("/photo/caricon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 598, 430);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(132, 10, 443, 368);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("友情提示：\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"单击左侧四个按钮，即可查看5个模块的使用帮助。\r\n" + 
				"\r\n" + 
				"\r\n" +
				"任何问题请联系管理员获取帮助，\r\n" + 
				"管理员邮箱：576922471@qq.com。");
		textArea.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("用户管理");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.setText("用户管理功能简介：\r\n" + 
						"\r\n" + 
						"查询：可通过身份证号查询用户信息，可修改用户信息并保存。\r\n" + 
						"\r\n" + 
						"添加用户：填写新用户个人信息，可添加新用户。\r\n" + 
						"\r\n" + 
						"删除：选定某行用户信息，单击“删除”后，即可删除此条用户信息。\r\n" + 
						"\r\n" + 
						"刷新：添加或用户，单击“刷新”后，既可刷新用户信息表。\r\n" + 
						"\r\n" + 
						"\r\n" + 
						"任何问题请联系管理员获取帮助，\r\n" + 
						"管理员邮箱：576922471@qq.com。");
				
			}
		});
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 34, 108, 23);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("违章管理");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.setText("违章管理功能简介：\r\n" + 
						"\r\n" + 
						"查询车辆信息：输入车牌号，即可查看车主和车辆信息。\r\n" + 
						"\r\n" + 
						"添加违章信息：输入违章时间、车牌号、违章地点等信息，即可添加\r\n" + 
						"	 车辆违章信息。\r\n" + 
						"\r\n" + 
						"删除：选定某行违章信息，单击“删除”后，即可删除此条违章信息。\r\n" + 
						"\r\n" + 
						"刷新：添加或删除违章信息，单击“刷新”后，即可刷新违章信息表。\r\n" + 
						"\r\n" + 
						"\r\n" + 
						"任何问题请联系管理员获取帮助，\r\n" + 
						"管理员邮箱：576922471@qq.com。");
				
			}
		});
		btnNewButton_1.setBackground(SystemColor.menu);
		btnNewButton_1.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_1.setBounds(10, 67, 108, 23);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("公告&意见");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.setText("公告（意见）功能简介：\r\n" + 
						"\r\n" + 
						"发布公告：输入标题、内容，单击“确定”后，即可发布公告。\r\n" + 
						"\r\n" + 
						"查看详情：选定某行公告（意见），单击“查看详情”后，\r\n" + 
						"                  即可查看公告（意见）详情。\r\n" + 
						"\r\n" + 
						"删除：选定某行公告（意见），单击“删除”后，\r\n" + 
						"           即可删除此条公告（意见）。\r\n" + 
						"\r\n" + 
						"刷新：发布或删除公告（意见），单击“刷新”后，\r\n" + 
						"           即可刷新公告（意见）信息表。\r\n" + 
						"\r\n" + 
						"\r\n" + 
						"任何问题请联系管理员获取帮助，\r\n" + 
						"管理员邮箱：576922471@qq.com。");
				
			}
		});
		btnNewButton_2.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_2.setBackground(SystemColor.menu);
		btnNewButton_2.setBounds(10, 100, 108, 23);
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("地图绘制");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.setText("地图绘制功能简介：此模块会生成上个月违章事件多发地点表。\r\n" + 
						"\r\n" + 
						"历史地图：可查看已发布的所有地图的代码。\r\n" + 
						"\r\n" + 
						"地图绘制：打开高德地图网页，根据违章事件多发地点表，可自行绘制热点地图，关闭网页前，请单击“获取代码”\r\n" + 
						"                  复制地图代码，粘贴至“地图发布”和“修改地图”功能中。\r\n" + 
						"\r\n" + 
						"地图发布：将复制的地图代码黏贴到文本框中，点击“确定”，即可发布此地图。\r\n" + 
						"\r\n" + 
						"修改地图：使用此功能前，请先配置tomcat服务并启动。详情请阅读tomcat配置文档。\r\n" + 
						"                  单击将打开HopPointMap.html文件，将最新的地图代码覆盖原代码后，保存并退出即可。\r\n" + 
						"                  HotPointMap.html应在C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\MapWeb中。\r\n" + 
						"\r\n" + 
						"查看地图：使用此功能前，请先配置tomcat服务并启动。详情请阅读tomcat配置文档。\r\n" + 
						"                “修改地图”完成后，单击“查看地图”，即可查看最新热点地图。\r\n" + 
						"\r\n" + 
						"任何问题请联系管理员获取帮助，\r\n" + 
						"管理员邮箱：576922471@qq.com。");
				
			}
		});
		btnNewButton_3.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_3.setBackground(SystemColor.menu);
		btnNewButton_3.setBounds(10, 133, 108, 23);
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("个人中心");
		btnNewButton_4.setBackground(SystemColor.menu);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.setText("个人中心功能简介：\r\n" + 
						"\r\n" + 
						"        此模块可修改管理员的个人信息，单击“保存修改”后，即可保\r\n" + 
						"存修改后的个人信息。"+
						"\r\n" + 
						"\r\n" + 
						"任何问题请联系管理员获取帮助，\r\n" + 
						"管理员邮箱：576922471@qq.com。");
				
			}
		});
		btnNewButton_4.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_4.setBounds(10, 168, 108, 23);
		btnNewButton_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton_4);
		
		
		
		//居中显示
		this.setLocationRelativeTo(null);
				
		//设置窗体大小不变
		this.setResizable(false);
	}
}
