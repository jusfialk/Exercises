package pl.connectis.cschool.jusfialk.kot;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {

	static Scanner sc = new Scanner(System.in);
	static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
	static KotDAO kotDAO = new KotDAO();
	static boolean poprawny;

	public static void menu() {

		Main main = new Main();

		System.out.println("#############################################################");
		System.out.println("#                                                           #");
		System.out.println("#                        ***MENU***                         #");
		System.out.println("#                                                           #");
		System.out.println("#############################################################");
		System.out.println("[1] Dodaj kota ");
		System.out.println("[2] Pokaz koty ");
		System.out.println("[3] Zamknij program \n");

		System.out.println("Wybierz opcję i zatwierdź klawiszem ENTER");
		String wyborUzytkownika = (sc.nextLine());

		do {

			switch (wyborUzytkownika) {
			case "1":
				dodajKota();
				poprawny = true;
				break;
			case "2":
				kotDAO.wyswietlKoty();

				System.out.println("\nWybierz numer kota, który ma się przedstawić i zatwierdź klawiszem ENTER");

				String numerWczytany = sc.nextLine();
				Pattern wzorzecNumeru = Pattern.compile("[0-9]+");
				Matcher matcher = wzorzecNumeru.matcher(numerWczytany);
				matcher.matches();
				do {
					numerWczytany = sc.nextLine();
					int numerKota = Integer.parseInt(numerWczytany);

					if (kotDAO.koty.size() >= numerKota && numerKota >= 0) {
						kotDAO.wypiszKota(numerKota);
						poprawny = true;
					} else {
						System.out.println("\nW bazie nie istnieje kot o takim numerze. Sprobuj raz jeszcze");
					}
				} while (matcher.matches() == true && poprawny == false);

				// do {
				// numerKota = Integer.parseInt(sc.nextLine());
				// if (numerKota >= 0 && numerKota < kotDAO.koty.size()) {
				// poprawny = true;
				// kotDAO.wypiszKota(numerKota);
				// } else {
				// System.out.println("Błędny numer kota! Podaj numer
				// ponownie.");
				// poprawny = false;
				// }
				// }
				// while (poprawny == false); //gdy zle numer, to wchodzi raz
				// jeszcze

				break;
			case "3":
				wyjscie();
				poprawny = true;
				break;
			default:
				System.out.println("Nie ma takiej opcji. Sprobuj raz jeszcze");
				poprawny = false;
				break;
			}
		} while (poprawny = false);
	}

	public static void dodajKota() {

		System.out.println("#############################################################");
		System.out.println("#                                                           #");
		System.out.println("#                   ***DODAJ KOTA***                        #");
		System.out.println("#                                                           #");
		System.out.println("#############################################################");

		Kot kot = new Kot();

		// IMIE KOTA
		System.out.print("Podaj imie kota: ");
		kot.setImie(sc.nextLine());

		// OPIEKUN KOTA
		System.out.print("Podaj imie opiekuna kota: ");
		kot.setImieOpiekuna(sc.nextLine());

		// WIEK KOTA
		System.out.println("Podaj wiek kota: ");
		boolean prawidlowyWiek = false;

		do {
			try {
				int wiek = Integer.parseInt(sc.nextLine());
				if (wiek > 0) {
					kot.setWiek(wiek);
					prawidlowyWiek = true;

				} else
					System.out.println("Nieodpowiedni wiek zartownisiu. Sprobuj raz jeszcze");
			} catch (NumberFormatException nfe) {
				System.out.println("Zly format! Wiek podajemy cyframi. Sprobuj raz jeszcze");
			}
		} while (prawidlowyWiek == false);

		// DATA URODZENIA
		System.out.println("Podaj date urodzenia kota (dzien.miesiac.rok): ");

		// String data;
		// Pattern patternData =
		// Pattern.compile("[0-1]?[0-9].[0-3]?[0-9].[0-9]{4}.");
		// //Matcher matcher = patternData.matcher(data);
		// //matcher.matches();
		//
		// do {
		// data = sc.nextLine();
		// if(patternData.matcher(data).matches() == true){
		// try{
		// kot.setData(sdf.parse(data));
		// } catch (ParseException pe) {
		// System.out.println("Coś jest nie tak z formatem daty! Sprobuj raz
		// jeszcze");
		// }
		// }
		// } while (kot.getData() == null);
		//
		Date data;
		do {
			try {
				data = sdf.parse(sc.nextLine());
				kot.setData(data);
			} catch (ParseException pe) {
				System.out.println("Coś jest nie tak z formatem daty! Sprobuj raz jeszcze");
			}
		} while (kot.getData() == null);

		// WAGA KOTA
		System.out.println("Podaj wage kota w kilogramach (w formacie XX.YY ): ");

		do {
			String wagaUzytkownika = sc.nextLine();
			Pattern patternWaga = Pattern.compile("([0-9]+\\.[0-9]+)");
			Matcher matcher = patternWaga.matcher(wagaUzytkownika);
			matcher.matches();

			if (matcher.matches() == true) {
				kot.setWaga(Double.valueOf(wagaUzytkownika));
			} else {
				System.out.println("Nieprawidlowa waga! Wprowadz ponownie!");
			}
		} while (kot.getWaga() == null);

		// do {
		// try {
		// kot.setWaga(Double.valueOf(sc.nextLine()));
		// } catch (NumberFormatException e) {
		// System.out.println("Zły format! Spróbuj raz jeszcze");
		// }
		// } while (kot.getWaga() == null);

		System.out.println("!!!Kot poprawnie dodany do bazy!!!.\n");
		kotDAO.dodajKota(kot);

		System.out.println("\nJesli chcesz wrocic do MENU, wybierz [1]");
		System.out.println("Jesli chcesz dodac kolejnego kota, wybierz [2]");
		do {
			if (sc.nextLine().matches("2")) {
				dodajKota();
				poprawny = true;
			} else if (sc.nextLine().matches("1")) {
				menu();
				poprawny = true;
			} else {
				System.out.println("Nie ma takiej opcji. Sprobuj raz jeszcze!");
				poprawny = false;
			}
		} while (poprawny == false);
	}

	public static void wyjscie() {
		System.out.println("#############################################################");
		System.out.println("#                                                           #");
		System.out.println("#                     ***WYJSCIE***                         #");
		System.out.println("#                                                           #");
		System.out.println("#############################################################\n");

		System.out.println("Czy na pewno chcesz wyjsc? y/n");

		if (sc.nextLine().matches("n")) {
			menu();
		} else if (sc.nextLine().matches("y")) {
			try {
				Thread.sleep(500);
				System.exit(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
