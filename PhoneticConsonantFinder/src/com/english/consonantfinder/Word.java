package com.english.consonantfinder;

import java.util.ArrayList;

public class Word {

	public String word, vowels = "aeiou";
	public String[] phonetics;
	public int index = 0;
	public ArrayList<String> consonantSounds = new ArrayList<String>();
	
	public Word(String word, int index) {
		this.word = word;
		this.index = index;
	}
	
	public void addSounds(String sounds) {
		
		phonetics = sounds.split(" ");
		for(String string:phonetics) {
			//System.out.println(string);
			boolean isVowel = false;
			for(int i = 0; i < vowels.length(); i++) {
				if(string.substring(0,1).equals(vowels.substring(i, i+1))){
					isVowel = true;
					break;
				}
			}
			if(!isVowel) {
				consonantSounds.add(string);
				System.out.println(string);
			}
		}
	}
	
	public void calcScore() {
		
	}
	
	public ArrayList<String> getConsonantSounds(){
		return consonantSounds;
	}
	
	public String getWord() {
		return word;
	}
	
}
