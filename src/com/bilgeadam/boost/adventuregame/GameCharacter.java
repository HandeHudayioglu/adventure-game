package com.bilgeadam.boost.adventuregame;

public abstract class GameCharacter {
	
	private int id;
	private String name;
	private int damage;
	private int health;
	private int money;
	
	
	public GameCharacter(String name,int id,int damage, int health, int money) {
		super();
		this.id=id;
		this.name=name;
		this.damage = damage;
		this.health = health;
		this.money = money;
	}


	public int getDamage() {
		return this.damage;
	}


	public void setDamage(int damage) {
		this.damage = damage;
	}


	public int getHealth() {
		return this.health;
	}


	public void setHealth(int health) {
		this.health = health;
	}


	public int getMoney() {
		return this.money;
	}


	public void setMoney(int money) {
		this.money = money;
	}
	
	


	public String getName() {
		return this.name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	


	public int getId() {
		return this.id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "GameCharacter [damage=" + this.damage + ", health=" + this.health + ", money=" + this.money + "]";
	}
	
	

}
