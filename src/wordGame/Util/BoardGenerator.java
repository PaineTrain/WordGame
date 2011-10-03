/**
 * 
 */
package wordGame.Util;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Harrison
 * Helper class to generate board instances from static .qbe files
 * See QBEspec.txt for information for formatting and behavioral specifics of .qbe files
 */
public class BoardGenerator {
	
	/**
	 * 
	 * @param filename
	 * @return
	 */
	
	public static LetterData[] generateCubesFromFile(String filename) throws IOException {
		Scanner cubeScanner = null;
		try{
			cubeScanner = new Scanner(new BufferedReader(new FileReader(filename)));
			String currentLine = null;
			ArrayList<LetterData> cubes = new ArrayList<LetterData>();
			Random rng = new Random();
			while (cubeScanner.hasNext()){
				if (currentLine.charAt(0) != '#' && !currentLine.contains(":")) {
					currentLine = cubeScanner.next();
					currentLine.toUpperCase();
					currentLine.trim();
					currentLine.replaceAll("\\s\\d:", "");
					cubes.add(new LetterData(currentLine.charAt(rng.nextInt(currentLine.length()))));
				}
			}
			LetterData[] cubeArray;
			cubes.toArray(cubeArray);
			return cubeArray;
			
			
		}
		finally{
			if (cubeScanner != null){
				cubeScanner.close();
				return null;
		}
	}

}
