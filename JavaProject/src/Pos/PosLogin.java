package Pos;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;

import javax.swing.JPanel;

public class PosLogin extends JFrame {

	private JTextField tfid;
	private JPasswordField tfpwd;
	private JButton bt_1 = new JButton("");
	private JButton bt_2 = new JButton("");
	private JButton bt_3 = new JButton("");
	private JButton bt_4 = new JButton("");
	private JButton bt_5 = new JButton("");
	private JButton bt_6 = new JButton("");
	private JButton bt_7 = new JButton("");
	private JButton bt_8 = new JButton("");
	private JButton bt_9 = new JButton("");
	private JButton bt_C = new JButton("");
	private JButton bt_0 = new JButton("");
	private JButton bt_back = new JButton("");
	private JButton bt_exit = new JButton("");
	private JButton bt_ok = new JButton("");
	private String str="";
	private JLabel lblMadeBy = new JLabel("Made by YHT");
	private JLabel lbTitle = new JLabel("LOGIN");
	private PosMain ps;
	private JLabel Timage;
	private ImageIcon img = null;
	private URL imageURL;
	private final JPanel panel2 = new JPanel();

	public PosLogin(){
		super("POS");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("chickenicon.png")));
		getContentPane().setBackground(new Color(255, 192, 203));
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		}
		
		login_bt();//로그인 창
		ok_exit_bt();//확인,종료
		num_bt();//숫자버튼
		background();//배경
	}
	public void wrong_dialog(String str){
		JLabel label = new JLabel(str);
		label.setFont(new Font("휴먼옛체", Font.PLAIN , 15));
		JOptionPane.showMessageDialog(null,label,"비밀번호 오류",JOptionPane.PLAIN_MESSAGE);
		tfid.setText("Admin");
		tfpwd.setText("");
	}
	public void correct_dialog(String str){
		JLabel label = new JLabel(str);
		label.setFont(new Font("휴먼옛체", Font.PLAIN, 15));
		JOptionPane.showMessageDialog(null,label,"로그인 성공",JOptionPane.PLAIN_MESSAGE);
	}
	public void login_bt(){

		getContentPane().setFont(new Font("굴림", Font.PLAIN, 12));
		setTitle("POS \uB85C\uADF8\uC778");
		getContentPane().setLayout(null);
	}
	public void ok_exit_bt(){
		bt_ok.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ok_login.png")));
		bt_ok.setBounds(280, 204, 90, 66);
		panel2.setBackground(new Color(255, 255, 224));
		panel2.add(bt_ok);
		bt_ok.setFont(new Font("휴먼옛체", Font.BOLD, 20));
		bt_ok.setBackground(new Color(250, 235, 215));

		bt_ok.setForeground(new Color(0, 0, 0));
		bt_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account db = new Account();
				@SuppressWarnings("deprecation")
				String pwd = tfpwd.getText(); 
				
				if(!pwd.equals(db.getStrpwd())){
					wrong_dialog("비밀번호를 다시 입력하세요.");
					str="";
				}
				else{//성공
					correct_dialog("로그인 성공! 반갑습니다.");	
					if(ps==null){//객체가 생성되기 전 로그인시
						try {
							ps = new PosMain(PosLogin.this);
							tfpwd.setText("");
							str="";
						} catch (IOException e1) {
						}
					}
					else{//객체 생성되어서 로그인시
						ps.setVisible(true);
						tfpwd.setText("");
						str="";
					}
					setVisible(false);
				}
			}
		});
		bt_exit.setIcon(new ImageIcon(getClass().getClassLoader().getResource("logout_img.png")));
		bt_exit.setBounds(430, 204, 90, 66);
		panel2.add(bt_exit);
		bt_exit.setFont(new Font("휴먼옛체", Font.BOLD, 20));
		bt_exit.setForeground(new Color(0, 0, 0));
		bt_exit.setBackground(new Color(250, 235, 215));
		bt_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel label = new JLabel("정말 종료 하시겠습니까?");
				label.setFont(new Font("휴먼옛체", Font.PLAIN, 15));
				int result = JOptionPane.showConfirmDialog(null,label,"종료",
								JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(result==JOptionPane.OK_OPTION){
					System.exit(0);
				}
			}
		});
	}
	public void num_bt(){
		bt_1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("1.png")));
		bt_1.setBounds(29, 162, 55, 55);
		panel2.add(bt_1);
		bt_1.setForeground(new Color(255, 105, 180));
		bt_1.setBackground(new Color(250, 235, 215));
		bt_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				str += "1";
				tfpwd.setText(str);
			}
		});
		bt_1.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 30));
		bt_2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("2.png")));
		bt_2.setBounds(104, 162, 55, 55);
		panel2.add(bt_2);
		bt_2.setForeground(new Color(255, 105, 180));
		bt_2.setBackground(new Color(250, 235, 215));
		bt_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				str += "2";
				tfpwd.setText(str);
			}
		});
		bt_2.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 30));
		
		bt_3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("3.png")));
		bt_3.setBounds(179, 162, 55, 55);
		panel2.add(bt_3);
		bt_3.setForeground(new Color(255, 105, 180));
		bt_3.setBackground(new Color(250, 235, 215));
		bt_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				str += "3";
				tfpwd.setText(str);
			}
		});
		bt_3.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 30));
		bt_4.setIcon(new ImageIcon(getClass().getClassLoader().getResource("4.png")));
		bt_4.setBounds(29, 92, 55, 55);
		panel2.add(bt_4);
		bt_4.setForeground(new Color(255, 105, 180));
		bt_4.setBackground(new Color(250, 235, 215));
		bt_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				str += "4";
				tfpwd.setText(str);
			}
		});
		bt_4.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 30));
		bt_5.setIcon(new ImageIcon(getClass().getClassLoader().getResource("5.png")));
		bt_5.setBounds(104, 92, 55, 55);
		panel2.add(bt_5);
		bt_5.setForeground(new Color(255, 105, 180));
		bt_5.setBackground(new Color(250, 235, 215));
		bt_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				str += "5";
				tfpwd.setText(str);
			}
		});
		bt_5.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 30));
		bt_6.setIcon(new ImageIcon(getClass().getClassLoader().getResource("6.png")));
		bt_6.setBounds(179, 92, 55, 55);
		panel2.add(bt_6);
		bt_6.setForeground(new Color(255, 105, 180));
		bt_6.setBackground(new Color(250, 235, 215));
		bt_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				str += "6";
				tfpwd.setText(str);
			}
		});
		bt_6.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 30));
		bt_7.setIcon(new ImageIcon(getClass().getClassLoader().getResource("7.png")));
		bt_7.setBounds(29, 22, 55, 55);
		panel2.add(bt_7);
		bt_7.setForeground(new Color(255, 105, 180));
		bt_7.setBackground(new Color(250, 235, 215));
		bt_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				str += "7";
				tfpwd.setText(str);
			}
		});
		bt_7.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 30));
		bt_8.setIcon(new ImageIcon(getClass().getClassLoader().getResource("8.png")));
		bt_8.setBounds(104, 22, 55, 55);
		panel2.add(bt_8);
		bt_8.setForeground(new Color(255, 105, 180));
		bt_8.setBackground(new Color(250, 235, 215));
		bt_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				str += "8";
				tfpwd.setText(str);
			}
		});
		bt_8.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 30));
		bt_9.setIcon(new ImageIcon(getClass().getClassLoader().getResource("9.png")));
		bt_9.setBounds(179, 22, 55, 55);
		panel2.add(bt_9);
		bt_9.setForeground(new Color(255, 105, 180));
		bt_9.setBackground(new Color(250, 235, 215));
		bt_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				str += "9";
				tfpwd.setText(str);
			}
		});
		bt_9.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 30));
		bt_0.setIcon(new ImageIcon(getClass().getClassLoader().getResource("0.png")));
		bt_0.setBounds(104, 232, 55, 55);
		panel2.add(bt_0);
		bt_0.setForeground(new Color(255, 105, 180));
		bt_0.setBackground(new Color(250, 235, 215));
		bt_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				str += "0";
				tfpwd.setText(str);
			}
		});
		bt_0.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 30));
		bt_C.setIcon(new ImageIcon(getClass().getClassLoader().getResource("c.png")));
		bt_C.setBounds(29, 232, 55, 55);
		panel2.add(bt_C);
		bt_C.setBackground(new Color(250, 235, 215));
		bt_C.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				str = "";
				tfpwd.setText(str);
			}
		});
		bt_C.setFont(new Font("Papyrus", Font.BOLD, 20));
		bt_C.setForeground(new Color(255, 105, 180));
		bt_back.setIcon(new ImageIcon(getClass().getClassLoader().getResource("back.png")));
		bt_back.setBounds(179, 232, 55, 55);
		panel2.add(bt_back);
		bt_back.setForeground(new Color(255, 105, 180));
		bt_back.setBackground(new Color(250, 235, 215));

		bt_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(str.length()-1!=-1)
				{str = str.substring(0,str.length()-1);
				tfpwd.setText(str);
				}
			}
		});
		bt_back.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 21));
	}
	public void focus(){
		bt_7.setFocusable(false);
		bt_8.setFocusable(false);
		bt_9.setFocusable(false);
		tfid.setFocusable(false);
		bt_4.setFocusable(false);
		bt_5.setFocusable(false);
		bt_6.setFocusable(false);
		bt_1.setFocusable(false);
		bt_2.setFocusable(false);
		bt_3.setFocusable(false);
		bt_0.setFocusable(false);
		bt_exit.setFocusable(false);
		bt_ok.setFocusable(false);
		tfpwd.setFocusable(true);
		bt_C.setFocusable(false);
		bt_back.setFocusable(false);
	}
	public void background(){
		lblMadeBy.setForeground(new Color(0, 0, 0));
		lblMadeBy.setBounds(399, 280, 144, 25);
		panel2.add(lblMadeBy);

		lblMadeBy.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		
		
		imageURL = getClass().getClassLoader().getResource("login.gif");
		img = new ImageIcon(imageURL);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 224));
		panel.setLayout(null);
		panel.setBounds(63, 34, 550, 108);
		getContentPane().add(panel);
		Timage = new JLabel(img);
		Timage.setBounds(0, 0, 158, 108);
		panel.add(Timage);
		Timage.setBackground(Color.WHITE);
		lbTitle.setForeground(new Color(255, 105, 180));
		lbTitle.setBounds(152, 0, 398, 108);
		panel.add(lbTitle);
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setFont(new Font("Papyrus", Font.BOLD, 75));
		
		panel2.setLayout(null);
		panel2.setBounds(60, 172, 553, 303);
		getContentPane().add(panel2);
		JLabel lbid = new JLabel("\uC544\uC774\uB514");
		lbid.setForeground(new Color(0, 0, 0));
		lbid.setBounds(279, 10, 109, 41);
		panel2.add(lbid);
		lbid.setFont(new Font("휴먼편지체", Font.BOLD, 35));
		
				JLabel lbpwd = new JLabel("\uBE44\uBC00\uBC88\uD638");
				lbpwd.setForeground(new Color(0, 0, 0));
				lbpwd.setBounds(279, 110, 156, 41);
				panel2.add(lbpwd);
				lbpwd.setFont(new Font("휴먼편지체", Font.BOLD, 35));
				
						tfid = new JTextField();
						tfid.setForeground(new Color(255, 105, 180));
						tfid.setBounds(280, 60, 240, 40);
						panel2.add(tfid);
						tfid.setFont(new Font("Chiller", Font.BOLD | Font.ITALIC, 55));
						tfid.setBackground(new Color(250, 235, 215));
						tfid.setEditable(false);
						tfid.setText("Admin");
						tfid.setColumns(10);
						
								tfpwd = new JPasswordField();
								tfpwd.setForeground(new Color(255, 105, 180));
								tfpwd.setBounds(280, 160, 240, 40);
								panel2.add(tfpwd);
								tfpwd.setFont(new Font("SansSerif", Font.PLAIN, 23));
								tfpwd.setBackground(new Color(250, 235, 215));
		setSize(670,540);
		Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize(); //화면 사이즈를 넣어줌		 
		Dimension dimen1 = getSize(); //프레임 사이즈 입력
		int xpos = (int)(dimen.getWidth())/2-(int)dimen1.getWidth()/2; //화면사이즈/2 - 프레임사이즈/2 (화면중앙)		
		int ypos = (int)(dimen.getHeight())/2 -(int)dimen1.getHeight()/2;		
		this.setUndecorated(true);
		setLocation(xpos, ypos); //화면중앙에 위치
		setVisible(true);
		setResizable(false);
		focus();
	}
}