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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Harrison
 * Helper class to generate board instances from static .qbe files
 * See QBEspec.txt for information for formatting and behavioral specifics of .qbe files
 */
public class BoardGenerator {
	
	private static final int DEFAULT_ROWS = 4;
	private static final int DEFAULT_COLS = 4;
	/**
	 * 
	 * @param filename
	 * @param row
	 * @param col
	 * @return
	 */
	
	public static Board generateCubesFromScanner(Scanner fileScanner, int row, int col) throws NumberFormatException {
		Scanner cubeScanner = null;
		int numRows = row;
		int numCols = col;
		if (numRows == 0)
			numRows = DEFAULT_ROWS;
		if (numCols == 0)
			numCols = DEFAULT_COLS;
		try{
			
			// cubeScanner = new Scanner(new BufferedReader(new FileReader(filename)));
			cubeScanner = fileScanner;
			String currentLine = null;
			ArrayList<LetterData[]> cubes = new ArrayList<LetterData[]>();
			while (cubeScanner.hasNext()){
				currentLine = cubeScanner.next();
				if (currentLine.charAt(0) != '#' && !currentLine.contains(":|\\d")) {
					
					currentLine.toUpperCase();
					currentLine.trim();
					currentLine.replaceAll("\\s\\d:", "");
					LetterData[] cube = new LetterData[currentLine.length()];
					for (int i = 0; i < currentLine.length(); i++){
						cube[i] = new LetterData(currentLine.charAt(i));
					}
					cubes.add(cube);
				}
				if (currentLine.matches("\\d:\\d")){
					String[] RowCol = currentLine.split(":");
					numRows = Integer.parseInt(RowCol[0]);
					numCols = Integer.parseInt(RowCol[1]);
				}
			}
			int boardSize = numRows * numCols;
			LetterData[] boardLetters = new LetterData[boardSize];
			Random rng = new Random();
			if (boardSize > cubes.size()){
				ArrayList<LetterData[]> discardCubes = new ArrayList<LetterData[]>();
				for (int i = 0; i < boardSize; i++){
					if (cubes.size() == 0 && discardCubes.size() > 0){
						cubes = discardCubes;
						discardCubes = new ArrayList<LetterData[]>();
					}
					LetterData[] randomCube = cubes.remove(rng.nextInt(cubes.size()));
					discardCubes.add(randomCube);
					boardLetters[i] = randomCube[rng.nextInt(randomCube.length)];
				}
			}
			else{
				for (int i = 0; i < boardSize; i++){
					LetterData[] randomCube = cubes.remove(rng.nextInt(cubes.size()));
					boardLetters[i] = randomCube[rng.nextInt(randomCube.length)];
				}
			}
			
			LetterData[] newBoardLetters = new LetterData[boardSize];
			LetterData currentLetter;
			for (int i = 0; i < boardSize; i++){
				currentLetter = boardLetters[i];
				newBoardLetters[i] = new LetterData(currentLetter.toString());
			}
			return new Board(newBoardLetters, numRows, numCols);
			
		}
		catch (Exception e){
			
		}
		finally{
			if (cubeScanner != null){
				cubeScanner.close();
			}
		}
		return null;

	}
	public static Board generateCubesFromFile(String filename){
		Scanner fileScanner = null;
		try {
			fileScanner = new Scanner(new BufferedReader(new FileReader(filename)));
			return generateCubesFromScanner(fileScanner, 0, 0);
		}
		catch (IOException e){
		}
		finally{
			if (fileScanner != null){
				fileScanner.close();
			}
		}
		return null;
	}
	public static Board generateCubesFromURL(URL fileURL, int row, int col){
		Scanner fileScanner = null;
		try {
			fileScanner = new Scanner(new BufferedReader(new InputStreamReader(fileURL.openStream())));
			return generateCubesFromScanner(fileScanner, row, col);
		}
		catch (IOException e){
		}
		finally {
				if (fileScanner != null){
					fileScanner.close();
				}
			}
		return null;
			
	}
	public static Board generateCubesFromURL(URL fileURL){
		return generateCubesFromURL(fileURL, 0, 0);
	}
	
}
