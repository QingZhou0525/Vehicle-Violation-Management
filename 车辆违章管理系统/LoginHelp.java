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
import javax.swing.JEditorPane;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.JScrollPane;

public class LoginHelp extends JFrame {

	private JPanel contentPane;
	boolean buttonishelp=true;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginHelp frame = new LoginHelp();
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
	public LoginHelp() {
		setTitle("登录帮助");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginHelp.class.getResource("/photo/caricon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 288, 299);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 259, 208);
		contentPane.add(scrollPane);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		//textArea_1.setEditable(false);
		textArea_1.setText("友情提示：\r\n" + 
				"\r\n" + 
				"请使用统一身份认证账号登录，\r\n" + 
				"登录时请注意身份选择，\r\n" + 
				"初始密码为123456，\r\n" + 
				"请登陆后修改密码，\r\n" + 
				"如果忘记密码，请联系管理员找回。\r\n" + 
				"管理员邮箱：576922471@qq.com\r\n" + 
				"\r\n" + 
				"登录后，请点击系统右下角帮助按钮，\r\n" + 
				"查看系统功能说明。\r\n" + 
				"");
		scrollPane.setViewportView(textArea_1);
		
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton.setText("关于本系统");
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(buttonishelp)
				{
					buttonishelp=false;
					btnNewButton.setText("友情提示");
					textArea_1.setText("关于车辆违章管理系统：\r\n" + 
							"\r\n" + 
							"该系统针对于城市车辆违章管理而设计，\r\n" + 
							"分为管理员、用户两个模块。\r\n" + 
							"\r\n" + 
							"该系统包含违章管理需要的大部分功能，\r\n" + 
							"具有功能全面、易学易用、高效等特点。");
				}
				else
				{
					buttonishelp=true;
					btnNewButton.setText("关于本系统");
					textArea_1.setText("友情提示：\r\n" + 
							"\r\n" + 
							"请使用统一身份认证账号登录，\r\n" + 
							"登录时请注意身份选择，\r\n" + 
							"初始密码为123456，\r\n" + 
							"请登陆后修改密码，\r\n" + 
							"如果忘记密码，请联系管理员找回。\r\n" + 
							"管理员邮箱：576922471@qq.com");
				}
				
				
			}
		});
		btnNewButton.setBounds(96, 228, 173, 23);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton);
		
		
		
		//居中显示
		this.setLocationRelativeTo(null);
				
		//设置窗体大小不变
		this.setResizable(false);
		
	}
}
