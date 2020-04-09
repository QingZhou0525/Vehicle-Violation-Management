package 车辆违章管理系统;

import java.awt.BorderLayout;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.DropMode;
import javax.swing.Icon;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Toolkit;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField id_text;
	private JPasswordField pwd_text;
	static String get_id;
	static String get_name;
	static String get_licence;
	Point pressedPoint;
	
	/**
	 * Launch the application.
	 */
	


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/photo/caricon.png")));
		setBackground(Color.WHITE);
		setTitle("车辆违章管理");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 399);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setUndecorated(true);
		
		
		//按住鼠标拖动
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) { //鼠标按下事件
				pressedPoint = e.getPoint(); //记录鼠标坐标
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) { // 鼠标拖拽事件
				Point point = e.getPoint();// 获取当前坐标
				Point locationPoint = getLocation();// 获取窗体坐标
				int x = locationPoint.x + point.x - pressedPoint.x;// 计算移动后的新坐标
				int y = locationPoint.y + point.y - pressedPoint.y;
				setLocation(x, y);// 改变窗体位置
			}
		});


		
		JComboBox choose_comboBox = new JComboBox();
		choose_comboBox.setToolTipText("选择身份");
		choose_comboBox.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		choose_comboBox.setBackground(SystemColor.window);
		choose_comboBox.setForeground(Color.BLACK);
		choose_comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u7BA1\u7406\u5458", "\u7528\u6237"}));
		choose_comboBox.setBounds(575, 152, 117, 21);
		contentPane.add(choose_comboBox);
		
		JButton login_button = new JButton("登       录");
		login_button.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		login_button.setBackground(SystemColor.menu);
		login_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//管理员登录
				if(choose_comboBox.getSelectedItem().toString()=="管理员")
				{
					
					
					//输入的id和密码
					get_id=id_text.getText().trim();
					String pwd=pwd_text.getText().trim();

					//数据库中的id和密码
					int Id;
					String Password=null;

					//id为数字或id不为空
					if(isNumber(get_id)&&!get_id.isEmpty()) {
						
						Connection conn;
						PreparedStatement ps=null;
						ResultSet rs=null;
						
						ConnectDB connect =new ConnectDB();
						conn=connect.getConnection();
						
						try {
							//查询数据库
							String sql="select * from dbo.VehicleManager where id="+get_id;
							ps=conn.prepareStatement(sql);
							rs=ps.executeQuery();
						
							while(rs.next()) {
								get_name=rs.getString("name");
								Id=rs.getInt("id");
								Password=Login.toString(rs.getString("password").trim());
							}
							
							if(pwd.equals(Password)) {
								Admin admin=new Admin();
								dispose();
								admin.show();
							}else {
								JOptionPane.showMessageDialog(null, "用户名或密码不正确！");
							}
							
							
						}catch(Exception e) {
							e.printStackTrace();
						}
						
						connect.closeConection(ps,rs,conn);
					}
					//id不为数字或为空
					else 
					{
						JOptionPane.showMessageDialog(null, "用户名为空或格式不正确！");
					}

				}
				//用户登录
				else
				{
					//输入的id和密码
					get_id=id_text.getText().trim();
					String pwd=pwd_text.getText().trim();

					//数据库中的id和密码
					int Id;
					String Password=null;

					//id为数字或不为空
					if(isNumber(get_id)&&!get_id.isEmpty()) {
						
						Connection conn;
						PreparedStatement ps=null;
						ResultSet rs=null;
						
						ConnectDB connect =new ConnectDB();
						conn=connect.getConnection();
						
						try {
							//查询数据库
							String sql="select * from dbo.Users where id="+get_id;
							ps=conn.prepareStatement(sql);
							rs=ps.executeQuery();
						
							while(rs.next()) {
								get_name=rs.getString("name");
								get_licence=rs.getString("licence");
								Id=rs.getInt("id");
								Password=Login.toString(rs.getString("password").trim());
							}
							
							if(pwd.equals(Password)) {
								User user=new User();
								dispose();
								user.show();
							}else {
								JOptionPane.showMessageDialog(null, "用户名或密码不正确！");
							}
							
							
						}catch(Exception e) {
							e.printStackTrace();
						}
						
						connect.closeConection(ps,rs,conn);
					}
					//id不为数字或id为空
					else 
					{
						JOptionPane.showMessageDialog(null, "用户名为空或格式不正确！");
					}

					
				}
			}
			
		});
		login_button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		login_button.setBounds(550, 271, 142, 22);
		contentPane.add(login_button);
		
		id_text = new JTextField();
		id_text.setBackground(Color.WHITE);
		id_text.setForeground(Color.BLACK);
		id_text.setToolTipText("账号");
		id_text.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		id_text.setBounds(575, 190, 117, 21);
		contentPane.add(id_text);
		id_text.setColumns(10);
		
		//回车登录
		id_text.addKeyListener(new KeyAdapter() 
		{
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar()==KeyEvent.VK_ENTER) {
					login_button.doClick();
				}
			}
		});
				
		JLabel label = new JLabel("\u8F66\u8F86\u8FDD\u7AE0\u7BA1\u7406\u7CFB\u7EDF");
		label.setBackground(new Color(0, 0, 0));
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("方正准圆简体", Font.BOLD, 18));
		label.setBounds(544, 95, 165, 43);
		contentPane.add(label);
		
		pwd_text = new JPasswordField();
		pwd_text.setToolTipText("密码");
		pwd_text.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		pwd_text.setEchoChar('*');
		pwd_text.setBounds(575, 221, 117, 21);
		contentPane.add(pwd_text);
		
		JButton btnNewButton = new JButton("用户注册");
		btnNewButton.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				UserRegistration userregistration = new UserRegistration();
				userregistration.show();
			}
		});
		btnNewButton.setBounds(550, 336, 142, 23);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("忘记密码");
		btnNewButton_1.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_1.setBackground(SystemColor.menu);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FindKey findkey=new FindKey();
				findkey.show();
			}
		});
		btnNewButton_1.setBounds(550, 303, 142, 23);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/photo/loginbg.jpg")));
		lblNewLabel.setBounds(0, 0, 515, 401);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setToolTipText("关闭");
		btnNewButton_2.setIcon(new ImageIcon(Login.class.getResource("/photo/close.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_2.setBounds(686, 0, 33, 34);
		btnNewButton_2.setIconTextGap(0);//将标签中显示的文本和图标之间的间隔量设置为0  
		btnNewButton_2.setBorderPainted(false);//不打印边框  
		btnNewButton_2.setBorder(null);//除去边框  
		btnNewButton_2.setText(null);//除去按钮的默认名称  
		btnNewButton_2.setFocusPainted(false);//除去焦点的框  
		btnNewButton_2.setContentAreaFilled(false);//除去默认的背景填充
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//鼠标变换
		btnNewButton_2.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e) {
				btnNewButton_2.setIcon(new ImageIcon(Login.class.getResource("/photo/close2.png")));
			}
			public void mouseExited(MouseEvent e) {
				btnNewButton_2.setIcon(new ImageIcon(Login.class.getResource("/photo/close.png")));
			}
		});
		contentPane.add(btnNewButton_2);
		
		JButton button = new JButton((String) null);
		button.setToolTipText("最小化");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setExtendedState(JFrame.ICONIFIED);
			}
		});
		button.setIcon(new ImageIcon(Login.class.getResource("/photo/min.png")));
		button.setIconTextGap(0);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setBounds(660, 5, 26, 23);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//鼠标变换
		button.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e) {
				button.setIcon(new ImageIcon(Login.class.getResource("/photo/min2.png")));
			}
			
			public void mouseExited(MouseEvent e) {
				button.setIcon(new ImageIcon(Login.class.getResource("/photo/min.png")));
			}
		});
		contentPane.add(button);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/photo/car.png")));
		lblNewLabel_1.setBounds(595, 42, 72, 54);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/photo/password.png")));
		lblNewLabel_2.setBounds(544, 213, 33, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/photo/user.png")));
		lblNewLabel_3.setBounds(544, 190, 54, 21);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Login.class.getResource("/photo/choose.png")));
		lblNewLabel_4.setBounds(542, 152, 40, 21);
		contentPane.add(lblNewLabel_4);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				
				LoginHelp loginhelp=new LoginHelp();
				loginhelp.show();
			}
		});
		btnNewButton_3.setToolTipText("帮助");
		//btnNewButton_3.setIcon(new ImageIcon("photo/help.png"));
		btnNewButton_3.setIcon(new ImageIcon(Login.class.getResource("/photo/help.png")));
		btnNewButton_3.setBounds(627, 5, 40, 23);
		btnNewButton_3.setIconTextGap(0);//将标签中显示的文本和图标之间的间隔量设置为0  
		btnNewButton_3.setBorderPainted(false);//不打印边框  
		btnNewButton_3.setBorder(null);//除去边框  
		btnNewButton_3.setText(null);//除去按钮的默认名称  
		btnNewButton_3.setFocusPainted(false);//除去焦点的框  
		btnNewButton_3.setContentAreaFilled(false);//除去默认的背景填充
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//鼠标变换
		btnNewButton_3.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e) {
					btnNewButton_3.setIcon(new ImageIcon(Login.class.getResource("/photo/help2.png")));
			}
			public void mouseExited(MouseEvent e) {
					btnNewButton_3.setIcon(new ImageIcon(Login.class.getResource("/photo/help.png")));
			}
		});
		contentPane.add(btnNewButton_3);
		
		//回车登录
		pwd_text.addKeyListener(new KeyAdapter() 
		{
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar()==KeyEvent.VK_ENTER) {
					login_button.doClick();
				}
			}
		});
		
		//居中显示
		this.setLocationRelativeTo(null);
		
		//设置窗体大小不变
		this.setResizable(false);

	}
	

	
	//判断id是否为纯数字
	 public boolean isNumber(String str){
	        for (int i=0;i<str.length();i++){
	            if (!Character.isDigit(str.charAt(i)))
	            {
	                return false;
	            }
	        }
	        return true;
	    }
	 
	 
	//二进制字符串转换为普通字符串
			public static String toString(String binaryStr) {

				   if (binaryStr == null) return null;

				   String[] binArrays = binaryStr.split(" ");


				   StringBuffer sb = new StringBuffer();
				        for (String binStr : binArrays) {
				            char c = binstrToChar(binStr);
				            sb.append(c);
				        }
				        return sb.toString();
			}

			//二进制字符串转换为int数组 
			private static int[] binstrToIntArray(String binStr) {
				   char[] temp=binStr.toCharArray();
				   int[] result=new int[temp.length];
				   for(int i=0;i<temp.length;i++) {
				         result[i]=temp[i]-48;
				   }
				      return result;
			}

			//将二进制转换为字符
			private static char binstrToChar(String binStr){
				   int[] temp=binstrToIntArray(binStr);
				   int sum=0;
				   for(int i=0; i<temp.length;i++){
				            sum +=temp[temp.length-1-i]<<i;
				   }
				        return (char)sum;
			}		
}
