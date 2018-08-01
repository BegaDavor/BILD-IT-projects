package src;

import java.util.Scanner;

public class Account extends Baza {

	private int id;
	private String name;
	private double balance;
	static Scanner input = new Scanner(System.in);

	public Account() {
		this.id = (int) (Math.random() * 100000);
		System.out.println("Vas ID je: " + this.id);
		System.out.println("Unesite vase ime: ");
		this.name = input.nextLine();
		do {
			String balanceTemp;
			do {
			System.out.println("Koliko novca uplacujete: ");
			balanceTemp = input.next();
			}while(jeBroj(balanceTemp) == false);
			this.balance = Double.parseDouble(balanceTemp);
			input.nextLine();
			if (isValidBalance(this.balance) == false)
				System.out.println("Doslo je do greske.");
		} while (isValidBalance(this.balance) == false);
	}
	
	public Account(int id, String name, double balance) {
		setId(id);
		setName(name);
		setBalance(balance);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void setId(int id) {
		this.id = id;
	}

	public boolean isValidBalance(double balance) {
		boolean valid = true;

		if (balance < 0) {
			valid = false;
		}
		return valid;
	}
	
	public void povecajBalance(double money) {
		this.balance += money;
	}
	public void smanjiBalance(double money) {
		this.balance -= money;
	}
	public static boolean jeBroj(String broj) {
		boolean jeBroj = true;

		for (int i = 0; i < broj.length(); i++) {
			if (Character.isLetter(broj.charAt(i))) {
				jeBroj = false;
				break;
			}
		}

		return jeBroj;
	}

}
