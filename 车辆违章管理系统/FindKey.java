package 车辆违章管理系统;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class FindKey extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	static FindKey frame = new FindKey();
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
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
	public FindKey() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FindKey.class.getResource("/photo/caricon.png")));
		setFont(new Font("方正准圆简体", Font.PLAIN, 18));
		setTitle("找回密码");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 254, 237);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("：");
		lblNewLabel.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel.setIcon(new ImageIcon(FindKey.class.getResource("/photo/user.png")));
		lblNewLabel.setBounds(24, 54, 47, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("：");
		lblNewLabel_1.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_1.setIcon(new ImageIcon(FindKey.class.getResource("/photo/驾驶证.png")));
		lblNewLabel_1.setBounds(24, 85, 47, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("：");
		lblNewLabel_2.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_2.setIcon(new ImageIcon(FindKey.class.getResource("/photo/身份证.png")));
		lblNewLabel_2.setBounds(24, 126, 53, 26);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		textField.setToolTipText("账号");
		textField.setBackground(Color.WHITE);
		textField.setBounds(68, 54, 150, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		textField_1.setToolTipText("驾驶证号");
		textField_1.setBounds(68, 90, 150, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		textField_2.setToolTipText("身份证号");
		textField_2.setBounds(68, 129, 150, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("查询密码");
		btnNewButton.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//获取输入的id
				String text_id=textField.getText().trim();
				char ch_id='0';
				//获取驾驶证号值
				String text_licence = textField_1.getText().trim();
				char ch_licence='0';
				//获取身份证号值
				String text_identity = textField_2.getText().trim();
				char ch_identity='0';
				
				//判断id是否为纯数字
				Pattern id_pattern = Pattern.compile("[0-9]*");
		        Matcher id_matcher = id_pattern.matcher(text_id);
		        boolean id_istrue=id_matcher.matches();
				
				//驾驶证号码和身份证号码验证规则
				String licence_identity_regex = "\\d{15}|\\d{17}[\\dxX]";
				Pattern licence_identity_pattern = Pattern.compile(licence_identity_regex);
				//验证驾驶证号码
				Matcher licence_matcher = licence_identity_pattern.matcher(text_licence);
				//验证身份证号码
				Matcher identity_matcher = licence_identity_pattern.matcher(text_identity);
				// 布尔值表示驾驶证号码格式是否与规则一致
				boolean licence_istrue=licence_matcher.matches();
				// 布尔值表示身份证号码格式是否与规则一致
				boolean identity_istrue=identity_matcher.matches();
				
				if(text_id.isEmpty()||text_licence.isEmpty()||text_identity.isEmpty()) 
				{
					JOptionPane.showMessageDialog(null, "有信息未填！");
				}
				else 
				{
					if(!id_istrue)
					{
						JOptionPane.showMessageDialog(null, "账号格式不正确！");
					}
					else
					{
						if(!licence_istrue)
						{
							JOptionPane.showMessageDialog(null, "驾驶证号格式不正确！");
						}
						else
						{
							if(!identity_istrue)
							{
								JOptionPane.showMessageDialog(null, "身份证号格式不正确！");
							}
							else
							{
								String pwd=null;
								boolean find=false;
								
								Connection conn;
								PreparedStatement ps=null;
								ResultSet rs=null;
								
								ConnectDB connect =new ConnectDB();
								conn=connect.getConnection();
								
								try {
									//查询数据库
									String sql="select * from dbo.Users where id='"+text_id+"' and licence = '"+text_licence+"' and identification ='"+text_identity+"'";
									ps=conn.prepareStatement(sql);
									rs=ps.executeQuery();
								
									while(rs.next()) {
										find=true;
										pwd=FindKey.toString(rs.getString("password").trim());
									}
								}catch(Exception e1) {
									e1.printStackTrace();
								}
								
								connect.closeConection(ps,rs,conn);
								
								if(find) {
									JOptionPane.showMessageDialog(null, "您的密码是："+pwd);
								}else {
									JOptionPane.showMessageDialog(null, "无查找数据！请检查输入信息是否有误！");
								}
								
							}
						}
					}
				}
				
			}
		});
		btnNewButton.setBounds(68, 164, 120, 23);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("请依次输入账号、驾驶证号、身份证号");
		lblNewLabel_3.setFont(new Font("方正准圆简体", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 22, 247, 15);
		contentPane.add(lblNewLabel_3);
		
		//居中显示
		this.setLocationRelativeTo(null);
				
		//设置窗体大小不变
		this.setResizable(false);
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
