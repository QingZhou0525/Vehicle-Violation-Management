package 车辆违章管理系统;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;

public class User extends JFrame {

	private JPanel contentPane;
	Point pressedPoint;
	
	boolean uvisblue=true;
	boolean uanisblue=false;
	boolean umisblue=false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User frame = new User();
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
	public User() {
		
		
		setForeground(Color.BLACK);
		setIconImage(Toolkit.getDefaultToolkit().getImage(User.class.getResource("/photo/caricon.png")));
		
		Login login=new Login();
		
		setTitle("车辆违章管理系统");
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 240, 246));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setUndecorated(true);
		
		//按住鼠标拖动
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) { //鼠标按下事件
				pressedPoint = e.getPoint(); //记录鼠标坐标
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) { // 鼠标拖拽事件
				Point point = e.getPoint();// 获取当前坐标
				Point locationPoint = getLocation();// 获取窗体坐标
				int x = locationPoint.x + point.x - pressedPoint.x;// 计算移动后的新坐标
				int y = locationPoint.y + point.y - pressedPoint.y;
				setLocation(x, y);// 改变窗体位置
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 450);
		
		
		//违章信息模块
		UserViolation panel_uv;
		panel_uv = new UserViolation();
		panel_uv.setBounds(0, 71, 760, 351);
		contentPane.add(panel_uv);
		panel_uv.setVisible(true);
				
		//意见&公告模块
		UserAdviceNotice panel_uan;
		panel_uan = new UserAdviceNotice();
		panel_uan.setBounds(0, 71, 760, 351);
		contentPane.add(panel_uan);
		panel_uan.setVisible(false);
				
		//查看地图模块
		UserMap panel_um;
		panel_um=new UserMap();
		panel_um.setBounds(0,71, 760, 351);
		contentPane.add(panel_um);
		panel_um.setVisible(false);
		
		
		//违章管理按钮
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setToolTipText("查看违章信息");
		btnNewButton_1.setIcon(new ImageIcon(User.class.getResource("/photo/车辆管理2.png")));
		btnNewButton_1.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_1.setBackground(SystemColor.menu);
		btnNewButton_1.setBounds(300, 13, 46, 52);
		btnNewButton_1.setIconTextGap(0);//将标签中显示的文本和图标之间的间隔量设置为0  
		btnNewButton_1.setBorderPainted(false);//不打印边框  
		btnNewButton_1.setBorder(null);//除去边框  
		btnNewButton_1.setText(null);//除去按钮的默认名称  
		btnNewButton_1.setFocusPainted(false);//除去焦点的框  
		btnNewButton_1.setContentAreaFilled(false);//除去默认的背景填充
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton_1);
		
		//意见&公告按钮
		JButton btnNewButton_2 = new JButton("\u516C\u544A&\u610F\u89C1\u7BA1\u7406");
		btnNewButton_2.setToolTipText("查看公告&意见");
		btnNewButton_2.setIcon(new ImageIcon(User.class.getResource("/photo/公告.png")));
		btnNewButton_2.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_2.setBackground(SystemColor.menu);
		btnNewButton_2.setBounds(365, 12, 51, 52);
		btnNewButton_2.setIconTextGap(0);//将标签中显示的文本和图标之间的间隔量设置为0  
		btnNewButton_2.setBorderPainted(false);//不打印边框  
		btnNewButton_2.setBorder(null);//除去边框  
		btnNewButton_2.setText(null);//除去按钮的默认名称  
		btnNewButton_2.setFocusPainted(false);//除去焦点的框  
		btnNewButton_2.setContentAreaFilled(false);//除去默认的背景填充
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton_2);
		
		//地图绘制按钮
		JButton btnNewButton_3 = new JButton("\u5730\u56FE\u7ED8\u5236");
		btnNewButton_3.setToolTipText("查看地图");
		btnNewButton_3.setIcon(new ImageIcon(User.class.getResource("/photo/地图.png")));
		btnNewButton_3.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		btnNewButton_3.setBackground(SystemColor.menu);
		btnNewButton_3.setBounds(430, 12, 51, 50);
		btnNewButton_3.setIconTextGap(0);//将标签中显示的文本和图标之间的间隔量设置为0  
		btnNewButton_3.setBorderPainted(false);//不打印边框  
		btnNewButton_3.setBorder(null);//除去边框  
		btnNewButton_3.setText(null);//除去按钮的默认名称  
		btnNewButton_3.setFocusPainted(false);//除去焦点的框  
		btnNewButton_3.setContentAreaFilled(false);//除去默认的背景填充
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewButton_3);	
		
		JLabel lblNewLabel = new JLabel("车辆违章管理系统");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("方正准圆简体", Font.PLAIN, 18));
		lblNewLabel.setIcon(new ImageIcon(User.class.getResource("/photo/carblue.png")));
		lblNewLabel.setBounds(20, 5, 209, 62);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setToolTipText("退出");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(User.class.getResource("/photo/退出.png")));
		btnNewButton_4.setBounds(722, 18, 40, 39);
		btnNewButton_4.setIconTextGap(0);//将标签中显示的文本和图标之间的间隔量设置为0  
		btnNewButton_4.setBorderPainted(false);//不打印边框  
		btnNewButton_4.setBorder(null);//除去边框  
		btnNewButton_4.setText(null);//除去按钮的默认名称  
		btnNewButton_4.setFocusPainted(false);//除去焦点的框  
		btnNewButton_4.setContentAreaFilled(false);//除去默认的背景填充
		btnNewButton_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_4.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e) {
				btnNewButton_4.setIcon(new ImageIcon(User.class.getResource("/photo/退出2.png")));
			}
			public void mouseExited(MouseEvent e) {
				btnNewButton_4.setIcon(new ImageIcon(User.class.getResource("/photo/退出.png")));
			}
		});
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setToolTipText("最小化");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setExtendedState(JFrame.ICONIFIED);
				
			}
		});
		btnNewButton_5.setIcon(new ImageIcon(User.class.getResource("/photo/最小化.png")));
		btnNewButton_5.setBounds(690, 18, 40, 39);
		btnNewButton_5.setIconTextGap(0);//将标签中显示的文本和图标之间的间隔量设置为0  
		btnNewButton_5.setBorderPainted(false);//不打印边框  
		btnNewButton_5.setBorder(null);//除去边框  
		btnNewButton_5.setText(null);//除去按钮的默认名称  
		btnNewButton_5.setFocusPainted(false);//除去焦点的框  
		btnNewButton_5.setContentAreaFilled(false);//除去默认的背景填充
		btnNewButton_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_5.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e) {
				btnNewButton_5.setIcon(new ImageIcon(User.class.getResource("/photo/最小化2.png")));
			}
			public void mouseExited(MouseEvent e) {
				btnNewButton_5.setIcon(new ImageIcon(User.class.getResource("/photo/最小化.png")));
			}
		});
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(User.class.getResource("/photo/line.png")));
		lblNewLabel_1.setBounds(640, 18, 22, 39);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setToolTipText("个人中心");
		btnNewButton_6.setFont(new Font("方正准圆简体", Font.PLAIN, 15));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UserInformation userinformation = new UserInformation();
				userinformation.show();

			}
		});
		btnNewButton_6.setIcon(new ImageIcon(User.class.getResource("/photo/人物.png")));
		btnNewButton_6.setBounds(550, 16, 103, 44);
		btnNewButton_6.setIconTextGap(0);//将标签中显示的文本和图标之间的间隔量设置为0  
		btnNewButton_6.setBorderPainted(false);//不打印边框  
		btnNewButton_6.setBorder(null);//除去边框  
		btnNewButton_6.setText("  "+login.get_name);//除去按钮的默认名称  
		btnNewButton_6.setFocusPainted(false);//除去焦点的框  
		btnNewButton_6.setContentAreaFilled(false);//除去默认的背景填充
		btnNewButton_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_6.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e) {
				btnNewButton_6.setIcon(new ImageIcon(User.class.getResource("/photo/人物2.png")));
				btnNewButton_6.setForeground(new Color(18,150,219));
			}
			public void mouseExited(MouseEvent e) {
				btnNewButton_6.setIcon(new ImageIcon(User.class.getResource("/photo/人物.png")));
				btnNewButton_6.setForeground(Color.BLACK);
			}
		});
		contentPane.add(btnNewButton_6);
		
		JLabel lblNewLabel_2 = new JLabel(login.get_name+",欢迎使用车辆违章管理系统！");
		lblNewLabel_2.setFont(new Font("方正准圆简体", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(20, 430, 602, 15);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.setToolTipText("帮助");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UserHelp userhelp=new UserHelp();
				userhelp.show();
				
			}
		});
		btnNewButton_7.setIcon(new ImageIcon(User.class.getResource("/photo/提示2.png")));
		btnNewButton_7.setBounds(731, 423, 29, 25);
		btnNewButton_7.setIconTextGap(0);//将标签中显示的文本和图标之间的间隔量设置为0  
		btnNewButton_7.setBorderPainted(false);//不打印边框  
		btnNewButton_7.setBorder(null);
		btnNewButton_7.setFocusPainted(false);//除去焦点的框  
		btnNewButton_7.setContentAreaFilled(false);//除去默认的背景填充
		btnNewButton_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_7.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e) {
				btnNewButton_7.setIcon(new ImageIcon(User.class.getResource("/photo/提示.png")));
			}
			public void mouseExited(MouseEvent e) {
				btnNewButton_7.setIcon(new ImageIcon(User.class.getResource("/photo/提示2.png")));
			}
		});
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("");
		btnNewButton_8.setToolTipText("用户切换");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int result = JOptionPane.showConfirmDialog(null, "是否要切换用户?", "确认框", JOptionPane.YES_NO_OPTION);
				
				//确认修改
				if (result == JOptionPane.YES_OPTION) {
					
					dispose();
					Login login=new Login();
					login.show();
					
				}
				//取消修改
				else if (result == JOptionPane.NO_OPTION) {
					//退出
				}				
				
			}
		});
		btnNewButton_8.setIcon(new ImageIcon((User.class.getResource("/photo/切换用户.png"))));
		btnNewButton_8.setBounds(653, 15, 51, 45);
		btnNewButton_8.setIconTextGap(0);//将标签中显示的文本和图标之间的间隔量设置为0  
		btnNewButton_8.setBorderPainted(false);//不打印边框  
		btnNewButton_8.setBorder(null);
		btnNewButton_8.setFocusPainted(false);//除去焦点的框  
		btnNewButton_8.setContentAreaFilled(false);//除去默认的背景填充
		btnNewButton_8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_8.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e) {
				btnNewButton_8.setIcon(new ImageIcon(User.class.getResource("/photo/切换用户2.png")));
			}
			public void mouseExited(MouseEvent e) {
				btnNewButton_8.setIcon(new ImageIcon(User.class.getResource("/photo/切换用户.png")));
			}
		});
		contentPane.add(btnNewButton_8);
		
		
		
		
		
				//违章管理按钮事件
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						uvisblue=true;
						uanisblue=false;
						umisblue=false;
						
						btnNewButton_1.setIcon(new ImageIcon(User.class.getResource("/photo/车辆管理2.png")));
						btnNewButton_2.setIcon(new ImageIcon(User.class.getResource("/photo/公告.png")));
						btnNewButton_3.setIcon(new ImageIcon(User.class.getResource("/photo/地图.png")));
						
						panel_uan.setVisible(false);
						panel_um.setVisible(false);
						panel_uv.setVisible(true);
					}
				});

				btnNewButton_1.addMouseListener(new MouseAdapter(){
					public void mouseEntered(MouseEvent e) {
						if(!uvisblue) {
							btnNewButton_1.setIcon(new ImageIcon(User.class.getResource("/photo/车辆管理2.png")));
						}
					}
					public void mouseExited(MouseEvent e) {
						if(!uvisblue) {
							btnNewButton_1.setIcon(new ImageIcon(User.class.getResource("/photo/车辆管理.png")));
						}
					}
				});
				
				
				//公告意见按钮事件
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						uvisblue=false;
						uanisblue=true;
						umisblue=false;
						
						btnNewButton_1.setIcon(new ImageIcon(User.class.getResource("/photo/车辆管理.png")));
						btnNewButton_2.setIcon(new ImageIcon(User.class.getResource("/photo/公告2.png")));
						btnNewButton_3.setIcon(new ImageIcon(User.class.getResource("/photo/地图.png")));
						
						panel_um.setVisible(false);
						panel_uv.setVisible(false);
						panel_uan.setVisible(true);
					}
				});
				btnNewButton_2.addMouseListener(new MouseAdapter(){
					public void mouseEntered(MouseEvent e) {
						if(!uanisblue) {
							btnNewButton_2.setIcon(new ImageIcon(User.class.getResource("/photo/公告2.png")));
						}
					}
					public void mouseExited(MouseEvent e) {
						if(!uanisblue) {
							btnNewButton_2.setIcon(new ImageIcon(User.class.getResource("/photo/公告.png")));
						}
					}
				});
				
				//绘制地图按钮事件
				btnNewButton_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						uvisblue=false;
						uanisblue=false;
						umisblue=true;
						
						btnNewButton_1.setIcon(new ImageIcon(User.class.getResource("/photo/车辆管理.png")));
						btnNewButton_2.setIcon(new ImageIcon(User.class.getResource("/photo/公告.png")));
						btnNewButton_3.setIcon(new ImageIcon(User.class.getResource("/photo/地图2.png")));
						
						panel_uv.setVisible(false);
						panel_uan.setVisible(false);
						panel_um.setVisible(true);
					}
				});
				btnNewButton_3.addMouseListener(new MouseAdapter(){
					public void mouseEntered(MouseEvent e) {
						if(!umisblue) {
							btnNewButton_3.setIcon(new ImageIcon(User.class.getResource("/photo/地图2.png")));
						}
					}
					public void mouseExited(MouseEvent e) {
						if(!umisblue) {
							btnNewButton_3.setIcon(new ImageIcon(User.class.getResource("/photo/地图.png")));
						}
					}
				});	
		
		//居中显示
		this.setLocationRelativeTo(null);
		
		//设置窗体大小不变
		this.setResizable(false);
	}
}
