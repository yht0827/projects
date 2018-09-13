package Pos;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

public class PosMain extends JFrame implements Runnable{

	private Thread thread;
	private JLabel clock;
	private SimpleDateFormat dayTime;
	private JTextField chargetext;
	private JTextField paytext;
	private JTextField sumtext;
	private String str="";
	private JLabel Timage;
	private ImageIcon img = null;
	private URL imageURL;
	private JLabel Timage1;
	private ImageIcon img1 = null;
	private URL imageURL1;
	private JPanel panel_1 = new JPanel();
	private JButton bt_1 = new JButton("");
	private JButton bt_2 = new JButton("");
	private JButton bt_3 = new JButton("");
	private JButton bt_4 = new JButton("");
	private JButton bt_5 = new JButton("");
	private JButton bt_6 = new JButton("");
	private JButton bt_7 = new JButton("");
	private JPanel panel = new JPanel();
	private JButton bt_8 = new JButton("");
	private JButton bt_9 = new JButton("");
	private JButton bt_0 = new JButton("");

	private JButton bt_bs = new JButton("");
	private JButton bt_clear = new JButton("");
	private JButton bt_sale = new JButton("");
	private JButton back_bt = new JButton("");
	private JButton calc_bt = new JButton("");
	private JButton exit_bt = new JButton("");
	private JLabel label_sum = new JLabel("\uD569    \uACC4 :");
	private JButton table1 = new JButton("1");
	private JButton table2 = new JButton("2");
	private JButton table3 = new JButton("3");
	private JButton table4 = new JButton("4");
	private JButton table5 = new JButton("5");
	private JButton table6 = new JButton("6");
	private JButton table7 = new JButton("7");
	private JButton table8 = new JButton("8");
	private JButton table9 = new JButton("9");
	private int[] price= new int[9];
	private JLabel label_charge = new JLabel("\uAC70\uC2A4\uB984\uB3C8 :");
	private boolean[] tableflag = new boolean[9];
	private JLabel label_pay = new JLabel("\uBC1B\uC740\uAE08\uC561 :");
	private int[] cnt = new int[9];
	private int[] cnt1 = new int[9];
	private int[] cnt2 = new int[9];
	private int[] cnt3 = new int[9];
	private int[] cnt4 = new int[9];
	private int[] cnt5 = new int[9];
	private int[] cnt6 = new int[9];
	private int[] cnt7 = new int[9];
	private int[] cnt8 = new int[9];
	private int[] cnt9 = new int[9];

	private JLabel lblTitle = new JLabel("\uC5D0\uB77C \uBAA8\uB974\uACA0\uB2ED");
	private MaeChul mae = new MaeChul(this);

