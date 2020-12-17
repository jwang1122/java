package com.huaxia.learnrxjava;

public class Book {
	private String _id;
	private String title;
	private String author;
	private boolean read;
	private double price;
	private String rating;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public boolean isRead() {
		return read;
	}
	public void setRead(boolean read) {
		this.read = read;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Book [_id=" + _id + ", title=" + title + ", price=" + price + "]";
	}
	
}
