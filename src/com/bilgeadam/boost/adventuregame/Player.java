package com.bilgeadam.boost.adventuregame;

import java.util.Scanner;

public class Player {
	
	private int damage;
	private int health;
	private int originalHealth;
	private int money;
	private String name;
	private String charName;
	private Inventory inventory;
	Scanner scan = new Scanner(System.in);
			
	
	
	public Player(String name) {
		
		this.name = name;
		this.inventory=new Inventory();
	}
	
	public void selectChar () {
		
		System.out.println("---------------------------------------------------------------------");
		CharSamurai samurai = new CharSamurai();
		CharArcher archer = new CharArcher();
		CharKnight knight = new CharKnight();
		
		GameCharacter [] charList = {new CharSamurai(),new CharArcher(),new CharKnight()};
		
		System.out.println("Characters: ");
		System.out.println("----------------------------------------------------------------------    ");
		
		for (GameCharacter gameCharacter : charList) {
			
			System.out.println("Character: "+gameCharacter.getName()+"\t ID: "+gameCharacter.getId()+"\t Damage: "+gameCharacter.getDamage()+
					           "\t Health: "+gameCharacter.getHealth()+"\t Money: "+ gameCharacter.getMoney());
		}
		
		System.out.println("----------------------------------------------------------------------  ");
		System.out.print("Please choose a character: ");
		int selectChar = scan.nextInt();
		switch (selectChar) {
		
		case 1:
			initPlayer(new CharSamurai());
			break;
		case 2:
			initPlayer(new CharArcher());
			break;
		case 3:
			initPlayer(new CharKnight());
			break;
		default:
			System.out.println("Invalid choice!");
				
			
		}
		System.out.println("Character: "+this.getCharName()+"\t Damage: "+this.getDamage()+
				           "\t Health: "+this.getHealth()+"\t Money:"+this.getMoney());
		
	}
	
	public void selectLoc() {
		
		Location location =null;
		
		while (true) {
		
		System.out.println("----------------------------------------------------");
		this.printInfo();
		System.out.println("----------------------------------------------------");
		System.out.println("Locations:");
		System.out.println("1-Safe House--->You are safe here, there are no enemies");
		System.out.println("2-Tool Store---> You can get weapons or armor");
		System.out.println("3-Cave--> Be careful! You might encounter a vampire");
		System.out.println("4-Forest--> Be careful! You might encounter a zombie");
		System.out.println("5-River--> Be careful! You might encounter a bear");
		System.out.println("6-Mine--> Be careful! You might encounter a snake");
		System.out.println("0-Exit--> End the game");
		System.out.println("----------------------------------------------------");
		System.out.print("Please choose a location: ");
		int choose =scan.nextInt();
		
		switch(choose) {
		
		case 0:
			location=null;
			break;
		
		
		case 1:
			location = new LocSafeHouse(this);
			break;
			
		case 2:
			location = new LocToolStore(this);
			break;
			
		case 3:
			location = new Cave(this);
			break;
		case 4:
			location = new Forest(this);
			break;
		case 5:
			location = new River(this);
			break;
		case 6:
			location = new Mine(this);
			break;
			
		default:
			location = new LocSafeHouse(this);
			break;
				
		}
		
		if(location==null) {
			
			System.out.println("The game is over, we wait again!");
			break;
		}
		
		if(!location.onLocation()) {
			
			System.out.println("GAME OVER!");
			break;
		}
		
		
	}
	}
	
	public void initPlayer(GameCharacter gameChar) {
		
		this.setDamage(gameChar.getDamage());
		this.setHealth(gameChar.getHealth());
		this.setOriginalHealth(gameChar.getHealth());
		this.setMoney(gameChar.getMoney());
		this.setCharName(gameChar.getName());
		
	}
	
	public void printInfo() {
		
		System.out.println("------------------------------------------------------------------");
		System.out.println("Weapon: "+this.getInventory().getWeapon().getName() +"\t Armor: " + this.getInventory().getArmor().getName()+
				            "\t Blocked: "+this.getInventory().getArmor().getBlocked()+"\t Damage: "+this.getTotalDamage()+
				            "\t Health: "+this.getHealth()+ "\t Money: "+this.getMoney());
	    
	}
     
	public int getTotalDamage() {
		
		return this.damage + this.getInventory().getWeapon().getDamage();  // burda aldığımız silahın zararını kendi zararımızın üstüne ekliyoruz
	}

	public int getDamage() {return this.damage;}


	public void setDamage(int damage) {this.damage = damage;}


	public int getHealth() {return this.health;}


	public void setHealth(int health) {this.health = health;}


	public int getMoney() {return this.money;}


	public void setMoney(int money) {this.money = money;}


	public String getName() {return this.name;}


	public void setName(String name) {this.name = name;}


	public String getCharName() {return this.charName;}


	public void setCharName(String charName) {this.charName = charName;}

	public Inventory getInventory() {return this.inventory;}

	public void setInventory(Inventory inventory) {this.inventory = inventory;}

	public int getOriginalHealth() {return this.originalHealth;}

	public void setOriginalHealth(int originalHealth) {
		this.originalHealth = originalHealth;
	}
	
	
	
	
	

}
