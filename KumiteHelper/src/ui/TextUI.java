package ui;

import logic.KumiteHelperLogic;
import java.util.*;

public class TextUI {
	private Scanner scanner;
	private KumiteHelperLogic kumiteHelperLogic;
	
	public TextUI() {
		this.scanner = new Scanner(System.in);
		this.kumiteHelperLogic = new KumiteHelperLogic();
	}
	
	public void start() {
		System.out.println("Welcome to the Kumite Helper!");
		System.out.println("<--------------------------->");
		
		while (true) {
			System.out.println("[1] Add a contestant\n" 
							+ "[2] Add a weightclass\n" 
							+ "[3] Print all contestants\n" 
							+ "[4] Print all weightclasses\n" 
							+ "[5] Add contestants to weightclass\n"
							+ "[x] Quit");
			String inputCommand = scanner.nextLine();
			
			if (inputCommand.equals("x")) {
				break;
			} else if (inputCommand.equals("1")) {
				System.out.println("First name:");
				String inputFirstName = scanner.nextLine();
				System.out.println("Last name:");
				String inputLastName = scanner.nextLine();
				System.out.println("Gender:");
				String inputGenderUnconverted = scanner.nextLine();
				char inputGender = inputGenderUnconverted.charAt(0);
				if (!(inputGender == 'm')) {
					if (!(inputGender == 'f')) {
						System.out.println("Gender must be either m or f");
						continue;
					}
				}
				
				System.out.println("Weight");
				double inputWeight = 0;
				try {
					inputWeight = Double.valueOf(scanner.nextLine());
				} catch (Exception e) {
					System.out.println("Weight must be a double");
					continue;
				}
				
				System.out.println("Grade");
				String inputGrade = scanner.nextLine();
				
				kumiteHelperLogic.addContestant(inputFirstName, inputLastName, inputGender, inputWeight, inputGrade);
			} else if (inputCommand.equals("2")) {
				System.out.println("Give weight (\"under xx\")");
				double inputMaxWeight = 0;
				try {
					inputMaxWeight = Double.valueOf(scanner.nextLine());
				} catch (Exception e) {
					System.out.println("Weight must be a double");
					continue;
				}
				
				System.out.println("Enter gender of contestants");
				String unconvertedForWeightClass = scanner.nextLine();
				char inputGenderForWeightClass = unconvertedForWeightClass.charAt(0);
				if (!(inputGenderForWeightClass == 'm')) {
					if (!(inputGenderForWeightClass == 'f')) {
						System.out.println("Gender must be either m or f");
						continue;
					}
				}
				kumiteHelperLogic.addWeightClass(inputMaxWeight, inputGenderForWeightClass);
			} else if (inputCommand.equals("3")) {
				kumiteHelperLogic.printAllContestants();
			} else if (inputCommand.equals("4")) {
				kumiteHelperLogic.printAllWeightClasses();
				
			} else if (inputCommand.equals("5")) {
				System.out.println("For which weightclass?");
				double weightForWeightClass = 0;
				try {
					weightForWeightClass = Double.valueOf(scanner.nextLine());
				} catch (Exception e) {
					System.out.println("Weight must be a double");
					continue;
				}
				
				System.out.println("For which gender?");
				String genderForWeightClassUnconverted = scanner.nextLine();
				char genderForWeightClass = genderForWeightClassUnconverted.charAt(0);
				if (!(genderForWeightClass == 'm')) {
					if (!(genderForWeightClass == 'f')) {
						System.out.println("Gender must be either m or f");
						continue;
					}
				}
				kumiteHelperLogic.addContestantsToWeightClass(kumiteHelperLogic.getWeightClass(weightForWeightClass, genderForWeightClass), genderForWeightClass);
				System.out.println(kumiteHelperLogic.getWeightClass(weightForWeightClass, genderForWeightClass).getContestantsInClass());
			}
		}
	}
}
