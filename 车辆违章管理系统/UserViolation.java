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
import java.awt.Color;
import java.awt.Font;

public class UserViolation extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public UserViolation() {
		
		
		setBackground(Color.WHITE);
		setLayout(null);
		
		
		Login login=new Login();
		
		boolean carnum_isnull=true;
		
		String get_carnum = null;
		
		Connection conn_search;
		PreparedStatement ps_search=null;
		ResultSet rs_search=null;
		
		ConnectDB connect_search =new ConnectDB();
		conn_search=connect_search.getConnection();
		
		try {
				
			String sql="select * from dbo.CarInformation where ownerlicence='"+login.get_licence+"'";
			ps_search=conn_search.prepareStatement(sql);
			rs_search=ps_search.executeQuery();
			
			if(rs_search.next()) {
				
				get_carnum=rs_search.getString("carnum");
				carnum_isnull=false;
				
			}
			
				
		}catch(Exception e_search) {
			e_search.printStackTrace();
		}

		connect_search.closeConection(ps_search,rs_search,conn_search);
		
		boolean haveviolation=false;
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 33, 760, 318);
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
		
		Connection conn;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		ConnectDB connect =new ConnectDB();
		conn=connect.getConnection();
		
		try {
			//查询数据库
			String sql="select * from dbo.ViolationInformation where carnum = '"+get_carnum+"' order by time desc";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
		
			while(rs.next()) {
				Vector<Object> vec = new Vector<Object>();
				for(int i=1;i<=6;i++)
				{
					vec.add(rs.getObject(i));
				}
				dataVector.add(vec);
				
				haveviolation=true;
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
		
		if(carnum_isnull) 
		{
			
			JLabel lblNewLabel = new JLabel("请先在 个人中心 中绑定车牌号码后，重新登录系统后查看违章记录！");
			lblNewLabel.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
			lblNewLabel.setBounds(10, 10, 600, 15);
			add(lblNewLabel);
			
		}
		else
		{
			if(haveviolation)
			{
				JLabel lblNewLabel = new JLabel("你的违章记录如下：");
				lblNewLabel.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
				lblNewLabel.setBounds(10, 10, 600, 15);
				add(lblNewLabel);
			}
			else
			{
				JLabel lblNewLabel = new JLabel("你暂无违章记录，请继续保持！");
				lblNewLabel.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
				lblNewLabel.setBounds(10, 10, 600, 15);
				add(lblNewLabel);
			}
			
		}
		
		
		
		//设置各列长度
		int columncount = this.table.getColumnCount(); 
		this.table.getColumnModel().getColumn(0).setPreferredWidth(100); 
		this.table.getColumnModel().getColumn(1).setPreferredWidth(80); 
		this.table.getColumnModel().getColumn(2).setPreferredWidth(100); 
		this.table.getColumnModel().getColumn(3).setPreferredWidth(160); 
		this.table.getColumnModel().getColumn(4).setPreferredWidth(160); 
		this.table.getColumnModel().getColumn(5).setPreferredWidth(160); 

		
		//居中显示
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, r);
		
	}
}
