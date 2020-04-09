package 车辆违章管理系统;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.SystemColor;
import java.awt.Font;

public class UserMap extends JPanel {
	private JTable table;
	static int historymap_rownum;
	static Object historymap_time;

	/**
	 * Create the panel.
	 */
	public UserMap() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(126, 0, 634, 352);
		add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

		Vector<String> columnName = new Vector<String>();
		Vector<Vector<Object>> dataVector = new Vector<Vector<Object>>(); 
		
		columnName.add("发布时间");

		Connection conn;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		ConnectDB connect =new ConnectDB();
		conn=connect.getConnection();
		
		try {
			//查询数据库
			String sql="select * from dbo.map order by time desc";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
		
			while(rs.next()) {
				Vector<Object> vec = new Vector<Object>();
				int i=1;
				
				vec.add(rs.getObject(i));
				
				dataVector.add(vec);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		connect.closeConection(ps,rs,conn);
		
		//声明table的model
		DefaultTableModel  tmhavesold;
		tmhavesold = new DefaultTableModel() {
			public boolean isCellEditable(int row,int column){  
				return false;
			}  
		};
		tmhavesold.setDataVector(dataVector, columnName);
		
		table.setModel(tmhavesold);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JButton btnNewButton = new JButton("地图详情");
		btnNewButton.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				historymap_rownum=table.getSelectedRow();
				historymap_time=table.getValueAt(historymap_rownum, 0);
				
				UserMapDetail usermapdetail=new UserMapDetail();
				usermapdetail.show();
				
				
			}
		});
		btnNewButton.setBounds(10, 21, 102, 23);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("打开地图");
		btnNewButton_1.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_1.setBackground(SystemColor.menu);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String url="http://localhost:8080/MapWeb/HotPointMap.html";
				
				try {
					Runtime.getRuntime().exec("cmd.exe /c start "+url);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(10, 87, 102, 23);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("修改地图");
		btnNewButton_2.setBackground(SystemColor.menu);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Runtime.getRuntime().exec("C:\\WINDOWS\\system32\\notepad.exe C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\MapWeb\\HotPointMap.html");
				} catch (IOException e1) {
					System.out.println("无法找到  C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\MapWeb\\HotPointMap.html 文件！");
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_2.setBounds(10, 54, 102, 23);
		add(btnNewButton_2);
		
		table.getTableHeader().setReorderingAllowed(false);
		
		//设置各列长度
		int columncount = this.table.getColumnCount(); 
		this.table.getColumnModel().getColumn(0).setPreferredWidth(634); 

		
		//居中显示
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, r);
		

	}
}
