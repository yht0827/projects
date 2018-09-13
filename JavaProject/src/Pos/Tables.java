package Pos;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

public class Tables extends JFrame{
	
	private JButton menu1 = new JButton("");
	private JButton menu2 = new JButton("");
	private JButton menu3 = new JButton("");
	private JButton menu4 = new JButton("");
	private JButton menu5 = new JButton("");
	private JButton menu6 = new JButton("");
	private JButton menu7 = new JButton("");
	private JButton menu8 = new JButton("");
	private JButton menu9 = new JButton("");
	private JButton mainmenubt = new JButton("\uBA54\uC778");
	private JButton sidemenubt = new JButton("\uC0AC\uC774\uB4DC");
	private JButton drinkbt = new JButton("\uC74C\uB8CC");
	private JButton sojubt = new JButton("\uC8FC\uB958");
	private JButton anjubt = new JButton("\uC548\uC8FC");
	private JButton order_bt = new JButton("\uC8FC \uBB38");
	private JButton cancel_bt = new JButton("\uCDE8 \uC18C");
	
	private JLabel Timage;
	private JLabel Timage1;
	private JLabel[][] menuimg = new JLabel[5][9];
	private JLabel title_label = new JLabel("\uBD84\uB958");
	private JLabel menu_label = new JLabel("\uBA54\uB274");
	private JLabel tablename_label;
	private JLabel order_label = new JLabel("\uC7A5\uBC14\uAD6C\uB2C8");
	
	private JPanel[] menuframe = new JPanel[9];
	private JPanel menu_panel = new JPanel();
	private JPanel food_panel = new JPanel();
	private JPanel title_table = new JPanel();
	
	private JTable jTable;

	private URL imageURL;
	private URL imageURL1;
	private URL imageURL2;
	
	private ImageIcon img = null;
	private ImageIcon img1 = null;
	private ImageIcon img2 = null;
	
	private String[][] menu;
	private String[][] price;
	private String[][] pic;
	private String order="";
	
	private DefaultTableModel model;
	private JScrollPane jScollPane;
	
	private boolean[] flag = new boolean[5];
	private int[][] cnt = new int[5][9];
	private int[][] num = new int[5][9];
	private int sumprice=0;

	public Tables(String str, PosMain posmain) throws IOException {
		table_bg(str);
		menuset(str);
		menuimage();
		menu_bt(str,posmain);
		jtableset();		
	}
	
