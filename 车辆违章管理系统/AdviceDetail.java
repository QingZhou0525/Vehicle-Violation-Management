package 车辆违章管理系统;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class AdviceDetail extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdviceDetail frame = new AdviceDetail();
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
	public AdviceDetail() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdviceDetail.class.getResource("/photo/caricon.png")));
		setTitle("意见详情");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 342, 310);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AdviceDetail.class.getResource("/photo/时间.png")));
		lblNewLabel.setBounds(10, 10, 34, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setToolTipText("意见提交时间");
		lblNewLabel_1.setFont(new Font("方正准圆简体", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(54, 20, 239, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(AdviceDetail.class.getResource("/photo/内容.png")));
		lblNewLabel_2.setBounds(10, 63, 34, 35);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 67, 258, 153);
		contentPane.add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(112, 240, 113, 23);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton);
		
		//获取选定的行
		AdviceNotice advicenotice=new AdviceNotice();
		//获取选定行的时间
		Object time=advicenotice.advice_time;
				
		Connection conn;
		PreparedStatement ps=null;
		ResultSet rs=null;
				
		ConnectDB connect =new ConnectDB();
		conn=connect.getConnection();
				
		try {
			//查询数据库
			String sql="select * from dbo.UserAdvice where time='"+time+"'";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
				
			while(rs.next()) {
						
				lblNewLabel_1.setText(time.toString());
				textPane.setText(rs.getString("text"));
			}

			}catch(Exception e) {
				e.printStackTrace();
			}
				
		connect.closeConection(ps,rs,conn);
		
		
		//居中显示
		this.setLocationRelativeTo(null);
								
		//设置窗体大小不变
		this.setResizable(false);
		
	}
}
