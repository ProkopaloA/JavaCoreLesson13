package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Faction{
	private String nameOfdeputyGroup;

	public Faction (String nameOfdeputyGroup) {
		this.nameOfdeputyGroup = nameOfdeputyGroup;
	}
	

	public String getNameOfdeputyGroup() {
		return nameOfdeputyGroup;
	}

	public void setNameOfdeputyGroup(String nameOfdeputyGroup) {
		this.nameOfdeputyGroup = nameOfdeputyGroup;
	}


	List<Deputy> DeputyList = new ArrayList<>();

	public void addDeputy() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the surname of the deputy:");
		String surname = scanner.next();
		System.out.println("Enter the name of the deputy:");
		String name = scanner.next();
		System.out.println("Enter the age of the deputy:");
		int age = scanner.nextInt();
		System.out.println("Enter the height of the deputy:");
		float height = scanner.nextInt();
		System.out.println("Enter Deputy weight:");
		float weight = scanner.nextInt();
		System.out.println("Does the deputy take bribes (true/false):");
		boolean bribeTaker = scanner.nextBoolean();

		Deputy deputy = new Deputy(weight, height, surname, name, age, bribeTaker);
		if (bribeTaker) {
			deputy.isBribeTaker();
		}
		

		DeputyList.add(deputy);
		System.out.println("Deputy " + deputy.toString() + " successfully added to the faction!");
	}

	public void removeDeputy() {
		if (DeputyList.isEmpty()) {
			System.out.println("There are no deputies in your faction yet! Add them first! ");
		} else {
			Iterator<Deputy> iterator = DeputyList.iterator();
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the surname of the deputy:");
			String surname = scanner.next();
			System.out.println("Enter the name of the deputy:");
			String name = scanner.next();
			boolean flag = false;
			for (Deputy deputy : DeputyList) {
				if (deputy.getSurname().equalsIgnoreCase(surname) && deputy.getName().equalsIgnoreCase(name)) {
					flag = true;
				}
			}
				Iterator<Deputy> iterator1 = DeputyList.iterator();

				while (iterator1.hasNext()) {
					Deputy nextDeputy = iterator1.next();

					if (nextDeputy.getSurname().equalsIgnoreCase(surname) && nextDeputy.getName().equalsIgnoreCase(name)) {
						iterator1.remove();
						System.out.println("Deputy " + nextDeputy.toString() + " successfully removed from faction!");
					}
					else {
						System.out.println("The entered deputy does not exist!");
					}
				}
			}

		
	}
	public void BribeTakers() {
		System.out.println("Members of the faction who take bribes: ");
		for (Deputy deputy : DeputyList) {
			if (deputy.isBribeTaker()) {
				System.out.println(deputy.toString());
			}
		}
	}
	public void LargestBribeTaker() {
		int bribeSize = 0;
		int deputyIndex = -1;

		for (int i = 0; i < DeputyList.size(); i++) {
			if (DeputyList.get(i).isBribeTaker()) {
				if (DeputyList.get(i).getBribeSize() > bribeSize) {
					bribeSize = DeputyList.get(i).getBribeSize();
					deputyIndex = DeputyList.indexOf(DeputyList.get(i));
				}
			}
		}

		if (deputyIndex >= 0) {
			System.out.println("The biggest bribe taker of the faction " + DeputyList.get(deputyIndex).toString());
		} else {
			System.out.println("There are no bribe-takers in this batch!");
		}
	}
	public void AllDeputies() {
		System.out.println("Members of this faction:");
		for (Deputy deputy : DeputyList) {
			System.out.println(deputy.toString());
		}
	}
	public void clearDeputyGroup() {
		DeputyList.clear();
		System.out.println("Faction is empty!");
	}

	@Override
	public String toString() {
		return "DeputyGroup - nameOfdeputyGroup " + nameOfdeputyGroup + ", DeputyList: " + DeputyList;
	}
	
}
