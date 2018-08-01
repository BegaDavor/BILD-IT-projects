package src;

import java.util.Scanner;

public class Bankomat {
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

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Baza baza = new Baza();
		int opcija = -1;
		String opcijaTemp;
		do {
			do {
			System.out.println("1 - register, \n2 - transfer, \n3 - info, \n0 - izlaz");
			opcijaTemp = input.next();
			}while (jeBroj(opcijaTemp) == false);
			opcija = Integer.parseInt(opcijaTemp);
			switch (opcija) {

			case 0:
				break;

			case 1:
				Account account = new Account();
				baza.users.add(account);
				break;

			case 2:
				int tempIzlaz;
				int sourceAccount;
				int targetAccount;
				double uplata;
				String id1;
				String id2;
				String uplataTemp;
				String idInfoTemp;
				do {
				System.out.println("Unesite ID racuna koji salje novac: ");
				id1 = input.next();
				}while(jeBroj(id1) == false && baza.userPostoji(Integer.parseInt(id1)) == false);
				sourceAccount = Integer.parseInt(id1);
				tempIzlaz = baza.getPosition(sourceAccount);
				do {
				System.out.println("Unesite ID racuna koji prima novac: ");
				id2 = input.next();
				}while(jeBroj(id2) == false && baza.userPostoji(Integer.parseInt(id2)) == false);
				targetAccount = Integer.parseInt(id2);
				do {
				System.out.println("Unesite kolicinu novca koju prenosite: ");
				uplataTemp = input.next();
				}while(jeBroj(uplataTemp) == false);
				uplata = Integer.parseInt(uplataTemp);
				if (uplata <= baza.users.get(tempIzlaz).getBalance()) {
					baza.users.get(baza.getPosition(sourceAccount)).smanjiBalance(uplata);
					baza.users.get(baza.getPosition(targetAccount)).povecajBalance(uplata);
				} else
					System.out.println("Nemate dovoljno sredstava na racunu.");
				break;
			case 3:
				do {
				System.out.println("Upisite vas ID: ");
				idInfoTemp = input.next();
				}while(jeBroj(idInfoTemp) == false);
				int idInfo = Integer.parseInt(idInfoTemp);
				int position = baza.getPosition(idInfo);
				baza.info(baza.users.get(position).getId());
				break;
			default:
				System.out.println("Unos nije dobar.");
			}
		} while (opcija != 0);
		input.close();
	}
}
