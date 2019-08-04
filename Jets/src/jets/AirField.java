package jets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirField {

	private List<Jet> jetList = new ArrayList<Jet>();
	CargoCarrier ccJet = new CargoCarrier();
	Fighter fJet = new Fighter();
	Scanner kb = new Scanner(System.in);

	public AirField() {
		readJets();
	}

	public List<Jet> readJets() {
		this.jetList = new ArrayList<Jet>(); // this is necessary, null pointer without or prints duplicate lists idky

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("JetInventory.txt"));
			String line;

			while ((line = reader.readLine()) != null) {
				String[] jetRead = line.split(",");

				String type = jetRead[0];
				String model = jetRead[1];
				double speed = Double.parseDouble(jetRead[2]);
				int range = Integer.parseInt(jetRead[3]);
				long price = Long.parseLong(jetRead[4]);

				Jet currentJet = new JetImp(type, model, speed, range, price);
				jetList.add(currentJet);
			}

			reader.close();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return jetList;
	}

	public void showInventory() {
		System.out.println("\nHere at Lewy's Airfield we have a total of: " + jetList.size() + " aircraft\n");
		System.out.println("Type,       Make,      Model,      MaxSpeed,       MaxRange,      PurchaseCost\n");
		for (int i = 0; i < jetList.size(); i++) {
			System.out.println(jetList.get(i));
		}
	}

	public void flyJets() {
		System.out.println("All Jets Fly Now");
		for (Jet jet : jetList) {
			System.out.println("Gonna Fly Now..." + jet.getModel() + " can fly for "
					+ (int) (jet.getRange() / jet.getSpeed()) + " hours on one tank of fuel.\n");

		}
	}

	public void fastestJet() {
		double fJet = 0.0;
		String nameJet = null;
		for (Jet jet : jetList) {
			if (jet.getSpeed() > fJet) {
				fJet = jet.getSpeed();
				nameJet = jet.getModel();
			}
		}
		System.out.println("The fastest jet is the " + nameJet + " it has a speed of " + fJet + " mph ");
	}

	public void longestRange() {
		int lrJet = 0;
		String nameJet = null;
		for (Jet jet : jetList) {
			if (jet.getRange() > lrJet) {
				lrJet = jet.getRange();
				nameJet = jet.getModel();
			}
		}
		System.out.println("The longest range jet is the " + nameJet + " it can cruise " + lrJet + " miles ");
	}

	public void loadCargo() {
		for (Jet jet : jetList) {
			String type = jet.getType();
			if (type.equalsIgnoreCase("Cargo")) {
				System.out.println(jet.getModel());
			}
		}
		System.out.println("All Cargo Carriers standing by to be loaded.");
		ccJet.loadCargo();
	}

	public void dogFight() {
		for (Jet jet : jetList) {
			String type = jet.getType();
			if (type.equalsIgnoreCase("fighter")) {
				System.out.println(jet.getModel());
			}
		}
		System.out.print("All fighters ");
		fJet.dogFight();
	}

	public List<Jet> addJet() {
		System.out.print("Would you like to add a Cargo Carrier or Fighter jet?  ");
		String type = kb.next();
		System.out.println("\nEnter the Model: ");
		String model = kb.next();
		System.out.print("Speed : ");
		Double speed = kb.nextDouble();
		System.out.print("Range : ");
		int range = kb.nextInt();
		System.out.print("Price: $");
		Long price = kb.nextLong();
		Jet newAddition = new JetImp(type, model, speed, range, price);
		jetList.add(newAddition);
		System.out.println();
		System.out.println("Breaking news... We have an updated inventory.  ");
		System.out.println();
		return jetList;
	}

	public List<Jet> removeJet() {
		System.out.println("Please choose a jet to remove. Review the inventory and enter the number.");
		System.out.println("You can only fly one at a time. But, you may return to checkout another.");
		for (int index = 0; index < jetList.size(); index++) {
			System.out.println((index + 1) + " " + jetList.get(index).getModel());
		}
		int choice = kb.nextInt();
		jetList.remove(choice - 1);
		System.out.println();
		System.out.println("Our Inventory has changed, one is off flying. ");
		System.out.println();
		return jetList;
	}
}
