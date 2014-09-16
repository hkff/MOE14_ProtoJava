package universe;

import java.util.ArrayList;
import universe.planets.Planet;

/**
 * This class implements the singleton pattern
 */
public class Universe {

	/*
	 * Attributes
	 */
	public ArrayList<Planet> planets = new ArrayList<Planet>();
	private static Universe univers;
	
	/**
	 * Constructor
	 */
	private Universe(){
		
	}
	
	public static Universe newUniverse(){
		if(univers == null)
			return new Universe();
		else
			return univers;
	}
	
	/*
	 * Methods
	 */
	public void addPlanet(Planet p) {
		this.planets.add(p);
		System.out.println("Planet "+p.name+" added !");
	}
	
	public void destroyPlanet(String pname) {
		Planet tmp = this.findPlanet(pname);
		if(tmp != null) {
			this.planets.remove(tmp);
			System.out.println("Planet "+pname+" destroyed !");	
		} else {
			System.out.println("Planet "+pname+" not found!");
		}
		
	}
	
	public Planet findPlanet(String pname) {
		for (Planet p : this.planets) {
			if(p.name.equals(pname))
				return p;
		}
		return null;
	}
	
	public void showPlanets() {
		int nbr = 0;
		for (Planet p : this.planets) {
			nbr = p.creatures.size();
			System.out.println("Planet "+p.name+" ( "+nbr+" creatures)");
		}
	}
}