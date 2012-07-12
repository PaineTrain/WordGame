/*******************************************************************************
 * Copyright (c) 2012 Harrison Paine
 *
 * Permission is hereby granted, free of charge, to any person 
 * obtaining a copy of this software and associated documentation 
 * files (the "Software"), to deal in the Software without restriction, 
 * including without limitation the rights to use, copy, modify, merge, 
 * publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, 
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included 
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, 
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO 
 * THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS 
 * BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *******************************************************************************/
package wordGame.Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class DictTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dictionary myDict = new Dictionary();
		Dictionary myDict2;
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
		try {
			myDict2 = Dictionary.createDictionaryFromURL(new URL(WebUtil.WEBGETDICTIONARY + "1"));
		}
		catch (MalformedURLException e){
			myDict2 = new Dictionary();
		}
		
		Scanner input = new Scanner(System.in);
		while (true){
			currentWord = input.next();
			System.out.println("Local Dict: " + myDict.find(currentWord));
			System.out.println("Online Dict: " + myDict2.find(currentWord));
		}
	}

}
