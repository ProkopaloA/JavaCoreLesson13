package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class SupremeCouncil {
	private static SupremeCouncil instance = new SupremeCouncil();

	private SupremeCouncil() {
	}

	public static SupremeCouncil getInstance() {
		if (instance == null) {
			instance = new SupremeCouncil();
		}

		return instance;
	}

	ArrayList<Faction> supremeCouncilArray = new ArrayList<Faction>();

	public void addFaction() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the faction:");
		String nameOfdeputyGroup = scanner.nextLine();
		Faction faction = new Faction(nameOfdeputyGroup);
		supremeCouncilArray.add(faction);
		System.out.println(faction.toString() + " successfully added to the Supreme Council!");
	}

	public void removeFaction() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the faction:");
		String nameOfdeputyGroup = scanner.next();

		boolean typeCorrect = isFactionExists(supremeCouncilArray, nameOfdeputyGroup);

		if (typeCorrect) {

			Iterator<Faction> iterator = supremeCouncilArray.iterator();

			while (iterator.hasNext()) {
				Faction nextFaction = iterator.next();

				if (nextFaction.getNameOfdeputyGroup().equalsIgnoreCase(nameOfdeputyGroup)) {
					iterator.remove();
					System.out.println(nextFaction.toString() + " successfully removed from the Verkhovna Rada!");
				}
			}

		} else {
			System.out.println("There is no faction introduced in the Verkhovna Rada!");
		}
	}

	public void AllFaction() {
		System.out.println("Factions registered in Verkhovna Rada:");
		for (Faction deputyGroup : supremeCouncilArray) {
			System.out.println(deputyGroup.toString());
		}
	}

	public void clearFaction() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the faction:");
		String nameOfdeputyGroup = scanner.next();

		boolean typeCorrect = isFactionExists(supremeCouncilArray, nameOfdeputyGroup);

		if (typeCorrect) {
			for (Faction faction : supremeCouncilArray) {
				if (faction.getNameOfdeputyGroup().equalsIgnoreCase(nameOfdeputyGroup)) {
					faction.clearDeputyGroup();
				}
			}

		} else {
			System.out.println("There is no faction introduced in the Verkhovna Rada!");
		}
	}

	public void getFaction() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the faction:");
		String nameOfdeputyGroup = scanner.next();

		for (Faction faction : supremeCouncilArray) {
			if (faction.getNameOfdeputyGroup().equalsIgnoreCase(nameOfdeputyGroup)) {
				System.out.println(faction.toString());
				faction.AllDeputies();
			}
		}
	}

	public void addDeputyToFaction() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the faction:");
		String nameOfdeputyGroup = scanner.next();

		boolean typeCorrect = isFactionExists(supremeCouncilArray, nameOfdeputyGroup);

		if (typeCorrect) {
			for (Faction faction : supremeCouncilArray) {
				if (faction.getNameOfdeputyGroup().equalsIgnoreCase(nameOfdeputyGroup)) {
					faction.addDeputy();
				}
			}

		} else {
			System.out.println("There is no faction introduced in the Verkhovna Rada!");
		}
	}

	public void removeDeputyFromFaction() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the faction:");
		String nameOfdeputyGroup = scanner.next();

		boolean typeCorrect = isFactionExists(supremeCouncilArray, nameOfdeputyGroup);

		if (typeCorrect) {
			for (Faction faction : supremeCouncilArray) {
				if (faction.getNameOfdeputyGroup().equalsIgnoreCase(nameOfdeputyGroup)) {
					faction.removeDeputy();
				}
			}

		} else {
			System.out.println("There is no faction introduced in the Verkhovna Rada!");
		}
	}

	public void BribeTakersFromFaction() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the faction:");
		String nameOfdeputyGroup = scanner.next();

		boolean typeCorrect = isFactionExists(supremeCouncilArray, nameOfdeputyGroup);

		if (typeCorrect) {
			for (Faction faction : supremeCouncilArray) {
				if (faction.getNameOfdeputyGroup().equalsIgnoreCase(nameOfdeputyGroup)) {
					faction.BribeTakers();
				}
			}

		} else {
			System.out.println("There is no faction introduced in the Verkhovna Rada!");
		}
	}

	public void LargestBribeTakerFromFaction() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the faction:");
		String nameOfdeputyGroup = scanner.next();

		boolean typeCorrect = isFactionExists(supremeCouncilArray, nameOfdeputyGroup);

		if (typeCorrect) {
			for (Faction faction : supremeCouncilArray) {
				if (faction.getNameOfdeputyGroup().equalsIgnoreCase(nameOfdeputyGroup)) {
					faction.LargestBribeTaker();
				}
			}

		} else {
			System.out.println("There is no faction introduced in the Verkhovna Rada!");
		}
	}

	public void getAllDeputiesFromFaction() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the faction:");
		String nameOfdeputyGroup = scanner.next();

		boolean typeCorrect = isFactionExists(supremeCouncilArray, nameOfdeputyGroup);

		if (typeCorrect) {
			for (Faction faction : supremeCouncilArray) {
				if (faction.getNameOfdeputyGroup().equalsIgnoreCase(nameOfdeputyGroup)) {
					faction.AllDeputies();
					;
				}
			}

		} else {
			System.out.println("There is no faction introduced in the Verkhovna Rada!");
		}
	}

	static boolean isFactionExists(ArrayList<Faction> supremeCouncilArray, String nameOfdeputyGroup) {
		boolean flag = false;

		for (Faction faction : supremeCouncilArray) {
			if (faction.getNameOfdeputyGroup().equalsIgnoreCase(nameOfdeputyGroup)) {
				flag = true;
			}
		}

		return flag;
	}

}
