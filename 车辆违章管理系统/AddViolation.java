package 车辆违章管理系统;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

public class AddViolation extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JComboBox comboBox_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddViolation frame = new AddViolation();
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
	public AddViolation() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddViolation.class.getResource("/photo/caricon.png")));
		setTitle("添加违章信息");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 415, 313);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("：");
		lblNewLabel.setToolTipText("请选择违章时间");
		lblNewLabel.setIcon(new ImageIcon(AddViolation.class.getResource("/photo/日 历.png")));
		lblNewLabel.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 19, 50, 26);
		contentPane.add(lblNewLabel);
		
		//获取当前年份
		Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));
        
        int year_int=Integer.parseInt(year);
        
        year_int--;
        
        String last_year=Integer.toString(year_int);
        
		JComboBox comboBox_9;
		comboBox_9 = new JComboBox();
		comboBox_9.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		comboBox_9.setBackground(SystemColor.window);
		comboBox_9.setModel(new DefaultComboBoxModel(new String[] {year,last_year}));
		comboBox_9.setBounds(54, 22, 58, 21);
		contentPane.add(comboBox_9);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		comboBox.setBackground(SystemColor.window);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBox.setBounds(140, 22, 43, 21);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("年");
		lblNewLabel_1.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(119, 25, 21, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("月");
		lblNewLabel_2.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(190, 25, 21, 15);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		comboBox_1.setBackground(SystemColor.window);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_1.setBounds(213, 22, 43, 21);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_3 = new JLabel("日");
		lblNewLabel_3.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(264, 25, 21, 15);
		contentPane.add(lblNewLabel_3);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		comboBox_2.setBackground(SystemColor.window);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox_2.setBounds(286, 22, 43, 21);
		contentPane.add(comboBox_2);
		
		JLabel lblNewLabel_4 = new JLabel("：");
		lblNewLabel_4.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(333, 23, 21, 15);
		contentPane.add(lblNewLabel_4);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		comboBox_3.setBackground(SystemColor.window);
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		comboBox_3.setBounds(346, 22, 48, 21);
		contentPane.add(comboBox_3);
		
		JLabel lblNewLabel_5 = new JLabel("：");
		lblNewLabel_5.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_5.setIcon(new ImageIcon(AddViolation.class.getResource("/photo/车牌号.png")));
		lblNewLabel_5.setBounds(10, 62, 50, 26);
		contentPane.add(lblNewLabel_5);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("请输入车牌号");
		textField_1.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		textField_1.setBounds(54, 65, 110, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("：");
		lblNewLabel_6.setToolTipText("请选择车辆颜色");
		lblNewLabel_6.setIcon(new ImageIcon(AddViolation.class.getResource("/photo/车辆颜色.png")));
		lblNewLabel_6.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(264, 59, 50, 33);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("：");
		lblNewLabel_7.setToolTipText("请选择违章地点");
		lblNewLabel_7.setIcon(new ImageIcon(AddViolation.class.getResource("/photo/地点.png")));
		lblNewLabel_7.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(10, 106, 50, 30);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("：");
		lblNewLabel_8.setToolTipText("请选择违章事件");
		lblNewLabel_8.setIcon(new ImageIcon(AddViolation.class.getResource("/photo/事件.png")));
		lblNewLabel_8.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(11, 183, 50, 39);
		contentPane.add(lblNewLabel_8);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		comboBox_4.setBackground(SystemColor.window);
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"请选择", "违章停车", "未按照交通信号灯行驶", "超速行驶", "行驶过程中压线行驶", "人行横道未让行人", "行驶过程未系安全带"}));
		comboBox_4.setBounds(54, 192, 342, 21);
		contentPane.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		comboBox_5.setBackground(SystemColor.window);
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"南京市"}));
		comboBox_5.setBounds(54, 111, 77, 21);
		contentPane.add(comboBox_5);
		
		//浦口区街道
		DefaultComboBoxModel model_1 = new DefaultComboBoxModel(new String[] {"请选择","江浦街道","桥林街道","汤泉街道","盘城街道","沿江街道","泰山街道","顶山街道"});
		//玄武区街道
		DefaultComboBoxModel model_2 = new DefaultComboBoxModel(new String[] {"请选择","梅园新村街道","新街口街道","兰园街道","玄武门街道","后宰门街道","锁金村街道","孝陵卫街道","玄武湖街道","红山街道","卫岗街道"});
		//秦淮区街道
		DefaultComboBoxModel model_3 = new DefaultComboBoxModel(new String[] {"请选择","秦虹街道","夫子庙街道","红花街道","双塘街道","中华门街道","五老村街道","洪武路街道","瑞金路街道","月牙湖街道","光华路街道","朝天宫街道"});
		//江宁区街道
		DefaultComboBoxModel model_4 = new DefaultComboBoxModel(new String[] {"请选择","东山街道","秣陵街道","汤山街道","淳化街道","禄口街道","江宁街道","谷里街道"});
		//建邺区街道
		DefaultComboBoxModel model_5 = new DefaultComboBoxModel(new String[] {"请选择","滨湖街道","南湖街道","南苑街道","兴隆街道","双闸街道","沙洲街道","江心洲街道"});
		//鼓楼区街道
		DefaultComboBoxModel model_6 = new DefaultComboBoxModel(new String[] {"请选择","华侨路街道","宁海路街道","湖南路街道","中央门街道","挹江门街道","江东街道","莫愁街道"});
		//雨花台区街道
		DefaultComboBoxModel model_7 = new DefaultComboBoxModel(new String[] {"请选择","西善桥街道","板桥街道","铁心桥街道","赛虹桥街道","梅山街道","雨花街道"});
		
		JLabel longitude_label = new JLabel("00.0000000");
		longitude_label.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		longitude_label.setBounds(107, 154, 89, 15);
		contentPane.add(longitude_label);
		
		JLabel latitude_label = new JLabel("000.0000000");
		latitude_label.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		latitude_label.setBounds(264, 154, 109, 15);
		contentPane.add(latitude_label);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		comboBox_6.setBackground(SystemColor.window);
		
		//街道选择，获取经纬度
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		comboBox_7.setBackground(SystemColor.window);
		comboBox_7.setModel(new DefaultComboBoxModel(new String[] {"请选择"}));
		comboBox_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object district=comboBox_6.getSelectedItem();
				Object street=comboBox_7.getSelectedItem();

				Connection conn;
				PreparedStatement ps=null;
				ResultSet rs=null;
				
				ConnectDB connect =new ConnectDB();
				conn=connect.getConnection();
				
				BigDecimal longitude = null;
				BigDecimal latitude = null;
				
				try {
					//查询数据库
					String sql="select * from dbo.Nanjing where district='"+district.toString().trim()+"'and street='"+street.toString().trim()+"'";
					ps=conn.prepareStatement(sql);
					rs=ps.executeQuery();
					
					while(rs.next()) {
						longitude=rs.getBigDecimal("longitude");
						latitude=rs.getBigDecimal("latitude");
					}
					
					
					longitude_label.setText(longitude.toPlainString());
					latitude_label.setText(latitude.toPlainString());
					

				}catch(Exception e_choose) {
					e_choose.printStackTrace();
				}
				
				connect.closeConection(ps,rs,conn);	
			}
		});
		comboBox_7.setBounds(264, 111, 130, 21);
		contentPane.add(comboBox_7);
		
		
		comboBox_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(comboBox_6.getSelectedItem()=="浦口区") {
					comboBox_7.setModel(model_1);
				}
				if(comboBox_6.getSelectedItem()=="玄武区")
				{
					comboBox_7.setModel(model_2);
				}
				if(comboBox_6.getSelectedItem()=="秦淮区") {
					comboBox_7.setModel(model_3);
				}
				if(comboBox_6.getSelectedItem()=="江宁区") {
					comboBox_7.setModel(model_4);
				}
				if(comboBox_6.getSelectedItem()=="建邺区") {
					comboBox_7.setModel(model_5);
				}
				if(comboBox_6.getSelectedItem()=="鼓楼区") {
					comboBox_7.setModel(model_6);
				}
				if(comboBox_6.getSelectedItem()=="雨花台区") {
					comboBox_7.setModel(model_7);
				}
				if(comboBox_6.getSelectedItem()=="请选择") {
					comboBox_7.setModel(new DefaultComboBoxModel(new String[] {"请选择"}));
				}
			}
		});
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"请选择", "玄武区", "浦口区", "秦淮区", "江宁区", "建邺区", "鼓楼区", "雨花台区"}));
		comboBox_6.setBounds(140, 111, 116, 21);
		contentPane.add(comboBox_6);
		
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		comboBox_8.setBackground(SystemColor.window);
		comboBox_8.setModel(new DefaultComboBoxModel(new String[] {"请选择", "黑色", "白色", "红色", "蓝色", "黄色", "绿色", "橙色", "银色", "灰色", "紫色", "粉色"}));
		comboBox_8.setBounds(307, 65, 89, 21);
		contentPane.add(comboBox_8);
		
		JLabel lblNewLabel_9 = new JLabel("经  度：");
		lblNewLabel_9.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(54, 154, 66, 15);
		contentPane.add(lblNewLabel_9);
				
		JLabel lblNewLabel_11 = new JLabel("纬  度：");
		lblNewLabel_11.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_11.setBounds(213, 154, 58, 15);
		contentPane.add(lblNewLabel_11);
		
		//确定按钮
		JButton btnNewButton = new JButton("确定");
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String input_date;

				//获取输入日期
				String input_year=comboBox_9.getSelectedItem().toString().trim();
				String input_month=comboBox.getSelectedItem().toString().trim();
				String input_day=comboBox_1.getSelectedItem().toString().trim();
				String input_hour=comboBox_2.getSelectedItem().toString().trim();
				String input_min=comboBox_3.getSelectedItem().toString().trim();
				
				//格式化输入的日期
				input_date=input_year+"-"+input_month+"-"+input_day+" "+input_hour+":"+input_min+":00.000";
				
				//获取输入的车牌号码
				String input_carnum=textField_1.getText().trim();
				
				//车牌号码验证规则
				String carnum_regex = "([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼]{1}(([A-HJ-Z]{1}[A-HJ-NP-Z0-9]{5})|([A-HJ-Z]{1}(([DF]{1}[A-HJ-NP-Z0-9]{1}[0-9]{4})|([0-9]{5}[DF]{1})))|([A-HJ-Z]{1}[A-D0-9]{1}[0-9]{3}警)))|([0-9]{6}使)|((([沪粤川云桂鄂陕蒙藏黑辽渝]{1}A)|鲁B|闽D|蒙E|蒙H)[0-9]{4}领)|(WJ[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼·•]{1}[0-9]{4}[TDSHBXJ0-9]{1})|([VKHBSLJNGCE]{1}[A-DJ-PR-TVY]{1}[0-9]{5})";
				Pattern carnum_pattern = Pattern.compile(carnum_regex);
				//验证车牌号码
				Matcher carnum_matcher = carnum_pattern.matcher(input_carnum);
				//布尔值表示车牌号码格式是否与规则一致
				boolean carnum_istrue=carnum_matcher.matches();
				
				//获取输入的车辆颜色
				String input_carcolour=comboBox_8.getSelectedItem().toString().trim();
				
				//获取输入的区
				String input_district=comboBox_6.getSelectedItem().toString().trim();
				
				//获取输入的街道
				String input_street=comboBox_7.getSelectedItem().toString().trim();
				
				//获取输入的经纬度
				String input_longitude = longitude_label.getText();
				String input_latitude=latitude_label.getText();
				
				//获取输入的违章事件
				String input_thing=comboBox_4.getSelectedItem().toString().trim();
				
				if(input_carnum.isEmpty()||comboBox_6.getSelectedItem().toString().trim()=="请选择"||comboBox_7.getSelectedItem().toString().trim()=="请选择"||comboBox_4.getSelectedItem().toString().trim()=="请选择"||comboBox_8.getSelectedItem().toString().trim()=="请选择")
				{
					JOptionPane.showMessageDialog(null, "有信息未填！");
				}
				else
				{
					if(!carnum_istrue)
					{
						JOptionPane.showMessageDialog(null, "车牌号码格式错误！");
					}
					else
					{
						int result = JOptionPane.showConfirmDialog(null, "是否要添加此违章信息?", "确认添加框", JOptionPane.YES_NO_OPTION);										
						//确认添加
						if (result == JOptionPane.YES_OPTION) {
						
							Connection conn_insert;
							PreparedStatement ps_insert=null;
							ResultSet rs_insert=null;
									
							ConnectDB connect_insert =new ConnectDB();
							conn_insert=connect_insert.getConnection();

							try {
								//插入数据库中
								String sql="insert into dbo.ViolationInformation values ('"+input_carnum+"','"+input_carcolour+"','"+input_district+"','"+input_street+"','"+input_date+"','"+input_thing+"',"+input_longitude+",'"+input_latitude+ "')";
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
		});
		btnNewButton.setBounds(235, 237, 110, 23);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton);
		
		//取消按钮
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.setBackground(SystemColor.menu);
		btnNewButton_1.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(73, 237, 110, 23);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton_1);
		
		//居中显示
		this.setLocationRelativeTo(null);
				
		//设置窗体大小不变
		this.setResizable(false);
		
	}
}
