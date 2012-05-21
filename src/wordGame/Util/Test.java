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
/**
 * 
 */
package wordGame.Util;

import java.util.Scanner;

/**
 * @author Harrison
 *
 */
public class Test {

	public static void main(String args[]){
		LetterData[] TestValues = new LetterData[16];
		String[] TestStrings = {"D", "O", "P", "R"
		                      , "K", "T", "D", "O"
		                      , "N", "A", "S", "E"
		                      , "E", "R", "I", "N"};
		LetterData[] TestList = {new LetterData("D"), new LetterData("O"), new LetterData("N"), new LetterData("T")};
		for (int i = 0; i < TestValues.length; i++){
			TestValues[i] = new LetterData(TestStrings[i]);
		}
		Board myBoard = new Board(TestValues, 4, 4);
		System.out.print(myBoard.toString());
		
		myBoard.findPath(TestList);
		System.out.println(myBoard.toString());
		
		try {
			myBoard = BoardGenerator.generateCubesFromFile("res/Big.qbe");
		}
		catch (Exception e){
			
		}
		
	
	
		String currentWord;
		Scanner input = new Scanner(System.in);
		while (true){
			
			System.out.println(myBoard.toString());
			currentWord = input.next();
			myBoard.clear();
			myBoard.findPath(LetterData.convertString(currentWord));
		}
	}
}
