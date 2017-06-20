package pl.connectis.cschool.jusfialk.kot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class KotDAO {

	static Menu menu = new Menu();
	static boolean poprawny = false;
	List<Kot> koty = new ArrayList<>();

	static Scanner sc = new Scanner(System.in);

	public void dodajKota(Kot kot) {
		koty.add(kot);
	}

	public List<Kot> getKoty() {
		return koty;
	}

	public void wyswietlKoty() {

		System.out.println("#############################################################");
		System.out.println("#                                                           #");
		System.out.println("#                   ***LISTA KOTOW  ***                     #");
		System.out.println("#                                                           #");
		System.out.println("#############################################################\n");

		System.out.println("W bazie istnieje " + (koty.size()) + " zapisanych kotow");

		// dla kazdego kota z kolekcji koty typu Kot
		for (Kot kot : koty) {
			System.out.println("Kot numer " + (koty.indexOf(kot)) + " ma na imie: " + kot.getImie());

		}

		// TO SAMO W INNY SPOSOB
		// Kot kot;
		// for (int i=0; i<getKoty().size(); i++) {
		// kot = getKoty().get(i);
		// System.out.println(i + ": " + kot.getImie());
		// }

	}

	public void wypiszKota(int numerKota) {

		System.out.println("\n");
		System.out.println("#############################################################");
		System.out.println("#                                                           #");
		System.out.println("#                   ***WYBRANY KOT***                       #");
		System.out.println("#                                                           #");
		System.out.println("#############################################################");
		System.out.println("Wybrales numer: " + koty.get(numerKota));
		System.out.println("Kot ma na imie: " + koty.get(numerKota).getImie());
		System.out.println("Urodzil sie: " + koty.get(numerKota).getData());
		System.out.println("Wazy: " + koty.get(numerKota).getWaga() + " kg");
		System.out.println("Opiekun to: " + koty.get(numerKota).getImieOpiekuna());
		System.out.println("Ma lat: " + koty.get(numerKota).getWiek());

		System.out.println("\nJesli chcesz wrocic do MENU, wybierz [1]");
		System.out.println("Jesli chcesz wyjsc z programu, wybierz [2]");
		do {
			if (sc.nextLine().matches("1")) {
				menu.menu();
				poprawny = true;
			} else if (sc.nextLine().matches("2")) {
				menu.wyjscie();
				poprawny = true;
			} else {
				System.out.println("Nie ma takiej opcji. Sprobuj raz jeszcze!");
				poprawny = false;
			}
		} while (poprawny == false);

	}

}
