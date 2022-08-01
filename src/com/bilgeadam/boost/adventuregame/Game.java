package com.bilgeadam.boost.adventuregame;

import java.util.Scanner;

public class Game {
	
	Scanner scan = new Scanner(System.in);
	
	public void start() {
		
		System.out.println("Welcome to Adventure Game!");
		//System.out.println("Please enter a name: ");
		//String playerName = scan.nextLine();
		Player player = new Player("Hande");
		System.out.println(player.getName() + " welcome to our adventure game. Everything that happens here is real!");
		System.out.println("Please choose a character: ");
		player.selectChar();
		player.selectLoc();
	}
	
	

}
