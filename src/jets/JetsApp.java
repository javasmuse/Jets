package jets;

import java.util.Scanner;

public class JetsApp {

	public JetsApp() {
	}
	
//	public List<Jet> jets = new ArrayList<>();

	Scanner kb = new Scanner(System.in);

	private AirField airfield = new AirField();

	public static void main(String[] args) {

		JetsApp jetsapp = new JetsApp();
		jetsapp.menu();

	}

	public int menu() {
		int choice;
		System.out.println("***** Welcome to Lewy's Airfield ****** ");
		System.out.println("\nYou have options, press a number to choose.");
		System.out.println("\n(1) List our Fleet");
		System.out.println("(2) Fly all Jets");
		System.out.println("(3) View fastest Jet");
		System.out.println("(4) View Jet with the longest Range");
		System.out.println("(5) Load all Cargo Jets");
		System.out.println("(6) Dogfight");
		System.out.println("(7) add a jet to our Fleet");
		System.out.println("(8) remove a jet from our Fleet");
		System.out.println("(9) Quit / leave the airfield\n");
		choice = kb.nextInt();
		choice(choice);
		return choice;
	}

	public void choice(int choice) {

		
			switch (choice) {
			case 1:
				airfield.readJets();
				airfield.showInventory();
				System.out.println();
				menu();
				break;
			case 2:
				airfield.flyJets();
				System.out.println();
				menu();
				break;
			case 3:
				airfield.fastestJet();
				System.out.println();
				menu();
				break;

			case 4:
				airfield.longestRange();
				System.out.println();
				menu();
				break;
			case 5:
				airfield.loadCargo();
				System.out.println();
				menu();
				break;
			case 6:
				airfield.dogFight();
				System.out.println();
				menu(); 
				break;
			case 7:
				airfield.addJet();
				airfield.showInventory();
				System.out.println();
				menu();
				break;
			case 8:
				airfield.removeJet();
				airfield.showInventory();
				System.out.println();
				menu();
				break;
			case 9:
				System.out.println("Goodbye, Welcome back anytime.");
				break;
			}
	}

}
