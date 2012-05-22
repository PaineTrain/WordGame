package wordGame.Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class DictTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dictionary myDict = new Dictionary();
		String filename = "res/clean_words2";
		String currentWord;
		try {
			Scanner wordScanner = new Scanner(new BufferedReader(new FileReader(filename)));
			while (wordScanner.hasNext()){
				currentWord = wordScanner.next();
				myDict.addWord(currentWord);
			}
			wordScanner.close();
		}
		catch (FileNotFoundException e){
			System.err.println("Dictionary file not found");
			return;
		}
		
		Scanner input = new Scanner(System.in);
		while (true){
			currentWord = input.next();
			System.out.println(myDict.find(currentWord));
		}
	}

}
