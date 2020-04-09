package 车辆违章管理系统;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.SystemColor;
import java.awt.Font;

public class MapMake extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public MapMake() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		//获取当前时间
		Calendar date = Calendar.getInstance();
		String year = String.valueOf(date.get(Calendar.YEAR));
		String month=String.valueOf(date.get(Calendar.MONTH)+1);
				
		int int_month1=0;
		int int_month2 = Integer.parseInt(month);
		int int_year1=0;
		int int_year2=0;
				
		if(int_month2==1) {
			int_month1=12;
			int_year2=Integer.parseInt(year);
			int_year1=int_year2-1;
		}else {
			int_month1=int_month2-1;
			int_year2=Integer.parseInt(year);
			int_year1=Integer.parseInt(year);
		}
					
		String time1=String.valueOf(int_year1)+"-"+String.valueOf(int_month1)+"-01 00:00:00.000";
		String time2=String.valueOf(int_year2)+"-"+String.valueOf(int_month2)+"-01 00:00:00.000";
		
		
		JButton btnNewButton = new JButton("地图绘制");
		btnNewButton.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton.setBackground(SystemColor.controlLtHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String url="https://lbs.amap.com/console/show/tools";
				
				try {
					Runtime.getRuntime().exec("cmd.exe /c start "+url);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(22, 84, 110, 23);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("查看地图");
		btnNewButton_1.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_1.setBackground(SystemColor.controlLtHighlight);
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
		btnNewButton_1.setBounds(22, 181, 110, 23);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("地图发布");
		btnNewButton_2.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_2.setBackground(SystemColor.controlLtHighlight);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UploadMap map=new UploadMap();
				map.show();
				
			}
		});
		btnNewButton_2.setBounds(22, 117, 110, 23);
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel(String.valueOf(int_year1)+"年"+String.valueOf(int_month1)+"月"+"违章事件多发地点：");
		lblNewLabel.setFont(new Font("方正准圆简体", Font.PLAIN, 15));
		lblNewLabel.setBounds(153, 10, 581, 15);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(153, 35, 607, 316);
		add(scrollPane);
		
		
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		Vector<String> columnName = new Vector<String>();
		Vector<Vector<Object>> dataVector = new Vector<Vector<Object>>(); 
		
		columnName.add("区域");
		columnName.add("街道");
		columnName.add("次数");
		columnName.add("违章地点经度");
		columnName.add("违章地点纬度");
		
		Connection conn;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		ConnectDB connect =new ConnectDB();
		conn=connect.getConnection();
		
		try {
			//查询数据库
			String sql="select dbo.ViolationInformation.district,dbo.ViolationInformation.street,COUNT(dbo.ViolationInformation.street) as 次数,dbo.Nanjing.longitude,dbo.Nanjing.latitude from dbo.ViolationInformation left join dbo.Nanjing on dbo.ViolationInformation.district=dbo.Nanjing.district and dbo.ViolationInformation.street=dbo.Nanjing.street where time >='"+time1+"' and time <='"+time2+"' group by dbo.ViolationInformation.district,dbo.ViolationInformation.street,dbo.Nanjing.longitude,dbo.Nanjing.latitude order by 次数 desc";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
		
			while(rs.next()) {
				Vector<Object> vec = new Vector<Object>();
				for(int i=1;i<=5;i++)
				{
					vec.add(rs.getObject(i));
				}
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
		table.getTableHeader().setReorderingAllowed(false);
		
		//设置各列长度
		int columncount = this.table.getColumnCount(); 
		this.table.getColumnModel().getColumn(0).setPreferredWidth(100); 
		this.table.getColumnModel().getColumn(1).setPreferredWidth(110); 
		this.table.getColumnModel().getColumn(2).setPreferredWidth(100); 
		this.table.getColumnModel().getColumn(3).setPreferredWidth(150); 
		this.table.getColumnModel().getColumn(4).setPreferredWidth(150); 
 
		//居中显示
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, r);
		

		JButton btnNewButton_3 = new JButton("历史地图");
		btnNewButton_3.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_3.setBackground(SystemColor.controlLtHighlight);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HistoryMap historymap=new HistoryMap();
				historymap.show();
			}
		});
		btnNewButton_3.setBounds(22, 35, 110, 23);
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("刷新");
		btnNewButton_4.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_4.setBackground(SystemColor.controlLtHighlight);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Vector<String> columnName1 = new Vector<String>();
				Vector<Vector<Object>> dataVector1 = new Vector<Vector<Object>>(); 
				
				columnName1.add("区域");
				columnName1.add("街道");
				columnName1.add("次数");
				columnName1.add("违章地点经度");
				columnName1.add("违章地点纬度");
				
				Connection conn1;
				PreparedStatement ps1=null;
				ResultSet rs1=null;
				
				ConnectDB connect1 =new ConnectDB();
				conn1=connect1.getConnection();
				
				try {
					//查询数据库
					String sql1="select dbo.ViolationInformation.district,dbo.ViolationInformation.street,COUNT(dbo.ViolationInformation.street) as 次数,dbo.Nanjing.longitude,dbo.Nanjing.latitude from dbo.ViolationInformation left join dbo.Nanjing on dbo.ViolationInformation.district=dbo.Nanjing.district and dbo.ViolationInformation.street=dbo.Nanjing.street where time >='"+time1+"' and time <='"+time2+"' group by dbo.ViolationInformation.district,dbo.ViolationInformation.street,dbo.Nanjing.longitude,dbo.Nanjing.latitude order by 次数 desc";
					ps1=conn1.prepareStatement(sql1);
					rs1=ps1.executeQuery();
				
					while(rs1.next()) {
						Vector<Object> vec1 = new Vector<Object>();
						for(int i=1;i<=5;i++)
						{
							vec1.add(rs1.getObject(i));
						}
						dataVector1.add(vec1);
					}

				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
				connect1.closeConection(ps1,rs1,conn1);
				
				//声明table的model
				DefaultTableModel  tmhavesold1;
				tmhavesold1 = new DefaultTableModel() {
					public boolean isCellEditable(int row,int column){  
						return false;
					}  
				};
				tmhavesold1.setDataVector(dataVector1, columnName1);
				
				table.setModel(tmhavesold1);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.getTableHeader().setReorderingAllowed(false);
				
				//设置各列长度
				table.getColumnModel().getColumn(0).setPreferredWidth(100); 
				table.getColumnModel().getColumn(1).setPreferredWidth(110); 
				table.getColumnModel().getColumn(2).setPreferredWidth(100); 
				table.getColumnModel().getColumn(3).setPreferredWidth(150); 
				table.getColumnModel().getColumn(4).setPreferredWidth(150); 
		 
				//居中显示
				DefaultTableCellRenderer r = new DefaultTableCellRenderer();
				r.setHorizontalAlignment(JLabel.CENTER);
				table.setDefaultRenderer(Object.class, r);
			}
		});
		btnNewButton_4.setBounds(22, 236, 110, 23);
		btnNewButton_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("修改地图");
		btnNewButton_5.setBackground(SystemColor.controlLtHighlight);
		btnNewButton_5.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				try {
					Runtime.getRuntime().exec("C:\\WINDOWS\\system32\\notepad.exe C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\MapWeb\\HotPointMap.html");
				} catch (IOException e1) {
					System.out.println("无法找到  C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\MapWeb\\HotPointMap.html 文件！");
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		btnNewButton_5.setBounds(22, 148, 110, 23);
		add(btnNewButton_5);

	}
}
