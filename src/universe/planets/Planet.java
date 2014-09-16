package universe.planets;

import java.util.ArrayList;

import universe.creatures.Creature;

public class Planet {

	/*
	 * Attributes 
	 */
	public ArrayList<Creature> creatures = new ArrayList<Creature>();
	public String name;
	
	/**
	 * Constructor
	 * @param name
	 */
	public Planet(String name) {
		this.name = name;
	}
	
	
	/*
	 * Methods
	 */
	public Creature findCreature(String cname) {
		boolean found = false;
		int lng = this.creatures.size();
		int i = 0;
		Creature tmp = null;
		
		while(!found && i<lng) {
			tmp = this.creatures.get(i);
			if(tmp.name.equals(cname))
				found = true;
			i++;
		}
		
		if(found)
			return tmp;
		else
			return null;
	}
	
	public void addCreature(Creature c) {
		this.creatures.add(c);
		System.out.println("Creature "+c.name+" added !");
	}
	
	@Override
	public String toString(){
		return "Planet" + this.getClass().getName() + " Name :" + name + " Creatures : "+this.creatures.size();
	}
	
	public void showCreatures() {
		for (Creature c: this.creatures) {
			System.out.println(c.toString());
		}
	}
	
}
