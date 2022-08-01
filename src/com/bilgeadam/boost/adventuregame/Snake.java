package com.bilgeadam.boost.adventuregame;

import java.util.Random;

public class Snake extends Monster{

	
	
	public Snake() {
		super("Snake", 4, randomDamage(), 12, 0);
		
		
	}
	
	// 3 ve 6 arasında 
	public static int randomDamage() {
				
	Random r = new Random();
	return r.nextInt(3) +3;
			}
	
	

}
