package com.bilgeadam.boost.adventuregame;

import java.util.Random;

public class Mine extends BattleLocation {

	
   
	public Mine(Player player) {
		super(player, "Mine", new Snake(), randomAward(), 6);
		// TODO Auto-generated constructor stub
	}
	
	

	//ödül olarak para silah veya zırhı random atayacak
	public static String randomAward() {
		
		
		Random r = new Random();
		int num = r.nextInt(2) + 1;
		
		switch (num) {
		
		case 1:
			
			System.out.println("Your award: "+Award.MONEY);
			break;
		case 2:
			
			System.out.println("Your award: "+Award.WEAPON);
			break;
		case 3:
			
			System.out.println("Your award: "+Award.ARMOR);
			break;
			
			
		}
		return null;
		
		
	}
	
	

}
