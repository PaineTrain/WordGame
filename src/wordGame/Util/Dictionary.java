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
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.util.Scanner;

public class Dictionary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3257275693596581421L;
	private TrieNode root;
	
	public Dictionary(){
		root = new TrieNode(null, false);
	}
	
	public static Dictionary createDictionaryFromURL(URL inputURL){
		Dictionary returnDictionary = new Dictionary();
		String currentWord;
		
		try {
			Scanner wordScanner = new Scanner(new BufferedReader(new InputStreamReader(inputURL.openStream())));
			while (wordScanner.hasNext()){
				currentWord = wordScanner.next();
				returnDictionary.addWord(currentWord);
			}
			wordScanner.close();
		}
		catch (IOException e){
			System.err.println("Error Loading Dictionary File!");
		}
		return returnDictionary;
		
	}
	
	private void addWord(TrieNode node, String word){
		String currentLetter = Character.toString(word.charAt(0));
		boolean lastLetter = (word.length() == 1);
		for(TrieNode child : node.getChildren()){
			if (child.getData().equals(currentLetter)){
				if (lastLetter){
					child.setEndOfWord(true);
					return;
				}
				else {
					addWord(child, word.substring(1));
					return;
				}
			}
		}
		TrieNode newNode = new TrieNode(currentLetter, lastLetter);
		node.addChild(newNode);
		if (lastLetter){
			return;
		}
		else {
			addWord(newNode, word.substring(1));
		}
		
		
	}
	public void addWord(String word){
		addWord(root, word);
	}
	public boolean find(String word){
		return find(root, word);
	}
	private boolean find(TrieNode node, String word){
		String currentLetter = Character.toString(word.charAt(0));
		boolean lastLetter = (word.length() <= 1);
		if (lastLetter){
			for (TrieNode child : node.getChildren()){
				if (child.getData().equals(currentLetter) && child.isEndOfWord()){
					return true;
				}
			
			}
			return false;
		}
		else {
			for (TrieNode child : node.getChildren()){
				if (child.getData().equals(currentLetter)){
					return find(child, word.substring(1));
				}
			}
			
		}
		return false;
	}

}
