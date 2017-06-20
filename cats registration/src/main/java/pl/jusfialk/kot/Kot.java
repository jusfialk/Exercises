package pl.connectis.cschool.jusfialk.kot;

import java.util.Date;

public class Kot {
	String imie;
	Date data;
	Double waga;
	String imieOpiekuna;
	Integer wiek;

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setWaga(Double waga) {
		this.waga = waga;
	}

	public Double getWaga() {
		return waga;
	}

	public String getImieOpiekuna() {
		return imieOpiekuna;
	}

	public void setImieOpiekuna(String imieOpiekuna) {
		this.imieOpiekuna = imieOpiekuna;
	}

	public Integer getWiek() {
		return wiek;
	}

	public void setWiek(Integer wiek) {
		this.wiek = wiek;
	}

}
