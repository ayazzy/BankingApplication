import java.util.Scanner;

public class Application {
	public static Scanner scan = new Scanner(System.in);
	static double balance;
	static double previousTrans;
	static double depositValue;
	static double withdrawnValue;

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Hello and welcome to this banking application");
		Thread.sleep(1000);
		System.out.println("What is your name?");
		String name = scan.nextLine();
		Thread.sleep(1000);
		System.out.println("What would you like to do today " + name + "?");
		menu();
	}

	public static void menu() {
		System.out.println("1. Deposit \n2. Withdraw \n3. Check Balance \n4. Previous Transaction \n5. Quit");
		int choice = scan.nextInt();
		if (choice == 1) {
			deposit();
		} else if (choice == 2) {
			withdraw();
		} else if (choice == 3) {
			checkBalance();
		} else if (choice == 4) {
			previousTransaction();
		} else if (choice == 5) {
			return;
		}

	}

	private static void previousTransaction() {
		System.out.println("Your previous transaction was " + previousTrans + "\n");
		menu();

	}

	private static void checkBalance() {
		System.out.println("Your balance is: $" + balance + "\n");
		menu();
	}

	private static void withdraw() {
		System.out.println("How much would you like to withdraw?" + "\n");
		withdrawnValue = scan.nextDouble();
		if (withdrawnValue > balance) {
			System.out.println("You do not have sufficient funds to withdraw." + "\n");
			System.out.println("You have " + balance + " dollars in your bank acocunt." + "\n");
			System.out.println("Would you like to withdraw a different amount? if Yes press 1/if No press 2" + "\n");
			int wChoice = scan.nextInt();
			if (wChoice == 1) {
				withdraw();
			} else {
				menu();
			}
		}
		if (withdrawnValue <= balance) {
			balance = balance - withdrawnValue;
			previousTrans = -withdrawnValue;
			System.out.println("You have withdrawn: $" + withdrawnValue + "\n");
			System.out.println("your remaining balance is: $" + balance + "\n");
			menu();
		} else {
			System.out.println("You have inputted an invalid answer sending you back to the menu." + "\n");
			menu();
		}

	}

	private static void deposit() {
		System.out.println("How much would you like to deposit?");
		depositValue = scan.nextDouble();
		if (depositValue == depositValue) {
			balance = balance + depositValue;
			previousTrans = +depositValue;
			System.out.println("You have successfully deposited: $" + depositValue + "\n");
			menu();

		} else {
			System.out.println("You have inputted an invalid value to deposit, sending you back to the menu");
			menu();

		}

	}

}
