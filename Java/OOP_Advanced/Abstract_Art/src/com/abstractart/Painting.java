package com.abstractart;

public class Painting extends Art {

	private String paintType;

	public Painting(String title, String author, String description, String paintType) {
		super(title, author, description);
		this.paintType = paintType;
	}

	public String getPaintType() {
		return paintType;
	}

	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}

	@Override
	public void viewArt() {
		System.out.println(String.format("\nTitle: %s\nAuthor: %s\nDescription: %s\nPaint Type: %s", title, author,
				description, paintType));
	}

}
