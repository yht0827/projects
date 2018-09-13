package Pos;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;

public class MaeChul extends JFrame {


	private int cnt[] = new int[9];
	private JLabel Timage;
	private ImageIcon img = null;
	private URL imageURL;
	
	public void setCnt(int[] cnt) {
		for(int i=0;i<9;i++){
			this.cnt[i]+=cnt[i];
		}
	}
	public MaeChul(PosMain posMain) {
		setBackground(new Color(255, 192, 203));
		this.setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("chickenicon.png")));

		getContentPane().setBackground(new Color(255, 192, 203));
		setTitle("\uC77C\uC77C \uB9E4\uCD9C");
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(255, 192, 203));
		panel1.setLayout(null);
		panel1.setBounds(24, 17, 844, 394);
		getContentPane().add(panel1);
		Container contentPane = getContentPane();
		graphicPanel drawingPanel = new graphicPanel();
		drawingPanel.setSize(880, 900);
		contentPane.setLayout(null);
		panel1.add(drawingPanel);
		
		imageURL = getClass().getClassLoader().getResource("kk.gif");
		img = new ImageIcon(imageURL);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));
		panel.setLayout(null);
		panel.setBounds(18, 423, 850, 159);
		getContentPane().add(panel);
		Timage= new JLabel(img);
		Timage.setBounds(257, 6, 234, 135);
		panel.add(Timage);
		JButton bt_re = new JButton("\uC774\uC804 \uD654\uBA74");
		bt_re.setFont(new Font("휴먼옛체", Font.PLAIN, 26));
		bt_re.setBounds(88, 49, 158, 46);
		panel.add(bt_re);
		bt_re.setBackground(new Color(250, 235, 215));
		bt_re.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				posMain.setVisible(true);
			}
		});
		bt_re.setFocusable(false);
		
		JLabel lblNewLabel = new JLabel(" \uB9E4\uCD9C \uC21C\uC704");
		lblNewLabel.setForeground(new Color(148, 0, 211));
		lblNewLabel.setFont(new Font("휴먼편지체", Font.BOLD, 60));
		lblNewLabel.setBounds(496, 22, 326, 118);
		panel.add(lblNewLabel);
		setSize(900,600);
		Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize(); //화면 사이즈를 넣어줌		 
		Dimension dimen1 = getSize(); //프레임 사이즈 입력
		int xpos = (int)(dimen.getWidth())/2-(int)dimen1.getWidth()/2; //화면사이즈/2 - 프레임사이즈/2 (화면중앙)		
		int ypos = (int)(dimen.getHeight())/2 -(int)dimen1.getHeight()/2;		
		setLocation(xpos, ypos); //화면중앙에 위치
		setVisible(true);
		setResizable(false);
	}
	class graphicPanel extends JPanel
	{
		public void paint(Graphics g){
			
			g.clearRect(0,0,getWidth(),getHeight());
			g.drawLine(50,350,780,350);//가장 밑에 줄
			for(int cnt = 1 ;cnt<12;cnt++)
			{
				Font font = new Font("Sitka Small", Font.BOLD, 20);
				g.setFont(font);
				g.drawString(cnt *1 +" ",20,357-30*cnt);   //그래프 옆 숫자
				g.drawLine(50, 350-30*cnt, 780,350-30*cnt);//그래프표 줄 
			}
			g.drawLine(50,20,50,350); // 맨 왼쪽 숫자옆줄 
			g.drawLine(780,20,780,350); // 맨 오른쪽 줄 
			Font font = new Font("휴먼모음T", Font.BOLD, 20);
			g.setFont(font);
			g.setColor(Color.RED);
			g.drawString("후라이드",60,370);
			g.setColor(new Color(0xFFFF4500));
			g.drawString("양념치킨",140,370);
			g.setColor(Color.YELLOW);
			g.drawString("옛날통닭",220,370);
			g.setColor(new Color(0xFF32CD32));
			g.drawString("양파치킨",300,370);
			g.setColor(new Color(0xFF1E90FF));
			g.drawString("순살일반",380,370);
			g.setColor(new Color(0xFF00008B));
			g.drawString("순살양념",460,370);
			g.setColor(new Color(0xFF800080));
			g.drawString("반반치킨",540,370);
			g.setColor(new Color(0xFFDDA0DD));
			g.drawString("순살반반",620,370);
			g.setColor(new Color(0xFFFFDAB9));
			g.drawString("간장치킨",700,370);
			draw(g);
		}
		public void draw(Graphics g) {
			if (cnt[0]>0){
				g.setColor(Color.RED);
				g.fillRect(70,350-cnt[0]*30,40,cnt[0]*30);}
			if(cnt[1]>0){
				g.setColor(new Color(0xFFFF4500));
				g.fillRect(150,350-cnt[1]*30,40,cnt[1]*30);}
			if(cnt[2]>0){
				g.setColor(Color.YELLOW);
				g.fillRect(230,350-cnt[2]*30,40,cnt[2]*30);}
			if(cnt[3]>0){
				g.setColor(new Color(0xFF32CD32));
				g.fillRect(310,350-cnt[3]*30,40,cnt[3]*30);}
			if(cnt[4]>0){
				g.setColor(new Color(0xFF1E90FF));
				g.fillRect(390,350-cnt[4]*30,40,cnt[4]*30);}
			if(cnt[5]>0){
				g.setColor(new Color(0xFF00008B));
				g.fillRect(470,350-cnt[5]*30,40,cnt[5]*30);}
			if(cnt[6]>0){
				g.setColor(new Color(0xFF800080));
				g.fillRect(550,350-cnt[6]*30,40,cnt[6]*30);}
			if(cnt[7]>0){
				g.setColor(new Color(0xFFDDA0DD));
				g.fillRect(630,350-cnt[7]*30,40,cnt[7]*30);}
			if(cnt[8]>0){
				g.setColor(new Color(0xFFFFDAB9));
				g.fillRect(710,350-cnt[8]*30,40,cnt[8]*30);}
		}
	}
}