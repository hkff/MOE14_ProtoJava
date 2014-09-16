import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import universe.Universe;
import universe.creatures.Creature;
import universe.creatures.Human;
import universe.creatures.Human.Sexe;
import universe.planets.Planet;

public class Main {
	static Universe universe;
	
	public static void main(String[] args) {
		universe = Universe.newUniverse();
		
		System.out.println("Welcome to universe simulator ");
		
		Scanner sc = new Scanner(System.in);
		
		while(true){
			System.out.println("Enter choice : 0- Create planet 1- Create Human 2- List planets 3- List creatures 4- Run tests ");
			
			int choice = sc.nextInt();
			
			switch(choice){
			case 0 :
				System.out.println("Enter Planet name : ");
				String name = sc.next();
				universe.addPlanet(new Planet(name));
				break;
				
			case 1 :
				System.out.println("Enter human : name age sexe(M/F) planet : ");
				String hname = sc.next();
				int hage = sc.nextInt();
				String hsexe = sc.next();
				String pName = sc.next();
				Sexe sexe;
				
				Planet planet = universe.findPlanet(pName);
				if(hsexe.equals("M"))
					sexe = Sexe.MALE;
				else
					sexe = Sexe.FEMALE;
				
				if(planet!= null) {
					planet.addCreature(new Human(hname, hage, sexe, planet));	
				}else{
					System.out.println("Planet not found !");
				}
					
				
				break;
				
			case 2 :
				universe.showPlanets();
				break;
			case 3 :
				for (Planet p : universe.planets) {
					p.showCreatures();
				}
				break;
			case 4 :
				Main.tester();
				break;
			}
		}
	}
	
	
	/**
	 * Tester method
	 * Print the output in "test.txt"
	 */
	public static void tester() {
        // Create log file
        File file = new File("logJava.txt");
        try {
            PrintStream printStream = new PrintStream(file);
            
            // Save standard output
            PrintStream stdout = System.out;
            
            // Redirect output to printStream
            System.setOut(printStream);
            
			Planet p1 = new Planet("p1");
			Planet p2 = new Planet("p2");
			Planet p3 = new Planet("p3");
			Planet p4 = new Planet("p4");
			Planet p5 = new Planet("p5");
			Planet p6 = new Planet("p6");
			Human h1 = new Human("h1", 20, Sexe.MALE, p1);
			Human h2 = new Human("h2", 85, Sexe.FEMALE, p5);
			Human h3 = new Human("h3", 18, Sexe.MALE, p1);
			Human h4 = new Human("h4", 20, Sexe.FEMALE, p2);
			Human h5 = new Human("h5", 45, Sexe.FEMALE, p1);
			Human h6 = new Human("h6", 46, Sexe.FEMALE, p3);
			Human h7 = new Human("h7", 20, Sexe.MALE, p6);
			Human h8 = new Human("h8", 19, Sexe.FEMALE, p1);
			
			universe.addPlanet(p1);
			universe.addPlanet(p2);
			universe.addPlanet(p3);
			universe.addPlanet(p4);
			universe.addPlanet(p5);
			universe.addPlanet(p6);
			
			universe.showPlanets();
			
			for (Planet p : universe.planets) {
				p.showCreatures();
			}
			
			System.out.println(universe.findPlanet("p8"));
			System.out.println(universe.findPlanet("p1"));
			
			System.out.println(p2.findCreature("h4"));
			System.out.println(p2.findCreature("h9"));
			
			// Restore standard output
			System.setOut(stdout);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		
	}
}
