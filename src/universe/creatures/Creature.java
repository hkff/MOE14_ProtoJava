package universe.creatures;

import universe.planets.Planet;

public class Creature {

	/*
	 * Attributes 
	 */
	public String name;
	public int age;
	public int energy;
	public Planet planet;
	static int counter = 0;

	/**
	 * Constructor
	 * @param name
	 * @param age
	 */
	public Creature(String name, int age, Planet planet) {
		this.name = name;
		this.age = age;
		this.energy = 100;
		this.planet = planet;
		planet.addCreature(this);
		Creature.counter++;
	}
	
	/*
	 * Methods
	 */
	public void die() {
		this.energy = 0;
	}
	
	@Override
	public String toString(){
		return "Creature " + this.getClass().getName() + " Name :" + name + " Age : "+age;
	}
	
}
