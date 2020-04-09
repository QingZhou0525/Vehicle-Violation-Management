package 车辆违章管理系统;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class AddUser extends JFrame {

	private JPanel contentPane;
	private JTextField name_text;
	private JTextField tel_text;
	private JTextField email_text;
	private JTextField licence_text;
	private JTextField identity_text;
	private JTextField pwd_text;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUser frame = new AddUser();
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
	public AddUser() {
		setFont(new Font("方正准圆简体", Font.PLAIN, 13));
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddUser.class.getResource("/photo/caricon.png")));
		setTitle("添加用户");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 336, 342);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel id_label = new JLabel("：");
		id_label.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		id_label.setIcon(new ImageIcon(AddUser.class.getResource("/photo/user.png")));
		id_label.setBounds(23, 19, 45, 23);
		contentPane.add(id_label);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setToolTipText("你的账号,请牢记");
		lblNewLabel_1.setFont(new Font("方正准圆简体", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(74, 20, 94, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel name_label = new JLabel(":");
		name_label.setFont(new Font("方正准圆简体", Font.BOLD, 14));
		name_label.setIcon(new ImageIcon(AddUser.class.getResource("/photo/name.png")));
		name_label.setBounds(178, 19, 45, 23);
		contentPane.add(name_label);
		
		name_text = new JTextField();
		name_text.setToolTipText("请输入姓名");
		name_text.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		name_text.setBounds(213, 20, 92, 21);
		contentPane.add(name_text);
		name_text.setColumns(10);
		
		JLabel sex_label = new JLabel(":");
		sex_label.setFont(new Font("方正准圆简体", Font.BOLD, 14));
		sex_label.setIcon(new ImageIcon(AddUser.class.getResource("/photo/性别.png")));
		sex_label.setBounds(25, 58, 71, 23);
		contentPane.add(sex_label);
		
		JLabel tel_label = new JLabel("：");
		tel_label.setIcon(new ImageIcon(AddUser.class.getResource("/photo/电 话.png")));
		tel_label.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		tel_label.setBounds(178, 60, 54, 19);
		contentPane.add(tel_label);
		
		tel_text = new JTextField();
		tel_text.setToolTipText("请输入电话");
		tel_text.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		tel_text.setBounds(213, 59, 92, 21);
		contentPane.add(tel_text);
		tel_text.setColumns(10);
		
		JLabel email_label = new JLabel("：");
		email_label.setIcon(new ImageIcon(AddUser.class.getResource("/photo/邮箱.png")));
		email_label.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		email_label.setBounds(23, 185, 71, 24);
		contentPane.add(email_label);
		
		email_text = new JTextField();
		email_text.setToolTipText("请输入邮箱");
		email_text.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		email_text.setBounds(74, 185, 231, 21);
		contentPane.add(email_text);
		email_text.setColumns(10);
		
		JLabel licence_label = new JLabel("：");
		licence_label.setIcon(new ImageIcon(AddUser.class.getResource("/photo/驾驶证.png")));
		licence_label.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		licence_label.setBounds(23, 101, 54, 35);
		contentPane.add(licence_label);
		
		licence_text = new JTextField();
		licence_text.setToolTipText("请输入驾驶证号");
		licence_text.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		licence_text.setBounds(74, 108, 231, 21);
		contentPane.add(licence_text);
		licence_text.setColumns(10);
		
		JLabel identity_label = new JLabel("：");
		identity_label.setIcon(new ImageIcon(AddUser.class.getResource("/photo/身份证.png")));
		identity_label.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		identity_label.setBounds(23, 146, 71, 24);
		contentPane.add(identity_label);
		
		identity_text = new JTextField();
		identity_text.setToolTipText("请输入身份证号");
		identity_text.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		identity_text.setBounds(74, 146, 231, 21);
		contentPane.add(identity_text);
		identity_text.setColumns(10);
		
		JLabel pwd_label = new JLabel("：");
		pwd_label.setIcon(new ImageIcon(AddUser.class.getResource("/photo/密码.png")));
		pwd_label.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		pwd_label.setBounds(24, 218, 54, 30);
		contentPane.add(pwd_label);
		
		pwd_text = new JTextField();
		pwd_text.setToolTipText("默认密码为123456，请自行修改");
		pwd_text.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		pwd_text.setText("123456");
		pwd_text.setBounds(74, 224, 231, 21);
		contentPane.add(pwd_text);
		pwd_text.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("请选择性别");
		comboBox.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		comboBox.setBackground(SystemColor.window);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"男", "女"}));
		comboBox.setBounds(74, 59, 72, 21);
		contentPane.add(comboBox);
		
		
		//获取当前年份
		Calendar date = Calendar.getInstance();
		String year = String.valueOf(date.get(Calendar.YEAR));
				
		//定义当前年份的用户数
		int year_count=0;
				
		int id_init= 0;
		
		Connection conn;
		PreparedStatement ps=null;
		ResultSet rs=null;
				
		ConnectDB connect =new ConnectDB();
		conn=connect.getConnection();

		try {
			//查询数据库
			String sql="select * from dbo.Users where id like '"+year+"%' order by id asc";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
					
			//统计当前年份用户数
			while(rs.next()) {	
				id_init=rs.getInt("id");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
				
		connect.closeConection(ps,rs,conn);
				
		//给id的标签赋值
		lblNewLabel_1.setText(Integer.toString(id_init+1));
		
		
		
		
		//确定按钮
		JButton btnNewButton = new JButton("确  定");
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//获取name值
				String text_name = name_text.getText().trim();
				char ch_name='0';
				//获取电话值
				String text_tel = tel_text.getText().trim();
				char ch_tel='0';
				//获取驾驶证号值
				String text_licence = licence_text.getText().trim();
				char ch_licence='0';
				//获取身份证号值
				String text_identity = identity_text.getText().trim();
				char ch_identity='0';
				//获取邮箱值
				String text_email = email_text.getText().trim();
				char ch_email='0';
				//获取密码值
				String text_pwd = StrToBinstr(pwd_text.getText().trim());
				char ch_pwd='0';
				
				boolean insert_licence=true;
				boolean insert_identity=true;
				boolean insert_email=true;
				
				//判断驾驶证号码无重复
				Connection conn2;
				PreparedStatement ps2=null;
				ResultSet rs2=null;
						
				ConnectDB connect2 =new ConnectDB();
				conn2=connect2.getConnection();

				try {
					//查询数据库
					String sql2="select * from dbo.Users where licence='"+text_licence+"'";
					ps2=conn2.prepareStatement(sql2);
					rs2=ps2.executeQuery();
							
					while(rs2.next()) {	
						insert_licence=false;
					}
				}catch(Exception e2) {
					e2.printStackTrace();
				}
						
				connect2.closeConection(ps2,rs2,conn2);
		
				//判断身份证号码无重复
				Connection conn3;
				PreparedStatement ps3=null;
				ResultSet rs3=null;
						
				ConnectDB connect3 =new ConnectDB();
				conn3=connect3.getConnection();

				try {
					//查询数据库
					String sql3="select * from dbo.Users where identification='"+text_identity+"'";
					ps3=conn3.prepareStatement(sql3);
					rs3=ps3.executeQuery();
							
					while(rs3.next()) {	
						insert_identity=false;
					}
				}catch(Exception e3) {
					e3.printStackTrace();
				}
						
				connect3.closeConection(ps3,rs3,conn3);
				
				//判断邮箱无重复
				Connection conn4;
				PreparedStatement ps4=null;
				ResultSet rs4=null;
						
				ConnectDB connect4 =new ConnectDB();
				conn4=connect4.getConnection();

				try {
					//查询数据库
					String sql4="select * from dbo.Users where email='"+text_email+"'";
					ps4=conn4.prepareStatement(sql4);
					rs4=ps4.executeQuery();
							
					while(rs4.next()) {	
						insert_email=false;
					}
				}catch(Exception e4) {
					e4.printStackTrace();
				}
						
				connect4.closeConection(ps4,rs4,conn4);
				
				
				if(text_name.isEmpty()||text_tel.isEmpty()||text_licence.isEmpty()||text_identity.isEmpty()||text_email.isEmpty()||text_pwd.isEmpty()) 
				{
					JOptionPane.showMessageDialog(null, "有信息未填！");
				}
				else 
				{
					ch_name = text_name.charAt(text_name.length() - 1);
					ch_tel = text_tel.charAt(text_tel.length() - 1);
					ch_licence = text_licence.charAt(text_licence.length() - 1);
					ch_identity = text_identity.charAt(text_identity.length() - 1);
					ch_email = text_email.charAt(text_email.length() - 1);
					ch_pwd = text_pwd.charAt(text_pwd.length() - 1);

					//布尔值表示name值是否为纯汉字
					boolean name_ischinese=true;
					
					char[] name=text_name.toCharArray();
					for(int i=0;i<name.length;i++) {
						//判断姓名为纯汉字
						if(!(name[i] >= '\u4E00' && name[i] <= '\u9FA5')) 
						{
							name_ischinese=false;
							break;
						}
					}
					
					//电话号码验证规则
					String tel_regex = "^[1](([3][0-9])|([4][5,7,9])|([5][^4,6,9])|([6][6])|([7][3,5,6,7,8])|([8][0-9])|([9][8,9]))[0-9]{8}$";
					Pattern tel_pattern = Pattern.compile(tel_regex);
					//验证电话号码
					Matcher tel_matcher = tel_pattern.matcher(text_tel);
					//布尔值表示电话号码格式是否与规则一致
					boolean tel_istrue=tel_matcher.matches();
					
					//驾驶证号码和身份证号码验证规则
					String id_regex = "\\d{15}|\\d{17}[\\dxX]";
					Pattern id_pattern = Pattern.compile(id_regex);
					//验证驾驶证号码
					Matcher licence_matcher = id_pattern.matcher(text_licence);
					//验证身份证号码
					Matcher identity_matcher = id_pattern.matcher(text_identity);
					// 布尔值表示驾驶证号码格式是否与规则一致
					boolean licence_istrue=licence_matcher.matches();
					// 布尔值表示身份证号码格式是否与规则一致
					boolean identity_istrue=identity_matcher.matches();
					
					// 邮箱验证规则
					// 编译正则表达式
					String email_regex = "[0-9a-zA-Z]{1,}@[0-9a-zA-Z]{1,}\\.(com|cn)";
					Pattern email_pattern = Pattern.compile(email_regex);
					Matcher email_matcher = email_pattern.matcher(text_email);
					// 布尔值表示邮箱格式是否与规则一致
					boolean email_istrue = email_matcher.matches();

					//对进行输入的值判断
					//判断姓名是否为纯中文
					if(!name_ischinese) 
					{
						JOptionPane.showMessageDialog(null, "姓名应该为纯汉字！");
					}
					else 
					{
						//判断电话格式是否正确
						if(!tel_istrue)
						{
							JOptionPane.showMessageDialog(null, "电话号码格式不正确！");
						}
						else
						{
							//判断驾驶证格式是否正确或有无重复
							if(!licence_istrue||!insert_licence) 
							{
								JOptionPane.showMessageDialog(null, "驾驶证号码格式不正确或该驾驶证号已被注册！");
							}
							else 
							{
								//判断身份证号码格式是否正确
								if(!identity_istrue||!insert_identity)
								{
									JOptionPane.showMessageDialog(null, "身份证号码格式不正确或该身份证号已被注册！");
								}
								else
								{
									//判断邮箱格式是否正确或有无重复
									if(!email_istrue||!insert_email)
									{
										JOptionPane.showMessageDialog(null, "邮箱格式不正确或该邮箱已被注册！");
									}
									else
									{
										
											int result = JOptionPane.showConfirmDialog(null, "请确定信息无误！", "确认注册框", JOptionPane.YES_NO_OPTION);										
											//确认添加
											if (result == JOptionPane.YES_OPTION) {
												//获取性别值
												String input_sex=(String) comboBox.getSelectedItem();
												
												String input_id=lblNewLabel_1.getText().trim();
												
												int id_in=Integer.parseInt(input_id);
												
												
											
												Connection conn_insert;
												PreparedStatement ps_insert=null;
												ResultSet rs_insert=null;
														
												ConnectDB connect_insert =new ConnectDB();
												conn_insert=connect_insert.getConnection();

												try {
													//插入数据库中
													String sql="insert into dbo.Users values ('"+text_name+"','"+input_sex+"','"+text_tel+"','"+text_licence+"','"+text_identity+"','"+text_email+"',"+id_in+",'"+text_pwd+ "')";
													ps_insert=conn_insert.prepareStatement(sql);
													rs_insert=ps_insert.executeQuery();

												}catch(Exception e_insert) {
													e_insert.printStackTrace();
												}
												
												
												connect_insert.closeConection(ps_insert,rs_insert,conn_insert);												
												JOptionPane.showMessageDialog(null, "添加成功！");
												dispose();
																								
											}
											//取消添加
											else if (result == JOptionPane.NO_OPTION) {
												//退出
											}		

									}
								}	
							}
						}
					}
				}			
			}
		});

		btnNewButton.setBounds(186, 268, 102, 23);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton);
		
		//取消按钮
		JButton btnNewButton_1 = new JButton("取  消");
		btnNewButton_1.setBackground(SystemColor.menu);
		btnNewButton_1.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(40, 268, 102, 23);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton_1);
				
		//居中显示
		this.setLocationRelativeTo(null);
		
		//设置窗体大小不变
		this.setResizable(false);
	}
	
	//将字符串转换成二进制字符串，以空格相隔
	private String StrToBinstr(String str) { 
		char[] strChar = str.toCharArray(); 
		String result = ""; 
		for (int i = 0; i < strChar.length; i++) { 
		       result += Integer.toBinaryString(strChar[i]) + " "; 
		} 
		return result; 
	}
	
}
