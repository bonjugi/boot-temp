package dev.bonjugi.boottemp.ebooknbook;

public class Ebook extends Book{

	public Ebook(String title, double v) {
		super(title);
	}

	public Ebook(String title, int amount, double discount) {
		super(title, amount, discount);
	}

}