	public PosMain(PosLogin posLogin) throws IOException {
		DigitClock();
		main_func(posLogin);
		bt_set(posLogin);//버튼 
		bt_init();//버튼 포커스 초기화
		main_bg();//메인배경
	}
	public void bt_set(PosLogin posLogin) {
		calc_bt.setIcon(new ImageIcon(getClass().getClassLoader().getResource("account.png")));

		calc_bt.setBackground(new Color(255, 192, 203));
		calc_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!paytext.getText().equals("") && !sumtext.getText().equals("0")){
					if(!(Integer.parseInt(sumtext.getText())>Integer.parseInt(paytext.getText()))){
						int exchange = Integer.parseInt(paytext.getText())-Integer.parseInt(sumtext.getText());
						chargetext.setText(String.valueOf(exchange));
						JLabel ok_label = new JLabel("계산 완료 !");
						ok_label.setFont(new Font("휴먼옛체", Font.PLAIN, 18));
						String[] bt = {"확인"};
						int ret = JOptionPane.showOptionDialog(null,ok_label,"계산", 
								JOptionPane.OK_OPTION,JOptionPane.INFORMATION_MESSAGE,null,bt,"확인");
						if(ret==JOptionPane.OK_OPTION){
							sumtext.setText("0");
							paytext.setText("");
							chargetext.setText("0");
							table_init(flaginit()+1);
							str="";
						}
						mae.setCnt(cnt);
					}
				}
			}
		});
		calc_bt.setFont(new Font("휴먼옛체", Font.PLAIN, 50));
		calc_bt.setBounds(700, 470, 310, 70);
		getContentPane().add(calc_bt);
		bt_2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("main_2.png")));

		bt_2.setBackground(new Color(255, 192, 203));
		bt_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				str += "2";
				paytext.setText(str);
			}
		});
		bt_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("main_1.png")));
		bt_1.setBackground(new Color(255, 192, 203));
		bt_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				str += "1";
				paytext.setText(str);
			}
		});
		bt_1.setFont(new Font("Berlin Sans FB Demi", Font.BOLD | Font.ITALIC, 30));
		bt_1.setBounds(700, 380, 90, 70);
		getContentPane().add(bt_1);
		bt_2.setFont(new Font("Berlin Sans FB Demi", Font.BOLD | Font.ITALIC, 30));
		bt_2.setBounds(810, 380, 90, 70);
		getContentPane().add(bt_2);
		bt_4.setIcon(new ImageIcon(getClass().getClassLoader().getResource("main_4.png")));

		bt_4.setBackground(new Color(255, 192, 203));
		bt_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				str += "4";
				paytext.setText(str);
			}
		});
		bt_3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("main_3.png")));
		bt_3.setFocusable(false);
		bt_3.setBackground(new Color(255, 192, 203));
		bt_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				str += "3";
				paytext.setText(str);
			}
		});
		bt_3.setFont(new Font("Berlin Sans FB Demi", Font.BOLD | Font.ITALIC, 30));
		bt_3.setBounds(920, 380, 90, 70);
		getContentPane().add(bt_3);

		bt_4.setFont(new Font("Berlin Sans FB Demi", Font.BOLD | Font.ITALIC, 30));
		bt_4.setBounds(700, 300, 90, 70);
		getContentPane().add(bt_4);
		bt_7.setIcon(new ImageIcon(getClass().getClassLoader().getResource("main_7.png")));

		bt_7.setBackground(new Color(255, 192, 203));
		bt_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				str += "7";
				paytext.setText(str);
			}
		});
		bt_5.setIcon(new ImageIcon(getClass().getClassLoader().getResource("main_5.png")));

		bt_5.setBackground(new Color(255, 192, 203));
		bt_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				str += "5";
				paytext.setText(str);
			}
		});
		bt_5.setFont(new Font("Berlin Sans FB Demi", Font.BOLD | Font.ITALIC, 30));
		bt_5.setBounds(810, 300, 90, 70);
		getContentPane().add(bt_5);
		bt_6.setIcon(new ImageIcon(getClass().getClassLoader().getResource("main_6.png")));

		bt_6.setBackground(new Color(255, 192, 203));
		bt_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				str += "6";
				paytext.setText(str);
			}
		});
		bt_6.setFont(new Font("Berlin Sans FB Demi", Font.BOLD | Font.ITALIC, 30));
		bt_6.setBounds(920, 300, 90, 70);
		getContentPane().add(bt_6);
		bt_7.setFont(new Font("Berlin Sans FB Demi", Font.BOLD | Font.ITALIC, 30));
		bt_7.setBounds(700, 220, 90, 70);
		getContentPane().add(bt_7);
		bt_8.setIcon(new ImageIcon(getClass().getClassLoader().getResource("main_8.png")));

		bt_8.setBackground(new Color(255, 192, 203));
		bt_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				str += "8";
				paytext.setText(str);
			}
		});
		bt_8.setFont(new Font("Berlin Sans FB Demi", Font.BOLD | Font.ITALIC, 30));
		bt_8.setBounds(810, 220, 90, 70);
		getContentPane().add(bt_8);
		bt_9.setIcon(new ImageIcon(getClass().getClassLoader().getResource("main_9.png")));

		bt_9.setBackground(new Color(255, 192, 203));
		bt_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				str += "9";
				paytext.setText(str);
			}
		});
		bt_9.setFont(new Font("Berlin Sans FB Demi", Font.BOLD | Font.ITALIC, 30));
		bt_9.setBounds(920, 220, 90, 70);
		getContentPane().add(bt_9);
		bt_0.setIcon(new ImageIcon(getClass().getClassLoader().getResource("main_0.png")));

		bt_0.setBackground(new Color(255, 192, 203));
		bt_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!str.equals("")){
					str += "0";
					paytext.setText(str);
				}
			}
		});
		bt_0.setForeground(Color.BLACK);
		bt_0.setFont(new Font("Berlin Sans FB Demi", Font.BOLD | Font.ITALIC, 30));
		bt_0.setBounds(810, 140, 90, 70);
		getContentPane().add(bt_0);
		bt_bs.setIcon(new ImageIcon(getClass().getClassLoader().getResource("main_bc.png")));

		bt_bs.setBackground(new Color(255, 192, 203));
		bt_bs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(str.length()-1!=-1)
				{str = str.substring(0,str.length()-1);
				paytext.setText(str);
				}
			}
		});
		bt_bs.setFont(new Font("Berlin Sans FB Demi", Font.BOLD | Font.ITALIC, 30));
		bt_bs.setBounds(920, 140, 90, 70);
		getContentPane().add(bt_bs);
		bt_clear.setIcon(new ImageIcon(getClass().getClassLoader().getResource("c.png")));

		bt_clear.setBackground(new Color(255, 192, 203));
		bt_clear.setForeground(Color.RED);
		bt_clear.setFont(new Font("Berlin Sans FB Demi", Font.BOLD | Font.ITALIC, 30));
		bt_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				str = "";
				sumtext.setText("0");
				paytext.setText(str);
				chargetext.setText("0");
			}
		});
		bt_clear.setBounds(700, 140, 90, 70);
		getContentPane().add(bt_clear);
		exit_bt.setIcon(new ImageIcon(getClass().getClassLoader().getResource("main_logout .png")));

		exit_bt.setBackground(new Color(255, 192, 203));
		exit_bt.setFont(new Font("휴먼옛체", Font.PLAIN, 30));
		exit_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel label = new JLabel("정말 종료하시겠습니까?");
				label.setFont(new Font("휴먼옛체", Font.PLAIN, 15));
				int result = JOptionPane.showConfirmDialog(null,label,"종료",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(result==JOptionPane.OK_OPTION){
					System.exit(0);
				}
			}
		});

		exit_bt.setBounds(920, 545, 90, 70);
		getContentPane().add(exit_bt);
		back_bt.setIcon(new ImageIcon(getClass().getClassLoader().getResource("backmenu.png")));
		back_bt.setBackground(new Color(255, 192, 203));
		back_bt.setFont(new Font("휴먼옛체", Font.PLAIN, 26));
		back_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel label = new JLabel("로그인 화면으로 돌아가시겠습니까?");
				label.setFont(new Font("휴먼옛체", Font.PLAIN, 15));
				int result = JOptionPane.showConfirmDialog(null,label,"돌아가기",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(result==JOptionPane.OK_OPTION){

					posLogin.setVisible(true);
					setVisible(false);
				}
			}
		});
		back_bt.setBounds(805, 544, 95, 75);
		getContentPane().add(back_bt);
	}

	public void input_cnt() {
				
	}
	public void main_bg() {
		getContentPane().setBackground(new Color(255, 192, 203));
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("chickenicon.png")));
		this.setUndecorated(true);
		mae.setVisible(false);
		setTitle("POS \uC2DC\uC2A4\uD15C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setSize(1070,920);
		Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize(); //화면 사이즈를 넣어줌		 
		Dimension dimen1 = getSize(); //프레임 사이즈 입력
		int xpos = (int)(dimen.getWidth())/2-(int)dimen1.getWidth()/2; //화면사이즈/2 - 프레임사이즈/2 (화면중앙)		
		int ypos = (int)(dimen.getHeight())/2 -(int)dimen1.getHeight()/2;		
		setLocation(xpos, ypos); //화면중앙에 위치
		setVisible(true);
		setResizable(false);
	}
	public void main_func(PosLogin posLogin){

		chargetext = new JTextField();
		chargetext.setBackground(new Color(255, 192, 203));
		chargetext.setEditable(false);
		chargetext.setFont(new Font("Dialog", Font.BOLD, 45));
		chargetext.setText("0");
		chargetext.setHorizontalAlignment(SwingConstants.RIGHT);
		chargetext.setBounds(769, 791, 241, 70);
		getContentPane().add(chargetext);
		chargetext.setColumns(10);

		paytext = new JTextField();
		paytext.setBackground(new Color(255, 192, 203));
		paytext.setFont(new Font("Dialog", Font.BOLD, 45));
		paytext.setHorizontalAlignment(SwingConstants.RIGHT);
		paytext.setColumns(10);
		paytext.setBounds(769, 711, 241, 70);
		getContentPane().add(paytext);

		label_sum.setForeground(new Color(0, 0, 0));
		label_sum.setHorizontalAlignment(SwingConstants.RIGHT);
		label_sum.setFont(new Font("휴먼엑스포", Font.BOLD, 27));
		label_sum.setBounds(612, 631, 145, 66);
		getContentPane().add(label_sum);

		label_pay.setForeground(new Color(0, 0, 0));
		label_pay.setHorizontalAlignment(SwingConstants.RIGHT);
		label_pay.setFont(new Font("휴먼엑스포", Font.BOLD, 27));
		label_pay.setBounds(612, 711, 145, 66);
		getContentPane().add(label_pay);

		label_charge.setForeground(new Color(0, 0, 0));
		label_charge.setHorizontalAlignment(SwingConstants.RIGHT);
		label_charge.setFont(new Font("휴먼엑스포", Font.BOLD, 27));
		label_charge.setBounds(612, 791, 145, 66);
		getContentPane().add(label_charge);

		sumtext = new JTextField();
		sumtext.setBackground(new Color(255, 192, 203));
		sumtext.setEditable(false);
		sumtext.setFont(new Font("Dialog", Font.BOLD, 45));
		sumtext.setHorizontalAlignment(SwingConstants.RIGHT);
		sumtext.setText("0");
		sumtext.setColumns(10);
		sumtext.setBounds(769, 631, 241, 70);
		getContentPane().add(sumtext);

		panel_1.setLayout(null);
		panel_1.setBackground(new Color(255, 228, 225));
		panel_1.setBounds(50, 20, 960, 108);
		getContentPane().add(panel_1);

		lblTitle.setLocation(128, 0);
		lblTitle.setSize(589, 108);
		lblTitle.setForeground(new Color(186, 85, 211));
		panel_1.add(lblTitle);
		lblTitle.setBackground(Color.WHITE);
		lblTitle.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC, 80));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

		imageURL = getClass().getClassLoader().getResource("aa.gif");
		imageURL1 = getClass().getClassLoader().getResource("gg.gif");
		img = new ImageIcon(imageURL);
		img1 = new ImageIcon(imageURL1);
		Timage1= new JLabel(img1);
		Timage1.setLocation(716, 0);
		Timage1.setSize(187, 108);
		panel_1.add(Timage1);
		Timage = new JLabel(img);
		Timage.setLocation(31, 0);
		Timage.setSize(146, 110);
		panel_1.add(Timage);
		PosMain ps = this;
		bt_sale.setBounds(697, 545, 95, 75);
		getContentPane().add(bt_sale);
		bt_sale.setIcon(new ImageIcon(getClass().getClassLoader().getResource("graph.png")));
		bt_sale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mae.setVisible(true);
				ps.setVisible(false);

			}
		});
		bt_sale.setBackground(new Color(255, 192, 203));

		bt_sale.setFont(new Font("문체부 쓰기 정체", Font.BOLD, 23));
		panel.setBackground(new Color(255, 192, 203));
		panel.setBounds(49, 140, 554, 540);
		panel.setLayout(null);
		getContentPane().add(panel);
		table1.setForeground(new Color(255, 0, 0));
		table1.setBackground(new Color(255, 228, 225));
		table1.setBounds(0, 0, 154, 139);
		panel.add(table1);
		table1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1){
					if(price[0]!=0){
						menuinit(0);	
						sumtext.setText(String.valueOf(price[0]));
					}
				}
				else if(e.getClickCount()==2){
					try {
						new Tables("Table 1번 주문",PosMain.this);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		table1.setFont(new Font("Sitka Small", Font.BOLD, 60));
		table2.setForeground(new Color(255, 69, 0));
		table2.setBackground(new Color(255, 228, 225));
		table2.setBounds(200, 0, 154, 139);
		panel.add(table2);
		table2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1){
					if(price[1]!=0){
						menuinit(1);		
						sumtext.setText(String.valueOf(price[1]));
					}
				}
				else if(e.getClickCount()==2){
					try {
						new Tables("Table 2번 주문",PosMain.this);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		table2.setFont(new Font("Sitka Small", Font.BOLD, 60));
		table3.setForeground(new Color(255, 255, 0));

		table3.setBackground(new Color(255, 228, 225));
		table3.setBounds(400, 0, 154, 139);
		panel.add(table3);
		table3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1){
					if(price[2]!=0){
						menuinit(2);		
						sumtext.setText(String.valueOf(price[2]));
					}
				}
				else if(e.getClickCount()==2){
					try {
						new Tables("Table 3번 주문",PosMain.this);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		table3.setFont(new Font("Sitka Small", Font.BOLD, 60));
		table4.setForeground(new Color(144, 238, 144));

		table4.setBackground(new Color(255, 228, 225));
		table4.setBounds(0, 200, 154, 139);
		panel.add(table4);
		table4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1){
					if(price[3]!=0){
						menuinit(3);	
						sumtext.setText(String.valueOf(price[3]));
					}
				}
				else if(e.getClickCount()==2){
					try {
						new Tables("Table 4번 주문",PosMain.this);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		table4.setFont(new Font("Sitka Small", Font.BOLD, 60));
		table5.setForeground(new Color(0, 128, 128));
		table5.setBackground(new Color(255, 228, 225));
		table5.setBounds(200, 200, 154, 139);
		panel.add(table5);
		table5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1){
					if(price[4]!=0){
						menuinit(4);	
						sumtext.setText(String.valueOf(price[4]));
					}
				}
				if(e.getClickCount()==2){
					try {
						new Tables("Table 5번 주문",PosMain.this);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		table5.setFont(new Font("Sitka Small", Font.BOLD, 60));
		table6.setForeground(new Color(0, 0, 255));
		table6.setBackground(new Color(255, 228, 225));
		table6.setBounds(400, 200, 154, 139);
		panel.add(table6);
		table6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1){
					if(price[5]!=0){
						menuinit(5);		
						sumtext.setText(String.valueOf(price[5]));
					}
				}
				if(e.getClickCount()==2){
					try {
						new Tables("Table 6번 주문",PosMain.this);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		table6.setFont(new Font("Sitka Small", Font.BOLD, 60));
		table7.setForeground(new Color(25, 25, 112));
		table7.setBackground(new Color(255, 228, 225));
		table7.setBounds(0, 401, 154, 139);
		panel.add(table7);
		table7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1){
					if(price[6]!=0){
						menuinit(6);		
						sumtext.setText(String.valueOf(price[6]));
					}
				}
				else if(e.getClickCount()==2){
					try {
						new Tables("Table 7번 주문",PosMain.this);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		table7.setFont(new Font("Sitka Small", Font.BOLD, 60));
		table8.setForeground(new Color(255, 105, 180));

		table8.setBackground(new Color(255, 228, 225));
		table8.setBounds(200, 401, 154, 139);
		panel.add(table8);
		table8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1){
					if(price[7]!=0){
						menuinit(7);	
						sumtext.setText(String.valueOf(price[7]));
					}
				}
				if(e.getClickCount()==2){
					try {
						new Tables("Table 8번 주문",PosMain.this);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		table8.setFont(new Font("Sitka Small", Font.BOLD, 60));
		table9.setForeground(new Color(138, 43, 226));
		table9.setBackground(new Color(255, 228, 225));
		table9.setBounds(400, 401, 154, 139);
		panel.add(table9);
		table9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1){
					if(price[8]!=0){
						menuinit(8);		
						sumtext.setText(String.valueOf(price[8]));
					}
				}
				if(e.getClickCount()==2){
					try {
						new Tables("Table 9번 주문",PosMain.this);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		table9.setFont(new Font("Sitka Small", Font.BOLD, 60));
	}
	public void DigitClock(){
		clock = new JLabel();
		clock.setForeground(new Color(0, 0, 0));
		clock.setBackground(Color.GRAY);
		clock.setFont(new Font("휴먼편지체", Font.BOLD, 35));
		clock.setBounds(50, 692, 554, 131);
		dayTime = new SimpleDateFormat("YYYY년 MM월 dd일 hh시 mm분 ss초");
		if(thread == null){
			thread = new Thread(this);
			thread.start();
		}
		getContentPane().add(clock);
	}
	public void run() {
		while (true) {
			clock.setText(dayTime.format(new Date()));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e){}
		}
	}
	public void menuinit(int i){
		paytext.setText("");	
		chargetext.setText("0");
		str="";
		tableflag[i]=true;
	}
	public void bt_init(){
		table1.setFocusable(false);
		table2.setFocusable(false);
		table3.setFocusable(false);
		table4.setFocusable(false);
		table5.setFocusable(false);
		table6.setFocusable(false);
		table7.setFocusable(false);
		table8.setFocusable(false);
		table9.setFocusable(false);
		bt_1.setFocusable(false);
		bt_2.setFocusable(false);
		bt_3.setFocusable(false);
		bt_4.setFocusable(false);
		bt_5.setFocusable(false);
		bt_6.setFocusable(false);
		bt_7.setFocusable(false);
		bt_8.setFocusable(false);
		bt_9.setFocusable(false);
		bt_0.setFocusable(false);
		bt_bs.setFocusable(false);
		bt_clear.setFocusable(false);
		calc_bt.setFocusable(false);
		exit_bt.setFocusable(false);
		back_bt.setFocusable(false);		
		sumtext.setFocusable(false);
		chargetext.setFocusable(false);
		bt_sale.setFocusable(false);
	}
	public int flaginit() {
		int flag=0;
		for(int i=0;i<9;i++){
			if(tableflag[i]){
				flag=i;
				tableflag[i]=false;
			}
		}
		return flag;
	}
	public void table_init(int flag) {
		if(flag==1){
			table1.setText("1");
			table1.setFont(new Font("Sitka Small", Font.BOLD, 60));
			table1.setForeground(Color.BLACK);
			table1.setHorizontalAlignment(SwingConstants.CENTER);
			price[0]=0;
			cnt=cnt1;
		}
		else if(flag==2){
			table2.setText("2");
			table2.setFont(new Font("Sitka Small", Font.BOLD, 60));
			table2.setForeground(Color.BLACK);
			table2.setHorizontalAlignment(SwingConstants.CENTER);
			price[1]=0;
			cnt=cnt2;
		}
		else if(flag==3){
			table3.setText("3");
			table3.setFont(new Font("Sitka Small", Font.BOLD, 60));
			table3.setForeground(Color.BLACK);
			table3.setHorizontalAlignment(SwingConstants.CENTER);
			price[2]=0;
			cnt=cnt3;
		}
		else if(flag==4){
			table4.setText("4");
			table4.setFont(new Font("Sitka Small", Font.BOLD, 60));
			table4.setForeground(Color.BLACK);
			table4.setHorizontalAlignment(SwingConstants.CENTER);
			price[3]=0;
			cnt=cnt4;
		}
		else if(flag==5){
			table5.setText("5");
			table5.setFont(new Font("Sitka Small", Font.BOLD, 60));
			table5.setForeground(Color.BLACK);
			table5.setHorizontalAlignment(SwingConstants.CENTER);
			price[4]=0;
			cnt=cnt5;
		}
		else if(flag==6){
			table6.setText("6");
			table6.setFont(new Font("Sitka Small", Font.BOLD, 60));
			table6.setForeground(Color.BLACK);
			table6.setHorizontalAlignment(SwingConstants.CENTER);
			price[5]=0;
			cnt=cnt6;
		}
		else if(flag==7){
			table7.setText("7");
			table7.setFont(new Font("Sitka Small", Font.BOLD, 60));
			table7.setForeground(Color.BLACK);
			table7.setHorizontalAlignment(SwingConstants.CENTER);
			price[6]=0;
			cnt=cnt7;
		}
		else if(flag==8){
			table8.setText("8");
			table8.setFont(new Font("Sitka Small", Font.BOLD, 60));
			table8.setForeground(Color.BLACK);
			table8.setHorizontalAlignment(SwingConstants.CENTER);
			price[7]=0;
			cnt=cnt8;
		}
		else{
			table9.setText("9");
			table9.setFont(new Font("Sitka Small", Font.BOLD, 60));
			table9.setForeground(Color.BLACK);
			table9.setHorizontalAlignment(SwingConstants.CENTER);
			price[8]=0;
			cnt=cnt9;
		}
	}
	public void setCnt(int i, int count,int table) {

		if(table==1){
			cnt1[i] = count;
		}
		else if(table==2){
			cnt2[i] = count;
		}
		else if(table==3){
			cnt3[i] = count;
		}
		else if(table==4){
			cnt4[i] = count;
		}
		else if(table==5){
			cnt5[i] = count;
		}
		else if(table==6){
			cnt6[i] = count;
		}
		else if(table==7){
			cnt7[i] = count;
		}
		else if(table==8){
			cnt8[i] = count;
		}
		else if(table==9){
			cnt9[i] = count;
		}

	}
	public void setTable1(String str,int price) {
		table1.setText(str);
		table1.setFont(new Font("문체부 쓰기 정체",Font.BOLD, 14));
		table1.setForeground(Color.BLACK);
		table1.setHorizontalAlignment(SwingConstants.LEFT);
		this.price[0]=price;
	}
	public void setTable2(String str,int price) {
		table2.setText(str);
		table2.setFont(new Font("문체부 쓰기 정체",Font.BOLD, 14));
		table2.setForeground(Color.BLACK);
		table2.setHorizontalAlignment(SwingConstants.LEFT);
		this.price[1]=price;
	}
	public void setTable3(String str,int price) {
		table3.setText(str);
		table3.setFont(new Font("문체부 쓰기 정체",Font.BOLD, 14));
		table3.setForeground(Color.BLACK);
		table3.setHorizontalAlignment(SwingConstants.LEFT);
		this.price[2]=price;
	}
	public void setTable4(String str,int price) {
		table4.setText(str);
		table4.setFont(new Font("문체부 쓰기 정체", Font.BOLD, 14));
		table4.setForeground(Color.BLACK);
		table4.setHorizontalAlignment(SwingConstants.LEFT);
		this.price[3]=price;
	}
	public void setTable5(String str,int price) {
		table5.setText(str);
		table5.setFont(new Font("문체부 쓰기 정체",Font.BOLD, 14));
		table5.setForeground(Color.BLACK);
		table5.setHorizontalAlignment(SwingConstants.LEFT);
		this.price[4]=price;
	}
	public void setTable6(String str,int price) {
		table6.setText(str);
		table6.setFont(new Font("문체부 쓰기 정체",Font.BOLD, 14));
		table6.setForeground(Color.BLACK);
		table6.setHorizontalAlignment(SwingConstants.LEFT);
		this.price[5]=price;
	}
	public void setTable7(String str,int price) {
		table7.setText(str);
		table7.setFont(new Font("문체부 쓰기 정체",Font.BOLD, 14));
		table7.setForeground(Color.BLACK);
		table7.setHorizontalAlignment(SwingConstants.LEFT);
		this.price[6]=price;
	}
	public void setTable8(String str,int price) {
		table8.setText(str);
		table8.setFont(new Font("문체부 쓰기 정체",Font.BOLD, 14));
		table8.setForeground(Color.BLACK);
		table8.setHorizontalAlignment(SwingConstants.LEFT);
		this.price[7]=price;
	}
	public void setTable9(String str,int price) {
		table9.setText(str);
		table9.setFont(new Font("문체부 쓰기 정체",Font.BOLD, 14));
		table9.setForeground(Color.BLACK);
		table9.setHorizontalAlignment(SwingConstants.LEFT);
		this.price[8]=price;
	}
}