package com.english.consonantfinder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class InterpretFile {

	private static String path = System.getProperty("user.dir");
	private static String file = path + "\\Files\\PhoneticDictionary.file";
	

	
	public static ArrayList<String> lines = new ArrayList<String>();
	public static ArrayList<Word> words = new ArrayList<Word>();
	
	public static void interpretFile() {
		
		try(FileReader reader = new FileReader(file)){
			BufferedReader br = new BufferedReader(reader);
			
			String line = "";
			while((line = br.readLine()) != null) {
				lines.add(line.toLowerCase());
				System.out.println(line.toLowerCase());
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < lines.size(); i++) {
			String temp = lines.get(i);
			for(int ch = 0; ch < temp.length() - 2; ch++) {
				if(temp.substring(ch, ch + 2).equals("  ")) {
					words.add(new Word(temp.substring(0, ch), i));
					System.out.println(words.get(i).getWord());
					words.get(i).addSounds(temp.substring(ch + 2, temp.length()));
					break;
				}
			}
		}
	}
}
