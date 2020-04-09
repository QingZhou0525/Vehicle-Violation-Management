package 车辆违章管理系统;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;

public class UserManage extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 *
	 */
		

	
	
	public UserManage() {
		setBackground(Color.WHITE);
		
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(126, 0, 634, 352);
		add(scrollPane);
		
		table = new JTable();
		table.setForeground(Color.BLACK);
		table.setBackground(SystemColor.window);
		//table.setFont(new Font("方正准圆简体", Font.PLAIN, 13));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		Vector<String> columnName = new Vector<String>();
		Vector<Vector<Object>> dataVector = new Vector<Vector<Object>>(); 
		columnName.add("姓名");
		columnName.add("性别");
		columnName.add("电话");
		columnName.add("驾驶证号");
		columnName.add("身份证号");
		columnName.add("邮箱");
		columnName.add("账号");
		columnName.add("密码");
		
		Connection conn;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		ConnectDB connect =new ConnectDB();
		conn=connect.getConnection();
		
		try {
			//查询数据库
			String sql="select * from dbo.Users";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
		
			while(rs.next()) {
				Vector<Object> vec = new Vector<Object>();
				for(int i=1;i<=7;i++)
				{
					vec.add(rs.getObject(i));
				}
				
				vec.add(toString(rs.getString(8)));
				
				dataVector.add(vec);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		connect.closeConection(ps,rs,conn);
		
		//声明table的model
		DefaultTableModel  tmhavesold;
		tmhavesold = new DefaultTableModel() {
			//设置id列不可修改
			public boolean isCellEditable(int row,int column){  
			    if(column == 6){  
			       return false;  
			    }else{  
			       return true;  
			    }  
			}  
		};
		tmhavesold.setDataVector(dataVector, columnName);
		
		table.setModel(tmhavesold);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		
		//设置各列长度
		int columncount = this.table.getColumnCount(); 
		this.table.getColumnModel().getColumn(0).setPreferredWidth(50); 
		this.table.getColumnModel().getColumn(1).setPreferredWidth(40); 
		this.table.getColumnModel().getColumn(2).setPreferredWidth(100); 
		this.table.getColumnModel().getColumn(3).setPreferredWidth(150); 
		this.table.getColumnModel().getColumn(4).setPreferredWidth(150); 
		this.table.getColumnModel().getColumn(5).setPreferredWidth(150); 
		this.table.getColumnModel().getColumn(6).setPreferredWidth(80); 
		this.table.getColumnModel().getColumn(7).setPreferredWidth(80);
		

		//居中显示
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, r);
		
		
		DefaultTableModel  tmhavesold1;
		tmhavesold1 = new DefaultTableModel() {
			//设置id列不可修改
			public boolean isCellEditable(int row,int column){  
			    if(column == 6){  
			       return false;  
			    }else{  
			       return true;  
			    }  
			}  
		};
		
		//刷新按钮
		JButton button = new JButton("刷       新");
		button.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		button.setBackground(SystemColor.controlLtHighlight);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				Vector<String> columnName1 = new Vector<String>();
				Vector<Vector<Object>> dataVector1 = new Vector<Vector<Object>>(); 
				
				columnName1.add("姓名");
				columnName1.add("性别");
				columnName1.add("电话");
				columnName1.add("驾驶证号");
				columnName1.add("身份证号");
				columnName1.add("邮箱");
				columnName1.add("账号");
				columnName1.add("密码");
				
				
				Connection conn1;
				PreparedStatement ps1=null;
				ResultSet rs1=null;
				
				ConnectDB connect1 =new ConnectDB();
				conn1=connect1.getConnection();
				
				try {
					//查询数据库
					String sql="select * from dbo.Users";
					ps1=conn1.prepareStatement(sql);
					rs1=ps1.executeQuery();
				
					while(rs1.next()) {
						Vector<Object> vec1 = new Vector<Object>();
						for(int i=1;i<=7;i++)
						{
							vec1.add(rs1.getObject(i));
						}
						
						vec1.add(UserManage.toString(rs1.getString(8)));
						
						dataVector1.add(vec1);
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				connect.closeConection(ps1,rs1,conn1);
				
				tmhavesold1.setDataVector(dataVector1, columnName1);
				
				table.setModel(tmhavesold1);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.getTableHeader().setReorderingAllowed(false);
				
				//居中显示
				DefaultTableCellRenderer r = new DefaultTableCellRenderer();
				r.setHorizontalAlignment(JLabel.CENTER);
				table.setDefaultRenderer(Object.class, r);
				
				//设置各列长度
				table.getColumnModel().getColumn(0).setPreferredWidth(50); 
				table.getColumnModel().getColumn(1).setPreferredWidth(40); 
				table.getColumnModel().getColumn(2).setPreferredWidth(100); 
				table.getColumnModel().getColumn(3).setPreferredWidth(150); 
				table.getColumnModel().getColumn(4).setPreferredWidth(150); 
				table.getColumnModel().getColumn(5).setPreferredWidth(150); 
				table.getColumnModel().getColumn(6).setPreferredWidth(80); 
				table.getColumnModel().getColumn(7).setPreferredWidth(80);
			}
		});
		button.setBounds(10, 139, 106, 23);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(button);
		
		/*
		//修改按钮
		JButton btnNewButton = new JButton("\u4FDD\u5B58\u4FEE\u6539");
		btnNewButton.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton.setBackground(SystemColor.controlLtHighlight);
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
			int result = JOptionPane.showConfirmDialog(null, "确认修改?", "确认修改框", JOptionPane.YES_NO_OPTION);
			
			//确认修改
			if (result == JOptionPane.YES_OPTION) {
				//统计总用户数
				int row_count=table.getRowCount();
				int i=0;
					
				Connection conn_update;
				PreparedStatement ps_update=null;
				ResultSet rs_update=null;
				
				ConnectDB connect_update =new ConnectDB();
				conn_update=connect_update.getConnection();
				
				Connection conn_update1;
				PreparedStatement ps_update1=null;
				ResultSet rs_update1=null;
				
				ConnectDB connect_update1 =new ConnectDB();
				conn_update1=connect_update1.getConnection();
				
				//修改到Users表
				for(i=0;i<row_count;i++) {
					try {
						
						Object getname=table.getValueAt(i, 0);
						Object getsex=table.getValueAt(i, 1);
						Object gettel=table.getValueAt(i, 2);
						Object getlicence=table.getValueAt(i, 3);
						Object getidentification=table.getValueAt(i, 4);
						Object getmail=table.getValueAt(i, 5);
						Object getid=table.getValueAt(i, 6);
						Object getpwd=table.getValueAt(i, 7);
						
						
						String sql="update dbo.Users set name='"+getname.toString().trim()+"',sex='"+getsex.toString().trim()+ "',tel='"+gettel.toString().trim()+"',licence="+getlicence+",identification="+getidentification+",email='"+getmail.toString().trim()+"',password='"+StrToBinstr(getpwd.toString().trim())+"'where id="+getid;
						ps_update=conn_update.prepareStatement(sql);
						rs_update=ps_update.executeQuery();
						
					}catch(Exception e_update) {
						e_update.printStackTrace();
					}			
				}
				
				connect.closeConection(ps_update,rs_update,conn_update);
				
				
				//将电话修改到CarInformation表
				
				for(i=0;i<row_count;i++) {
					
					Connection conn3;
					PreparedStatement ps3=null;
					ResultSet rs3=null;
					
					ConnectDB connect3 =new ConnectDB();
					conn3=connect3.getConnection();
					
					boolean isdata=false;
					
					try {
						
						Object getlicence=table.getValueAt(i, 3);
						//查询数据库
						String sql3="select * from dbo.CarInformation where ownerlicence="+getlicence;
						ps3=conn3.prepareStatement(sql3);
						rs3=ps3.executeQuery();
					
						while(rs3.next()) {
							
							isdata=true;
						}						
					}catch(Exception e3) {
						e3.printStackTrace();
					}
					
					connect3.closeConection(ps3,rs3,conn3);

					if(isdata) {
						try {
							
							Object gettel=table.getValueAt(i, 2);
							Object getlicence=table.getValueAt(i, 3);
							
							String sql1="update dbo.CarInformation set ownertel='"+gettel.toString().trim()+"'where ownerlicence='"+getlicence+"'";
							ps_update1=conn_update1.prepareStatement(sql1);
							rs_update1=ps_update1.executeQuery();
							
						}catch(Exception e_update1) {
							e_update1.printStackTrace();
						}			
					
					
						connect_update1.closeConection(ps_update1,rs_update1,conn_update1);	
					}
					
				}
			}
			//取消修改
			else if (result == JOptionPane.NO_OPTION) {
				//退出
			}				
		}
		});
		btnNewButton.setBounds(10, 106, 106, 23);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnNewButton);
		*/
		
		//删除按钮
		JButton button_1 = new JButton("删       除");
		button_1.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		button_1.setBackground(SystemColor.controlLtHighlight);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//获取选定行行号
				int rownum=table.getSelectedRow();
				//获取选定行的id号
				Object getid=table.getValueAt(rownum, 6);
				
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
						String sql="delete from dbo.Users where id="+getid;
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
		button_1.setBounds(10, 106, 106, 23);
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(button_1);
		
		//添加用户按钮
		JButton btnNewButton_1 = new JButton("\u6DFB\u52A0\u7528\u6237");
		btnNewButton_1.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_1.setBackground(SystemColor.controlLtHighlight);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUser adduser=new AddUser();
				adduser.show();
			}
		});
		btnNewButton_1.setBounds(10, 73, 106, 23);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("查       询");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchUser search=new SearchUser();
				search.show();
			}
		});
		btnNewButton_2.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_2.setBackground(SystemColor.controlLtHighlight);
		btnNewButton_2.setBounds(10, 20, 106, 23);
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnNewButton_2);
		
		
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
