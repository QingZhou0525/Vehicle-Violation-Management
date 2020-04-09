package 车辆违章管理系统;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class SearchUser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchUser frame = new SearchUser();
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
	public SearchUser() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SearchUser.class.getResource("/photo/caricon.png")));
		setTitle("用户信息查询");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 291, 353);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SearchUser.class.getResource("/photo/身份证.png")));
		lblNewLabel.setBounds(10, 38, 39, 31);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setToolTipText("请输入身份证号");
		textField.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		textField.setBounds(57, 42, 146, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("请输入身份证号：");
		lblNewLabel_1.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 13, 190, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("：");
		lblNewLabel_2.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_2.setIcon(new ImageIcon(SearchUser.class.getResource("/photo/user.png")));
		lblNewLabel_2.setBounds(12, 83, 43, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("：");
		lblNewLabel_3.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_3.setIcon(new ImageIcon(SearchUser.class.getResource("/photo/电 话.png")));
		lblNewLabel_3.setBounds(12, 124, 43, 31);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("：");
		lblNewLabel_4.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_4.setIcon(new ImageIcon(SearchUser.class.getResource("/photo/name.png")));
		lblNewLabel_4.setBounds(160, 83, 39, 31);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("：");
		lblNewLabel_5.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_5.setIcon(new ImageIcon(SearchUser.class.getResource("/photo/性别.png")));
		lblNewLabel_5.setBounds(160, 124, 39, 31);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("：");
		lblNewLabel_6.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_6.setIcon(new ImageIcon(SearchUser.class.getResource("/photo/邮箱.png")));
		lblNewLabel_6.setBounds(12, 205, 51, 31);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("：");
		lblNewLabel_7.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_7.setIcon(new ImageIcon(SearchUser.class.getResource("/photo/驾驶证.png")));
		lblNewLabel_7.setBounds(12, 165, 51, 31);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("：");
		lblNewLabel_8.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_8.setIcon(new ImageIcon(SearchUser.class.getResource("/photo/密码.png")));
		lblNewLabel_8.setBounds(12, 240, 51, 31);
		contentPane.add(lblNewLabel_8);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		textField_1.setToolTipText("账号");
		textField_1.setBounds(57, 90, 93, 21);
		textField_1.setEditable(false);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("电话");
		textField_2.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		textField_2.setBounds(57, 129, 93, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		textField_3.setToolTipText("姓名");
		textField_3.setBounds(196, 89, 78, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(SystemColor.window);
		comboBox.setToolTipText("性别");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"男", "女"}));
		comboBox.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		comboBox.setBounds(196, 129, 78, 21);
		contentPane.add(comboBox);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		textField_4.setToolTipText("驾驶证号");
		textField_4.setBounds(57, 170, 217, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		textField_5.setToolTipText("邮箱");
		textField_5.setBounds(57, 210, 217, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		textField_6.setToolTipText("密码");
		textField_6.setBounds(57, 245, 217, 21);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//获取输入的身份证号码
				String identification=textField.getText().trim();
				
				//判断身份证格式是否正确
				String identification_regex = "\\d{15}|\\d{17}[\\dxX]";
				Pattern identification_pattern = Pattern.compile(identification_regex);
				Matcher identification_matcher = identification_pattern.matcher(identification);
				// 布尔值表示身份证号码格式是否与规则一致
				boolean identification_istrue=identification_matcher.matches();
				
				if(identification.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "身份证号码不能为空！");
				}
				else
				{
					if(!identification_istrue)
					{
						JOptionPane.showMessageDialog(null, "身份证格式不正确！");
					}
					else
					{
						Connection conn;
						PreparedStatement ps=null;
						ResultSet rs=null;
						
						ConnectDB connect =new ConnectDB();
						conn=connect.getConnection();
						
						try {
							//查询数据库
							String sql="select * from dbo.Users where identification='"+identification+"'";
							ps=conn.prepareStatement(sql);
							rs=ps.executeQuery();
						
							if(rs.next()) {
														
								textField_1.setText(rs.getString("id"));
								textField_2.setText(rs.getString("tel"));
								textField_3.setText(rs.getString("name"));
								comboBox.setSelectedItem(rs.getString("sex"));
								textField_4.setText(rs.getString("licence"));
								textField_5.setText(rs.getString("email"));
								textField_6.setText(SearchUser.toString(rs.getString("password")));
								
								
							}
							else
							{
								JOptionPane.showMessageDialog(null, "无此人信息！");
							}
							
							
						}catch(Exception e) {
							e.printStackTrace();
						}
						
						connect.closeConection(ps,rs,conn);
					}
				}
				
			}
		});
		btnNewButton.setBounds(207, 41, 67, 23);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("保存修改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name=textField_3.getText().trim();
				String tel=textField_2.getText().trim();
				String sex=comboBox.getSelectedItem().toString().trim();
				String licence=textField_4.getText().trim();
				String email=textField_5.getText().trim();
				String password=StrToBinstr(textField_6.getText().trim());
				
				//判断姓名为纯汉字
				boolean name_ischinese=true;
				char[] name_char=name.toCharArray();
				for(int i=0;i<name_char.length;i++) {
					if(!(name_char[i] >= '\u4E00' && name_char[i] <= '\u9FA5')) 
					{
						name_ischinese=false;
						break;
					}
				}
				
				//电话号码验证规则
				String tel_regex = "^[1](([3][0-9])|([4][5,7,9])|([5][^4,6,9])|([6][6])|([7][3,5,6,7,8])|([8][0-9])|([9][8,9]))[0-9]{8}$";
				Pattern tel_pattern = Pattern.compile(tel_regex);
				//验证电话号码
				Matcher tel_matcher = tel_pattern.matcher(tel);
				//布尔值表示电话号码格式是否与规则一致
				boolean tel_istrue=tel_matcher.matches();
				
				//驾驶证号码验证规则
				String licence_regex = "\\d{15}|\\d{17}[\\dxX]";
				Pattern licence_pattern = Pattern.compile(licence_regex);
				//验证驾驶证号码
				Matcher licence_matcher = licence_pattern.matcher(licence);
				// 布尔值表示驾驶证号码格式是否与规则一致
				boolean licence_istrue=licence_matcher.matches();
				
				
				// 邮箱验证规则
				// 编译正则表达式
				String email_regex = "[0-9a-zA-Z]{1,}@[0-9a-zA-Z]{1,}\\.(com|cn)";
				Pattern email_pattern = Pattern.compile(email_regex);
				Matcher email_matcher = email_pattern.matcher(email);
				// 布尔值表示邮箱格式是否与规则一致
				boolean email_istrue = email_matcher.matches();
				
				if(name.isEmpty()||tel.isEmpty()||sex.isEmpty()||licence.isEmpty()||email.isEmpty()||password.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "有信息未填！");
				}
				else
				{
					if(!name_ischinese)
					{
						JOptionPane.showMessageDialog(null, "姓名应该为纯汉字！");
					}
					else
					{
						if(!tel_istrue)
						{
							JOptionPane.showMessageDialog(null, "电话号码格式不正确！");
						}
						else
						{
							if(!licence_istrue)
							{
								JOptionPane.showMessageDialog(null, "驾驶证号格式不正确！");
							}
							else
							{
								if(!email_istrue)
								{
									JOptionPane.showMessageDialog(null, "邮箱格式不正确！");
								}
								else
								{
									
									int result = JOptionPane.showConfirmDialog(null, "是否要保存修改！", "确认修改框", JOptionPane.YES_NO_OPTION);										
									//确认添加
									if (result == JOptionPane.YES_OPTION) {
										
										//修改Users表
										Connection conn_update;
										PreparedStatement ps_update=null;
										ResultSet rs_update=null;
										
										ConnectDB connect_update =new ConnectDB();
										conn_update=connect_update.getConnection();
										
										try {
												
											String sql="update dbo.Users set name='"+name+"',sex='"+sex+ "',tel='"+tel+"',licence='"+licence+"',email='"+email+"',password='"+password+"'where id="+textField_1.getText().trim();
											ps_update=conn_update.prepareStatement(sql);
											rs_update=ps_update.executeQuery();
												
										}catch(Exception e_update) {
											e_update.printStackTrace();
										}

										connect_update.closeConection(ps_update,rs_update,conn_update);
										
										//将电话修改到CarInformation表
										Connection conn;
										PreparedStatement ps=null;
										ResultSet rs=null;
										
										ConnectDB connect =new ConnectDB();
										conn=connect.getConnection();
										
										boolean isdata=false;
										
										try {
											//查询数据库
											String sql="select * from dbo.CarInformation where ownerlicence='"+licence+"'";
											ps=conn.prepareStatement(sql);
											rs=ps.executeQuery();
										
											while(rs.next()) {
												
												isdata=true;
											}
										}catch(Exception e1) {
											e1.printStackTrace();
										}
										
										connect.closeConection(ps,rs,conn);
										
										if(isdata) {
											
											Connection conn_update1;
											PreparedStatement ps_update1=null;
											ResultSet rs_update1=null;
											
											ConnectDB connect_update1 =new ConnectDB();
											conn_update1=connect_update1.getConnection();
											
											try {
													
												String sql1="update dbo.CarInformation set ownertel='"+tel+"'where ownerlicence='"+licence+"'";
												ps_update1=conn_update1.prepareStatement(sql1);
												rs_update1=ps_update1.executeQuery();
													
											}catch(Exception e_update1) {
												e_update1.printStackTrace();
											}

											connect_update1.closeConection(ps_update1,rs_update1,conn_update1);
										}
			
										JOptionPane.showMessageDialog(null, "修改成功！");
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
		});
		btnNewButton_1.setBackground(SystemColor.menu);
		btnNewButton_1.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_1.setBounds(94, 285, 105, 23);
		contentPane.add(btnNewButton_1);
		
		
		
		//回车查询
		textField.addKeyListener(new KeyAdapter() 
		{
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar()==KeyEvent.VK_ENTER) {
					btnNewButton.doClick();
				}
			}
		});
		
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
