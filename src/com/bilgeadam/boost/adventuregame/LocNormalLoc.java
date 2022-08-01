package com.bilgeadam.boost.adventuregame;

public abstract class LocNormalLoc extends Location {

	public LocNormalLoc(Player player,String name) {
		super(player,name);
		
		
	}

	@Override
	public boolean onLocation() {
		
		return true;
	}

}
