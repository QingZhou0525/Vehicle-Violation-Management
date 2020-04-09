package 车辆违章管理系统;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserInformation extends JFrame {

	private JPanel contentPane;

	String car_num;
	
	boolean carnum_isnull=false;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInformation frame = new UserInformation();
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
	public UserInformation() {
		setTitle("个人中心");
		setIconImage(Toolkit.getDefaultToolkit().getImage(UserInformation.class.getResource("/photo/caricon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 318, 502);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("：");
		lblNewLabel.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel.setIcon(new ImageIcon(UserInformation.class.getResource("/photo/user.png")));
		lblNewLabel.setBounds(10, 31, 54, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("：");
		lblNewLabel_2.setIcon(new ImageIcon(UserInformation.class.getResource("/photo/name.png")));
		lblNewLabel_2.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(164, 31, 54, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("：");
		lblNewLabel_3.setIcon(new ImageIcon(UserInformation.class.getResource("/photo/性别.png")));
		lblNewLabel_3.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(12, 65, 54, 30);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("：");
		lblNewLabel_4.setIcon(new ImageIcon(UserInformation.class.getResource("/photo/驾驶证.png")));
		lblNewLabel_4.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 105, 54, 30);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("：");
		lblNewLabel_5.setIcon(new ImageIcon(UserInformation.class.getResource("/photo/身份证.png")));
		lblNewLabel_5.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(10, 145, 46, 29);
		contentPane.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setToolTipText("账号，不可修改");
		textField.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		textField.setBounds(58, 36, 92, 21);
		textField.setEditable(false);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("姓名，请联系管理员修改");
		textField_1.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		textField_1.setBounds(203, 36, 92, 21);
		textField_1.setEditable(false);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("性别，请联系管理员修改");
		textField_2.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		textField_2.setBounds(58, 71, 92, 21);
		textField_2.setEditable(false);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("电话，可修改");
		textField_3.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		textField_3.setBounds(203, 71, 92, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("驾驶证号，请联系管理员修改");
		textField_4.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		textField_4.setBounds(58, 110, 237, 21);
		textField_4.setEditable(false);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
			
		JLabel lblNewLabel_1 = new JLabel("：");
		lblNewLabel_1.setIcon(new ImageIcon(UserInformation.class.getResource("/photo/电 话.png")));
		lblNewLabel_1.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(164, 65, 54, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_6 = new JLabel("：");
		lblNewLabel_6.setIcon(new ImageIcon(UserInformation.class.getResource("/photo/邮箱.png")));
		lblNewLabel_6.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(10, 180, 54, 30);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("：");
		lblNewLabel_7.setIcon(new ImageIcon(UserInformation.class.getResource("/photo/密码.png")));
		lblNewLabel_7.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(11, 213, 54, 30);
		contentPane.add(lblNewLabel_7);
		
		textField_5 = new JTextField();
		textField_5.setToolTipText("身份证号，请联系管理员修改");
		textField_5.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		textField_5.setBounds(58, 149, 237, 21);
		textField_5.setEditable(false);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setToolTipText("邮箱，可修改");
		textField_6.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		textField_6.setBounds(58, 185, 237, 21);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setToolTipText("密码，可修改");
		textField_7.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		textField_7.setBounds(58, 220, 237, 21);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("个人信息：");
		lblNewLabel_8.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(10, 10, 115, 15);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("车辆绑定：");
		lblNewLabel_9.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(10, 311, 139, 21);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("：");
		lblNewLabel_10.setIcon(new ImageIcon(UserInformation.class.getResource("/photo/车牌号.png")));
		lblNewLabel_10.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(10, 342, 54, 26);
		contentPane.add(lblNewLabel_10);
		
		textField_8 = new JTextField();
		textField_8.setToolTipText("车牌号，可修改");
		textField_8.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		textField_8.setBounds(58, 342, 66, 21);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("：");
		lblNewLabel_11.setIcon(new ImageIcon(UserInformation.class.getResource("/photo/车辆颜色.png")));
		lblNewLabel_11.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_11.setBounds(153, 340, 54, 30);
		contentPane.add(lblNewLabel_11);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("车辆颜色，可修改");
		comboBox.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"请选择", "黑色", "白色", "红色", "蓝色", "黄色", "绿色", "橙色", "银色", "灰色", "紫色", "粉色"}));
		comboBox.setBackground(SystemColor.window);
		comboBox.setBounds(203, 345, 92, 21);
		contentPane.add(comboBox);
		
		JLabel lblEngine = new JLabel(" ：");
		lblEngine.setIcon(new ImageIcon(UserInformation.class.getResource("/photo/发动机码.png")));
		lblEngine.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblEngine.setBounds(10, 378, 54, 30);
		contentPane.add(lblEngine);
		
		textField_9 = new JTextField();
		textField_9.setToolTipText("发动机编号，可修改");
		textField_9.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		textField_9.setBounds(58, 383, 66, 21);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("：");
		lblNewLabel_12.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_12.setIcon(new ImageIcon(UserInformation.class.getResource("/photo/车型.png")));
		lblNewLabel_12.setBounds(153, 378, 54, 30);
		contentPane.add(lblNewLabel_12);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("车型，可修改");
		comboBox_1.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"请选择", "小汽车", "货车", "大型客车", "拖拉机"}));
		comboBox_1.setBackground(SystemColor.window);
		comboBox_1.setBounds(203, 383, 92, 21);
		contentPane.add(comboBox_1);
		
		Login login=new Login();
		
		//用户信息
		Connection conn;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		ConnectDB connect =new ConnectDB();
		conn=connect.getConnection();
		
		try {
			//查询数据库
			String sql="select * from dbo.Users where id='"+login.get_id+"'";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
		
			while(rs.next()) {
				
				
				textField.setText(rs.getString("id"));
				textField_1.setText(rs.getString("name"));
				textField_2.setText(rs.getString("sex"));
				textField_3.setText(rs.getString("tel"));
				textField_4.setText(rs.getString("licence"));
				textField_5.setText(rs.getString("identification"));
				textField_6.setText(rs.getString("email"));
				textField_7.setText(toString(rs.getString("password")));
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		connect.closeConection(ps,rs,conn);
		
		
		//车辆信息
		Connection conn1;
		PreparedStatement ps1=null;
		ResultSet rs1=null;
		
		ConnectDB connect1 =new ConnectDB();
		conn1=connect1.getConnection();
		
		try {
			//查询数据库
			String sql1="select * from dbo.CarInformation where ownerlicence='"+textField_4.getText().trim()+"'";
			ps1=conn1.prepareStatement(sql1);
			rs1=ps1.executeQuery();
		
			while(rs1.next()) {
				
				car_num=rs1.getString("carnum");
				
				textField_8.setText(rs1.getString("carnum"));
				comboBox.setSelectedItem(rs1.getString("carcolour"));
				comboBox_1.setSelectedItem(rs1.getString("carkind"));
				textField_9.setText(rs1.getString("enginenum"));
				
			}
			
			
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
		connect1.closeConection(ps1,rs1,conn1);
		
		
		if(textField_8.getText().isEmpty()) {
			carnum_isnull=true;
		}
		
		
		
		
		JButton btnNewButton = new JButton("保存修改");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//获取电话值
				String text_tel = textField_3.getText().trim();
				char ch_tel='0';
				//获取邮箱值
				String text_email = textField_6.getText().trim();
				char ch_email='0';
				//获取密码值
				String text_pwd = StrToBinstr(textField_7.getText().trim());
				char ch_pwd='0';
				
				//电话号码验证规则
				String tel_regex = "^[1](([3][0-9])|([4][5,7,9])|([5][^4,6,9])|([6][6])|([7][3,5,6,7,8])|([8][0-9])|([9][8,9]))[0-9]{8}$";
				Pattern tel_pattern = Pattern.compile(tel_regex);
				//验证电话号码
				Matcher tel_matcher = tel_pattern.matcher(text_tel);
				//布尔值表示电话号码格式是否与规则一致
				boolean tel_istrue=tel_matcher.matches();
				
				// 邮箱验证规则
				// 编译正则表达式
				String email_regex = "[0-9a-zA-Z]{1,}@[0-9a-zA-Z]{1,}\\.(com|cn)";
				Pattern email_pattern = Pattern.compile(email_regex);
				Matcher email_matcher = email_pattern.matcher(text_email);
				// 布尔值表示邮箱格式是否与规则一致
				boolean email_istrue = email_matcher.matches();
				
				if(text_tel.isEmpty()||text_email.isEmpty()||text_pwd.isEmpty()) 
				{
					JOptionPane.showMessageDialog(null, "有信息未填！");
				}
				else
				{
					if(!tel_istrue)
					{
						JOptionPane.showMessageDialog(null, "电话号码格式不正确！");
					}
					else
					{
						if(!email_istrue)
						{
							JOptionPane.showMessageDialog(null, "邮箱格式不正确！");
						}
						else
						{
							
							int result = JOptionPane.showConfirmDialog(null, "确认修改?", "确认修改框", JOptionPane.YES_NO_OPTION);
							
							//确认修改
							if (result == JOptionPane.YES_OPTION) {
								
								//修改Users表
								Connection conn_update;
								PreparedStatement ps_update=null;
								ResultSet rs_update=null;
								
								ConnectDB connect_update =new ConnectDB();
								conn_update=connect_update.getConnection();
								
								try {
										
									String sql="update dbo.Users set tel='"+text_tel+"',email='"+text_email+ "',password='"+text_pwd+"'where id="+login.get_id;
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
									String sql="select * from dbo.CarInformation where ownerlicence='"+textField_4.getText().trim()+"'";
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
											
										String sql1="update dbo.CarInformation set ownertel='"+text_tel+"'where ownerlicence='"+textField_4.getText().trim()+"'";
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
							//取消修改
							else if (result == JOptionPane.NO_OPTION) {
								//退出
							}		
						}
					}
				}		
			}	
		});
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton.setBounds(94, 263, 139, 23);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("绑定车辆");
		btnNewButton_1.setBackground(SystemColor.menu);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String input_carnum=textField_8.getText().trim();
				String input_name=textField_1.getText().trim();
				String input_tel=textField_3.getText().trim();
				String input_licence=textField_4.getText().trim();
				String input_carcolour=comboBox.getSelectedItem().toString();
				String input_carkind=comboBox_1.getSelectedItem().toString();
				String input_enginenum=textField_9.getText().trim();
				
				car_num=textField_8.getText().trim();
				
				//车牌号码验证规则
				String carnum_regex = "([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼]{1}(([A-HJ-Z]{1}[A-HJ-NP-Z0-9]{5})|([A-HJ-Z]{1}(([DF]{1}[A-HJ-NP-Z0-9]{1}[0-9]{4})|([0-9]{5}[DF]{1})))|([A-HJ-Z]{1}[A-D0-9]{1}[0-9]{3}警)))|([0-9]{6}使)|((([沪粤川云桂鄂陕蒙藏黑辽渝]{1}A)|鲁B|闽D|蒙E|蒙H)[0-9]{4}领)|(WJ[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼·•]{1}[0-9]{4}[TDSHBXJ0-9]{1})|([VKHBSLJNGCE]{1}[A-DJ-PR-TVY]{1}[0-9]{5})";
				Pattern carnum_pattern = Pattern.compile(carnum_regex);
				//验证车牌号码
				Matcher carnum_matcher = carnum_pattern.matcher(input_carnum);
				//布尔值表示车牌号码格式是否与规则一致
				boolean carnum_istrue=carnum_matcher.matches();
				
				//电话号码验证规则
				String tel_regex = "^[1](([3][0-9])|([4][5,7,9])|([5][^4,6,9])|([6][6])|([7][3,5,6,7,8])|([8][0-9])|([9][8,9]))[0-9]{8}$";
				Pattern tel_pattern = Pattern.compile(tel_regex);
				//验证电话号码
				Matcher tel_matcher = tel_pattern.matcher(input_tel);
				//布尔值表示电话号码格式是否与规则一致
				boolean tel_istrue=tel_matcher.matches();
				
				//发动机编号验证规则
				String enginenum_regex = "^[a-z0-9A-Z]+$";
				Pattern enginenum_pattern = Pattern.compile(enginenum_regex);
				//验证发动机编号
				Matcher enginenum_matcher = enginenum_pattern.matcher(input_enginenum);
				//布尔值表示发动机编号格式是否与规则一致
				boolean enginenum_istrue=enginenum_matcher.matches();
				
				
				if(input_carnum.isEmpty()||input_tel.isEmpty()||input_carcolour=="请选择"||input_carkind=="请选择"||input_enginenum.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "有信息未填！");
				}
				else
				{
					if(!carnum_istrue)
					{
						JOptionPane.showMessageDialog(null, "车牌号码格式不正确！");
					}
					else
					{
						
						if(!tel_istrue)
						{
							JOptionPane.showMessageDialog(null, "电话号码格式不正确！");
						}
						else
						{
							if(!enginenum_istrue)
							{
								JOptionPane.showMessageDialog(null, "发动机编号格式不正确！");
							}
							else
							{
								//初始车牌号码为空，插入信息
								if(carnum_isnull)
								{
									//检查车牌号码有无重复
									Connection conn;
									PreparedStatement ps=null;
									ResultSet rs=null;
									
									ConnectDB connect =new ConnectDB();
									conn=connect.getConnection();
									
									boolean car_isonly=true;
									
									try {
										//查询数据库
										String sql="select * from dbo.CarInformation where carnum='"+input_carnum+"'";
										ps=conn.prepareStatement(sql);
										rs=ps.executeQuery();
									
										while(rs.next()) {
											car_isonly=false;
										}

									}catch(Exception e1) {
										e1.printStackTrace();
									}
									
									connect.closeConection(ps,rs,conn);
									
									if(car_isonly) 
									{
										int result = JOptionPane.showConfirmDialog(null, "是否要修改绑定车辆信息?", "确认修改框", JOptionPane.YES_NO_OPTION);										
										//确认添加
										if (result == JOptionPane.YES_OPTION) {
										
											Connection conn_insert;
											PreparedStatement ps_insert=null;
											ResultSet rs_insert=null;
													
											ConnectDB connect_insert =new ConnectDB();
											conn_insert=connect_insert.getConnection();

											try {
												
												//插入数据库中
												String sql_insert="insert into dbo.CarInformation values ('"+input_carnum+"','"+input_name+"','"+input_tel+"','"+input_licence+"','"+input_carcolour+"','"+input_carkind+"','"+input_enginenum+ "')";
												ps_insert=conn_insert.prepareStatement(sql_insert);
												rs_insert=ps_insert.executeQuery();

											}catch(Exception e_insert) {
												e_insert.printStackTrace();
											}
													
											connect_insert.closeConection(ps_insert,rs_insert,conn_insert);
											
											JOptionPane.showMessageDialog(null, "修改成功！请重新登录系统后查看违章信息！");
										}
										//取消添加
										else if (result == JOptionPane.NO_OPTION) {
											//退出
										}
									}
									else
									{
										JOptionPane.showMessageDialog(null, "该车辆已被绑定！");	
									}	
								}
								//初始车牌号码不为空，更新信息
								else
								{
									//检查车牌号码有无重复
									Connection conn;
									PreparedStatement ps=null;
									ResultSet rs=null;
									
									ConnectDB connect =new ConnectDB();
									conn=connect.getConnection();
									
									boolean car_isonly=true;
									
									try {
										//查询数据库
										String sql="select * from dbo.CarInformation where carnum='"+input_carnum+"'";
										ps=conn.prepareStatement(sql);
										rs=ps.executeQuery();
									
										while(rs.next()) {
											car_isonly=false;
										}

									}catch(Exception e1) {
										e1.printStackTrace();
									}
									
									connect.closeConection(ps,rs,conn);
									
									if(car_isonly) 
									{
										int result = JOptionPane.showConfirmDialog(null, "是否要修改绑定车辆信息?", "确认修改框", JOptionPane.YES_NO_OPTION);										
										//确认修改
										if (result == JOptionPane.YES_OPTION) {
										
											Connection conn_update;
											PreparedStatement ps_update=null;
											ResultSet rs_update=null;
											
											ConnectDB connect_update =new ConnectDB();
											conn_update=connect_update.getConnection();

											try {
												
												//更新数据库
												String sql_update="update dbo.CarInformation set carnum='"+input_carnum+"',carowner='"+input_name+"',ownertel='"+input_tel+"',ownerlicence='"+input_licence+"',carcolour='"+input_carcolour+"',carkind='"+input_carkind+"',enginenum='"+input_enginenum+"' where ownerlicence ='"+textField_4.getText().trim()+"'";
												ps_update=conn_update.prepareStatement(sql_update);
												rs_update=ps_update.executeQuery();

											}catch(Exception e_insert) {
												e_insert.printStackTrace();
											}
													
											connect_update.closeConection(ps_update,rs_update,conn_update);
											
											JOptionPane.showMessageDialog(null, "修改成功！请重新登录系统后查看违章信息！");
											dispose();
										}
										//取消添加
										else if (result == JOptionPane.NO_OPTION) {
											//退出
										}
									}
									else
									{
										JOptionPane.showMessageDialog(null, "该车辆已被绑定！");	
									}	
									
									
								}
								
							}
						}
					}
				}
			}
	
		});
		btnNewButton_1.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_1.setBounds(94, 427, 139, 23);
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
