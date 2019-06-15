package dev.bonjugi.boottemp.ebooknbook;

import java.util.Objects;

public class Book {


	protected int amount;
	protected double discount;
	protected String title;

	public static Book paperBook(String title, int amount) {
		return new PaperBook(title, amount, 1.0);
	}

	public static Book ebook(String title, int amount) {
		return new Ebook(title, amount, 0.8);
	}

	public static Book paperBook(String title) {
		return new PaperBook(title, 1.0);
	}

	public static Book ebook(String title) {
		return new Ebook(title, 0.8);
	}


	public int getAmount() {
		return (int)(amount * discount);
	}

	public String getTitle() {
		return this.title;
	}


	public Book(String title) {
		this.title = title;
	}

	public Book(String title, int amount, double discount) {
		this.amount=amount;
		this.title=title;
		this.discount=discount;
	}


	public Ebook toEbook() {
		return new Ebook(title, amount, 0.8);
	}



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Book book = (Book) o;
		if(title==null || book.title == null) return false;
		return Objects.equals(title, book.title);
	}


	@Override
	public int hashCode() {
		return Objects.hash(title);
	}

	@Override
	public String toString() {
		return "Book{" +
				"amount=" + amount +
				", discount=" + discount +
				", title='" + title + '\'' +
				'}';
	}
}
