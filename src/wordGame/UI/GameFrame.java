/**
 * 
 */
package wordGame.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

import wordGame.Util.Board;
import wordGame.Util.Node;

/**
 * @author Harrison
 *
 */
public class GameFrame extends JPanel implements MouseListener, ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3607785848538407285L;
	private Board myBoard;
	private int width, height;
	private BoardPanel boardPanel;
	private WordInputField inputField;

	public GameFrame(Board board){
		super(new BorderLayout());
		myBoard = board;
		boardPanel = new BoardPanel(myBoard);
		inputField = new WordInputField(boardPanel);
		boardPanel.addMouseListener(this);
		this.add(inputField, BorderLayout.SOUTH);
		this.add(boardPanel, BorderLayout.CENTER);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
