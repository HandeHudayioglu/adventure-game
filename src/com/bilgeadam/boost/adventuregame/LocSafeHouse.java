package com.bilgeadam.boost.adventuregame;

public class LocSafeHouse extends LocNormalLoc {

	public LocSafeHouse(Player player) {
		super(player, "Safe House");
		
	}

	@Override
	public boolean onLocation() {
		
		System.out.println("You are in the safe house!");
		System.out.println("You are full of life!");
		//safehouse a geldiğinde canının fullenme kodu
		this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
		return true;
		
	}
	
	

}
