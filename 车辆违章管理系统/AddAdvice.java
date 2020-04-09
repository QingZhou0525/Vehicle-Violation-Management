package 车辆违章管理系统;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class AddAdvice extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAdvice frame = new AddAdvice();
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
	public AddAdvice() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddAdvice.class.getResource("/photo/caricon.png")));
		setTitle("反馈意见");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 346, 337);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AddAdvice.class.getResource("/photo/时间.png")));
		lblNewLabel.setBounds(10, 10, 54, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setToolTipText("当前时间");
		lblNewLabel_2.setFont(new Font("方正准圆简体", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(49, 20, 262, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setToolTipText("意见内容");
		lblNewLabel_3.setIcon(new ImageIcon(AddAdvice.class.getResource("/photo/内容.png")));
		lblNewLabel_3.setBounds(10, 54, 35, 45);
		contentPane.add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 63, 262, 170);
		contentPane.add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		
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
		lblNewLabel_2.setText(now_time);
		
		//导入数据库的时间
		//String now_time_detail=year+"-"+month+"-"+day+" 00:00:00.000";
		
		//确定按钮
		JButton btnNewButton_1 = new JButton("确定");
		btnNewButton_1.setBackground(SystemColor.menu);
		btnNewButton_1.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
								
				String input_text=textPane.getText().trim();
				
				if(input_text.isEmpty()) 
				{
					JOptionPane.showMessageDialog(null, "有内容未填！");
				}
				else 
				{
					int result = JOptionPane.showConfirmDialog(null, "是否要反馈此意见?", "确认框", JOptionPane.YES_NO_OPTION);										
					//确认添加
					if (result == JOptionPane.YES_OPTION) {
						
						Connection conn_insert;
						PreparedStatement ps_insert=null;
						ResultSet rs_insert=null;
								
						ConnectDB connect_insert =new ConnectDB();
						conn_insert=connect_insert.getConnection();

						try {
							//插入数据库中
							String sql="insert into dbo.UserAdvice values ('"+now_time+"','"+input_text+"')";
							ps_insert=conn_insert.prepareStatement(sql);
							rs_insert=ps_insert.executeQuery();

						}catch(Exception e_insert) {
							e_insert.printStackTrace();
						}
								
						connect_insert.closeConection(ps_insert,rs_insert,conn_insert);
						
						JOptionPane.showMessageDialog(null, "反馈成功！");
						dispose();										
					}
					//取消添加
					else if (result == JOptionPane.NO_OPTION) {
						//退出
					}		
				}
			}
		});
		btnNewButton_1.setBounds(209, 255, 102, 23);
		contentPane.add(btnNewButton_1);
		
		
		//取消按钮
		JButton btnNewButton = new JButton("取消");
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(49, 255, 102, 23);
		contentPane.add(btnNewButton);
		
		//居中显示
		this.setLocationRelativeTo(null);
						
		//设置窗体大小不变
		this.setResizable(false);
	}

}
