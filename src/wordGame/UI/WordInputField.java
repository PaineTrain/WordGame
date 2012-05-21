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
package wordGame.UI;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import wordGame.Util.Board;
import wordGame.Util.LetterData;

public class WordInputField extends JTextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7938131798235312635L;
	private BoardPanel myBoardPanel;
	private boolean pathFound;
	
	public WordInputField(BoardPanel board){
		this.getDocument().addDocumentListener(new InputListener(this));
		myBoardPanel = board;
		
	}
	
	public class InputListener implements DocumentListener{
		
		private WordInputField field;
		public InputListener (WordInputField textField){
			field = textField;
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			findWord(e);
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			findWord(e);
			
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			findWord(e);
			
		}
		private void findWord(DocumentEvent e){
			try{
				// myBoard.clear();
				if (e.getDocument().getLength() > 0){
					String searchWord = e.getDocument().getText(0, e.getDocument().getLength());
					System.err.println(e.getDocument().getText(0,e.getDocument().getLength()));
					pathFound = myBoardPanel.findWord(searchWord);
				}
				// field.getParent().repaint();
				
			}
			catch (BadLocationException ex){
			
			}
		}
		
		
	}

}