	private void table_bg(String str) {	
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("chickenicon.png")));
		getContentPane().setBackground(new Color(255, 192, 203));
		getContentPane().setLayout(null);
		this.setUndecorated(true);	
		TableMenu tm = new TableMenu();
		this.menu=tm.menu();
		this.price = tm.price();
		this.pic=tm.pic();
		
		title_table.setLayout(null);
		title_table.setBackground(new Color(255, 255, 224));
		title_table.setBounds(12, 26, 1141, 95);
		getContentPane().add(title_table);
		imageURL1 =getClass().getClassLoader().getResource("zz.gif");
		img1 = new ImageIcon(imageURL1);
		Timage= new JLabel(img1);
		Timage.setLocation(684, 0);
		Timage.setSize(135, 95);
		title_table.add(Timage);
		
		imageURL2 =getClass().getClassLoader().getResource("pp.gif");
		img2 = new ImageIcon(imageURL2);
		Timage1= new JLabel(img2);
		Timage1.setLocation(158, 0);
		Timage1.setSize(135, 95);
		title_table.add(Timage1);
		
		order_label.setBackground(new Color(255, 255, 224));
		order_label.setHorizontalAlignment(SwingConstants.CENTER);
		order_label.setFont(new Font("휴먼편지체", Font.BOLD, 50));
		order_label.setForeground(new Color(0, 0, 0));
		order_label.setBounds(782, 135, 371, 63);
		getContentPane().add(order_label);

		setTitle(str);
		setResizable(false);
		setVisible(true);
		setSize(1170,850);
		Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize(); //화면 사이즈를 넣어줌		 
		Dimension dimen1 = getSize(); //프레임 사이즈 입력
		int xpos = (int)(dimen.getWidth())/2-(int)dimen1.getWidth()/2; //화면사이즈/2 - 프레임사이즈/2 (화면중앙)		
		int ypos = (int)(dimen.getHeight())/2 -(int)dimen1.getHeight()/2-20;		
		setLocation(xpos, ypos); //화면중앙에 위치
	}
	private void jtableset() {
		String columnNames[] =
			{ };

		Object rowData[][] =
			{};
		jTable = new JTable(rowData, columnNames);
		jTable.setBackground(new Color(255, 255, 224));
		jTable.setShowVerticalLines(false);
		jTable.setShowHorizontalLines(false);
		jTable.setShowGrid(false);
		jTable.setForeground(new Color(0, 0, 0));
		jTable.setFont(new Font("휴먼편지체", Font.BOLD, 30));
		jTable.setModel(model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"\uBA54\uB274", "\uC218\uB7C9"
				}
				));
		jTable.getColumnModel().getColumn(0).setPreferredWidth(120);
		jTable.getColumnModel().getColumn(0).setMinWidth(120);
		jTable.getColumnModel().getColumn(1).setPreferredWidth(50);
		jTable.getColumnModel().getColumn(1).setMinWidth(50);
		jTable.setRowHeight(40); 
		
		jScollPane = new JScrollPane(jTable);
		jScollPane.getViewport().setBackground(new Color(255, 255, 224));
		jScollPane.setLocation(782, 208);
		jScollPane.setSize(371, 469);
		getContentPane().add(jScollPane);
		jScollPane.setPreferredSize(new Dimension(470,400));
		
		menu_label.setBackground(new Color(255, 255, 224));
		menu_label.setForeground(new Color(0, 0, 0));
		menu_label.setFont(new Font("휴먼편지체", Font.BOLD, 50));
		menu_label.setHorizontalAlignment(SwingConstants.CENTER);
		menu_label.setBounds(236, 135, 534, 63);
		getContentPane().add(menu_label);
	}
	private void menuset(String str) {
		
		tablename_label = new JLabel(str.substring(6,8)+" \uD14C\uC774\uBE14");
		tablename_label.setForeground(new Color(0, 0, 0));
		tablename_label.setFont(new Font("맑은 고딕", Font.BOLD | Font.ITALIC, 65));
		tablename_label.setBounds(336, 9, 373, 75);
		title_table.add(tablename_label);
		
		menu_panel.setBackground(new Color(255, 255, 224));
		menu_panel.setBounds(12, 208, 212, 584);
		getContentPane().add(menu_panel);
		menu_panel.setLayout(null);
	
		title_label.setBackground(new Color(255, 255, 224));
		title_label.setForeground(new Color(0, 0, 0));
		title_label.setHorizontalAlignment(SwingConstants.CENTER);
		title_label.setFont(new Font("휴먼편지체", Font.BOLD, 50));
		title_label.setBounds(12, 135, 212, 63);
		getContentPane().add(title_label);
		
		food_panel.setLayout(null);
		food_panel.setBackground(new Color(255, 255, 224));
		food_panel.setBounds(236, 208, 534, 584);
		getContentPane().add(food_panel);		
		menu2.setForeground(new Color(0, 0, 0));
		menu2.setBackground(new Color(255, 218, 185));
		menu2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!menu2.getText().equals("")){
					if(e.getClickCount()==1){
						tableshow(1);
					}
				}
			}
		});
		menu2.setFont(new Font("휴먼편지체", Font.BOLD, 18));
		menu2.setBounds(190, 120, 160, 70);
		food_panel.add(menu2);
		menu3.setForeground(new Color(0, 0, 0));
		menu3.setBackground(new Color(255, 218, 185));
		menu3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!menu3.getText().equals("")){
					if(e.getClickCount()==1){
						tableshow(2);
					}
				}
			}
		});
		menu3.setFont(new Font("휴먼편지체", Font.BOLD, 18));
		menu3.setBounds(370, 120, 160, 70);
		food_panel.add(menu3);
		menu4.setForeground(new Color(0, 0, 0));
		menu4.setBackground(new Color(255, 218, 185));
		menu4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!menu4.getText().equals("")){
					if(e.getClickCount()==1){
						tableshow(3);
					}
				}
			}
		});
		menu4.setFont(new Font("휴먼편지체", Font.BOLD, 18));
		menu4.setBounds(10, 320, 160, 70);
		food_panel.add(menu4);
		menu5.setForeground(new Color(0, 0, 0));
		menu5.setBackground(new Color(255, 218, 185));
		menu5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!menu5.getText().equals("")){
					if(e.getClickCount()==1){
						tableshow(4);
					}
				}
			}
		});
		menu5.setFont(new Font("휴먼편지체", Font.BOLD, 18));
		menu5.setBounds(190, 320, 160, 70);
		food_panel.add(menu5);
		menu6.setForeground(new Color(0, 0, 0));
		menu6.setBackground(new Color(255, 218, 185));
		menu6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!menu6.getText().equals("")){
					if(e.getClickCount()==1){
						tableshow(5);
					}
				}
			}
		});
		menu6.setFont(new Font("휴먼편지체", Font.BOLD, 18));
		menu6.setBounds(370, 320, 160, 70);
		food_panel.add(menu6);
		menu7.setForeground(new Color(0, 0, 0));
		menu7.setBackground(new Color(255, 218, 185));
		menu7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!menu7.getText().equals("")){
					if(e.getClickCount()==1){
						tableshow(6);
					}
				}
			}
		});
		menu7.setFont(new Font("휴먼편지체", Font.BOLD, 18));
		menu7.setBounds(10, 510, 160, 70);
		food_panel.add(menu7);
		menu8.setForeground(new Color(0, 0, 0));
		menu8.setBackground(new Color(255, 218, 185));
		menu8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!menu8.getText().equals("")){
					if(e.getClickCount()==1){
						tableshow(7);
					}
				}
			}
		});
		menu8.setFont(new Font("휴먼편지체", Font.BOLD, 18));
		menu8.setBounds(190, 510, 160, 70);
		food_panel.add(menu8);
		menu9.setForeground(new Color(0, 0, 0));
		menu9.setBackground(new Color(255, 218, 185));
		menu9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!menu9.getText().equals("")){
					if(e.getClickCount()==1){
						tableshow(8);
					}
				}
			}
		});
		menu9.setFont(new Font("휴먼편지체", Font.BOLD, 18));
		menu9.setBounds(370, 510, 160, 70);
		food_panel.add(menu9);
		menu1.setForeground(new Color(0, 0, 0));
		menu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menu1.setBackground(new Color(255, 218, 185));

		menu1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!menu1.getText().equals("")){
					if(e.getClickCount()==1){
						tableshow(0);
					}
				}
			}
		});
		menu1.setFont(new Font("휴먼편지체", Font.BOLD, 18));
		menu1.setBounds(10, 120, 160, 70);
		food_panel.add(menu1);
		
	}
	private void menu_bt(String str, PosMain posmain) {
		
		mainmenubt.setBackground(new Color(255, 218, 185));
		mainmenubt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					menueffect(0);

				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		mainmenubt.setForeground(new Color(255, 0, 0));
		mainmenubt.setFont(new Font("휴먼편지체", Font.BOLD, 30));
		mainmenubt.setBounds(12, 58, 160, 70);
		menu_panel.add(mainmenubt);

		
		sidemenubt.setBackground(new Color(255, 218, 185));
		sidemenubt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					menueffect(1);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		sidemenubt.setForeground(new Color(255, 69, 0));
		sidemenubt.setFont(new Font("휴먼편지체", Font.BOLD, 30));
		sidemenubt.setBounds(12, 158, 160, 70);
		menu_panel.add(sidemenubt);

		
		drinkbt.setBackground(new Color(255, 218, 185));
		drinkbt.setForeground(new Color(34, 139, 34));
		drinkbt.setFont(new Font("휴먼편지체", Font.BOLD, 35));
		drinkbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					menueffect(3);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		drinkbt.setBounds(12, 363, 160, 70);
		menu_panel.add(drinkbt);

		
		sojubt.setBackground(new Color(255, 218, 185));
		sojubt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					menueffect(4);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		sojubt.setForeground(new Color(0, 0, 205));
		sojubt.setFont(new Font("휴먼편지체", Font.BOLD, 35));
		sojubt.setBounds(12, 468, 160, 70);
		menu_panel.add(sojubt);

		
		anjubt.setBackground(new Color(255, 218, 185));
		anjubt.setForeground(new Color(255, 215, 0));
		anjubt.setFont(new Font("휴먼편지체", Font.BOLD, 35));
		anjubt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					menueffect(2);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		anjubt.setBounds(12, 254, 160, 70);
		menu_panel.add(anjubt);
		
		order_bt.setBackground(new Color(255, 192, 203));
		order_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jTable.getRowCount()!=0){
					ordermenu(Integer.parseInt(str.substring(6,7)),posmain);
					settable(Integer.parseInt(str.substring(6,7)),posmain,order);

					setVisible(false);
					order="";
					sumprice=0; 
				}
			}
		});
		order_bt.setBounds(782, 706, 185, 86);
		getContentPane().add(order_bt);
		order_bt.setForeground(new Color(0, 0, 0));
		order_bt.setFont(new Font("휴먼편지체", Font.BOLD, 46));

		
		cancel_bt.setBackground(new Color(255, 192, 203));
		cancel_bt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1){
					if(jTable.getSelectedRow()!=-1)
					{
						jBtnDelRow();
					}
				}
				else if(e.getClickCount()==2){

					setVisible(false);
				}
			}
		});
		cancel_bt.setForeground(new Color(0, 0, 0));
		cancel_bt.setFont(new Font("휴먼편지체", Font.BOLD, 46));
		cancel_bt.setBounds(979, 706, 174, 86);
		getContentPane().add(cancel_bt);
	}
	public void menuimage() throws IOException {
		for(int i=0;i<9;i++){
			menuframe[i] = new JPanel();
			menuframe[i].setBackground(new Color(255, 255, 224));
			if(i>=0 && i<3)
			{
				menuframe[i].setBounds(10+(180*i), 10, 160, 100);
			}
			else if(i>=3 && i<6)
			{
				menuframe[i].setBounds(10+(180*(i-3)), 210, 160, 100);
			}
			else{
				menuframe[i].setBounds(10+(180*(i-6)), 400, 160, 100);
			}
			menuframe[i].setVisible(true);
			food_panel.add(menuframe[i]);
		}
		for(int i=0;i<5;i++){
			for(int j=0;j<9;j++){
				if(!pic[i][j].equals("")){
					imageURL = getClass().getClassLoader().getResource(pic[i][j]);
					img = new ImageIcon(imageURL);
					menuimg[i][j]  = new JLabel(img);

					if(j>=0 && j<3){
						menuimg[i][j].setLocation(10+(180*j), 10);
					}
					else if(j>=3 && j<6){
						menuimg[i][j].setLocation(10+(180*(j-3)), 210);
					}
					else{
						menuimg[i][j].setLocation(10+(180*(j-6)), 400);
					}
					menuimg[i][j].setVisible(false);
					menuimg[i][j].setSize(160,100);
					food_panel.add(menuimg[i][j]);
				}
			}
		}
	}
	public void menupic(int num) throws IOException {

		menuicinit();

		for(int i=0;i<5;i++){
			for(int j=0;j<9;j++){
				if(!pic[i][j].equals("")){
					if(num==i){
						menuimg[i][j].setVisible(true);
						menuframe[j].setVisible(false);
					}
				}
			}
		}
	}
	public void menuicinit() {
		for(int i=0;i<5;i++){
			for(int j=0;j<9;j++){
				if(!pic[i][j].equals("")){
					menuimg[i][j].setVisible(false);
					menuframe[j].setVisible(true);
				}
			}
		}
	}
	public void ordermenu(int table, PosMain posmain) {
		order += "<html>";
		for(int i=0;i<jTable.getRowCount();i++){
			order += jTable.getValueAt(i,0).toString();//메뉴이름
			order += " x";
			order += jTable.getValueAt(i,1).toString();//개수
			order += "<br />";
			valuecheck(jTable.getValueAt(i,0).toString(),jTable.getValueAt(i,1).toString(),posmain,table);
		}
		order += "<br />";
		order += String.valueOf(sumprice)+"원";//총 가격
		order += "</html>";
	}
	public void valuecheck(String str, String count,PosMain posmain, int table) {

		for(int i=0;i<9;i++){
			if(menu[0][i].equals(str)){
				posmain.setCnt(i,Integer.parseInt(count),table);
			}
		}
	}
	public void settable(int nu, PosMain posmain,String str) {
		if(nu==1){
			posmain.setTable1(str,sumprice);
		}
		else if(nu==2){
			posmain.setTable2(str,sumprice);
		}
		else if(nu==3){
			posmain.setTable3(str,sumprice);
		}
		else if(nu==4){
			posmain.setTable4(str,sumprice);
		}
		else if(nu==5){
			posmain.setTable5(str,sumprice);
		}
		else if(nu==6){
			posmain.setTable6(str,sumprice);
		}
		else if(nu==7){
			posmain.setTable7(str,sumprice);
		}
		else if(nu==8){
			posmain.setTable8(str,sumprice);
		}
		else{
			posmain.setTable9(str,sumprice);
		}
	}
	public void tableshow(int se){
		String inputstr[]= new String[2];
		int temp=0;
		for(int i=0;i<5;i++){
			if(flag[i]){
				temp=i;
			}
		}
		cnt[temp][se]++;
		if(cnt[temp][se]==1&& !menu[temp][se].equals("")){
			try{
				inputstr[0]= menu[temp][se];
				inputstr[1]= String.valueOf(cnt[temp][se]);
				model.addRow(inputstr);
				num[temp][se] = model.getRowCount()-1;
				sumprice += Integer.parseInt(price[temp][se].trim());
			}
			catch(Exception aa){
			}
		}
		else{
			model.setValueAt(cnt[temp][se],num[temp][se],1);
			sumprice += Integer.parseInt(price[temp][se].trim());
		}	
	}	
	public void menueffect(int num) throws IOException{
		menu1.setText("");
		menu2.setText("");
		menu3.setText("");
		menu4.setText("");
		menu5.setText("");
		menu6.setText("");
		menu7.setText("");
		menu8.setText("");
		menu9.setText("");
		for(int i=0;i<flag.length;i++){
			if(i!=num){
				flag[i]=false;
			}
			else{
				flag[i]=true;
			}
		}
		menupic(num);

		menu1.setText("<html><body><div style=\"text-align:center\">"+menu[num][0]+"</div><div style=\"text-align:center\">"+price[num][0]+"</div></body></html>");
		menu2.setText("<html><body><div style=\"text-align:center\">"+menu[num][1]+"</div><div style=\"text-align:center\">"+price[num][1]+"</div></body></html>");
		menu3.setText("<html><body><div style=\"text-align:center\">"+menu[num][2]+"</div><div style=\"text-align:center\">"+price[num][2]+"</div></body></html>");
		menu4.setText("<html><body><div style=\"text-align:center\">"+menu[num][3]+"</div><div style=\"text-align:center\">"+price[num][3]+"</div></body></html>");
		menu5.setText("<html><body><div style=\"text-align:center\">"+menu[num][4]+"</div><div style=\"text-align:center\">"+price[num][4]+"</div></body></html>");
		menu6.setText("<html><body><div style=\"text-align:center\">"+menu[num][5]+"</div><div style=\"text-align:center\">"+price[num][5]+"</div></body></html>");
		menu7.setText("<html><body><div style=\"text-align:center\">"+menu[num][6]+"</div><div style=\"text-align:center\">"+price[num][6]+"</div></body></html>");
		menu8.setText("<html><body><div style=\"text-align:center\">"+menu[num][7]+"</div><div style=\"text-align:center\">"+price[num][7]+"</div></body></html>");
		menu9.setText("<html><body><div style=\"text-align:center\">"+menu[num][8]+"</div><div style=\"text-align:center\">"+price[num][8]+"</div></body></html>");
	}
	public void jBtnDelRow() {
		int row = jTable.getSelectedRow();
		int row1 = jTable.getRowCount();
		delprice(row);
		for(int i=row+1;i<row1;i++)
		{
			changeinitnum(jTable.getValueAt(i,0),i);
		}
		initmenu(jTable.getValueAt(row,0));
		if(row<0) return; // 선택이 안된 상태면 -1리턴
		model.removeRow(row);
	}
	public void delprice(int row) {

		for(int i=0;i<5;i++){
			for(int j=0;j<9;j++){
				if(menu[i][j].equals(jTable.getValueAt(row,0)))
				{
					sumprice -= (Integer.parseInt(price[i][j].trim())*cnt[i][j]);
					cnt[i][j]=0;
				}
			}
		}
	}
	public void changeinitnum(Object me,int su) {
		for(int i=0;i<5;i++){
			for(int j=0;j<8;j++){
				if(menu[i][j].equals(me.toString()))
				{
					num[i][j]--;
				}
			}
		}
	}
	public void initmenu(Object me) {
		for(int i=0;i<5;i++){
			for(int j=0;j<8;j++){
				if(menu[i][j].equals(me.toString()))
				{
					cnt[i][j]=0;
					num[i][j]=0;
				}
			}
		}
	}
}