package dev.bonjugi.boottemp.ebooknbook;

public class PaperBook extends Book{

	public PaperBook(String title, double v) {
		super(title);
	}

	public PaperBook(String title, int amount, double discount) {
		super(title, amount, discount);
	}

}
