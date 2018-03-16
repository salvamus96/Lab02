package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

public class AlienDictionary {
	
	private List <Word> dictionary;
	
	public AlienDictionary () {
		dictionary = new LinkedList <> ();
	}
	
	
	
	public List<Word> getDictionary() {
		return dictionary;
	}

	public void setDictionary(List<Word> dictionary) {
		this.dictionary = dictionary;
	}



	public void addWord(String alienWord, String translation) {
		Word parola = new Word (alienWord, translation);
		for (Word w : dictionary) 
			 if (w.getAlienWord().equals(alienWord)) {
				 w.setTranslation(translation);
				 return ;
			 }
		dictionary.add(parola);	
	}
	
	 public String translateWord(String alienWord) {
		 for (Word w : dictionary) {
			 if (w.getAlienWord().equals(alienWord))
				 return w.getTranslation();
		 }
		 return null;
	 }


}

