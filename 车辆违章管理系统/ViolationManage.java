package 车辆违章管理系统;

import javax.swing.JPanel;
import javax.swing.JScrollBar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

public class ViolationManage extends JPanel {

	private JTable table;
	
	/**
	 * Create the panel.
	 */
	public ViolationManage() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(149, 0, 612, 352);
		add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

		Vector<String> columnName = new Vector<String>();
		Vector<Vector<Object>> dataVector = new Vector<Vector<Object>>(); 
		
		columnName.add("车牌号");
		columnName.add("车辆颜色");
		columnName.add("违章区域");
		columnName.add("违章街道");
		columnName.add("违章时间");
		columnName.add("违章事件");
		columnName.add("违章地点经度");
		columnName.add("违章地点纬度");
		
		Connection conn;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		ConnectDB connect =new ConnectDB();
		conn=connect.getConnection();
		
		try {
			//查询数据库
			String sql="select * from dbo.ViolationInformation order by time desc";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
		
			while(rs.next()) {
				Vector<Object> vec = new Vector<Object>();
				for(int i=1;i<=8;i++)
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
		this.table.getColumnModel().getColumn(1).setPreferredWidth(80); 
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
			public boolean isCellEditable(int row,int column){  
				return false;
			}  
		};
		
		
		//刷新按钮
		JButton btnNewButton = new JButton("刷       新");
		btnNewButton.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton.setBackground(SystemColor.controlLtHighlight);
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			Vector<String> columnName1 = new Vector<String>();
			Vector<Vector<Object>> dataVector1 = new Vector<Vector<Object>>(); 
			
			columnName1.add("车牌号");
			columnName1.add("车辆颜色");
			columnName1.add("违章区域");
			columnName1.add("违章街道");
			columnName1.add("违章时间");
			columnName1.add("违章事件");
			columnName1.add("违章地点经度");
			columnName1.add("违章地点纬度");
			
			
			Connection conn1;
			PreparedStatement ps1=null;
			ResultSet rs1=null;
			
			ConnectDB connect1 =new ConnectDB();
			conn1=connect1.getConnection();
			
			try {
				//查询数据库
				String sql="select * from dbo.ViolationInformation order by time desc";
				ps1=conn1.prepareStatement(sql);
				rs1=ps1.executeQuery();
			
				while(rs1.next()) {
					Vector<Object> vec1 = new Vector<Object>();
					for(int i=1;i<=8;i++)
					{
						vec1.add(rs1.getObject(i));
					}
					dataVector1.add(vec1);
				}

			}catch(Exception e) {
				e.printStackTrace();
			}
			
			connect1.closeConection(ps1,rs1,conn1);
			
			tmhavesold1.setDataVector(dataVector1, columnName1);
			
			table.setModel(tmhavesold1);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.getTableHeader().setReorderingAllowed(false);
			
			//居中显示
			DefaultTableCellRenderer r = new DefaultTableCellRenderer();
			r.setHorizontalAlignment(JLabel.CENTER);
			table.setDefaultRenderer(Object.class, r);
			
			//设置各列长度
			table.getColumnModel().getColumn(0).setPreferredWidth(100); 
			table.getColumnModel().getColumn(1).setPreferredWidth(80); 
			table.getColumnModel().getColumn(2).setPreferredWidth(100); 
			table.getColumnModel().getColumn(3).setPreferredWidth(150); 
			table.getColumnModel().getColumn(4).setPreferredWidth(150); 
			table.getColumnModel().getColumn(5).setPreferredWidth(150); 
			table.getColumnModel().getColumn(6).setPreferredWidth(80);
			table.getColumnModel().getColumn(7).setPreferredWidth(80); 
				
			}
		});
		btnNewButton.setBounds(8, 157, 129, 23);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnNewButton);
		
		//删除按钮
		JButton btnNewButton_1 = new JButton("删       除");
		btnNewButton_1.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_1.setBackground(SystemColor.controlLtHighlight);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int result = JOptionPane.showConfirmDialog(null, "是否要删除本行数据?", "确认删除框", JOptionPane.YES_NO_OPTION);
				
				//确认删除
				if (result == JOptionPane.YES_OPTION) {
					//获取选定行行号
					int rownum=table.getSelectedRow();
					//获取选定行的车牌号
					Object getcarnum=table.getValueAt(rownum, 0);	
					//获取选定行的违章时间
					Object gettime=table.getValueAt(rownum, 4);
					
					Connection conn_delete;
					PreparedStatement ps_delete=null;
					ResultSet rs_delete=null;
					
					ConnectDB connect_delete =new ConnectDB();
					conn_delete=connect_delete.getConnection();
					
					try {
						//查询数据库
						String sql="delete from dbo.ViolationInformation where carnum='"+getcarnum.toString()+"'and time='"+gettime+"'";
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
		btnNewButton_1.setBounds(8, 124, 131, 23);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnNewButton_1);
		
		//添加违章信息按钮
		JButton btnNewButton_2 = new JButton("添加违章信息");
		btnNewButton_2.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_2.setBackground(SystemColor.controlLtHighlight);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddViolation addviolation=new AddViolation();
				addviolation.show();
			}
		});
		btnNewButton_2.setBounds(8, 91, 131, 23);
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnNewButton_2);
		
		//查询车辆信息按钮
		JButton btnNewButton_3 = new JButton("查询车辆信息");
		btnNewButton_3.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_3.setBackground(SystemColor.controlLtHighlight);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarSearch carsearch=new CarSearch();
				carsearch.show();
			}
		});
		btnNewButton_3.setBounds(8, 20, 131, 23);
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnNewButton_3);
	}
}
