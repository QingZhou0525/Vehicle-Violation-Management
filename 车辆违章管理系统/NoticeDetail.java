package 车辆违章管理系统;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;

public class NoticeDetail extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NoticeDetail frame = new NoticeDetail();
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
	public NoticeDetail() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(NoticeDetail.class.getResource("/photo/caricon.png")));
		setTitle("公告详情");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 371, 353);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(NoticeDetail.class.getResource("/photo/时间.png")));
		lblNewLabel.setBounds(12, 20, 54, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("time");
		lblNewLabel_1.setToolTipText("公告发布时间");
		lblNewLabel_1.setFont(new Font("方正准圆简体", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(53, 30, 259, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(NoticeDetail.class.getResource("/photo/标题.png")));
		lblNewLabel_2.setBounds(10, 64, 54, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("title");
		lblNewLabel_3.setToolTipText("公告标题");
		lblNewLabel_3.setFont(new Font("方正准圆简体", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(53, 73, 259, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(NoticeDetail.class.getResource("/photo/内容.png")));
		lblNewLabel_4.setBounds(12, 112, 54, 34);
		contentPane.add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 115, 291, 146);
		contentPane.add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);
		
		//确定按钮
		JButton btnNewButton = new JButton("确定");
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setBounds(120, 279, 126, 23);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton);
		
		
		//获取选定的行
		AdviceNotice advicenotice=new AdviceNotice();
		//获取选定行的时间
		Object time=advicenotice.notice_time;
		
		Connection conn;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		ConnectDB connect =new ConnectDB();
		conn=connect.getConnection();
		
		try {
			//查询数据库
			String sql="select * from dbo.Proclamation where time='"+time+"'";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
		
			while(rs.next()) {
				
				lblNewLabel_1.setText(time.toString());
				lblNewLabel_3.setText(rs.getString("title"));
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
