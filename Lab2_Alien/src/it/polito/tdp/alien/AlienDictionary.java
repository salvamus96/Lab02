package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

public class AlienDictionary {
	
	private List <WordEnhanced> dictionary;
	
	public AlienDictionary () {
		dictionary = new LinkedList <> ();
	}
	
	
	
	public List<WordEnhanced> getDictionary() {
		return dictionary;
	}

	public void setDictionary(List<WordEnhanced> dictionary) {
		this.dictionary = dictionary;
	}



	public void addWord(String alienWord, String translation) {
		WordEnhanced parola = new WordEnhanced (alienWord, translation);
		for (WordEnhanced w : dictionary) 
			 if (w.getAlienWord().equals(alienWord) && !w.getTranslation().equals(translation)) {
				 w.addTranslations(translation);
				 return ;
			 }
		dictionary.add(parola);	
	}
	
	 public String translateWord(String alienWord) {
		 for (WordEnhanced w : dictionary) {
			 if (w.getAlienWord().equals(alienWord))
				 return w.elencoTraduzioni();
		 }
		 return null;
	 }


}

