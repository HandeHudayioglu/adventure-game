package com.bilgeadam.boost.adventuregame;

import java.util.ArrayList;

public class Armor {
	
	private String name;
	private int id;
	private int blocked;
	private int money;
	
	
	public Armor(String name, int id, int blocked, int money) {
		super();
		this.name = name;
		this.id = id;
		this.blocked = blocked;
		this.money = money;
	}
	
	public static ArrayList<Armor>armors(){
		
		ArrayList<Armor> armorList = new ArrayList<>();
		armorList.add(new Armor("Slight", 1,1, 15));
		armorList.add(new Armor("Medium",2,3,25));
		armorList.add(new Armor("Heavy",3,5,40));
		
		return armorList;
	}
	
public static Armor getArmorObjById(int id) {
		
		for (Armor a : Armor.armors()) {
			
			if(a.getId()==id) {
				
				return a;		
			}
			
		}
		return null;
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


	public int getBlocked() {
		return this.blocked;
	}


	public void setBlocked(int blocked) {
		this.blocked = blocked;
	}


	public int getMoney() {
		return this.money;
	}


	public void setMoney(int money) {
		this.money = money;
	}
	
	

}
