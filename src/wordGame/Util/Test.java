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
