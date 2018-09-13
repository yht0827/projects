package Pos;

public class TableMenu {
	public String[][] menu(){
		String[][] menu = new String[][]{
			{"후라이드","양념치킨","옛날통닭","양파치킨","순살일반","순살양념","반반치킨","순살반반","간장치킨"},
			{"감자튀김","치즈스틱","모듬소세지","새우튀김","쥐      포","갈비만두","해쉬브라운","모듬까스","콘샐러드"},
			{"똥집튀김","골  뱅 이","닭      발","계란말이","닭볶음탕","해물짬뽕","오 뎅 탕","떡 볶 이","버 터 밥"},
			{"사이다 500ml","사이다 1.25L","콜라 500ml","콜라 1.25L","환타 600ml","환타 1.5L","쿨 피 스","아이스티","생      수"},
			{"참 이 슬","처음처럼","맥주 500cc","맥주 2000cc","맥주 3000cc","준      벅","모 히 또","피치크러쉬","블루하와이"}
		};
		return menu;
	}
	public String[][] price(){
		String[][] price = new String[][]{
			{" 15000"," 16000"," 16000"," 16000"," 16000"," 17000"," 16000"," 17000"," 16000"},
			{" 3000"," 4000"," 12000"," 5000"," 6000"," 6000"," 3000"," 5000"," 3000"},
			{" 12000"," 13000"," 10000"," 8000"," 20000"," 15000"," 13000"," 10000"," 3000"},
			{" 2000"," 3000"," 2000"," 3000"," 2000"," 3000"," 2000"," 2000"," 1000"},
			{" 4000"," 4000"," 4000"," 12000"," 16000"," 5000"," 5000"," 5000"," 5000"}
		};
		return price;
	}
	public String[][] pic(){
		String[][] pic = new String[][]{
			{"fried.jpg","yangnum.jpg","oldchi.jpg","onion.jpg","sunsalfried.jpg","sunsalyangnum.jpg","half.jpg","sunsalhalf.jpg","soychick.jpg"},
			{"gamja.jpg","cheesestick.jpg","sousage.jpg","shirmp.jpg","jipo.jpg","galbimandu.jpg","hashbrown.jpg","modum.jpg","corn.jpg"},
			{"dakdong.jpg","gol.jpg","dakbal.jpg","egg.jpg","dakbok.jpg","jjambbong.jpg","odeng.jpg","ttuk.jpg","butter.jpg"},
			{"cider500.jpg","cider125.jpg","coke500.jpg","coke125.jpg","fanta600.jpg","fanta15.jpg","cool.jpg","icedtea.jpg","water.jpg"},
			{"chamisul.jpg","chum.jpg","sang500.jpg","sang2000.jpg","sang3000.jpg","junebug.jpg","mojito.jpg","peachcrush.jpg","Blue Hawaii.jpg"}
		};
		return pic;
	}
}