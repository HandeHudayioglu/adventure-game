package com.bilgeadam.boost.adventuregame;

public class LocToolStore extends LocNormalLoc {

	public LocToolStore(Player player) {
		super(player,"Tool Store");
		
	}

	
	
	@Override
	public boolean onLocation() {

      System.out.println("Welcome to tool store!");
      
      boolean showMenu=true;
      while(showMenu) {
      System.out.println("1-Weaponry");
      System.out.println("2-Armour");
      System.out.println("3-Exit");
      System.out.print("Your choice: ");
      int choose = scan.nextInt();
      while(choose<1 || choose>3) {
    	  
    	  System.out.print("Invalid choice! Try again: ");
    	  choose = scan.nextInt();
    	  
      }
      
      switch(choose) {
      
      case 1:
    	  printWeapon();
    	  buyWeapon();
    	  break;
      case 2:
    	  printArmor();
    	  buyArmor();
    	  break;
      case 3:
    	  System.out.println("We hope you come again!");
    	 showMenu=false;
    	 break;
      
      }
		
	}
      return true;
	}
      
	//zırhları yazdırdık
	private void printArmor() {
		
		System.out.println("Armors");
		System.out.println();
		
		for (Armor a : Armor.armors()) {
			
			System.out.println("ID: "+a.getId()+ "\t Name: "+a.getName()+"\t Money: "+a.getMoney()+"\t Blocked: "+a.getBlocked());
			
		}
		System.out.println("0- Exit");
		
	}
	
	private void buyArmor() {
		
		System.out.println("Please choose an armor: ");
		int choose = scan.nextInt();
		while (choose<0 || choose>Armor.armors().toArray().length) {
			
			System.out.println("Invalid choice. Try again: ");
			choose = scan.nextInt();
		}
		if(choose!=0) {
			
			
			Armor selectedArmor = Armor.getArmorObjById(choose);
			
			if(selectedArmor != null) {
				
				if(selectedArmor.getMoney()>this.getPlayer().getMoney()) {
					System.out.println("You don't have enought money!");
					
				} else {
					
					System.out.println("You bought a "+ selectedArmor.getName());
					int balance = this.getPlayer().getMoney()-selectedArmor.getMoney();
					this.getPlayer().setMoney(balance);
					System.out.println("Your remaining money: "+this.getPlayer().getMoney());
					this.getPlayer().getInventory().setArmor(selectedArmor);  //önceki zırhını yeni seçtiği zırhla değiştirdik
				}
			}
		}
	}

	
	//silah isimlerini yazdırdık
	private void printWeapon() {
		
		System.out.println("Weaponry: ");
		System.out.println();
		for (Weapon w : Weapon.weapons()) {
			System.out.println("ID: "+w.getId()+ "\t Name: "+w.getName()+"\t Money: "+w.getMoney()+"\t Damage: "+w.getDamage());
		}
		
		System.out.println("0- Exit");
	}
		
	
	//Silah satın alma işleminin gerçekleştiği yer
		public void buyWeapon() {
			
		System.out.println("Please choose a weapon: ");
		int choose = scan.nextInt();
		while (choose<0 || choose>Weapon.weapons().length) {
			
			System.out.println("Invalid choice. Try again: ");
			choose = scan.nextInt();
		}
		
		if(choose!=0) {
			
			Weapon selectedWeapon = Weapon.getWeaponObjById(choose);
			if( selectedWeapon !=null) {
				
				if(selectedWeapon.getMoney()>this.getPlayer().getMoney()) {
					
					System.out.println("You don't have enought money!");
				} else {
					
					System.out.println("You bought a "+ selectedWeapon.getName());
					int balance = this.getPlayer().getMoney()-selectedWeapon.getMoney();
					this.getPlayer().setMoney(balance);
					System.out.println("Your remaining money: "+this.getPlayer().getMoney());
					//System.out.println("Your weapon before you change it: " + this.getPlayer().getInventory().getWeapon().getName());
					this.getPlayer().getInventory().setWeapon(selectedWeapon);  // önceki silahını yeni silahıyla değiştirdik
					//System.out.println("Your new weapon: "  +this.getPlayer().getInventory().getWeapon().getName());
				}
			
		}
		
			
		}
		
	}
	
	

}
