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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URI;
import java.net.URL;

import javax.swing.JApplet;

import com.google.gson.Gson;

import wordGame.Util.Board;
import wordGame.Util.BoardGenerator;

public class GameApplet extends JApplet implements MouseListener,
		ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 839717125670676782L;
	private int width = 800;
	private int height = 450;
	private Board myBoard;
	private GameFrame myPanel;
	private String currentWord;
	
	private Gson gson;
	

	public void init(){
		
		try {
			URL inputURL = new URL("file:/C:/Users/Harrison/Documents/JavaProjects/WordGame/res/Big.qbe");				
			URI inputURI = inputURL.toURI();
			myBoard = BoardGenerator.generateCubesFromURL(inputURL, 5, 5);
			javax.swing.SwingUtilities.invokeAndWait(new Runnable(){
				public void run(){
//					initializeBoard();
					createUI();
					
				}
			});
		}
		catch(Exception e) {
			System.err.println("Error in initializing applet! Exception type: " + e);
		}
				
	}
	public void start(){
		
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	private void createUI(){
		myPanel = new GameFrame(myBoard);
		myPanel.setOpaque(true);
		setContentPane(myPanel);
		
		
	}
	
	private void initializeBoard(){
		
		//myBoard = BoardGenerator.generateCubesFromFile("res/Big.qbe", 5, 5);
	}

}
