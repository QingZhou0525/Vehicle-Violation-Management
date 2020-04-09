package 车辆违章管理系统;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.SystemColor;

public class MapDetail extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MapDetail frame = new MapDetail();
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
	public MapDetail() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MapDetail.class.getResource("/photo/caricon.png")));
		setTitle("地图代码");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 441, 395);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 414, 311);
		contentPane.add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(159, 331, 122, 23);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton);
		
		//获取选定的行
		HistoryMap historymap=new HistoryMap();
		//获取选定行的时间
		Object time=historymap.historymap_time;
				
		Connection conn;
		PreparedStatement ps=null;
		ResultSet rs=null;
				
		ConnectDB connect =new ConnectDB();
		conn=connect.getConnection();
				
		try {
			//查询数据库
			String sql="select * from dbo.map where time='"+time+"'";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
				
			while(rs.next()) {
				
				textPane.setText(toString(rs.getString("mapcode")));
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
