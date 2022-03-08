package com.abstractart;

import java.util.ArrayList;

public class Museum {

	public static void main(String[] args) {
		ArrayList<Art> museum = new ArrayList<Art>();
		// TODO Auto-generated method stub
		Painting monaLisa = new Painting("Mona Lisa", "Leonardo da Vinci", "Very famous", "Oil");
		Painting starryNight = new Painting("Starry Night", "Vincent van Gogh", "Good", "Oil");
		Painting americanGothic = new Painting("American Gothic", "Grant Wood", "Very Good", "Oil on beaverboard");

		Sculpture venusOfWillendorf = new Sculpture("Venus of Willendorf", "Josef Szombathy", "Interesting",
				"Limestone, Red ochre");
		Sculpture nefertiti = new Sculpture("Nefertiti Bust", "Thutmose", "Ancient", "Limestone and stucco");

		museum.add(monaLisa);
		museum.add(starryNight);
		museum.add(americanGothic);
		museum.add(venusOfWillendorf);
		museum.add(nefertiti);

		for (Art item : museum) {
			item.viewArt();
		}

	}

}
