package 车辆违章管理系统;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class UserHelp extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserHelp frame = new UserHelp();
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
	public UserHelp() {
		setTitle("用户使用帮助");
		setIconImage(Toolkit.getDefaultToolkit().getImage(UserHelp.class.getResource("/photo/caricon.png")));
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
				"单击左侧三个按钮，即可查看4个模块使用帮助。\r\n" + 
				"\r\n" + 
				"\r\n" +
				"任何问题请联系管理员获取帮助，\r\n" + 
				"管理员邮箱：576922471@qq.com。");
		textArea.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton_1 = new JButton("违章信息");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.setText("违章管理功能简介：\r\n" + 
						"\r\n" + 
						"（1）使用功能前，请先在 个人中心 中绑定车辆信息。\r\n" + 
						"\r\n" + 
						"（2）绑定车辆信息后，重新登录系统即可查看违章信息。\r\n" + 
						"\r\n" + 
						"\r\n" + 
						"任何问题请联系管理员获取帮助，\r\n" + 
						"管理员邮箱：576922471@qq.com。");
				
			}
		});
		btnNewButton_1.setBackground(SystemColor.menu);
		btnNewButton_1.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_1.setBounds(11, 34, 108, 23);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("公告&意见");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.setText("公告（意见）功能简介：\r\n" + 
						"\r\n" + 
						"反馈意见：输入内容，单击“确定”后，即可反馈意见。\r\n" + 
						"\r\n" + 
						"查看详情：选定某行公告（意见），单击“查看详情”后，\r\n" + 
						"                  即可查看公告（意见）详情。\r\n" + 
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
		btnNewButton_2.setBounds(11, 67, 108, 23);
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("查看地图");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.setText("地图功能简介：\r\n" + 
						"\r\n" + 
						"地图详情：选定某行地图，单击“地图详情”后，即可查看地图代码。\r\n" + 
						"\r\n" + 
						"修改地图：使用此功能前，请先配置tomcat服务并启动。详情请阅读tomcat配置文档。\r\n" + 
						"                  单击将打开HopPointMap.html文件，将最新的地图代码覆盖原代码后，保存并退出即可。\r\n" + 
						"                  HotPointMap.html应在C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\MapWeb中。\r\n" + 
						"\r\n" + 
						"查看地图：使用此功能前，请先配置tomcat服务并启动。详情请阅读tomcat配置文档。\r\n" + 
						"                  “修改地图”完成后，单击“查看地图”，即可查看最新热点地图。\r\n" + 
						"\r\n" + 
						"\r\n" + 
						"任何问题请联系管理员获取帮助，\r\n" + 
						"管理员邮箱：576922471@qq.com。");
				
			}
		});
		btnNewButton_3.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_3.setBackground(SystemColor.menu);
		btnNewButton_3.setBounds(11, 100, 108, 23);
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("个人中心");
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.setText("个人中心功能简介：\r\n" + 
						"\r\n" + 
						"个人信息：显示用户的个人信息，并且允许用户自行修改电话、邮箱、\r\n" + 
						"                  密码，单击“保存修改”即可保存。\r\n" + 
						"                  如果想修改其他信息，请联系管理员进行修改。\r\n" + 
						"\r\n" + 
						"车辆绑定：完成或修改车辆绑定后，请重新登录系统，即可查看个人\r\n" + 
						"                  违章信息。\r\n" + 
						"                  \r\n" + 
						"\r\n" + 
						"任何问题请联系管理员获取帮助，\r\n" + 
						"管理员邮箱：576922471@qq.com。");
				
			}
		});
		btnNewButton.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton.setBounds(11, 133, 108, 23);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton);
		
		
		
		//居中显示
		this.setLocationRelativeTo(null);
				
		//设置窗体大小不变
		this.setResizable(false);
	}

}
