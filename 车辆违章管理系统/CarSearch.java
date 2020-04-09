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
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class CarSearch extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarSearch frame = new CarSearch();
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
	public CarSearch() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CarSearch.class.getResource("/photo/caricon.png")));
		setTitle("查询车辆信息");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 277, 298);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CarSearch.class.getResource("/photo/车牌号.png")));
		lblNewLabel.setBounds(10, 44, 36, 23);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setToolTipText("请输入车牌号");
		textField.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		textField.setBounds(56, 44, 110, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("：");
		lblNewLabel_1.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_1.setIcon(new ImageIcon(CarSearch.class.getResource("/photo/车辆颜色.png")));
		lblNewLabel_1.setBounds(139, 165, 46, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("：");
		lblNewLabel_2.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_2.setIcon(new ImageIcon(CarSearch.class.getResource("/photo/name.png")));
		lblNewLabel_2.setBounds(10, 85, 47, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("：");
		lblNewLabel_3.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_3.setIcon(new ImageIcon(CarSearch.class.getResource("/photo/电 话.png")));
		lblNewLabel_3.setBounds(139, 89, 47, 23);
		contentPane.add(lblNewLabel_3);
		
		JLabel ownername_label = new JLabel("请查询");
		ownername_label.setToolTipText("车主姓名");
		ownername_label.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		ownername_label.setBounds(56, 93, 73, 15);
		contentPane.add(ownername_label);
		
		JLabel ownertel_label = new JLabel("请查询");
		ownertel_label.setToolTipText("车主电话");
		ownertel_label.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		ownertel_label.setBounds(187, 93, 81, 15);
		contentPane.add(ownertel_label);
		
		JLabel lblNewLabel_6 = new JLabel("：");
		lblNewLabel_6.setIcon(new ImageIcon(CarSearch.class.getResource("/photo/驾驶证.png")));
		lblNewLabel_6.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(10, 126, 54, 27);
		contentPane.add(lblNewLabel_6);
		
		JLabel ownerlicence_label = new JLabel("请查询");
		ownerlicence_label.setToolTipText("车主驾驶证号");
		ownerlicence_label.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		ownerlicence_label.setBounds(56, 132, 187, 15);
		contentPane.add(ownerlicence_label);
		
		JLabel carcolour_label = new JLabel("请查询");
		carcolour_label.setToolTipText("车辆颜色");
		carcolour_label.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		carcolour_label.setBounds(187, 177, 70, 15);
		contentPane.add(carcolour_label);
		
		JLabel lblNewLabel_9 = new JLabel("：");
		lblNewLabel_9.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_9.setIcon(new ImageIcon(CarSearch.class.getResource("/photo/车型.png")));
		lblNewLabel_9.setBounds(10, 171, 46, 26);
		contentPane.add(lblNewLabel_9);
		
		JLabel carkind_label = new JLabel("请查询");
		carkind_label.setToolTipText("车型");
		carkind_label.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		carkind_label.setBounds(56, 177, 73, 15);
		contentPane.add(carkind_label);
		
		JLabel lblNewLabel_11 = new JLabel("：");
		lblNewLabel_11.setIcon(new ImageIcon(CarSearch.class.getResource("/photo/发动机码.png")));
		lblNewLabel_11.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_11.setBounds(10, 214, 46, 31);
		contentPane.add(lblNewLabel_11);
		
		JLabel engine_label = new JLabel("请查询");
		engine_label.setToolTipText("发动机编号");
		engine_label.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		engine_label.setBounds(56, 223, 155, 15);
		contentPane.add(engine_label);
		
		//查询按钮
		JButton btnNewButton = new JButton("查询");
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//获取输入的车牌号码
				String input_carnum=textField.getText().trim();
				
				//车牌号码验证规则
				String carnum_regex = "([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼]{1}(([A-HJ-Z]{1}[A-HJ-NP-Z0-9]{5})|([A-HJ-Z]{1}(([DF]{1}[A-HJ-NP-Z0-9]{1}[0-9]{4})|([0-9]{5}[DF]{1})))|([A-HJ-Z]{1}[A-D0-9]{1}[0-9]{3}警)))|([0-9]{6}使)|((([沪粤川云桂鄂陕蒙藏黑辽渝]{1}A)|鲁B|闽D|蒙E|蒙H)[0-9]{4}领)|(WJ[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼·•]{1}[0-9]{4}[TDSHBXJ0-9]{1})|([VKHBSLJNGCE]{1}[A-DJ-PR-TVY]{1}[0-9]{5})";
				Pattern carnum_pattern = Pattern.compile(carnum_regex);
				//验证车牌号码
				Matcher carnum_matcher = carnum_pattern.matcher(input_carnum);
				//布尔值表示车牌号码格式是否与规则一致
				boolean carnum_istrue=carnum_matcher.matches();
				
				if(input_carnum.isEmpty()||!carnum_istrue)
				{
					JOptionPane.showMessageDialog(null, "请输入正确的车牌号码！");
				}
				else
				{
					Connection conn_search;
					PreparedStatement ps_search=null;
					ResultSet rs_search=null;
					
					ConnectDB connect_search =new ConnectDB();
					conn_search=connect_search.getConnection();
					
					String ownername;
					String ownertel;
					String ownerlicence;
					String carcolour;
					String carkind;
					String engine;
					
					try {
						//查询数据库
						String sql="select * from dbo.CarInformation where carnum='"+input_carnum+"'";
						ps_search=conn_search.prepareStatement(sql);
						rs_search=ps_search.executeQuery();
					
						if(rs_search.next()) {
							ownername=rs_search.getString("carowner");
							ownertel=rs_search.getString("ownertel");
							ownerlicence=rs_search.getString("ownerlicence");
							carcolour=rs_search.getString("carcolour");
							carkind=rs_search.getString("carkind");
							engine=rs_search.getString("enginenum");
							
							ownername_label.setText(ownername);
							ownertel_label.setText(ownertel);
							ownerlicence_label.setText(ownerlicence);
							carcolour_label.setText(carcolour);
							carkind_label.setText(carkind);
							engine_label.setText(engine);
							
						}
						else
						{
							ownername_label.setText("请查询");
							ownertel_label.setText("请查询");
							ownerlicence_label.setText("请查询");
							carcolour_label.setText("请查询");
							carkind_label.setText("请查询");
							engine_label.setText("请查询");
							JOptionPane.showMessageDialog(null, "无此车辆信息！");
						}
						
					}catch(Exception e_search) {
						e_search.printStackTrace();
					}
					
					connect_search.closeConection(ps_search,rs_search,conn_search);
				}
				
			}
		});
		btnNewButton.setBounds(176, 43, 83, 23);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("请输入车牌号码：");
		lblNewLabel_4.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 17, 131, 15);
		contentPane.add(lblNewLabel_4);
		
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
}
