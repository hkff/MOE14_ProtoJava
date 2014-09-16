package universe.creatures;

import universe.planets.Planet;

public class Human extends Creature {

	/**
	 * Enumeration
	 */
	public enum Sexe {
		MALE,
		FEMALE;
	}

	/*
	 * Attributes
	 */
	public Sexe sexe;
	
	
	/**
	 * Constructor
	 * @param name
	 * @param age
	 */
	public Human(String name, int age, Planet planet) {
		super(name, age, planet);
	}
	
	/**
	 * Constructor
	 * @param name
	 * @param age
	 * @param sexe
	 */
	public Human(String name, int age, Sexe sexe, Planet planet) {
		this(name, age, planet);
		this.sexe = sexe;
	}
	
	/*
	 * Methods 
	 */
	public void sayHello() {
		System.out.println("Hello I am "+this.name+" !");
	}
	
	public void eat(int food) {
		System.out.println("Miam, miam ...");
		this.energy += food;
	}
}
