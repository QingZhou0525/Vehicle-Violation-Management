package 车辆违章管理系统;

import javax.swing.JPanel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.SystemColor;
import java.awt.Font;

public class AdviceNotice extends JPanel {
	JTable table1;
	private JTable table2;
	static int notice_rownum;
	static Object notice_time;
	static int advice_rownum;
	static Object advice_time;
	
	/**
	 * Create the panel.
	 */
	public AdviceNotice() {
		setBackground(Color.WHITE);
		setLayout(null);

		//公告
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(126, 35, 634, 137);
		add(scrollPane1);
		
		//公告表
		table1 = new JTable();
		table1.setBackground(Color.WHITE);
		table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane1.setViewportView(table1);
		
		Vector<String> columnName = new Vector<String>();
		Vector<Vector<Object>> dataVector = new Vector<Vector<Object>>(); 
		
		columnName.add("标题");
		columnName.add("发布时间");
		
		Connection conn;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		ConnectDB connect =new ConnectDB();
		conn=connect.getConnection();
		
		try {
			//查询数据库
			String sql="select * from dbo.Proclamation order by time desc";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
		
			while(rs.next()) {
				Vector<Object> vec = new Vector<Object>();
				for(int i=1;i<=2;i++)
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
				
		table1.setModel(tmhavesold);
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table1.getTableHeader().setReorderingAllowed(false);
				
		//设置各列长度
		int columncount = this.table1.getColumnCount(); 
		this.table1.getColumnModel().getColumn(0).setPreferredWidth(308); 
		this.table1.getColumnModel().getColumn(1).setPreferredWidth(308); 
		
		//居中显示
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		table1.setDefaultRenderer(Object.class, r);
		
		//用户意见
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(126, 214, 634, 137);
		add(scrollPane2);
		
		//意见表
		table2 = new JTable();
		table2.setBackground(Color.WHITE);
		table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane2.setViewportView(table2);
		
		Vector<String> columnName2 = new Vector<String>();
		Vector<Vector<Object>> dataVector2 = new Vector<Vector<Object>>(); 
		
		columnName2.add("时间");
		columnName2.add("内容");
		
		Connection conn2;
		PreparedStatement ps2=null;
		ResultSet rs2=null;
		
		ConnectDB connect2 =new ConnectDB();
		conn2=connect2.getConnection();
		
		try {
			//查询数据库
			String sql="select * from dbo.UserAdvice order by time desc";
			ps2=conn2.prepareStatement(sql);
			rs2=ps2.executeQuery();
		
			while(rs2.next()) {
				Vector<Object> vec2 = new Vector<Object>();
				for(int i=1;i<=2;i++)
				{
					vec2.add(rs2.getObject(i));
				}
				dataVector2.add(vec2);
			}

		}catch(Exception e2) {
			e2.printStackTrace();
		}
		
		connect2.closeConection(ps2,rs2,conn2);
		
		DefaultTableModel  tmhavesold2;
		tmhavesold2 = new DefaultTableModel() {
			public boolean isCellEditable(int row,int column){  
				return false;
			}  
		};
		tmhavesold2.setDataVector(dataVector2, columnName2);
				
		table2.setModel(tmhavesold2);
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table2.getTableHeader().setReorderingAllowed(false);
				
		//设置各列长度
		int columncount2 = this.table2.getColumnCount(); 
		this.table2.getColumnModel().getColumn(0).setPreferredWidth(308); 
		this.table2.getColumnModel().getColumn(1).setPreferredWidth(308); 
		
		//居中显示
		DefaultTableCellRenderer r2 = new DefaultTableCellRenderer();
		r2.setHorizontalAlignment(JLabel.CENTER);
		table2.setDefaultRenderer(Object.class, r2);
			
		JLabel lblNewLabel = new JLabel("公       告：");
		lblNewLabel.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel.setBounds(128, 10, 94, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("用户意见：");
		lblNewLabel_1.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(126, 191, 102, 15);
		add(lblNewLabel_1);
		
		//发布公告按钮
		JButton btnNewButton = new JButton("发布公告");
		btnNewButton.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton.setBackground(SystemColor.controlLtHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddNotice addnotice=new AddNotice();
				addnotice.show();
			}
		});
		btnNewButton.setBounds(10, 35, 102, 23);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnNewButton);
			
		//公告查看详情按钮
		JButton btnNewButton_1 = new JButton("查看详情");
		btnNewButton_1.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_1.setBackground(SystemColor.controlLtHighlight);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				notice_rownum=table1.getSelectedRow();
				notice_time=table1.getValueAt(notice_rownum, 1);
				
				NoticeDetail noticedetail=new NoticeDetail();			
				noticedetail.show();
				
			}
		});
		btnNewButton_1.setBounds(10, 68, 102, 23);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnNewButton_1);
		
		//意见查看详情按钮
		JButton btnNewButton_2 = new JButton("查看详情");
		btnNewButton_2.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_2.setBackground(SystemColor.controlLtHighlight);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				advice_rownum=table2.getSelectedRow();
				advice_time=table2.getValueAt(advice_rownum, 0);
				
				AdviceDetail advicedetail=new AdviceDetail();			
				advicedetail.show();
				
			}
		});
		btnNewButton_2.setBounds(10, 214, 102, 23);
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnNewButton_2);
		
		DefaultTableModel  tmhavesold1;
		tmhavesold1 = new DefaultTableModel() {
			public boolean isCellEditable(int row,int column){  
				return false;
			}  
		};
		//公告刷新按钮
		JButton btnNewButton_3 = new JButton("刷       新");
		btnNewButton_3.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_3.setBackground(SystemColor.controlLtHighlight);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Vector<String> columnName1 = new Vector<String>();
				Vector<Vector<Object>> dataVector1 = new Vector<Vector<Object>>(); 
				
				columnName1.add("标题");
				columnName1.add("发布时间");
				
				Connection conn1;
				PreparedStatement ps1=null;
				ResultSet rs1=null;
				
				ConnectDB connect1 =new ConnectDB();
				conn1=connect1.getConnection();
				
				try {
					//查询数据库
					String sql="select * from dbo.Proclamation order by time desc";
					ps1=conn1.prepareStatement(sql);
					rs1=ps1.executeQuery();
				
					while(rs1.next()) {
						Vector<Object> vec1 = new Vector<Object>();
						for(int i=1;i<=2;i++)
						{
							vec1.add(rs1.getObject(i));
						}
						dataVector1.add(vec1);
					}

				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
				connect1.closeConection(ps1,rs1,conn1);
				
				tmhavesold1.setDataVector(dataVector1, columnName1);
				
				table1.setModel(tmhavesold1);
				table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table1.getTableHeader().setReorderingAllowed(false);
						
				//设置各列长度
				table1.getColumnModel().getColumn(0).setPreferredWidth(308); 
				table1.getColumnModel().getColumn(1).setPreferredWidth(308); 
				
				//居中显示
				DefaultTableCellRenderer r = new DefaultTableCellRenderer();
				r.setHorizontalAlignment(JLabel.CENTER);
				table1.setDefaultRenderer(Object.class, r);
				
			}
		});
		btnNewButton_3.setBounds(10, 134, 102, 23);
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnNewButton_3);
		
		
		DefaultTableModel  tmhavesold3;
		tmhavesold3 = new DefaultTableModel() {
			public boolean isCellEditable(int row,int column){  
				return false;
			}  
		};
		//意见刷新按钮
		JButton btnNewButton_4 = new JButton("刷       新");
		btnNewButton_4.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_4.setBackground(SystemColor.controlLtHighlight);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Vector<String> columnName3 = new Vector<String>();
				Vector<Vector<Object>> dataVector3 = new Vector<Vector<Object>>(); 
				
				columnName3.add("时间");
				columnName3.add("内容");
				
				Connection conn3;
				PreparedStatement ps3=null;
				ResultSet rs3=null;
				
				ConnectDB connect3 =new ConnectDB();
				conn3=connect3.getConnection();
				
				try {
					//查询数据库
					String sql="select * from dbo.UserAdvice order by time desc";
					ps3=conn3.prepareStatement(sql);
					rs3=ps3.executeQuery();
				
					while(rs3.next()) {
						Vector<Object> vec3 = new Vector<Object>();
						for(int i=1;i<=2;i++)
						{
							vec3.add(rs3.getObject(i));
						}
						dataVector3.add(vec3);
					}

				}catch(Exception e3) {
					e3.printStackTrace();
				}
				
				connect3.closeConection(ps3,rs3,conn3);
				
				tmhavesold3.setDataVector(dataVector3, columnName3);
				
				table2.setModel(tmhavesold3);
				table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table2.getTableHeader().setReorderingAllowed(false);
						
				//设置各列长度
				table2.getColumnModel().getColumn(0).setPreferredWidth(308); 
				table2.getColumnModel().getColumn(1).setPreferredWidth(308); 
				
				//居中显示
				DefaultTableCellRenderer r3 = new DefaultTableCellRenderer();
				r3.setHorizontalAlignment(JLabel.CENTER);
				table2.setDefaultRenderer(Object.class, r3);
			}
		});
		btnNewButton_4.setBounds(10, 280, 102, 23);
		btnNewButton_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnNewButton_4);	
		
		//公告删除按钮
		JButton btnNewButton_5 = new JButton("删       除");
		btnNewButton_5.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_5.setBackground(SystemColor.controlLtHighlight);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//获取选定行行号
				int rownum=table1.getSelectedRow();
				//获取选定行的时间
				Object gettime=table1.getValueAt(rownum, 1);
				
				int result = JOptionPane.showConfirmDialog(null, "是否要删除本行数据?", "确认删除框", JOptionPane.YES_NO_OPTION);
				
				//确认删除
				if (result == JOptionPane.YES_OPTION) {
		
					Connection conn_delete;
					PreparedStatement ps_delete=null;
					ResultSet rs_delete=null;
					
					ConnectDB connect_delete =new ConnectDB();
					conn_delete=connect_delete.getConnection();
					
					try {
						//查询数据库
						String sql="delete from dbo.Proclamation where time='"+gettime+"'";
						ps_delete=conn_delete.prepareStatement(sql);
						rs_delete=ps_delete.executeQuery();
						
					}catch(Exception e_delete) {
						e_delete.printStackTrace();
					}
					
					connect_delete.closeConection(ps_delete,rs_delete,conn_delete);
					
					tmhavesold.removeRow(rownum);
					tmhavesold1.removeRow(rownum);
				}
				//取消删除
				else if (result == JOptionPane.NO_OPTION) {
					//退出
				}		
			}
		});
		btnNewButton_5.setBounds(10, 101, 102, 23);
		btnNewButton_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnNewButton_5);
		
		//意见删除按钮
		JButton btnNewButton_6 = new JButton("删       除");
		btnNewButton_6.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_6.setBackground(SystemColor.controlLtHighlight);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//获取选定行行号
				int rownum=table2.getSelectedRow();
				//获取选定行的时间
				Object gettime=table2.getValueAt(rownum, 0);
				
				int result = JOptionPane.showConfirmDialog(null, "是否要删除本行数据?", "确认删除框", JOptionPane.YES_NO_OPTION);
				
				//确认删除
				if (result == JOptionPane.YES_OPTION) {
		
					Connection conn_delete;
					PreparedStatement ps_delete=null;
					ResultSet rs_delete=null;
					
					ConnectDB connect_delete =new ConnectDB();
					conn_delete=connect_delete.getConnection();
					
					try {
						//查询数据库
						String sql="delete from dbo.UserAdvice where time='"+gettime+"'";
						ps_delete=conn_delete.prepareStatement(sql);
						rs_delete=ps_delete.executeQuery();
						
					}catch(Exception e_delete) {
						e_delete.printStackTrace();
					}
					
					connect_delete.closeConection(ps_delete,rs_delete,conn_delete);
					
					tmhavesold2.removeRow(rownum);
					tmhavesold3.removeRow(rownum);
				}
				//取消删除
				else if (result == JOptionPane.NO_OPTION) {
					//退出
				}	
			}
		});
		btnNewButton_6.setBounds(10, 247, 102, 23);
		btnNewButton_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnNewButton_6);
	}
	
	
}
