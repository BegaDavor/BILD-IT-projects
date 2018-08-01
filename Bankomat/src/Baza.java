package src;

import java.util.ArrayList;

public class Baza {

	protected ArrayList<Account> users = new ArrayList<>();

	public Baza() {

	}

	public double getBalance(int id) {
		double balance = 0;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == id) {
				balance = users.get(i).getBalance();
			}
		}
		return balance;
	}
	

	public int getPosition(int id) {
		int position = 0;
		
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getId() == id) {
					position = i;
					break;
				}
			}
			return position;
		}
	
	public boolean userPostoji(int id) {
		boolean postoji = false;
		for(int i = 0; i < this.users.size(); i++) {
			if(this.users.get(i).getId() == id) {
				postoji = true;
				break;
			}
		}
		return postoji;
	}

	

	public void info(int id) {
		int infoId = getPosition(id);
		System.out.println("ID : " + users.get(infoId).getId());
		System.out.println("Name: " + users.get(infoId).getName());
		System.out.println("Balance: " + users.get(infoId).getBalance());
	}
}
