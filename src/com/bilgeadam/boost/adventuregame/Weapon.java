package com.bilgeadam.boost.adventuregame;

public class Weapon {
	
	private int id;
	private String name;
	private int damage;
	private int money;
	
	
	public Weapon(String name,int id,  int damage, int money) {
		super();
		this.id = id;
		this.name = name;
		this.damage = damage;
		this.money = money;
	}
	
	public static Weapon [] weapons () {
		
		Weapon [] weaponList = {new Weapon("Gun",1,2,15),new Weapon("Sword",2,3,35),new Weapon("Rifle",3,7,45)};
		return weaponList;
	}
	
	public static Weapon getWeaponObjById(int id) {
		
		for (Weapon w : Weapon.weapons()) {
			
			if(w.getId()==id) {
				
				return w;		
			}
			
		}
		return null;
	}


	public int getId() {
		return this.id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return this.name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getDamage() {
		return this.damage;
	}


	public void setDamage(int damage) {
		this.damage = damage;
	}


	public int getMoney() {
		return this.money;
	}


	public void setMoney(int money) {
		this.money = money;
	}
	
	

}
