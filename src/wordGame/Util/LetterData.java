/**
 * 
 */
package wordGame.Util;

/**
 * @author Harrison
 *
 */
public class LetterData {
	private String mCharacters;
	
	public LetterData(String characters){
		mCharacters = characters.toLowerCase();
	}
	public LetterData(char character){
		mCharacters = Character.toString(character).toLowerCase();
		
		
	}
	
	public String toString(){
		return mCharacters;
	}
	public boolean equals(LetterData compareTo){
		return this.toString().equals(compareTo.toString());
	}
	/**
	 * Converts an input string into an array of LetterData objects
	 * @param string
	 * @return
	 */
	public static LetterData[] convertString(String string){
		int size = string.length();
		LetterData[] letterArray = new LetterData[size];
		for (int i = 0; i < size; i++){
			letterArray[i] = new LetterData(string.charAt(i));
		}
		return letterArray;
	}
}
