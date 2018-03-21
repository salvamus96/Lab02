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
	 

	 public String translateWordWildCard(String alienWildCard) {

			// Utilizzo le regual expression di Java.
			// Sostituisco il punto interrogativo con il punto.
			// Il punto indica qualsiasi carattere (posso usare stringa.matches())
			alienWildCard = alienWildCard.replaceAll("\\?", ".");

			int matchCounter = 0;
			StringBuilder sb = new StringBuilder();

			for (WordEnhanced w : dictionary) {
				if (w.compareWild(alienWildCard)) {
					matchCounter++;
					sb.append(w.elencoTraduzioni() + "\n");
				}
			}
			
			if (matchCounter != 0)
				return sb.toString();
			else
				return null;
		}
}

