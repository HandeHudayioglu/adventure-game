package com.bilgeadam.boost.adventuregame;

public class Inventory {
	  //oyuncunun sahip olduğu envanterler
	private Weapon weapon;
	private Armor armor;
	private boolean isWater;
	private boolean isFirewood;
	private boolean isFood;
	
	
	public Inventory() {
		
		this.weapon = new Weapon ("Punch", -1,0,0); //yapıcı metodun içindekiler varsayılan değerler
		this.armor = new Armor ("None",-1,0,0);    //yapıcı metodun içindekiler varsayılan değerler
		this.isFirewood = false;
		this.isFood = false;
		this.isWater = false;
	}


	public Weapon getWeapon() {
		return this.weapon;
	}


	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}


	public Armor getArmor() {
		return this.armor;
	}


	public void setArmor(Armor armor) {
		this.armor = armor;
	}


	public boolean isWater() {
		return this.isWater;
	}


	public void setWater(boolean isWater) {
		this.isWater = isWater;
	}


	public boolean isFirewood() {
		return this.isFirewood;
	}


	public void setFirewood(boolean isFirewood) {
		this.isFirewood = isFirewood;
	}


	public boolean isFood() {
		return this.isFood;
	}


	public void setFood(boolean isFood) {
		this.isFood = isFood;
	}
	
	
	
	
	
	

}
