package 车辆违章管理系统;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class UploadMap extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UploadMap frame = new UploadMap();
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
	public UploadMap() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UploadMap.class.getResource("/photo/caricon.png")));
		setTitle("地图发布");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 356, 407);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(UploadMap.class.getResource("/photo/时间.png")));
		lblNewLabel.setBounds(10, 16, 38, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setToolTipText("时间");
		lblNewLabel_1.setFont(new Font("方正准圆简体", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(48, 24, 252, 15);
		contentPane.add(lblNewLabel_1);
		
		//获取当前年份
		Calendar date = Calendar.getInstance();
		String year = String.valueOf(date.get(Calendar.YEAR));
		String month=String.valueOf(date.get(Calendar.MONTH)+1);
		String day=String.valueOf(date.get(Calendar.DAY_OF_MONTH));
		String hour=String.valueOf(date.get(Calendar.HOUR_OF_DAY));
		String min=String.valueOf(date.get(Calendar.MINUTE));
		String second=String.valueOf(date.get(Calendar.SECOND));
				
		//标签显示时间
		String now_time=year+"-"+month+"-"+day+" "+hour+":"+min+":"+second+".000";
		lblNewLabel_1.setText(now_time);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setToolTipText("地图代码");
		lblNewLabel_2.setIcon(new ImageIcon(UploadMap.class.getResource("/photo/代码.png")));
		lblNewLabel_2.setBounds(11, 73, 31, 26);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 103, 325, 209);
		contentPane.add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("方正准圆简体", Font.PLAIN, 12));
		scrollPane.setViewportView(textPane);
		
		//确定按钮
		JButton btnNewButton = new JButton("确定");
		btnNewButton.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
				String input_mapcode=StrToBinstr(textPane.getText());
				
				if(input_mapcode.isEmpty()) 
				{
					JOptionPane.showMessageDialog(null, "有内容未填！");
				}
				else 
				{
					int result = JOptionPane.showConfirmDialog(null, "是否要发布此地图?", "确认发布框", JOptionPane.YES_NO_OPTION);										
					//确认添加
					if (result == JOptionPane.YES_OPTION) {
						
						Connection conn_insert;
						PreparedStatement ps_insert=null;
						ResultSet rs_insert=null;
								
						ConnectDB connect_insert =new ConnectDB();
						conn_insert=connect_insert.getConnection();

						try {
							//插入数据库中
							String sql="insert into dbo.map values ('"+now_time+"','"+input_mapcode+"')";
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
				
		});
		btnNewButton.setBounds(229, 335, 108, 23);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton);
		
		//取消按钮
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_1.setBackground(SystemColor.menu);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(12, 335, 108, 23);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("请复制地图代码");
		lblNewLabel_3.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(48, 78, 175, 15);
		contentPane.add(lblNewLabel_3);
		
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
