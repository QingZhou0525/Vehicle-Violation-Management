package 车辆违章管理系统;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;

public class AddNotice extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNotice frame = new AddNotice();
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
	public AddNotice() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddNotice.class.getResource("/photo/caricon.png")));
		setTitle("发布公告");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 346, 369);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AddNotice.class.getResource("/photo/时间.png")));
		lblNewLabel.setBounds(10, 17, 54, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AddNotice.class.getResource("/photo/标题.png")));
		lblNewLabel_1.setBounds(10, 65, 54, 28);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		textField.setToolTipText("请输入标题");
		textField.setBounds(49, 69, 262, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setFont(new Font("方正准圆简体", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(49, 23, 262, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(AddNotice.class.getResource("/photo/内容.png")));
		lblNewLabel_3.setBounds(10, 113, 29, 34);
		contentPane.add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 116, 262, 147);
		contentPane.add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		textPane.setToolTipText("请输入内容");
		textPane.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
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
				
				String input_title=textField.getText().trim();
				
				String input_text=textPane.getText().trim();
				
				if(input_title.isEmpty()||input_text.isEmpty()) 
				{
					JOptionPane.showMessageDialog(null, "有内容未填！");
				}
				else 
				{
					int result = JOptionPane.showConfirmDialog(null, "是否要发布此公告?", "确认发布框", JOptionPane.YES_NO_OPTION);										
					//确认添加
					if (result == JOptionPane.YES_OPTION) {
						
						Connection conn_insert;
						PreparedStatement ps_insert=null;
						ResultSet rs_insert=null;
								
						ConnectDB connect_insert =new ConnectDB();
						conn_insert=connect_insert.getConnection();

						try {
							//插入数据库中
							String sql="insert into dbo.Proclamation values ('"+input_title+"','"+now_time+"','"+input_text+"')";
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
		btnNewButton_1.setBounds(209, 286, 102, 23);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton_1);
		
		
		//取消按钮
		JButton btnNewButton = new JButton("取消");
		btnNewButton.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(49, 286, 102, 23);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton);
		
		//居中显示
		this.setLocationRelativeTo(null);
						
		//设置窗体大小不变
		this.setResizable(false);
	}

}
