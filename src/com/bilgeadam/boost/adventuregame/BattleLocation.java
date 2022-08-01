package com.bilgeadam.boost.adventuregame;

import java.util.Random;

public abstract class BattleLocation extends Location {

	private Monster monster;
	private String award;
	private int maxMonster;
	
	
	public BattleLocation(Player player, String name,Monster monster,String award,int maxMonster) {
		super(player, name);
		this.monster=monster;
		this.award=award;
		this.monster=monster;
		this.maxMonster=maxMonster;
		
	}

	@Override
	public boolean onLocation() {
		int monsterNumber = this.randomMonsterNumber(); // kaç canavar atandıysa onu çağırıyoruz
		System.out.println("You are in the " +this.getName()+ " now.");
		System.out.println("Be careful! "+ monsterNumber + " "+this.getMonster().getName()+" live here!");
		System.out.println("-----------------------------------------------------");
		System.out.println("F-Fight     or     E-Escape  ");
		String select = scan.nextLine();
		select = select.toUpperCase(); 
		if (select.equals("F")) {
			
			if(combat(monsterNumber)) {
				
				System.out.println("You defeated all the enemies in the "+this.getName()); //bu yerdeki tüm düşmanları yendiniz
				if(this.getAward().equals("Food") && this.getPlayer().getInventory().isFood()==false) {
					System.out.println("You won "+this.getAward());
					this.getPlayer().getInventory().setWater(true);
				} else if (this.getAward().equals("Firewood") && this.getPlayer().getInventory().isFirewood()==false ) {
					System.out.println("You won "+ this.getAward());
					this.getPlayer().getInventory().setFirewood(true);
				} else if(this.getAward().equals("Water") && this.getPlayer().getInventory().isWater()==false) {
					System.out.println("You won "+this.getAward());
					this.getPlayer().getInventory().setWater(true);
				}
				return true;
				
			}
		}
		
		if(this.getPlayer().getHealth()<=0) {
			System.out.println("You died!");
			return false;
		}
		return true;
	}
	
	public boolean combat(int monsterNumber) {
		
		for(int i=1; i<=monsterNumber; i++) {
			
			this.getMonster().setHealth(this.getMonster().getOriginalHealth()); //2 zombi çıktığında ilkini yendiğimizde onun canı sıfırlandığı
			playerInfo();                                                       //için 2. zombi geldiğinde canı her defasında tekrar orjinale dönüyor
			monsterInfo(i); 
			
			if (randomFirstMove()==true) {
			while(this.getPlayer().getHealth()>0 && this.getMonster().getHealth()>0) {
				
				System.out.println("H-Hit         E-Escape");
				String select = scan.nextLine().toUpperCase();
				
				if(select.equals("H")) {
					
					System.out.println("You hit!");
					this.getMonster().setHealth(this.getMonster().getHealth()-getPlayer().getTotalDamage());
					afterHit();
					
				}
					
				if(randomFirstMove()==false) {
				if(this.getMonster().getHealth()>0) {
						
						System.out.println();
						System.out.println("The monster hit you!");
						//burada canavar bize zarar verdikten sonra sağlığımızın neye düştüğünü bulmadan önce
						//zırhımız varsa eğer diye zırhın blok değerini canavarın verdiği zarardan çıkarıyoruz
						int monsterDamage=this.getMonster().getDamage()-this.getPlayer().getInventory().getArmor().getBlocked();
						if(monsterDamage<0) { monsterDamage=0; }
						this.getPlayer().setHealth(this.getPlayer().getHealth()-monsterDamage);
						afterHit();
					}
				} else {
					
					return false;
				}
			}
			
			}
			
			if(this.getMonster().getHealth() < this.getPlayer().getHealth()) {
				
				System.out.println();
				System.out.println("You defeated the enemy!");
				System.out.println("Money you earn: "+this.getMonster().getAward());
				this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getMonster().getAward()); //canavardan kazandığı parayı oyuncunun parasının üstüne ekledik
				System.out.println("Your current money: "+this.getPlayer().getMoney());
			} else {
				
				return false;
			}
		
		}
		return true;
	}
	
	
        public void afterHit() {
		
        	System.out.println();
        	System.out.println("Your health: "+this.getPlayer().getHealth());
        	System.out.println("Health of "+this.getMonster().getName()+": "+this.getMonster().getHealth());
        	System.out.println();
	         }
	
	public void playerInfo() {
		
		System.out.println();
		System.out.println("Player status: ");
		System.out.println("  - - - - - - -   ");
		System.out.println("Health: "+this.getPlayer().getHealth());
		System.out.println("Damage: "+this.getPlayer().getTotalDamage());
		System.out.println("Money: "+this.getPlayer().getMoney());
		System.out.println("Weapon: "+this.getPlayer().getInventory().getWeapon().getName());
		System.out.println("Armor: "+this.getPlayer().getInventory().getArmor().getName());
		System.out.println("Blocked: "+this.getPlayer().getInventory().getArmor().getBlocked());
		System.out.println("  - - - - - - -   ");
		
	}
	
	public void monsterInfo(int i) {
		
		System.out.println();
		System.out.println(i+". "+this.getMonster().getName()+":");
		System.out.println("  - - - - - - -   ");
		System.out.println("Health: "+this.getMonster().getHealth());
		System.out.println("Damage: "+this.getMonster().getDamage());
		System.out.println("Award: "+this.getMonster().getAward());
		System.out.println("  - - - - - - -   ");
		
	}
	
	
	public int randomMonsterNumber() {
		
		Random r = new Random();
		return r.nextInt(this.getMaxMonster()) + 1;     //1 ile 4 arasında rastgele bir sayı ataması yapıyor çünkü getMxMonster()->3
	}
	
	public boolean randomFirstMove() {
		
		Random r = new Random();
		return r.nextBoolean();
		
	}

	public Monster getMonster() {
		return this.monster;
	}

	public void setMonster(Monster monster) {
		this.monster = monster;
	}

	public String getAward() {
		return this.award;
	}

	public void setAward(String award) {
		this.award = award;
	}

	public int getMaxMonster() {
		return this.maxMonster;
	}

	public void setMaxMonster(int maxMonster) {
		this.maxMonster = maxMonster;
	}
	
	
	
	

}
