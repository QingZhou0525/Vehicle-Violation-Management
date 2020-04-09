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

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AdminInformation extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminInformation frame = new AdminInformation();
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
	public AdminInformation() {
		
		Login login=new Login();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminInformation.class.getResource("/photo/caricon.png")));
		setTitle("个人中心");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 251, 332);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setToolTipText("姓名，可修改");
		textField.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		textField.setBounds(68, 64, 146, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("：");
		lblNewLabel.setIcon(new ImageIcon(AdminInformation.class.getResource("/photo/name.png")));
		lblNewLabel.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel.setBounds(20, 60, 54, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("：");
		lblNewLabel_1.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_1.setIcon(new ImageIcon(AdminInformation.class.getResource("/photo/性别.png")));
		lblNewLabel_1.setBounds(20, 92, 54, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTel = new JLabel("：");
		lblTel.setIcon(new ImageIcon(AdminInformation.class.getResource("/photo/电 话.png")));
		lblTel.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblTel.setBounds(20, 136, 38, 29);
		contentPane.add(lblTel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("性别，可修改");
		comboBox.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"男", "女"}));
		comboBox.setBackground(SystemColor.window);
		comboBox.setBounds(68, 99, 146, 21);
		contentPane.add(comboBox);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("电话，可修改");
		textField_2.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		textField_2.setBounds(68, 140, 146, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("：");
		lblNewLabel_2.setIcon(new ImageIcon(AdminInformation.class.getResource("/photo/user.png")));
		lblNewLabel_2.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(20, 24, 54, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(login.get_id);
		lblNewLabel_3.setToolTipText("你的账号");
		lblNewLabel_3.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(68, 28, 105, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("：");
		lblNewLabel_4.setIcon(new ImageIcon(AdminInformation.class.getResource("/photo/邮箱.png")));
		lblNewLabel_4.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(20, 175, 54, 29);
		contentPane.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("邮箱，可修改");
		textField_3.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		textField_3.setBounds(68, 179, 146, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("密码，可修改");
		textField_4.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		textField_4.setBounds(68, 218, 146, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblPwd = new JLabel("：");
		lblPwd.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblPwd.setIcon(new ImageIcon(AdminInformation.class.getResource("/photo/密码.png")));
		lblPwd.setBounds(20, 214, 54, 29);
		contentPane.add(lblPwd);
		
		Connection conn;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		ConnectDB connect =new ConnectDB();
		conn=connect.getConnection();
		
		try {
			//查询数据库
			String sql="select * from dbo.VehicleManager where id='"+login.get_id+"'";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
		
			while(rs.next()) {
										
				textField.setText(rs.getString("name"));
				comboBox.setSelectedItem(rs.getString("sex"));
				textField_2.setText(rs.getString("tel"));
				textField_3.setText(rs.getString("email"));
				textField_4.setText(toString(rs.getString("password")));

			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		connect.closeConection(ps,rs,conn);
		

		JButton btnNewButton = new JButton("保存修改");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String name=textField.getText().trim();
				char ch_name='0';
				
				String sex=comboBox.getSelectedItem().toString().trim();
				String tel=textField_2.getText().trim();
				String email=textField_3.getText().trim();
				String password=StrToBinstr(textField_4.getText().trim());
				
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
				
				// 邮箱验证规则
				// 编译正则表达式
				String email_regex = "[0-9a-zA-Z]{1,}@[0-9a-zA-Z]{1,}\\.(com|cn)";
				Pattern email_pattern = Pattern.compile(email_regex);
				Matcher email_matcher = email_pattern.matcher(email);
				// 布尔值表示邮箱格式是否与规则一致
				boolean email_istrue = email_matcher.matches();
				
				if(name.isEmpty()||tel.isEmpty()||email.isEmpty()||password.isEmpty())
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
							if(!email_istrue)
							{
								JOptionPane.showMessageDialog(null, "邮箱格式不正确！");
							}
							else
							{
								int result = JOptionPane.showConfirmDialog(null, "是否要保存修改！", "确认修改框", JOptionPane.YES_NO_OPTION);										
								//确认添加
								if (result == JOptionPane.YES_OPTION) {
									
									//修改VehicleManager表
									Connection conn_update;
									PreparedStatement ps_update=null;
									ResultSet rs_update=null;
									
									ConnectDB connect_update =new ConnectDB();
									conn_update=connect_update.getConnection();
									
									try {
											
										String sql="update dbo.VehicleManager set name='"+name+"',sex='"+sex+ "',tel='"+tel+"',email='"+email+"',password='"+password+"'where id="+login.get_id;
										ps_update=conn_update.prepareStatement(sql);
										rs_update=ps_update.executeQuery();
											
									}catch(Exception e_update) {
										e_update.printStackTrace();
									}

									connect_update.closeConection(ps_update,rs_update,conn_update);
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
		});
		btnNewButton.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.setBounds(78, 258, 98, 23);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton);
		
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
